package com.carpartsshow.presenter.me;

import com.carpartsshow.base.BasePresenterImpl;
import com.carpartsshow.base.CommonSubscriber;
import com.carpartsshow.model.DataManager;
import com.carpartsshow.model.http.bean.CollectionBean;
import com.carpartsshow.model.http.response.CPSResponse;
import com.carpartsshow.presenter.me.contract.CollectionContract;
import com.carpartsshow.util.RxUtil;

import java.util.HashMap;
import java.util.Map;

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
    public void plus(String userId, String productId, int productType) {
        Map<String,Object> map = new HashMap<>();
        map.put("Product_ID",productId);
        map.put("Product_Type",productType);
        map.put("RepairUser_ID",userId);
        addSubscribe(dataManager.fetchAddCar(map)
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
