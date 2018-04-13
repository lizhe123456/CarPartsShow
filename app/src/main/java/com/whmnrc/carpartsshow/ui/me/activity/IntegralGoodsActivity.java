package com.whmnrc.carpartsshow.ui.me.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewStub;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.whmnrc.carpartsshow.R;
import com.whmnrc.carpartsshow.base.MvpActivity;
import com.whmnrc.carpartsshow.base.adapter.BaseAdapter;
import com.whmnrc.carpartsshow.model.http.bean.GoodsDetailToBean;
import com.whmnrc.carpartsshow.model.http.bean.IntergralShopBean;
import com.whmnrc.carpartsshow.model.http.bean.LoginBean;
import com.whmnrc.carpartsshow.presenter.me.IntegralGoodsPresenter;
import com.whmnrc.carpartsshow.presenter.me.contract.IntegralGoodsContract;
import com.whmnrc.carpartsshow.ui.home.activity.GoodsDetailsActivity;
import com.whmnrc.carpartsshow.ui.me.adapter.GoodsAdapter;
import com.whmnrc.carpartsshow.util.SpUtil;
import com.whmnrc.carpartsshow.widgets.CPSToast;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by lizhe on 2018/3/16.
 *
 */

public class IntegralGoodsActivity extends MvpActivity<IntegralGoodsPresenter> implements IntegralGoodsContract.View {

    @BindView(R.id.et_search)
    EditText etSearch;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;

    private GoodsAdapter mAdapter;
    @BindView(R.id.vs_empty)
    ViewStub vsEmpty;

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
                refresh.finishRefresh();
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
                refresh.finishLoadmore();
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
                GoodsDetailsActivity.newInstance(IntegralGoodsActivity.this,goods);
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
        if (list.size() == 0) {
            recyclerView.setVisibility(View.GONE);
            vsEmpty.setVisibility(View.VISIBLE);
        } else {
            vsEmpty.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
        }
        mAdapter.addFirstDataSet(list);
        refresh.finishRefresh();
    }

    @Override
    public void loadMore(List<IntergralShopBean.IstIntegerGoods> list) {
        mAdapter.addMoreDataSet(list);
        refresh.finishLoadmore();
        if (list.size() == 0){
            CPSToast.showText(this,"暂无更多");
        }
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
