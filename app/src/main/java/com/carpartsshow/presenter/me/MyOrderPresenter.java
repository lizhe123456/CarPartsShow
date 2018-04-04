package com.carpartsshow.presenter.me;

import com.carpartsshow.base.BasePresenterImpl;
import com.carpartsshow.base.CommonSubscriber;
import com.carpartsshow.model.DataManager;
import com.carpartsshow.model.http.bean.LoginBean;
import com.carpartsshow.model.http.bean.OrderListBean;
import com.carpartsshow.model.http.response.CPSResponse;
import com.carpartsshow.presenter.me.contract.MyOrderContract;
import com.carpartsshow.util.RxUtil;
import com.carpartsshow.util.SpUtil;

import java.util.Map;

import javax.inject.Inject;

/**
 * Created by lizhe on 2018/3/31.
 */

public class MyOrderPresenter extends BasePresenterImpl<MyOrderContract.View> implements MyOrderContract.Presenter {

    DataManager dataManager;
    int size = 10;
    int page = 1;

    @Inject
    public MyOrderPresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public void getOrderList(String userId, int type, final int loadType) {
        if (loadType == 1){
            page = 1;
        }
        addSubscribe(dataManager.fetchSplitListOrder(userId,size,page,type)
                .compose(RxUtil.<CPSResponse<OrderListBean>>rxSchedulerHelper())
                .compose(RxUtil.<OrderListBean>handle())
                .subscribeWith(new CommonSubscriber<OrderListBean>(mView){
                    @Override
                    public void onNext(OrderListBean orderListBean) {
                        super.onNext(orderListBean);
                        if (loadType == 1){
                            mView.showData(orderListBean);
                        }else {
                            mView.loadMore(orderListBean);
                        }
                        page++;
                    }
                })
        );
    }

    @Override
    public void orderUrgent(String orderId) {
        //加急
        addSubscribe(dataManager.fetchSureOrderUrgent(orderId)
                .compose(RxUtil.<CPSResponse>rxSchedulerHelper())
                .compose(RxUtil.handleState())
                .subscribeWith(new CommonSubscriber<CPSResponse>(mView){
                    @Override
                    public void onNext(CPSResponse cpsResponse) {
                        super.onNext(cpsResponse);
                        mView.updateData();
                    }
                })
        );
    }

    @Override
    public void receiptGoods(String orderId) {
        mView.loading("收货中..");
        //收货
        addSubscribe(dataManager.fetchSureOrder(orderId)
                .compose(RxUtil.<CPSResponse>rxSchedulerHelper())
                .compose(RxUtil.handleState())
                .subscribeWith(new CommonSubscriber<CPSResponse>(mView){
                    @Override
                    public void onNext(CPSResponse cpsResponse) {
                        super.onNext(cpsResponse);
                        mView.updateData();
                    }
                })
        );
    }

    @Override
    public void cancelOrder(String orderId) {
        mView.loading("取消中..");
        //取消
        addSubscribe(dataManager.fetchCancelOrder(orderId)
                .compose(RxUtil.<CPSResponse>rxSchedulerHelper())
                .compose(RxUtil.handleState())
                .subscribeWith(new CommonSubscriber<CPSResponse>(mView){
                    @Override
                    public void onNext(CPSResponse cpsResponse) {
                        super.onNext(cpsResponse);
                        mView.updateData();
                    }
                })
        );
    }

    @Override
    public void pay(Map<String, Object> map) {

    }

    @Override
    public void lookProgress() {

    }


}
