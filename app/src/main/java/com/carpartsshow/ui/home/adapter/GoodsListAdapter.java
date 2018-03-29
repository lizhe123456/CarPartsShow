package com.carpartsshow.ui.home.adapter;


import android.content.Context;
import android.view.View;

import com.carpartsshow.R;
import com.carpartsshow.base.adapter.BaseAdapter;
import com.carpartsshow.base.adapter.BaseViewHolder;
import com.carpartsshow.model.http.bean.GoodsListBean;

/**
 * Created by lizhe on 2018/3/27.
 */

public class GoodsListAdapter extends BaseAdapter<GoodsListBean.ListGoodsBean>{

    private OnJoinClickListener onJoinClickListener;

    public GoodsListAdapter(Context context) {
        super(context);
    }

    public void setOnJoinClickListener(OnJoinClickListener onJoinClickListener) {
        this.onJoinClickListener = onJoinClickListener;
    }

    @Override
    protected void bindDataToItemView(BaseViewHolder holder, final GoodsListBean.ListGoodsBean item, int position) {
        holder.setText(R.id.tv_goods_desc,item.getName())
                .setText(R.id.tv_price,item.getGoods_Price()+".00")
                .setGlieuImage(R.id.iv_goods,item.getImagePath());
        holder.setOnClickListener(R.id.tv_join_car, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onJoinClickListener != null){
                    onJoinClickListener.joinCar(item);
                }
            }
        });
    }

    @Override
    protected int getItemViewLayoutId(int position, GoodsListBean.ListGoodsBean item) {
        return R.layout.item_goods_list;
    }

    public interface OnJoinClickListener{
        void joinCar(GoodsListBean.ListGoodsBean item);
    }
}
