package com.carpartsshow.presenter.me;

import com.carpartsshow.base.BasePresenterImpl;
import com.carpartsshow.base.CommonSubscriber;
import com.carpartsshow.model.DataManager;
import com.carpartsshow.model.http.bean.UserInfoBean;
import com.carpartsshow.model.http.response.CPSResponse;
import com.carpartsshow.presenter.me.contract.MeContract;
import com.carpartsshow.util.RxUtil;

import javax.inject.Inject;

/**
 * Created by lizhe on 2018/3/14.
 */

public class MePresenter extends BasePresenterImpl<MeContract.View> implements MeContract.Presenter {

    DataManager dataManager;

    @Inject
    public MePresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public void getUserInfo(String userId) {
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
