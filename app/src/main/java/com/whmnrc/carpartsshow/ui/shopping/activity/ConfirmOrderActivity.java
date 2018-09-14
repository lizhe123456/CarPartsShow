package com.whmnrc.carpartsshow.ui.shopping.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
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
import com.bigkoo.pickerview.OptionsPickerView;
import com.whmnrc.carpartsshow.R;
import com.whmnrc.carpartsshow.base.MvpActivity;
import com.whmnrc.carpartsshow.base.adapter.BaseAdapter;
import com.whmnrc.carpartsshow.model.http.bean.CouponBean;
import com.whmnrc.carpartsshow.model.http.bean.LoginBean;
import com.whmnrc.carpartsshow.model.http.bean.OrderBean;
import com.whmnrc.carpartsshow.model.http.bean.OrderBeanV2;
import com.whmnrc.carpartsshow.model.http.bean.OrderListBean;
import com.whmnrc.carpartsshow.presenter.shopping.SubmitOrderPresenter;
import com.whmnrc.carpartsshow.presenter.shopping.contract.SubmitOrderContract;
import com.whmnrc.carpartsshow.ui.me.activity.MyCouponActivity;
import com.whmnrc.carpartsshow.ui.me.activity.MyOrderActivity;
import com.whmnrc.carpartsshow.ui.me.adapter.AddressAdapter;
import com.whmnrc.carpartsshow.ui.me.fragment.order.adapter.OrderGoodsAdapter;
import com.whmnrc.carpartsshow.ui.shopping.adapter.ConfirmOrderAdapter;
import com.whmnrc.carpartsshow.util.SpUtil;
import com.whmnrc.carpartsshow.view.PayDialog;
import com.whmnrc.carpartsshow.view.ZlCustomDialog;
import com.whmnrc.carpartsshow.widgets.CPSToast;
import com.whmnrc.carpartsshow.widgets.CurrencyDialog;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    @BindView(R.id.tv_price)
    TextView tvPrice;
    @BindView(R.id.tv_integral)
    TextView tvIntegral;
    @BindView(R.id.coupon)
    TextView tvCouponTop;
    @BindView(R.id.select_warehouse)
    TextView tvSelectt;



    private int type;
    private Map<String,Object> map = new HashMap<>();
    private String couponId;
    private LoginBean loginBean;
    PayDialog payDialog;
    private AddressAdapter addressAdapter;
    private int price = 0;
    private int integer = 0;
    CurrencyDialog currencyDialog;
    OrderBeanV2.ListReceiptAddressBean addressBean;
    OrderBeanV2 orderBean;
    private String warehouseCode;
    private OptionsPickerView mPickerView;

    public static void start(Context context, String json,int type) {
        Intent starter = new Intent(context, ConfirmOrderActivity.class);
        starter.putExtra("json", json);
        starter.putExtra("type",type);
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
        type = getIntent().getIntExtra("type", 0);
        String json = getIntent().getStringExtra("json");
        View view = LayoutInflater.from(this).inflate(R.layout.head_address, null);
        //初始化头部
        final TextView contacts = view.findViewById(R.id.tv_contacts);
        final TextView phone = view.findViewById(R.id.tv_phone);
        final TextView addressDesc = view.findViewById(R.id.tv_address);
        final RelativeLayout rlAddress = view.findViewById(R.id.rl_address);
        LinearLayout llAddress = view.findViewById(R.id.ll_receipt_address);
        final TextView address = view.findViewById(R.id.receipt_address);
        title.setText("确认订单");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setNestedScrollingEnabled(false);
        loginBean = SpUtil.getObject(this,"user");
        if (type == 0){
            orderBean = new Gson().fromJson(json, OrderBeanV2.class);
            addressBean = orderBean.getListReceiptAddress().get(0);
            ConfirmOrderAdapter mAdapter = new ConfirmOrderAdapter(this);
            recyclerView.setAdapter(mAdapter);
            mAdapter.addFirstDataSet(orderBean.getListGoods());

            if (TextUtils.isEmpty(addressBean.getMobile())) {
                rlAddress.setVisibility(View.GONE);
                String name = addressBean.getDetailAddress();
                address.setText("收货地址：" + name);
            } else {
                address.setVisibility(View.GONE);
                contacts.setText(addressBean.getPersonName());
                phone.setText(addressBean.getMobile());
                addressDesc.setText(addressBean.getProvice()+" "+addressBean.getCity()+" "+addressBean.getRegion()+" "+addressBean.getDetailAddress());
            }
            llAddress.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //地址选择
                    final ZlCustomDialog dialog = new ZlCustomDialog(ConfirmOrderActivity.this);
                    addressAdapter = new AddressAdapter(ConfirmOrderActivity.this);
                    addressAdapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
                        @Override
                        public void onClick(View view, Object item, int position) {
                            addressBean = (OrderBeanV2.ListReceiptAddressBean) item;
                            if (TextUtils.isEmpty(addressBean.getMobile())) {
                                rlAddress.setVisibility(View.GONE);
                                String name = addressBean.getDetailAddress();
                                address.setText("收货地址：" + name);
                            } else {
                                address.setVisibility(View.GONE);
                                contacts.setText(addressBean.getPersonName());
                                phone.setText(addressBean.getMobile());
                                addressDesc.setText(addressBean.getDetailAddress());
                            }
                            initParam(orderBean);
                            dialog.cancel();
                        }
                    });
                    dialog.show(addressAdapter,orderBean.getListReceiptAddress());

                }
            });
            textView.setText("您有" + orderBean.getCouponCount() + "张优惠券");
            for (OrderBeanV2.ListGoodsBean goodsBean : orderBean.getListGoods()) {
                if (goodsBean.getGoods_Type() == 2){
                    integer += goodsBean.getGoods_Price() * goodsBean.getNumber();

                }else {
                    price += goodsBean.getGoods_Price() * goodsBean.getNumber();
                }
            }
            mAdapter.addHeaderView(view);
            initParam(orderBean);
        }else {
            //从我的订单跳过来的，重新提交订单
            OrderListBean.DataBean dataBean = new Gson().fromJson(json, OrderListBean.DataBean.class);
            if (TextUtils.isEmpty(dataBean.getAddress_Mobile())) {
                rlAddress.setVisibility(View.GONE);
                String name = dataBean.getAddress_FullAddress();
                address.setText("收货地址：" + name);
            } else {
                address.setVisibility(View.GONE);
                contacts.setText(dataBean.getAddress_Name());
                phone.setText(dataBean.getAddress_Mobile());
                addressDesc.setText(dataBean.getAddress_FullAddress());
            }

            OrderGoodsAdapter mAdapter = new OrderGoodsAdapter(this);
            recyclerView.setAdapter(mAdapter);
            mAdapter.addFirstDataSet(dataBean.getDetail());

            for (OrderListBean.DataBean.DetailBean goodsBean : dataBean.getDetail()) {
                if (goodsBean.getProduct_Type() == 2){
                    integer += goodsBean.getOrderItem_Money() * goodsBean.getOrderItem_Number();
                }else {
                    price += goodsBean.getOrderItem_Money() * goodsBean.getOrderItem_Number();
                }
            }
            tvCoupon.setText("已优惠："+dataBean.getOrder_CouponMoney()+".00元");
            tvCouponTop.setText("优惠券优惠金额"+dataBean.getOrder_CouponMoney()+".00元");
            textView.setVisibility(View.GONE);
            switch1.setChecked(dataBean.isOrder_IsUseCompanyName());
            switch1.setClickable(false);
            if (dataBean.getOrder_Remark() != null) {
                etDesc.setText(dataBean.getOrder_Remark().toString());
            }
            etDesc.setClickable(false);
            etDesc.setFocusable(false);
            mAdapter.addHeaderView(view);
            map.put("Order_IsUrgent",dataBean.isOrder_IsUseCompanyName());
            map.put("RepairUser_ID",loginBean.getRepairUser_ID());
            map.put("Mobile",dataBean.getAddress_Mobile());
            map.put("Order_IsUrgent",true);
            String productAttrIds = "";
            for (int i = 0; i < dataBean.getDetail().size(); i++) {
                if (i == dataBean.getDetail().size()-1){
                    productAttrIds += dataBean.getDetail().get(i).getProduct_ID() + "," + dataBean.getDetail().get(i).getOrderItem_Number();
                }else {
                    productAttrIds += dataBean.getDetail().get(i).getProduct_ID() + "," + dataBean.getDetail().get(i).getOrderItem_Number()+"|";
                }
            }
            map.put("ProductAttrIds",productAttrIds);
            if (TextUtils.isEmpty(dataBean.getAddress_Mobile())){
                map.put("IsUseCompanyName","1");
            }else {
                map.put("PersonName",dataBean.getAddress_Name());
                map.put("IsUseCompanyName","0");
            }
            map.put("Address",dataBean.getAddress_FullAddress());
            map.put("Order_IsUrgent",switch1.isChecked());
        }

        tvPrice.setText("¥"+price+".00");
        tvIntegral.setText("积分："+integer);
        currencyDialog = new CurrencyDialog.Builder(ConfirmOrderActivity.this)
                .setNegativeButton("取消", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        currencyDialog.dismiss();
                    }
                }).setPositiveButton("确认",
                        new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mPresenter.submitOrder(map);
                        currencyDialog.dismiss();

                    }
                })
                .setMessage("确定要支付吗？")
                .setCancelable(true)
                .build();
    }

    private void initParam(OrderBeanV2 orderBean) {
        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    map.put("Order_IsUrgent",true);
                }else {
                    map.put("Order_IsUrgent",false);
                }
            }
        });
        String productAttrIds = "";
        for (int i = 0; i < orderBean.getListGoods().size(); i++) {
            if (i == orderBean.getListGoods().size()-1){
                productAttrIds += orderBean.getListGoods().get(i).getGoods_ID() + "," + orderBean.getListGoods().get(i).getNumber();
            }else {
                productAttrIds += orderBean.getListGoods().get(i).getGoods_ID() + "," + orderBean.getListGoods().get(i).getNumber()+"|";
            }
        }
        map.put("ProductAttrIds",productAttrIds);
        map.put("RepairUser_ID",loginBean.getRepairUser_ID());


        if (TextUtils.isEmpty(addressBean.getMobile())){

        }else {
            map.put("Mobile",addressBean.getMobile());
        }

        if (TextUtils.isEmpty(addressBean.getPersonName())){
            map.put("IsUseCompanyName","1");
        }else {
            map.put("PersonName",addressBean.getPersonName());
            map.put("IsUseCompanyName","0");
        }
        map.put("Address",addressBean.getDetailAddress());
        map.put("Order_IsUrgent",switch1.isChecked());
    }


    @OnClick({R.id.iv_back, R.id.select_coupon,R.id.tv_pay,R.id.rl_warehouse})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                this.finish();
                break;
            case R.id.select_coupon:
                //跳转优惠券页面
                MyCouponActivity.start(this);
                break;
            case R.id.tv_pay:
                //提交订单
                payDialog = new PayDialog.Builder(this)
                        .setPayListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
