package com.carpartsshow.ui.me.activity;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.carpartsshow.R;
import com.carpartsshow.base.MvpActivity;
import com.carpartsshow.model.http.bean.CouponBean;
import com.carpartsshow.model.http.bean.LoginBean;
import com.carpartsshow.presenter.me.CouponPresenter;
import com.carpartsshow.presenter.me.contract.CouponContract;
import com.carpartsshow.ui.me.adapter.CouponAdapter;
import com.carpartsshow.util.SpUtil;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.List;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by lizhe on 2018/3/15.
 */

public class MyCouponActivity extends MvpActivity<CouponPresenter> implements CouponContract.View {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;

    private CouponAdapter mAdapter;


    @Override
    protected int setLayout() {
        return R.layout.activity_coupon;
    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected void setData() {
        LoginBean loginBean = SpUtil.getObject(this, "user");
        mPresenter.getCoupon(loginBean.getRepairUser_ID(),1);
        mAdapter = new CouponAdapter(this);
        StaggeredGridLayoutManager linearLayoutManager = new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void stateError() {

    }

    @Override
    public void showContent(List<CouponBean> couponBean) {
        mAdapter.addFirstDataSet(couponBean);
    }

    @Override
    public void loadMore(List<CouponBean> couponBean) {
        mAdapter.addMoreDataSet(couponBean);
    }


    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        this.finish();
    }
}
