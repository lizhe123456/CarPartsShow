package com.carpartsshow.ui.me.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.carpartsshow.R;
import com.carpartsshow.base.BaseFragment;
import com.carpartsshow.base.MvpFragment;
import com.carpartsshow.model.http.bean.ConsumptionRecordBean;
import com.carpartsshow.model.http.bean.LoginBean;
import com.carpartsshow.presenter.me.CreditMoneyPresenter;
import com.carpartsshow.presenter.me.contract.CreditMoneyContract;
import com.carpartsshow.ui.me.adapter.ConsumptionRecordAdapter;
import com.carpartsshow.util.SpUtil;
import com.carpartsshow.widgets.CPSToast;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.List;

import butterknife.BindView;

/**
 * Created by lizhe on 2018/3/15.
 * 消费记录
 */

public class ConsumptionRecordFragment extends MvpFragment<CreditMoneyPresenter> implements CreditMoneyContract.View{
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;

    private ConsumptionRecordAdapter adapter;

    @Override
    protected int setLayout() {
        return R.layout.fragment_consumption_record;
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
        mPresenter.getCreditMoney(loginBean.getRepairUser_ID(),1);
        refresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                mPresenter.getCreditMoney(loginBean.getRepairUser_ID(),1);
            }
        });
        refresh.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                mPresenter.getCreditMoney(loginBean.getRepairUser_ID(),2);
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
