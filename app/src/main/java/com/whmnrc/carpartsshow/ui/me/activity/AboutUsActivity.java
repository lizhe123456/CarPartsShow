package com.whmnrc.carpartsshow.ui.me.activity;

import android.widget.TextView;

import com.whmnrc.carpartsshow.R;
import com.whmnrc.carpartsshow.base.BaseActivity;
import com.whmnrc.carpartsshow.util.SystemUtil;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by lizhe on 2018/3/15.
 */

public class AboutUsActivity extends BaseActivity {

    @BindView(R.id.tv_version)
    TextView tvVersion;

    @Override
    protected int setLayout() {
        return R.layout.activity_aboutus;
    }

    @Override
    protected void init() {

    }

    @Override
    protected void setData() {
        tvVersion.setText("智配库（" + SystemUtil.getVerName(this)+"）");
    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        this.finish();
    }

}
