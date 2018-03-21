package com.carpartsshow.presenter.shopping;

import com.carpartsshow.base.BasePresenterImpl;
import com.carpartsshow.base.CommonSubscriber;
import com.carpartsshow.model.DataManager;
import com.carpartsshow.model.http.bean.ShopCarBean;
import com.carpartsshow.model.http.response.CPSResponse;
import com.carpartsshow.presenter.shopping.contract.ShoppingCarContract;
import com.carpartsshow.util.RxUtil;

import javax.inject.Inject;

/**
 * Created by lizhe on 2018/3/20.
 */

public class ShoppingCarPresenter extends BasePresenterImpl<ShoppingCarContract.View> implements ShoppingCarContract.Presenter {

    DataManager dataManager;
    int page = 1;
    int size = 10;
    @Inject
    public ShoppingCarPresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public void getShoppingCarData(String userId, final int type) {
        if (type == 1){
            page = 1;
        }
        addSubscribe(dataManager.userShopingCarList(userId,size,page)
                .compose(RxUtil.<CPSResponse<ShopCarBean>>rxSchedulerHelper())
                .compose(RxUtil.<ShopCarBean>handle())
                .subscribeWith(new CommonSubscriber<ShopCarBean>(mView){
                    @Override
                    public void onNext(ShopCarBean shopCarBean) {
                        super.onNext(shopCarBean);
                        if (type == 1){
                            mView.showContent(shopCarBean);
                        }else {
                            mView.loadMore(shopCarBean);
                        }
                        page++;
                    }
                })
        );
    }
    
}
