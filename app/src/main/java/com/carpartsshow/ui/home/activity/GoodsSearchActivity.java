package com.carpartsshow.ui.home.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import com.carpartsshow.R;
import com.carpartsshow.base.MvpActivity;
import com.carpartsshow.eventbus.CarClassifyBean;
import com.carpartsshow.eventbus.GoodsMoreBean;
import com.carpartsshow.model.http.bean.ClassificationBean;
import com.carpartsshow.model.http.bean.ClassificationItemBean;
import com.carpartsshow.model.http.bean.GoodsListBean;
import com.carpartsshow.model.http.bean.LoginBean;
import com.carpartsshow.presenter.home.GoodsSearchPresenter;
import com.carpartsshow.presenter.home.contract.GoodsSearchContract;
import com.carpartsshow.ui.classify.fragment.BrandFragment;
import com.carpartsshow.ui.classify.fragment.CarBrandFragment;
import com.carpartsshow.ui.classify.fragment.CarClassifyFragment;
import com.carpartsshow.ui.home.fragment.GoodsFragment;
import com.carpartsshow.util.SpUtil;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    @BindView(R.id.ll_label)
    LinearLayout mLlabel;
    @BindView(R.id.tv_label_delete)
    TextView tvLabelDelete;
    @BindView(R.id.tv_label_brand_delete)
    TextView tvLabelBrandDelete;
    @BindView(R.id.tv_label_models_delete)
    TextView tvLabelModelsDelete;
    @BindView(R.id.tv_zh)
    TextView tvZh;
    @BindView(R.id.tv_classify)
    TextView tvXl;
    @BindView(R.id.tv_brand)
    TextView tvJf;
    @BindView(R.id.tv_models)
    TextView tvModels;
    @BindView(R.id.fragment_content)
    FrameLayout fragmentContent;

    private CarClassifyFragment classification;
    private BrandFragment brand;
    private CarBrandFragment models;
    private GoodsFragment goodsFragment;

    private static final String FRAGMENT_TAG_BRAND = "brand";
    private static final String FRAGMENT_TAG_GOODS = "goods";
    private static final String FRAGMENT_TAG_CARCLASSIFY = "carclassify";
    private static final String FRAGMENT_TAG_CARBRAND = "carbrand";

    private FragmentManager fragmentManager;
    private String currentFragmentTag;

    private String latelBrand;
    private String latelClassify;
    private String latelCarBrand;
    private int cid;
    private LoginBean loginBean;
    private String searchValue;

    //商品搜索请求参数map
    private Map<String , Object> map = new HashMap<>();
    //ASC   desc
    private String orderASC = "";
    private int page = 1;

    public boolean isClassifyShow;
    public boolean isBrandShow;
    public boolean isCarShow;

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
        EventBus.getDefault().register(this);
        latelBrand = getIntent().getStringExtra("brand") == null ? "" : getIntent().getStringExtra("brand");
        latelClassify = getIntent().getStringExtra("classify") == null ? "" : getIntent().getStringExtra("classify");
        cid = getIntent().getIntExtra("cid",-1) ;
        latelCarBrand = getIntent().getStringExtra("carBrand") ;
        searchValue = getIntent().getStringExtra("searchValue") == null ? "" : getIntent().getStringExtra("searchValue");
        initLabel();
        fragmentManager = getSupportFragmentManager();
        setContentFragment(FRAGMENT_TAG_GOODS);
        loginBean = SpUtil.getObject(getApplicationContext(),"user");
        mPresenter.getClassification(loginBean.getRepairUser_ID());
        map.put("RepairUser_ID",loginBean.getRepairUser_ID());
        map.put("PageIndex",page);
        map.put("BrandName",latelBrand);
        map.put("CategoryName",latelClassify);
        if (cid != -1) {
            map.put("CarID", cid);
        }
        map.put("SearchValue",searchValue);
        mPresenter.getGoodsSearch(map);
        etSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH){
                    searchValue = etSearch.getText().toString().trim();
                    map.put("SearchValue",searchValue);
                    page = 1;
                    mPresenter.getGoodsSearch(map);
                    return true;
                }
                return false;
            }
        });
    }

    //初始化标签
    private void initLabel() {
        if (TextUtils.isEmpty(latelClassify) && TextUtils.isEmpty(latelCarBrand) && TextUtils.isEmpty(latelBrand)){
            mLlabel.setVisibility(View.GONE);
        }

        if (TextUtils.isEmpty(latelClassify)){
            tvLabelDelete.setVisibility(View.GONE);
        }else {
            mLlabel.setVisibility(View.VISIBLE);
            tvLabelDelete.setVisibility(View.VISIBLE);
            tvLabelDelete.setText(latelClassify);
        }

        if (TextUtils.isEmpty(latelCarBrand)){
            tvLabelModelsDelete.setVisibility(View.GONE);
        }else {
            mLlabel.setVisibility(View.VISIBLE);
            tvLabelModelsDelete.setVisibility(View.VISIBLE);
            tvLabelModelsDelete.setText(latelCarBrand);
        }

        if (TextUtils.isEmpty(latelBrand)){
            tvLabelBrandDelete.setVisibility(View.GONE);
        }else {
            mLlabel.setVisibility(View.VISIBLE);
            tvLabelBrandDelete.setVisibility(View.VISIBLE);
            tvLabelBrandDelete.setText(latelBrand);
        }
        etSearch.setText(searchValue == null ? "" : searchValue);
        etSearch.setSelection(etSearch.getText().length());
    }

    @OnClick({R.id.iv_back, R.id.tv_label_delete, R.id.tv_label_brand_delete, R.id.tv_label_models_delete, R.id.tv_zh, R.id.tv_classify, R.id.tv_brand, R.id.tv_models})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                this.finish();
                break;
            case R.id.tv_label_delete:
                latelClassify = "";
                map.put("CategoryName",latelClassify);
                tvLabelDelete.setVisibility(View.GONE);
                updateDate(map);
                break;
            case R.id.tv_label_brand_delete:
                latelBrand = "";
                map.put("BrandName",latelBrand);
                tvLabelBrandDelete.setVisibility(View.GONE);
                updateDate(map);
                break;
            case R.id.tv_label_models_delete:
                map.remove("CarID");
                tvLabelModelsDelete.setVisibility(View.GONE);
                updateDate(map);
                break;
            case R.id.tv_zh:
                //价格
                map.put("","");
                break;
            case R.id.tv_classify:
                //分类
                if (!isClassifyShow) {
                    setContentFragment(FRAGMENT_TAG_CARCLASSIFY);
                    isClassifyShow = true;
                    isCarShow = false;
                    isBrandShow = false;
                }else {
                    isCarShow = false;
                    isBrandShow = false;
                    isClassifyShow = false;
                    setContentFragment(FRAGMENT_TAG_GOODS);
                }
                break;
            case R.id.tv_brand:
                //品牌
                if (!isBrandShow) {
                    setContentFragment(FRAGMENT_TAG_BRAND);
                    isBrandShow = true;
                    isClassifyShow = false;
                    isCarShow = false;
                }else {
                    isCarShow = false;
                    isBrandShow = false;
                    isClassifyShow = false;
                    setContentFragment(FRAGMENT_TAG_GOODS);
                }
                break;
            case R.id.tv_models:
                //车型
                if (!isCarShow) {
                    isCarShow = true;
                    isBrandShow = false;
                    isClassifyShow = false;
                    setContentFragment(FRAGMENT_TAG_CARBRAND);
                }else {
                    isCarShow = false;
                    isBrandShow = false;
                    isClassifyShow = false;
                    setContentFragment(FRAGMENT_TAG_GOODS);
                }

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
        models = CarBrandFragment.newInstance((ArrayList<ClassificationBean.ListCarBrandBean>) listCarBrandBeans);
    }

    @Override
    public void showGoodsList(GoodsListBean goodsListBean) {
        if (page == 1){
            goodsListBean.setIsMore(1);
        }else {
            goodsListBean.setIsMore(2);
        }
        //向商品Fragment发送数据
        EventBus.getDefault().post(goodsListBean);
        page++;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getGoosData(GoodsMoreBean bean){
        //刷新ui
        if (bean.getInteger() == 1) {
            page = 1;
            map.put("PageIndex",page);
            mPresenter.getGoodsSearch(map);
        }else {
            map.put("PageIndex",page);
            mPresenter.getGoodsSearch(map);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getType(CarClassifyBean carClassifyBean){
        switch (carClassifyBean.getType()){
            case "brand":
                latelBrand = carClassifyBean.getName();
                map.put("BrandName",latelBrand);
                tvLabelBrandDelete.setVisibility(View.VISIBLE);
                tvLabelBrandDelete.setText(latelBrand);
                updateDate(map);
                isCarShow = false;
                isBrandShow = false;
                isClassifyShow = false;
                setContentFragment(FRAGMENT_TAG_GOODS);
                break;
            case "classify":
                latelClassify = carClassifyBean.getName();
                map.put("CategoryName",latelClassify);
                tvLabelDelete.setVisibility(View.VISIBLE);
                tvLabelDelete.setText(latelClassify);
                updateDate(map);
                isCarShow = false;
                isBrandShow = false;
                isClassifyShow = false;
                setContentFragment(FRAGMENT_TAG_GOODS);
                break;
            case "carBrand":
                latelCarBrand = carClassifyBean.getName();
                cid = carClassifyBean.getCid();
                map.put("CarID", cid);
                updateDate(map);
                tvLabelModelsDelete.setText(latelCarBrand);
                tvLabelModelsDelete.setVisibility(View.VISIBLE);
                isCarShow = false;
                isBrandShow = false;
                isClassifyShow = false;
                setContentFragment(FRAGMENT_TAG_GOODS);
                break;
        }
        if (!isShow(mLlabel)){
            mLlabel.setVisibility(View.VISIBLE);
        }
    }

    public void updateDate(Map<String , Object> map){
        page = 1;
        mPresenter.getGoodsSearch(map);
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
                    foundFragment = new GoodsFragment();
                    break;
                case FRAGMENT_TAG_BRAND:
                    foundFragment = brand;
                    break;
                case FRAGMENT_TAG_CARCLASSIFY:
                    foundFragment = classification;
                    break;
                case FRAGMENT_TAG_CARBRAND:
                    foundFragment = models;
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
