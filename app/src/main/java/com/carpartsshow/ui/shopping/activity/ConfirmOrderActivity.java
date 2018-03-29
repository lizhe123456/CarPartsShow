package com.carpartsshow.ui.shopping.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import com.carpartsshow.R;
import com.carpartsshow.base.BaseActivity;
import com.carpartsshow.model.http.bean.OrderBean;
import com.carpartsshow.ui.shopping.adapter.ConfirmOrderAdapter;
import com.carpartsshow.widgets.CPSToast;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by lizhe on 2018/3/29.
 * 确认订单
 */

public class ConfirmOrderActivity extends BaseActivity {

    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.switch1)
    Switch switch1;
    @BindView(R.id.ll_money)
    LinearLayout llMoney;
    @BindView(R.id.et_desc)
    EditText etDesc;
    @BindView(R.id.select_coupon)
    TextView textView;


    private OrderBean orderBean;
    private int type;
    private ConfirmOrderAdapter mAdapter;

    public static void start(Context context,OrderBean orderBean, int type){
        Intent intent = new Intent();
        intent.putExtra("order",orderBean);
        intent.putExtra("type",type);
        context.startActivity(intent);
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_confirm_order;
    }

    @Override
    protected void init() {

    }

    @Override
    protected void setData() {
        orderBean = (OrderBean) getIntent().getSerializableExtra("order");
        type = getIntent().getIntExtra("type",0);
        title.setText("确认订单");
        mAdapter = new ConfirmOrderAdapter(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(mAdapter);
        mAdapter.addFirstDataSet(orderBean.getListGoods());
        View view = LayoutInflater.from(this).inflate(R.layout.head_address,null);
        TextView address = view.findViewById(R.id.receipt_address);
        LinearLayout llAddress = view.findViewById(R.id.ll_receipt_address);
        String name = orderBean.getListReceiptAddress().get(0).getDetailAddress();
        address.setText("收货地址："+name);
        llAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CPSToast.showText(getApplicationContext(),"呵呵哒");
            }
        });
        mAdapter.addHeaderView(view);
        textView.setText("您有"+orderBean.getCouponCount()+"张优惠券");
    }


    @OnClick({R.id.iv_back, R.id.select_coupon})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                this.finish();
                break;
            case R.id.select_coupon:
                break;
        }
    }
}
