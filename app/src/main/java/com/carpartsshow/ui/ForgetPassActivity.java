package com.carpartsshow.ui;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import com.carpartsshow.R;
import com.carpartsshow.base.MvpActivity;
import com.carpartsshow.presenter.me.ForgetPassPresenter;
import com.carpartsshow.presenter.me.contract.ForgetPassContract;
import com.carpartsshow.util.StatusBarUtil;
import com.carpartsshow.widgets.CPSToast;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by lizhe on 2018/3/14.
 */

public class ForgetPassActivity extends MvpActivity<ForgetPassPresenter> implements ForgetPassContract.View {


    @BindView(R.id.et_phone)
    EditText etPhone;
    @BindView(R.id.et_password)
    EditText etPassword;

    String mobile;
    String code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            StatusBarUtil.setStatusBarColor(this, R.color.white);
        }
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int setLayout() {
        return R.layout.activty_forget;
    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected void setData() {

    }

    @OnClick({R.id.tv_code, R.id.tv_login, R.id.tv_xyb})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_code:
                mobile = etPhone.getText().toString().trim();
                if (TextUtils.isEmpty(mobile)){
                    CPSToast.showText(this,"请输入手机号");
                    return;
                }
                mPresenter.sendPhoneCode(mobile);
                break;
            case R.id.tv_login:
                this.finish();
                break;
            case R.id.tv_xyb:
                code = etPassword.getText().toString().trim();
                mobile = etPhone.getText().toString().trim();
                if (TextUtils.isEmpty(mobile)){
                    CPSToast.showText(this,"请输入手机号");
                    return;
                }
                if (TextUtils.isEmpty(code)){
                    CPSToast.showText(this, "请输入验证码");
                    return;
                }
                Intent intent = new Intent(this,NewPassActivity.class);
                intent.putExtra("mobile",mobile);
                intent.putExtra("code",code);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void stateError() {

    }

    @Override
    public void state() {
        CPSToast.showText(this,"发送验证码成功。");
        etPhone.setEnabled(false);
    }
}
