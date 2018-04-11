package com.whmnrc.carpartsshow.ui.home.adapter;

import android.content.Context;

import com.whmnrc.carpartsshow.R;
import com.whmnrc.carpartsshow.base.adapter.BaseAdapter;
import com.whmnrc.carpartsshow.base.adapter.BaseViewHolder;
import com.whmnrc.carpartsshow.model.http.bean.MsgBean;

/**
 * Created by lizhe on 2018/3/28.
 */

public class MessageRecordAdapter extends BaseAdapter<MsgBean> {
    public MessageRecordAdapter(Context context) {
        super(context);
    }

    @Override
    protected void bindDataToItemView(BaseViewHolder holder, MsgBean item, int position) {
        holder.setText(R.id.tv_title,item.getUserMsg_Content()).setText(R.id.tv_time,item.getUserMsg_CreateTime());
    }

    @Override
    protected int getItemViewLayoutId(int position, MsgBean item) {
        return R.layout.message_item;
    }
}
