package com.whmnrc.carpartsshow.presenter.me;

import com.whmnrc.carpartsshow.base.BasePresenterImpl;
import com.whmnrc.carpartsshow.base.CommonSubscriber;
import com.whmnrc.carpartsshow.model.DataManager;
import com.whmnrc.carpartsshow.model.http.bean.UserInfoBean;
import com.whmnrc.carpartsshow.model.http.response.CPSResponse;
import com.whmnrc.carpartsshow.presenter.me.contract.MeContract;
import com.whmnrc.carpartsshow.util.RxUtil;

import javax.inject.Inject;

/**
 * Created by lizhe on 2018/3/14.
 */

public class MePresenter extends BasePresenterImpl<MeContract.View> implements MeContract.Presenter {

    DataManager dataManager;
    private boolean isflag = true;
    @Inject
    public MePresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public void getUserInfo(String userId) {
        if (isflag) {
            mView.loading("加载中..");
            isflag = false;
        }
        addSubscribe(dataManager.fetchGetUserInfo(userId)
                .compose(RxUtil.<CPSResponse<UserInfoBean>>rxSchedulerHelper())
                .compose(RxUtil.<UserInfoBean>handle())
                .subscribeWith(new CommonSubscriber<UserInfoBean>(mView){
                    @Override
                    public void onNext(UserInfoBean userInfoBean) {
                        super.onNext(userInfoBean);
                        mView.showUserInfo(userInfoBean);
                    }
                })
        );
    }

    /**
     * 退出登录
     */
    @Override
    public void exitLogin() {

    }

}
