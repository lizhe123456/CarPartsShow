package com.whmnrc.carpartsshow.presenter.me;

import com.whmnrc.carpartsshow.app.App;
import com.whmnrc.carpartsshow.base.BasePresenterImpl;
import com.whmnrc.carpartsshow.base.CommonSubscriber;
import com.whmnrc.carpartsshow.model.DataManager;
import com.whmnrc.carpartsshow.model.http.bean.LoginBean;
import com.whmnrc.carpartsshow.model.http.bean.OrderListBean;
import com.whmnrc.carpartsshow.model.http.response.CPSResponse;
import com.whmnrc.carpartsshow.presenter.me.contract.MyOrderContract;
import com.whmnrc.carpartsshow.util.RxUtil;
import com.whmnrc.carpartsshow.util.SpUtil;

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
                            if (orderListBean.getData().size() == 0){
                                mView.showEmpty();
                            }
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
    public void applyCustomerService(Map<String,Object> map) {
        mView.loading("退货申请中..");
        addSubscribe(dataManager.submitRefundGoods(map)
                .compose(RxUtil.<CPSResponse>rxSchedulerHelper())
                .compose(RxUtil.handleState())
                .subscribeWith(new CommonSubscriber<CPSResponse>(mView){
                    @Override
                    public void onNext(CPSResponse cpsResponse) {
                        super.onNext(cpsResponse);
                        mView.updateData(cpsResponse.getMessage());
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
                        mView.updateData(cpsResponse.getMessage());
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
                        mView.updateData(cpsResponse.getMessage());
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
                        mView.updateData(cpsResponse.getMessage());
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
