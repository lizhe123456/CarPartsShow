package com.whmnrc.carpartsshow.ui.me.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.whmnrc.carpartsshow.R;
import com.whmnrc.carpartsshow.ui.me.adapter.bean.OrderItem;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lizhe on 2018/3/14.
 */

public class OrderListAdapter extends BaseAdapter {

    private List<OrderItem> list = new ArrayList<>();
    private LayoutInflater layoutInflater;
    private Context mContext;

    public OrderListAdapter(Context context) {
        mContext = context;

        this.layoutInflater = LayoutInflater.from(mContext);
    }

    public void addFristData(List<OrderItem> data){
        list.addAll(data);
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if(convertView == null){
            viewHolder = new ViewHolder();
            convertView = layoutInflater.inflate(R.layout.order_item, null);
            viewHolder.mImageView = convertView.findViewById(R.id.iv_icon);
            viewHolder.mTextView = convertView.findViewById(R.id.tv_title);
            viewHolder.mTextNum = convertView.findViewById(R.id.tv_num);
            viewHolder.viewXian = convertView.findViewById(R.id.tv_xian);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.mImageView.setImageResource(list.get(position).getImg());
        viewHolder.mTextView.setText(list.get(position).getText()+"");
        if (list.get(position).getNum() > 0) {
            viewHolder.mTextNum.setText(list.get(position).getNum() + "");
            viewHolder.mTextNum.setVisibility(View.VISIBLE);
        }else {
            viewHolder.mTextNum.setVisibility(View.GONE);
        }
        if (position == list.size() -1){
            viewHolder.viewXian.setVisibility(View.VISIBLE);
        }else {
            viewHolder.viewXian.setVisibility(View.GONE);
        }
        return convertView;
    }

    class ViewHolder{
        ImageView mImageView;
        TextView mTextView;
        TextView mTextNum;
        View viewXian;
    }
}
