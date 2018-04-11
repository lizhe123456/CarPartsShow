package com.whmnrc.carpartsshow.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.hardware.fingerprint.FingerprintManagerCompat;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.whmnrc.carpartsshow.R;
import com.whmnrc.carpartsshow.app.App;
import com.whmnrc.carpartsshow.base.MvpActivity;
import com.whmnrc.carpartsshow.model.http.bean.LoginBean;
import com.whmnrc.carpartsshow.presenter.me.LoginPresenter;
import com.whmnrc.carpartsshow.presenter.me.contract.LoginContract;
import com.whmnrc.carpartsshow.util.FingerprintUtil;
import com.whmnrc.carpartsshow.util.SpUtil;
import com.whmnrc.carpartsshow.util.StatusBarUtil;
import com.whmnrc.carpartsshow.widgets.CPSToast;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by lizhe on 2018/3/12.
 * 指纹登录页面
 */

public class FingerprintLoginActivity extends MvpActivity<LoginPresenter> implements LoginContract.View{

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

    private AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        StatusBarUtil.setStatusBarColor(this, R.color.white);
//        }
        super.onCreate(savedInstanceState);

    }

    @Override
    protected int setLayout() {
        return R.layout.fingerprint_login_activity;
    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected void setData() {

    }


    private int postion = 0;
    TextView tv1;
    TextView tv2;

    private void initView(View view) {
        postion = 0;
        tv1 = (TextView) view.findViewById(R.id.tv1);
        tv2 = (TextView) view.findViewById(R.id.tv2);
    }

    private void showDialog() {
        if (dialog == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View view = LayoutInflater.from(this).inflate(R.layout.layout_fingerprint, null);
            initView(view);
            builder.setView(view);
            builder.setCancelable(false);
            builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    FingerprintUtil.cancel();
                }
            });
            builder.setPositiveButton("验证其他方式", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            dialog = builder.create();
        }
        dialog.show();
    }

    private void hideDialog() {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
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
//                Intent intent1 = new Intent();
//                intent1.setClass(this, MainActivity.class);
//                startActivity(intent1);
                onFingerprintClick();
                break;
            case R.id.switch_login_mode:
                LoginActivity.start(this);
                break;
            case R.id.switch_user:
                break;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        onFingerprintClick();
    }

    public void onFingerprintClick() {
        FingerprintUtil.callFingerPrint(new FingerprintUtil.OnCallBackListenr() {
            @Override
            public void onSupportFailed() {
                CPSToast.showText(FingerprintLoginActivity.this, "当前设备不支持指纹",1000);
                LoginActivity.start(FingerprintLoginActivity.this);
            }

            @Override
            public void onInsecurity() {
                CPSToast.showText(FingerprintLoginActivity.this, "当前设备未处于安全保护中",1000);
            }

            @Override
            public void onEnrollFailed() {
                CPSToast.showText(FingerprintLoginActivity.this, "请到设置中设置指纹",1000);
            }

            @Override
            public void onAuthenticationStart() {
                showDialog();
                tv1.setText("您的指纹解锁");
                tv2.setText("通过指纹键验证已有手机指纹");
                dialog.getButton(DialogInterface.BUTTON_POSITIVE).setVisibility(View.GONE);
            }

            @Override
            public void onAuthenticationError(int errMsgId, CharSequence errString) {
                CPSToast.showText(FingerprintLoginActivity.this, errString.toString());
                hideDialog();
            }

            @Override
            public void onAuthenticationFailed() {
                tv1.setText("再试一次");
                tv2.setText("通过指纹键验证已有手机指纹");
                dialog.getButton(DialogInterface.BUTTON_POSITIVE).setVisibility(View.VISIBLE);
            }

            @Override
            public void onAuthenticationHelp(int helpMsgId, CharSequence helpString) {
                CPSToast.showText(FingerprintLoginActivity.this, helpString.toString());
            }

            @Override
            public void onAuthenticationSucceeded(FingerprintManagerCompat.AuthenticationResult result) {
                hideDialog();
                String username =  SpUtil.getString(FingerprintLoginActivity.this,"username");
                String pass = SpUtil.getString(FingerprintLoginActivity.this,"pass");
                if (TextUtils.isEmpty(username)){
                    CPSToast.showText(FingerprintLoginActivity.this,"请先首次登录");
                    LoginActivity.start(FingerprintLoginActivity.this);
                }else {
                    mPresenter.passLogin(username, pass);
                }
            }
        });
    }


    @Override
    public void stateError() {

    }

    @Override
    public void loginState(LoginBean loginBean) {
        SpUtil.putObject(this,"user",loginBean);
        Intent intent = new Intent();
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        intent.setClass(this, MainActivity.class);
        startActivity(intent);
        this.finish();
        overridePendingTransition(0, 0);
    }
}
