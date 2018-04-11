package com.whmnrc.carpartsshow.ui.me.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import com.whmnrc.carpartsshow.R;
import com.whmnrc.carpartsshow.base.MvpActivity;
import com.whmnrc.carpartsshow.model.http.bean.NewTypeBean;
import com.whmnrc.carpartsshow.presenter.home.NewsTypePresenter;
import com.whmnrc.carpartsshow.presenter.home.contract.NewsTypeContract;
import com.whmnrc.carpartsshow.ui.me.fragment.news.NewsListFragment;

import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by lizhe on 2018/3/18.
 */

public class NewsActivity extends MvpActivity<NewsTypePresenter> implements NewsTypeContract.View {

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
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected void setData() {
        mPresenter.getNewsType();
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

    @Override
    public void stateError() {

    }

    @Override
    public void showNewsType(List<NewTypeBean> newTypeBeans) {
        fragments = new ArrayList<>();
        mTitleList = new ArrayList<>();
        for (NewTypeBean bean : newTypeBeans) {
            NewsListFragment fragment = NewsListFragment.newInstance(bean);
            fragments.add(fragment);
            mTitleList.add(bean.getItemName());
        }
        for (int i = 0; i < mTitleList.size(); i++) {
            tabLayout.addTab(tabLayout.newTab().setText(mTitleList.get(i)));
            //添加tab选项

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
}
