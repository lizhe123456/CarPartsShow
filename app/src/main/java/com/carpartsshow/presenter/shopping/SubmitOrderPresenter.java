package com.carpartsshow.presenter.shopping;

import com.carpartsshow.base.BasePresenterImpl;
import com.carpartsshow.base.CommonSubscriber;
import com.carpartsshow.model.DataManager;
import com.carpartsshow.model.http.response.CPSResponse;
import com.carpartsshow.presenter.shopping.contract.SubmitOrderContract;
import com.carpartsshow.util.RxUtil;

import java.util.Map;

import javax.inject.Inject;

/**
 * Created by lizhe on 2018/3/30.
 */

public class SubmitOrderPresenter extends BasePresenterImpl<SubmitOrderContract.View> implements SubmitOrderContract.Presenter {

    DataManager dataManager;
    @Inject
    public SubmitOrderPresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public void submitOrder(Map<String,Object> map) {
        mView.loading("提交中..");
        addSubscribe(dataManager.fetchSubmitOrder(map)
                .compose(RxUtil.<CPSResponse>rxSchedulerHelper())
                .compose(RxUtil.handleState())
                .subscribeWith(new CommonSubscriber<CPSResponse>(mView){
                    @Override
                    public void onNext(CPSResponse cpsResponse) {
                        super.onNext(cpsResponse);
                        mView.submitSuccess();
                    }
                })
        );
    }
}
