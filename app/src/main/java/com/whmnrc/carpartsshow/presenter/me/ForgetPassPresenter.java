package com.whmnrc.carpartsshow.presenter.me;

import com.whmnrc.carpartsshow.base.BasePresenterImpl;
import com.whmnrc.carpartsshow.base.CommonSubscriber;
import com.whmnrc.carpartsshow.model.DataManager;
import com.whmnrc.carpartsshow.model.http.response.CPSResponse;
import com.whmnrc.carpartsshow.presenter.me.contract.ForgetPassContract;
import com.whmnrc.carpartsshow.util.RxUtil;

import javax.inject.Inject;

/**
 * Created by lizhe on 2018/3/14.
 */

public class ForgetPassPresenter extends BasePresenterImpl<ForgetPassContract.View> implements ForgetPassContract.Presenter {

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
