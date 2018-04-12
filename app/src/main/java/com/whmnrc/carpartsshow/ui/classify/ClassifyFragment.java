package com.whmnrc.carpartsshow.ui.classify;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.whmnrc.carpartsshow.R;
import com.whmnrc.carpartsshow.base.MvpFragment;
import com.whmnrc.carpartsshow.eventbus.HomePageBean;
import com.whmnrc.carpartsshow.model.http.bean.ClassificationBean;
import com.whmnrc.carpartsshow.model.http.bean.ClassificationItemBean;
import com.whmnrc.carpartsshow.model.http.bean.GoodsListBean;
import com.whmnrc.carpartsshow.model.http.bean.LoginBean;
import com.whmnrc.carpartsshow.presenter.home.GoodsSearchPresenter;
import com.whmnrc.carpartsshow.presenter.home.contract.GoodsSearchContract;
import com.whmnrc.carpartsshow.ui.classify.fragment.BrandFragment;
import com.whmnrc.carpartsshow.ui.classify.fragment.CarBrandFragment;
import com.whmnrc.carpartsshow.ui.classify.fragment.CarClassifyFragment;
import com.whmnrc.carpartsshow.ui.home.activity.GoodsSearchActivity;
import com.whmnrc.carpartsshow.util.ScreenUtils;
import com.whmnrc.carpartsshow.util.SpUtil;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by lizhe on 2018/3/12.
 */

public class ClassifyFragment extends MvpFragment<GoodsSearchPresenter> implements GoodsSearchContract.View {

    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.tv_models)
    TextView tvModels;
    @BindView(R.id.tv_classify)
    TextView tvClassify;
    @BindView(R.id.tv_brand)
    TextView tvBrand;
    @BindView(R.id.v_models)
    View vModels;
    @BindView(R.id.v_classify)
    View vClassify;
    @BindView(R.id.v_brand)
    View vBrand;
    @BindView(R.id.divider)
    View divider;
    @BindView(R.id.et_search)
    EditText etSearch;
    @BindView(R.id.stu_bar)
    View view;

    private CarClassifyFragment classification;
    private BrandFragment brand;
    private CarBrandFragment models;
    private List<Fragment> fragments = new ArrayList<>();


    private int page = 0;
    private LoginBean loginBean;

    @Override
    protected int setLayout() {
        return R.layout.fragment_classify;
    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
        EventBus.getDefault().register(this);
    }

    @Override
    protected void setData() {
        LinearLayout.LayoutParams linearParams =(LinearLayout.LayoutParams) view.getLayoutParams();
        //取控件textView当前的布局参数 linearParams.height = 20;// 控件的高强制设成20
        linearParams.height = ScreenUtils.getStatusHeight(getContext());
        view.setLayoutParams(linearParams);
        //使设置好的布局参数应用到控件
        loginBean = SpUtil.getObject(getContext(), "user");

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
        mPresenter.getClassification(loginBean.getRepairUser_ID(), 0);
    }



    @Override
    public void stateError() {

    }

    @Override
    public void showClassification(List<ClassificationItemBean> listCategoryBeans) {
        classification = CarClassifyFragment.newInstance(listCategoryBeans);
    }

    @Override
    public void showBrand(List<ClassificationBean.ListBrandBean> listBrandBeans) {
        brand = BrandFragment.newInstance(listBrandBeans);
    }

    @Override
    public void showCarBrand(List<ClassificationBean.ListCarBrandBean> listCarBrandBeans) {
        models = CarBrandFragment.newInstance((ArrayList<ClassificationBean.ListCarBrandBean>) listCarBrandBeans);
        fragments.add(models);
        fragments.add(classification);
        fragments.add(brand);

        FragmentAdapter adapter = new FragmentAdapter(getFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                page = position;
                switch (position) {
                    case 0:
                        selectedModels();
                        break;
                    case 1:
                        selectedClassify();
                        break;
                    case 2:
                        selectedBrand();
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        viewPager.setCurrentItem(page);
        if (page == 0){
            selectedModels();
        }else if (page == 1){
            selectedClassify();
        }else if (page == 2){
            selectedBrand();
        }

    }


    @Override
    public void showGoodsList(GoodsListBean goodsListBean, int type) {

    }


    @OnClick({R.id.tv_models, R.id.tv_classify, R.id.tv_brand})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_models:
                viewPager.setCurrentItem(0);
                break;
            case R.id.tv_classify:
                viewPager.setCurrentItem(1);
                break;
            case R.id.tv_brand:
                viewPager.setCurrentItem(2);
                break;
        }
    }

    public void selectedBrand() {
        vModels.setVisibility(View.INVISIBLE);
        vBrand.setVisibility(View.VISIBLE);
        vClassify.setVisibility(View.INVISIBLE);
        tvBrand.setSelected(true);
        tvClassify.setSelected(false);
        tvModels.setSelected(false);
        tvModels.setTextColor(Color.parseColor("#5D5F69"));
        tvBrand.setTextColor(getResources().getColor(R.color.red_login));
        tvClassify.setTextColor(Color.parseColor("#5D5F69"));
    }

    private void selectedClassify() {
        vModels.setVisibility(View.INVISIBLE);
        vBrand.setVisibility(View.INVISIBLE);
        vClassify.setVisibility(View.VISIBLE);
        tvBrand.setSelected(false);
        tvClassify.setSelected(true);
        tvModels.setSelected(false);
        tvModels.setTextColor(Color.parseColor("#5D5F69"));
        tvBrand.setTextColor(Color.parseColor("#5D5F69"));
        tvClassify.setTextColor(getResources().getColor(R.color.red_login));
    }

    private void selectedModels() {
        vModels.setVisibility(View.VISIBLE);
        vBrand.setVisibility(View.INVISIBLE);
        vClassify.setVisibility(View.INVISIBLE);
        tvBrand.setSelected(false);
        tvClassify.setSelected(false);
        tvModels.setSelected(true);
        tvModels.setTextColor(getResources().getColor(R.color.red_login));
        tvBrand.setTextColor(Color.parseColor("#5D5F69"));
        tvClassify.setTextColor(Color.parseColor("#5D5F69"));
    }

    public class FragmentAdapter extends FragmentPagerAdapter {

        public FragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

    }

    @Subscribe
    public void selectFragment(HomePageBean homePageBean) {
        switch (homePageBean.getPage()) {
            case 1:
                selectedModels();
                page = 0;
                viewPager.setCurrentItem(0);
                break;
            case 2:
                selectedClassify();
                page = 1;
                viewPager.setCurrentItem(1);
                break;
            case 3:
                page = 2;
                selectedBrand();
                viewPager.setCurrentItem(2);
                break;
        }
    }

}
