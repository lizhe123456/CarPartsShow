package com.carpartsshow.ui.me.activity;


import android.content.Intent;
import android.view.View;
import com.carpartsshow.R;
import com.carpartsshow.base.BaseActivity;
import com.carpartsshow.model.http.bean.LoginBean;
import com.carpartsshow.util.SpUtil;
import com.carpartsshow.view.NoMarginsTextView;
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

    @Override
    protected int setLayout() {
        return R.layout.activity_my_money;
    }

    @Override
    protected void init() {

    }

    @Override
    protected void setData() {
        LoginBean loginBean = SpUtil.getObject(this,"user");
        tvPrice.setText(loginBean.getRepairUser_CreditMoney() == null ? "0" : loginBean.getRepairUser_CreditMoney());
        tvPriceZ.setText("10,000");
    }


    @OnClick({R.id.iv_back, R.id.iv_ed, R.id.tv_hq, R.id.tv_wt, R.id.tv_te})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                this.finish();
                break;
            case R.id.iv_ed:
                Intent intent = new Intent();
                intent.setClass(this,CreditMoneyActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_hq:
                break;
            case R.id.tv_wt:
                break;
            case R.id.tv_te:
                break;
        }
    }
}