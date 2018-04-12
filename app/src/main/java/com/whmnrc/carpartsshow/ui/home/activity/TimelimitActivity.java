package com.whmnrc.carpartsshow.ui.home.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;

import com.whmnrc.carpartsshow.R;
import com.whmnrc.carpartsshow.base.MvpActivity;
import com.whmnrc.carpartsshow.base.adapter.BaseAdapter;
import com.whmnrc.carpartsshow.model.http.bean.GoodsDetailToBean;
import com.whmnrc.carpartsshow.model.http.bean.LoginBean;
import com.whmnrc.carpartsshow.model.http.bean.SeckillGoodsBean;
import com.whmnrc.carpartsshow.presenter.home.TimelimitPresenter;
import com.whmnrc.carpartsshow.presenter.home.contract.TimelimitContract;
import com.whmnrc.carpartsshow.ui.home.adapter.TimelimitAdapter;
import com.whmnrc.carpartsshow.util.SpUtil;
import com.whmnrc.carpartsshow.view.CountdownTextView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.Calendar;
import java.util.List;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by lizhe on 2018/3/28.
 * 限时折扣
 */

public class TimelimitActivity extends MvpActivity<TimelimitPresenter> implements TimelimitContract.View {

    @BindView(R.id.tv_time)
    CountdownTextView tvTime;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;
    @BindView(R.id.vs_empty)
    ViewStub vsEmpty;
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
                GoodsDetailToBean goodsDetailToBean = new GoodsDetailToBean(listSeckillGoodsBean.getUrl(),listSeckillGoodsBean.isIsCollection(),listSeckillGoodsBean.getCarCount());
                GoodsDetailsActivity.newInstance(TimelimitActivity.this ,goodsDetailToBean);
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
    protected void onResume() {
        super.onResume();
        Calendar calendar=Calendar.getInstance();  //获取当前时间，作为图标的名字
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);

        tvTime.setTime(23 - hour, 59 - minute , 59 - second );
        tvTime.start();
    }

    @Override
    public void stateError() {

    }

    @Override
    public void loadData(List<SeckillGoodsBean> list) {
        if (list.size() == 0) {
            if (vsEmpty.getParent() != null) {
                showEmpty();
            }
            recyclerView.setVisibility(View.GONE);
            vsEmpty.setVisibility(View.VISIBLE);
        } else {
            if (vsEmpty.getParent() == null) {
                vsEmpty.setVisibility(View.GONE);
            }
            recyclerView.setVisibility(View.VISIBLE);
        }
        timelimitAdapter.addFirstDataSet(list);
        refresh.finishRefresh();
    }

    @Override
    public void loadMore(List<SeckillGoodsBean> list) {
        timelimitAdapter.addMoreDataSet(list);
        refresh.finishLoadmore();
    }

    @Override
    public void showEmpty() {
        if (vsEmpty != null) {
            View view = vsEmpty.inflate();
            ImageView imageView = view.findViewById(R.id.iv_empty);
            TextView textView = view.findViewById(R.id.tv_empty_msg);
            imageView.setImageResource(R.drawable.order_empty);
            textView.setText("暂无更多数据~");
        }
    }
}
