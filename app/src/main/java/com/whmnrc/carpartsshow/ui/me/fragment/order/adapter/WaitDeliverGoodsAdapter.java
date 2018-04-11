package com.whmnrc.carpartsshow.ui.me.fragment.order.adapter;

import android.content.Context;

import com.whmnrc.carpartsshow.base.adapter.BaseViewHolder;
import com.whmnrc.carpartsshow.model.http.bean.OrderListBean;
import com.whmnrc.carpartsshow.presenter.me.MyOrderPresenter;
import com.whmnrc.carpartsshow.ui.me.fragment.order.base.OrderAdapter;

/**
 * Created by lizhe on 2018/3/31.
 * 待发货
 */

public class WaitDeliverGoodsAdapter extends OrderAdapter {

    public WaitDeliverGoodsAdapter(Context context, MyOrderPresenter presenter) {
        super(context,presenter);
    }

    @Override
    protected void bindDataToItemView(BaseViewHolder holder, OrderListBean.DataBean item, int position) {
        super.bindDataToItemView(holder, item, position);
    }


}
