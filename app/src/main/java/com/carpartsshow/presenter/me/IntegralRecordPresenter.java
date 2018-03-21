package com.carpartsshow.presenter.me;

import com.carpartsshow.base.BasePresenterImpl;
import com.carpartsshow.base.CommonSubscriber;
import com.carpartsshow.model.DataManager;
import com.carpartsshow.model.http.bean.IntegralRecordBean;
import com.carpartsshow.model.http.response.CPSResponse;
import com.carpartsshow.presenter.me.contract.IntegralRecordContract;
import com.carpartsshow.util.RxUtil;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by lizhe on 2018/3/16.
 */

public class IntegralRecordPresenter extends BasePresenterImpl<IntegralRecordContract.View> implements IntegralRecordContract.Presenter {

    DataManager dataManager;
    private int page = 1;
    private int size = 10;

    @Inject
    public IntegralRecordPresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public void getRecord(String userId, final int type) {
        if (type == 1){
            page = 1;
        }
        addSubscribe(dataManager.fetchSplitExchangeRecord(userId,size,page)
                .compose(RxUtil.<CPSResponse<List<IntegralRecordBean>>>rxSchedulerHelper())
                .compose(RxUtil.<List<IntegralRecordBean>>handle())
                .subscribeWith(new CommonSubscriber<List<IntegralRecordBean>>(mView){
                    @Override
                    public void onNext(List<IntegralRecordBean> list) {
                        super.onNext(list);
                        if (type == 1){
                            mView.showContent(list);
                        }else {
                            mView.loadMore(list);
                        }
                        page++;
                    }
                })
        );
    }
}