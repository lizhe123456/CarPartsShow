package com.whmnrc.carpartsshow.ui.me.fragment.order;

import com.whmnrc.carpartsshow.model.http.bean.OrderListBean;
import com.whmnrc.carpartsshow.ui.me.fragment.order.adapter.CustomerServiceAdapter;
import com.whmnrc.carpartsshow.ui.me.fragment.order.base.BaseOrderFragment;
import com.whmnrc.carpartsshow.ui.me.fragment.order.base.OnOrderListenerAdapter;
import com.whmnrc.carpartsshow.ui.me.fragment.order.base.OrderAdapter;

/**
 * Created by lizhe on 2018/3/16.
 * 退货/售后
 */

public class OrderItem5Fragment extends BaseOrderFragment {

    @Override
    public OrderAdapter setAdapter() {
        CustomerServiceAdapter adapter = new CustomerServiceAdapter(getContext(),mPresenter);
        adapter.setOnOrderListener(new OnOrderListenerAdapter(){
            @Override
            public void customerServicePhoneClick(OrderListBean.DataBean item) {
                customerServicePhone();
            }

        });
        return adapter;
    }

    @Override
    public int request() {
        return 5;
    }
}
