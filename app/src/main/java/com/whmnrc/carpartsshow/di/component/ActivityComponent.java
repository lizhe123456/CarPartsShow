package com.whmnrc.carpartsshow.di.component;

import android.app.Activity;

import com.whmnrc.carpartsshow.di.module.ActivityModule;
import com.whmnrc.carpartsshow.di.scope.ActivityScope;
import com.whmnrc.carpartsshow.ui.FingerprintLoginActivity;
import com.whmnrc.carpartsshow.ui.ForgetPassActivity;
import com.whmnrc.carpartsshow.ui.LoginActivity;
import com.whmnrc.carpartsshow.ui.NewPassActivity;
import com.whmnrc.carpartsshow.ui.SplashActivity;
import com.whmnrc.carpartsshow.ui.classify.activity.CarBrandDetailsActivity;
import com.whmnrc.carpartsshow.ui.home.activity.GoodsDetailsActivity;
import com.whmnrc.carpartsshow.ui.home.activity.GoodsSearchActivity;
import com.whmnrc.carpartsshow.ui.home.activity.MessageRecordActivity;
import com.whmnrc.carpartsshow.ui.home.activity.TimelimitActivity;
import com.whmnrc.carpartsshow.ui.me.activity.AllOrderActivity;
import com.whmnrc.carpartsshow.ui.me.activity.FeedbackActivity;
import com.whmnrc.carpartsshow.ui.me.activity.IntegralGoodsActivity;
import com.whmnrc.carpartsshow.ui.me.activity.IntegralRecordActivity;
import com.whmnrc.carpartsshow.ui.me.activity.IntegralShopActivity;
import com.whmnrc.carpartsshow.ui.me.activity.MyCollectActivity;
import com.whmnrc.carpartsshow.ui.me.activity.MyCouponActivity;
import com.whmnrc.carpartsshow.ui.me.activity.MyIntegralActivity;
import com.whmnrc.carpartsshow.ui.me.activity.NewsActivity;
import com.whmnrc.carpartsshow.ui.me.activity.ReturnGoodsActivity;
import com.whmnrc.carpartsshow.ui.me.activity.UpdateAddressActivity;
import com.whmnrc.carpartsshow.ui.me.activity.UpdatePassActivity;
import com.whmnrc.carpartsshow.ui.scancode.activity.ScanCodeActivity;
import com.whmnrc.carpartsshow.ui.scancode.activity.VINActivity;
import com.whmnrc.carpartsshow.ui.scancode.activity.VINResultActivity;
import com.whmnrc.carpartsshow.ui.shopping.ShoppingCartActivity;
import com.whmnrc.carpartsshow.ui.shopping.activity.ConfirmOrderActivity;

import dagger.Component;

/**
 * Created by lizhe on 2017/12/11 0011.
 * 目标定在月亮之上，即使失败，也可以落在众星之间。
 */
@ActivityScope
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    Activity getActivity();


    void inject(LoginActivity loginActivity);

    void inject(ForgetPassActivity forgetPassActivity);

    void inject(NewPassActivity newPassActivity);

    void inject(MyIntegralActivity myIntegralActivity);

    void inject(UpdatePassActivity updatePassActivity);

    void inject(FeedbackActivity feedbackActivity);

    void inject(MyCouponActivity myCouponActivity);

    void inject(MyCollectActivity myCollectActivity);

    void inject(UpdateAddressActivity updateAddressActivity);

    void inject(IntegralShopActivity integralShopActivity);

    void inject(IntegralRecordActivity integralRecordActivity);

    void inject(IntegralGoodsActivity integralGoodsActivity);

    void inject(GoodsSearchActivity goodsSearchActivity);

    void inject(ShoppingCartActivity shoppingCartActivity);

    void inject(MessageRecordActivity messageRecordActivity);

    void inject(NewsActivity newsActivity);

    void inject(CarBrandDetailsActivity carBrandDetailsActivity);

    void inject(GoodsDetailsActivity goodsDetailsActivity);

    void inject(ConfirmOrderActivity confirmOrderActivity);

    void inject(AllOrderActivity allOrderActivity);

    void inject(TimelimitActivity timelimitActivity);

    void inject(ScanCodeActivity scanCodeActivity);

    void inject(FingerprintLoginActivity fingerprintLoginActivity);

    void inject(VINActivity vinActivity);

    void inject(VINResultActivity vinResultActivity);

    void inject(SplashActivity splashActivity);

    void inject(ReturnGoodsActivity returnGoodsActivity);
}
