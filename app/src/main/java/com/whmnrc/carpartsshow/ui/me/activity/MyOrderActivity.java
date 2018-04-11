package com.whmnrc.carpartsshow.ui.me.activity;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.whmnrc.carpartsshow.R;
import com.whmnrc.carpartsshow.base.BaseActivity;
import com.whmnrc.carpartsshow.model.http.bean.UserInfoBean;
import com.whmnrc.carpartsshow.ui.me.fragment.order.OrderItem1Fragment;
import com.whmnrc.carpartsshow.ui.me.fragment.order.OrderItem2Fragment;
import com.whmnrc.carpartsshow.ui.me.fragment.order.OrderItem3Fragment;
import com.whmnrc.carpartsshow.ui.me.fragment.order.OrderItem4Fragment;
import com.whmnrc.carpartsshow.ui.me.fragment.order.OrderItem5Fragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by lizhe on 2018/3/15.
 */

public class MyOrderActivity extends BaseActivity {

    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.viewPager)
    ViewPager viewPager;

    private List<String> mTitleList;
    private List<Fragment> fragments;

    private int selectPage;

    public static void start(Context context, int page) {
        Intent starter = new Intent(context, MyOrderActivity.class);
        starter.putExtra("page",page);
        context.startActivity(starter);
    }
    public static void start(Context context,UserInfoBean userInfoBean) {
        Intent starter = new Intent(context, MyOrderActivity.class);
        starter.putExtra("userInfo",userInfoBean);
        context.startActivity(starter);
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_order;
    }

    @Override
    protected void init() {

    }

    @Override
    protected void setData() {
        selectPage = getIntent().getIntExtra("page",0);
        fragments = new ArrayList<>();
        fragments.add(new OrderItem1Fragment());
        fragments.add(new OrderItem2Fragment());
        fragments.add(new OrderItem3Fragment());
        fragments.add(new OrderItem4Fragment());
        fragments.add(new OrderItem5Fragment());
        mTitleList = new ArrayList<>();
        mTitleList.add("待付款");
        mTitleList.add("待发货");
        mTitleList.add("已发货");
        mTitleList.add("已完成");
        mTitleList.add("退货/售后");
        for (int i=0;i<mTitleList.size();i++){
            tabLayout.addTab(tabLayout.newTab().setText(mTitleList.get(i)));//添加tab选项

        }
        FragmentPagerAdapter mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
            //ViewPager与TabLayout绑定后，这里获取到PageTitle就是Tab的Text
            @Override
            public CharSequence getPageTitle(int position) {
                return mTitleList.get(position);
            }
        };
        viewPager.setAdapter(mAdapter);
        tabLayout.setupWithViewPager(viewPager);//将TabLayout和ViewPager关联起来。
        tabLayout.setTabsFromPagerAdapter(mAdapter);//给Tabs设置适配器
//        reflex(tabLayout);
//        reduceMarginsInTabs(tabLayout,20);
        viewPager.setCurrentItem(selectPage);
    }


    @OnClick({R.id.iv_back, R.id.tv_all})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                this.finish();
                break;
            case R.id.tv_all:
                AllOrderActivity.start(this);
                break;
        }
    }


}
