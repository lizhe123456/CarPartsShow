package com.carpartsshow.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.carpartsshow.R;
import com.carpartsshow.base.BaseActivity;
import com.carpartsshow.ui.classify.ClassifyFragment;
import com.carpartsshow.ui.home.HomeFragment;
import com.carpartsshow.ui.me.MeFragment;
import com.carpartsshow.ui.scancode.ScanCodeFragment;
import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.fragment_content)
    FrameLayout fragmentContent;
    @BindView(R.id.tv_home)
    TextView tvHome;
    @BindView(R.id.tv_classify)
    TextView tvClassify;
    @BindView(R.id.tv_shopping_cart)
    TextView tvShoppingCart;
    @BindView(R.id.tv_me)
    TextView tvMe;
    @BindView(R.id.tv_scan_code)
    TextView tvScanCode;

    private FragmentManager fragmentManager;
    private String currentFragmentTag;

    //首页
    private static final String HOME = "home";
    //查找
    private static final String CLASSIFY = "classify";
    //扫码
    private static final String SCANCODE = "scancode";
    //购物车
    private static final String SHOPPINGCART = "shop";
    //我的
    private static final String ME = "me";

    private String tag = HOME;

    @Override
    protected int setLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {
        fragmentManager = getSupportFragmentManager();
    }

    @Override
    protected void setData() {
        selectNavigation();
        setContentFragment(tag);
    }


    @OnClick({R.id.tv_home, R.id.tv_classify, R.id.tv_shopping_cart, R.id.tv_me, R.id.tv_scan_code})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_home:
                tag = HOME;
                break;
            case R.id.tv_classify:
                tag = CLASSIFY;
                break;
            case R.id.tv_shopping_cart:
                tag = SHOPPINGCART;
                break;
            case R.id.tv_me:
                tag = ME;
                break;
            case R.id.tv_scan_code:
                tag = SCANCODE;
                break;
        }
        selectNavigation();
        setContentFragment(tag);
    }

    //通过转入参数改变navigation颜色
    private void selectNavigation(){
        switch (tag){
            case HOME :
                tvHome.setSelected(true);
                tvClassify.setSelected(false);
//                tvScanCode.setSelected(false);
                tvShoppingCart.setSelected(false);
                tvMe.setSelected(false);
                break;
            case CLASSIFY :
                tvHome.setSelected(false);
                tvClassify.setSelected(true);
//                tvScanCode.setSelected(false);
                tvShoppingCart.setSelected(false);
                tvMe.setSelected(false);
                break;
            case SCANCODE :
//                tvHome.setSelected(true);
//                tvClassify.setSelected(false);
//                tvScanCode.setSelected(false);
//                tvShoppingCart.setSelected(false);
//                tvMe.setSelected(false);
                break;
            case SHOPPINGCART :
                tvHome.setSelected(false);
                tvClassify.setSelected(false);
//                tvScanCode.setSelected(false);
                tvShoppingCart.setSelected(true);
                tvMe.setSelected(false);
                break;
            case ME :
                tvHome.setSelected(false);
                tvClassify.setSelected(false);
//                tvScanCode.setSelected(false);
                tvShoppingCart.setSelected(false);
                tvMe.setSelected(true);
                break;
        }
    }

    //通过传入参数选择fragment
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
                case HOME:
                    foundFragment = new HomeFragment();
                    break;
                case CLASSIFY:
                    foundFragment = new ClassifyFragment();
                    break;
                case SCANCODE:
                    foundFragment = new ScanCodeFragment();
                    break;
                case SHOPPINGCART:
                    foundFragment = new ScanCodeFragment();
                    break;
                case ME:
                    foundFragment = new MeFragment();
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
