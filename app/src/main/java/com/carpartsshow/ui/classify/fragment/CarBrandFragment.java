package com.carpartsshow.ui.classify.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.carpartsshow.R;
import com.carpartsshow.base.BaseFragment;
import com.carpartsshow.model.http.bean.ClassificationBean;
import com.carpartsshow.ui.classify.adapter.CarBrandAdapter;
import com.carpartsshow.ui.classify.adapter.brand.BrandComparator;
import com.carpartsshow.ui.classify.adapter.brand.CarBrandComparator;
import com.carpartsshow.util.PinyinUtils;
import com.carpartsshow.view.SideBar;
import com.carpartsshow.view.XRecyclerView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by lizhe on 2018/3/27.
 * 分类-车型
 */

public class CarBrandFragment extends BaseFragment {


    @BindView(R.id.recyclerView)
    XRecyclerView recyclerView;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;
    @BindView(R.id.right_side)
    SideBar rightSide;
    @BindView(R.id.dialog)
    TextView dialog;

    private ArrayList<ClassificationBean.ListCarBrandBean> list;
    private CarBrandAdapter mAdapter;

    public static CarBrandFragment newInstance(ArrayList<ClassificationBean.ListCarBrandBean> list) {
        CarBrandFragment myFragment = new CarBrandFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("list", list);
        myFragment.setArguments(bundle);
        return myFragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_car_brand;
    }

    @Override
    protected void init() {
        Bundle bundle = getArguments();
        list = bundle.getParcelableArrayList("list");
        filledData(list);
        rightSide.setTextView(dialog);
    }

    @Override
    protected void setData() {
        mAdapter = new CarBrandAdapter(getContext());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        Collections.sort(list,new CarBrandComparator());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mAdapter);
        mAdapter.setData(list);
        //设置右侧触摸监听
        rightSide.setOnTouchingLetterChangedListener(new SideBar.OnTouchingLetterChangedListener() {
            @Override
            public void onTouchingLetterChanged(String s) {
                //该字母首次出现的位置
                int position = mAdapter.getPositionForSection(s.charAt(0));
                if (position != -1) {
                    recyclerView.scrollToPosition(position + 1);
                }
            }
        });

    }

    private List<ClassificationBean.ListCarBrandBean> filledData(List<ClassificationBean.ListCarBrandBean> date) {
        List<ClassificationBean.ListCarBrandBean> mSortList = new ArrayList<>();
        ArrayList<String> indexString = new ArrayList<>();

        for (int i = 0; i < date.size(); i++) {
            ClassificationBean.ListCarBrandBean sortModel = new ClassificationBean.ListCarBrandBean();
            String pinyin = PinyinUtils.getPingYin(date.get(i).getCarBrand_FirstCode());
            String sortString = pinyin.substring(0, 1).toUpperCase();
            if (sortString.matches("[A-Z]")) {
                sortModel.setCarBrand_FirstCode(sortString.toUpperCase());
                if (!indexString.contains(sortString)) {
                    indexString.add(sortString);
                }
            }
            mSortList.add(sortModel);
        }
        Collections.sort(indexString);
        rightSide.setIndexText(indexString);
        return mSortList;
    }

}
