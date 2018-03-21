package com.carpartsshow.ui.me.fragment;

import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import com.carpartsshow.R;
import com.carpartsshow.base.BaseFragment;
import com.carpartsshow.ui.me.adapter.IntegralAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import butterknife.BindView;

/**
 * Created by lizhe on 2018/3/15.
 */

public class WaitRepayFragment extends BaseFragment {
    @BindView(R.id.my_moe)
    TextView myMoe;
    @BindView(R.id.tv_num)
    TextView tvNum;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;

    private IntegralAdapter mAdapter;

    @Override
    protected int setLayout() {
        return R.layout.fragment_wait_repay;
    }

    @Override
    protected void init() {

    }

    @Override
    protected void setData() {

    }

}
