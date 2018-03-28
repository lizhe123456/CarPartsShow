package com.carpartsshow.ui.me.fragment.news;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.carpartsshow.R;
import com.carpartsshow.base.MvpFragment;
import com.carpartsshow.model.http.bean.NewTypeBean;
import com.carpartsshow.model.http.bean.NewsListBean;
import com.carpartsshow.presenter.home.NewsListPresenter;
import com.carpartsshow.presenter.home.contract.NewsListContract;
import com.carpartsshow.ui.me.adapter.NewsListAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
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
        mPresenter.getNewsList(newTypeBean.getItemName(),1);
        mAdapter = new NewsListAdapter(getContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(mAdapter);
        refresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                mPresenter.getNewsList(newTypeBean.getItemName(),1);
            }
        });
        refresh.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                mPresenter.getNewsList(newTypeBean.getItemName(),2);
            }
        });
    }

    @Override
    public void stateError() {

    }

    @Override
    public void loadFirst(List<NewsListBean> msgBeans) {
        mAdapter.addFirstDataSet(msgBeans);
        refresh.finishRefresh();
    }

    @Override
    public void loadMore(List<NewsListBean> msgBeans) {
        mAdapter.addMoreDataSet(msgBeans);
        refresh.finishLoadmore();
    }

}
