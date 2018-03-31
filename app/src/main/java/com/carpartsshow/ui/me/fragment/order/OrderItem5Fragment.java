package com.carpartsshow.ui.me.fragment.order;

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
        return new CustomerServiceAdapter(getContext());
    }

    @Override
    public int request() {
        return 5;
    }
}
