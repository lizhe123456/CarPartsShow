package com.carpartsshow.presenter.home;

import com.carpartsshow.base.BasePresenterImpl;
import com.carpartsshow.base.CommonSubscriber;
import com.carpartsshow.model.DataManager;
import com.carpartsshow.model.http.bean.MsgBean;
import com.carpartsshow.model.http.response.CPSResponse;
import com.carpartsshow.presenter.home.contract.MessageRecordContract;
import com.carpartsshow.util.RxUtil;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by lizhe on 2018/3/28.
 */

public class MessageRecordPresenter extends BasePresenterImpl<MessageRecordContract.View> implements MessageRecordContract.Presenter{

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
