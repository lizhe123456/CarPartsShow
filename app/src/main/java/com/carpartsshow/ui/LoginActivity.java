package com.carpartsshow.ui;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import com.carpartsshow.R;
import com.carpartsshow.app.App;
import com.carpartsshow.base.MvpActivity;
import com.carpartsshow.model.http.bean.LoginBean;
import com.carpartsshow.presenter.me.LoginPresenter;
import com.carpartsshow.presenter.me.contract.LoginContract;
import com.carpartsshow.util.SpUtil;
import com.carpartsshow.util.StatusBarUtil;
import com.carpartsshow.widgets.CPSToast;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by lizhe on 2018/3/12.
 */

public class LoginActivity extends MvpActivity<LoginPresenter> implements LoginContract.View {


    @BindView(R.id.et_phone)
    EditText etPhone;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.select_state)
    ImageView selectState;
    //是否记住密码
    private boolean isRemember;
    //是否可见
    private boolean canSee;

    private String pass;
    private String mobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            StatusBarUtil.setStatusBarColor(this,R.color.white);
//        }
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_login;
    }


    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected void setData() {
        pass = SpUtil.getString(this,"pass");
        mobile = SpUtil.getString(this,"username");
        if (!TextUtils.isEmpty(pass) && !TextUtils.isEmpty(mobile)){
            etPhone.setText(mobile);
            etPhone.setSelection(etPhone.getText().length());
            etPassword.setText(pass);
            isRemember = true;
            selectState.setImageResource(R.drawable.round_btn_selected);
        }
//        mPresenter.passLogin("17688943972","123456");
    }

    @OnClick({R.id.iv_exit, R.id.select_state, R.id.text_password, R.id.text_password2, R.id.switch_login_mode,R.id.tv_login,R.id.iv_visual})
    public void onViewClicked(View view) {

        switch (view.getId()) {
            case R.id.iv_exit:
                App.getInstance().exitApp();
                break;
            case R.id.select_state:
                //select_state
                if (!isRemember){
                    selectState.setImageResource(R.drawable.round_btn_selected);
                    isRemember = true;
                }else {
                    selectState.setImageResource(R.drawable.round_btn_normal);
                    isRemember = false;
                }
                break;
            case R.id.text_password:
                //记住密码
                if (!isRemember){
                    selectState.setImageResource(R.drawable.round_btn_selected);
                    isRemember = true;
                }else {
                    selectState.setImageResource(R.drawable.round_btn_normal);
                    isRemember = false;
                }
                break;
            case R.id.text_password2:
                //跳转忘记密码
                Intent intent1 = new Intent();
                intent1.setClass(this,ForgetPassActivity.class);
                startActivity(intent1);
                break;
            case R.id.switch_login_mode:
                this.finish();
                Intent intent = new Intent();
                intent.setClass(this,FingerprintLoginActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_login:
                pass = etPassword.getText().toString().trim();
                mobile = etPhone.getText().toString().trim();
                if (TextUtils.isEmpty(mobile)){
                    CPSToast.showText(this,"请输入手机号");
                    return;
                }
                if (TextUtils.isEmpty(pass)){
                    CPSToast.showText(this,"请输入密码");
                    return;
                }
                mPresenter.passLogin(mobile,pass);
                break;
            case R.id.iv_visual:
                if (canSee==false){
                    //如果是不能看到密码的情况下，
                    etPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    canSee=true;
                }else {
                    //如果是能看到密码的状态下
                    etPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    canSee=false;
                }
                etPassword.setSelection(etPassword.getText().length());
                break;
        }
    }

    @Override
    public void stateError() {

    }

    @Override
    public void loginState(LoginBean loginBean) {
        if(isRemember){
            SpUtil.putString(this,"username",mobile);
            SpUtil.putString(this,"pass",pass);
        }
        SpUtil.putObject(this,"user",loginBean);
        this.finish();
        Intent intent = new Intent();
        intent.setClass(this, MainActivity.class);
        startActivity(intent);
    }

}
