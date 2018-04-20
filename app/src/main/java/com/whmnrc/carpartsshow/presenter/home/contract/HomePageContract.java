package com.whmnrc.carpartsshow.presenter.home.contract;

import com.whmnrc.carpartsshow.base.BasePresenter;
import com.whmnrc.carpartsshow.base.BaseView;
import com.whmnrc.carpartsshow.model.http.bean.CarModelByVINBean;
import com.whmnrc.carpartsshow.model.http.bean.HomePageBean;

import java.util.List;

/**
 * Created by lizhe on 2018/3/20.
 */

public interface HomePageContract {

    interface View extends BaseView{

        void showContent(HomePageBean homePageBean);

        void loadMore(HomePageBean homePageBean);

        void showVinData(List<CarModelByVINBean> carModelByVINBean);
    }

    interface Presenter extends BasePresenter<View>{

        void getHomePage(String userId,int type);

        void searchVin(String vin);
    }


}
