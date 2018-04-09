package com.carpartsshow.ui.me.activity;


import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.carpartsshow.R;
import com.carpartsshow.base.BaseActivity;
import com.carpartsshow.model.http.bean.LoginBean;
import com.carpartsshow.model.http.bean.UserInfoBean;
import com.carpartsshow.model.http.response.CPSResponse;
import com.carpartsshow.util.SpUtil;
import com.carpartsshow.view.NoMarginsTextView;
import com.carpartsshow.widgets.CPSToast;
import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by lizhe on 2018/3/16.
 */

public class MyMoneyActivity extends BaseActivity {
    @BindView(R.id.tv_price)
    NoMarginsTextView tvPrice;
    @BindView(R.id.tv_price_z)
    NoMarginsTextView tvPriceZ;

    public static void start(Context context,String json) {
        Intent starter = new Intent(context, MyMoneyActivity.class);
        starter.putExtra("userInfo",json);
        context.startActivity(starter);
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_my_money;
    }

    @Override
    protected void init() {

    }

    @Override
    protected void setData() {
        UserInfoBean userInfoBean = new Gson().fromJson(getIntent().getStringExtra("userInfo"),UserInfoBean.class);
        tvPrice.setText(userInfoBean.getCurrentRepairUser().getRepairUser_CreditBeOverMoney()+"");
        tvPriceZ.setText(userInfoBean.getCurrentRepairUser().getRepairUser_CreditMoney()+"");
    }


    @OnClick({R.id.iv_back, R.id.iv_ed, R.id.tv_hq, R.id.tv_wt, R.id.tv_te})
    public void onViewClicked(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.iv_back:
                this.finish();
                break;
            case R.id.iv_ed:
                intent.setClass(this,CreditMoneyActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_hq:
                intent.setClass(this,CreditMoneyActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_wt:
                CPSToast.showText(this,"暂不开放");
                break;
            case R.id.tv_te:
                CPSToast.showText(this,"暂不开放");
                break;
        }
    }
}
