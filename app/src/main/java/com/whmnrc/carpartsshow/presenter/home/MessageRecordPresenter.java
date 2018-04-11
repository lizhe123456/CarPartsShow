package com.whmnrc.carpartsshow.presenter.home;

import com.whmnrc.carpartsshow.base.BasePresenterImpl;
import com.whmnrc.carpartsshow.base.CommonSubscriber;
import com.whmnrc.carpartsshow.model.DataManager;
import com.whmnrc.carpartsshow.model.http.bean.MsgBean;
import com.whmnrc.carpartsshow.model.http.response.CPSResponse;
import com.whmnrc.carpartsshow.presenter.home.contract.MessageRecordContract;
import com.whmnrc.carpartsshow.util.RxUtil;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by lizhe on 2018/3/28.
 */

public class MessageRecordPresenter extends BasePresenterImpl<MessageRecordContract.View> implements MessageRecordContract.Presenter {

    int page = 1;
    DataManager dataManager;

    @Inject
    public MessageRecordPresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public void getMsgData(String userId, final int type) {
        if (type == 1){
            page = 1;
        }
        addSubscribe(dataManager.fetchSplitUserMsg(userId,page)
            .compose(RxUtil.<CPSResponse<List<MsgBean>>>rxSchedulerHelper())
                .compose(RxUtil.<List<MsgBean>>handle())
                .subscribeWith(new CommonSubscriber<List<MsgBean>>(mView){
                    @Override
                    public void onNext(List<MsgBean> msgBeans) {
                        super.onNext(msgBeans);
                        if (type == 1){
                            if (msgBeans.size() == 0){
                                mView.showEmpty();
                            }
                            mView.loadFirst(msgBeans);
                        }else {
                            mView.loadMore(msgBeans);
                        }
                        page++;
                    }
                })
        );
    }
}
