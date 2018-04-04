package com.carpartsshow.ui.me.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;

import com.carpartsshow.R;
import com.carpartsshow.base.MvpActivity;
import com.carpartsshow.model.http.bean.IntegralRecordBean;
import com.carpartsshow.model.http.bean.LoginBean;
import com.carpartsshow.presenter.me.IntegralRecordPresenter;
import com.carpartsshow.presenter.me.contract.IntegralRecordContract;
import com.carpartsshow.ui.me.adapter.IntegralRecordAdapter;
import com.carpartsshow.util.SpUtil;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.List;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by lizhe on 2018/3/16.
 * 我的兑换记录
 */

public class IntegralRecordActivity extends MvpActivity<IntegralRecordPresenter> implements IntegralRecordContract.View {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;
    private IntegralRecordAdapter mAdapter;
    LoginBean loginBean;

    @Override
    protected int setLayout() {
        return R.layout.activity_integral_record;
    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected void setData() {
        loginBean = SpUtil.getObject(this,"user");
        mPresenter.getRecord(loginBean.getRepairUser_ID(),1);
        mAdapter = new IntegralRecordAdapter(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(mAdapter);
        refresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                refresh.finishRefresh(3000);
                mPresenter.getRecord(loginBean.getRepairUser_ID(),1);

            }
        });
        refresh.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                refresh.finishLoadmore(3000);
                mPresenter.getRecord(loginBean.getRepairUser_ID(),2);
            }
        });
    }

    @Override
    public void stateError() {

    }


    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        this.finish();
    }

    @Override
    public void showContent(List<IntegralRecordBean> list) {
        refresh.finishRefresh();
        mAdapter.addFirstDataSet(list);
    }

    @Override
    public void loadMore(List<IntegralRecordBean> list) {
        refresh.finishLoadmore();
        mAdapter.addMoreDataSet(list);
    }
}
