package com.whmnrc.carpartsshow.ui.home.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.whmnrc.carpartsshow.R;
import com.whmnrc.carpartsshow.base.MvpActivity;
import com.whmnrc.carpartsshow.model.http.bean.GoodsDetailBean;
import com.whmnrc.carpartsshow.model.http.bean.GoodsDetailToBean;
import com.whmnrc.carpartsshow.model.http.bean.IntergralShopBean;
import com.whmnrc.carpartsshow.model.http.bean.LoginBean;
import com.whmnrc.carpartsshow.model.http.bean.OrderBean;
import com.whmnrc.carpartsshow.model.http.bean.SeckillGoodsDetail;
import com.whmnrc.carpartsshow.model.http.bean.UserInfoBean;
import com.whmnrc.carpartsshow.presenter.home.GoodsDetailsPresenter;
import com.whmnrc.carpartsshow.presenter.home.contract.GoodsDetailsContract;
import com.whmnrc.carpartsshow.ui.shopping.ShoppingCartActivity;
import com.whmnrc.carpartsshow.ui.shopping.activity.ConfirmOrderActivity;
import com.whmnrc.carpartsshow.util.ScreenUtils;
import com.whmnrc.carpartsshow.util.SpUtil;
import com.whmnrc.carpartsshow.view.X5WebView;
import com.whmnrc.carpartsshow.widgets.CPSToast;
import com.google.gson.Gson;
import com.tencent.smtt.sdk.WebView;

import butterknife.BindView;
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
    private GoodsDetailToBean specialOfferBean;
    private IntergralShopBean.IstIntegerGoods istIntegerGoods;

    public static void newInstance(Context context, String gid,int goodsType) {
        Intent intent = new Intent();
        intent.putExtra("gid", gid);
        intent.putExtra("gType", goodsType);
        intent.setClass(context, GoodsDetailsActivity.class);
        context.startActivity(intent);
    }

    public static void newInstance(Context context, GoodsDetailToBean goodsDetailToBean) {
        Intent intent = new Intent();
        intent.putExtra("goodsDetailToBean", goodsDetailToBean);
        intent.setClass(context, GoodsDetailsActivity.class);
        context.startActivity(intent);
    }
    public static void newInstance(Context context, IntergralShopBean.IstIntegerGoods istIntegerGoods) {
        Intent intent = new Intent();
        intent.putExtra("istIntegerGoods", istIntegerGoods);
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
        specialOfferBean = (GoodsDetailToBean) getIntent().getSerializableExtra("goodsDetailToBean");
        istIntegerGoods = (IntergralShopBean.IstIntegerGoods) getIntent().getSerializableExtra("istIntegerGoods");
        if (!TextUtils.isEmpty(gid)){
            mPresenter.getGoods(loginBean.getRepairUser_ID(), gid);

        }else if (specialOfferBean != null){
            wvX5.loadUrl(specialOfferBean.getUrl());
            tvNum.setText(specialOfferBean.getCount()+"");
            if (specialOfferBean.isCollection()){
                Drawable nav_up = getResources().getDrawable(R.drawable.like_select);
                nav_up.setBounds(0, 0, nav_up.getMinimumWidth(), nav_up.getMinimumHeight());
                tvCollection.setCompoundDrawables(null, nav_up, null, null);
            }else {
                Drawable nav_up = getResources().getDrawable(R.drawable.like_normal);
                nav_up.setBounds(0, 0, nav_up.getMinimumWidth(), nav_up.getMinimumHeight());
                tvCollection.setCompoundDrawables(null, nav_up,null , null);
            }
            isCollections = specialOfferBean.isCollection();
        }else if (istIntegerGoods != null){
            wvX5.loadUrl(istIntegerGoods.getUrl());
            tvNum.setText(istIntegerGoods.getCarCount()+"");
            if (istIntegerGoods.isCollection()){
                Drawable nav_up = getResources().getDrawable(R.drawable.like_select);
                nav_up.setBounds(0, 0, nav_up.getMinimumWidth(), nav_up.getMinimumHeight());
                tvCollection.setCompoundDrawables(null, nav_up, null, null);
            }else {
                Drawable nav_up = getResources().getDrawable(R.drawable.like_normal);
                nav_up.setBounds(0, 0, nav_up.getMinimumWidth(), nav_up.getMinimumHeight());
                tvCollection.setCompoundDrawables(null, nav_up,null , null);
            }
            isCollections = istIntegerGoods.isCollection();
        }
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
                customerServicePhone();
                break;
            case R.id.tv_collection:
                //收藏
                if (goodsDetailBean != null) {
                    String pids = goodsDetailBean.getVGoods().getGoods_ID()+",0"+"|";
                    if (isCollections) {
                        mPresenter.delCollections(pids);
                        isCollections = false;
                    } else {
                        mPresenter.collections(loginBean.getRepairUser_ID(), pids);
                        isCollections = true;
                    }

                }else if (specialOfferBean != null){
                    String[] pid = specialOfferBean.getUrl().split("Seckill_ID=");
                    String pids = pid[pid.length-1]+",1"+"|";
                    if (isCollections) {
                        mPresenter.delCollections(pids);
                        isCollections = false;
                    } else {
                        mPresenter.collections(loginBean.getRepairUser_ID(),pids);
                        isCollections = true;
                    }
                }else if (istIntegerGoods != null){
                    if (isCollections){
                        mPresenter.delCollections(istIntegerGoods.getIntegerGoods_ID()+",2|");
                        isCollections = false;
                    }else {
                        mPresenter.collections(loginBean.getRepairUser_ID(),istIntegerGoods.getIntegerGoods_ID()+",2|");
                        isCollections = true;
                    }
                }
                break;
            case R.id.tv_pay:
                //支付
                if (goodsDetailBean != null) {
                    mPresenter.generateOrder(loginBean.getRepairUser_ID(), goodsDetailBean.getVGoods().getGoods_ID() + ",1|");
                }else if (specialOfferBean != null){
                    String[] pid = specialOfferBean.getUrl().split("Seckill_ID=");
                    mPresenter.generateOrder(loginBean.getRepairUser_ID(), pid[pid.length-1] + ",1|");
                }else if (istIntegerGoods != null){
                    mPresenter.generateOrder(loginBean.getRepairUser_ID(), istIntegerGoods.getIntegerGoods_ID() + ",1|");
                } else {

                }
                break;
            case R.id.tv_join_car:
                //加入购物车
                if (goodsDetailBean != null) {
                    mPresenter.plus(loginBean.getRepairUser_ID(), goodsDetailBean.getVGoods().getGoods_ID(), goodsType);
                }else if (specialOfferBean != null){
                    String[] pid = specialOfferBean.getUrl().split("Seckill_ID=");
                    mPresenter.plus(loginBean.getRepairUser_ID(), pid[pid.length-1],1);
                }else if (istIntegerGoods != null){
                    mPresenter.plus(loginBean.getRepairUser_ID(), istIntegerGoods.getIntegerGoods_ID(),2);
                }
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

    @Override
    public void showSeckillGoods(SeckillGoodsDetail seckillGoodsDetail) {
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
                ScreenUtils.diallPhone(GoodsDetailsActivity.this,tv_phone_1.getText().toString().trim());
            }
        });
        tv_phone_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ScreenUtils.diallPhone(GoodsDetailsActivity.this,tv_phone_2.getText().toString().trim());
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

}
