package com.carpartsshow.presenter.me;

import com.carpartsshow.base.BasePresenterImpl;
import com.carpartsshow.base.CommonSubscriber;
import com.carpartsshow.model.DataManager;
import com.carpartsshow.model.http.response.CPSResponse;
import com.carpartsshow.presenter.me.contract.ForgetPassContract;
import com.carpartsshow.util.RxUtil;

import javax.inject.Inject;

/**
 * Created by lizhe on 2018/3/14.
 */

public class ForgetPassPresenter extends BasePresenterImpl<ForgetPassContract.View> implements ForgetPassContract.Presenter{

    DataManager dataManager;
    @Inject
    public ForgetPassPresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public void sendPhoneCode(String mobile) {
        addSubscribe(dataManager.fetchSendPhoneCode(mobile)
                .compose(RxUtil.<CPSResponse>rxSchedulerHelper())
                .compose(RxUtil.handleState())
                .subscribeWith(new CommonSubscriber<CPSResponse>(mView){
                    @Override
                    public void onNext(CPSResponse cpsResponse) {
                        super.onNext(cpsResponse);
                        mView.state();
                    }
                })
        );
    }
}
