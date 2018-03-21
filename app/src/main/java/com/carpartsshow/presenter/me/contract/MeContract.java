package com.carpartsshow.presenter.me.contract;

import com.carpartsshow.base.BasePresenter;
import com.carpartsshow.base.BaseView;
import com.carpartsshow.model.http.bean.UserInfoBean;

/**
 * Created by lizhe on 2018/3/14.
 */

public interface MeContract {

    interface View extends BaseView{
        void showUserInfo(UserInfoBean userInfoBean);

    }

    interface Presenter extends BasePresenter<View>{
        void getUserInfo(String userId);

        void exitLogin();

    }
}
