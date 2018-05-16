package com.whmnrc.carpartsshow.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.whmnrc.carpartsshow.R;
import com.whmnrc.carpartsshow.app.App;
import com.whmnrc.carpartsshow.base.BaseActivity;
import com.whmnrc.carpartsshow.ui.classify.ClassifyFragment;
import com.whmnrc.carpartsshow.ui.home.HomeFragment;
import com.whmnrc.carpartsshow.ui.me.MeFragment;
import com.whmnrc.carpartsshow.ui.scancode.activity.VINActivity;
import com.whmnrc.carpartsshow.ui.shopping.ShoppingCartActivity;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

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
    private long exitTime = 0;
    private int page = 0;


    public void setPage(int page) {
        this.page = page;
    }

    public static void start(Context context, String page) {
        Intent starter = new Intent(context, MainActivity.class);
        starter.putExtra("page",page);
        context.startActivity(starter);
    }

    //首页
    public static final String HOME = "home";
    //查找
    public static final String CLASSIFY = "classify";
    //扫码
    private static final String SCANCODE = "scancode";
    //购物车
    private static final String SHOPPINGCART = "shop";
    //我的
    public static final String ME = "me";

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
        tag = getIntent().getStringExtra("page") == null ? HOME : getIntent().getStringExtra("page");
        selectNavigation();
        setContentFragment(tag);
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @OnClick({R.id.tv_home, R.id.tv_classify, R.id.tv_shopping_cart, R.id.tv_me, R.id.tv_scan_code})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_home:
                tag = HOME;
                selectNavigation();
                setContentFragment(tag);
                break;
            case R.id.tv_classify:
                tag = CLASSIFY;
                selectNavigation();
                setContentFragment(tag);
                break;
            case R.id.tv_shopping_cart:
//                tag = SHOPPINGCART;
                ShoppingCartActivity.start(this);
                break;
            case R.id.tv_me:
                tag = ME;
                selectNavigation();
                setContentFragment(tag);
                break;
            case R.id.tv_scan_code:
//                tag = SCANCODE;
                VINActivity.start(this);
                break;
        }


    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    //通过转入参数改变navigation颜色
    public void selectNavigation(){
        switch (tag){
            case HOME :
                tvHome.setSelected(true);
                tvClassify.setSelected(false);
                tvMe.setSelected(false);
                break;
            case CLASSIFY :
                tvHome.setSelected(false);
                tvClassify.setSelected(true);
                tvMe.setSelected(false);
                break;
            case ME :
                tvHome.setSelected(false);
                tvClassify.setSelected(false);
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
//        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE);
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
                    foundFragment = ClassifyFragment.newInstance(page);
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
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exit();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    public void exit() {
        if ((System.currentTimeMillis() - exitTime) > 2000) {
            Toast.makeText(getApplicationContext(), "再按一次退出程序",
                    Toast.LENGTH_SHORT).show();
            exitTime = System.currentTimeMillis();
        } else {
            App.getInstance().exitApp();
        }
    }

    /**
     * 兼容状态栏透明（沉浸式）
     * @param activity
     */
    public static void setImmersionStateMode(Activity activity){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT && Build.VERSION.SDK_INT != Build.VERSION_CODES.LOLLIPOP) {
            // 透明状态栏
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);   //去除半透明状态栏

                activity.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);  //一般配合fitsSystemWindows()使用, 或者在根部局加上属性android:fitsSystemWindows="true", 使根部局全屏显示

                activity.getWindow().setStatusBarColor(Color.TRANSPARENT);
            }
//            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//            activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
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
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(Color.TRANSPARENT);
            window.setNavigationBarColor(Color.TRANSPARENT);
        }
    }

    private Method noteStateNotSavedMethod;
    private Object fragmentMgr;
    private String[] activityClassName = {"Activity", "FragmentActivity"};

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        invokeFragmentManagerNoteStateNotSaved();
    }

    private void invokeFragmentManagerNoteStateNotSaved() {
        //java.lang.IllegalStateException: Can not perform this action after onSaveInstanceState
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB) {
            return;
        }
        try {
            if (noteStateNotSavedMethod != null && fragmentMgr != null) {
                noteStateNotSavedMethod.invoke(fragmentMgr);
                return;
            }
            Class cls = getClass();
            do {
                cls = cls.getSuperclass();
            } while (!(activityClassName[0].equals(cls.getSimpleName())
                    || activityClassName[1].equals(cls.getSimpleName())));

            Field fragmentMgrField = prepareField(cls, "mFragments");
            if (fragmentMgrField != null) {
                fragmentMgr = fragmentMgrField.get(this);
                noteStateNotSavedMethod = getDeclaredMethod(fragmentMgr, "noteStateNotSaved");
                if (noteStateNotSavedMethod != null) {
                    noteStateNotSavedMethod.invoke(fragmentMgr);
                }
            }

        } catch (Exception ex) {
        }
    }

    private Field prepareField(Class<?> c, String fieldName) throws NoSuchFieldException {
        while (c != null) {
            try {
                Field f = c.getDeclaredField(fieldName);
                f.setAccessible(true);
                return f;
            } finally {
                c = c.getSuperclass();
            }
        }
        throw new NoSuchFieldException();
    }

    private Method getDeclaredMethod(Object object, String methodName, Class<?>... parameterTypes) {
        Method method = null;
        for (Class<?> clazz = object.getClass(); clazz != Object.class; clazz = clazz.getSuperclass()) {
            try {
                method = clazz.getDeclaredMethod(methodName, parameterTypes);
                return method;
            } catch (Exception e) {
            }
        }
        return null;
    }

}
