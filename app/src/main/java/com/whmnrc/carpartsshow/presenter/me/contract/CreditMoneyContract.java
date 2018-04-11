package com.whmnrc.carpartsshow.presenter.me.contract;

import com.whmnrc.carpartsshow.base.BasePresenter;
import com.whmnrc.carpartsshow.base.BaseView;
import com.whmnrc.carpartsshow.model.http.bean.ConsumptionRecordBean;

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
