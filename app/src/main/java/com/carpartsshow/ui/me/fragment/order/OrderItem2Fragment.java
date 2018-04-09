package com.carpartsshow.ui.me.fragment.order;

import com.carpartsshow.model.http.bean.OrderListBean;
import com.carpartsshow.ui.me.fragment.order.adapter.WaitDeliverGoodsAdapter;
import com.carpartsshow.ui.me.fragment.order.base.BaseOrderFragment;
import com.carpartsshow.ui.me.fragment.order.base.OnOrderListenerAdapter;
import com.carpartsshow.ui.me.fragment.order.base.OrderAdapter;

/**
 * Created by lizhe on 2018/3/16.
 * 待发货
 */

public class OrderItem2Fragment extends BaseOrderFragment {


    @Override
    public OrderAdapter setAdapter() {
        WaitDeliverGoodsAdapter adapter = new WaitDeliverGoodsAdapter(getContext(),mPresenter);
        adapter.setOnOrderListener(new OnOrderListenerAdapter() {

            @Override
            public void customerServicePhoneClick(OrderListBean.DataBean item) {
                //联系客服
                customerServicePhone();
            }

        });
        return adapter;
    }

    @Override
    public int request() {
        return 2;
    }
}
