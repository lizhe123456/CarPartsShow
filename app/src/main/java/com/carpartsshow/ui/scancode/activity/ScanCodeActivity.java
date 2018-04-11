package com.carpartsshow.ui.scancode.activity;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.ImageFormat;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v13.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.ocr.sdk.OCR;
import com.baidu.ocr.sdk.OnResultListener;
import com.baidu.ocr.sdk.exception.OCRError;
import com.baidu.ocr.sdk.model.AccessToken;
import com.carpartsshow.R;
import com.carpartsshow.base.MvpActivity;
import com.carpartsshow.base.adapter.BaseAdapter;
import com.carpartsshow.model.http.bean.BaiduToken;
import com.carpartsshow.model.http.bean.BaiduWord;
import com.carpartsshow.model.http.bean.CarModelByVINBean;
import com.carpartsshow.presenter.scancode.ScanCodePresenter;
import com.carpartsshow.presenter.scancode.contract.ScanCodeContract;
import com.carpartsshow.ui.home.activity.GoodsSearchActivity;
import com.carpartsshow.ui.scancode.RecognizeService;
import com.carpartsshow.ui.scancode.adapter.ScanCodeCarBrandAdapter;
import com.carpartsshow.util.FileUtil;
import com.carpartsshow.util.ImageUtil;
import com.carpartsshow.util.ScreenUtils;
import com.carpartsshow.view.ScanCodeDialog;
import com.carpartsshow.widgets.BmpImageView;
import com.carpartsshow.widgets.CPSToast;
import com.google.gson.Gson;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.OnClick;


