package com.carpartsshow.ui.home;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;
import com.carpartsshow.R;
import com.carpartsshow.base.MvpFragment;
import com.carpartsshow.base.adapter.BaseAdapter;
import com.carpartsshow.model.http.bean.HomePageBean;
import com.carpartsshow.model.http.bean.LoginBean;
import com.carpartsshow.presenter.home.HomePagePresenter;
import com.carpartsshow.presenter.home.contract.HomePageContract;
import com.carpartsshow.ui.home.activity.GoodsSearchActivity;
import com.carpartsshow.ui.home.activity.MessageRecordActivity;
import com.carpartsshow.ui.home.adapter.HomeCategoryAdapter;
import com.carpartsshow.ui.home.adapter.HomePageAdapter;
import com.carpartsshow.ui.home.adapter.ListDateItemAdapter;
import com.carpartsshow.ui.home.adapter.SeckillGoodsAdapter;
import com.carpartsshow.ui.home.adapter.SpecialOfferAdapter;
import com.carpartsshow.util.SpUtil;
import com.carpartsshow.view.CountdownTextView;
import com.carpartsshow.widgets.GlideImageLoader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.OnClick;



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
    @BindView(R.id.vf_news)
    ViewFlipper vfNews;
    @BindView(R.id.tv_time)
    CountdownTextView tvTime;
    @BindView(R.id.tv_go)
    TextView tvGo;
    @BindView(R.id.rv_goods_item)
    RecyclerView rvGoodsItem;
    @BindView(R.id.rv_crad_item)
    RecyclerView rvCradItem;
    @BindView(R.id.rv_data_item)
    RecyclerView rvDataItem;
    @BindView(R.id.tv_title)
    TextView tvTitle;

    private HomePageAdapter mAdapter;

    @Override
    protected int setLayout() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initInject() {
//        setFitsSystemWindows(getActivity(),true);
        getFragmentComponent().inject(this);
    }

    @Override
    protected void setData() {
        loginBean = SpUtil.getObject(getContext(), "user");
        mPresenter.getHomePage(loginBean.getRepairUser_ID(), 1);
        etSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH){
                    Intent intent = new Intent();
                    intent.setClass(getContext(),GoodsSearchActivity.class);
                    intent.putExtra("searchValue",etSearch.getText().toString().trim());
                    startActivity(intent);
                    return true;
                }
                return false;
            }
        });
    }

    @Override
    public void stateError() {

    }

    @Override
    public void showContent(HomePageBean homePageBean) {
        initBanner(homePageBean.getBanner());
        initCategory(homePageBean.getListFirstCategory());
        initListNotice(homePageBean.getListNotice());
        initTime(homePageBean.getTimeLimit());
        initGoods(homePageBean.getListSeckillGoods());
        initCrad(homePageBean);
        initDataItem(homePageBean.getListDateItem());
//        List<Object> list = new ArrayList<>();
//        list.add(homePageBean.getListFirstCategory());
//        list.add(homePageBean.getListNotice());
//        list.add(homePageBean.getTimeLimit());
//        list.add(homePageBean.getListSeckillGoods());
//        list.add(homePageBean.getListCrad());
//        list.add(homePageBean.getListDateItem());
//        mAdapter.addData(list);
    }

    private void initCrad(HomePageBean homePageBean) {
        List<HomePageBean.SpecialOfferBean> specialOfferBeans = new ArrayList<>();
        for (int i = 0; i < homePageBean.getPoopNar().size(); i++) {
            HomePageBean.SpecialOfferBean specialOfferBean = new HomePageBean.SpecialOfferBean();
            specialOfferBean.setBanner_ID(homePageBean.getPoopNar().get(i).getBanner_ID());
            specialOfferBean.setBanner_PcLikUrl(homePageBean.getPoopNar().get(i).getBanner_PcLikUrl());
            specialOfferBean.setBanner_Sort(homePageBean.getPoopNar().get(i).getBanner_Sort());
            specialOfferBean.setBanner_WxAppImgPath(homePageBean.getPoopNar().get(i).getBanner_WxAppImgPath());
            specialOfferBean.setCategory(homePageBean.getPoopNar().get(i).getCategory());
            specialOfferBean.setCompany_ID(homePageBean.getPoopNar().get(i).getCompany_ID());
            specialOfferBeans.add(specialOfferBean);
        }

        for (int i = 0; i < homePageBean.getOfferNar().size(); i++) {
            HomePageBean.SpecialOfferBean specialOfferBean = new HomePageBean.SpecialOfferBean();
            specialOfferBean.setBanner_ID(homePageBean.getOfferNar().get(i).getBanner_ID());
            specialOfferBean.setBanner_PcLikUrl(homePageBean.getOfferNar().get(i).getBanner_PcLikUrl());
            specialOfferBean.setBanner_Sort(homePageBean.getOfferNar().get(i).getBanner_Sort());
            specialOfferBean.setBanner_WxAppImgPath(homePageBean.getOfferNar().get(i).getBanner_WxAppImgPath());
            specialOfferBean.setCategory(homePageBean.getOfferNar().get(i).getCategory());
            specialOfferBean.setCompany_ID(homePageBean.getOfferNar().get(i).getCompany_ID());
            specialOfferBeans.add(specialOfferBean);
        }
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rvCradItem.setLayoutManager(layoutManager);
        SpecialOfferAdapter adapter = new SpecialOfferAdapter(getContext());
        rvCradItem.setAdapter(adapter);
        adapter.addFirstDataSet(specialOfferBeans);
    }

    private void initDataItem(List<HomePageBean.ListDateItemBean> listDateItem) {
        ListDateItemAdapter adapter = new ListDateItemAdapter(getContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvDataItem.setLayoutManager(linearLayoutManager);
        rvDataItem.setAdapter(adapter);
        View view = LayoutInflater.from(getContext()).inflate(R.layout.img_layout, null);
        adapter.addHeaderView(view);

    }

    private void initGoods(List<HomePageBean.ListSeckillGoodsBean> listSeckillGoods) {
        SeckillGoodsAdapter adapter = new SeckillGoodsAdapter(getContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rvGoodsItem.setLayoutManager(linearLayoutManager);
        rvGoodsItem.setAdapter(adapter);
        adapter.addFirstDataSet(listSeckillGoods);
    }

    private void initTime(HomePageBean.TimeLimit timeLimit) {
        tvGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        tvTime.init("hh:mm:ss", 213215);
        tvTime.start(0);
    }

    private void initListNotice(List<HomePageBean.ListNoticeBean> listNotice) {
        for (HomePageBean.ListNoticeBean bean : listNotice) {
            TextView textView = new TextView(getContext());
            textView.setTextColor(getActivity().getResources().getColor(R.color.tv_000));
            textView.setTextSize(15);
            textView.setMaxLines(1);
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setText(bean.getNotice_Title());
            vfNews.addView(textView);
        }
    }

    private void initCategory(final List<HomePageBean.ListFirstCategoryBean> listFirstCategory) {

        HomeCategoryAdapter adapter = new HomeCategoryAdapter(getContext());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        gridLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);
        adapter.addFirstDataSet(listFirstCategory);
        adapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
            @Override
            public void onClick(View view, Object item, int position) {
                HomePageBean.ListFirstCategoryBean listFirstCategoryBean = (HomePageBean.ListFirstCategoryBean) item;
                if (listFirstCategoryBean.getName().equals("积分商城")){
                    //跳积分商城
                }else if (listFirstCategoryBean.getName().equals("车型匹配")){
                    //跳车型
                }else if (listFirstCategoryBean.getName().equals("品牌大全")){
                    //跳品牌
                }else if (listFirstCategoryBean.getName().equals("全部分类")){
                    //跳分类
                }else {
                    Intent intent = new Intent();
                    intent.setClass(getContext(),GoodsSearchActivity.class);
                    intent.putExtra("classify",listFirstCategoryBean.getName());
                    startActivity(intent);
                }
            }
        });
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


    @OnClick({R.id.iv_scan, R.id.et_search, R.id.iv_message})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_scan:
                break;
            case R.id.et_search:
                break;
            case R.id.iv_message:
                startActivity(new Intent(getContext(), MessageRecordActivity.class));
                break;
        }
    }


}
