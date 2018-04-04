package com.carpartsshow.ui.scancode.activity;

import android.Manifest;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ImageFormat;
import android.graphics.Matrix;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.hardware.Camera;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.annotation.StringRes;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.DialogFragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
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
import android.widget.Toast;
import com.carpartsshow.R;
import com.carpartsshow.base.BaseActivity;
import com.carpartsshow.util.ScreenUtils;
import com.google.android.cameraview.AspectRatio;
import com.google.android.cameraview.CameraView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * Created by lizhe on 2018/4/3.
 */

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class ScanCodeActivity extends BaseActivity implements Camera.PreviewCallback,SurfaceHolder.Callback{


    @BindView(R.id.iv_scan_xian)
    ImageView ivScanXian;
    @BindView(R.id.iv_distinguish)
    ImageView ivDistinguish;
    @BindView(R.id.camera)
    SurfaceView surfaceView;

    private int pmHeight;
    private int pmWidth;
    private int mPreviewHeight;
    private int mPreviewWidth;
    // 定义对象
    private SurfaceHolder mSurfaceHolder = null;  // SurfaceHolder对象：(抽象接口)SurfaceView支持类
    private Camera mCamera =null; // Camera对象，相机预览
    private boolean bIfPreview;

    public static void start(Context context) {
        Intent starter = new Intent(context, ScanCodeActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_scancode;
    }

    @Override
    protected void init() {

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //去除title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //去掉Activity上面的状态栏
        getWindow().setFlags(WindowManager.LayoutParams. FLAG_FULLSCREEN ,
                WindowManager.LayoutParams. FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void setData() {
        pmHeight = ScreenUtils.getScreenHeight(this);
        pmWidth = ScreenUtils.getScreenWidth(this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(15, (int) (pmHeight / (float) 1.4));
        layoutParams.topMargin = (int) (pmHeight / (float) 7.5);
        layoutParams.bottomMargin = (int) (pmHeight / (float) 5.6);
        ivScanXian.setLayoutParams(layoutParams);
//        ObjectAnimator animator = ObjectAnimator.ofFloat(ivScanXian,)
        TranslateAnimation translateAnimation = new TranslateAnimation((float) pmWidth * ((float) 2 / 3), (float) pmWidth * ((float) 1 / 3), ivScanXian.getY(), ivScanXian.getY());
        translateAnimation.setDuration(1000);
        translateAnimation.setRepeatMode(Animation.REVERSE);
        translateAnimation.setRepeatCount(Animation.INFINITE);
        ivScanXian.setAnimation(translateAnimation);
        ivScanXian.setVisibility(View.VISIBLE);
//        cameraView.captureImage();
        initSurfaceView();

    }

    private void initSurfaceView() {
        mSurfaceHolder = surfaceView.getHolder(); // 绑定SurfaceView，取得SurfaceHolder对象
        mSurfaceHolder.addCallback(this); // SurfaceHolder加入回调接口
        // mSurfaceHolder.setFixedSize(176, 144); // 预览大小設置
        mSurfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);// 設置顯示器類型，setType必须设置
    }

    private void initCamera(){//surfaceChanged中调用
           if (bIfPreview) {
                mCamera.stopPreview();//stopCamera();
           }
           if(null != mCamera) {
                try {
                    mCamera.setPreviewCallback(this);
                     /* Camera Service settings*/
                     Camera.Parameters parameters = mCamera.getParameters();
                     // parameters.setFlashMode("off"); // 无闪光灯
                     parameters.setPictureFormat(PixelFormat.JPEG); //Sets the image format for picture 设定相片格式为JPEG，默认为NV21
                     parameters.setPreviewFormat(PixelFormat.YCbCr_420_SP); //Sets the image format for preview picture，默认为NV21
                     /*【ImageFormat】JPEG/NV16(YCrCb format，used for Video)/NV21(YCrCb format，used for Image)/RGB_565/YUY2/YU12*/

                     // 【调试】获取caera支持的PictrueSize，看看能否设置？？
                     List<Camera.Size> pictureSizes = mCamera.getParameters().getSupportedPictureSizes();
                     List<Camera.Size> previewSizes = mCamera.getParameters().getSupportedPreviewSizes();
                     List<Integer> previewFormats = mCamera.getParameters().getSupportedPreviewFormats();
                     List<Integer> previewFrameRates = mCamera.getParameters().getSupportedPreviewFrameRates();
                     Log.i(TAG+"initCamera", "cyy support parameters is ");
                     Camera.Size psize = null;
                     for (int i = 0; i < pictureSizes.size(); i++)
                         {
                          psize = pictureSizes.get(i);
                          Log.i(TAG+"initCamera", "PictrueSize,width: " + psize.width + " height" + psize.height);
                         }
                     for (int i = 0; i < previewSizes.size(); i++)
                         {
                          psize = previewSizes.get(i);
                          Log.i(TAG+"initCamera", "PreviewSize,width: " + psize.width + " height" + psize.height);
                         }
                     Integer pf = null;
                     for (int i = 0; i < previewFormats.size(); i++)
                         {
                          pf = previewFormats.get(i);
                          Log.i(TAG+"initCamera", "previewformates:" + pf);
                         }

                     // 设置拍照和预览图片大小
                     parameters.setPictureSize(640, 480); //指定拍照图片的大小
                     parameters.setPreviewSize(mPreviewWidth, mPreviewHeight);
                     // 指定preview的大小
                     //这两个属性 如果这两个属性设置的和真实手机的不一样时，就会报错

                     // 横竖屏镜头自动调整
                     if (this.getResources().getConfiguration().orientation != Configuration.ORIENTATION_LANDSCAPE) {
                          parameters.set("orientation", "portrait"); //
                          parameters.set("rotation", 90); // 镜头角度转90度（默认摄像头是横拍）
                          mCamera.setDisplayOrientation(90); // 在2.2以上可以使用
                         } else// 如果是横屏
                     {
                          parameters.set("orientation", "landscape"); //
                          mCamera.setDisplayOrientation(0); // 在2.2以上可以使用
                         }

                     /* 视频流编码处理 */
                     //添加对视频流处理函数

                    // 设定配置参数并开启预览
                     mCamera.setParameters(parameters); // 将Camera.Parameters设定予Camera
                     mCamera.startPreview(); // 打开预览画面
                     bIfPreview = true;

                     // 【调试】设置后的图片大小和预览大小以及帧率
                     Camera.Size csize = mCamera.getParameters().getPreviewSize();
                     mPreviewHeight = csize.height; //
                     mPreviewWidth = csize.width;
                     Log.i(TAG+"initCamera", "after setting, previewSize:width: " + csize.width + " height: " + csize.height);
                     csize = mCamera.getParameters().getPictureSize();
                     Log.i(TAG+"initCamera", "after setting, pictruesize:width: " + csize.width + " height: " + csize.height);
                     Log.i(TAG+"initCamera", "after setting, previewformate is " + mCamera.getParameters().getPreviewFormat());
                     Log.i(TAG+"initCamera", "after setting, previewframetate is " + mCamera.getParameters().getPreviewFrameRate());
                    } catch (Exception e) {
                     e.printStackTrace();
                    }
               }
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
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onPreviewFrame(byte[] data, Camera camera) {
        Camera.Size size = camera.getParameters().getPreviewSize();
        try{
            YuvImage image = new YuvImage(data, ImageFormat.NV21, size.width, size.height, null);
            if(image!=null){
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                image.compressToJpeg(new Rect(0, 0, size.width, size.height), 80, stream);

                Bitmap bmp = BitmapFactory.decodeByteArray(stream.toByteArray(), 0, stream.size());
                rotateMyBitmap(bmp);
                ivDistinguish.setImageBitmap(bmp);
                if (bmp != null){
                    bmp.recycle();
                    bmp = null;
                }
                System.gc();
                //**********************
                //因为图片会放生旋转，因此要对图片进行旋转到和手机在一个方向上

                //**********************************
                stream.close();
            }

        }catch(Exception ex){
            Log.e("Sys","Error:"+ex.getMessage());
        }
    }


    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        mCamera = Camera.open();// 开启摄像头（2.3版本后支持多摄像头,需传入参数）
        try {
            Log.i(TAG, "SurfaceHolder.Callback：surface Created");
            mCamera.setPreviewDisplay(mSurfaceHolder);//set the surface to be used for live preview

        } catch (Exception ex) {
            if(null != mCamera)
            {
                mCamera.release();
                mCamera = null;
            }
            Log.i(TAG+"initCamera", ex.getMessage());
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        Log.i(TAG, "SurfaceHolder.Callback：Surface Changed");
        //mPreviewHeight = height;
        //mPreviewWidth = width;
        initCamera();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        Log.i(TAG, "SurfaceHolder.Callback：Surface Destroyed");
        if(null != mCamera)
        {
            mCamera.setPreviewCallback(null); //！！这个必须在前，不然退出出错
            mCamera.stopPreview();
//            bIfPreview = false;
            mCamera.release();
            mCamera = null;
        }
    }


    public Bitmap rotateMyBitmap(Bitmap bmp){
        //*****旋转一下
        Matrix matrix = new Matrix();
        matrix.postRotate(90);
        Bitmap bitmap = Bitmap.createBitmap(bmp.getWidth(), bmp.getHeight(), Bitmap.Config.ARGB_8888);
        Bitmap nbmp2 = Bitmap.createBitmap(bmp, 0,0, bmp.getWidth(),  bmp.getHeight(), matrix, true);
        //*******显示一下
        return nbmp2;
    }

}
