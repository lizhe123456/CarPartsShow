package com.carpartsshow.ui;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import com.carpartsshow.R;
import com.carpartsshow.base.MvpActivity;
import com.carpartsshow.presenter.me.NewPassPresenter;
import com.carpartsshow.presenter.me.contract.NewPassContract;
import com.carpartsshow.util.StatusBarUtil;
import com.carpartsshow.widgets.CPSToast;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by lizhe on 2018/3/14.
 */

public class NewPassActivity extends MvpActivity<NewPassPresenter> implements NewPassContract.View {

    @BindView(R.id.et_new_password)
    EditText etNewPassword;
    @BindView(R.id.et_password)
    EditText etPassword;

    //是否可见
    private boolean canSee;
    private String mobile;
    private String code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            StatusBarUtil.setStatusBarColor(this, R.color.white);
        }
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_new_pass;
    }


    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected void setData() {
        mobile = getIntent().getStringExtra("mobile");
        code = getIntent().getStringExtra("code");
    }


    @OnClick({R.id.iv_visual, R.id.tv_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_visual:
                if (canSee==false){
                    //如果是不能看到密码的情况下，
                    etNewPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    canSee=true;
                }else {
                    //如果是能看到密码的状态下
                    etNewPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    canSee=false;
                }
                etNewPassword.setSelection(etNewPassword.getText().length());
                break;
            case R.id.tv_login:
                String pass = etNewPassword.getText().toString().trim();
                String pass2 = etPassword.getText().toString().trim();
                if (TextUtils.isEmpty(pass2) || TextUtils.isEmpty(pass)){
                    CPSToast.showText(this,"请输入密码");
                    return;
                }
                if (!pass.equals(pass2)){
                    CPSToast.showText(this, "两次输入不一致");
                    return;
                }
                if (TextUtils.isEmpty(mobile)){
                    mobile = "";
                    return;
                }
                if (TextUtils.isEmpty(code)){
                    code = "";
                    return;
                }
                mPresenter.submitFindPwd(mobile,code,pass);
                break;
        }
    }

    @Override
    public void stateError() {

    }

    @Override
    public void state() {

    }
}
