package com.whmnrc.carpartsshow.ui.me.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;

import com.whmnrc.carpartsshow.R;
import com.whmnrc.carpartsshow.base.MvpActivity;
import com.whmnrc.carpartsshow.model.http.bean.LoginBean;
import com.whmnrc.carpartsshow.model.http.bean.OrderListBean;
import com.whmnrc.carpartsshow.model.http.bean.UserInfoBean;
import com.whmnrc.carpartsshow.presenter.me.MyOrderPresenter;
import com.whmnrc.carpartsshow.presenter.me.contract.MyOrderContract;
import com.whmnrc.carpartsshow.ui.me.fragment.order.adapter.AllOrderAdapter;
import com.whmnrc.carpartsshow.ui.me.fragment.order.base.OnOrderListenerAdapter;
import com.whmnrc.carpartsshow.ui.me.fragment.order.base.OrderAdapter;
import com.whmnrc.carpartsshow.ui.shopping.activity.ConfirmOrderActivity;
import com.whmnrc.carpartsshow.util.ScreenUtils;
import com.whmnrc.carpartsshow.util.SpUtil;
import com.whmnrc.carpartsshow.widgets.CPSToast;
import com.google.gson.Gson;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by lizhe on 2018/4/2.
 */

public class AllOrderActivity extends MvpActivity<MyOrderPresenter> implements MyOrderContract.View {

    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;
    @BindView(R.id.vs_empty)
    ViewStub vsEmpty;

    private LoginBean loginBean;
    protected OrderAdapter mAdapter;

    public static void start(Context context) {
        Intent starter = new Intent(context, AllOrderActivity.class);
        context.startActivity(starter);
    }

    @Override
    public void stateError() {

    }

    @Override
    public void showData(OrderListBean orderListBean) {
        if (orderListBean.getData().size() == 0) {
            recyclerView.setVisibility(View.GONE);
            vsEmpty.setVisibility(View.VISIBLE);
        } else {
            vsEmpty.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
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
    public void updateData(String msg) {
        refresh.autoRefresh(3000);
        CPSToast.showText(this,msg);
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_all_order;
    }

    @Override
    protected void setData() {
        title.setText("全部订单");
        loginBean = SpUtil.getObject(this,"user");
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new AllOrderAdapter(this,mPresenter);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setNestedScrollingEnabled(false);
        mPresenter.getOrderList(loginBean.getRepairUser_ID(),0,1);
        refresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                mPresenter.getOrderList(loginBean.getRepairUser_ID(), 0, 1);
                refresh.finishRefresh(3000);
            }
        });

        refresh.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                mPresenter.getOrderList(loginBean.getRepairUser_ID(), 0, 2);
                refresh.finishLoadmore(3000);
            }
        });

        mAdapter.setOnOrderListener(new OnOrderListenerAdapter() {
            @Override
            public void applyCustomerServiceClick(OrderListBean.DataBean item) {

            }

            @Override
            public void payClick(OrderListBean.DataBean item) {
                String json = new Gson().toJson(item);
                ConfirmOrderActivity.start(AllOrderActivity.this,json,1);
            }

            @Override
            public void customerServicePhoneClick(OrderListBean.DataBean item) {
                customerServicePhone();
            }

            @Override
            public void lookProgress(OrderListBean.DataBean item) {

            }
        });
    }

    //联系客服
    protected void customerServicePhone() {
        UserInfoBean userInfoBean = SpUtil.getObject(this,"userInfo");
        final Dialog bottomDialog = new Dialog(this, R.style.BottomDialog);
        View contentView = LayoutInflater.from(this).inflate(R.layout.dialog_content_normal, null);
        TextView tv_cancel = contentView.findViewById(R.id.tv_cancel);
        final TextView tv_phone_2 = contentView.findViewById(R.id.tv_phone_2);
        final TextView tv_phone_1 = contentView.findViewById(R.id.tv_phone_1);
        if (userInfoBean != null) {
            try {
                tv_phone_1.setText(userInfoBean.getListServicePhone().get(0).getItemValue());
                tv_phone_2.setText(userInfoBean.getListServicePhone().get(1).getItemValue());
            }catch (IndexOutOfBoundsException e){

            }
        }
        tv_phone_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ScreenUtils.diallPhone(AllOrderActivity.this,tv_phone_1.getText().toString().trim());
            }
        });
        tv_phone_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ScreenUtils.diallPhone(AllOrderActivity.this,tv_phone_2.getText().toString().trim());
            }
        });
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
        if (vsEmpty.getParent() != null) {
            View view = vsEmpty.inflate();
            ImageView imageView = view.findViewById(R.id.iv_empty);
            TextView textView = view.findViewById(R.id.tv_empty_msg);
            imageView.setImageResource(R.drawable.order_empty);
            textView.setText("暂无更多订单~");
        }
    }

}
