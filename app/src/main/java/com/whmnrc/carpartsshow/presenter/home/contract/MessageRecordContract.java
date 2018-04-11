package com.whmnrc.carpartsshow.presenter.home.contract;

import com.whmnrc.carpartsshow.base.BasePresenter;
import com.whmnrc.carpartsshow.base.BaseView;
import com.whmnrc.carpartsshow.model.http.bean.MsgBean;

import java.util.List;

/**
 * Created by lizhe on 2018/3/28.
 * 消息通知
 * type 1 刷新  2 加载更多
 */

public interface MessageRecordContract {

    interface View extends BaseView{
        void loadFirst(List<MsgBean> msgBeans);

        void loadMore(List<MsgBean> msgBeans);
    }

    interface Presenter extends BasePresenter<View>{

        void getMsgData(String userId, int type);
    }
}
