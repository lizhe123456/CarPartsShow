package com.carpartsshow.di.component;

import android.app.Activity;

import com.carpartsshow.di.module.ActivityModule;
import com.carpartsshow.di.scope.ActivityScope;
import com.carpartsshow.ui.ForgetPassActivity;
import com.carpartsshow.ui.LoginActivity;
import com.carpartsshow.ui.NewPassActivity;
import com.carpartsshow.ui.home.activity.GoodsSearchActivity;
import com.carpartsshow.ui.me.activity.FeedbackActivity;
import com.carpartsshow.ui.me.activity.IntegralGoodsActivity;
import com.carpartsshow.ui.me.activity.IntegralRecordActivity;
import com.carpartsshow.ui.me.activity.IntegralShopActivity;
import com.carpartsshow.ui.me.activity.MyCollectActivity;
import com.carpartsshow.ui.me.activity.MyCouponActivity;
import com.carpartsshow.ui.me.activity.MyIntegralActivity;
import com.carpartsshow.ui.me.activity.UpdateAddressActivity;
import com.carpartsshow.ui.me.activity.UpdatePassActivity;

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
}
