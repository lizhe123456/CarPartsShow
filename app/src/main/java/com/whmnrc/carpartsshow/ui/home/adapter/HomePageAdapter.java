package com.whmnrc.carpartsshow.ui.home.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.whmnrc.carpartsshow.R;
import com.whmnrc.carpartsshow.base.adapter.BaseViewHolder;
import com.whmnrc.carpartsshow.model.http.bean.HomePageBean;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

/**
 * Created by lizhe on 2018/3/21.
 * 首页适配器，数据需要自行排序处理HomePageBean
 * 确认item位置
 */

public class HomePageAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private Context mContext;
    private LayoutInflater layoutInflater;
    private List<Object> mData = new ArrayList<>();

    public HomePageAdapter(Context context) {
        mContext = context;
        layoutInflater = LayoutInflater.from(context);
    }
    

    private int getItemViewLayoutId(int viewType) {
        if (viewType == 1) {
            return R.layout.home_item_category;
        }else if (viewType == 2){
            return R.layout.home_item_listnotice;
        }else if (viewType == 4){
            return R.layout.home_item_listseckillgoods;
        }else if (viewType == 6){
            return R.layout.home_item_listdateitem;
        }else if (viewType == 5){
            return R.layout.home_item_offernar;
        }else if (viewType == 3){
            return R.layout.home_item_timelimit;
        }else {
            return 0;
        }
    }

    public void addData(@Nullable List<Object> list){
        mData = list;
        notifyDataSetChanged();
    }

    public void loadMore(@Nullable List<Object> list){
        mData.addAll(list);
        notifyDataSetChanged();
    }


    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (getItemViewLayoutId(viewType) == 0){
            return null;
        }
        BaseViewHolder baseViewHolder  = new BaseViewHolder(layoutInflater.inflate(getItemViewLayoutId(viewType), parent, false), mContext);
        return baseViewHolder;
    }

    public LayoutInflater getLayoutInflater() {
        return layoutInflater;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        if (getItemViewType(position) == 1){
            List<HomePageBean.ListFirstCategoryBean> list = (List<HomePageBean.ListFirstCategoryBean>) mData.get(position);
            HomeCategoryAdapter adapter = new HomeCategoryAdapter(mContext);
            RecyclerView recyclerView = holder.getView(R.id.vp_home_category);
            GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext,2);
            gridLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            recyclerView.setAdapter(adapter);
            adapter.addFirstDataSet(list);
        }else if (getItemViewType(position) == 2){
//            List<HomePageBean.ListNoticeBean> list = (List<HomePageBean.ListNoticeBean>) mData.get(position);
//            ViewFlipper viewFlipper = holder.getView(R.id.vf_news);
//            for (HomePageBean.ListNoticeBean bean : list) {
//                TextView textView = new TextView(mContext);
//                textView.setTextColor(mContext.getResources().getColor(R.color.tv_000));
//                textView.setTextSize(15);
//                textView.setText(bean.getNotice_Title());
//                viewFlipper.addView(textView);
//            }
        }else if (getItemViewType(position) == 3){
            holder.setOnClickListener(R.id.tv_go, new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }else if (getItemViewType(position) == 4){
            List<HomePageBean.ListSeckillGoodsBean> list = (List<HomePageBean.ListSeckillGoodsBean>) mData.get(position);
            RecyclerView recyclerView = holder.getView(R.id.recyclerView);
            SeckillGoodsAdapter adapter = new SeckillGoodsAdapter(mContext);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(adapter);
            adapter.addFirstDataSet(list);
        }else if (getItemViewType(position) == 5){
            List<HomePageBean.ListCradBean> list = (List<HomePageBean.ListCradBean>) mData.get(position);
            RecyclerView recyclerView = holder.getView(R.id.recyclerView);
            LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
            layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            recyclerView.setLayoutManager(layoutManager);
            SpecialOfferAdapter adapter = new SpecialOfferAdapter(mContext);
            recyclerView.setAdapter(adapter);
//            adapter.addFirstDataSet(list);
        }else if (getItemViewType(position) == 6){
//            List<HomePageBean.ListDateItemBean> list = (List<HomePageBean.ListDateItemBean>) mData.get(position);
//            RecyclerView recyclerView = holder.getView(R.id.recyclerView);
////            ListDateItemAdapter adapter = new ListDateItemAdapter(mContext);
//            recyclerView.setAdapter(adapter);
//            View view = LayoutInflater.from(mContext).inflate(R.layout.img_layout,null);
//            adapter.addHeaderView(view);
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    public List<Object> getmData() {
        return mData;
    }

    @Override
    public int getItemViewType(int position) {
        Object item = mData.get(position);
        ArrayList itemHome = null;
        if (item instanceof ArrayList){
            itemHome = (ArrayList) getmData().get(position);
        }

        if (itemHome == null || itemHome.size() == 0){
            return 0;
        }
        if (itemHome.get(0) instanceof HomePageBean.ListFirstCategoryBean) {
            return 1;
        }else if (itemHome.get(0) instanceof HomePageBean.ListNoticeBean){
            return 2;
        }else if (itemHome.get(0) instanceof HomePageBean.ListSeckillGoodsBean){
            return 4;
        }else if (itemHome.get(0) instanceof HomePageBean.ListDateItemBean){
            return 6;
        }else if (itemHome.get(0) instanceof HomePageBean.ListCradBean){
            return 5;
        }else if (item instanceof HomePageBean.TimeLimit){
            return 3;
        }else {
            return 0;
        }
    }
}
