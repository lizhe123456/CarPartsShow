package com.carpartsshow.ui.home.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.carpartsshow.R;
import com.carpartsshow.base.MvpActivity;
import com.carpartsshow.base.adapter.BaseAdapter;
import com.carpartsshow.model.http.bean.LoginBean;
import com.carpartsshow.model.http.bean.SeckillGoodsBean;
import com.carpartsshow.presenter.home.TimelimitPresenter;
import com.carpartsshow.presenter.home.contract.TimelimitContract;
import com.carpartsshow.ui.home.adapter.TimelimitAdapter;
import com.carpartsshow.util.SpUtil;
import com.carpartsshow.view.CountdownTextView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import java.util.List;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by lizhe on 2018/3/28.
 * 限时折扣
 */

public class TimelimitActivity extends MvpActivity<TimelimitPresenter> implements TimelimitContract.View{

    @BindView(R.id.tv_time)
    CountdownTextView tvTime;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;
    private TimelimitAdapter timelimitAdapter;

    public static void start(Context context) {
        Intent starter = new Intent(context, TimelimitActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_time_limit;
    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected void setData() {
        final LoginBean loginBean = SpUtil.getObject(this,"user");
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        timelimitAdapter = new TimelimitAdapter(this);
        recyclerView.setAdapter(timelimitAdapter);
        refresh.autoRefresh();
        timelimitAdapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
            @Override
            public void onClick(View view, Object item, int position) {
                SeckillGoodsBean listSeckillGoodsBean = (SeckillGoodsBean) item;
                GoodsDetailsActivity.newInstance(TimelimitActivity.this,"",0,listSeckillGoodsBean.getUrl());
            }
        });
        refresh.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                refresh.finishLoadmore(3000);
                mPresenter.getTimeData(loginBean.getRepairUser_ID(),2);
            }
        });

        refresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                refresh.finishRefresh(3000);
                mPresenter.getTimeData(loginBean.getRepairUser_ID(),1);
            }
        });
    }


    @OnClick({R.id.iv_back})
    public void onViewClicked(View view) {
        switch (view.getId()){
            case R.id.iv_back:
                this.finish();
                break;
        }

    }


    @Override
    public void stateError() {

    }

    @Override
    public void loadData(List<SeckillGoodsBean> list) {
        timelimitAdapter.addFirstDataSet(list);
        refresh.finishRefresh();
    }

    @Override
    public void loadMore(List<SeckillGoodsBean> list) {
        timelimitAdapter.addMoreDataSet(list);
        refresh.finishLoadmore();
    }
}
