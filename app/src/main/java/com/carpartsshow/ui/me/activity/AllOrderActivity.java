package com.carpartsshow.ui.me.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.carpartsshow.R;
import com.carpartsshow.base.MvpActivity;
import com.carpartsshow.model.http.bean.LoginBean;
import com.carpartsshow.model.http.bean.OrderListBean;
import com.carpartsshow.presenter.me.MyOrderPresenter;
import com.carpartsshow.presenter.me.contract.MyOrderContract;
import com.carpartsshow.ui.me.fragment.order.adapter.AllOrderAdapter;
import com.carpartsshow.ui.me.fragment.order.base.OrderAdapter;
import com.carpartsshow.ui.shopping.activity.ConfirmOrderActivity;
import com.carpartsshow.util.SpUtil;
import com.google.gson.Gson;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by lizhe on 2018/4/2.
 */

public class AllOrderActivity extends MvpActivity<MyOrderPresenter> implements MyOrderContract.View {

    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;
    @BindView(R.id.vs_empty)
    ViewStub vsEmpty;

    private LoginBean loginBean;
    protected OrderAdapter mAdapter;

    public static void start(Context context) {
        Intent starter = new Intent(context, AllOrderActivity.class);
        context.startActivity(starter);
    }

    @Override
    public void stateError() {

    }

    @Override
    public void showData(OrderListBean orderListBean) {
        mAdapter.addFirstDataSet(orderListBean.getData());
        refresh.finishRefresh();
    }

    @Override
    public void loadMore(OrderListBean orderListBean) {
        mAdapter.addMoreDataSet(orderListBean.getData());
        refresh.finishLoadmore();
    }

    @Override
    public void updateData() {
        refresh.autoRefresh(3000);
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_all_order;
    }

    @Override
    protected void setData() {
        title.setText("全部订单");
        loginBean = SpUtil.getObject(this,"user");
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new AllOrderAdapter(this,mPresenter);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setNestedScrollingEnabled(false);
        mPresenter.getOrderList(loginBean.getRepairUser_ID(),0,1);
        refresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                mPresenter.getOrderList(loginBean.getRepairUser_ID(), 0, 1);
                refresh.finishRefresh(3000);
            }
        });

        refresh.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                mPresenter.getOrderList(loginBean.getRepairUser_ID(), 0, 2);
                refresh.finishLoadmore(3000);
            }
        });

        mAdapter.setOnOrderListener(new OrderAdapter.OnOrderListener() {
            @Override
            public void applyCustomerServiceClick(OrderListBean.DataBean item) {

            }

            @Override
            public void payClick(OrderListBean.DataBean item) {
                String json = new Gson().toJson(item);
                ConfirmOrderActivity.start(AllOrderActivity.this,json,1);
            }

            @Override
            public void customerServicePhoneClick(OrderListBean.DataBean item) {

            }

            @Override
            public void lookProgress(OrderListBean.DataBean item) {

            }
        });
    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        this.finish();
    }


}