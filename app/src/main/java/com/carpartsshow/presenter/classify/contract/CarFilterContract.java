package com.carpartsshow.presenter.classify.contract;

import com.carpartsshow.base.BasePresenter;
import com.carpartsshow.base.BaseView;
import com.carpartsshow.model.http.bean.CarFilterBean;

/**
 * Created by lizhe on 2018/3/30.
 */

public interface CarFilterContract {

    interface View extends BaseView{
        void loadData(CarFilterBean carFilterBean);
    }

    interface Presenter extends BasePresenter<View>{
        void carFilter(String val);
    }

}
