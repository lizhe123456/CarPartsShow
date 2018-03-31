package com.carpartsshow.ui.home.activity;

import android.content.Context;
import android.content.Intent;
import com.carpartsshow.R;
import com.carpartsshow.base.MvpActivity;
import com.carpartsshow.model.http.bean.LoginBean;
import com.carpartsshow.presenter.home.GoodsDetailsPresenter;
import com.carpartsshow.presenter.home.contract.GoodsDetailsContract;
import com.carpartsshow.util.SpUtil;
import com.carpartsshow.view.X5WebView;
import butterknife.BindView;

/**
 * Created by lizhe on 2018/3/26.
 */

public class GoodsDetailsActivity extends MvpActivity<GoodsDetailsPresenter> implements GoodsDetailsContract.View {

    @BindView(R.id.wv_x5)
    X5WebView wvX5;

    private String gid;

    public static void newInstance(Context context,String gid){
        Intent intent = new Intent();
        intent.putExtra("gid",gid);
        intent.setClass(context,GoodsDetailsActivity.class);
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
        gid = getIntent().getStringExtra("gid");
        LoginBean loginBean = SpUtil.getObject(this,"user");
        mPresenter.getGoods(loginBean.getRepairUser_ID(),gid);
    }

    @Override
    public void stateError() {

    }

    @Override
    public void shoeGoodsDetails(String url) {
        wvX5.loadUrl(url);
    }
}
