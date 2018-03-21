package com.carpartsshow.presenter.me.contract;

import com.carpartsshow.base.BasePresenter;
import com.carpartsshow.base.BaseView;

/**
 * Created by lizhe on 2018/3/14.
 */

public interface ForgetPassContract {

    interface View extends BaseView{
        void state();
    }

    interface Presenter extends BasePresenter<View>{
        void sendPhoneCode(String mobile);
    }
}
