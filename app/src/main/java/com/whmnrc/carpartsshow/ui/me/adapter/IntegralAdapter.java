package com.whmnrc.carpartsshow.ui.me.adapter;

import android.content.Context;

import com.whmnrc.carpartsshow.R;
import com.whmnrc.carpartsshow.base.adapter.BaseAdapter;
import com.whmnrc.carpartsshow.base.adapter.BaseViewHolder;
import com.whmnrc.carpartsshow.model.http.bean.IntergralBean;

/**
 * Created by lizhe on 2018/3/15.
 */

public class IntegralAdapter extends BaseAdapter<IntergralBean> {

    public IntegralAdapter(Context context) {
        super(context);
    }

    @Override
    protected void bindDataToItemView(BaseViewHolder holder, IntergralBean item, int position) {
        holder.setText(R.id.tv_desc,item.getIntegerGoods_Name());
        holder.setText(R.id.tv_time,item.getExchange_CreateTime());
        holder.setText(R.id.tv_integral,"-"+item.getIntegerGoods_Integer());
        if (position == getDataSource().size()-1){
            holder.setVisible(R.id.v_xian,false);
        }
    }

    @Override
    protected int getItemViewLayoutId(int position, IntergralBean item) {
        return R.layout.integral_item;
    }
}
