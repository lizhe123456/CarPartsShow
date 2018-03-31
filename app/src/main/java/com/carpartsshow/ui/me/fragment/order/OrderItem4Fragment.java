package com.carpartsshow.ui.me.fragment.order;

import com.carpartsshow.R;
import com.carpartsshow.base.BaseFragment;
import com.carpartsshow.ui.me.fragment.order.adapter.CompleteOrederAdapter;
import com.carpartsshow.ui.me.fragment.order.base.BaseOrderFragment;
import com.carpartsshow.ui.me.fragment.order.base.OrderAdapter;

/**
 * Created by lizhe on 2018/3/16.
 * 已完成
 */

public class OrderItem4Fragment extends BaseOrderFragment{

    @Override
    public OrderAdapter setAdapter() {
        return new CompleteOrederAdapter(getContext());
    }

    @Override
    public int request() {
        return 4;
    }
}
