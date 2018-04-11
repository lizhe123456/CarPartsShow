package com.whmnrc.carpartsshow.presenter.me.contract;

import com.whmnrc.carpartsshow.base.BasePresenter;
import com.whmnrc.carpartsshow.base.BaseView;
import com.whmnrc.carpartsshow.model.http.bean.OrderListBean;

import java.util.Map;

/**
 * Created by lizhe on 2018/3/31.
 */

public interface MyOrderContract {

    interface View extends BaseView{
        void showData(OrderListBean orderListBean);

        void loadMore(OrderListBean orderListBean);

        void updateData(String msg);
    }

    interface Presenter extends BasePresenter<View>{
        void getOrderList(String userId,int type,int loadType);

        //申请售后
        void applyCustomerService(String orderId);

        //订单加急
        void orderUrgent(String orderId);

        //确认收货
        void receiptGoods(String orderId);

        //取消订单
        void cancelOrder(String orderId);

        //付款
        void pay(Map<String,Object> map);

        //查看进度
        void lookProgress();
    }

}
