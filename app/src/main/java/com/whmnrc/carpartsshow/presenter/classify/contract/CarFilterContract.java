package com.whmnrc.carpartsshow.presenter.classify.contract;

import com.whmnrc.carpartsshow.base.BasePresenter;
import com.whmnrc.carpartsshow.base.BaseView;
import com.whmnrc.carpartsshow.model.http.bean.CarFilterBean;

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
