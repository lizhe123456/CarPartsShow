package com.whmnrc.carpartsshow.ui.me.fragment.order.adapter;

import android.content.Context;

import com.whmnrc.carpartsshow.R;
import com.whmnrc.carpartsshow.base.adapter.BaseAdapter;
import com.whmnrc.carpartsshow.base.adapter.BaseViewHolder;
import com.whmnrc.carpartsshow.model.http.bean.OrderListBean;

/**
 * Created by lizhe on 2018/3/31.
 *
 */

public class OrderGoodsAdapter extends BaseAdapter<OrderListBean.DataBean.DetailBean> {


    public OrderGoodsAdapter(Context context) {
        super(context);
    }

    @Override
    protected void bindDataToItemView(BaseViewHolder holder, OrderListBean.DataBean.DetailBean item, int position) {
        holder.setVisible(R.id.tv_goods_num,true);
        holder.setText(R.id.tv_goods_num,"x"+item.getOrderItem_Number())
                .setGlieuImage(R.id.iv_goods,item.getProduct_ImgPath());
        if (item.getProduct_Type() == 2){
            holder.setText(R.id.tv_price,"积分："+item.getOrderItem_Money());
            holder.setVisible(R.id.tv_rmb,false);
            holder.setText(R.id.tv_xiaoj,"积分："+(item.getOrderItem_Money() * item.getOrderItem_Number()));
        }else {
            holder.setVisible(R.id.tv_rmb,true);
            if (item.getOrderItem_Money() <= 0){
                holder.setText(R.id.tv_price, R.string.no_price);
                holder.setVisible(R.id.tv_rmb,false);
            }else {
                holder.setText(R.id.tv_price, item.getOrderItem_Money()+""  );
                holder.setVisible(R.id.tv_rmb,true);
            }
            holder.setText(R.id.tv_xiaoj,"¥"+(item.getOrderItem_Money() * item.getOrderItem_Number()));
        }

        holder.setText(R.id.tv_znum,"共"+item.getOrderItem_Number()+"件商品");
    }

    @Override
    protected int getItemViewLayoutId(int position, OrderListBean.DataBean.DetailBean item) {
        return R.layout.order_goods_item_v2;
    }
}
