package com.whmnrc.carpartsshow.ui.classify;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.whmnrc.carpartsshow.R;
import com.whmnrc.carpartsshow.base.MvpFragment;
import com.whmnrc.carpartsshow.base.adapter.BaseAdapter;
import com.whmnrc.carpartsshow.eventbus.HomePageBean;
import com.whmnrc.carpartsshow.model.http.bean.CarModelByVINBean;
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
import com.whmnrc.carpartsshow.ui.scancode.activity.ScanCodeActivity;
import com.whmnrc.carpartsshow.ui.scancode.adapter.ScanCodeCarBrandAdapter;
import com.whmnrc.carpartsshow.util.DensityUtils;
import com.whmnrc.carpartsshow.util.ScreenUtils;
import com.whmnrc.carpartsshow.util.SpUtil;
import com.whmnrc.carpartsshow.view.ScanCodeDialog;
import com.zyyoona7.lib.EasyPopup;
import com.zyyoona7.lib.HorizontalGravity;
import com.zyyoona7.lib.VerticalGravity;

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
    @BindView(R.id.tv_vin)
    TextView tvVin;
    @BindView(R.id.iv_scan)
    ImageView ivScan;
//    @BindView(R.id.stu_bar)
//    View view;

    private CarClassifyFragment classification;
    private BrandFragment brand;
    private CarBrandFragment models;
    private List<Fragment> fragments = new ArrayList<>();
    public int searchType;

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
//        LinearLayout.LayoutParams linearParams =(LinearLayout.LayoutParams) view.getLayoutParams();
//        //取控件textView当前的布局参数 linearParams.height = 20;// 控件的高强制设成20
//        linearParams.height = ScreenUtils.getStatusHeight(getContext());
//        view.setLayoutParams(linearParams);
        //使设置好的布局参数应用到控件
        loginBean = SpUtil.getObject(getContext(), "user");

        etSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    String value = etSearch.getText().toString().trim();
                    if (searchType == 0){
                        Intent intent = new Intent();
                        intent.setClass(getContext(), GoodsSearchActivity.class);
                        intent.putExtra("searchValue", value);
                        startActivity(intent);
                    }else {
                        mPresenter.searchVin(value);
                    }
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

    @Override
    public void showVinData(List<CarModelByVINBean> carModelByVINBean) {
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
            dialog.show(scanCodeCarBrandAdapter, carModelByVINBean);
        }
    }

    @Override
    public void updateBrand(List<ClassificationBean.ListBrandBean> listBrandBeans) {

    }


    @OnClick({R.id.tv_models, R.id.tv_classify, R.id.tv_brand,R.id.tv_vin,R.id.iv_scan})
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
            case R.id.tv_vin:
                showWindow(view);
                break;
            case R.id.iv_scan:
                ScanCodeActivity.start(getContext());
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
                ClassifyFragment.this.tvVin.setText("关键字");
                searchType = 0;
                mCirclePop.dismiss();
            }
        });
        tvVin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClassifyFragment.this.tvVin.setText("VIN");
                searchType = 1;
                mCirclePop.dismiss();
            }
        });
        mCirclePop.showAtAnchorView(view, VerticalGravity.BELOW, HorizontalGravity.ALIGN_LEFT, (int) 0, (int) 10);
    }

}
