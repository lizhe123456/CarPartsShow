package com.carpartsshow.ui.me.adapter;

import android.content.Context;

import com.carpartsshow.R;
import com.carpartsshow.base.adapter.BaseAdapter;
import com.carpartsshow.base.adapter.BaseViewHolder;
import com.carpartsshow.model.http.bean.IntegralRecordBean;

/**
 * Created by lizhe on 2018/3/16.
 */

public class IntegralRecordAdapter extends BaseAdapter<IntegralRecordBean> {

    public IntegralRecordAdapter(Context context) {
        super(context);
    }

    @Override
    protected void bindDataToItemView(BaseViewHolder holder, IntegralRecordBean item, int position) {
        holder.setGlieuImage(R.id.goods_img,item.getIntegerGoods_ImgPath())
                .setText(R.id.tv_time,"兑换时间："+item.getExchange_CreateTime())
                .setText(R.id.tv_goods_name,item.getIntegerGoods_Name())
                .setText(R.id.tv_price,item.getIntegerGoods_Integer()+"")
                .setText(R.id.tv_num,"x1");
    }

    @Override
    protected int getItemViewLayoutId(int position, IntegralRecordBean item) {
        return R.layout.integral_record;
    }
}
