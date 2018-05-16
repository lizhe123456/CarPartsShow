package com.whmnrc.carpartsshow.ui.home;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;
import com.google.gson.Gson;
import com.whmnrc.carpartsshow.R;
import com.whmnrc.carpartsshow.app.Constants;
import com.whmnrc.carpartsshow.base.MvpFragment;
import com.whmnrc.carpartsshow.base.adapter.BaseAdapter;
import com.whmnrc.carpartsshow.model.http.bean.CarModelByVINBean;
import com.whmnrc.carpartsshow.model.http.bean.GoodsDetailToBean;
import com.whmnrc.carpartsshow.model.http.bean.HomePageBean;
import com.whmnrc.carpartsshow.model.http.bean.LoginBean;
import com.whmnrc.carpartsshow.presenter.home.HomePagePresenter;
import com.whmnrc.carpartsshow.presenter.home.contract.HomePageContract;
import com.whmnrc.carpartsshow.ui.MainActivity;
import com.whmnrc.carpartsshow.ui.home.activity.GoodsDetailsActivity;
import com.whmnrc.carpartsshow.ui.home.activity.GoodsSearchActivity;
import com.whmnrc.carpartsshow.ui.home.activity.MessageRecordActivity;
import com.whmnrc.carpartsshow.ui.home.activity.TimelimitActivity;
import com.whmnrc.carpartsshow.ui.home.adapter.HomeCategoryAdapter;
import com.whmnrc.carpartsshow.ui.home.adapter.ListDateItemAdapter;
import com.whmnrc.carpartsshow.ui.home.adapter.SeckillGoodsAdapter;
import com.whmnrc.carpartsshow.ui.home.adapter.SpecialOfferAdapter;
import com.whmnrc.carpartsshow.ui.me.activity.IntegralShopActivity;
import com.whmnrc.carpartsshow.ui.me.activity.NewsDetailsActivity;
import com.whmnrc.carpartsshow.ui.scancode.activity.ScanCodeActivity;
import com.whmnrc.carpartsshow.ui.scancode.adapter.ScanCodeCarBrandAdapter;
import com.whmnrc.carpartsshow.util.DensityUtils;
import com.whmnrc.carpartsshow.util.GlideuUtil;
import com.whmnrc.carpartsshow.util.SpUtil;
import com.whmnrc.carpartsshow.view.CountdownTextView;
import com.whmnrc.carpartsshow.view.ScanCodeDialog;
import com.whmnrc.carpartsshow.widgets.GlideImageLoader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.zyyoona7.lib.EasyPopup;
import com.zyyoona7.lib.HorizontalGravity;
import com.zyyoona7.lib.VerticalGravity;
import org.greenrobot.eventbus.EventBus;
import java.util.ArrayList;
import java.util.Calendar;
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
//    @BindView(R.id.nested_scroll_view)
//    MyNestedScrollView nestedScrollView;
    @BindView(R.id.rl_title)
    RelativeLayout rlTile;
    @BindView(R.id.ll_title)
    RelativeLayout linearLayout;
    @BindView(R.id.tv_title0)
    TextView tvTitle0;
    @BindView(R.id.tv_search0)
    TextView tvSearch0;
    @BindView(R.id.iv_img0)
    ImageView ivImg0;
    @BindView(R.id.ll_goods_0)
    LinearLayout llGoods0;
    @BindView(R.id.tv_title1)
    TextView tvTitle1;
    @BindView(R.id.tv_search1)
    TextView tvSearch1;
    @BindView(R.id.iv_img1)
    ImageView ivImg1;
    @BindView(R.id.ll_goods_1)
    LinearLayout llGoods1;
    @BindView(R.id.tv_title2)
    TextView tvTitle2;
    @BindView(R.id.tv_search2)
    TextView tvSearch2;
    @BindView(R.id.iv_img2)
    ImageView ivImg2;
    @BindView(R.id.ll_goods_2)
    LinearLayout llGoods2;
    @BindView(R.id.tv_title3)
    TextView tvTitle3;
    @BindView(R.id.tv_search3)
    TextView tvSearch3;
    @BindView(R.id.iv_img3)
    ImageView ivImg3;
    @BindView(R.id.ll_goods_3)
    LinearLayout llGoods3;
    @BindView(R.id.tv_title4)
    TextView tvTitle4;
    @BindView(R.id.tv_search4)
    TextView tvSearch4;
    @BindView(R.id.iv_img4)
    ImageView ivImg4;
    @BindView(R.id.ll_goods_4)
    LinearLayout llGoods4;
    @BindView(R.id.ll_all)
    LinearLayout llAll;
    @BindView(R.id.tv_vin)
    TextView tvVin;


    @Override
    protected int setLayout() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void setData() {
        loginBean = SpUtil.getObject(getContext(), "user");
        HomePageBean homePageBean = new Gson().fromJson(SpUtil.getString(getContext(),"home"),HomePageBean.class);
        if (Constants.homePageBean != null){
            showContent(Constants.homePageBean);
        }else if (homePageBean != null){
            showContent(homePageBean);
            mPresenter.getHomePage(loginBean.getRepairUser_ID(),1);
        }else {
            mPresenter.getHomePage(loginBean.getRepairUser_ID(), 1);
        }
//        mPresenter.getHomePage(loginBean.getRepairUser_ID(), 1);
        etSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    if (searchType == 0) {
                        Intent intent = new Intent();
                        intent.setClass(getContext(), GoodsSearchActivity.class);
                        intent.putExtra("searchValue", etSearch.getText().toString().trim());
                        startActivity(intent);
                    }else {
                        mPresenter.searchVin(etSearch.getText().toString().trim());
                    }
                    return true;
                }
                return false;
            }
        });
        recyclerView.setNestedScrollingEnabled(false);
        rvDataItem.setNestedScrollingEnabled(false);
        rvCradItem.setNestedScrollingEnabled(false);
        rvGoodsItem.setNestedScrollingEnabled(false);
