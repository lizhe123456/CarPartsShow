package com.carpartsshow.ui.classify.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.carpartsshow.R;
import com.carpartsshow.base.adapter.SecondaryListAdapter;
import com.carpartsshow.model.http.bean.ClassificationItemBean;
import com.carpartsshow.util.GlideuUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lizhe on 2018/3/27.
 */

public class CarClassifyAdapter extends SecondaryListAdapter<CarClassifyAdapter.GroupItemViewHolder, CarClassifyAdapter.SubItemViewHolder> {

    private Context context;

    private List<DataTree<ClassificationItemBean,ClassificationItemBean.ClassificationItem2Bean>> dts = new ArrayList<>();

    public CarClassifyAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<ClassificationItemBean> datas) {
        List<DataTree<ClassificationItemBean,ClassificationItemBean.ClassificationItem2Bean>> dataTrees = new ArrayList<>();
        for (ClassificationItemBean c : datas) {
            DataTree<ClassificationItemBean,ClassificationItemBean.ClassificationItem2Bean> d = new DataTree<>(c,c.getList());
            dataTrees.add(d);
        }
        dts = dataTrees;
        notifyNewData(dataTrees);
    }

    @Override
    public RecyclerView.ViewHolder groupItemViewHolder(ViewGroup parent) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_classify, parent, false);

        return new GroupItemViewHolder(v);
    }

    @Override
    public RecyclerView.ViewHolder subItemViewHolder(ViewGroup parent) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_classify_node, parent, false);

        return new SubItemViewHolder(v);
    }

    @Override
    public void onGroupItemBindViewHolder(RecyclerView.ViewHolder holder, int groupItemIndex) {
        ((GroupItemViewHolder) holder).tvGroupName.setText(dts.get(groupItemIndex).getGroupItem().getName());
        GlideuUtil.loadImageView(context,dts.get(groupItemIndex).getGroupItem().getCategory_ImgPath(),((GroupItemViewHolder) holder).ivImg);

    }

    @Override
    public void onSubItemBindViewHolder(RecyclerView.ViewHolder holder, int groupItemIndex, int subItemIndex) {

        ((SubItemViewHolder) holder).tvSubName.setText(dts.get(groupItemIndex).getSubItems().get(subItemIndex).getName());

    }

    @Override
    public void onGroupItemClick(Boolean isExpand, GroupItemViewHolder holder, int groupItemIndex) {
        Toast.makeText(context, "group item " + String.valueOf(groupItemIndex) + " is expand " +
                String.valueOf(isExpand), Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onSubItemClick(SubItemViewHolder holder, int groupItemIndex, int subItemIndex) {
        Toast.makeText(context, "sub item " + String.valueOf(subItemIndex) + " in group item " +
                String.valueOf(groupItemIndex), Toast.LENGTH_SHORT).show();

    }

    public static class GroupItemViewHolder extends RecyclerView.ViewHolder {

        TextView tvGroupName;
        ImageView ivImg;
        RelativeLayout groupLayout;
        ImageView ivItemGo;

        public GroupItemViewHolder(View itemView) {
            super(itemView);
            tvGroupName = itemView.findViewById(R.id.tv_name);
            groupLayout = itemView.findViewById(R.id.rl_group);
            ivItemGo = itemView.findViewById(R.id.item_go);
            ivImg = itemView.findViewById(R.id.item_img);
        }
    }

    public static class SubItemViewHolder extends RecyclerView.ViewHolder {

        TextView tvSubName;
        LinearLayout nodeLayout;

        public SubItemViewHolder(View itemView) {
            super(itemView);
            tvSubName = (TextView) itemView.findViewById(R.id.tv_node_name);
            nodeLayout = itemView.findViewById(R.id.ll_node_layout);
        }
    }

}
