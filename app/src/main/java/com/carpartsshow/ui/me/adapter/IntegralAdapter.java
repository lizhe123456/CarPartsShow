package com.carpartsshow.ui.me.adapter;

import android.content.Context;

import com.carpartsshow.R;
import com.carpartsshow.base.adapter.BaseAdapter;
import com.carpartsshow.base.adapter.BaseViewHolder;
import com.carpartsshow.model.http.bean.IntergralBean;

/**
 * Created by lizhe on 2018/3/15.
 */

public class IntegralAdapter extends BaseAdapter<IntergralBean> {

    public IntegralAdapter(Context context) {
        super(context);
    }

    @Override
    protected void bindDataToItemView(BaseViewHolder holder, IntergralBean item, int position) {
        holder.setText(R.id.tv_desc,"");
        holder.setText(R.id.tv_time,"");
        holder.setText(R.id.tv_integral,"");
    }

    @Override
    protected int getItemViewLayoutId(int position, IntergralBean item) {
        return R.layout.integral_item;
    }
}
