package com.whmnrc.carpartsshow.presenter.me.contract;

import com.whmnrc.carpartsshow.base.BasePresenter;
import com.whmnrc.carpartsshow.base.BaseView;
import com.whmnrc.carpartsshow.model.http.bean.LoginBean;

/**
 * Created by lizhe on 2018/3/14.
 */

public interface LoginContract {

    interface View extends BaseView{
        void loginState(LoginBean loginBean);
    }

    interface Presenter extends BasePresenter<View>{

        void passLogin(String mobile,String pass);

    }
}
