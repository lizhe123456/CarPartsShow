package com.carpartsshow.ui.me.fragment.order.base;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;

import com.carpartsshow.R;
import com.carpartsshow.base.MvpFragment;
import com.carpartsshow.base.adapter.BaseAdapter;
import com.carpartsshow.model.http.bean.LoginBean;
import com.carpartsshow.model.http.bean.OrderListBean;
import com.carpartsshow.presenter.me.MyOrderPresenter;
import com.carpartsshow.presenter.me.contract.MyOrderContract;
import com.carpartsshow.util.SpUtil;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by lizhe on 2018/3/31.
 * 待支付、已支付、待收货、已完成、取消的订单、等待审核、退款成功、退款失败
 */

public abstract class BaseOrderFragment extends MvpFragment<MyOrderPresenter> implements MyOrderContract.View {


    @BindView(R.id.recyclerView)
    protected RecyclerView recyclerView;
    @BindView(R.id.refresh)
    protected SmartRefreshLayout refresh;
    @BindView(R.id.vs_empty)
    ViewStub vsEmpty;

    protected OrderAdapter mAdapter;


    @Override
    public void stateError() {

    }

    @Override
    public void showData(OrderListBean orderListBean) {
        if (null != orderListBean.getData() && orderListBean.getData().size() == 0){
            showEmpty();
        }
        mAdapter.addFirstDataSet(orderListBean.getData());
        refresh.finishRefresh();

    }

    @Override
    public void loadMore(OrderListBean orderListBean) {
        mAdapter.addMoreDataSet(orderListBean.getData());
        refresh.finishLoadmore();
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_order;
    }

    @Override
    protected void setData() {
        initRecyclerView();
    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    public void initRecyclerView() {
        final LoginBean loginBean = SpUtil.getObject(getContext(), "user");
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setNestedScrollingEnabled(false);
        mAdapter = setAdapter();
        recyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
            @Override
            public void onClick(View view, Object item, int position) {
//                OrderDetailsActivity.start(getContext());
            }
        });

        mPresenter.getOrderList(loginBean.getRepairUser_ID(), request(), 1);

        refresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                mPresenter.getOrderList(loginBean.getRepairUser_ID(), request(), 1);
                refresh.finishRefresh(3000);
            }
        });

        refresh.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                mPresenter.getOrderList(loginBean.getRepairUser_ID(), request(), 2);
                refresh.finishLoadmore(3000);
            }
        });


    }

    public abstract OrderAdapter setAdapter();

    public abstract int request();

    //申请售后
    protected void applyCustomerService() {
//        mPresenter.applyCustomerServiceClick();
    }

    //订单加急
    protected void orderUrgent() {
    }

    //确认收货
    protected void receiptGoods() {

    }

    //取消订单
    protected void cancelOrder() {

    }

    //付款
    protected void pay() {

    }

    @Override
    public void updateData() {
        refresh.autoRefresh(3000);
    }

    Dialog bottomDialog;

    //联系客服
    protected void customerServicePhone() {
        bottomDialog = new Dialog(getContext(), R.style.BottomDialog);
        View contentView = LayoutInflater.from(getContext()).inflate(R.layout.dialog_content_normal, null);
        TextView tv_cancel = contentView.findViewById(R.id.tv_cancel);
        TextView tv_phone_2 = contentView.findViewById(R.id.tv_phone_2);
        TextView tv_phone_1 = contentView.findViewById(R.id.tv_phone_1);
        TextView tv_phone = contentView.findViewById(R.id.tv_phone);

        bottomDialog.setContentView(contentView);
        ViewGroup.LayoutParams layoutParams = contentView.getLayoutParams();
        layoutParams.width = getResources().getDisplayMetrics().widthPixels;
        contentView.setLayoutParams(layoutParams);
        bottomDialog.getWindow().setGravity(Gravity.BOTTOM);
        bottomDialog.getWindow().setWindowAnimations(R.style.BottomDialog_Animation);
        bottomDialog.show();
        tv_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomDialog.cancel();
            }
        });
    }

    //查看进度
    protected void lookProgress() {

    }

    public void showEmpty() {
        View view = vsEmpty.inflate();
        ImageView imageView = view.findViewById(R.id.iv_empty);
        TextView textView = view.findViewById(R.id.tv_empty_msg);
        imageView.setImageResource(R.drawable.order_empty);
        textView.setText("暂无更多订单~");
    }


}
