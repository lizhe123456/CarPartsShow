package com.whmnrc.carpartsshow.di.component;

import android.app.Activity;


import com.whmnrc.carpartsshow.di.module.FragmentModule;
import com.whmnrc.carpartsshow.di.scope.FragmentScope;
import com.whmnrc.carpartsshow.ui.classify.ClassifyFragment;
import com.whmnrc.carpartsshow.ui.home.HomeFragment;
import com.whmnrc.carpartsshow.ui.home.fragment.GoodsFragment;
import com.whmnrc.carpartsshow.ui.me.MeFragment;
import com.whmnrc.carpartsshow.ui.me.fragment.ConsumptionRecordFragment;
import com.whmnrc.carpartsshow.ui.me.fragment.RepayCompleteFragment;
import com.whmnrc.carpartsshow.ui.me.fragment.WaitRepayFragment;
import com.whmnrc.carpartsshow.ui.me.fragment.news.NewsListFragment;
import com.whmnrc.carpartsshow.ui.me.fragment.order.base.BaseOrderFragment;

import dagger.Component;

/**
 * Created by lizhe on 2017/12/11 0011.
 * 目标定在月亮之上，即使失败，也可以落在众星之间。
 */
@FragmentScope
@Component(dependencies = AppComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {

    Activity getActivity();

    void inject(MeFragment meFragment);

    void inject(HomeFragment homeFragment);

    void inject(ClassifyFragment classifyFragment);

    void inject(NewsListFragment newsListFragment);

    void inject(WaitRepayFragment waitRepayFragment);

    void inject(RepayCompleteFragment repayCompleteFragment);

    void inject(ConsumptionRecordFragment consumptionRecordFragment);

    void inject(GoodsFragment goodsFragment);

    void inject(BaseOrderFragment baseOrderFragment);
}
