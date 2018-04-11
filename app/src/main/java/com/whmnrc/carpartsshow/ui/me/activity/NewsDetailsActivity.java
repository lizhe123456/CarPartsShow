package com.whmnrc.carpartsshow.ui.me.activity;

import android.content.Context;
import android.content.Intent;
import android.widget.TextView;

import com.whmnrc.carpartsshow.R;
import com.whmnrc.carpartsshow.base.BaseActivity;
import com.whmnrc.carpartsshow.view.X5WebView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by lizhe on 2018/4/3.
 */

public class NewsDetailsActivity extends BaseActivity {

    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.wv_x5)
    X5WebView wvX5;

    public static void start(Context context,String url) {
        Intent starter = new Intent(context, NewsDetailsActivity.class);
        starter.putExtra("url",url);
        context.startActivity(starter);
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_news_details;
    }

    @Override
    protected void init() {
        title.setText("新闻资讯");
    }

    @Override
    protected void setData() {
        String url = getIntent().getStringExtra("url");
        wvX5.loadUrl(url);
    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        this.finish();
    }
}
