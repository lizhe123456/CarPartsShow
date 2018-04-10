package com.carpartsshow.base;

import android.text.TextUtils;

import com.carpartsshow.app.App;
import com.carpartsshow.exception.ApiException;
import com.carpartsshow.exception.SysException;
import com.carpartsshow.util.DensityUtils;
import com.carpartsshow.util.LogUtil;
import com.carpartsshow.util.ScreenUtils;
import com.carpartsshow.util.SystemUtil;
import com.google.gson.JsonSyntaxException;

import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

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
            if (SystemUtil.isNetworkConnected(App.getInstance().getmContext())) {
                mView.showErrorMsg("服务器异常，正在抢修中..");
            }else {
                mView.showErrorMsg("网络已断开，请检查网络连接..");
            }
        }else if (e instanceof SysException){
            mView.showErrorMsg(e.getMessage());
        }else if (e instanceof JsonSyntaxException){

        }else if (e instanceof IllegalStateException){

        }else if (e instanceof SocketTimeoutException){
            mView.showErrorMsg("网络不给力，请重试..");
        }else if (e instanceof UnknownHostException){

        }else {
            mView.showErrorMsg("未知错误");
            LogUtil.d(e.toString());
        }
        if (isShowErrorState) {
            mView.stateError();
        }
    }
}

