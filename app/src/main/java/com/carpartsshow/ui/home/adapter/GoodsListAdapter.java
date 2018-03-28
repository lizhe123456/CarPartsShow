package com.carpartsshow.ui.home.adapter;


import android.content.Context;

import com.carpartsshow.R;
import com.carpartsshow.base.adapter.BaseAdapter;
import com.carpartsshow.base.adapter.BaseViewHolder;
import com.carpartsshow.model.http.bean.GoodsListBean;

/**
 * Created by lizhe on 2018/3/27.
 */

public class GoodsListAdapter extends BaseAdapter<GoodsListBean>{

    public GoodsListAdapter(Context context) {
        super(context);
    }

    @Override
    protected void bindDataToItemView(BaseViewHolder holder, GoodsListBean item, int position) {
//        holder.setText(R.id.tv_goods_desc,).setText(R.id.tv_price,item.get).setGlieuImage()
    }

    @Override
    protected int getItemViewLayoutId(int position, GoodsListBean item) {
        return R.layout.item_goods_list;
    }

}
