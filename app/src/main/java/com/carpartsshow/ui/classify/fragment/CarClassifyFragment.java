package com.carpartsshow.ui.classify.fragment;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ExpandableListView;

import com.carpartsshow.R;
import com.carpartsshow.base.BaseFragment;
import com.carpartsshow.model.http.bean.ClassificationItemBean;
import com.carpartsshow.ui.classify.adapter.CarClassifyAdapter;
import com.carpartsshow.ui.home.adapter.ClassifyGroupAdapter;
import com.carpartsshow.widgets.AnimatedExpandableListView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;


/**
 * Created by lizhe on 2018/3/27.
 * 分类-分类
 */

public class CarClassifyFragment extends BaseFragment {

    @BindView(R.id.expandable_lv)
    AnimatedExpandableListView expandableListView;

//    private CarClassifyAdapter mAdapter;
    private ClassifyGroupAdapter mAdapter;
    private ArrayList<ClassificationItemBean> list;
    private int type;

    public static CarClassifyFragment newInstance(List<ClassificationItemBean> list){
        CarClassifyFragment myFragment = new CarClassifyFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("list", (ArrayList<? extends Parcelable>) list);
        myFragment.setArguments(bundle);
        return myFragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_car_classify;
    }

    @Override
    protected void init() {
        Bundle bundle = getArguments();
        list =  bundle.getParcelableArrayList("list");

    }

    @Override
    protected void setData() {
        mAdapter = new ClassifyGroupAdapter(getContext());
        expandableListView.setAdapter(mAdapter);
        mAdapter.loadData(list);
        int width = getActivity().getWindowManager().getDefaultDisplay().getWidth();
        expandableListView.setIndicatorBounds(width-40, width-10);

    }


}
