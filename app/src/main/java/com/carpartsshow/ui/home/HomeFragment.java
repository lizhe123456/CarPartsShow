package com.carpartsshow.ui.home;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;
import com.carpartsshow.R;
import com.carpartsshow.base.MvpFragment;
import com.carpartsshow.base.adapter.BaseAdapter;
import com.carpartsshow.model.http.bean.HomePageBean;
import com.carpartsshow.model.http.bean.LoginBean;
import com.carpartsshow.presenter.home.HomePagePresenter;
import com.carpartsshow.presenter.home.contract.HomePageContract;
import com.carpartsshow.ui.home.activity.GoodsDetailsActivity;
import com.carpartsshow.ui.home.activity.GoodsSearchActivity;
import com.carpartsshow.ui.home.activity.MessageRecordActivity;
import com.carpartsshow.ui.home.activity.TimelimitActivity;
import com.carpartsshow.ui.home.adapter.HomeCategoryAdapter;
import com.carpartsshow.ui.home.adapter.ListDateItemAdapter;
import com.carpartsshow.ui.home.adapter.SeckillGoodsAdapter;
import com.carpartsshow.ui.home.adapter.SpecialOfferAdapter;
import com.carpartsshow.ui.me.activity.IntegralShopActivity;
import com.carpartsshow.ui.me.activity.NewsDetailsActivity;
import com.carpartsshow.ui.scancode.activity.ScanCodeActivity;
import com.carpartsshow.util.SpUtil;
import com.carpartsshow.view.CountdownTextView;
import com.carpartsshow.widgets.GlideImageLoader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import org.greenrobot.eventbus.EventBus;
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
    @BindView(R.id.ll_notice)
    LinearLayout linearLayoutNotice;
    @BindView(R.id.nested_scroll_view)
    NestedScrollView nestedScrollView;
    @BindView(R.id.rl_title)
    RelativeLayout rlTile;
    @BindView(R.id.ll_title)
    RelativeLayout linearLayout;


//    private HomePageAdapter mAdapter;

    @Override
    protected int setLayout() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initInject() {
//        setFitsSystemWindows(getActivity(),true);
        getFragmentComponent().inject(this);
    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void setData() {
        loginBean = SpUtil.getObject(getContext(), "user");
        mPresenter.getHomePage(loginBean.getRepairUser_ID(), 1);
        etSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    Intent intent = new Intent();
                    intent.setClass(getContext(), GoodsSearchActivity.class);
                    intent.putExtra("searchValue", etSearch.getText().toString().trim());
                    startActivity(intent);
                    return true;
                }
                return false;
            }
        });
        recyclerView.setNestedScrollingEnabled(false);
        rvDataItem.setNestedScrollingEnabled(false);
        rvCradItem.setNestedScrollingEnabled(false);
        rvGoodsItem.setNestedScrollingEnabled(false);
