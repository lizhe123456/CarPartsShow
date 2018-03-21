package com.carpartsshow.app;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Looper;
import android.widget.Toast;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lizhe on 2018/3/12.
 * 应用系统异常退出，处理类
 */

public class AppExceptionHandler implements Thread.UncaughtExceptionHandler {

    private Context mContext;

    private static AppExceptionHandler instance;

    public static AppExceptionHandler getInstance() {
        if (instance == null){
            //线程同步
            synchronized (AppExceptionHandler.class) {
                instance = new AppExceptionHandler();
            }
        }
        return instance;
    }

    private AppExceptionHandler(){}



    @Override
    public void uncaughtException(Thread thread, Throwable throwable) {

    }


    /**
     * 为我们的应用程序设置自定义Crash处理
     */
    public void setCrashHandler(Context context){
        mContext = context;
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    /**
     * 显示提示信息，需要在线程中显示Toast
     * @param context
     * @param msg
     */
    private void showToast(final Context context, final String msg){
        new Thread(new Runnable() {
            @Override
            public void run() {
                Looper.prepare();
                Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
                Looper.loop();
            }
        }).start();
    }

    /**
     * 获取一些简单的信息，软件版本，手机版本，型号等信息放在HashMap中
     * @param context
     * @return
     */
    private HashMap<String, String> obtainSimpleInfo(Context context){
        HashMap<String, String> map = new HashMap<>();
        PackageManager manager = context.getPackageManager();
        PackageInfo info = null;

        try {
            info = manager.getPackageInfo(context.getPackageName(),PackageManager.GET_ACTIVITIES);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        map.put("versionName", info.versionName);
        map.put("versionCode", ""+info.versionCode);

        map.put("MODEL",""+ Build.MODEL);
        map.put("SDK_INT",""+Build.VERSION.SDK_INT);
        map.put("PRODUCT",""+Build.PRODUCT);

        return map;
    }

    /**
     * 获取系统未捕捉的错误信息
     * @param t
     * @return
     */
    private String obtainExceptionInfo(Throwable t){
        StringWriter mStringWriter = new StringWriter();
        PrintWriter mPrintWriter = new PrintWriter(mStringWriter);
        t.printStackTrace(mPrintWriter);
        mPrintWriter.close();
        return mStringWriter.toString();
    }

    /**
     * 处理异常信息
     * @param ex
     */
    protected void handleException(Throwable ex){
        final StringBuffer sb = new StringBuffer();

        for (Map.Entry<String, String> entry : obtainSimpleInfo(mContext).entrySet()){
            String key = entry.getKey();
            String value = entry.getValue();
            sb.append(key).append(" = ").append(value).append("\n");

            sb.append(obtainExceptionInfo(ex));
//            FileUtil.writeLogCrashContent(sb.toString());
            showToast(mContext,String.format("%s\n%s", "很抱歉，程序遭遇异常，即将退出！", sb.toString()));
        }

    }

    /**
     * 为我们的应用程序设置自定义Crash处理
     */
    public void setCrashHanler(Context context){
        mContext = context;
        Thread.setDefaultUncaughtExceptionHandler(this);
    }
}
