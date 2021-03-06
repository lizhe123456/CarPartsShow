package com.whmnrc.carpartsshow.ui.me.fragment.order;

import com.whmnrc.carpartsshow.model.http.bean.OrderListBean;
import com.whmnrc.carpartsshow.ui.me.fragment.order.adapter.CompleteOrederAdapter;
import com.whmnrc.carpartsshow.ui.me.fragment.order.base.BaseOrderFragment;
import com.whmnrc.carpartsshow.ui.me.fragment.order.base.OnOrderListenerAdapter;
import com.whmnrc.carpartsshow.ui.me.fragment.order.base.OrderAdapter;

/**
 * Created by lizhe on 2018/3/16.
 * 已完成
 */

public class OrderItem4Fragment extends BaseOrderFragment {

    @Override
    public OrderAdapter setAdapter(){
        CompleteOrederAdapter adapter = new CompleteOrederAdapter(getContext(),mPresenter);
        adapter.setOnOrderListener(new OnOrderListenerAdapter() {
            @Override
            public void applyCustomerServiceClick(OrderListBean.DataBean item) {
                //申请售后
                applyCustomerService(item);
            }

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
        return 4;
    }
}