//        nestedScrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
//            @Override
//            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
//                if (scrollY <= 0) {
//                    rlTile.setBackgroundColor(Color.argb((int) 0, 227, 29, 26));//AGB由相关工具获得，或者美工提供
//                } else if (scrollY > 0 && scrollY <= 180) {
//                    float scale = (float) scrollY / 180;
//                    float alpha = (255 * scale);
//                    // 只是layout背景透明(仿知乎滑动效果)
//                    rlTile.setBackgroundColor(Color.argb((int) alpha, 227, 29, 26));
//                } else {
//                    rlTile.setBackgroundColor(Color.argb((int) 255, 227, 29, 26));
//                }
//            }
//        });
    }

    @Override
    public void stateError() {

    }

    @Override
    public void showContent(HomePageBean homePageBean) {
        initBanner(homePageBean.getBanner());
        initCategory(homePageBean.getListFirstCategory());
        initListNotice(homePageBean.getListNotice());
        initTime(homePageBean.getTimeLimit(), homePageBean.getListSeckillGoods());
        initGoods(homePageBean.getListSeckillGoods());
        initCrad(homePageBean);
        initDataItem(homePageBean.getListCardImg());
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
            specialOfferBean.setUrl(homePageBean.getOfferNar().get(i).getBanner_WxLinkUrl());
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
            specialOfferBean.setUrl(homePageBean.getOfferNar().get(i).getBanner_WxLinkUrl());
            specialOfferBeans.add(specialOfferBean);
        }
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvCradItem.setLayoutManager(layoutManager);
        SpecialOfferAdapter adapter = new SpecialOfferAdapter(getContext());
        rvCradItem.setAdapter(adapter);
        adapter.addFirstDataSet(specialOfferBeans);
        rvCradItem.setVisibility(View.VISIBLE);
        adapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
            @Override
            public void onClick(View view, Object item, int position) {
                HomePageBean.SpecialOfferBean listSeckillGoodsBean = (HomePageBean.SpecialOfferBean) item;
                GoodsDetailsActivity.newInstance(getContext(), "", 0, listSeckillGoodsBean.getUrl());
            }
        });
    }

    private void initDataItem(List<HomePageBean.ListCardImg> listDateItem) {
        ListDateItemAdapter adapter = new ListDateItemAdapter(getContext());
        GridLayoutManager linearLayoutManager = new GridLayoutManager(getContext(), 2);
        rvDataItem.setLayoutManager(linearLayoutManager);
        rvDataItem.setAdapter(adapter);
        rvDataItem.setVisibility(View.VISIBLE);
        adapter.addFirstDataSet(listDateItem);
        linearLayout.setVisibility(View.VISIBLE);
        adapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
            @Override
            public void onClick(View view, Object item, int position) {
                HomePageBean.ListCardImg listCardImg = (HomePageBean.ListCardImg) item;
                GoodsSearchActivity.start(getContext(), listCardImg.getSearch());
            }
        });
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (hidden) {
            vfNews.stopFlipping();
        } else {
            vfNews.startFlipping();
        }
    }

    private void initGoods(List<HomePageBean.ListSeckillGoodsBean> listSeckillGoods) {
        SeckillGoodsAdapter adapter = new SeckillGoodsAdapter(getContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rvGoodsItem.setLayoutManager(linearLayoutManager);
        rvGoodsItem.setAdapter(adapter);
        adapter.addFirstDataSet(listSeckillGoods);
        rvGoodsItem.setVisibility(View.VISIBLE);
        adapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
            @Override
            public void onClick(View view, Object item, int position) {
                HomePageBean.ListSeckillGoodsBean listSeckillGoodsBean = (HomePageBean.ListSeckillGoodsBean) item;
                GoodsDetailsActivity.newInstance(getContext(), "", 0, listSeckillGoodsBean.getUrl());
            }
        });
    }

    private void initTime(HomePageBean.TimeLimit timeLimit, final List<HomePageBean.ListSeckillGoodsBean> listSeckillGoods) {
        tvGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimelimitActivity.start(getContext());
            }
        });
        tvTime.setTime(9, 59, 59);
        tvTime.start();
    }

    private void initListNotice(final List<HomePageBean.ListNoticeBean> listNotice) {
        for (HomePageBean.ListNoticeBean bean : listNotice) {
            TextView textView = new TextView(getContext());
            textView.setTextColor(getActivity().getResources().getColor(R.color.tv_000));
            textView.setTextSize(15);
            textView.setMaxLines(1);
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setText(bean.getNotice_Title());
            vfNews.addView(textView);
        }
        linearLayoutNotice.setVisibility(View.VISIBLE);
        vfNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NewsDetailsActivity.start(getContext(), listNotice.get(vfNews.getDisplayedChild()).getUrl());
            }
        });
    }

    private void initCategory(final List<HomePageBean.ListFirstCategoryBean> listFirstCategory) {

        HomeCategoryAdapter adapter = new HomeCategoryAdapter(getContext());
        listFirstCategory.add(0, new HomePageBean.ListFirstCategoryBean(R.drawable.carbrand, "车型匹配"));
        listFirstCategory.add(0, new HomePageBean.ListFirstCategoryBean(R.drawable.jifenshop, "积分商城"));
        listFirstCategory.add(new HomePageBean.ListFirstCategoryBean(R.drawable.brand_dq, "品牌大全"));
        listFirstCategory.add(new HomePageBean.ListFirstCategoryBean(R.drawable.all_c, "全部分类"));
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        gridLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);
        adapter.addFirstDataSet(listFirstCategory);
        adapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
            @Override
            public void onClick(View view, Object item, int position) {
                HomePageBean.ListFirstCategoryBean listFirstCategoryBean = (HomePageBean.ListFirstCategoryBean) item;
                if (listFirstCategoryBean.getName().equals("积分商城")) {
                    //跳积分商城
                    IntegralShopActivity.start(getContext());
                } else if (listFirstCategoryBean.getName().equals("车型匹配")) {
                    //跳车型
                    EventBus.getDefault().post(new com.carpartsshow.eventbus.HomePageBean(1));
                } else if (listFirstCategoryBean.getName().equals("品牌大全")) {
                    //跳品牌
                    EventBus.getDefault().post(new com.carpartsshow.eventbus.HomePageBean(3));
                } else if (listFirstCategoryBean.getName().equals("全部分类")) {
                    //跳分类
                    EventBus.getDefault().post(new com.carpartsshow.eventbus.HomePageBean(2));
                } else {
                    Intent intent = new Intent();
                    intent.setClass(getContext(), GoodsSearchActivity.class);
                    intent.putExtra("classify", listFirstCategoryBean.getName());
                    startActivity(intent);
                }
            }
        });
        recyclerView.setVisibility(View.VISIBLE);
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


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @OnClick({R.id.iv_scan, R.id.et_search, R.id.iv_message})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_scan:
                ScanCodeActivity.start(getContext());
                break;
            case R.id.et_search:
                break;
            case R.id.iv_message:
                startActivity(new Intent(getContext(), MessageRecordActivity.class));
                break;
        }
    }

}
