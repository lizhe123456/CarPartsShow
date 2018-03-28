package com.carpartsshow.base.adapter;

import android.animation.ObjectAnimator;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: Providing a adapter to implement secondary list base on
 * {@link RecyclerView.Adapter} for {@link RecyclerView}.
 * <!--
 * Author: Rusan
 * Date: 2017/4/20
 * Version: 0.0.1
 * ---------------------------------------------
 * History: 多节点适配器
 * <p>
 * -->
 */

public abstract class SecondaryListAdapter<GVH, SVH extends RecyclerView.ViewHolder> extends RecyclerView
        .Adapter<RecyclerView.ViewHolder> {

    private List<Boolean> groupItemStatus = new ArrayList<>();

    private List<DataTree> dataTrees = new ArrayList<>();

    /**
     * Set new data for adapter to show. It must be called when set new data.
     *
     * @param data New data
     *
     */
    public void notifyNewData(List data) {
        setDataTrees(data);
    }


    /**
     * Set new data for adapter and notify changing.
     *
     * @param dt New data
     *
     */
    private final void setDataTrees(List dt) {
        this.dataTrees = dt;
        initGroupItemStatus(groupItemStatus);
        notifyDataSetChanged();
    }

    /**
     * Initialize the list to false.
     *
     * @param l The list need to initialize
     *
     */
    private void initGroupItemStatus(List l) {
        for (int i = 0; i < dataTrees.size(); i++) {
            l.add(false);
        }
    }


    /**
     * Create group item view holder for onCreateViewHolder.
     *
     * @param parent Provided by onCreateViewHolder.
     *
     */
    public abstract RecyclerView.ViewHolder groupItemViewHolder(ViewGroup parent);

    /**
     * Create subitem view holder for onCreateViewHolder.
     *
     * @param parent Provided by onCreateViewHolder.
     *
     */
    public abstract RecyclerView.ViewHolder subItemViewHolder(ViewGroup parent);


    @Override
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        RecyclerView.ViewHolder viewHolder = null;

        if (viewType == ItemStatus.VIEW_TYPE_GROUPITEM) {

            viewHolder = groupItemViewHolder(parent);

        } else if (viewType == ItemStatus.VIEW_TYPE_SUBITEM) {

            viewHolder = subItemViewHolder(parent);
        }

        return viewHolder;
    }

    /**
     * Update the content of specified group item. The method will called by onBindViewHolder.
     *
     * @param holder The ViewHolder which should be updated to represent the contents of the
     *        item at the given position in the data set.
     *
     * @param groupItemIndex The index of the group item.
     *
     */
    public abstract void onGroupItemBindViewHolder(RecyclerView.ViewHolder holder, int
            groupItemIndex);

    /**
     * Update the content of specified subitem. The method will called by onBindViewHolder.
     *
     * @param holder The ViewHolder which should be updated to represent the contents of the
     *        item at the given position in the data set.
     * @param subItemIndex The index of the subitem.
     *
     */
    public abstract void onSubItemBindViewHolder(RecyclerView.ViewHolder holder, int
            groupItemIndex, int subItemIndex);

    /**
     * The method will be called when the group item clicked.
     *
     * @param isExpand whether is expanded or no the group item clicked.
     * @param holder The holder' s item view clicked.
     * @param groupItemIndex The index of the group item clicked.
     *
     */
    public abstract void onGroupItemClick(Boolean isExpand, GVH holder, int groupItemIndex);

    /**
     * The method will be called when the subitem clicked.
     *
     * @param holder The holder' s item view clicked.
     * @param subItemIndex The index of the subitem clicked.
     *
     */
    public abstract void onSubItemClick(SVH holder, int groupItemIndex, int subItemIndex);

    /**
     * 传入你需要执行动画的view
     * @param holder
     * @return
     */
    public abstract View dropDown(GVH holder);

    @Override
    public final void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {

        final ItemStatus itemStatus = getItemStatusByPosition(position);

        final DataTree dt = dataTrees.get(itemStatus.getGroupItemIndex());

        if ( itemStatus.getViewType() == ItemStatus.VIEW_TYPE_GROUPITEM ) {

            onGroupItemBindViewHolder(holder, itemStatus.getGroupItemIndex());
            dropDown((GVH) holder).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int groupItemIndex = itemStatus.getGroupItemIndex();
                    if ( !groupItemStatus.get(groupItemIndex) ) {

                        groupItemStatus.set(groupItemIndex, true);
                        //显示展开数据
                        notifyItemRangeInserted(holder.getAdapterPosition() + 1, dt.getSubItems
                                ().size());
                        //不需要转动画，注释此处，并注释 abstract 方法 dropDown(GVH holder)
                        rotateOnYCoordinate(dropDown((GVH) holder));
                    } else {

                        groupItemStatus.set(groupItemIndex, false);
                        //影藏展开数据
                        notifyItemRangeRemoved(holder.getAdapterPosition() + 1, dt.getSubItems
                                ().size());
                        //不需要转动画，注释此处
                        dropDown(dropDown((GVH) holder));
                    }

                }
            });

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int groupItemIndex = itemStatus.getGroupItemIndex();

                    if ( !groupItemStatus.get(groupItemIndex) ) {
                        onGroupItemClick(false, (GVH) holder, groupItemIndex);
                        groupItemStatus.set(groupItemIndex, true);


                    } else {
                        onGroupItemClick(true, (GVH) holder, groupItemIndex);
                        groupItemStatus.set(groupItemIndex, false);
                    }

                }
            });

        } else if (itemStatus.getViewType() == ItemStatus.VIEW_TYPE_SUBITEM) {

            onSubItemBindViewHolder(holder, itemStatus.getGroupItemIndex(), itemStatus
                    .getSubItemIndex());

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    onSubItemClick((SVH) holder, itemStatus.getGroupItemIndex(), itemStatus.getSubItemIndex());

                }
            });

        }


    }

    @Override
    public final int getItemCount() {

        int itemCount = 0;

        if (groupItemStatus.size() == 0) {
            return 0;
        }

        for (int i = 0; i < dataTrees.size(); i++) {

            if (groupItemStatus.get(i)) {
                itemCount += dataTrees.get(i).getSubItems().size() + 1;
            } else {
                itemCount++;
            }

        }

        return itemCount;
    }


    @Override
    public final int getItemViewType(int position) {
        return getItemStatusByPosition(position).getViewType();
    }


    /**
     * Get item' s status include view type, group item index and subitem index.
     *
     * @param position Position
     *
     */
    private ItemStatus getItemStatusByPosition(int position) {

        ItemStatus itemStatus = new ItemStatus();

        int count = 0;
        int i = 0;

        for (i = 0; i < groupItemStatus.size(); i++ ) {

            if (count == position) {

                itemStatus.setViewType(ItemStatus.VIEW_TYPE_GROUPITEM);
                itemStatus.setGroupItemIndex(i);
                break;

            } else if (count > position) {

                itemStatus.setViewType(ItemStatus.VIEW_TYPE_SUBITEM);
                itemStatus.setGroupItemIndex(i - 1);
                itemStatus.setSubItemIndex(position - ( count - dataTrees.get(i - 1).getSubItems
                        ().size() ) );
                break;

            }

            count++;

            if (groupItemStatus.get(i)) {

                count += dataTrees.get(i).getSubItems().size();

            }


        }

        if (i >= groupItemStatus.size()) {
            itemStatus.setGroupItemIndex(i - 1);
            itemStatus.setViewType(ItemStatus.VIEW_TYPE_SUBITEM);
            itemStatus.setSubItemIndex(position - ( count - dataTrees.get(i - 1).getSubItems().size
                    () ) );
        }

        return itemStatus;
    }



    private static class ItemStatus {

        public static final int VIEW_TYPE_GROUPITEM = 0;
        public static final int VIEW_TYPE_SUBITEM = 1;

        private int viewType;
        private int groupItemIndex = 0;
        private int subItemIndex = -1;

        public ItemStatus() {
        }

        public int getViewType() {
            return viewType;
        }

        public void setViewType(int viewType) {
            this.viewType = viewType;
        }

        public int getGroupItemIndex() {
            return groupItemIndex;
        }

        public void setGroupItemIndex(int groupItemIndex) {
            this.groupItemIndex = groupItemIndex;
        }

        public int getSubItemIndex() {
            return subItemIndex;
        }

        public void setSubItemIndex(int subItemIndex) {
            this.subItemIndex = subItemIndex;
        }
    }


    /**
     * Created by Rusan on 2017/4/12.
     */

    public final static class DataTree<K, V> {

        private K groupItem;
        private List<V> subItems;

        public DataTree(K groupItem, List<V> subItems) {
            this.groupItem = groupItem;
            this.subItems = subItems;
        }

        public K getGroupItem() {
            return groupItem;
        }

        public List<V> getSubItems() {
            return subItems;
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
}
