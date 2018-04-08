package com.carpartsshow.ui.me.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import com.carpartsshow.R;
import com.carpartsshow.base.BaseActivity;
import com.carpartsshow.base.MvpActivity;
import com.carpartsshow.base.adapter.BaseAdapter;
import com.carpartsshow.model.http.bean.IntergralShopBean;
import com.carpartsshow.model.http.bean.LoginBean;
import com.carpartsshow.presenter.me.IntegralGoodsPresenter;
import com.carpartsshow.presenter.me.contract.IntegralGoodsContract;
import com.carpartsshow.ui.home.activity.GoodsDetailsActivity;
import com.carpartsshow.ui.home.activity.GoodsSearchActivity;
import com.carpartsshow.ui.me.adapter.GoodsAdapter;
import com.carpartsshow.util.SpUtil;
import com.carpartsshow.widgets.CPSToast;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by lizhe on 2018/3/16.
 * 积分兑换
 */

public class IntegralGoodsActivity extends MvpActivity<IntegralGoodsPresenter> implements IntegralGoodsContract.View {

    @BindView(R.id.et_search)
    EditText etSearch;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;

    private GoodsAdapter mAdapter;

    private String textMsg;
    private String userId;
    private String type;
    private String value;
    public static void start(Context context) {
        Intent starter = new Intent(context, IntegralGoodsActivity.class);
        context.startActivity(starter);
    }

    public static void start(Context context,String type) {
        Intent starter = new Intent(context, IntegralGoodsActivity.class);
        starter.putExtra("type",type);
        context.startActivity(starter);
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_integral_goods;
    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected void setData() {
        LoginBean loginBean = SpUtil.getObject(this,"user");
        userId = loginBean.getRepairUser_ID();
        type = getIntent().getStringExtra("type");
        mAdapter = new GoodsAdapter(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(mAdapter);
        refresh.autoRefresh();
        etSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH){
                    textMsg = etSearch.getText().toString().trim();
                    mPresenter.getGoodsInfo(1,textMsg,userId,type);
                    return true;
                }
                return false;
            }
        });
        refresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                refresh.finishRefresh(3000);
                etSearch.setText("");
                if (TextUtils.isEmpty(type)){
                    mPresenter.getGoodsInfo(1,"",userId,"");
                }else {
                    mPresenter.getGoodsInfo(1,"",userId,type);
                }
            }
        });
        refresh.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                refresh.finishLoadmore(3000);
                if (TextUtils.isEmpty(type)){
                    mPresenter.getGoodsInfo(2,"",userId,"");
                }else {
                    mPresenter.getGoodsInfo(2,"",userId,type);
                }
            }
        });

        mAdapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
            @Override
            public void onClick(View view, Object item, int position) {
                IntergralShopBean.IstIntegerGoods goods = (IntergralShopBean.IstIntegerGoods) item;
                GoodsDetailsActivity.newInstance(IntegralGoodsActivity.this,"",2,goods.getUrl());
            }
        });
    }

    @OnClick({R.id.iv_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                this.finish();
                break;
        }
    }

    @Override
    public void stateError() {

    }

    @Override
    public void showContent(List<IntergralShopBean.IstIntegerGoods> list) {
        mAdapter.addFirstDataSet(list);
        refresh.finishRefresh();
        if (list.size() == 0){
            CPSToast.showText(this,"暂无更多");
        }
    }

    @Override
    public void loadMore(List<IntergralShopBean.IstIntegerGoods> list) {
        mAdapter.addMoreDataSet(list);
        refresh.finishLoadmore();
        if (list.size() == 0){
            CPSToast.showText(this,"暂无更多");
        }
    }
}
