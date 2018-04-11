package com.whmnrc.carpartsshow.presenter.me;

import com.whmnrc.carpartsshow.base.BasePresenterImpl;
import com.whmnrc.carpartsshow.base.CommonSubscriber;
import com.whmnrc.carpartsshow.model.DataManager;
import com.whmnrc.carpartsshow.model.http.bean.CollectionBean;
import com.whmnrc.carpartsshow.model.http.response.CPSResponse;
import com.whmnrc.carpartsshow.presenter.me.contract.CollectionContract;
import com.whmnrc.carpartsshow.util.RxUtil;

import javax.inject.Inject;

/**
 * Created by lizhe on 2018/3/15.
 */

public class CollectionPresenter extends BasePresenterImpl<CollectionContract.View> implements CollectionContract.Presenter {

    DataManager dataManager;
    private int page = 1;
    private int size = 10;
    @Inject
    public CollectionPresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public void getCollectionList(String userId, final int type) {
        if (type == 1){
            page = 1;
        }
        addSubscribe(dataManager.fetchCollection(userId,page,size)
                .compose(RxUtil.<CPSResponse<CollectionBean>>rxSchedulerHelper())
                .compose(RxUtil.<CollectionBean>handle())
                .subscribeWith(new CommonSubscriber<CollectionBean>(mView){
                    @Override
                    public void onNext(CollectionBean collectionBean) {
                        super.onNext(collectionBean);
                        if (type == 1){
                            mView.showData(collectionBean);
                        }else {
                            mView.loadMore(collectionBean);
                        }
                        page++;
                    }
                })
        );
    }

    @Override
    public void delCollections(String cids) {
        addSubscribe(dataManager.fetchDelCollection(cids)
                .compose(RxUtil.<CPSResponse>rxSchedulerHelper())
                .compose(RxUtil.handleState())
                .subscribeWith(new CommonSubscriber<CPSResponse>(mView){
                    @Override
                    public void onNext(CPSResponse cpsResponse) {
                        super.onNext(cpsResponse);
                        mView.state(cpsResponse.getMessage());
                    }
                })
        );
    }

    @Override
    public void plus(String userId, String productId) {
        addSubscribe(dataManager.fetchAddCar(userId,productId)
                .compose(RxUtil.<CPSResponse>rxSchedulerHelper())
                .compose(RxUtil.handleState())
                .subscribeWith(new CommonSubscriber<CPSResponse>(mView){
                    @Override
                    public void onNext(CPSResponse cpsResponse) {
                        super.onNext(cpsResponse);
                        mView.state(cpsResponse.getMessage());
                    }
                })
        );
    }
}
