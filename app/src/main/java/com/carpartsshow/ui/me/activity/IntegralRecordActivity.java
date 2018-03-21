package com.carpartsshow.ui.me.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.carpartsshow.R;
import com.carpartsshow.base.MvpActivity;
import com.carpartsshow.model.http.bean.IntegralRecordBean;
import com.carpartsshow.model.http.bean.LoginBean;
import com.carpartsshow.presenter.me.IntegralRecordPresenter;
import com.carpartsshow.presenter.me.contract.IntegralRecordContract;
import com.carpartsshow.ui.me.adapter.IntegralRecordAdapter;
import com.carpartsshow.util.SpUtil;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.List;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by lizhe on 2018/3/16.
 * 我的兑换记录
 */

public class IntegralRecordActivity extends MvpActivity<IntegralRecordPresenter> implements IntegralRecordContract.View {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;
    private IntegralRecordAdapter mAdapter;

    @Override
    protected int setLayout() {
        return R.layout.activity_integral_record;
    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected void setData() {
        LoginBean loginBean = SpUtil.getObject(this,"user");
        mPresenter.getRecord(loginBean.getRepairUser_ID(),1);
        mAdapter = new IntegralRecordAdapter(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void stateError() {

    }


    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        this.finish();
    }

    @Override
    public void showContent(List<IntegralRecordBean> list) {
        mAdapter.addFirstDataSet(list);
    }

    @Override
    public void loadMore(List<IntegralRecordBean> list) {

    }
}
