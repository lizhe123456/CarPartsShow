package com.whmnrc.carpartsshow.ui.classify.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SectionIndexer;
import android.widget.TextView;

import com.whmnrc.carpartsshow.R;
import com.whmnrc.carpartsshow.base.adapter.SecondaryListAdapter;
import com.whmnrc.carpartsshow.model.http.bean.ClassificationBean;
import com.whmnrc.carpartsshow.util.GlideuUtil;

import java.util.ArrayList;
import java.util.List;



/**
 * Created by lizhe on 2018/3/27.
 */

public class CarBrandAdapter extends SecondaryListAdapter<CarBrandAdapter.GroupItemViewHolder, CarClassifyAdapter.SubItemViewHolder> implements SectionIndexer {

    private Context context;

    private List<DataTree<ClassificationBean.ListCarBrandBean,ClassificationBean.VCJListBean>> dts = new ArrayList<>();

    public CarBrandAdapter(Context context) {
        this.context = context;
    }

    public void setData(ArrayList<ClassificationBean.ListCarBrandBean> arrayList) {
        List<DataTree<ClassificationBean.ListCarBrandBean,ClassificationBean.VCJListBean>> dataTrees = new ArrayList<>();
        for (ClassificationBean.ListCarBrandBean c : arrayList) {
            DataTree<ClassificationBean.ListCarBrandBean,ClassificationBean.VCJListBean> d = new DataTree<>(c,c.getListBeans());
            dataTrees.add(d);
        }
        this.dts = dataTrees;
        notifyNewData(dataTrees);
    }

    @Override
    public RecyclerView.ViewHolder groupItemViewHolder(ViewGroup parent) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_car_brand, parent, false);
        return new CarBrandAdapter.GroupItemViewHolder(v);
    }

    @Override
    public RecyclerView.ViewHolder subItemViewHolder(ViewGroup parent) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_classify_node, parent, false);
        return new CarClassifyAdapter.SubItemViewHolder(v);
    }

    @Override
    public void onGroupItemBindViewHolder(RecyclerView.ViewHolder holder, int groupItemIndex) {
        ((GroupItemViewHolder) holder).tvTitle.setText(dts.get(groupItemIndex).getGroupItem().getName());
        GlideuUtil.loadImageView(context,dts.get(groupItemIndex).getGroupItem().getCarBrand_ImgPath(),((GroupItemViewHolder) holder).ivImg);
        int section = getSectionForPosition(groupItemIndex);
        if (groupItemIndex == getPositionForSection(section)) {
            ((GroupItemViewHolder) holder).tvLetter.setVisibility(View.VISIBLE);
            ((GroupItemViewHolder) holder).tvLetter.setText(this.dts.get(groupItemIndex).getGroupItem().getCarBrand_FirstCode());
        } else {
            ((GroupItemViewHolder) holder).tvLetter.setVisibility(View.GONE);
        }

    }

    @Override
    public void onSubItemBindViewHolder(RecyclerView.ViewHolder holder, int groupItemIndex, int subItemIndex) {
        ((CarClassifyAdapter.SubItemViewHolder) holder).tvSubName.setText(dts.get(groupItemIndex).getSubItems().get(subItemIndex).getName());
    }

    @Override
    public void onGroupItemClick(Boolean isExpand, GroupItemViewHolder holder, int groupItemIndex) {

    }


    @Override
    public void onSubItemClick(CarClassifyAdapter.SubItemViewHolder holder, int groupItemIndex, int subItemIndex) {

    }

    @Override
    public View dropDown(GroupItemViewHolder holder) {
        return holder.ivItemGo;
    }


    public int getSectionForPosition(int position) {
        return dts.get(position).getGroupItem().getCarBrand_FirstCode().charAt(0);
    }

    public int getPositionForSection(int section) {
        for (int i = 0; i < getItemCount(); i++) {
            String sortStr = dts.get(i).getGroupItem().getCarBrand_FirstCode();
            char firstChar = sortStr.toUpperCase().charAt(0);
            if (firstChar == section) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Object[] getSections() {
        return null;
    }


    public static class GroupItemViewHolder extends RecyclerView.ViewHolder {

        ImageView ivImg;
        RelativeLayout groupLayout;
        ImageView ivItemGo;
        TextView tvLetter;
        TextView tvTitle;

        public GroupItemViewHolder(View itemView) {
            super(itemView);
            tvLetter = itemView.findViewById(R.id.tv_catagory);
            groupLayout = itemView.findViewById(R.id.rl_layout);
            ivItemGo = itemView.findViewById(R.id.iv_goto);
            ivImg = itemView.findViewById(R.id.iv_img);
            tvTitle = itemView.findViewById(R.id.tv_name);
        }
    }
}
