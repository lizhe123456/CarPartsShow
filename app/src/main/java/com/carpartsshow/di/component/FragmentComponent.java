package com.carpartsshow.di.component;

import android.app.Activity;


import com.carpartsshow.di.module.FragmentModule;
import com.carpartsshow.di.scope.FragmentScope;
import com.carpartsshow.ui.classify.ClassifyFragment;
import com.carpartsshow.ui.home.HomeFragment;
import com.carpartsshow.ui.me.MeFragment;
import com.carpartsshow.ui.me.activity.MyIntegralActivity;
import com.carpartsshow.ui.me.fragment.news.NewsListFragment;

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
}
