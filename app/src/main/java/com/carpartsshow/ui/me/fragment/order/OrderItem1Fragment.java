package com.carpartsshow.ui.me.fragment.order;

import com.carpartsshow.model.http.bean.OrderListBean;
import com.carpartsshow.ui.MainActivity;
import com.carpartsshow.ui.me.fragment.order.adapter.WaitOrderAdapter;
import com.carpartsshow.ui.me.fragment.order.base.BaseOrderFragment;
import com.carpartsshow.ui.me.fragment.order.base.OrderAdapter;
import com.carpartsshow.ui.shopping.activity.ConfirmOrderActivity;
import com.google.gson.Gson;

/**
 * Created by lizhe on 2018/3/16.
 * 待付款
 */

public class OrderItem1Fragment extends BaseOrderFragment{

    private WaitOrderAdapter mAdapter;

    @Override
    public OrderAdapter setAdapter() {
        mAdapter = new WaitOrderAdapter(getContext(),mPresenter);
        mAdapter.setOnOrderListener(new OrderAdapter.OnOrderListener() {

            @Override
            public void applyCustomerServiceClick(OrderListBean.DataBean item) {

            }

            @Override
            public void payClick(OrderListBean.DataBean item) {
                String json = new Gson().toJson(item);
                ConfirmOrderActivity.start(getContext(),json,1);
            }

            @Override
            public void customerServicePhoneClick(OrderListBean.DataBean item) {
                //联系客服
                customerServicePhone();
            }

            @Override
            public void lookProgress(OrderListBean.DataBean item) {

            }
        });
        return mAdapter;
    }


    @Override
    public int request() {
        return 1;
    }

}
