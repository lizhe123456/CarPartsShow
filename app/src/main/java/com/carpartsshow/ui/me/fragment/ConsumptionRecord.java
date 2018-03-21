package com.carpartsshow.ui.me.fragment;

import android.support.v7.widget.RecyclerView;
import com.carpartsshow.R;
import com.carpartsshow.base.BaseFragment;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import butterknife.BindView;

/**
 * Created by lizhe on 2018/3/15.
 */

public class ConsumptionRecord extends BaseFragment {
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;

    @Override
    protected int setLayout() {
        return R.layout.fragment_consumption_record;
    }

    @Override
    protected void init() {

    }

    @Override
    protected void setData() {

    }

}
