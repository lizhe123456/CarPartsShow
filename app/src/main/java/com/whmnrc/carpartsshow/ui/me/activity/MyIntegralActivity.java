package com.whmnrc.carpartsshow.ui.me.activity;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;

import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.whmnrc.carpartsshow.R;
import com.whmnrc.carpartsshow.base.MvpActivity;
import com.whmnrc.carpartsshow.model.http.bean.IntergralBean;
import com.whmnrc.carpartsshow.model.http.bean.LoginBean;
import com.whmnrc.carpartsshow.presenter.me.IntergralPresenter;
import com.whmnrc.carpartsshow.presenter.me.contract.IntergralContract;
import com.whmnrc.carpartsshow.ui.me.adapter.IntegralAdapter;
import com.whmnrc.carpartsshow.util.SpUtil;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by lizhe on 2018/3/15.
 */

public class MyIntegralActivity extends MvpActivity<IntergralPresenter> implements IntergralContract.View {

    @BindView(R.id.my_integral)
    TextView integral;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;
    @BindView(R.id.vs_empty)
    ViewStub vsEmpty;

    private IntegralAdapter mAdapter;
    private LoginBean loginBean;

    @Override
    protected int setLayout() {
        return R.layout.activity_my_integral;
    }


    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected void setData() {
        integral.setText(getIntent().getStringExtra("integer") == null ? "0" : getIntent().getStringExtra("integer") );
        loginBean = SpUtil.getObject(this,"user");
        mPresenter.getIntergralList(loginBean.getRepairUser_ID(),1);
        mAdapter = new IntegralAdapter(this);
        StaggeredGridLayoutManager linearLayoutManager = new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(mAdapter);
        refresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                refresh.finishRefresh(3000);
                mPresenter.getIntergralList(loginBean.getRepairUser_ID(),1);
            }
        });

        refresh.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                refresh.finishLoadmore(3000);
                mPresenter.getIntergralList(loginBean.getRepairUser_ID(),2);
            }
        });
        recyclerView.setNestedScrollingEnabled(false);
    }

    @Override
    public void stateError() {

    }

    @Override
    public void showContent(List<IntergralBean> intergralBean) {
        if (intergralBean.size() == 0) {
            recyclerView.setVisibility(View.GONE);
            vsEmpty.setVisibility(View.VISIBLE);
        } else {
            vsEmpty.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
        }
        refresh.finishRefresh();
        mAdapter.addFirstDataSet(intergralBean);
    }

    @Override
    public void loadMore(List<IntergralBean> intergralBean) {
        refresh.finishLoadmore();
        mAdapter.addMoreDataSet(intergralBean);
    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        this.finish();
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
