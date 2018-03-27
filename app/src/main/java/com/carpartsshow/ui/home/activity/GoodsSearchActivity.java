package com.carpartsshow.ui.home.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.carpartsshow.R;
import com.carpartsshow.base.BaseActivity;
import com.carpartsshow.base.BaseFragment;
import com.carpartsshow.base.MvpActivity;
import com.carpartsshow.model.http.bean.ClassificationBean;
import com.carpartsshow.model.http.bean.ClassificationItemBean;
import com.carpartsshow.presenter.home.GoodsSearchPresenter;
import com.carpartsshow.presenter.home.contract.GoodsSearchContract;
import com.carpartsshow.ui.classify.ClassifyFragment;
import com.carpartsshow.ui.classify.fragment.BrandFragment;
import com.carpartsshow.ui.classify.fragment.CarBrandFragment;
import com.carpartsshow.ui.classify.fragment.CarClassifyFragment;
import com.carpartsshow.ui.home.fragment.GoodsFragment;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by lizhe on 2018/3/26.
 * 商品搜索
 */

public class GoodsSearchActivity extends MvpActivity<GoodsSearchPresenter> implements GoodsSearchContract.View {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.et_search)
    EditText etSearch;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.tv_label_delete)
    TextView tvLabelDelete;
    @BindView(R.id.tv_label_brand_delete)
    TextView tvLabelBrandDelete;
    @BindView(R.id.tv_label_models_delete)
    TextView tvLabelModelsDelete;
    @BindView(R.id.tv_zh)
    TextView tvZh;
    @BindView(R.id.tv_xl)
    TextView tvXl;
    @BindView(R.id.tv_jf)
    TextView tvJf;
    @BindView(R.id.tv_models)
    TextView tvModels;
    @BindView(R.id.fragment_content)
    FrameLayout fragmentContent;

    private CarClassifyFragment classification;
    private BrandFragment brand;
    private CarBrandFragment models;

    private static final String FRAGMENT_TAG_BRAND = "brand";
    private static final String FRAGMENT_TAG_GOODS = "goods";
    private static final String FRAGMENT_TAG_CARCLASSIFY = "carclassify";
    private static final String FRAGMENT_TAG_CARBRAND = "carbrand";

    private FragmentManager fragmentManager;
    private String currentFragmentTag;


    @Override
    protected int setLayout() {
        return R.layout.activity_goods_search;
    }


    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected void setData() {
        setContentFragment(FRAGMENT_TAG_GOODS);
    }

    @OnClick({R.id.iv_back, R.id.tv_label_delete, R.id.tv_label_brand_delete, R.id.tv_label_models_delete, R.id.tv_zh, R.id.tv_classify, R.id.tv_brand, R.id.tv_models})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                this.finish();
                break;
            case R.id.tv_label_delete:
                break;
            case R.id.tv_label_brand_delete:
                break;
            case R.id.tv_label_models_delete:
                break;
            case R.id.tv_zh:
                //价格

                break;
            case R.id.tv_classify:
                //分类
                setContentFragment(FRAGMENT_TAG_CARCLASSIFY);
                break;
            case R.id.tv_brand:
                //品牌
                setContentFragment(FRAGMENT_TAG_BRAND);
                break;
            case R.id.tv_models:
                //车型
                setContentFragment(FRAGMENT_TAG_CARBRAND);
                break;
        }
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
        models = CarBrandFragment.newInstance(listCarBrandBeans);
    }

    //设置fragment 切换
    public void setContentFragment(String tag){

        if (currentFragmentTag != null && currentFragmentTag.equals(tag)){
            return;
        }

        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE);
        Fragment currentFragment = fragmentManager.findFragmentByTag(currentFragmentTag);

        if (currentFragment != null) {
            ft.hide(currentFragment);
        }
        Fragment foundFragment = fragmentManager.findFragmentByTag(tag);

        if (foundFragment == null){
            switch (tag){
                case FRAGMENT_TAG_GOODS:
                    foundFragment = classification;
                    break;
                case FRAGMENT_TAG_BRAND:
                    foundFragment = brand;
                    break;
                case FRAGMENT_TAG_CARCLASSIFY:
                    foundFragment = models;
                    break;
                case FRAGMENT_TAG_CARBRAND:
                    foundFragment = new CarBrandFragment();
                    break;
            }
        }

        if (foundFragment == null){

        }else if (foundFragment.isAdded()){
            ft.show(foundFragment);
        }else {
            ft.add(R.id.fragment_content,foundFragment,tag);
        }
        ft.commit();
        currentFragmentTag = tag;
        invalidateOptionsMenu();
    }

}
