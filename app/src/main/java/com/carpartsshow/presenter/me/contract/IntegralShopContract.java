package com.carpartsshow.presenter.me.contract;

import com.carpartsshow.base.BasePresenter;
import com.carpartsshow.base.BaseView;
import com.carpartsshow.model.http.bean.IntergralShopBean;

/**
 * Created by lizhe on 2018/3/16.
 */

public interface IntegralShopContract {

    interface View extends BaseView{
        void showCentent(IntergralShopBean shopBean);

        void loadMore(IntergralShopBean shopBean);
    }

    interface Presenter extends BasePresenter<View>{
        void getIntegralShop(int type);
    }

}
