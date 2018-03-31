package com.carpartsshow.presenter.me.contract;

import com.carpartsshow.base.BasePresenter;
import com.carpartsshow.base.BaseView;
import com.carpartsshow.model.http.bean.OrderListBean;

/**
 * Created by lizhe on 2018/3/31.
 */

public interface MyOrderContract {

    interface View extends BaseView{
        void showData(OrderListBean orderListBean);

        void loadMore(OrderListBean orderListBean);
    }

    interface Presenter extends BasePresenter<View>{
        void getOrderList(String userId,int type,int loadType);
    }

}
