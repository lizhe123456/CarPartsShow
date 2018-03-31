package com.carpartsshow.ui.me.fragment.order;

import com.carpartsshow.ui.me.fragment.order.adapter.WaitDeliverGoodsAdapter;
import com.carpartsshow.ui.me.fragment.order.base.BaseOrderFragment;
import com.carpartsshow.ui.me.fragment.order.base.OrderAdapter;

/**
 * Created by lizhe on 2018/3/16.
 * 待发货
 */

public class OrderItem2Fragment extends BaseOrderFragment {


    @Override
    public OrderAdapter setAdapter() {
        return new WaitDeliverGoodsAdapter(getContext());
    }

    @Override
    public int request() {
        return 2;
    }
}
