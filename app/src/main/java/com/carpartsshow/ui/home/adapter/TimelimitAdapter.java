package com.carpartsshow.ui.home.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.widget.TextView;

import com.carpartsshow.R;
import com.carpartsshow.base.adapter.BaseAdapter;
import com.carpartsshow.base.adapter.BaseViewHolder;
import com.carpartsshow.model.http.bean.SeckillGoodsBean;

/**
 * Created by lizhe on 2018/4/8.
 */

public class TimelimitAdapter extends BaseAdapter<SeckillGoodsBean> {

    public TimelimitAdapter(Context context) {
        super(context);
    }

    @Override
    protected void bindDataToItemView(BaseViewHolder holder, SeckillGoodsBean item, int position) {
        holder.setText(R.id.tv_goods_desc,item.getSeckill_Name())
                .setText(R.id.tv_price,item.getSeckill_Price()+".00")
                .setText(R.id.tv_num,"只剩"+item.getSeckill_Stock()+"件").setText(R.id.tv_old_price,"¥"+item.getSeckill_SourcePrice()+".00");
        holder.setGlieuImage(R.id.iv_goods,item.getSeckill_ImgPath());
        TextView textView = holder.getView(R.id.tv_old_price);
        textView.getPaint().setAntiAlias(true);//抗锯齿
        textView.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG); //中划线
    }

    @Override
    protected int getItemViewLayoutId(int position, SeckillGoodsBean item) {
        return R.layout.item_time_limit;
    }
}