//                                payDialog.select();
                                //提交订单
                                if (!TextUtils.isEmpty(etDesc.getText().toString())) {
                                    map.put("Order_Remark", etDesc.getText().toString());
                                }
                                if (!TextUtils.isEmpty(warehouseCode)){
                                    map.put("WarehouseCode",warehouseCode);
                                }
                                map.put("Order_PayType",type);
                                if (type == 0){
                                    /**
                                     * AliPayTools.aliPay(mContext,
                                         APP_ID,//支付宝分配的APP_ID
                                         isRSA2,//是否是 RSA2 加密
                                         RSA_PRIVATE,// RSA 或 RSA2 字符串
                                         new AliPayModel(order_id,//订单ID (唯一)
                                         money,//价格
                                         name,//商品名称
                                         detail),//商品描述详情 (用于显示在 支付宝 的交易记录里)
                                         new onRequestListener() {
                                        @Override
                                        public void onSuccess(String s) {RxToast.success("支付成功");}

                                        @Override
                                        public void onError(String s) {RxToast.error("支付失败");
                                        }
                                        });
                                     */
                                    CPSToast.showText(ConfirmOrderActivity.this, "暂未不支持");
                                }else if (type == 1){
                                    /**
                                     * wechatPayApp(mContext,
                                         app_id, //微信分配的APP_ID
                                         partner_id, //微信分配的 PARTNER_ID (商户ID)
                                         wx_private_key, //微信分配的 PRIVATE_KEY (私钥)
                                         prepay_id, //订单ID (唯一)
                                         new onRequestListener() {
                                        @Override
                                        public void onSuccess(String s) {}

                                        @Override
                                        public void onError(String s) {}
                                        });
                                     */

                                    CPSToast.showText(ConfirmOrderActivity.this, "暂未不支持");
                                }else if (type == 2){
                                    currencyDialog.show();
                                }
                            }
                        })
                        .setAliListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                payDialog.select(0);
                                type = 0;
                            }
                        })
                        .setCreditListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                payDialog.select(2);
                                type = 2;
                            }
                        })
                        .setWXListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                payDialog.select(1);
                                type = 1;
                            }

                        }).build();
                payDialog.show();
                payDialog.select(0);
                type = 0;
                break;
            case R.id.rl_warehouse:
                mPickerView = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int options2, int options3, View v) {
                        warehouseCode = orderBean.getWarehouseList().get(options1).getCode();
                        tvSelectt.setText(orderBean.getWarehouseList().get(options1).getName());
                        mPickerView.dismiss();
                        map.put("WarehouseId",orderBean.getWarehouseList().get(options1).getId());
                    }
                }).setTitleText("仓库选择")
                        .setCyclic(false, false, false)
                        .setDividerColor(R.color.tv_ccc)
                        .setTextColorCenter(Color.BLACK) //设置选中项文字颜色
                        .setContentTextSize(20)
                        .build();
                if (orderBean.getWarehouseList() != null && orderBean.getWarehouseList().size() > 0) {
                    List<String> list = new ArrayList<>();
                    for (OrderBeanV2.WarehouseListBean warehouse:orderBean.getWarehouseList()) {
                        list.add(warehouse.getName());
                    }
                    mPickerView.setPicker(list);
                    //三级选择器
                    mPickerView.show();
                }else {
                    CPSToast.showText(this,"没有可用仓库");
                }

                break;
        }
    }



    @Override
    public void stateError() {

    }

    @Override
    public void submitSuccess() {
        MyOrderActivity.start(this,1);
        ConfirmOrderActivity.this.finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0){
            if (resultCode == 2){
                CouponBean couponBean = new Gson().fromJson(data.getStringExtra("coupon"),CouponBean.class);
                couponId = couponBean.getCoupon_ID();

                if (price >= couponBean.getCoupon_FullMoneyUse()){
                    map.put("Coupon_ID",couponId);
                    tvCoupon.setText("使用优惠券优惠"+couponBean.getCoupon_Money()+".00元");
                }else {
                    CPSToast.showText(this,"未满"+couponBean.getCoupon_FullMoneyUse()+"元");
                    tvCoupon.setText("暂未优惠");
                }

            }else if (resultCode == 3){
                //不使用优惠券
                map.remove("Coupon_ID");
                tvCoupon.setText("暂未优惠");
            }
        }
    }
}
