package com.carpartsshow.ui.me.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.carpartsshow.R;
import com.carpartsshow.base.MvpActivity;
import com.carpartsshow.model.http.bean.IntergralShopBean;
import com.carpartsshow.presenter.me.IntegralShopPresenter;
import com.carpartsshow.presenter.me.contract.IntegralShopContract;
import com.carpartsshow.ui.me.adapter.IntegralShopAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by lizhe on 2018/3/16.
 * 积分商城
 */

public class IntegralShopActivity extends MvpActivity<IntegralShopPresenter> implements IntegralShopContract.View {

    @BindView(R.id.et_search)
    TextView etSearch;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;

    private IntegralShopAdapter mAdapter;

    public static void start(Context context) {
        Intent starter = new Intent(context, IntegralShopActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_integral_shop;
    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected void setData() {
        mPresenter.getIntegralShop(1);
        mAdapter = new IntegralShopAdapter(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(mAdapter);
        refresh.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                refresh.finishLoadmore(3000);
                mPresenter.getIntegralShop(2);
            }
        });

        refresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                refresh.finishRefresh(3000);
                mPresenter.getIntegralShop(1);
            }
        });
    }

    @OnClick({R.id.iv_back, R.id.iv_record,R.id.search_bar})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                this.finish();
                break;
            case R.id.iv_record:
                Intent intent = new Intent();
                intent.setClass(this,IntegralRecordActivity.class);
                startActivity(intent);
                break;
            case R.id.search_bar:
                Intent intent1 = new Intent();
                intent1.setClass(this,IntegralGoodsActivity.class);
                startActivity(intent1);
                break;
        }
    }

    @Override
    public void stateError() {

    }

    @Override
    public void showCentent(IntergralShopBean shopBean) {
        mAdapter.addFirstDataSet(shopBean);
        refresh.finishRefresh();
    }

    @Override
    public void loadMore(IntergralShopBean shopBean) {
        mAdapter.addMore(shopBean);
        refresh.finishLoadmore();
    }
}
