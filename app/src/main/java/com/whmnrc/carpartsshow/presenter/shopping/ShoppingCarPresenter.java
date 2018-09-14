package com.whmnrc.carpartsshow.presenter.shopping;

import com.whmnrc.carpartsshow.base.BasePresenterImpl;
import com.whmnrc.carpartsshow.base.CommonSubscriber;
import com.whmnrc.carpartsshow.model.DataManager;
import com.whmnrc.carpartsshow.model.http.bean.OrderBean;
import com.whmnrc.carpartsshow.model.http.bean.OrderBeanV2;
import com.whmnrc.carpartsshow.model.http.bean.ShopCarBean;
import com.whmnrc.carpartsshow.model.http.response.CPSResponse;
import com.whmnrc.carpartsshow.presenter.shopping.contract.ShoppingCarContract;
import com.whmnrc.carpartsshow.util.RxUtil;

import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;

/**
 * Created by lizhe on 2018/3/20.
 */

public class ShoppingCarPresenter extends BasePresenterImpl<ShoppingCarContract.View> implements ShoppingCarContract.Presenter {

    DataManager dataManager;
    int page = 1;
    int size = 10;
    private boolean isLoading = true;

    @Inject
    public ShoppingCarPresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public void getShoppingCarData(String userId, final int type) {
        if (isLoading) {
            mView.loading("加载中..");
            isLoading = false;
        }
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
                            if (shopCarBean.getListCarProduct().size() == 0){
                                mView.showEmpty();
                            }
                            mView.showContent(shopCarBean);
                        }else {
                            mView.loadMore(shopCarBean);
                        }
                        page++;
                    }
                })
        );
    }

    @Override
    public void plus(String userId, String productId, int productType, final int position) {
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
                        mView.updateNum(0,position);
                    }
                })
        );
    }

    @Override
    public void reduce(String userId, String buyCarId, final int position) {
        Map<String,Object> map = new HashMap<>();
        map.put("BuyCar_ID",buyCarId);
        map.put("RepairUser_ID",userId);
        addSubscribe(dataManager.fetchSubCar(map)
                .compose(RxUtil.<CPSResponse>rxSchedulerHelper())
                .compose(RxUtil.handleState())
                .subscribeWith(new CommonSubscriber<CPSResponse>(mView){
                    @Override
                    public void onNext(CPSResponse cpsResponse) {
                        super.onNext(cpsResponse);
                        mView.updateNum(1,position);
                    }

                })
        );
    }

    @Override
    public void collections(String userId, String pids) {
        Map<String,Object> map = new HashMap<>();
        map.put("Pids",pids);
        map.put("RepairUser_ID",userId);
        addSubscribe(dataManager.fetchAppendCollections(map)
                .compose(RxUtil.<CPSResponse>rxSchedulerHelper())
                .compose(RxUtil.handleState())
                .subscribeWith(new CommonSubscriber<CPSResponse>(mView){
                    @Override
                    public void onNext(CPSResponse cpsResponse) {
                        super.onNext(cpsResponse);
                        //收藏成功
                        mView.state(cpsResponse.getMessage());
                    }
                })
        );
    }

    @Override
    public void delCards(final String userId, String cids) {
        addSubscribe(dataManager.fetchDelCards(cids)
                .compose(RxUtil.<CPSResponse>rxSchedulerHelper())
                .compose(RxUtil.handleState())
                .subscribeWith(new CommonSubscriber<CPSResponse>(mView){
                    @Override
                    public void onNext(CPSResponse cpsResponse) {
                        super.onNext(cpsResponse);
                        getShoppingCarData(userId,1);
                        //删除成功
                        mView.state(cpsResponse.getMessage());
                    }
                })
        );
    }

    @Override
    public void generateOrder(String userId, String pids) {
        mView.loading("提交中..");
        addSubscribe(dataManager.fetchToOder(userId,pids)
                .compose(RxUtil.<CPSResponse<OrderBeanV2>>rxSchedulerHelper())
                .compose(RxUtil.<OrderBeanV2>handle())
                .subscribeWith(new CommonSubscriber<OrderBeanV2>(mView){
                    @Override
                    public void onNext(OrderBeanV2 orderBean) {
                        super.onNext(orderBean);
                        mView.showToOrder(orderBean);
                    }
                })
        );
    }


}
