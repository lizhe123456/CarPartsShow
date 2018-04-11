package com.whmnrc.carpartsshow.ui.me.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.whmnrc.carpartsshow.R;
import com.whmnrc.carpartsshow.base.MvpActivity;
import com.whmnrc.carpartsshow.model.http.bean.IntergralShopBean;
import com.whmnrc.carpartsshow.presenter.me.IntegralShopPresenter;
import com.whmnrc.carpartsshow.presenter.me.contract.IntegralShopContract;
import com.whmnrc.carpartsshow.ui.me.adapter.IntegralShopAdapter;
import com.whmnrc.carpartsshow.widgets.CPSToast;
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
    EditText etSearch;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;

    private IntegralShopAdapter mAdapter;
    private String searchValue;
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
        searchValue = etSearch.getText().toString().trim();
        mPresenter.getIntegralShop(searchValue,1);
        mAdapter = new IntegralShopAdapter(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(mAdapter);
        refresh.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                refresh.finishLoadmore(3000);
                mPresenter.getIntegralShop(searchValue,2);
            }
        });

        refresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                refresh.finishRefresh(3000);
                mPresenter.getIntegralShop(searchValue,1);
            }
        });

        etSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    searchValue = etSearch.getText().toString().trim();
                    mPresenter.getIntegralShop(searchValue,1);
                    InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
                    return true;
                }
                return false;
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
        if (shopBean.getIstIntegerGoods().size() == 0){
            CPSToast.showText(this,"暂无更多..");
        }
        mAdapter.addFirstDataSet(shopBean);
        refresh.finishRefresh();
    }

    @Override
    public void loadMore(IntergralShopBean shopBean) {
        mAdapter.addMore(shopBean);
        refresh.finishLoadmore();
    }
}
