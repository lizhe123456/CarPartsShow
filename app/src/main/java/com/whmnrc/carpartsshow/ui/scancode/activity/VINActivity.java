package com.whmnrc.carpartsshow.ui.scancode.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.whmnrc.carpartsshow.R;
import com.whmnrc.carpartsshow.base.MvpActivity;
import com.whmnrc.carpartsshow.base.adapter.BaseAdapter;
import com.whmnrc.carpartsshow.model.http.bean.BaiduWord;
import com.whmnrc.carpartsshow.model.http.bean.CarModelByVINBean;
import com.whmnrc.carpartsshow.presenter.scancode.ScanCodePresenter;
import com.whmnrc.carpartsshow.presenter.scancode.contract.ScanCodeContract;
import com.whmnrc.carpartsshow.ui.MainActivity;
import com.whmnrc.carpartsshow.ui.home.activity.GoodsSearchActivity;
import com.whmnrc.carpartsshow.ui.scancode.RecognizeService;
import com.whmnrc.carpartsshow.ui.scancode.adapter.ScanCodeCarBrandAdapter;
import com.whmnrc.carpartsshow.util.FileUtil;
import com.whmnrc.carpartsshow.util.VINUtil;
import com.whmnrc.carpartsshow.view.ScanCodeDialog;
import com.whmnrc.carpartsshow.widgets.CPSToast;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
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

                PictureSelector.create(VINActivity.this)
                        .openCamera(PictureMimeType.ofImage())
                        .enableCrop(true)
                        .compress(true)
                        .rotateEnabled(false)
                        .withAspectRatio(5,2)
                        .forResult(PictureConfig.CHOOSE_REQUEST);
            }
        });
        tv_phone_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomDialog.dismiss();
                PictureSelector.create(VINActivity.this)
                        .openGallery(PictureMimeType.ofImage())
                        .maxSelectNum(1)
                        .minSelectNum(1)
                        .enableCrop(true)
                        .compress(true)
                        .rotateEnabled(false)
                        .withAspectRatio(5,2)
                        .forResult(PictureConfig.CHOOSE_REQUEST);
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


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null){
            if (requestCode == PictureConfig.CHOOSE_REQUEST) {
                final List<LocalMedia> mediaList = PictureSelector.obtainMultipleResult(data);
                loading("识别中..");
                flag = true;
                if (!mediaList.isEmpty()) {
                    new Thread(){
                        @Override
                        public void run() {
                            super.run();
                            if (flag) {
                                path = mediaList.get(0).getCompressPath();
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
                                                vin = wordsResultBean.getWords();
                                                if (VINUtil.checkVIN(vin)) {
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
                }else {
                    return;
                }
            }
        }
    }

}
