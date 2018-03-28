package com.carpartsshow.ui.shopping;

import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.carpartsshow.R;
import com.carpartsshow.base.MvpActivity;
import com.carpartsshow.model.http.bean.LoginBean;
import com.carpartsshow.model.http.bean.ShopCarBean;
import com.carpartsshow.presenter.shopping.ShoppingCarPresenter;
import com.carpartsshow.presenter.shopping.contract.ShoppingCarContract;
import com.carpartsshow.ui.shopping.adapter.ShopCarAdapter;
import com.carpartsshow.util.SpUtil;
import com.carpartsshow.widgets.CPSToast;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
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

    private ShopCarAdapter mAdapter;
    private LoginBean loginBean;
    private boolean isAll = false;
    private boolean isEdit = false;

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
                break;
            case R.id.tv_collection:
                String pis = "";
                int num1 = 0;
                for (ShopCarBean.ListCarProductBean listCarProductBean:mAdapter.getDataSource()) {
                    if (listCarProductBean.isSelected()){
                        if (num1 == 0) {
                            pis += listCarProductBean.getProduct_ID();
                        }else {
                            pis += "," + listCarProductBean.getProduct_ID();
                        }
                        num1++;
                    }
                }
                if (!TextUtils.isEmpty(pis)){
                    mPresenter.collections(loginBean.getRepairUser_ID(),pis);
                }else {
                    CPSToast.showText(this, "至少选择一个");
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
                    CPSToast.showText(this,"至少选择一个");
                }

                break;
        }
    }

    @Override
    public void stateError() {

    }

    @Override
    public void loadMore(ShopCarBean shopCarBean) {

    }

    @Override
    public void showContent(ShopCarBean shopCarBean) {
        mAdapter.addFirstDataSet(shopCarBean.getListCarProduct());
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


}
