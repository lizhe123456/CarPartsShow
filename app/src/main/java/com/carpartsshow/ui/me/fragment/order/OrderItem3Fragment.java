package com.carpartsshow.ui.me.fragment.order;

import com.carpartsshow.R;
import com.carpartsshow.ui.me.fragment.order.adapter.WaitDeliverGoodsAdapter;
import com.carpartsshow.ui.me.fragment.order.adapter.WaitReceiptGoodsAdapter;
import com.carpartsshow.ui.me.fragment.order.base.BaseOrderFragment;
import com.carpartsshow.ui.me.fragment.order.base.OrderAdapter;

/**
 * Created by lizhe on 2018/3/16.
 * 已发货
 */

public class OrderItem3Fragment extends BaseOrderFragment {

    @Override
    public OrderAdapter setAdapter() {
        return new WaitReceiptGoodsAdapter(getContext());
    }

    @Override
    public int request() {
        return 3;
    }
}
