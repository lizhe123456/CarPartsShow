package com.whmnrc.carpartsshow.ui.me.fragment.news;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;

import com.whmnrc.carpartsshow.R;
import com.whmnrc.carpartsshow.base.MvpFragment;
import com.whmnrc.carpartsshow.base.adapter.BaseAdapter;
import com.whmnrc.carpartsshow.model.http.bean.NewTypeBean;
import com.whmnrc.carpartsshow.model.http.bean.NewsListBean;
import com.whmnrc.carpartsshow.presenter.home.NewsListPresenter;
import com.whmnrc.carpartsshow.presenter.home.contract.NewsListContract;
import com.whmnrc.carpartsshow.ui.me.activity.NewsDetailsActivity;
import com.whmnrc.carpartsshow.ui.me.adapter.NewsListAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.whmnrc.carpartsshow.widgets.CPSToast;

import java.util.List;

import butterknife.BindView;

/**
 * Created by lizhe on 2018/3/28.
 * 新闻列表fragment
 */

public class NewsListFragment extends MvpFragment<NewsListPresenter> implements NewsListContract.View {


    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;
    @BindView(R.id.vs_empty)
    ViewStub vsEmpty;

    private NewsListAdapter mAdapter;
    private NewTypeBean newTypeBean;


    public static NewsListFragment newInstance(NewTypeBean bean) {
        NewsListFragment myFragment = new NewsListFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("bean", bean);
        myFragment.setArguments(bundle);
        return myFragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_news_list;
    }


    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected void setData() {
        Bundle bundle = getArguments();
        newTypeBean = (NewTypeBean) bundle.getSerializable("bean");
        mPresenter.getNewsList(newTypeBean.getItemName(), 1);
        mAdapter = new NewsListAdapter(getContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(mAdapter);
        refresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                mPresenter.getNewsList(newTypeBean.getItemName(), 1);
            }
        });
        refresh.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                mPresenter.getNewsList(newTypeBean.getItemName(), 2);
            }
        });
        mAdapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
            @Override
            public void onClick(View view, Object item, int position) {
                NewsListBean newsListBean = (NewsListBean) item;
                NewsDetailsActivity.start(getContext(), newsListBean.getNewsUrl());
            }
        });
    }

    @Override
    public void stateError() {

    }

    @Override
    public void loadFirst(List<NewsListBean> msgBeans) {
        if (msgBeans.size() == 0) {
            recyclerView.setVisibility(View.GONE);
            vsEmpty.setVisibility(View.VISIBLE);
        } else {
            vsEmpty.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
        }
        mAdapter.addFirstDataSet(msgBeans);
        refresh.finishRefresh();
    }

    @Override
    public void loadMore(List<NewsListBean> msgBeans) {
        mAdapter.addMoreDataSet(msgBeans);
        refresh.finishLoadmore();
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
