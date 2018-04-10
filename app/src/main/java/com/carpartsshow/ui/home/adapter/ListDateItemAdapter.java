package com.carpartsshow.ui.home.adapter;

import android.content.Context;
import android.view.View;

import com.carpartsshow.R;
import com.carpartsshow.base.adapter.BaseAdapter;
import com.carpartsshow.base.adapter.BaseViewHolder;
import com.carpartsshow.model.http.bean.HomePageBean;
import com.carpartsshow.ui.home.activity.GoodsSearchActivity;

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
                holder.setText(R.id.tv_title0, lists.get(0).get(0).getTitle()).setText(R.id.tv_search0, getDataSource().get(0).getSearch()).setGlieuImage(R.id.iv_img0, getDataSource().get(0).getImgUrl());
                holder.setText(R.id.tv_title1, lists.get(0).get(1).getTitle()).setText(R.id.tv_search1, getDataSource().get(1).getSearch()).setGlieuImage(R.id.iv_img1, getDataSource().get(1).getImgUrl());
                holder.setText(R.id.tv_title2, lists.get(0).get(2).getTitle()).setText(R.id.tv_search2, getDataSource().get(2).getSearch()).setGlieuImage(R.id.iv_img2, getDataSource().get(2).getImgUrl());
                holder.setText(R.id.tv_title3, lists.get(0).get(3).getTitle()).setText(R.id.tv_search3, getDataSource().get(3).getSearch()).setGlieuImage(R.id.iv_img3, getDataSource().get(3).getImgUrl());
                holder.setText(R.id.tv_title4, lists.get(0).get(4).getTitle()).setText(R.id.tv_search4, getDataSource().get(4).getSearch()).setGlieuImage(R.id.iv_img4, getDataSource().get(4).getImgUrl());
                holder.setOnClickListener(R.id.ll_goods_0, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        GoodsSearchActivity.start(getContext(), lists.get(0).get(0).getSearch());
                    }
                });
                holder.setOnClickListener(R.id.ll_goods_1, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        GoodsSearchActivity.start(getContext(), lists.get(0).get(1).getSearch());
                    }
                });
                holder.setOnClickListener(R.id.ll_goods_2, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        GoodsSearchActivity.start(getContext(), lists.get(0).get(2).getSearch());
                    }
                });
                holder.setOnClickListener(R.id.ll_goods_3, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        GoodsSearchActivity.start(getContext(), lists.get(0).get(3).getSearch());
                    }
                });
                holder.setOnClickListener(R.id.ll_goods_4, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        GoodsSearchActivity.start(getContext(), lists.get(0).get(4).getSearch());
                    }
                });
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
