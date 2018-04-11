package com.whmnrc.carpartsshow.presenter.me.contract;

import com.whmnrc.carpartsshow.base.BasePresenter;
import com.whmnrc.carpartsshow.base.BaseView;
import com.whmnrc.carpartsshow.model.http.bean.CouponBean;

import java.util.List;

/**
 * Created by lizhe on 2018/3/15.
 */

public interface CouponContract {

    interface View extends BaseView{
        void showContent(List<CouponBean> couponBean);

        void loadMore(List<CouponBean> couponBean);


    }

    interface Presenter extends BasePresenter<View> {
        void getCoupon(String userId,int type);


    }

}
