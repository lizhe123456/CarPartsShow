package com.whmnrc.carpartsshow.ui.me.adapter;

import android.content.Context;
import android.view.View;

import com.whmnrc.carpartsshow.R;
import com.whmnrc.carpartsshow.base.adapter.BaseAdapter;
import com.whmnrc.carpartsshow.base.adapter.BaseViewHolder;
import com.whmnrc.carpartsshow.model.http.bean.CollectionBean;

import java.util.List;

/**
 * Created by lizhe on 2018/3/15.
 */

public class CollectionAdapter extends BaseAdapter<CollectionBean.CollectionListProductBean> {

    private int type;



    public CollectionAdapter(Context context) {
        super(context);
    }

    public void showSelect(){
        type = 1;
        notifyDataSetChanged();
    }

    public void hipeSelect(){
        type = 0;
        notifyDataSetChanged();
    }

    @Override
    protected void bindDataToItemView(final BaseViewHolder holder, final CollectionBean.CollectionListProductBean item, int position) {
        if (type == 0){
            holder.setText(R.id.tv_goods_desc,item.getName());
            holder.setGlieuImage(R.id.iv_goods,item.getImagePath());
            holder.setText(R.id.tv_price,item.getPrice()+"");
            holder.setVisible(R.id.iv_select,false);
        }else if (type == 1){
            holder.setText(R.id.tv_goods_desc,item.getName());
            holder.setGlieuImage(R.id.iv_goods,item.getImagePath());
            holder.setText(R.id.tv_price,item.getPrice()+"");
            holder.setVisible(R.id.iv_select,true);
            if (item.isSelect()){
                holder.setImageResource(R.id.iv_select,R.drawable.round_btn_selected);
            }else {
                holder.setImageResource(R.id.iv_select,R.drawable.round_btn_normal);
            }

            holder.setOnClickListener(R.id.iv_select, new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (item.isSelect()){
                        holder.setImageResource(R.id.iv_select,R.drawable.round_btn_normal);
                        item.setSelect(false);
                    }else {
                        item.setSelect(true);
                        holder.setImageResource(R.id.iv_select,R.drawable.round_btn_selected);
                    }
                }
            });
        }
    }

    @Override
    protected int getItemViewLayoutId(int position, CollectionBean.CollectionListProductBean item) {
        return R.layout.item_collection;
    }


    public void allSelect(boolean flag) {
        List<CollectionBean.CollectionListProductBean> list = getDataSource();
        for (int i = 0; i < list.size(); i++) {
            if (flag) {
                list.get(i).setSelect(true);
            }else {
                list.get(i).setSelect(false);
            }
        }
        this.notifyDataSetChanged();
    }
}