/**
 * Created by lizhe on 2018/4/3.
 */

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class ScanCodeActivity extends MvpActivity<ScanCodePresenter> implements ScanCodeContract.View,SurfaceHolder.Callback, Camera.PreviewCallback ,RecognizeService.ServiceListener{


    private static final int REQUEST_TAKE_PHOTO_PERMISSION = 3;
    @BindView(R.id.iv_scan_xian)
    ImageView ivScanXian;
    @BindView(R.id.iv_distinguish)
    BmpImageView ivDistinguish;
    @BindView(R.id.camera)
    SurfaceView surfaceView;

    private int pmHeight;
    private int pmWidth;
    private Camera camera;
    private Camera.Parameters parameters;
    private int num;
    private Camera.AutoFocusCallback mAutoFocusCallback;
    private BaiduToken token = null;
    private SurfaceHolder surfaceHolder;
    private Handler handler;
    BitmapThread bitmapThread;

    public static void start(Context context) {
        Intent starter = new Intent(context, ScanCodeActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_scancode;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //去除title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //去掉Activity上面的状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
    }
//    Runnable runnable = new Runnable() {
//        @Override
//        public void run() {
//            CPSToast.showText(ScanCodeActivity.this,"扫描超时，请重试");
//            ScanCodeActivity.this.finish();
//
//        }
//    };

    @Override
    protected void init() {
        super.init();
        surfaceHolder = surfaceView.getHolder();
        surfaceHolder.addCallback(this);
        surfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        mAutoFocusCallback = new Camera.AutoFocusCallback() {
            public void onAutoFocus(boolean success, Camera camera) {
                if (success) {
                    camera.cancelAutoFocus();// 只有加上了这一句，才会自动对焦
//                    doAutoFocus();
                }
            }
        };
        OCR.getInstance().initAccessToken(new OnResultListener<AccessToken>() {
            @Override
            public void onResult(AccessToken result) {
                // 调用成功，返回AccessToken对象
                String token = result.getAccessToken();
            }
            @Override
            public void onError(OCRError error) {
                // 调用失败，返回OCRError子类SDKError对象
            }
        }, getApplicationContext());
        handler = new Handler();
//        handler.postDelayed(runnable,30000);
        bitmapThread = new BitmapThread();
        bitmapThread.start();
    }


    @Override
    protected void setData() {
        pmHeight = ScreenUtils.getScreenHeight(this);
        pmWidth = ScreenUtils.getScreenWidth(this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(15, (int) (pmHeight / (float) 1.4));
        layoutParams.topMargin = (int) (pmHeight / (float) 7.5);
        layoutParams.bottomMargin = (int) (pmHeight / (float) 5.6);
        ivScanXian.setLayoutParams(layoutParams);
        TranslateAnimation translateAnimation = new TranslateAnimation((float) pmWidth * ((float) 2 / 3), (float) pmWidth * ((float) 1 / 3), ivScanXian.getY(), ivScanXian.getY());
        translateAnimation.setDuration(1000);
        translateAnimation.setRepeatMode(Animation.REVERSE);
        translateAnimation.setRepeatCount(Animation.INFINITE);
        ivScanXian.setAnimation(translateAnimation);
        ivScanXian.setVisibility(View.VISIBLE);
    }

    @OnClick({R.id.iv_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                this.finish();
                break;
        }
    }


    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (ContextCompat.checkSelfPermission(ScanCodeActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            //申请权限，REQUEST_TAKE_PHOTO_PERMISSION是自定义的常量
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CAMERA},
                    REQUEST_TAKE_PHOTO_PERMISSION);
        } else {
            //有权限，直接拍照
            openCamera(surfaceHolder); // 开启相机
        }
    }


    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        releaseCamera();
    }

    private void openCamera(SurfaceHolder surfaceHolder) {
        releaseCamera();

        try {
            camera = getCamera(Camera.CameraInfo.CAMERA_FACING_BACK); // 根据需求选择前/后置摄像头
        } catch (Exception e) {
            camera = null;
//            if (AppContext.isDebugMode) {
//                e.printStackTrace();
//            }
        }
        if (camera != null) {
            try {
                camera.setPreviewCallback(this);
                camera.setDisplayOrientation(90); // 此方法为官方提供的旋转显示部分的方法，并不会影响onPreviewFrame方法中的原始数据；
                if (parameters == null) {
                    parameters = camera.getParameters();
                }
                onFocus(new Point(pmWidth / 2, pmHeight / 2), mAutoFocusCallback);
                parameters.setPreviewFormat(ImageFormat.NV21); // 常用格式：NV21 / YV12
                parameters.setPreviewSize(1920, 1080); // 还可以设置很多相机的参数，但是建议先遍历当前相机是否支持该配置，不然可能会导致出错；
                camera.setParameters(parameters);
                camera.setPreviewDisplay(surfaceHolder);
                camera.startPreview();
                camera.cancelAutoFocus();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 手动聚焦
     *
     * @param point 触屏坐标
     */
    protected boolean onFocus(Point point, Camera.AutoFocusCallback callback) {
        if (camera == null) {
            return false;
        }

        //不支持设置自定义聚焦，则使用自动聚焦，返回
        if (Build.VERSION.SDK_INT >= 14) {

            if (parameters.getMaxNumFocusAreas() <= 0) {
                return focus(callback);
            }
            //定点对焦
            List<Camera.Area> areas = new ArrayList<Camera.Area>();
            int left = point.x - 300;
            int top = point.y - 300;
            int right = point.x + 300;
            int bottom = point.y + 300;
            left = left < -1000 ? -1000 : left;
            top = top < -1000 ? -1000 : top;
            right = right > 1000 ? 1000 : right;
            bottom = bottom > 1000 ? 1000 : bottom;
            areas.add(new Camera.Area(new Rect(left, top, right, bottom), 100));
            parameters.setFocusAreas(areas);
            try {
                //本人使用的小米手机在设置聚焦区域的时候经常会出异常，看日志发现是框架层的字符串转int的时候出错了，
                //目测是小米修改了框架层代码导致，在此try掉，对实际聚焦效果没影响
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }


        return focus(callback);
    }

    private boolean focus(Camera.AutoFocusCallback callback) {
        try {
            camera.autoFocus(callback);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


    @TargetApi(9)
    private Camera getCamera(int cameraType) {
        Camera camera = null;
        try {
            camera = Camera.open(cameraType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return camera; // returns null if camera is unavailable
    }

    private synchronized void releaseCamera() {
        if (camera != null) {
            try {
                camera.setPreviewCallback(null);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                camera.stopPreview();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                camera.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
            camera = null;
        }
    }

    @Override
    public void onPreviewFrame(byte[] bytes, Camera camera) {
        if (num == 60) {
            Bitmap bitmap = ImageUtil.runInPreviewFrame(bytes, camera);
            boolean flag = saveBitmapToSd(bitmap, FileUtil.getSaveFile(getApplicationContext()).getAbsolutePath());
//            RecognizeService.recGeneralBasic(FileUtil.getSaveFile(getApplicationContext()).getAbsolutePath(), this);
            if (bitmapThread != null) {
                bitmapThread.handler.sendEmptyMessage(0);
            }
            if (bitmap != null && !bitmap.isRecycled()) {
                bitmap.isRecycled();
                bitmap = null;
            }

        }
        num = num + 1;
        if (num == 61) {
            num = 0;
        }
    }



    class BitmapThread extends Thread {
        public Handler handler;

        @Override
        public void run() {
            super.run();
            Looper.prepare();
            handler = new Handler() {
                @Override
                public void handleMessage(Message msg) {
                    super.handleMessage(msg);
                    RecognizeService.recGeneralBasic(FileUtil.getSaveFile(getApplicationContext()).getAbsolutePath(), ScanCodeActivity.this);
                }
            };
            Looper.loop();//loop()会调用到handler的handleMessage(Message msg)方法，所以，写在下面；
        }
    }



    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_TAKE_PHOTO_PERMISSION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                //申请成功，可以拍照
                openCamera(surfaceHolder);
            } else {
                CPSToast.showText(this,"相机权限未开启");
            }
            return;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onDestroy() {
//        handler.removeCallbacks(runnable);
        super.onDestroy();
    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    public static boolean saveBitmapToSd(Bitmap bitmap, String filePath){
        FileOutputStream outputStream = null;
        try {
            File file = new File(filePath);
            if(file.exists() || file.isDirectory()){
                file.delete();
            }
            file.createNewFile();
            outputStream = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 0, outputStream);
        } catch (IOException e) {
            return false;
        } finally {
            if(outputStream != null){
                try {
                    outputStream.flush();
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }

    @Override
    public void onResult(String result) {
        try {
            BaiduWord beanResutl = new Gson().fromJson(result, BaiduWord.class);
            mPresenter.getVinCode(beanResutl.getWords_result().get(0).getWords());
            CPSToast.showText(this,beanResutl.getWords_result().get(0).getWords());
        }catch (Exception e){

        }
    }

    @Override
    public void stateError() {

    }

    @Override
    public void showErrorMsg(String msg) {
        super.showErrorMsg(msg);
    }

    @Override
    public void showData(final List<CarModelByVINBean> list) {
        releaseCamera();
        final ScanCodeDialog dialog = new ScanCodeDialog(ScanCodeActivity.this);
        ScanCodeCarBrandAdapter scanCodeCarBrandAdapter = new ScanCodeCarBrandAdapter(ScanCodeActivity.this);
        scanCodeCarBrandAdapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
            @Override
            public void onClick(View view, Object item, int position) {
                CarModelByVINBean carModelByVINBean = (CarModelByVINBean) item;
                Intent intent = new Intent(ScanCodeActivity.this,GoodsSearchActivity.class);
                intent.putExtra("NLevelID",carModelByVINBean.getNLevelID());
                intent.putExtra("carBrand",carModelByVINBean.getPP() +" " + carModelByVINBean.getCX() +"--排量 " + carModelByVINBean.getPL() + " " + carModelByVINBean.getNK());
                startActivity(intent);
                ScanCodeActivity.this.finish();
            }
        });
        dialog.show(scanCodeCarBrandAdapter,list);
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                openCamera(surfaceHolder);
            }
        });
    }


}
