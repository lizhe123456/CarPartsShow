package com.carpartsshow.ui.me.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import com.carpartsshow.R;
import com.carpartsshow.base.BaseActivity;
import com.carpartsshow.ui.me.fragment.news.GroupNewsFragment;
import com.carpartsshow.ui.me.fragment.news.IndustryFragment;
import com.carpartsshow.ui.me.fragment.news.InfoNoticeFragment;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by lizhe on 2018/3/18.
 */

public class NewsActivity extends BaseActivity {

    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    private List<String> mTitleList;
    private List<Fragment> fragments;

    @Override
    protected int setLayout() {
        return R.layout.activity_news;
    }

    @Override
    protected void init() {

    }

    @Override
    protected void setData() {
        fragments = new ArrayList<>();
        fragments.add(new IndustryFragment());
        fragments.add(new InfoNoticeFragment());
        fragments.add(new GroupNewsFragment());
        mTitleList = new ArrayList<>();
        mTitleList.add("业内新闻");
        mTitleList.add("信息公告");
        mTitleList.add("集团新闻");
        for (int i = 0; i < mTitleList.size(); i++) {
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
        reduceMarginsInTabs(tabLayout,40);
        viewPager.setCurrentItem(0);
    }


    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }

    public void reduceMarginsInTabs(TabLayout tabLayout, int marginOffset) {
        View tabStrip = tabLayout.getChildAt(0);
        if (tabStrip instanceof ViewGroup) {
            ViewGroup tabStripGroup = (ViewGroup) tabStrip;
            for (int i = 0; i < ((ViewGroup) tabStrip).getChildCount(); i++) {
                View tabView = tabStripGroup.getChildAt(i);
                if (tabView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ((ViewGroup.MarginLayoutParams) tabView.getLayoutParams()).leftMargin = marginOffset;
                    ((ViewGroup.MarginLayoutParams) tabView.getLayoutParams()).rightMargin = marginOffset;
                }
            }
            tabLayout.requestLayout();
        }
    }
}
