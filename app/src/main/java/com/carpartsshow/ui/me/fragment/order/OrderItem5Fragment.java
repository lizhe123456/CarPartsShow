package com.carpartsshow.ui.me.fragment.order;

import com.carpartsshow.model.http.bean.OrderListBean;
import com.carpartsshow.ui.me.fragment.order.adapter.CustomerServiceAdapter;
import com.carpartsshow.ui.me.fragment.order.base.BaseOrderFragment;
import com.carpartsshow.ui.me.fragment.order.base.OrderAdapter;

/**
 * Created by lizhe on 2018/3/16.
 * 退货/售后
 */

public class OrderItem5Fragment extends BaseOrderFragment{

    @Override
    public OrderAdapter setAdapter() {
        CustomerServiceAdapter adapter = new CustomerServiceAdapter(getContext(),mPresenter);
        adapter.setOnOrderListener(new OrderAdapter.OnOrderListener() {
            @Override
            public void applyCustomerServiceClick(OrderListBean.DataBean item) {

            }

            @Override
            public void payClick(OrderListBean.DataBean item) {

            }

            @Override
            public void customerServicePhoneClick(OrderListBean.DataBean item) {

            }

            @Override
            public void lookProgress(OrderListBean.DataBean item) {

            }
        });
        return adapter;
    }

    @Override
    public int request() {
        return 5;
    }
}
