package com.carpartsshow.ui.me.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import com.carpartsshow.R;
import com.carpartsshow.base.BaseActivity;
import com.carpartsshow.base.MvpActivity;
import com.carpartsshow.model.http.bean.IntergralShopBean;
import com.carpartsshow.model.http.bean.LoginBean;
import com.carpartsshow.presenter.me.IntegralGoodsPresenter;
import com.carpartsshow.presenter.me.contract.IntegralGoodsContract;
import com.carpartsshow.ui.me.adapter.GoodsAdapter;
import com.carpartsshow.util.SpUtil;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by lizhe on 2018/3/16.
 * 积分兑换
 */

public class IntegralGoodsActivity extends MvpActivity<IntegralGoodsPresenter> implements IntegralGoodsContract.View {

    @BindView(R.id.et_search)
    EditText etSearch;
    @BindView(R.id.tv_zh)
    TextView tvZh;
    @BindView(R.id.tv_xl)
    TextView tvXl;
    @BindView(R.id.tv_jf)
    TextView tvJf;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;

    private GoodsAdapter mAdapter;

    private String textMsg;
    private String userId;

    @Override
    protected int setLayout() {
        return R.layout.activity_integral_goods;
    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected void setData() {
        LoginBean loginBean = SpUtil.getObject(this,"user");
        userId = loginBean.getRepairUser_ID();
        mPresenter.getGoodsInfo(1,"",userId,"");
        mAdapter = new GoodsAdapter(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(mAdapter);
        etSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH){
                    textMsg = etSearch.getText().toString().trim();
                    mPresenter.getGoodsInfo(1,textMsg,userId,"");
                    return true;
                }
                return false;
            }
        });
    }

    @OnClick({R.id.iv_back, R.id.tv_zh, R.id.tv_xl, R.id.tv_jf})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                this.finish();
                break;
            case R.id.tv_zh:
                break;
            case R.id.tv_xl:
                break;
            case R.id.tv_jf:
                break;
        }
    }

    @Override
    public void stateError() {

    }

    @Override
    public void showContent(List<IntergralShopBean.IstIntegerGoods> list) {
        mAdapter.addFirstDataSet(list);
    }

    @Override
    public void loadMore(List<IntergralShopBean.IstIntegerGoods> list) {

    }
}
