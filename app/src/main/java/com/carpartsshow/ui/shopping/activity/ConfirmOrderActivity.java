package com.carpartsshow.ui.shopping.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import com.carpartsshow.R;
import com.carpartsshow.base.MvpActivity;
import com.carpartsshow.model.http.bean.OrderBean;
import com.carpartsshow.presenter.shopping.SubmitOrderPresenter;
import com.carpartsshow.presenter.shopping.contract.SubmitOrderContract;
import com.carpartsshow.ui.shopping.adapter.ConfirmOrderAdapter;
import com.carpartsshow.view.PayDialog;
import com.carpartsshow.widgets.CPSToast;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by lizhe on 2018/3/29.
 * 确认订单
 */

public class ConfirmOrderActivity extends MvpActivity<SubmitOrderPresenter> implements SubmitOrderContract.View {

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
    @BindView(R.id.tv_desc)
    TextView tvDesc;
    @BindView(R.id.tv_coupon)
    TextView tvCoupon;
    @BindView(R.id.hj)
    TextView hj;
    @BindView(R.id.tv_price)
    TextView tvPrice;
    @BindView(R.id.tv_integral)
    TextView tvIntegral;



    private OrderBean orderBean;
    private int type;
    private ConfirmOrderAdapter mAdapter;
    private OrderBean.ListReceiptAddressBean listReceiptAddressBean;
    private Map<String,Object> map = new HashMap<>();
    private String couponId;

//    public static void start(Context context,OrderBean orderBean) {
//        Intent intent = new Intent();
//        intent.putExtra("order",orderBean);
//        intent.setClass(context,ConfirmOrderActivity.class);
//        context.startActivity(intent);
//    }

    public static void start(Context context, String json) {
        Intent starter = new Intent(context, ConfirmOrderActivity.class);
        starter.putExtra("json", json);
        context.startActivity(starter);
    }


    @Override
    protected int setLayout() {
        return R.layout.activity_confirm_order;
    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected void setData() {
        String json = getIntent().getStringExtra("json");
        orderBean = new Gson().fromJson(json, OrderBean.class);
        type = getIntent().getIntExtra("type", 0);
        listReceiptAddressBean = orderBean.getListReceiptAddress().get(0);
        title.setText("确认订单");
        mAdapter = new ConfirmOrderAdapter(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(mAdapter);
        mAdapter.addFirstDataSet(orderBean.getListGoods());
        View view = LayoutInflater.from(this).inflate(R.layout.head_address, null);
        TextView address = view.findViewById(R.id.receipt_address);
        TextView contacts = view.findViewById(R.id.tv_contacts);
        TextView phone = view.findViewById(R.id.tv_phone);
        TextView addressDesc = view.findViewById(R.id.tv_address);
        RelativeLayout rlAddress = view.findViewById(R.id.rl_address);
        LinearLayout llAddress = view.findViewById(R.id.ll_receipt_address);
        if (TextUtils.isEmpty(listReceiptAddressBean.getMobile())) {
            rlAddress.setVisibility(View.GONE);
        } else {
            contacts.setText("联系人：" + orderBean.getCurrentRepairUser().getRepairUser_RealName());
            phone.setText(listReceiptAddressBean.getMobile());
            addressDesc.setText(listReceiptAddressBean.getDetailAddress());
            map.put("Mobile",listReceiptAddressBean.getMobile());
            map.put("Address",listReceiptAddressBean.getDetailAddress());
        }
        String name = orderBean.getCurrentRepairUser().getRepairUser_Name();
        address.setText("收货地址：" + name);

        llAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CPSToast.showText(getApplicationContext(), "呵呵哒");
            }
        });
        mAdapter.addHeaderView(view);
        textView.setText("您有" + orderBean.getCouponCount() + "张优惠券");
        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    CPSToast.showText(ConfirmOrderActivity.this,"选中");
                    map.put("Order_IsUrgent",true);
                }else {
                    CPSToast.showText(ConfirmOrderActivity.this,"没选中");
                    map.put("Order_IsUrgent",false);
                }
            }
        });

    }

    PayDialog payDialog;

    @OnClick({R.id.iv_back, R.id.select_coupon,R.id.tv_pay})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                this.finish();
                break;
            case R.id.select_coupon:
                //跳转优惠券页面
                break;
            case R.id.tv_pay:
                //提交订单
                payDialog = new PayDialog.Builder(this)
                        .setPayListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
//                                payDialog.select();
                                //提交订单
//                                map.put("Order_Remark",);
//                                map.put("Order_Remark",);
//                                map.put("Order_PayType",);
//                                map.put("IsUseCompanyName",);
//                                map.put("RepairUser_ID",);
//                                map.put("PersonName",);
//
//                                map.put("PersonName",);
//                                map.put("ProductAttrIds",);
                                if (!TextUtils.isEmpty(couponId)){
                                    map.put("Coupon_ID",couponId);
                                }

                            }
                        })
                        .setAliListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                payDialog.select(0);
                            }
                        })
                        .setCreditListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                payDialog.select(2);
                            }
                        })
                        .setWXListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                payDialog.select(1);
                            }

                        }).build();
                payDialog.select(0);
                payDialog.show();
                break;
        }
    }

    @Override
    public void stateError() {

    }

    @Override
    public void submitSuccess() {

    }
}
