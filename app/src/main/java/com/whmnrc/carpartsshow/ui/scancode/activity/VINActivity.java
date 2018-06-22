package com.whmnrc.carpartsshow.ui.scancode.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.google.gson.Gson;
import com.linchaolong.android.imagepicker.ImagePicker;
import com.linchaolong.android.imagepicker.cropper.CropImage;
import com.linchaolong.android.imagepicker.cropper.CropImageView;
import com.whmnrc.carpartsshow.R;
import com.whmnrc.carpartsshow.base.MvpActivity;
import com.whmnrc.carpartsshow.base.adapter.BaseAdapter;
import com.whmnrc.carpartsshow.model.http.bean.BaiduWord;
import com.whmnrc.carpartsshow.model.http.bean.CarModelByVINBean;
import com.whmnrc.carpartsshow.presenter.scancode.ScanCodePresenter;
import com.whmnrc.carpartsshow.presenter.scancode.contract.ScanCodeContract;
import com.whmnrc.carpartsshow.ui.home.activity.GoodsSearchActivity;
import com.whmnrc.carpartsshow.ui.scancode.AllCapTransformationMethod;
import com.whmnrc.carpartsshow.ui.scancode.RecognizeService;
import com.whmnrc.carpartsshow.ui.scancode.adapter.ScanCodeCarBrandAdapter;
import com.whmnrc.carpartsshow.util.FileUtil;
import com.whmnrc.carpartsshow.util.VINUtil;
import com.whmnrc.carpartsshow.view.ScanCodeDialog;
import com.whmnrc.carpartsshow.widgets.CPSToast;
import java.io.File;
import java.util.List;
import butterknife.BindView;
import butterknife.OnClick;
import static com.whmnrc.carpartsshow.ui.scancode.ImgPretreatment.converyToGrayImg;
import static com.whmnrc.carpartsshow.ui.scancode.activity.ScanCodeActivity.saveBitmapToSd;

/**
 * Created by lizhe on 2018/4/13.
 */

public class VINActivity extends MvpActivity<ScanCodePresenter> implements ScanCodeContract.View {

    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.et_search)
    EditText etSearch;
    private String path;
    private boolean flag;
    private ImagePicker mImagePicker = new ImagePicker();

    public static void start(Context context) {
        Intent starter = new Intent(context, VINActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_vin;
    }


    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected void setData() {
        title.setText("图片识别");
        mImagePicker.setTitle("图片裁剪");
        // 设置是否裁剪图片
//        mImagePicker.setCropImage(true);
        etSearch.setTransformationMethod(new AllCapTransformationMethod());

    }

    @Override
    public void stateError() {

    }

    @Override
    public void showData(final List<CarModelByVINBean> list) {
        final ScanCodeDialog dialog = new ScanCodeDialog(VINActivity.this);
        ScanCodeCarBrandAdapter scanCodeCarBrandAdapter = new ScanCodeCarBrandAdapter(VINActivity.this);
        scanCodeCarBrandAdapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
            @Override
            public void onClick(View view, Object item, int position) {
                CarModelByVINBean carModelByVINBean = (CarModelByVINBean) item;
                Intent intent = new Intent(VINActivity.this, GoodsSearchActivity.class);
                intent.putExtra("NLevelID", carModelByVINBean.getNLevelID());
                intent.putExtra("carBrand", carModelByVINBean.getPP() + " " + carModelByVINBean.getCX() + "--排量 " + carModelByVINBean.getPL() + " " + carModelByVINBean.getNK());
                startActivity(intent);
                VINActivity.this.finish();
            }
        });
        dialog.show(scanCodeCarBrandAdapter, list);
    }

    @OnClick({R.id.iv_back, R.id.ic_camera, R.id.tv_search})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                this.finish();
                break;
            case R.id.ic_camera:
                show();
                break;
            case R.id.tv_search:
                String vin = etSearch.getText().toString().trim();
                if (TextUtils.isEmpty(vin) || !VINUtil.checkVIN(vin)){
                    CPSToast.showText(this,"请输入17位VIN码");
                }else {
                    mPresenter.getVinCode(vin);
                }
                break;
        }
    }

    private void show() {
        final Dialog bottomDialog = new Dialog(this, R.style.BottomDialog);
        View contentView = LayoutInflater.from(this).inflate(R.layout.dialog_content_normal, null);
        TextView tv_cancel = contentView.findViewById(R.id.tv_cancel);
        TextView tv_phone_2 = contentView.findViewById(R.id.tv_phone_2);
        TextView tv_phone_3 = contentView.findViewById(R.id.tv_phone_3);
        TextView tv_phone_1 = contentView.findViewById(R.id.tv_phone_1);
        TextView tv_title = contentView.findViewById(R.id.tv_phone);
        tv_title.setText("扫描或选取VIN照片");
        tv_phone_1.setText("扫描");
        tv_phone_2.setText("拍照");
        tv_phone_3.setText("图片识别");
        tv_phone_3.setVisibility(View.VISIBLE);
        File file = new File(this.getFilesDir(), "pic.jpg");
        final Uri uri = Uri.fromFile(file);
        tv_phone_1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                bottomDialog.dismiss();
                ScanCodeActivity.start(VINActivity.this);
            }
        });
        tv_phone_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomDialog.dismiss();
                mImagePicker.startCamera(VINActivity.this, new ImagePicker.Callback() {
                    @Override
                    public void onPickImage(Uri imageUri) {

                    }

                    @Override
                    public void onCropImage(Uri imageUri) {
                        super.onCropImage(imageUri);
                        sendImg(imageUri);
                    }

                    @Override
                    public void cropConfig(CropImage.ActivityBuilder builder) {
                        builder
                                // 是否启动多点触摸
                                .setMultiTouchEnabled(false)
                                // 设置网格显示模式
                                .setGuidelines(CropImageView.Guidelines.ON)
                                // 圆形/矩形
                                .setCropShape(CropImageView.CropShape.RECTANGLE);
                        builder.getIntent(VINActivity.this);
                    }
                });
