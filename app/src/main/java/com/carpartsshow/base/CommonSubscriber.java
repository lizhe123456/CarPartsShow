package com.carpartsshow.base;

import android.text.TextUtils;

import com.carpartsshow.exception.ApiException;
import com.carpartsshow.exception.SysException;
import com.carpartsshow.util.LogUtil;

import io.reactivex.subscribers.ResourceSubscriber;
import retrofit2.HttpException;

/**
 * Created by lizhe on 2018/3/14.
 */

public abstract class CommonSubscriber<T> extends ResourceSubscriber<T> {
    private BaseView mView;
    private String mErrorMsg;
    private boolean isShowErrorState = true;

    protected CommonSubscriber(BaseView view){
        this.mView = view;
    }

    protected CommonSubscriber(BaseView view, String errorMsg){
        this.mView = view;
        this.mErrorMsg = errorMsg;
    }

    protected CommonSubscriber(BaseView view, boolean isShowErrorState){
        this.mView = view;
        this.isShowErrorState = isShowErrorState;
    }

    protected CommonSubscriber(BaseView view, String errorMsg, boolean isShowErrorState){
        this.mView = view;
        this.mErrorMsg = errorMsg;
        this.isShowErrorState = isShowErrorState;
    }

    @Override
    public void onNext(T t) {
        mView.unLoading();
    }

    @Override
    public void onComplete() {
        mView.unLoading();
    }

    @Override
    public void onError(Throwable e) {
        if (mView == null) {
            return;
        }
        mView.unLoading();
        if (mErrorMsg != null && !TextUtils.isEmpty(mErrorMsg)) {
            mView.showErrorMsg(mErrorMsg);
        } else if (e instanceof ApiException) {
            mView.showErrorMsg(e.toString());
        } else if (e instanceof HttpException) {
            mView.showErrorMsg("服务器异常，正在抢修中..");
        }else if (e instanceof SysException){
            mView.showErrorMsg(e.getMessage());
        } else {
            mView.showErrorMsg("未知错误");
            LogUtil.d(e.toString());
        }
        if (isShowErrorState) {
            mView.stateError();
        }
    }
}

