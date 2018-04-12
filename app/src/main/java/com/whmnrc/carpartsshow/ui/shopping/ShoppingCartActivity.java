package com.whmnrc.carpartsshow.ui.shopping;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.whmnrc.carpartsshow.R;
import com.whmnrc.carpartsshow.base.MvpActivity;
import com.whmnrc.carpartsshow.model.http.bean.LoginBean;
import com.whmnrc.carpartsshow.model.http.bean.OrderBean;
import com.whmnrc.carpartsshow.model.http.bean.ShopCarBean;
import com.whmnrc.carpartsshow.presenter.shopping.ShoppingCarPresenter;
import com.whmnrc.carpartsshow.presenter.shopping.contract.ShoppingCarContract;
import com.whmnrc.carpartsshow.ui.MainActivity;
import com.whmnrc.carpartsshow.ui.home.activity.GoodsDetailsActivity;
import com.whmnrc.carpartsshow.ui.shopping.activity.ConfirmOrderActivity;
import com.whmnrc.carpartsshow.ui.shopping.adapter.ShopCarAdapter;
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
 * Created by lizhe on 2018/3/12.
 */

public class ShoppingCartActivity extends MvpActivity<ShoppingCarPresenter> implements ShoppingCarContract.View, ShopCarAdapter.OnClickRequestListener {

    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.tv_menu)
    TextView tvMenu;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;
    @BindView(R.id.tv_all)
    TextView tvAll;
    @BindView(R.id.tv_price)
    TextView tvPrice;
    @BindView(R.id.tv_integral)
    TextView tvIntegral;
    @BindView(R.id.tv_pay)
    TextView tvPay;
    @BindView(R.id.iv_menu)
    ImageView ivMenu;
    @BindView(R.id.hj)
    TextView hj;
    @BindView(R.id.tv_collection)
    TextView tvCollection;
    @BindView(R.id.tv_delete)
    TextView tvDelete;
    @BindView(R.id.ll_show)
    LinearLayout mLlShow;
    @BindView(R.id.vs_empty)
    ViewStub vsEmpty;

    private ShopCarAdapter mAdapter;
    private LoginBean loginBean;
    private boolean isAll = false;
    private boolean isEdit = false;

    public static void start(Activity context) {
        Intent starter = new Intent(context, ShoppingCartActivity.class);
        context.startActivity(starter);
    }
    @Override
    protected int setLayout() {
        return R.layout.activity_shoppingcart;
    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected void setData() {
        title.setText("购物车");
        tvMenu.setText("编辑");
        loginBean = SpUtil.getObject(getApplicationContext(), "user");
        mPresenter.getShoppingCarData(loginBean.getRepairUser_ID(), 1);
        mAdapter = new ShopCarAdapter(getApplicationContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(mAdapter);
        mAdapter.setOnClickRequestListener(this);
        refresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                mPresenter.getShoppingCarData(loginBean.getRepairUser_ID(), 1);
                refresh.finishRefresh(3000);
            }
        });
        refresh.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                mPresenter.getShoppingCarData(loginBean.getRepairUser_ID(), 0);
                refresh.finishLoadmore(3000);
            }
        });
    }


    @OnClick({R.id.iv_back, R.id.tv_menu, R.id.tv_all, R.id.tv_pay,R.id.tv_collection, R.id.tv_delete})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                this.finish();
                break;
            case R.id.tv_menu:
                if (isEdit){
                    isEdit = false;
                    tvMenu.setText("编辑");
                    mLlShow.setVisibility(View.VISIBLE);
                    tvPay.setVisibility(View.VISIBLE);
                    tvCollection.setVisibility(View.GONE);
                    tvDelete.setVisibility(View.GONE);
                }else {
                    isEdit = true;
                    tvMenu.setText("完成");
                    mLlShow.setVisibility(View.GONE);
                    tvPay.setVisibility(View.GONE);
                    tvCollection.setVisibility(View.VISIBLE);
                    tvDelete.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.tv_all:
                Drawable drawable = null;
                if (!isAll) {
                    drawable = getResources().getDrawable(R.drawable.round_btn_selected);
                    isAll = true;
                } else {
                    drawable = getResources().getDrawable(R.drawable.round_btn_normal);
                    isAll = false;
                }
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                tvAll.setCompoundDrawables(drawable, null, null, null);
                mAdapter.allSelected(isAll);
                break;
            case R.id.tv_pay:
                String opis = "";
                for (ShopCarBean.ListCarProductBean listCarProductBean : mAdapter.getDataSource()) {
                    if (listCarProductBean.isSelected()){
                        opis += listCarProductBean.getProduct_ID()+","+listCarProductBean.getBuyCar_Num()+"|";
                    }
                }
                if (!TextUtils.isEmpty(opis)){
                    mPresenter.generateOrder(loginBean.getRepairUser_ID(),opis);
                }else {
                    CPSToast.showText(this, "您没有选中任何商品。");
                }
                break;
            case R.id.tv_collection:
                String pis = "";
                for (ShopCarBean.ListCarProductBean listCarProductBean:mAdapter.getDataSource()) {
                    if (listCarProductBean.isSelected()){
                        pis += listCarProductBean.getProduct_ID()+","+listCarProductBean.getProduct_Type()+"|";
                    }
                }
                if (!TextUtils.isEmpty(pis)){
                    mPresenter.collections(loginBean.getRepairUser_ID(),pis);
                }else {
                    CPSToast.showText(this, "您没有选中任何商品。");
                }
                break;
            case R.id.tv_delete:
                String cids = "";
                int num = 0;
                for (ShopCarBean.ListCarProductBean listCarProductBean:mAdapter.getDataSource()) {
                    if (listCarProductBean.isSelected()){
                        if (num == 0){
                            cids += listCarProductBean.getBuyCar_ID();
                        }else {
                            cids +=","+listCarProductBean.getBuyCar_ID();
                        }
                        num++;
                    }
                }
                if (!TextUtils.isEmpty(cids)){
                    mPresenter.delCards(loginBean.getRepairUser_ID(),cids);
                }else {
                    CPSToast.showText(this,"您没有选中任何商品。");
                }

                break;
        }
    }

    @Override
    public void stateError() {

    }

    @Override
    public void loadMore(ShopCarBean shopCarBean) {
        mAdapter.addFirstDataSet(shopCarBean.getListCarProduct());
        refresh.finishLoadmore();
    }

    @Override
    public void showContent(ShopCarBean shopCarBean) {
        mAdapter.addFirstDataSet(shopCarBean.getListCarProduct());
        refresh.finishRefresh();
    }

    //加减请求成功
    @Override
    public void updateNum(int type, int position) {
        if (type == 0) {
            int num = mAdapter.getDataSource().get(position).getBuyCar_Num() + 1;
            mAdapter.getDataSource().get(position).setBuyCar_Num(num);
            mAdapter.shopNotifyItemChanged(position);
        } else {
            int num = mAdapter.getDataSource().get(position).getBuyCar_Num() - 1;
            mAdapter.getDataSource().get(position).setBuyCar_Num(num);
            mAdapter.shopNotifyItemChanged(position);
        }
    }

    @Override
    public void state(String msg) {
        CPSToast.showText(this,msg);
    }

    @Override
    public void showToOrder(OrderBean orderBean) {
        String json = new Gson().toJson(orderBean);
        ConfirmOrderActivity.start(this,json,0);
    }

    //购物车加一
    @Override
    public void plus(ShopCarBean.ListCarProductBean item, int position) {
        mPresenter.plus(loginBean.getRepairUser_ID(), item.getProduct_ID(), item.getProduct_Type(), position);
    }

    //购物减一
    @Override
    public void reduce(ShopCarBean.ListCarProductBean item, int position) {
        mPresenter.reduce(loginBean.getRepairUser_ID(), item.getBuyCar_ID(), position);
    }

    //合计
    @Override
    public void updateTotal(String money, String integral, String num) {
        tvPrice.setText(money);
        tvIntegral.setText(integral);
        tvPay.setText("结算(" + num + ")");
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
        tvAll.setCompoundDrawables(drawable, null, null, null);
    }

    @Override
    public void goodsDetails(ShopCarBean.ListCarProductBean item) {
        GoodsDetailsActivity.newInstance(this,item.getProduct_ID(),item.getProduct_Type());
    }

    @Override
    public void showEmpty() {
        if (vsEmpty != null) {
            View view = vsEmpty.inflate();
            ImageView imageView = view.findViewById(R.id.iv_empty);
            TextView textView = view.findViewById(R.id.tv_empty_msg);
            TextView textView1 = view.findViewById(R.id.tv_to_home);
            imageView.setImageResource(R.drawable.shop_car_e);
            textView.setText("购物车什么都没有");
            textView1.setVisibility(View.VISIBLE);
            textView1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MainActivity.start(ShoppingCartActivity.this);
//                    EventBus.getDefault().post(new HomePageBean(4));
                }
            });
        }
    }

}
