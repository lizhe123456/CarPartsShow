package com.whmnrc.carpartsshow.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;

import com.whmnrc.carpartsshow.R;
import com.whmnrc.carpartsshow.app.App;
import com.whmnrc.carpartsshow.base.MvpActivity;
import com.whmnrc.carpartsshow.model.http.bean.LoginBean;
import com.whmnrc.carpartsshow.presenter.me.LoginPresenter;
import com.whmnrc.carpartsshow.presenter.me.contract.LoginContract;
import com.whmnrc.carpartsshow.util.SpUtil;
import com.whmnrc.carpartsshow.util.StatusBarUtil;
import com.whmnrc.carpartsshow.widgets.CPSToast;

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

    public static void start(Context context) {
        Intent starter = new Intent(context, LoginActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            StatusBarUtil.setStatusBarColor(this,R.color.white);
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN, WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
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
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        getWindow().getDecorView().setBackgroundColor(getResources().getColor(R.color.transparent));
        super.onCreate(savedInstanceState, persistentState);
    }

    @Override
    protected void init() {
        super.init();

    }

    @Override
    protected void setData() {
        if (SpUtil.getBoolean(this,"isRemember",false)) {
            pass = SpUtil.getString(this,"pass");
            mobile = SpUtil.getString(this,"username");
        }
        if (!TextUtils.isEmpty(pass) && !TextUtils.isEmpty(mobile)){
            etPhone.setText(mobile);
            etPhone.setSelection(etPhone.getText().length());
            etPassword.setText(pass);
            isRemember = true;
            selectState.setImageResource(R.drawable.round_btn_selected);
        }
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
                Intent intent = new Intent();
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                intent.setClass(this,FingerprintLoginActivity.class);
                startActivity(intent);
                this.finish();
                overridePendingTransition(0, 0);
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
            SpUtil.putBoolean(this,"isRemember",true);
        }
        SpUtil.putString(this,"username",mobile);
        SpUtil.putString(this,"pass",pass);
        SpUtil.putObject(this,"user",loginBean);
        Intent intent = new Intent();
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        intent.setClass(this, MainActivity.class);
        startActivity(intent);
        this.finish();
        overridePendingTransition(0, 0);
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            App.getInstance().exitApp();
            return false;
        }else {
            return super.onKeyDown(keyCode, event);
        }

    }

}
