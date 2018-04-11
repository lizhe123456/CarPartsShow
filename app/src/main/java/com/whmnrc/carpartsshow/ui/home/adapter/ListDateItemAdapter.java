package com.whmnrc.carpartsshow.ui.home.adapter;

import android.content.Context;
import android.view.View;

import com.whmnrc.carpartsshow.R;
import com.whmnrc.carpartsshow.base.adapter.BaseAdapter;
import com.whmnrc.carpartsshow.base.adapter.BaseViewHolder;
import com.whmnrc.carpartsshow.model.http.bean.HomePageBean;
import com.whmnrc.carpartsshow.ui.home.activity.GoodsSearchActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lizhe on 2018/3/26.
 */

public class ListDateItemAdapter extends BaseAdapter<HomePageBean.ListCardImg> {

    private  int type;
    private boolean flag = true;

    private List<List<HomePageBean.ListCardImg>> lists = new ArrayList<>();

    public ListDateItemAdapter(Context context,int type) {
        super(context);
        this.type = type;
    }

    public void setLists(List<List<HomePageBean.ListCardImg>> lists) {
        this.lists = lists;
    }

    @Override
    protected void bindDataToItemView(BaseViewHolder holder, final HomePageBean.ListCardImg item, int position) {
        if (type == 0) {
            holder.setText(R.id.tv_title, item.getTitle()).setText(R.id.tv_search, item.getSearch()).setGlieuImage(R.id.iv_img, item.getImgUrl());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    GoodsSearchActivity.start(getContext(), item.getSearch());
                }
            });
        }else {
            if (flag) {

                flag = false;
            }else {
                holder.setVisible(R.id.ll_all,false);
            }

        }
    }

    @Override
    protected int getItemViewLayoutId(int position, HomePageBean.ListCardImg item) {
        if (type == 0) {
            return R.layout.home_data_item;
        }else {
            return R.layout.home_data_item_v2;
        }
    }
}
