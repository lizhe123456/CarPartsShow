package com.carpartsshow.ui.me.activity;

import android.os.Bundle;

import com.carpartsshow.R;
import com.carpartsshow.base.BaseActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lizhe on 2018/3/15.
 */

public class AboutUsActivity extends BaseActivity {

    @Override
    protected int setLayout() {
        return R.layout.activity_aboutus;
    }

    @Override
    protected void init() {

    }

    @Override
    protected void setData() {

    }


    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        this.finish();
    }
}
