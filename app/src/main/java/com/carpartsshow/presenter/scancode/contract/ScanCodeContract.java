package com.carpartsshow.presenter.scancode.contract;

import com.carpartsshow.base.BasePresenter;
import com.carpartsshow.base.BaseView;
import com.carpartsshow.model.http.bean.CarModelByVINBean;

import java.util.List;

/**
 * Created by lizhe on 2018/4/8.
 */

public interface ScanCodeContract {

    interface View extends BaseView{
        void showData(List<CarModelByVINBean> list);
    }

    interface Presenter extends BasePresenter<View>{
        void getVinCode(String vid);
    }

}
