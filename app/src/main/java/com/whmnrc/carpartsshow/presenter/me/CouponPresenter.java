package com.whmnrc.carpartsshow.presenter.me;

import com.whmnrc.carpartsshow.base.BasePresenterImpl;
import com.whmnrc.carpartsshow.base.CommonSubscriber;
import com.whmnrc.carpartsshow.model.DataManager;
import com.whmnrc.carpartsshow.model.http.bean.CouponBean;
import com.whmnrc.carpartsshow.model.http.response.CPSResponse;
import com.whmnrc.carpartsshow.presenter.me.contract.CouponContract;
import com.whmnrc.carpartsshow.util.RxUtil;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by lizhe on 2018/3/15.
 */

public class CouponPresenter extends BasePresenterImpl<CouponContract.View> implements CouponContract.Presenter{

    DataManager dataManager;
    private int page = 1;
    private int size = 10;

    @Inject
    public CouponPresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public void getCoupon(String userId, final int type) {
        if (type == 1){
            page = 1;
        }
        addSubscribe(dataManager.fetchUserCoupon(userId,page,size,0)
                .compose(RxUtil.<CPSResponse<List<CouponBean>>>rxSchedulerHelper())
                .compose(RxUtil.<List<CouponBean>>handle())
                .subscribeWith(new CommonSubscriber<List<CouponBean>>(mView){
                    @Override
                    public void onNext(List<CouponBean> list) {
                        super.onNext(list);
                        if (type == 1){
                            mView.showContent(list);
                        }else {
                            mView.loadMore(list);
                        }
                        page++;
                    }
                })
        );
    }




}
