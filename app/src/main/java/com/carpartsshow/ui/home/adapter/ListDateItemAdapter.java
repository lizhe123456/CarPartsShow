package com.carpartsshow.ui.home.adapter;

import android.content.Context;

import com.carpartsshow.R;
import com.carpartsshow.base.adapter.BaseAdapter;
import com.carpartsshow.base.adapter.BaseViewHolder;
import com.carpartsshow.model.http.bean.HomePageBean;

/**
 * Created by lizhe on 2018/3/26.
 */

public class ListDateItemAdapter extends BaseAdapter<HomePageBean.ListDateItemBean> {

    public ListDateItemAdapter(Context context) {
        super(context);
    }

    @Override
    protected void bindDataToItemView(BaseViewHolder holder, HomePageBean.ListDateItemBean item, int position) {

    }

    @Override
    protected int getItemViewLayoutId(int position, HomePageBean.ListDateItemBean item) {
        return R.layout.home_data_item;
    }
}
