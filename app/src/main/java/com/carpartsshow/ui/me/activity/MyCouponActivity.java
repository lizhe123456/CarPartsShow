package com.carpartsshow.ui.me.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;

import com.carpartsshow.R;
import com.carpartsshow.base.MvpActivity;
import com.carpartsshow.base.adapter.BaseAdapter;
import com.carpartsshow.model.http.bean.CouponBean;
import com.carpartsshow.model.http.bean.LoginBean;
import com.carpartsshow.model.http.bean.OrderBean;
import com.carpartsshow.presenter.me.CouponPresenter;
import com.carpartsshow.presenter.me.contract.CouponContract;
import com.carpartsshow.ui.me.adapter.CouponAdapter;
import com.carpartsshow.util.SpUtil;
import com.google.gson.Gson;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import java.util.List;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by lizhe on 2018/3/15.
 */

public class MyCouponActivity extends MvpActivity<CouponPresenter> implements CouponContract.View {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;
    @BindView(R.id.vs_empty)
    ViewStub vsEmpty;
    @BindView(R.id.cancel)
    TextView tvCancel;
    private CouponAdapter mAdapter;
    private int select = -1;

    public static void start(Activity context) {
        Intent starter = new Intent(context, MyCouponActivity.class);
        starter.putExtra("select",0);
        context.startActivityForResult(starter,0);
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_coupon;
    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected void setData() {

        select = getIntent().getIntExtra("select",-1);
        final LoginBean loginBean = SpUtil.getObject(this, "user");
        mPresenter.getCoupon(loginBean.getRepairUser_ID(), 1);
        mAdapter = new CouponAdapter(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplication());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(mAdapter);
        refresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                refresh.finishRefresh(3000);
                mPresenter.getCoupon(loginBean.getRepairUser_ID(), 1);
            }
        });

        refresh.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                refresh.finishLoadmore(3000);
                mPresenter.getCoupon(loginBean.getRepairUser_ID(), 2);
            }

        });
        if (select != -1) {
            mAdapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
                @Override
                public void onClick(View view, Object item, int position) {
                    CouponBean couponBean = (CouponBean) item;
                    Intent intent = new Intent();
                    String json = new Gson().toJson(couponBean);
                    intent.putExtra("coupon", json);
                    setResult(2, intent);
                    finish();
                }
            });
            tvCancel.setVisibility(View.VISIBLE);
            tvCancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setResult(3);
                    finish();
                }
            });
        }
    }

    @Override
    public void stateError() {

    }

    @Override
    public void showContent(List<CouponBean> couponBean) {
        mAdapter.addFirstDataSet(couponBean);
        refresh.finishRefresh();
        if (mAdapter.getDataSource().size() == 0){
            View view = vsEmpty.inflate();
            ImageView imageView = view.findViewById(R.id.iv_empty);
            TextView textView = view.findViewById(R.id.tv_empty_msg);
            imageView.setImageResource(R.drawable.coupon_empty);
            textView.setText("没有可用的优惠券哟~");
        }
    }

    @Override
    public void loadMore(List<CouponBean> couponBean) {
        mAdapter.addMoreDataSet(couponBean);
        refresh.finishLoadmore();
    }


    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        this.finish();
    }
}
