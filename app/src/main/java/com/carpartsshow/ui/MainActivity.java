package com.carpartsshow.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.carpartsshow.R;
import com.carpartsshow.base.BaseActivity;
import com.carpartsshow.eventbus.HomePageBean;
import com.carpartsshow.ui.classify.ClassifyFragment;
import com.carpartsshow.ui.home.HomeFragment;
import com.carpartsshow.ui.me.MeFragment;
import com.carpartsshow.ui.scancode.activity.ScanCodeActivity;
import com.carpartsshow.ui.shopping.ShoppingCartActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

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

    public static void start(Context context) {
        Intent starter = new Intent(context, MainActivity.class);
        context.startActivity(starter);
    }

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
    protected void onCreate(Bundle savedInstanceState) {
        setImmersionStateMode(this);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void init() {
        fragmentManager = getSupportFragmentManager();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void setData() {
        selectNavigation();
        setContentFragment(tag);
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
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
                Intent intent = new Intent();
                intent.setClass(this, ShoppingCartActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_me:
                tag = ME;
                break;
            case R.id.tv_scan_code:
                ScanCodeActivity.start(this);
                break;
        }
        selectNavigation();
        setContentFragment(tag);
    }

    @Subscribe
    public void selectFragment(HomePageBean homePageBean){
        switch (homePageBean.getPage()){
            case 1 :
                tag = CLASSIFY;
                selectNavigation();
                setContentFragment(tag);
                break;
            case 2 :
                tag = CLASSIFY;
                selectNavigation();
                setContentFragment(tag);
                break;
            case 3 :
                tag = CLASSIFY;
                selectNavigation();
                setContentFragment(tag);
                break;
            case 4:
                tag = HOME;
                selectNavigation();
                setContentFragment(tag);
                break;
        }
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
//                tvHome.setSelected(false);
//                tvClassify.setSelected(false);
////                tvScanCode.setSelected(false);
//                tvShoppingCart.setSelected(true);
//                tvMe.setSelected(false);
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
//                    foundFragment = new ScanCodeFragment();
                    break;
                case SHOPPINGCART:
//                    foundFragment = new ScanCodeFragment();
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    /**
     * 兼容状态栏透明（沉浸式）
     * @param activity
     */
    public static void setImmersionStateMode(Activity activity){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT && Build.VERSION.SDK_INT != Build.VERSION_CODES.LOLLIPOP) {
            // 透明状态栏
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            // 透明导航栏
            // getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        } else if (Build.VERSION.SDK_INT == Build.VERSION_CODES.LOLLIPOP) {
            Window window = activity.getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS |
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    // | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
            window.setNavigationBarColor(Color.TRANSPARENT);
        }
    }
}
