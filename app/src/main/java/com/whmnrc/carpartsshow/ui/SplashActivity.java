package com.whmnrc.carpartsshow.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.whmnrc.carpartsshow.R;
import com.whmnrc.carpartsshow.util.SpUtil;

/**
 * Created by lizhe on 2018/4/11.
 * 启动页
 */

public class SplashActivity extends AppCompatActivity {


    private Handler mHandler;
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            Intent intent = new Intent();
            intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            if (SpUtil.getObject(SplashActivity.this,"user") != null) {
                intent.setClass(SplashActivity.this, MainActivity.class);
            }else {
                intent.setClass(SplashActivity.this, LoginActivity.class);
            }
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN, WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
            startActivity(intent);
            SplashActivity.this.finish();
            overridePendingTransition(0, 0);
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mHandler = new Handler();
        mHandler.postDelayed(runnable,2000);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mHandler.removeCallbacks(runnable);
    }
}
