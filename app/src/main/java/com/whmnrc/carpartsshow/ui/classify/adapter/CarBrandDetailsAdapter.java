package com.whmnrc.carpartsshow.ui.classify.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.whmnrc.carpartsshow.R;
import com.whmnrc.carpartsshow.model.http.bean.CarFilterBean;
import com.whmnrc.carpartsshow.widgets.AnimatedExpandableListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lizhe on 2018/3/30.
 */

public class CarBrandDetailsAdapter extends AnimatedExpandableListView.AnimatedExpandableListAdapter   {


    private Context context;
    private List<CarFilterBean.ListCXIBean>dts = new ArrayList<>();


    private LayoutInflater mInflater;
    private OnOpenListener onOpenListener;
    private OnItemListener onGroupItemListener;

    public CarBrandDetailsAdapter(Context context) {
        this.context = context;
        mInflater = LayoutInflater.from(context);
    }

    public void setOnOpenListener(OnOpenListener onOpenListener) {
        this.onOpenListener = onOpenListener;
    }

    public void setOnItemListener(OnItemListener onGroupItemListener) {
        this.onGroupItemListener = onGroupItemListener;
    }

    public List<CarFilterBean.ListCXIBean>getDts() {
        return dts;
    }

    public void loadData(List<CarFilterBean.ListCXIBean>dts){
        this.dts.addAll(dts);
        notifyDataSetChanged();
    }


    @Override
    public View getGroupView(final int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GroupItemViewHolder holder;
        if (convertView == null) {
            mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.item_car_brand, null);
            holder = new GroupItemViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (GroupItemViewHolder) convertView.getTag();
        }
        holder.tvTitle.setText(getDts().get(groupPosition).getName());
        holder.ivImg.setVisibility(View.GONE);
        holder.tvLetter.setVisibility(View.GONE);
        holder.ivItemGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOpenListener.open(groupPosition);
            }
        });
        holder.groupLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onGroupItemListener.OnGroupItemClick(getDts().get(groupPosition));
            }
        });
        return convertView;
    }

    @Override
    public View getRealChildView(final int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        SubItemViewHolder holder;
        if (convertView == null) {
            mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.item_classify_node, null);
            holder = new SubItemViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (SubItemViewHolder) convertView.getTag();
        }
        holder.tvSubName.setText(getDts().get(groupPosition).getListCars().get(childPosition).getName());
        holder.nodeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onGroupItemListener.OnSubItemClick(getDts().get(groupPosition),getDts().get(groupPosition).getListCars().get(childPosition));
            }
        });
        if (childPosition == getDts().get(groupPosition).getListCars().size()-1){
            holder.xian.setVisibility(View.GONE);
        }
        return convertView;
    }

    @Override
    public int getRealChildrenCount(int groupPosition) {
        return getDts().get(groupPosition).getListCars().size();
    }

    @Override
    public int getGroupCount() {
        return getDts().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return getDts().get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return getDts().get(groupPosition).getListCars().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }
    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
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

    public static class SubItemViewHolder extends RecyclerView.ViewHolder {

        TextView tvSubName;
        LinearLayout nodeLayout;
        View xian;

        public SubItemViewHolder(View itemView) {
            super(itemView);
            tvSubName = (TextView) itemView.findViewById(R.id.tv_node_name);
            nodeLayout = itemView.findViewById(R.id.ll_node_layout);
            xian = itemView.findViewById(R.id.xian);
        }
    }

    public interface OnOpenListener{
        void open(int groupPosition);
    }

    public interface OnItemListener{
        void OnGroupItemClick(CarFilterBean.ListCXIBean listCXIBean);

        void OnSubItemClick(CarFilterBean.ListCXIBean listCXIBean, CarFilterBean.ListCXIBean.ListCarsBean listCarsBean);
    }
}
