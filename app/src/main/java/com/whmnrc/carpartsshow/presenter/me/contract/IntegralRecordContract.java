package com.whmnrc.carpartsshow.presenter.me.contract;

import com.whmnrc.carpartsshow.base.BasePresenter;
import com.whmnrc.carpartsshow.base.BaseView;
import com.whmnrc.carpartsshow.model.http.bean.IntegralRecordBean;

import java.util.List;

/**
 * Created by lizhe on 2018/3/16.
 */

public interface IntegralRecordContract {

    interface View extends BaseView{
        void showContent(List<IntegralRecordBean> list);

        void loadMore(List<IntegralRecordBean> list);
    }

    interface Presenter extends BasePresenter<View>{
        void getRecord(String userId, int type);
    }

}
