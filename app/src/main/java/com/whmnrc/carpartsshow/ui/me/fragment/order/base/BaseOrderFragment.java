package com.whmnrc.carpartsshow.ui.me.fragment.order.base;

import android.app.Dialog;
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
import com.whmnrc.carpartsshow.base.MvpFragment;
import com.whmnrc.carpartsshow.base.adapter.BaseAdapter;
import com.whmnrc.carpartsshow.model.http.bean.LoginBean;
import com.whmnrc.carpartsshow.model.http.bean.OrderListBean;
import com.whmnrc.carpartsshow.model.http.bean.UserInfoBean;
import com.whmnrc.carpartsshow.presenter.me.MyOrderPresenter;
import com.whmnrc.carpartsshow.presenter.me.contract.MyOrderContract;
import com.whmnrc.carpartsshow.util.ScreenUtils;
import com.whmnrc.carpartsshow.util.SpUtil;
import com.whmnrc.carpartsshow.widgets.CPSToast;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import butterknife.BindView;

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
    protected OrderListBean orderBean;


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
        orderBean = orderListBean;
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
    protected void applyCustomerService(OrderListBean.DataBean dataBean) {
//        mPresenter.applyCustomerServiceClick();
        mPresenter.applyCustomerService(dataBean.getOrder_ID());
    }

    @Override
    public void updateData(String msg) {
        CPSToast.showText(getContext(),msg);
        refresh.autoRefresh(3000);
    }

    //联系客服
    protected void customerServicePhone() {
        UserInfoBean userInfoBean = SpUtil.getObject(getContext(),"userInfo");
        final Dialog bottomDialog = new Dialog(getContext(), R.style.BottomDialog);
        View contentView = LayoutInflater.from(getContext()).inflate(R.layout.dialog_content_normal, null);
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
                ScreenUtils.diallPhone(getContext(),tv_phone_1.getText().toString().trim());
            }
        });
        tv_phone_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ScreenUtils.diallPhone(getContext(),tv_phone_2.getText().toString().trim());
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
