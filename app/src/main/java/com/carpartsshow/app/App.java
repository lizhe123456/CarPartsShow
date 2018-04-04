package com.carpartsshow.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.util.Log;
import com.carpartsshow.di.component.AppComponent;
import com.carpartsshow.di.component.DaggerAppComponent;
import com.carpartsshow.di.module.AppModule;
import com.carpartsshow.di.module.HttpModule;
import com.tencent.smtt.sdk.QbSdk;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lizhe on 2018/3/12.
 */

public class App extends Application {

    private static App instance;

    private Set<Activity> allActivitySet = new HashSet<>();

    public AppComponent appComponent;
    private Context mContext;

    public synchronized static App getInstance() {
        if (instance == null){
            return new App();
        }
        return instance;
    }

    public Context getmContext() {
        return mContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //应用入口，不宜做过多操作
        instance = this;
        mContext = getApplicationContext();
//        if(Constants.IS_DEBUG){
//            AppExceptionHandler.getInstance().setCrashHanler(this);
//        }
        QbSdk.PreInitCallback cb = new QbSdk.PreInitCallback() {
            @Override
            public void onViewInitFinished(boolean arg0) {
                //x5內核初始化完成的回调，为true表示x5内核加载成功，否则表示x5内核加载失败，会自动切换到系统内核。
                Log.d("app", " onViewInitFinished is " + arg0);
            }
            @Override
            public void onCoreInitFinished() {
            }
        };
        //x5内核初始化接口
        QbSdk.initX5Environment(getApplicationContext(),  cb);


    }

    public void addActivity(Activity activity){
        allActivitySet.add(activity);
    }

    public void removeActivity(Activity activity){
        if (activity != null){
            allActivitySet.remove(activity);
        }
    }


    public void exitApp(){
        if (allActivitySet != null){
            synchronized (allActivitySet){
                for (Activity activity : allActivitySet){
                    activity.finish();
                }
            }
        }
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }

    public AppComponent getAppComponent() {
        if (appComponent == null){
            appComponent = DaggerAppComponent.builder()
                    .appModule(new AppModule(instance))
                    .httpModule(new HttpModule())
                    .build();
        }
        return appComponent;
    }
}
