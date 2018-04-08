package com.carpartsshow.ui.home.adapter;

import android.content.Context;

import com.carpartsshow.R;
import com.carpartsshow.base.adapter.BaseAdapter;
import com.carpartsshow.base.adapter.BaseViewHolder;
import com.carpartsshow.model.http.bean.HomePageBean;

/**
 * Created by lizhe on 2018/3/26.
 */

public class ListDateItemAdapter extends BaseAdapter<HomePageBean.ListCardImg> {

    public ListDateItemAdapter(Context context) {
        super(context);
    }

    @Override
    protected void bindDataToItemView(BaseViewHolder holder, HomePageBean.ListCardImg item, int position) {
        holder.setText(R.id.tv_title,item.getTitle()).setText(R.id.tv_search,item.getSearch()).setGlieuImage(R.id.iv_img,item.getImgUrl());
    }

    @Override
    protected int getItemViewLayoutId(int position, HomePageBean.ListCardImg item) {
        return R.layout.home_data_item;
    }
}
