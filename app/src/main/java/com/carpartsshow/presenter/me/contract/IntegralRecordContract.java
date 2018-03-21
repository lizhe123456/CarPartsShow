package com.carpartsshow.presenter.me.contract;

import com.carpartsshow.base.BasePresenter;
import com.carpartsshow.base.BaseView;
import com.carpartsshow.model.http.bean.IntegralRecordBean;

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
