package com.carpartsshow.presenter.shopping.contract;

import com.carpartsshow.base.BasePresenter;
import com.carpartsshow.base.BaseView;

import java.util.Map;

/**
 * Created by lizhe on 2018/3/29.
 */

public interface SubmitOrderContract {

    interface View extends BaseView{
        void submitSuccess();
    }

    interface Presenter extends BasePresenter<View>{
        void submitOrder(Map<String, Object> map);
    }

}
