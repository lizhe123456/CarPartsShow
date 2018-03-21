package com.carpartsshow.ui.home;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import com.carpartsshow.R;
import com.carpartsshow.base.MvpFragment;
import com.carpartsshow.model.http.bean.HomePageBean;
import com.carpartsshow.model.http.bean.LoginBean;
import com.carpartsshow.presenter.home.HomePagePresenter;
import com.carpartsshow.presenter.home.contract.HomePageContract;
import com.carpartsshow.util.SpUtil;
import com.carpartsshow.util.StatusBarUtil;
import com.carpartsshow.widgets.GlideImageLoader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


/**
 * Created by lizhe on 2018/3/12.
 */

public class HomeFragment extends MvpFragment<HomePagePresenter> implements HomePageContract.View {

    @BindView(R.id.home_banner)
    Banner homeBanner;
    @BindView(R.id.iv_scan)
    ImageView ivScan;
    @BindView(R.id.et_search)
    EditText etSearch;
    @BindView(R.id.iv_message)
    ImageView ivMessage;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;
    LoginBean loginBean;

    @Override
    protected int setLayout() {
        return R.layout.fragment_home;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initInject() {
        setFitsSystemWindows(getActivity(),true);
        getFragmentComponent().inject(this);
    }

    @Override
    protected void setData() {
        loginBean = SpUtil.getObject(getContext(), "user");
        mPresenter.getHomePage(loginBean.getRepairUser_ID(), 1);
    }

    @Override
    public void stateError() {

    }

    @Override
    public void showContent(HomePageBean homePageBean) {
        initBanner(homePageBean.getBanner());
        initRecyclerView(homePageBean);
    }

    private void initRecyclerView(HomePageBean homePageBean) {

    }

    private void initBanner(List<HomePageBean.BannerBean> bannerList) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < bannerList.size(); i++) {
            list.add(bannerList.get(i).getBanner_WxAppImgPath());
        }
        //设置banner样式
        homeBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        homeBanner.setIndicatorGravity(BannerConfig.CENTER);
        //设置图片加载器
        homeBanner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        homeBanner.setImages(list);
        //设置banner动画效果
        homeBanner.setBannerAnimation(Transformer.Default);
        //设置自动轮播，默认为true
        homeBanner.isAutoPlay(true);
        //设置轮播时间
        homeBanner.setDelayTime(1500);
        homeBanner.start();
    }

    @Override
    public void loadMore(HomePageBean homePageBean) {

    }

    public void setFitsSystemWindows(Activity activity, boolean value) {
        ViewGroup contentFrameLayout = (ViewGroup) activity.findViewById(android.R.id.content);
        View parentView = contentFrameLayout.getChildAt(0);
        if (parentView != null && Build.VERSION.SDK_INT >= 14) {
            parentView.setFitsSystemWindows(value);
        }
    }

}
