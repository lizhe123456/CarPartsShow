package com.carpartsshow.ui.classify;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.carpartsshow.R;
import com.carpartsshow.base.MvpFragment;
import com.carpartsshow.model.http.bean.ClassificationBean;
import com.carpartsshow.model.http.bean.ClassificationItemBean;
import com.carpartsshow.model.http.bean.LoginBean;
import com.carpartsshow.presenter.home.GoodsSearchPresenter;
import com.carpartsshow.presenter.home.contract.GoodsSearchContract;
import com.carpartsshow.ui.classify.fragment.BrandFragment;
import com.carpartsshow.ui.classify.fragment.CarBrandFragment;
import com.carpartsshow.ui.classify.fragment.CarClassifyFragment;
import com.carpartsshow.util.SpUtil;
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

    private CarClassifyFragment classification;
    private BrandFragment brand;
    private CarBrandFragment models;
    private List<Fragment> fragments = new ArrayList<>();


    private int page = 0;

    @Override
    protected int setLayout() {
        return R.layout.fragment_classify;
    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected void setData() {
        LoginBean loginBean = SpUtil.getObject(getContext(), "user");
        mPresenter.getClassification(loginBean.getRepairUser_ID());
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
        viewPager.setCurrentItem(page);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                page = position;
                switch (position){
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
    }



    @OnClick({R.id.tv_models, R.id.tv_classify, R.id.tv_brand,R.id.iv_back, R.id.et_search})
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
            case R.id.iv_back:
                break;
            case R.id.et_search:
                break;
        }
    }

    public void selectedBrand(){
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

    private void selectedClassify(){
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

    private void selectedModels(){
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


    public class FragmentAdapter extends FragmentPagerAdapter  {

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
}
