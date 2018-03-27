package com.carpartsshow.ui.home.activity;

import com.carpartsshow.R;
import com.carpartsshow.base.BaseActivity;
import com.carpartsshow.view.X5WebView;
import butterknife.BindView;

/**
 * Created by lizhe on 2018/3/26.
 */

public class GoodsDetailsActivity extends BaseActivity {

    @BindView(R.id.wv_x5)
    X5WebView wvX5;

    private String webUrl;

    @Override
    protected int setLayout() {
        return R.layout.activity_goods_details;
    }

    @Override
    protected void init() {
        wvX5.loadUrl(webUrl);
    }

    @Override
    protected void setData() {

    }
}
