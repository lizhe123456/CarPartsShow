package com.whmnrc.carpartsshow.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import com.whmnrc.carpartsshow.app.App;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/8/18 0018.
 * Activity基类
 */

public abstract class BaseActivity extends AppCompatActivity {

    protected Activity mActivity;
    private Unbinder mUnbinder;
    protected View mView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = this;
        mView = LayoutInflater.from(this).inflate(setLayout(),null);
        setContentView(mView);
        mUnbinder = ButterKnife.bind(mActivity);
        App.getInstance().addActivity(mActivity);
        init();
        setData();
    }

    @LayoutRes
    protected abstract int setLayout();

    protected abstract void init();

    protected abstract void setData();




    /**
     * 防止快速点击
     *
     * @return
     */
    private boolean fastClick() {
        long lastClick = 0;
        if (System.currentTimeMillis() - lastClick <= 1000) {
            return false;
        }
        lastClick = System.currentTimeMillis();
        return true;

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        App.getInstance().removeActivity(this);
        mUnbinder.unbind();
    }

    /**
     * 检测view是否显示
     * @param view
     * @return
     */
    protected boolean isShow(View view){
        if (view.getVisibility() == View.VISIBLE){
            return true;
        }else {
            return false;
        }
    }


}
