package com.whmnrc.carpartsshow.presenter.me.contract;

import com.whmnrc.carpartsshow.base.BasePresenter;
import com.whmnrc.carpartsshow.base.BaseView;

/**
 * Created by lizhe on 2018/3/15.
 */

public interface FeedBackContract {

    interface View extends BaseView{
        void state();
    }

    interface Presenter extends BasePresenter<View>{
        void submitFeedback(String feedbackRemark,String userId);
    }

}
