package com.whmnrc.carpartsshow.ui.home.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;

import com.whmnrc.carpartsshow.R;
import com.whmnrc.carpartsshow.base.MvpActivity;
import com.whmnrc.carpartsshow.model.http.bean.LoginBean;
import com.whmnrc.carpartsshow.model.http.bean.MsgBean;
import com.whmnrc.carpartsshow.presenter.home.MessageRecordPresenter;
import com.whmnrc.carpartsshow.presenter.home.contract.MessageRecordContract;
import com.whmnrc.carpartsshow.ui.home.adapter.MessageRecordAdapter;
import com.whmnrc.carpartsshow.util.SpUtil;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.List;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by lizhe on 2018/3/28.
 * 消息通知界面
 */

public class MessageRecordActivity extends MvpActivity<MessageRecordPresenter> implements MessageRecordContract.View {

    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;
    @BindView(R.id.vs_empty)
    ViewStub vsEmpty;
    private LoginBean loginBean;

    private MessageRecordAdapter mAdapter;

    @Override
    public void stateError() {

    }

    @Override
    public void loadFirst(List<MsgBean> msgBeans) {
        if (msgBeans.size() == 0) {
            recyclerView.setVisibility(View.GONE);
            vsEmpty.setVisibility(View.VISIBLE);
        } else {
            vsEmpty.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
        }
        refresh.finishRefresh();
        mAdapter.addFirstDataSet(msgBeans);
    }

    @Override
    public void loadMore(List<MsgBean> msgBeans) {
        refresh.finishLoadmore();
        mAdapter.addMoreDataSet(msgBeans);
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_message_record;
    }

    @Override
    protected void setData() {
        title.setText("消息通知");
        loginBean = SpUtil.getObject(this,"user");
        mAdapter = new MessageRecordAdapter(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(mAdapter);
        refresh.autoRefresh();

        refresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                mPresenter.getMsgData(loginBean.getRepairUser_ID(),1);
            }
        });
        refresh.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                mPresenter.getMsgData(loginBean.getRepairUser_ID(),2);
            }
        });
    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        this.finish();
    }

    @Override
    public void showEmpty() {
        if (vsEmpty != null) {
            View view = vsEmpty.inflate();
            ImageView imageView = view.findViewById(R.id.iv_empty);
            TextView textView = view.findViewById(R.id.tv_empty_msg);
            imageView.setImageResource(R.drawable.msg_empty);
            textView.setText("这里什么都没有哦~");
        }
    }

}