//        nestedScrollView.addScrollViewListener(new MyNestedScrollView.ScrollViewListener() {
//            @Override
//            public void onScrollChanged(MyNestedScrollView myNestedScrollView, int x, int y, int oldx, int oldy) {
//                if (y <= 0) {
//                    rlTile.setBackgroundColor(Color.argb((int) 0, 0, 0, 0));//AGB由相关工具获得，或者美工提供
//                } else if (y > 0 && y <= 200) {
//                    float scale = (float) y / 200;
//                    float alpha = (255 * scale);
//                    // 只是layout背景透明(仿知乎滑动效果)
//                    rlTile.setBackgroundColor(Color.argb((int) alpha, 0, 0, 0));
//                } else {
//                    rlTile.setBackgroundColor(Color.argb((int) 255, 0, 0, 0));
//                }
//            }
//        });
        refresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                refresh.finishRefresh(1000);
                mPresenter.getHomePage(loginBean.getRepairUser_ID(), 1);
            }
        });
    }

    @Override
    public void stateError() {

    }

    @Override
    public void onResume() {
        super.onResume();
        Calendar calendar = Calendar.getInstance();
        //获取当前时间，作为图标的名字
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);
        tvTime.setTime(23 - hour, 59 - minute, 59 - second);
        tvTime.start();

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
        refresh.finishRefresh();
        SpUtil.putString(getContext(),"home",new Gson().toJson(homePageBean));
        Constants.homePageBean = null;
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
            specialOfferBean.setCarCount(homePageBean.getOfferNar().get(i).getCarCount());
            specialOfferBean.setCollection(homePageBean.getOfferNar().get(i).isCollection());
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
            specialOfferBean.setCarCount(homePageBean.getOfferNar().get(i).getCarCount());
            specialOfferBean.setCollection(homePageBean.getOfferNar().get(i).isCollection());
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
                GoodsDetailToBean goodsDetailToBean = new GoodsDetailToBean(listSeckillGoodsBean.getUrl(), listSeckillGoodsBean.isCollection(), listSeckillGoodsBean.getCarCount());
                GoodsDetailsActivity.newInstance(getContext(), goodsDetailToBean);
            }
        });
    }

    private void initDataItem(final List<HomePageBean.ListCardImg> listDateItem) {
        LinearLayoutManager linearLayoutManager = null;
        ListDateItemAdapter adapter = null;
        if (listDateItem.size() > 5) {
            linearLayoutManager = new GridLayoutManager(getContext(), 3);
            adapter = new ListDateItemAdapter(getContext(), 0);
        } else if (listDateItem.size() == 5) {
            tvTitle0.setText(listDateItem.get(0).getTitle());
            tvSearch0.setText(listDateItem.get(0).getSearch());
            GlideuUtil.loadImageView(getContext(),listDateItem.get(0).getImgUrl(),ivImg0);
            tvTitle1.setText(listDateItem.get(1).getTitle());
            tvSearch1.setText(listDateItem.get(1).getSearch());
            GlideuUtil.loadImageView(getContext(),listDateItem.get(1).getImgUrl(),ivImg1);
            tvTitle2.setText(listDateItem.get(2).getTitle());
            tvSearch2.setText(listDateItem.get(2).getSearch());
            GlideuUtil.loadImageView(getContext(),listDateItem.get(2).getImgUrl(),ivImg2);
            tvTitle3.setText(listDateItem.get(3).getTitle());
            tvSearch3.setText(listDateItem.get(3).getSearch());
            GlideuUtil.loadImageView(getContext(),listDateItem.get(3).getImgUrl(),ivImg3);
            tvTitle4.setText(listDateItem.get(4).getTitle());
            tvSearch4.setText(listDateItem.get(4).getSearch());
            GlideuUtil.loadImageView(getContext(),listDateItem.get(4).getImgUrl(),ivImg4);
            llGoods0.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    GoodsSearchActivity.start(getContext(), listDateItem.get(0).getSearch());
                }
            });
            llGoods1.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    GoodsSearchActivity.start(getContext(), listDateItem.get(1).getSearch());
                }
            });

            llGoods2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    GoodsSearchActivity.start(getContext(), listDateItem.get(2).getSearch());
                }
            });

            llGoods3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    GoodsSearchActivity.start(getContext(), listDateItem.get(3).getSearch());
                }
            });

            llGoods4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    GoodsSearchActivity.start(getContext(), listDateItem.get(4).getSearch());
                }
            });
            llAll.setVisibility(View.VISIBLE);
            linearLayout.setVisibility(View.VISIBLE);
            return;
        } else {
            adapter = new ListDateItemAdapter(getContext(), 0);
            linearLayoutManager = new GridLayoutManager(getContext(), 2);
        }
        rvDataItem.setLayoutManager(linearLayoutManager);
        rvDataItem.setAdapter(adapter);
        rvDataItem.setVisibility(View.VISIBLE);
        linearLayout.setVisibility(View.VISIBLE);
        adapter.addFirstDataSet(listDateItem);
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
                GoodsDetailToBean goodsDetailToBean = new GoodsDetailToBean(listSeckillGoodsBean.getUrl(), listSeckillGoodsBean.isCollection(), listSeckillGoodsBean.getCarCount());
                GoodsDetailsActivity.newInstance(getContext(), goodsDetailToBean);
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
        List<HomePageBean.ListFirstCategoryBean> showList = new ArrayList<>();

        HomePageBean.ListFirstCategoryBean listFirstCategoryBean = new HomePageBean.ListFirstCategoryBean(R.drawable.carbrand, "车型匹配");
        showList.add(listFirstCategoryBean);
        HomePageBean.ListFirstCategoryBean listFirstCategoryBean1 = new HomePageBean.ListFirstCategoryBean(R.drawable.jifenshop, "积分商城");
        showList.add(listFirstCategoryBean1);
        showList.addAll(listFirstCategory);
        HomePageBean.ListFirstCategoryBean listFirstCategoryBean2 = new HomePageBean.ListFirstCategoryBean(R.drawable.brand_dq, "品牌大全");
        showList.add(listFirstCategoryBean2);
        HomePageBean.ListFirstCategoryBean listFirstCategoryBean3 = new HomePageBean.ListFirstCategoryBean(R.drawable.all_c, "全部分类");
        showList.add(listFirstCategoryBean3);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        gridLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);
        adapter.addFirstDataSet(showList);
        adapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
            @Override
            public void onClick(View view, Object item, int position) {
                HomePageBean.ListFirstCategoryBean listFirstCategoryBean = (HomePageBean.ListFirstCategoryBean) item;
                if (listFirstCategoryBean.getName().equals("积分商城")) {
                    //跳积分商城
                    IntegralShopActivity.start(getContext());
                } else if (listFirstCategoryBean.getName().equals("车型匹配")) {
                    //跳车型
                    ((MainActivity)getActivity()).setPage(0);
                    ((MainActivity)getActivity()).setContentFragment(MainActivity.CLASSIFY);
                    ((MainActivity)getActivity()).setTag(MainActivity.CLASSIFY);
                    ((MainActivity)getActivity()).selectNavigation();
                    EventBus.getDefault().post(new com.whmnrc.carpartsshow.eventbus.HomePageBean(1));
                } else if (listFirstCategoryBean.getName().equals("品牌大全")) {
                    //跳品牌
                    ((MainActivity)getActivity()).setPage(2);
                    ((MainActivity)getActivity()).setContentFragment(MainActivity.CLASSIFY);
                    ((MainActivity)getActivity()).setTag(MainActivity.CLASSIFY);
                    ((MainActivity)getActivity()).selectNavigation();

                    EventBus.getDefault().post(new com.whmnrc.carpartsshow.eventbus.HomePageBean(3));
                } else if (listFirstCategoryBean.getName().equals("全部分类")) {
                    //跳分类
                    ((MainActivity)getActivity()).setPage(1);
                    ((MainActivity)getActivity()).setContentFragment(MainActivity.CLASSIFY);
                    ((MainActivity)getActivity()).setTag(MainActivity.CLASSIFY);
                    ((MainActivity)getActivity()).selectNavigation();
                    EventBus.getDefault().post(new com.whmnrc.carpartsshow.eventbus.HomePageBean(2));
                } else {
                    Intent intent = new Intent();
                    intent.setClass(getContext(), GoodsSearchActivity.class);
                    intent.putExtra("classify", listFirstCategoryBean.getName());
                    intent.putExtra("classifyStep", listFirstCategoryBean.getStep());
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

    @Override
    public void showVinData(List<CarModelByVINBean> list) {
        final ScanCodeDialog dialog = new ScanCodeDialog(getContext());
        ScanCodeCarBrandAdapter scanCodeCarBrandAdapter = new ScanCodeCarBrandAdapter(getContext());
        scanCodeCarBrandAdapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
            @Override
            public void onClick(View view, Object item, int position) {
                CarModelByVINBean carModelByVINBean = (CarModelByVINBean) item;
                Intent intent = new Intent(getContext(), GoodsSearchActivity.class);
                intent.putExtra("NLevelID", carModelByVINBean.getNLevelID());
                intent.putExtra("carBrand", carModelByVINBean.getPP() + " " + carModelByVINBean.getCX() + "--排量 " + carModelByVINBean.getPL() + " " + carModelByVINBean.getNK());
                startActivity(intent);
                dialog.dismiss();
            }
        });
        if (!dialog.isShowing()) {
            dialog.show(scanCodeCarBrandAdapter, list);
        }
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @OnClick({R.id.iv_scan, R.id.et_search, R.id.iv_message,R.id.tv_vin})
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
            case R.id.tv_vin:
                showWindow(view);
                break;
        }
    }

    public int searchType;

    public void showWindow(View view){
        final EasyPopup mCirclePop = new EasyPopup(getContext())
                .setContentView(R.layout.window_vin_comment,
                        DensityUtils.dip2px(getContext(),80), ViewGroup.LayoutParams.WRAP_CONTENT)
                //是否允许点击PopupWindow之外的地方消失
                .setFocusAndOutsideEnable(true)
                .createPopup();
        TextView tvSearch = mCirclePop.getView(R.id.tv_search);
        final TextView tvVin = mCirclePop.getView(R.id.tv_vin);
        tvSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomeFragment.this.tvVin.setText("关键字");
                searchType = 0;
                mCirclePop.dismiss();
            }
        });
        tvVin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomeFragment.this.tvVin.setText("VIN");
                searchType = 1;
                mCirclePop.dismiss();
            }
        });
        mCirclePop.showAtAnchorView(view, VerticalGravity.BELOW, HorizontalGravity.ALIGN_LEFT, (int) 0, (int) 10);
    }

}
