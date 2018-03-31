package com.carpartsshow.presenter.home;

import com.carpartsshow.base.BasePresenterImpl;
import com.carpartsshow.base.CommonSubscriber;
import com.carpartsshow.model.DataManager;
import com.carpartsshow.model.http.bean.GoodsDetailBean;
import com.carpartsshow.model.http.response.CPSResponse;
import com.carpartsshow.presenter.home.contract.GoodsDetailsContract;
import com.carpartsshow.util.RxUtil;

import javax.inject.Inject;

/**
 * Created by lizhe on 2018/3/30.
 */

public class GoodsDetailsPresenter extends BasePresenterImpl<GoodsDetailsContract.View> implements GoodsDetailsContract.Presenter{

    DataManager dataManager;

    @Inject
    public GoodsDetailsPresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public void getGoods(String userId, String goodsId) {
        mView.loading("加载中..");
        addSubscribe(dataManager.goodsDetail(userId, goodsId)
                .compose(RxUtil.<CPSResponse<GoodsDetailBean>>rxSchedulerHelper())
                .compose(RxUtil.<GoodsDetailBean>handle())
                .subscribeWith(new CommonSubscriber<GoodsDetailBean>(mView){
                    @Override
                    public void onNext(GoodsDetailBean goodsDetailBean) {
                        super.onNext(goodsDetailBean);
                        mView.shoeGoodsDetails(goodsDetailBean.getUrl());
                    }
                })
        );
    }
}
