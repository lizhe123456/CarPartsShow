package com.carpartsshow.ui.me.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.carpartsshow.R;
import com.carpartsshow.base.BaseActivity;

/**
 * Created by lizhe on 2018/3/31.
 */

public class OrderDetailsActivity extends BaseActivity {


    public static void start(Context context) {
        Intent starter = new Intent(context, OrderDetailsActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_order_details;
    }

    @Override
    protected void init() {

    }

    @Override
    protected void setData() {

    }
}
