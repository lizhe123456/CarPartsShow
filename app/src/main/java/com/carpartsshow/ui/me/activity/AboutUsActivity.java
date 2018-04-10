package com.carpartsshow.ui.me.activity;

import android.widget.TextView;
import com.carpartsshow.R;
import com.carpartsshow.base.BaseActivity;
import com.carpartsshow.util.SystemUtil;

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
        tvVersion.setText(SystemUtil.getVerName(this) + SystemUtil.getVersionCode(this));
    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        this.finish();
    }

}
