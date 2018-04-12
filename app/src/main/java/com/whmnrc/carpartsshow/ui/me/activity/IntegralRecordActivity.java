package com.whmnrc.carpartsshow.ui.me.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;

import com.whmnrc.carpartsshow.R;
import com.whmnrc.carpartsshow.base.MvpActivity;
import com.whmnrc.carpartsshow.model.http.bean.IntegralRecordBean;
import com.whmnrc.carpartsshow.model.http.bean.LoginBean;
import com.whmnrc.carpartsshow.presenter.me.IntegralRecordPresenter;
import com.whmnrc.carpartsshow.presenter.me.contract.IntegralRecordContract;
import com.whmnrc.carpartsshow.ui.me.adapter.IntegralRecordAdapter;
import com.whmnrc.carpartsshow.util.SpUtil;
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
    @BindView(R.id.vs_empty)
    ViewStub vsEmpty;

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
        mAdapter = new IntegralRecordAdapter(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(mAdapter);
        refresh.autoRefresh();
        refresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                refresh.finishRefresh();
                mPresenter.getRecord(loginBean.getRepairUser_ID(),1);

            }
        });
        refresh.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                refresh.finishLoadmore();
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
        if (list.size() == 0) {
            recyclerView.setVisibility(View.GONE);
            vsEmpty.setVisibility(View.VISIBLE);
        } else {
            vsEmpty.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
        }
        refresh.finishRefresh();
        mAdapter.addFirstDataSet(list);
    }

    @Override
    public void loadMore(List<IntegralRecordBean> list) {
        refresh.finishLoadmore();
        mAdapter.addMoreDataSet(list);
    }

    @Override
    public void showEmpty() {
        if (vsEmpty.getParent() != null) {
            View view = vsEmpty.inflate();
            ImageView imageView = view.findViewById(R.id.iv_empty);
            TextView textView = view.findViewById(R.id.tv_empty_msg);
            imageView.setImageResource(R.drawable.order_empty);
            textView.setText("暂无更多数据~");
        }
    }
}
