package com.carpartsshow.ui.me.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.carpartsshow.R;
import com.carpartsshow.base.BaseFragment;
import com.carpartsshow.base.MvpFragment;
import com.carpartsshow.base.adapter.BaseAdapter;
import com.carpartsshow.model.http.bean.ConsumptionRecordBean;
import com.carpartsshow.model.http.bean.LoginBean;
import com.carpartsshow.presenter.me.CreditMoneyPresenter;
import com.carpartsshow.presenter.me.contract.CreditMoneyContract;
import com.carpartsshow.ui.me.adapter.ConsumptionRecordAdapter;
import com.carpartsshow.ui.me.adapter.IntegralAdapter;
import com.carpartsshow.ui.shopping.activity.ConfirmOrderActivity;
import com.carpartsshow.util.SpUtil;
import com.carpartsshow.view.PayDialog;
import com.carpartsshow.widgets.CPSToast;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.List;

import butterknife.BindView;

/**
 * Created by lizhe on 2018/3/15.
 * 待还款
 */

public class WaitRepayFragment extends MvpFragment<CreditMoneyPresenter> implements CreditMoneyContract.View {
    @BindView(R.id.my_moe)
    TextView myMoe;
    @BindView(R.id.tv_num)
    TextView tvNum;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;

    private ConsumptionRecordAdapter adapter;
    private PayDialog payDialog;
    private int type;
    private LoginBean loginBean;
    @Override
    protected int setLayout() {
        return R.layout.fragment_wait_repay;
    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected void setData() {
        adapter = new ConsumptionRecordAdapter(getContext());
        loginBean = SpUtil.getObject(getContext(), "user");
//        tvNum.setText(loginBean);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
        mPresenter.getCreditMoney(loginBean.getRepairUser_ID(), 0, 1);
        refresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                refresh.finishRefresh(3000);
                mPresenter.getCreditMoney(loginBean.getRepairUser_ID(), 0, 1);
            }
        });
        refresh.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                refresh.finishLoadmore(3000);
                mPresenter.getCreditMoney(loginBean.getRepairUser_ID(), 0, 2);
            }
        });
       adapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
           @Override
           public void onClick(View view, Object item, int position) {
               payDialog = new PayDialog.Builder(getContext())
                       .setPayListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View v) {
//                                payDialog.select();
                               if (type == 0){
                                   //支付宝
                                   payDialog.dismiss();
                                   CPSToast.showText(getContext(),"暂不支持");
                               }else if (type == 2){
                                   //微信
                                   payDialog.dismiss();
                                   CPSToast.showText(getContext(),"暂不支持");
                               }
                           }
                       }).setIsCredit(false)
                       .setAliListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View v) {
                               payDialog.select(0);
                               type = 0;
                           }
                       }).setWXListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View v) {
                               payDialog.select(1);
                               type = 1;
                           }

                       }).build();
               payDialog.show();
               payDialog.select(0);
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
        tvNum.setText(list.size() + "笔");
        double num = Double.parseDouble(loginBean.getRepairUser_CreditMoney()) - Double.parseDouble(loginBean.getRepairUser_CreditBeOverMoney());
        myMoe.setText(num+"");
        refresh.finishRefresh();
        adapter.addFirstDataSet(list);
        if (list.size() == 0) {
            CPSToast.showText(getContext(), "没有更多记录了");
        }
    }
}
