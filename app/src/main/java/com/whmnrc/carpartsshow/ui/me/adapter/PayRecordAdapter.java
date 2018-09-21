package com.whmnrc.carpartsshow.ui.me.adapter;

import android.content.Context;

import com.whmnrc.carpartsshow.R;
import com.whmnrc.carpartsshow.base.adapter.BaseAdapter;
import com.whmnrc.carpartsshow.base.adapter.BaseViewHolder;
import com.whmnrc.carpartsshow.model.http.bean.PayRecordBean;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/9/17.
 */

public class PayRecordAdapter extends BaseAdapter<PayRecordBean>{

    public PayRecordAdapter(Context context) {
        super(context);
    }

    @Override
    protected void bindDataToItemView(BaseViewHolder holder, PayRecordBean item, int position) {
        holder.setText(R.id.tv_num,"金额："+item.getCreditRecord_Money()).setText(R.id.tv_time,"下单时间:"+item.getCreditRecord_CreateTime());
        holder.setText(R.id.tv_order_num,"订单号：" + item.getOrder_No());

    }

    @Override
    protected int getItemViewLayoutId(int position, PayRecordBean item) {
        return R.layout.item_pay_record;
    }
}
