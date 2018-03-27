package com.carpartsshow.ui.home.fragment;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import com.carpartsshow.R;
import com.carpartsshow.base.BaseFragment;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import butterknife.BindView;

/**
 * Created by lizhe on 2018/3/27.
 */

public class GoodsFragment extends BaseFragment {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;

    public static GoodsFragment newInstance(String s){
        GoodsFragment myFragment = new GoodsFragment();
        Bundle bundle = new Bundle();
        bundle.putString("list",s);
        myFragment.setArguments(bundle);
        return myFragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_goods;
    }

    @Override
    protected void init() {

    }

    @Override
    protected void setData() {

    }
}
