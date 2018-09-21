package com.whmnrc.carpartsshow.ui.me.fragment.order;

import com.whmnrc.carpartsshow.model.http.bean.OrderListBean;
import com.whmnrc.carpartsshow.ui.me.fragment.order.adapter.WaitReceiptGoodsAdapter;
import com.whmnrc.carpartsshow.ui.me.fragment.order.base.BaseOrderFragment;
import com.whmnrc.carpartsshow.ui.me.fragment.order.base.OnOrderListenerAdapter;
import com.whmnrc.carpartsshow.ui.me.fragment.order.base.OrderAdapter;

/**
 * Created by lizhe on 2018/3/16.
 * 已发货
 */

public class OrderItem3Fragment extends BaseOrderFragment {

    @Override
    public OrderAdapter setAdapter() {
        WaitReceiptGoodsAdapter adapter = new WaitReceiptGoodsAdapter(getContext(),mPresenter);
        adapter.setOnOrderListener(new OnOrderListenerAdapter() {
            @Override
            public void applyCustomerServiceClick(OrderListBean.DataBean item) {
                if (item.getOrder_PayType() == 2){
                    applyCustomerService(item);
                }else if (item.getOrder_PayType() == 0){
//                    mPresenter.applyCustomerService();
                }
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
        return 3;
    }
}
