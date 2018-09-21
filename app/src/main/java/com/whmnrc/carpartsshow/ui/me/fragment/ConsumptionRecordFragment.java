package com.whmnrc.carpartsshow.ui.me.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;

import com.whmnrc.carpartsshow.R;
import com.whmnrc.carpartsshow.base.MvpFragment;
import com.whmnrc.carpartsshow.base.adapter.BaseAdapter;
import com.whmnrc.carpartsshow.model.http.bean.ConsumptionRecordBean;
import com.whmnrc.carpartsshow.model.http.bean.LoginBean;
import com.whmnrc.carpartsshow.model.http.bean.PayRecordBean;
import com.whmnrc.carpartsshow.presenter.me.CreditMoneyPresenter;
import com.whmnrc.carpartsshow.presenter.me.contract.CreditMoneyContract;
import com.whmnrc.carpartsshow.ui.me.adapter.ConsumptionRecordAdapter;
import com.whmnrc.carpartsshow.ui.me.adapter.PayRecordAdapter;
import com.whmnrc.carpartsshow.util.SpUtil;
import com.whmnrc.carpartsshow.view.PayDialog;
import com.whmnrc.carpartsshow.widgets.CPSToast;
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

public class ConsumptionRecordFragment extends MvpFragment<CreditMoneyPresenter> implements CreditMoneyContract.View {
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;
    @BindView(R.id.vs_empty)
    ViewStub vsEmpty;

    private PayRecordAdapter adapter;
    private PayDialog payDialog;
    private int type;

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
        adapter = new PayRecordAdapter(getContext());
        final LoginBean loginBean = SpUtil.getObject(getContext(), "user");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
        mPresenter.getPay(loginBean.getRepairUser_ID(), true);
        refresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                mPresenter.getPay(loginBean.getRepairUser_ID(), true);
            }
        });
        refresh.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                mPresenter.getPay(loginBean.getRepairUser_ID(), false);
            }
        });
//        adapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
//            @Override
//            public void onClick(View view, Object item, int position) {
//                ConsumptionRecordBean consumptionRecordBean = (ConsumptionRecordBean) item;
//
//                    payDialog = new PayDialog.Builder(getContext())
//                            .setPayListener(new View.OnClickListener() {
//                                @Override
//                                public void onClick(View v) {
////                                payDialog.select();
//                                    if (type == 0) {
//                                        //支付宝
//                                        payDialog.dismiss();
//                                        CPSToast.showText(getContext(), "暂不支持");
//                                    } else if (type == 1) {
//                                        //微信
//                                        pay  Dialog.dismiss();
//                                        CPSToast.showText(getContext(), "暂不支持");
//                                    }
//                                }
//                            }).setIsCredit(false)
//                            .setAliListener(new View.OnClickListener() {
//                                @Override
//                                public void onClick(View v) {
//                                    payDialog.select(0);
//                                    type = 0;
//                                }
//                            }).setWXListener(new View.OnClickListener() {
//                                @Override
//                                public void onClick(View v) {
//                                    payDialog.select(1);
//                                    type = 1;
//                                }
//
//                            }).build();
//                    payDialog.show();
//                    payDialog.select(0);
//
//                }
//            });
    }

    @Override
    public void stateError() {

    }

    @Override
    public void loadMore(List<ConsumptionRecordBean> list) {


    }

    @Override
    public void loadFrist(List<ConsumptionRecordBean> list) {


    }

    @Override
    public void showPay(List<PayRecordBean> payRecordBeans) {
        refresh.finishRefresh();
        adapter.addFirstDataSet(payRecordBeans);
        if (payRecordBeans.size() == 0) {
            recyclerView.setVisibility(View.GONE);
            vsEmpty.setVisibility(View.VISIBLE);
        } else {
            vsEmpty.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void showPayLoadMore(List<PayRecordBean> payRecordBeans) {
        refresh.finishLoadmore();
        adapter.addMoreDataSet(payRecordBeans);
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
