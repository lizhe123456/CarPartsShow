package com.carpartsshow.ui.home.adapter;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.carpartsshow.R;
import com.carpartsshow.model.http.bean.ClassificationItemBean;
import com.carpartsshow.util.GlideuUtil;
import com.carpartsshow.widgets.AnimatedExpandableListView;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lizhe on 2018/3/29.
 * 二级列表
 */

public class ClassifyGroupAdapter extends AnimatedExpandableListView.AnimatedExpandableListAdapter {

    private Context context;
    private List<ClassificationItemBean> classificationItemBeans = new ArrayList<>();
    private LayoutInflater mInflater;
    private OnOpenListener onOpenListener;
    private OnItemListener onGroupItemListener;

    public ClassifyGroupAdapter(Context context) {
        this.context = context;
        mInflater = LayoutInflater.from(context);
    }

    public void setOnOpenListener(OnOpenListener onOpenListener) {
        this.onOpenListener = onOpenListener;
    }

    public void setOnItemListener(OnItemListener onGroupItemListener) {
        this.onGroupItemListener = onGroupItemListener;
    }

    @Override
    public int getGroupCount() {
        return classificationItemBeans == null ? 0 : classificationItemBeans.size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return classificationItemBeans.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return classificationItemBeans.get(groupPosition).getList().get(childPosition);
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

    public List<ClassificationItemBean> getClassificationItemBeans() {
        return classificationItemBeans;
    }

    public List<ClassificationItemBean.ClassificationItem2Bean> getClassificationItem2BeanList(int groupPosition) {
        return classificationItemBeans.get(groupPosition).getList();
    }

    public void addMore(List<ClassificationItemBean> classificationItemBeans){
        this.classificationItemBeans.addAll(classificationItemBeans);
        notifyDataSetChanged();
    }

    public void loadData(List<ClassificationItemBean> classificationItemBeans){
        this.classificationItemBeans = classificationItemBeans;
        notifyDataSetChanged();
    }

    @Override
    public View getGroupView(final int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GroupItemViewHolder holder;
        if (convertView == null) {
            mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.item_classify, null);
            holder = new GroupItemViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (GroupItemViewHolder) convertView.getTag();
        }
        holder.tvGroupName.setText(getClassificationItemBeans().get(groupPosition).getName());
        GlideuUtil.loadImageView(context,getClassificationItemBeans().get(groupPosition).getCategory_ImgPath(), holder.ivImg);
        holder.ivItemGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOpenListener.open(groupPosition);
            }
        });
        holder.groupLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onGroupItemListener.OnGroupItemClick(getClassificationItemBeans().get(groupPosition));
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
        holder.tvSubName.setText(getClassificationItem2BeanList(groupPosition).get(childPosition).getName());
        holder.nodeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onGroupItemListener.OnSubItemClick(getClassificationItem2BeanList(groupPosition).get(childPosition));
            }
        });
        return convertView;
    }

    @Override
    public int getRealChildrenCount(int groupPosition) {
        return classificationItemBeans.get(groupPosition).getList() == null ? 0 : classificationItemBeans.get(groupPosition).getList().size();
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

    public static class GroupItemViewHolder  {

        TextView tvGroupName;
        ImageView ivImg;
        RelativeLayout groupLayout;
        ImageView ivItemGo;

        public GroupItemViewHolder(View itemView) {
            tvGroupName = itemView.findViewById(R.id.tv_name);
            groupLayout = itemView.findViewById(R.id.rl_group);
            ivItemGo = itemView.findViewById(R.id.item_go);
            ivImg = itemView.findViewById(R.id.item_img);
        }
    }

    public static class SubItemViewHolder {

        TextView tvSubName;
        LinearLayout nodeLayout;

        public SubItemViewHolder(View itemView) {
            tvSubName = (TextView) itemView.findViewById(R.id.tv_node_name);
            nodeLayout = itemView.findViewById(R.id.ll_node_layout);
        }
    }

    //旋转动画
    private void rotateOnYCoordinate(View view) {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(view, "Rotation", 0f, 90f,90f);
        objectAnimator.setDuration(500);
        objectAnimator.setInterpolator(new AccelerateInterpolator()); // 设置插入器
        objectAnimator.reverse();
        objectAnimator.start();
    }

    //还远旋转动画
    private void dropDown(View view) {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(view, "Rotation", 90f, 0f,0f);
        objectAnimator.setDuration(500);
        objectAnimator.setInterpolator(new AccelerateInterpolator());
        objectAnimator.reverse();
        objectAnimator.start();

    }

    public interface OnOpenListener{
        void open(int groupPosition);
    }

    public interface OnItemListener{
        void OnGroupItemClick(ClassificationItemBean classificationItemBean);

        void OnSubItemClick(ClassificationItemBean.ClassificationItem2Bean classificationItem2Bean);
    }

}
