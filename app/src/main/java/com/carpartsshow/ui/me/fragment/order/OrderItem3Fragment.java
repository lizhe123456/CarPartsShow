package com.carpartsshow.ui.me.fragment.order;

import com.carpartsshow.model.http.bean.OrderListBean;
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
        WaitReceiptGoodsAdapter adapter = new WaitReceiptGoodsAdapter(getContext(),mPresenter);
        adapter.setOnOrderListener(new OrderAdapter.OnOrderListener() {
            @Override
            public void applyCustomerServiceClick(OrderListBean.DataBean item) {
                //申请售后
            }

            @Override
            public void payClick(OrderListBean.DataBean item) {

            }

            @Override
            public void customerServicePhoneClick(OrderListBean.DataBean item) {
                //联系客服
            }

            @Override
            public void lookProgress(OrderListBean.DataBean item) {

            }
        });
        return adapter;
    }

    @Override
    public int request() {
        return 3;
    }
}
