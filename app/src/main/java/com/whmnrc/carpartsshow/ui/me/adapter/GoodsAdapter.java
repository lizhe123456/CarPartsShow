package com.whmnrc.carpartsshow.ui.me.adapter;

import android.content.Context;

import com.whmnrc.carpartsshow.R;
import com.whmnrc.carpartsshow.base.adapter.BaseAdapter;
import com.whmnrc.carpartsshow.base.adapter.BaseViewHolder;
import com.whmnrc.carpartsshow.model.http.bean.IntergralShopBean;

/**
 * Created by lizhe on 2018/3/16.
 */

public class GoodsAdapter extends BaseAdapter<IntergralShopBean.IstIntegerGoods> {

    public GoodsAdapter(Context context) {
        super(context);
    }

    @Override
    protected void bindDataToItemView(BaseViewHolder holder, IntergralShopBean.IstIntegerGoods item, int position) {
        holder.setGlieuImage(R.id.iv_goods,item.getIntegerGoods_ImgPath());
        holder.setText(R.id.tv_goods_desc,item.getIntegerGoods_Name());
        holder.setText(R.id.tv_price,"积分："+item.getIntegerGoods_Integer()+"");
//        holder.setTextColor(R.id.tv_goods_state,R.color.tv_999);
//        holder.setTextColor(R.id.tv_goods_state,R.color.red_login);
    }

    @Override
    protected int getItemViewLayoutId(int position, IntergralShopBean.IstIntegerGoods item) {
        return R.layout.goods_item;
    }
}
