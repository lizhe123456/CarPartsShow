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
        holder.setText(R.id.tv_goods_num,"x"+item.getNumber())
                .setGlieuImage(R.id.iv_goods,item.getImagePath());
        if (item.getGoods_Type() == 2){
            holder.setText(R.id.tv_price,"积分："+item.getGoods_Price());
            holder.setVisible(R.id.tv_rmb,false);
            holder.setText(R.id.tv_xiaoj,"积分："+(item.getGoods_Price() * item.getNumber()));
        }else {
            holder.setVisible(R.id.tv_rmb,true);
            holder.setText(R.id.tv_price,item.getGoods_Price()+".00");
            holder.setText(R.id.tv_xiaoj,"¥"+(item.getGoods_Price() * item.getNumber())+".00");
        }

        holder.setText(R.id.tv_znum,"共"+item.getNumber()+"件商品");
    }

    @Override
    protected int getItemViewLayoutId(int position, OrderBean.GoodsBean item) {
        return R.layout.order_goods_item;
    }
}
