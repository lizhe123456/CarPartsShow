package com.carpartsshow.presenter.me;

import com.carpartsshow.base.BasePresenterImpl;
import com.carpartsshow.base.CommonSubscriber;
import com.carpartsshow.model.DataManager;
import com.carpartsshow.model.http.bean.IntergralShopBean;
import com.carpartsshow.model.http.response.CPSResponse;
import com.carpartsshow.presenter.me.contract.IntegralShopContract;
import com.carpartsshow.util.RxUtil;

import javax.inject.Inject;

/**
 * Created by lizhe on 2018/3/16.
 */

public class IntegralShopPresenter extends BasePresenterImpl<IntegralShopContract.View> implements IntegralShopContract.Presenter {

    DataManager dataManager;
    private int page = 1;
    private int size = 10;

    @Inject
    public IntegralShopPresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public void getIntegralShop(String searchValue,final int type) {
        if (type == 1){
            page = 1;
        }
        addSubscribe(dataManager.fetchSplitShopIndex(searchValue,page,size)
                .compose(RxUtil.<CPSResponse<IntergralShopBean>>rxSchedulerHelper())
                .compose(RxUtil.<IntergralShopBean>handle())
                .subscribeWith(new CommonSubscriber<IntergralShopBean>(mView){
                    @Override
                    public void onNext(IntergralShopBean intergralShopBean) {
                        super.onNext(intergralShopBean);
                        if (type == 1){
                            mView.showCentent(intergralShopBean);
                        }else {
                            mView.loadMore(intergralShopBean);
                        }
                        page++;
                    }
                })
        );
    }
}
