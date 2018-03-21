package com.carpartsshow.ui.me.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.TextView;

import com.carpartsshow.R;
import com.carpartsshow.base.MvpActivity;
import com.carpartsshow.model.http.bean.IntergralBean;
import com.carpartsshow.model.http.bean.LoginBean;
import com.carpartsshow.presenter.me.IntergralPresenter;
import com.carpartsshow.presenter.me.contract.IntergralContract;
import com.carpartsshow.ui.me.adapter.IntegralAdapter;
import com.carpartsshow.util.SpUtil;
import com.carpartsshow.util.StatusBarUtil;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by lizhe on 2018/3/15.
 */

public class MyIntegralActivity extends MvpActivity<IntergralPresenter> implements IntergralContract.View {

    @BindView(R.id.my_integral)
    TextView integral;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;

    private IntegralAdapter mAdapter;

    @Override
    protected int setLayout() {
        return R.layout.activity_my_integral;
    }


    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected void setData() {
        integral.setText(getIntent().getStringExtra("integer"));
        LoginBean loginBean = SpUtil.getObject(this,"user");
        mPresenter.getIntergralList(loginBean.getRepairUser_ID(),1);
        mAdapter = new IntegralAdapter(this);
        StaggeredGridLayoutManager linearLayoutManager = new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void stateError() {

    }

    @Override
    public void showContent(IntergralBean intergralBean) {

    }

    @Override
    public void loadMore(IntergralBean intergralBean) {

    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        this.finish();
    }

}
