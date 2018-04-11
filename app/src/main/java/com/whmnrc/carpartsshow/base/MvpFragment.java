package com.whmnrc.carpartsshow.base;


import android.view.ViewStub;

import com.whmnrc.carpartsshow.app.App;
import com.whmnrc.carpartsshow.di.component.DaggerFragmentComponent;
import com.whmnrc.carpartsshow.di.component.FragmentComponent;
import com.whmnrc.carpartsshow.di.module.FragmentModule;
import com.whmnrc.carpartsshow.widgets.CPSToast;

import javax.inject.Inject;

/**
 * author：lizhe
 * time： 2017-08-23
 * 不积跬步,无以至千里.不积小流,无以成江河
 * 类介绍：
 */

public abstract class MvpFragment<T extends BasePresenter> extends BaseFragment implements BaseView{

    @Inject
    protected T mPresenter;

    protected ViewStub vsEmpty;

    protected FragmentComponent getFragmentComponent(){
        return DaggerFragmentComponent.builder()
                .appComponent(App.getInstance().getAppComponent())
                .fragmentModule(new FragmentModule(this))
                .build();
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
    public void onDestroyView() {
        if (mPresenter != null){
            mPresenter.datachView();
        }
        //解除订阅
        super.onDestroyView();

    }

    protected abstract void initInject();

    @Override
    public void showEmpty() {
    }

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
    public void showErrorMsg(String msg) {
        CPSToast.showText(getActivity(),msg);
    }

}
