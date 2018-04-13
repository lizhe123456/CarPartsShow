package com.whmnrc.carpartsshow.ui.home.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
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
import android.widget.TextView;
import com.whmnrc.carpartsshow.R;
import com.whmnrc.carpartsshow.app.Constants;
import com.whmnrc.carpartsshow.base.MvpActivity;
import com.whmnrc.carpartsshow.eventbus.CarClassifyBean;
import com.whmnrc.carpartsshow.eventbus.GoodsMoreBean;
import com.whmnrc.carpartsshow.model.http.bean.ClassificationBean;
import com.whmnrc.carpartsshow.model.http.bean.ClassificationItemBean;
import com.whmnrc.carpartsshow.model.http.bean.GoodsListBean;
import com.whmnrc.carpartsshow.model.http.bean.LoginBean;
import com.whmnrc.carpartsshow.presenter.home.GoodsSearchPresenter;
import com.whmnrc.carpartsshow.presenter.home.contract.GoodsSearchContract;
import com.whmnrc.carpartsshow.ui.classify.fragment.BrandFragment;
import com.whmnrc.carpartsshow.ui.classify.fragment.CarBrandFragment;
import com.whmnrc.carpartsshow.ui.classify.fragment.CarClassifyFragment;
import com.whmnrc.carpartsshow.ui.home.fragment.GoodsFragment;
import com.whmnrc.carpartsshow.ui.me.activity.CreditMoneyActivity;
import com.whmnrc.carpartsshow.ui.scancode.activity.ScanCodeActivity;
import com.whmnrc.carpartsshow.ui.scancode.activity.VINActivity;
import com.whmnrc.carpartsshow.util.SpUtil;
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
    private int step;

    //商品搜索请求参数map
    private Map<String , Object> map = new HashMap<>();

    public boolean isClassifyShow;
    public boolean isBrandShow;
    public boolean isCarShow;
    private String nLevelID;


    public static void start(Context context,String searchValue) {
        Intent starter = new Intent(context, GoodsSearchActivity.class);
        starter.putExtra("searchValue",searchValue);
        context.startActivity(starter);
    }

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
        loginBean = SpUtil.getObject(getApplicationContext(),"user");
        if (!loginBean.getRepairUser_CreditBeOverMoney().equals(loginBean.getRepairUser_CreditMoney())){
            if (Constants.IS_REPAYMENT){
                CreditMoneyActivity.start(this,1);
                Constants.IS_REPAYMENT = false;
            }
        }
        EventBus.getDefault().register(this);
        latelBrand = getIntent().getStringExtra("brand") == null ? "" : getIntent().getStringExtra("brand");
        latelClassify = getIntent().getStringExtra("classify") == null ? "" : getIntent().getStringExtra("classify");
        cid = getIntent().getIntExtra("cid",-1) ;
        latelCarBrand = getIntent().getStringExtra("carBrand") ;
        searchValue = getIntent().getStringExtra("searchValue") == null ? "" : getIntent().getStringExtra("searchValue");
        nLevelID = getIntent().getStringExtra("NLevelID") == null ? "" : getIntent().getStringExtra("NLevelID");
        step = Integer.parseInt(getIntent().getStringExtra("classifyStep") == null ? "0" : getIntent().getStringExtra("classifyStep"));
        initLabel();
        fragmentManager = getSupportFragmentManager();
        setContentFragment(FRAGMENT_TAG_GOODS);
        mPresenter.getClassification(loginBean.getRepairUser_ID());
        map.put("RepairUser_ID",loginBean.getRepairUser_ID());
        map.put("BrandName",latelBrand);
        map.put("CategoryName",latelClassify);
        if (cid != -1) {
            map.put("CarID", cid);
        }
        map.put("SearchValue",searchValue);
        if (step != 0) {
            map.put("Step", step);
        }
        if (!TextUtils.isEmpty(nLevelID)){
            map.put("NLevelID",nLevelID);
        }
        mPresenter.getGoodsSearch(map,1);
        etSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH){
                    searchValue = etSearch.getText().toString().trim();
                    map.put("SearchValue",searchValue);
                    mPresenter.getGoodsSearch(map,1);
                    return true;
                }
                return false;
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

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

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @OnClick({R.id.iv_back, R.id.tv_label_delete, R.id.tv_label_brand_delete, R.id.tv_label_models_delete, R.id.tv_zh, R.id.tv_classify, R.id.tv_brand, R.id.tv_models,R.id.iv_record})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                this.finish();
                break;
            case R.id.tv_label_delete:
                latelClassify = "";
                map.put("CategoryName",latelClassify);
                tvLabelDelete.setVisibility(View.GONE);
                initLabel();
                updateDate(map);
                break;
            case R.id.tv_label_brand_delete:
                latelBrand = "";
                map.put("BrandName",latelBrand);
                tvLabelBrandDelete.setVisibility(View.GONE);
                initLabel();
                updateDate(map);
                break;
            case R.id.tv_label_models_delete:
                latelCarBrand = "";
                map.remove("CarID");
                map.remove("NLevelID");
                tvLabelModelsDelete.setVisibility(View.GONE);
                initLabel();
                updateDate(map);
                break;
            case R.id.tv_zh:
                //价格
                if (isAsc) {
                    Drawable drawable = getResources().getDrawable(R.drawable.ic_asc);
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    tvZh.setCompoundDrawables(null,null,drawable,null);
                    map.put("OrderASC", "ASC");
                    isAsc = false;
                }else {
                    Drawable drawable = getResources().getDrawable(R.drawable.ic_desc);
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    tvZh.setCompoundDrawables(null,null,drawable,null);
                    map.put("OrderASC", "DESC");
                    isAsc = true;
                }
                updateDate(map);
                isCarShow = false;
                isBrandShow = false;
                isClassifyShow = false;
                setContentFragment(FRAGMENT_TAG_GOODS);
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
            case R.id.iv_record:
                ScanCodeActivity.start(GoodsSearchActivity.this);
                this.finish();
                break;
        }
    }

    boolean isAsc;

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
    public void showGoodsList(GoodsListBean goodsListBean,int type) {
        if (type == 1){
            goodsListBean.setIsMore(1);
        }else {
            goodsListBean.setIsMore(2);
        }
        //向商品Fragment发送数据
        EventBus.getDefault().post(goodsListBean);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getGoosData(GoodsMoreBean bean){
        //刷新ui
        if (bean.getInteger() == 1) {
            mPresenter.getGoodsSearch(map,1);
        }else {
            mPresenter.getGoodsSearch(map,2);
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
                step = Integer.parseInt(carClassifyBean.getcType());
                map.put("CategoryName",latelClassify);
                map.put("Step",step);
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
                map.remove("NLevelID");
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
        mPresenter.setDialog(true);
        mPresenter.getGoodsSearch(map,1);
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
