package com.carpartsshow.presenter.me.contract;

import com.carpartsshow.base.BasePresenter;
import com.carpartsshow.base.BaseView;
import com.carpartsshow.model.http.bean.LoginBean;

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
