package com.whmnrc.carpartsshow.presenter.me;

import com.whmnrc.carpartsshow.base.BasePresenterImpl;
import com.whmnrc.carpartsshow.base.CommonSubscriber;
import com.whmnrc.carpartsshow.model.DataManager;
import com.whmnrc.carpartsshow.model.http.response.CPSResponse;
import com.whmnrc.carpartsshow.presenter.me.contract.FeedBackContract;
import com.whmnrc.carpartsshow.util.RxUtil;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

/**
 * Created by lizhe on 2018/3/15.
 */

public class FeedBackPresenter extends BasePresenterImpl<FeedBackContract.View> implements FeedBackContract.Presenter {

    DataManager dataManager;
    @Inject
    public FeedBackPresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public void submitFeedback(String feedbackRemark, String userId) {
        Map<String, Object> map = new HashMap<>();
        map.put("Feedback_Remark",feedbackRemark);
        map.put("RepairUser_ID",userId);
        addSubscribe(dataManager.fetchSubmitFeedback(map)
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
