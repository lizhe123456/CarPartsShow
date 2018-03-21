package com.carpartsshow.presenter.me;

import com.carpartsshow.base.BasePresenterImpl;
import com.carpartsshow.base.CommonSubscriber;
import com.carpartsshow.model.DataManager;
import com.carpartsshow.model.http.response.CPSResponse;
import com.carpartsshow.presenter.me.contract.FeedBackContract;
import com.carpartsshow.util.RxUtil;

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
