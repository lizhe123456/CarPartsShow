package com.carpartsshow.presenter.me.contract;

import com.carpartsshow.base.BasePresenter;
import com.carpartsshow.base.BaseView;
import com.carpartsshow.model.http.bean.ConsumptionRecordBean;

import java.util.List;

/**
 * Created by lizhe on 2018/3/29.
 */

public interface CreditMoneyContract {

    interface View extends BaseView{
        void loadMore(List<ConsumptionRecordBean> list);

        void loadFrist(List<ConsumptionRecordBean> list);
    }

    interface Presenter extends BasePresenter<View>{
        void getCreditMoney(String userId,int state,int type);

        void getCreditMoney(String userId,int type);
    }

}
