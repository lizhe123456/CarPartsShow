package com.whmnrc.carpartsshow.ui.scancode.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by lizhe on 2018/4/10.
 */

public class ScanCodeService extends Service {

    private Handler mHandler;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        new Thread(){
            @Override
            public void run() {
                super.run();

            }
        }.start();
        return null;
    }
}
