package com.carpartsshow.ui.shopping.adapter;

import android.content.Context;

import com.carpartsshow.R;
import com.carpartsshow.base.adapter.BaseAdapter;
import com.carpartsshow.base.adapter.BaseViewHolder;
import com.carpartsshow.model.http.bean.OrderBean;

/**
 * Created by lizhe on 2018/3/29.
 */

public class ConfirmOrderAdapter extends BaseAdapter<OrderBean.GoodsBean> {

    public ConfirmOrderAdapter(Context context) {
        super(context);
    }

    @Override
    protected void bindDataToItemView(BaseViewHolder holder, OrderBean.GoodsBean item, int position) {
        holder.setVisible(R.id.tv_goods_num,true);
        holder.setText(R.id.tv_goods_num,"x"+item.getName())
                .setGlieuImage(R.id.iv_goods,item.getImagePath());
        if (item.getGoods_Type() == 2){
            holder.setText(R.id.tv_price,"¥"+item.getGoods_Price()+".00");
        }else {
            holder.setText(R.id.tv_price,"积分："+item.getGoods_Integer());
        }

        holder.setText(R.id.tv_znum,"共"+item.getNumber()+"件商品").setText(R.id.tv_xiaoj,"¥"+(item.getGoods_Price() * item.getNumber()));
    }

    @Override
    protected int getItemViewLayoutId(int position, OrderBean.GoodsBean item) {
        return R.layout.order_goods_item;
    }
}