//                PictureSelector.create(VINActivity.this)
//                        .openCamera(PictureMimeType.ofImage())
//                        .enableCrop(true)
//                        .compress(true)
//                        .rotateEnabled(false)
//                        .withAspectRatio(5,2)
//                        .forResult(PictureConfig.CHOOSE_REQUEST);
            }
        });
        tv_phone_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomDialog.dismiss();
                mImagePicker.startGallery(VINActivity.this, new ImagePicker.Callback() {


                    @Override
                    public void onPickImage(Uri imageUri) {

                    }

                    @Override
                    public void onCropImage(Uri imageUri) {
                        super.onCropImage(imageUri);
                        sendImg(imageUri);
                    }

                    @Override
                    public void cropConfig(CropImage.ActivityBuilder builder) {
                        builder
                                // 是否启动多点触摸
                                .setMultiTouchEnabled(false)
                                // 设置网格显示模式
                                .setGuidelines(CropImageView.Guidelines.ON)
                                // 圆形/矩形
                                .setCropShape(CropImageView.CropShape.RECTANGLE);
                        builder.getIntent(VINActivity.this);
                    }
                });
//                PictureSelector.create(VINActivity.this)
//                        .openGallery(PictureMimeType.ofImage())
//                        .maxSelectNum(1)
//                        .minSelectNum(1)
//                        .enableCrop(true)
//                        .compress(true)
//                        .rotateEnabled(false)
//                        .withAspectRatio(5,2)
//                        .forResult(PictureConfig.CHOOSE_REQUEST);
            }
        });

        bottomDialog.setContentView(contentView);
        ViewGroup.LayoutParams layoutParams = contentView.getLayoutParams();
        layoutParams.width = getResources().getDisplayMetrics().widthPixels;
        contentView.setLayoutParams(layoutParams);
        bottomDialog.getWindow().setGravity(Gravity.BOTTOM);
        bottomDialog.getWindow().setWindowAnimations(R.style.BottomDialog_Animation);
        bottomDialog.show();
        tv_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomDialog.cancel();
            }
        });
    }

    private void sendImg(final Uri imageUri) {
        flag = true;
        loading("识别中..");
        new Thread(){
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void run() {
                super.run();
                if (flag) {
                    path = imageUri.getPath();
                    Bitmap bitmap = converyToGrayImg(BitmapFactory.decodeFile(path));
                    saveBitmapToSd(bitmap, FileUtil.getSaveFile(getApplicationContext()).getAbsolutePath());
                    if (bitmap != null && !bitmap.isRecycled()) {
                        bitmap.isRecycled();
                        bitmap = null;
                    }
                    RecognizeService.recGeneralBasic(FileUtil.getSaveFile(getApplicationContext()).getAbsolutePath(), new RecognizeService.ServiceListener() {
                        @Override
                        public void onResult(String result) {
                            try {
                                String vin = null;
                                BaiduWord beanResutl = new Gson().fromJson(result, BaiduWord.class);
                                for (BaiduWord.WordsResultBean wordsResultBean: beanResutl.getWords_result()) {
                                    if (VINUtil.checkVIN(wordsResultBean.getWords())) {
                                        vin = wordsResultBean.getWords();
                                        break;
                                    }
                                }
                                if (TextUtils.isEmpty(vin)){
                                    unLoading();
                                    CPSToast.showText(VINActivity.this, "VIN识别失败");
                                }else {
                                    unLoading();
                                    VINResultActivity.start(VINActivity.this, path, vin);
                                }

                            } catch (Exception e) {
                                CPSToast.showText(VINActivity.this, "VIN码识别失败");
                                unLoading();
                            }
                        }
                    });
                }
                flag = false;
            }
        }.start();

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                                     @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        mImagePicker.onRequestPermissionsResult(this, requestCode, permissions, grantResults);
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mImagePicker.onActivityResult(this, requestCode, resultCode, data);
    }

}
