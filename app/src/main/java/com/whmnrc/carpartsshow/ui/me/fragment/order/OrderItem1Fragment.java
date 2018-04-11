package com.whmnrc.carpartsshow.ui.me.fragment.order;

import com.whmnrc.carpartsshow.model.http.bean.OrderListBean;
import com.whmnrc.carpartsshow.ui.me.fragment.order.adapter.WaitOrderAdapter;
import com.whmnrc.carpartsshow.ui.me.fragment.order.base.BaseOrderFragment;
import com.whmnrc.carpartsshow.ui.me.fragment.order.base.OnOrderListenerAdapter;
import com.whmnrc.carpartsshow.ui.me.fragment.order.base.OrderAdapter;
import com.whmnrc.carpartsshow.ui.shopping.activity.ConfirmOrderActivity;
import com.google.gson.Gson;

/**
 * Created by lizhe on 2018/3/16.
 * 待付款
 */

public class OrderItem1Fragment extends BaseOrderFragment {

    private WaitOrderAdapter mAdapter;

    @Override
    public OrderAdapter setAdapter() {
        mAdapter = new WaitOrderAdapter(getContext(),mPresenter);
        mAdapter.setOnOrderListener(new OnOrderListenerAdapter() {
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
        });
        return mAdapter;
    }


    @Override
    public int request() {
        return 1;
    }

}
