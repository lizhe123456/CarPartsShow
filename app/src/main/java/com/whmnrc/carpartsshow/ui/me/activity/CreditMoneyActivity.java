package com.whmnrc.carpartsshow.ui.me.activity;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import com.whmnrc.carpartsshow.R;
import com.whmnrc.carpartsshow.base.BaseActivity;
import com.whmnrc.carpartsshow.ui.me.fragment.ConsumptionRecordFragment;
import com.whmnrc.carpartsshow.ui.me.fragment.RepayCompleteFragment;
import com.whmnrc.carpartsshow.ui.me.fragment.WaitRepayFragment;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by lizhe on 2018/3/15.
 */

public class CreditMoneyActivity extends BaseActivity {

    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.viewPager)
    ViewPager viewPager;

    private List<View> mViewList;
    private List<String> mTitleList;
    private List<Fragment> fragments;
    private int page;

    public static void start(Context context,int page) {
        Intent starter = new Intent(context, CreditMoneyActivity.class);
        starter.putExtra("page",page);
        context.startActivity(starter);
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_credit;
    }

    @Override
    protected void init() {

    }

    @Override
    protected void setData() {
        initData();
    }

    private void initData() {
        page = getIntent().getIntExtra("page",0);
        mViewList = new ArrayList<>();
        fragments = new ArrayList<>();
        fragments.add(new ConsumptionRecordFragment());
        fragments.add(new WaitRepayFragment());
        fragments.add(new RepayCompleteFragment());
        mTitleList = new ArrayList<>();
        mTitleList.add("消费记录");
        mTitleList.add("待还款");
        mTitleList.add("已还款");
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
        reduceMarginsInTabs(tabLayout,20);
        viewPager.setCurrentItem(page);
    }


    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        this.finish();
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
