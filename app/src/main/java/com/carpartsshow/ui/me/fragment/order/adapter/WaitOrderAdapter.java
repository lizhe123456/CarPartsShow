package com.carpartsshow.ui.me.fragment.order.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.carpartsshow.R;
import com.carpartsshow.base.adapter.BaseViewHolder;
import com.carpartsshow.model.http.bean.OrderListBean;
import com.carpartsshow.presenter.me.MyOrderPresenter;
import com.carpartsshow.ui.me.fragment.order.base.OrderAdapter;

/**
 * Created by lizhe on 2018/3/31.
 * 待付款
 */

public class WaitOrderAdapter extends OrderAdapter {

    public WaitOrderAdapter(Context context, MyOrderPresenter presenter) {
        super(context,presenter);
    }

    @Override
    protected void bindDataToItemView(BaseViewHolder holder, OrderListBean.DataBean item, int position) {
        super.bindDataToItemView(holder, item, position);
    }


}
