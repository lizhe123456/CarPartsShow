package com.carpartsshow.ui.classify.fragment;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.carpartsshow.R;
import com.carpartsshow.base.BaseFragment;
import com.carpartsshow.model.http.bean.ClassificationBean;
import com.carpartsshow.model.http.bean.ClassificationItemBean;
import com.carpartsshow.ui.classify.adapter.brand.BrandAdapter;
import com.carpartsshow.view.SideBar;
import com.carpartsshow.widgets.CPSToast;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by lizhe on 2018/3/27.
 * 分类-品牌
 */

public class BrandFragment extends BaseFragment {

    @BindView(R.id.listView)
    ListView listView;
    @BindView(R.id.right_side)
    SideBar rightSide;

    private BrandAdapter mAdapter;

    private List<ClassificationBean.ListBrandBean> mListBrandBeans;

    public static BrandFragment newInstance(List<ClassificationBean.ListBrandBean> list){
        BrandFragment myFragment = new BrandFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("list", (ArrayList<? extends Parcelable>) list);
        myFragment.setArguments(bundle);
        return myFragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_brand;
    }

    @Override
    protected void init() {
        Bundle bundle = getArguments();
        mListBrandBeans = bundle.getParcelableArrayList("list");

    }

    @Override
    protected void setData() {
        mAdapter = new BrandAdapter(getContext(), mListBrandBeans);
        listView.setAdapter(mAdapter);
        //设置右侧触摸监听
        rightSide.setOnTouchingLetterChangedListener(new SideBar.OnTouchingLetterChangedListener() {
            @Override
            public void onTouchingLetterChanged(String s) {
                //该字母首次出现的位置
                int position = mAdapter.getPositionForSection(s.charAt(0));
                if (position != -1) {
                    listView.setSelection(position + 1);
                }
            }
        });

        //ListView的点击事件
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
//                mTvTitle.setText(((ContactSortModel) adapter.getItem(position - 1)).getName());
                CPSToast.showText(getContext().getApplicationContext(),mAdapter.getItem(position).getCompany_FirstWord());
            }
        });

    }


}
