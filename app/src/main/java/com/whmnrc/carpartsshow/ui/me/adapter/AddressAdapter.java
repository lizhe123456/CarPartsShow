package com.whmnrc.carpartsshow.ui.me.adapter;

import android.content.Context;
import android.text.TextUtils;

import com.whmnrc.carpartsshow.R;
import com.whmnrc.carpartsshow.base.adapter.BaseAdapter;
import com.whmnrc.carpartsshow.base.adapter.BaseViewHolder;
import com.whmnrc.carpartsshow.model.http.bean.OrderBean;

/**
 * Created by lizhe on 2018/4/2.
 */

public class AddressAdapter extends BaseAdapter<OrderBean.ListReceiptAddressBean>{

    public AddressAdapter(Context context) {
        super(context);
    }

    @Override
    protected void bindDataToItemView(BaseViewHolder holder, OrderBean.ListReceiptAddressBean item, int position) {
        if (TextUtils.isEmpty(item.getMobile())) {
            String name = item.getDetailAddress();
            holder.setVisible(R.id.receipt_address,true).setText(R.id.receipt_address,"收货地址：" + name);
            holder.setVisible(R.id.rl_address,false);
        } else {
            holder.setVisible(R.id.receipt_address,false);
            holder.setVisible(R.id.rl_address,true);
            holder.setText(R.id.tv_contacts,item.getPersonName());
            holder.setText(R.id.tv_phone,item.getMobile());
            holder.setText(R.id.tv_address,item.getDetailAddress());
        }
    }

    @Override
    protected int getItemViewLayoutId(int position, OrderBean.ListReceiptAddressBean item) {
        return R.layout.head_address;
    }
}
