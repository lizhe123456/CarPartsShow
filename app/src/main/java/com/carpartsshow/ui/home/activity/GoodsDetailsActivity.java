package com.carpartsshow.ui.home.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.carpartsshow.R;
import com.carpartsshow.base.MvpActivity;
import com.carpartsshow.model.http.bean.GoodsDetailBean;
import com.carpartsshow.model.http.bean.LoginBean;
import com.carpartsshow.model.http.bean.OrderBean;
import com.carpartsshow.presenter.home.GoodsDetailsPresenter;
import com.carpartsshow.presenter.home.contract.GoodsDetailsContract;
import com.carpartsshow.ui.shopping.ShoppingCartActivity;
import com.carpartsshow.ui.shopping.activity.ConfirmOrderActivity;
import com.carpartsshow.util.SpUtil;
import com.carpartsshow.view.X5WebView;
import com.carpartsshow.widgets.CPSToast;
import com.google.gson.Gson;
import com.tencent.smtt.sdk.WebView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lizhe on 2018/3/26.
 */

public class GoodsDetailsActivity extends MvpActivity<GoodsDetailsPresenter> implements GoodsDetailsContract.View {

    @BindView(R.id.wv_x5)
    X5WebView wvX5;
    @BindView(R.id.tv_num)
    TextView tvNum;
    @BindView(R.id.tv_collection)
    TextView tvCollection;

    private String gid;
    private int goodsType;
    private GoodsDetailBean goodsDetailBean;
    private LoginBean loginBean;
    private boolean isCollections;
    private View contentView;

    public static void newInstance(Context context, String gid,int goodsType) {
        Intent intent = new Intent();
        intent.putExtra("gid", gid);
        intent.putExtra("gType", goodsType);
        intent.setClass(context, GoodsDetailsActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_goods_details;
    }


    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected void setData() {
        loading("加载中..");
        gid = getIntent().getStringExtra("gid");
        loginBean = SpUtil.getObject(this,"user");
        goodsType = getIntent().getIntExtra("gType",0);
        LoginBean loginBean = SpUtil.getObject(this, "user");
        mPresenter.getGoods(loginBean.getRepairUser_ID(), gid);
        wvX5.setOnWebViewListener(new X5WebView.OnWebViewListener() {
            @Override
            public void onProgressChange(WebView view) {
                unLoading();
            }

            @Override
            public void onPageFinish(WebView view) {
                unLoading();
            }
        });
    }

    @Override
    public void stateError() {

    }



    @OnClick({R.id.iv_back, R.id.rl_menu, R.id.tv_service, R.id.tv_collection, R.id.tv_pay, R.id.tv_join_car})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                this.finish();
                break;
            case R.id.rl_menu:
                ShoppingCartActivity.start(this);
                break;
            case R.id.tv_service:
                //客服
                show(goodsDetailBean.getListServicePhone());
                break;
            case R.id.tv_collection:
                //收藏
                if (isCollections){
                    mPresenter.delCollections(goodsDetailBean.getVGoods().getGoods_ID());
                    isCollections = false;
                }else {
                    mPresenter.collections(loginBean.getRepairUser_ID(),goodsDetailBean.getVGoods().getGoods_ID());
                    isCollections = true;
                }

                break;
            case R.id.tv_pay:
                //支付
                mPresenter.generateOrder(loginBean.getRepairUser_ID(),goodsDetailBean.getVGoods().getGoods_ID()+",1|");
                break;
            case R.id.tv_join_car:
                //加入购物车
                mPresenter.plus(loginBean.getRepairUser_ID(),goodsDetailBean.getVGoods().getGoods_ID(),goodsType);
                break;
        }
    }

    @Override
    public void shoeGoodsDetails(GoodsDetailBean goodsDetailBean) {
        this.goodsDetailBean = goodsDetailBean;
        wvX5.loadUrl(goodsDetailBean.getUrl());
        tvNum.setText(goodsDetailBean.getCarCount()+"");
        if (goodsDetailBean.isIsCollection()){
            Drawable nav_up = getResources().getDrawable(R.drawable.like_select);
            nav_up.setBounds(0, 0, nav_up.getMinimumWidth(), nav_up.getMinimumHeight());
            tvCollection.setCompoundDrawables(null, nav_up, null, null);
        }else {
            Drawable nav_up = getResources().getDrawable(R.drawable.like_normal);
            nav_up.setBounds(0, 0, nav_up.getMinimumWidth(), nav_up.getMinimumHeight());
            tvCollection.setCompoundDrawables(null, nav_up,null , null);
        }
        isCollections = goodsDetailBean.isIsCollection();
    }


    @Override
    public void state(String msg) {
        CPSToast.showText(this,msg);
        if (msg.contains("收藏")){
            if (isCollections){
                Drawable nav_up = getResources().getDrawable(R.drawable.like_select);
                nav_up.setBounds(0, 0, nav_up.getMinimumWidth(), nav_up.getMinimumHeight());
                tvCollection.setCompoundDrawables(null, nav_up, null, null);
            }else {
                Drawable nav_up = getResources().getDrawable(R.drawable.like_normal);
                nav_up.setBounds(0, 0, nav_up.getMinimumWidth(), nav_up.getMinimumHeight());
                tvCollection.setCompoundDrawables(null, nav_up,null , null);
            }
        }
    }

    @Override
    public void showToOrder(OrderBean orderBean) {
        String json = new Gson().toJson(orderBean);
        ConfirmOrderActivity.start(this,json,0);
    }

    private void show(List<GoodsDetailBean.ListServicePhoneBean> list){
        contentView = LayoutInflater.from(this).inflate(R.layout.dialog_content_normal, null);
        TextView tv_cancel = contentView.findViewById(R.id.tv_cancel);
        TextView tv_phone_2 = contentView.findViewById(R.id.tv_phone_2);
        TextView tv_phone_1 = contentView.findViewById(R.id.tv_phone_1);
        try{
            tv_phone_1.setText(list.get(0).getItemValue());
            tv_phone_2.setText(list.get(1).getItemValue());
        }catch (Exception e){

        }
        final Dialog bottomDialog = new Dialog(this, R.style.BottomDialog);
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

}
