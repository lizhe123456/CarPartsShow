package com.carpartsshow.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.carpartsshow.util.LogUtil;
import com.carpartsshow.util.SystemUtil;
import com.carpartsshow.widgets.CPSToast;

/**
 * Created by lizhe on 2018/4/10.
 */

public class NetworkReceiver extends BroadcastReceiver {

    boolean flag = true;

    @Override
    public void onReceive(Context context, Intent intent) {
        if (SystemUtil.isNetworkConnected(context)){
        }else {
            if (flag) {
                CPSToast.showText(context, "网络已断开，无网络连接");
                flag = false;
            }
        }
    }


}
