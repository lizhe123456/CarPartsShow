package com.whmnrc.carpartsshow.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.whmnrc.carpartsshow.R;
import com.whmnrc.carpartsshow.app.Constants;
import com.whmnrc.carpartsshow.base.MvpActivity;
import com.whmnrc.carpartsshow.model.http.bean.CarModelByVINBean;
import com.whmnrc.carpartsshow.model.http.bean.HomePageBean;
import com.whmnrc.carpartsshow.model.http.bean.LoginBean;
import com.whmnrc.carpartsshow.presenter.home.HomePagePresenter;
import com.whmnrc.carpartsshow.presenter.home.contract.HomePageContract;
import com.whmnrc.carpartsshow.util.SpUtil;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import okhttp3.Cache;

/**
 * Created by lizhe on 2018/4/11.
 * 启动页
 */

public class SplashActivity extends MvpActivity<HomePagePresenter> implements HomePageContract.View {


    private Handler mHandler;
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            Intent intent = new Intent();
            intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            if (SpUtil.getObject(SplashActivity.this,"user") != null) {
                intent.setClass(SplashActivity.this, MainActivity.class);
            }else {
                intent.setClass(SplashActivity.this, LoginActivity.class);
            }
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN, WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
            startActivity(intent);
            SplashActivity.this.finish();
            overridePendingTransition(0, 0);
        }
    };

    @Override
    protected int setLayout() {
        return R.layout.activity_splash;
    }

    @Override
    protected void setData() {
        LoginBean loginBean = SpUtil.getObject(SplashActivity.this,"user");
        if (loginBean != null) {
            mPresenter.getHomePage(loginBean.getRepairUser_ID(),1);
        }
        mHandler = new Handler();
        mHandler.postDelayed(runnable,2000);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mHandler.removeCallbacks(runnable);
    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    public void stateError() {

    }

    @Override
    public void showContent(HomePageBean homePageBean) {
        Constants.homePageBean  = homePageBean;
    }

    @Override
    public void loadMore(HomePageBean homePageBean) {

    }

    @Override
    public void showVinData(List<CarModelByVINBean> carModelByVINBean) {

    }

    @Override
    public void showErrorMsg(String msg) {

    }
}
