package com.carpartsshow.presenter.me;

import com.carpartsshow.base.BasePresenterImpl;
import com.carpartsshow.base.CommonSubscriber;
import com.carpartsshow.model.DataManager;
import com.carpartsshow.model.http.bean.ConsumptionRecordBean;
import com.carpartsshow.model.http.response.CPSResponse;
import com.carpartsshow.presenter.me.contract.CreditMoneyContract;
import com.carpartsshow.util.RxUtil;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by lizhe on 2018/3/29.
 */

public class CreditMoneyPresenter extends BasePresenterImpl<CreditMoneyContract.View> implements CreditMoneyContract.Presenter {

    int page = 1;
    int size = 10;
    DataManager dataManager;
    @Inject
    public CreditMoneyPresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public void getCreditMoney(String userId, final int type) {
        if (type == 1){
            page = 1;
        }
        addSubscribe(dataManager.splitCreditRecord(userId,size,page)
                .compose(RxUtil.<CPSResponse<List<ConsumptionRecordBean>>>rxSchedulerHelper())
                .compose(RxUtil.<List<ConsumptionRecordBean>>handle())
                .subscribeWith(new CommonSubscriber<List<ConsumptionRecordBean>>(mView){
                    @Override
                    public void onNext(List<ConsumptionRecordBean> cpsResponse) {
                        super.onNext(cpsResponse);
                        if (type == 1){
                            mView.loadFrist(cpsResponse);
                        }else {
                            mView.loadMore(cpsResponse);
                        }
                    }
                })
        );
    }

    @Override
    public void getCreditMoney(String userId, int state, final int type) {
        if (type == 1){
            page = 1;
        }
        addSubscribe(dataManager.splitCreditRecord(userId,size,page,state)
                .compose(RxUtil.<CPSResponse<List<ConsumptionRecordBean>>>rxSchedulerHelper())
                .compose(RxUtil.<List<ConsumptionRecordBean>>handle())
                .subscribeWith(new CommonSubscriber<List<ConsumptionRecordBean>>(mView){
                    @Override
                    public void onNext(List<ConsumptionRecordBean> cpsResponse) {
                        super.onNext(cpsResponse);
                        if (type == 1){
                            mView.loadFrist(cpsResponse);
                        }else {
                            mView.loadMore(cpsResponse);
                        }
                    }
                })
        );
    }


}
