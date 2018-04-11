package com.whmnrc.carpartsshow.ui.me.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.whmnrc.carpartsshow.R;
import com.whmnrc.carpartsshow.base.MvpFragment;
import com.whmnrc.carpartsshow.model.http.bean.ConsumptionRecordBean;
import com.whmnrc.carpartsshow.model.http.bean.LoginBean;
import com.whmnrc.carpartsshow.presenter.me.CreditMoneyPresenter;
import com.whmnrc.carpartsshow.presenter.me.contract.CreditMoneyContract;
import com.whmnrc.carpartsshow.ui.me.adapter.ConsumptionRecordAdapter;
import com.whmnrc.carpartsshow.util.SpUtil;
import com.whmnrc.carpartsshow.widgets.CPSToast;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.List;

import butterknife.BindView;

/**
 * Created by lizhe on 2018/3/15.
 * 已还款
 */

public class RepayCompleteFragment extends MvpFragment<CreditMoneyPresenter> implements CreditMoneyContract.View {


    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;

    private ConsumptionRecordAdapter adapter;

    @Override
    protected int setLayout() {
        return R.layout.repay_complete;
    }


    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected void setData() {
        adapter = new ConsumptionRecordAdapter(getContext());
        final LoginBean loginBean = SpUtil.getObject(getContext(),"user");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
        mPresenter.getCreditMoney(loginBean.getRepairUser_ID(),1,1);
        refresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                mPresenter.getCreditMoney(loginBean.getRepairUser_ID(),1,1);
            }
        });
        refresh.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                mPresenter.getCreditMoney(loginBean.getRepairUser_ID(),1,2);
            }
        });
    }

    @Override
    public void stateError() {

    }

    @Override
    public void loadMore(List<ConsumptionRecordBean> list) {
        refresh.finishLoadmore();
        adapter.addMoreDataSet(list);
    }

    @Override
    public void loadFrist(List<ConsumptionRecordBean> list) {
        refresh.finishRefresh();
        adapter.addFirstDataSet(list);
        if (list.size() == 0){
            CPSToast.showText(getContext(),"没有更多记录了");
        }
    }
}
