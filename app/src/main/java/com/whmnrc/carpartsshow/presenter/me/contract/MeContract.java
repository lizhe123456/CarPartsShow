package com.whmnrc.carpartsshow.presenter.me.contract;

import com.whmnrc.carpartsshow.base.BasePresenter;
import com.whmnrc.carpartsshow.base.BaseView;
import com.whmnrc.carpartsshow.model.http.bean.UserInfoBean;

/**
 * Created by lizhe on 2018/3/14.
 */

public interface MeContract {

    interface View extends BaseView{
        void showUserInfo(UserInfoBean userInfoBean);

    }

    interface Presenter extends BasePresenter<View> {
        void getUserInfo(String userId);

        void exitLogin();

    }
}
