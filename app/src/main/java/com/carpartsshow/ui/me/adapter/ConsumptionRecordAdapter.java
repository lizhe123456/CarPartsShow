package com.carpartsshow.ui.me.adapter;

import android.content.Context;

import com.carpartsshow.R;
import com.carpartsshow.base.adapter.BaseAdapter;
import com.carpartsshow.base.adapter.BaseViewHolder;
import com.carpartsshow.model.http.bean.ConsumptionRecordBean;

/**
 * Created by lizhe on 2018/3/29.
 */

public class ConsumptionRecordAdapter extends BaseAdapter<ConsumptionRecordBean> {


    public ConsumptionRecordAdapter(Context context) {
        super(context);
    }

    @Override
    protected void bindDataToItemView(BaseViewHolder holder, ConsumptionRecordBean item, int position) {
        holder.setText(R.id.tv_num,item.getCreditRecord_Money()+".00").setText(R.id.tv_time,"最后还款日:"+item.getCreditRecord_OverTime());
        if (item.getCreditRecord_State() == 0){
            holder.setText(R.id.tv_go,"去还款");
        }else if (item.getCreditRecord_State() == 1){
            holder.setText(R.id.tv_go,"已还款");
        }
    }

    @Override
    protected int getItemViewLayoutId(int position, ConsumptionRecordBean item) {
        return R.layout.item_consumption_record;
    }
}
