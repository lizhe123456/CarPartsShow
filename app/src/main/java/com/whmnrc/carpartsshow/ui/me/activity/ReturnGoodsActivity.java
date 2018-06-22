package com.whmnrc.carpartsshow.ui.me.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.whmnrc.carpartsshow.R;
import com.whmnrc.carpartsshow.base.BaseActivity;
import com.whmnrc.carpartsshow.model.http.bean.OrderListBean;
import com.whmnrc.carpartsshow.ui.me.adapter.ReturnGoodsAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/6/22.
 */

public class ReturnGoodsActivity extends BaseActivity implements ReturnGoodsAdapter.OnClickRequestListener {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.rv_goods)
    RecyclerView rvGoods;
    @BindView(R.id.tv_goods_price)
    TextView tvGoodsPrice;
    @BindView(R.id.et_ret_goods)
    EditText etRetGoods;
    @BindView(R.id.all_select)
    TextView allSelect;

    private ReturnGoodsAdapter mAdapter;
    private boolean isAll = false;
    private boolean isEdit = false;

    public static void start(Context context, OrderListBean.DataBean item) {
        Intent starter = new Intent(context, ReturnGoodsActivity.class);
        String json = new Gson().toJson(item, OrderListBean.DataBean.class);
        starter.putExtra("json", json);
        context.startActivity(starter);
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_retuen_goods;
    }

    @Override
    protected void init() {

    }

    @Override
    protected void setData() {
        String json = getIntent().getStringExtra("json");
        OrderListBean.DataBean dataBean = null;
        if (!TextUtils.isEmpty(json)) {
            dataBean = new Gson().fromJson(json, OrderListBean.DataBean.class);
        }
        mAdapter = new ReturnGoodsAdapter(this);
        rvGoods.setLayoutManager(new LinearLayoutManager(this));
        rvGoods.setAdapter(mAdapter);
        mAdapter.setOnClickRequestListener(this);
        if (dataBean != null) {
            mAdapter.addFirstDataSet(dataBean.getDetail());
        }
    }

    @Override
    public void plus(OrderListBean.DataBean.DetailBean item, int position) {
        int num = mAdapter.getDataSource().get(position).getOrderItem_Number() + 1;
        mAdapter.getDataSource().get(position).setOrderItem_Number(num);
        mAdapter.shopNotifyItemChanged(position);
    }
    @Override
    public void reduce(OrderListBean.DataBean.DetailBean item, int position) {
        int num = mAdapter.getDataSource().get(position).getOrderItem_Number() - 1;
        mAdapter.getDataSource().get(position).setOrderItem_Number(num);
        mAdapter.shopNotifyItemChanged(position);
    }

    @Override
    public void updateTotal(String money, String integral, String num) {
        tvGoodsPrice.setText(money);
    }

    @Override
    public void isAll(boolean isAll) {
        Drawable drawable = null;
        if (isAll) {
            drawable = getResources().getDrawable(R.drawable.round_btn_selected);
            this.isAll = true;
        } else {
            drawable = getResources().getDrawable(R.drawable.round_btn_normal);
            this.isAll = false;
        }
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        allSelect.setCompoundDrawables(drawable, null, null, null);
    }

    @Override
    public void goodsDetails(OrderListBean.DataBean.DetailBean item) {

    }


    @OnClick({R.id.iv_back,R.id.all_select, R.id.tv_reture_goods})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                this.finish();
                break;
            case R.id.all_select:
                Drawable drawable = null;
                if (!isAll) {
                    drawable = getResources().getDrawable(R.drawable.round_btn_selected);
                    isAll = true;
                } else {
                    drawable = getResources().getDrawable(R.drawable.round_btn_normal);
                    isAll = false;
                }
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                allSelect.setCompoundDrawables(drawable, null, null, null);
                mAdapter.allSelected(isAll);
                break;
            case R.id.tv_reture_goods:
                break;
        }
    }
}
