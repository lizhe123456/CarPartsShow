package com.whmnrc.carpartsshow.ui.me.fragment.order.base;

import com.whmnrc.carpartsshow.model.http.bean.OrderListBean;

/**
 * Created by lizhe on 2018/4/9.
 */

public interface OnOrderListener {
    //申请售后
    void applyCustomerServiceClick(OrderListBean.DataBean item);

    //付款
    void payClick(OrderListBean.DataBean item);

    //联系客服
    void customerServicePhoneClick(OrderListBean.DataBean item);

    //查看进度
    void lookProgress(OrderListBean.DataBean item);
}
