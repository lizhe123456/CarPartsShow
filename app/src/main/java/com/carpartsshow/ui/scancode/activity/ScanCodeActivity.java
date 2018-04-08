package com.carpartsshow.ui.scancode.activity;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.ImageFormat;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v13.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
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
import com.baidu.ocr.sdk.model.AccessToken;
import com.baidu.ocr.sdk.model.GeneralBasicParams;
import com.carpartsshow.R;
import com.carpartsshow.base.BaseActivity;
import com.carpartsshow.model.http.bean.BaiduToken;
import com.carpartsshow.model.http.bean.BaiduWord;
import com.carpartsshow.ui.scancode.RecognizeService;
import com.carpartsshow.util.Base64Util;
import com.carpartsshow.util.FileUtil;
import com.carpartsshow.util.ImageUtil;
import com.carpartsshow.util.ScreenUtils;
import com.carpartsshow.widgets.BmpImageView;
import com.carpartsshow.widgets.CPSToast;
import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Call;
import okhttp3.Response;


/**
 * Created by lizhe on 2018/4/3.
 */

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class ScanCodeActivity extends BaseActivity implements SurfaceHolder.Callback, Camera.PreviewCallback {


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

    @Override
    protected void init() {
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
        if (ContextCompat.checkSelfPermission(ScanCodeActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            //申请权限，REQUEST_TAKE_PHOTO_PERMISSION是自定义的常量
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
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
            boolean flag = saveBitmapToSd(bitmap,FileUtil.getSaveFile(getApplicationContext()).getAbsolutePath());
            RecognizeService.recGeneral(FileUtil.getSaveFile(getApplicationContext()).getAbsolutePath(),
                    new RecognizeService.ServiceListener() {
                        @Override
                        public void onResult(String result) {
                            BaiduWord beanResutl = new Gson().fromJson(result, BaiduWord.class);
                            CPSToast.showText(ScanCodeActivity.this,"skjhad");
                        }
            });
//            if (token == null) {
//                getToken("",bytes);
//            }else {
//                 recGeneral(token.getAccess_token(),bytes);
//            }
        }
        num = num + 1;
        if (num == 61) {
            num = 0;
        }
    }

    public void recGeneral(final String token, final byte[] bytes) {
        new Thread(){
            @Override
            public void run() {
                super.run();
                Bitmap bitmap = ImageUtil.runInPreviewFrame(bytes, camera);
                final String base64 = Base64Util.encode(ImageUtil.bitmapToByte(bitmap));
                Map<String, String> map = new HashMap<>();
                if (bitmap != null && !bitmap.isRecycled()){
                    bitmap.recycle();
                    bitmap = null;
                    System.gc();
                }
                map.put("image", base64);
                map.put("language_type", "ENG");
                map.put("detect_direction", "true");
                OkHttpUtils.post().url("https://aip.baidubce.com/rest/2.0/ocr/v1/general_basic")
                        .addHeader("Content-Type", "application/x-www-form-urlencoded")
                        .addParams("access_token", token).params(map)
                        .build().connTimeOut(3000).readTimeOut(2000).writeTimeOut(1000)
                        .execute(new com.zhy.http.okhttp.callback.Callback() {
                            @Override
                            public Object parseNetworkResponse(Response response, int id) throws Exception {
                                return response.body().string();
                            }

                            @Override
                            public void onError(Call call, Exception e, int id) {
                                camera.stopPreview();
                                CPSToast.showText(ScanCodeActivity.this,e.toString());
                                finish();
                            }

                            @Override
                            public void onResponse(Object response, int id) {
                                String json = (String) response;
                                CPSToast.showText(ScanCodeActivity.this,"sad");
//                        e.onNext(json);
                            }
                        });

            }
        }.start();
    }

    public void getToken(final String token, final byte[] bytes) {
        Flowable.create(new FlowableOnSubscribe<BaiduToken>() {
            @Override
            public void subscribe(FlowableEmitter<BaiduToken> e) throws Exception {
                OkHttpUtils.post().url("https://aip.baidubce.com/oauth/2.0/token")
                        .addParams("grant_type", "client_credentials")
                        .addParams("client_id", "CSQymvF6xklk2zwlzroOOrog")
                        .addParams("client_secret", "mEUcnehPKgiFdWmNecE2CUBNrprfFakg")
                        .build().connTimeOut(3000).readTimeOut(2000).writeTimeOut(1000)
                        .execute(new com.zhy.http.okhttp.callback.Callback() {
                    @Override
                    public Object parseNetworkResponse(Response response, int id) throws Exception {
                        return new Gson().fromJson(response.body().string(), BaiduToken.class);
                    }

                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(Object response, int id) {
                        ScanCodeActivity.this.token = (BaiduToken) response;
                    }
                });
            }
        }, BackpressureStrategy.BUFFER).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<BaiduToken>() {

            @Override
            public void accept(BaiduToken baiduToken) throws Exception {
                recGeneral(baiduToken.getAccess_token(),bytes);
            }
        });
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
        super.onDestroy();
        OkHttpUtils.getInstance().execute(null,null);
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

}
