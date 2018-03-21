package com.carpartsshow.ui;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.carpartsshow.R;
import com.carpartsshow.app.App;
import com.carpartsshow.base.BaseActivity;
import com.carpartsshow.util.StatusBarUtil;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by lizhe on 2018/3/12.
 * 指纹登录页面
 */

public class FingerprintLoginActivity extends BaseActivity {

    @BindView(R.id.register)
    TextView register;
    @BindView(R.id.login_title)
    TextView loginTitle;
    @BindView(R.id.iv_exit)
    ImageView ivExit;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.iv_logo)
    ImageView ivLogo;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.iv_fingerprint)
    ImageView ivFingerprint;
    @BindView(R.id.tv_fingerprint)
    TextView tvFingerprint;
    @BindView(R.id.switch_login_mode)
    TextView switchLoginMode;
    @BindView(R.id.switch_user)
    TextView switchUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            StatusBarUtil.setStatusBarColor(this,R.color.white);
//        }
        super.onCreate(savedInstanceState);

    }

    @Override
    protected int setLayout() {
        return R.layout.fingerprint_login_activity;
    }

    @Override
    protected void init() {

    }

    @Override
    protected void setData() {

    }

    @OnClick({R.id.register, R.id.iv_exit, R.id.iv_fingerprint, R.id.switch_login_mode, R.id.switch_user})
    public void onViewClicked(View view) {

        switch (view.getId()) {
            case R.id.register:
                break;
            case R.id.iv_exit:
                App.getInstance().exitApp();
                break;
            case R.id.iv_fingerprint:
                Intent intent1 = new Intent();
                intent1.setClass(this,MainActivity.class);
                startActivity(intent1);
                break;
            case R.id.switch_login_mode:
                this.finish();
                break;
            case R.id.switch_user:
                break;
        }
    }
}
