package com.whmnrc.carpartsshow.presenter.home.contract;

import com.whmnrc.carpartsshow.base.BasePresenter;
import com.whmnrc.carpartsshow.base.BaseView;
import com.whmnrc.carpartsshow.model.http.bean.HomePageBean;

/**
 * Created by lizhe on 2018/3/20.
 */

public interface HomePageContract {

    interface View extends BaseView{

        void showContent(HomePageBean homePageBean);

        void loadMore(HomePageBean homePageBean);
    }

    interface Presenter extends BasePresenter<View>{

        void getHomePage(String userId,int type);

    }


}