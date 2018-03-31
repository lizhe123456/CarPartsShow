package com.carpartsshow.ui.me.fragment.order;

import com.carpartsshow.ui.me.fragment.order.adapter.WaitOrderAdapter;
import com.carpartsshow.ui.me.fragment.order.base.BaseOrderFragment;
import com.carpartsshow.ui.me.fragment.order.base.OrderAdapter;

/**
 * Created by lizhe on 2018/3/16.
 * 待付款
 */

public class OrderItem1Fragment extends BaseOrderFragment{

    private WaitOrderAdapter mAdapter;


    @Override
    public OrderAdapter setAdapter() {
        mAdapter = new WaitOrderAdapter(getContext());
        return mAdapter;
    }


    @Override
    public int request() {
        return 1;
    }

}
