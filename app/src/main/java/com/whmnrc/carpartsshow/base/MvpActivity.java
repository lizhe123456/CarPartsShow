package com.whmnrc.carpartsshow.base;

import android.view.ViewStub;

import com.whmnrc.carpartsshow.app.App;
import com.whmnrc.carpartsshow.di.component.ActivityComponent;

import com.whmnrc.carpartsshow.di.component.DaggerActivityComponent;
import com.whmnrc.carpartsshow.di.module.ActivityModule;
import com.whmnrc.carpartsshow.view.LoadingDialog;
import com.whmnrc.carpartsshow.widgets.CPSToast;
import javax.inject.Inject;

/**
 * Created by Administrator on 2017/8/19 0019.
 */

public abstract class MvpActivity<T extends BasePresenter> extends BaseActivity implements BaseView{

    @Inject
    protected T mPresenter;

    protected LoadingDialog loadingDialog;

    protected ViewStub vsEmpty;

    protected ActivityComponent getActivityComponent(){
        return DaggerActivityComponent.builder()
                .appComponent(App.getInstance().getAppComponent())
                .activityModule(new ActivityModule(this))
                .build();
    }

    protected void initLoading(){
        loadingDialog = new LoadingDialog(this);
    }

    @Override
    protected void init() {
        initInject();
        if (mPresenter != null){
            mPresenter.attachView(this);
        }
        initLoading();
    }

    @Override
    protected void onDestroy() {
        if (mPresenter != null){
            mPresenter.datachView();
        }
        super.onDestroy();
    }


    protected abstract void initInject();

    @Override
    public void loading(String msg) {
        loadingDialog.setMessage(msg);
        loadingDialog.show();
    }

    @Override
    public void unLoading() {
        if (loadingDialog.isShowing()) {
            loadingDialog.cancel();
        }
    }

    @Override
    public void showEmpty() {
    }


    @Override
    public void showErrorMsg(String msg) {
        CPSToast.showText(mActivity,msg);
    }

    protected int getMaxElem(int[] arr) {
        int size = arr.length;
        int maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            if (arr[i]>maxVal)
                maxVal = arr[i];
        }
        return maxVal;
    }

}
