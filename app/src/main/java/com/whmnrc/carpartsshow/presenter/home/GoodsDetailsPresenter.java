package com.whmnrc.carpartsshow.presenter.home;

import com.whmnrc.carpartsshow.base.BasePresenterImpl;
import com.whmnrc.carpartsshow.base.CommonSubscriber;
import com.whmnrc.carpartsshow.model.DataManager;
import com.whmnrc.carpartsshow.model.http.bean.GoodsDetailBean;
import com.whmnrc.carpartsshow.model.http.bean.OrderBean;
import com.whmnrc.carpartsshow.model.http.bean.SeckillGoodsDetail;
import com.whmnrc.carpartsshow.model.http.response.CPSResponse;
import com.whmnrc.carpartsshow.presenter.home.contract.GoodsDetailsContract;
import com.whmnrc.carpartsshow.util.RxUtil;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

/**
 * Created by lizhe on 2018/3/30.
 */

public class GoodsDetailsPresenter extends BasePresenterImpl<GoodsDetailsContract.View> implements GoodsDetailsContract.Presenter{

    DataManager dataManager;

    @Inject
    public GoodsDetailsPresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public void getGoods(String userId, String goodsId) {
        addSubscribe(dataManager.goodsDetail(userId, goodsId)
                .compose(RxUtil.<CPSResponse<GoodsDetailBean>>rxSchedulerHelper())
                .compose(RxUtil.<GoodsDetailBean>handle())
                .subscribeWith(new CommonSubscriber<GoodsDetailBean>(mView){
                    @Override
                    public void onNext(GoodsDetailBean goodsDetailBean) {
                        super.onNext(goodsDetailBean);
                        mView.shoeGoodsDetails(goodsDetailBean);
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

    @Override
    public void seckillGoodsDetail(String userId, String seckillId) {
        addSubscribe(dataManager.seckillGoodsDetail(userId, seckillId)
                .compose(RxUtil.<CPSResponse<SeckillGoodsDetail>>rxSchedulerHelper())
                .compose(RxUtil.<SeckillGoodsDetail>handle())
                .subscribeWith(new CommonSubscriber<SeckillGoodsDetail>(mView){
                    @Override
                    public void onNext(SeckillGoodsDetail seckillGoodsDetail) {
                        super.onNext(seckillGoodsDetail);
                        mView.showSeckillGoods(seckillGoodsDetail);
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
    public void generateOrder(String userId, String pids) {
        mView.loading("提交中..");
        addSubscribe(dataManager.fetchToOder(userId,pids)
                .compose(RxUtil.<CPSResponse<OrderBean>>rxSchedulerHelper())
                .compose(RxUtil.<OrderBean>handle())
                .subscribeWith(new CommonSubscriber<OrderBean>(mView){
                    @Override
                    public void onNext(OrderBean orderBean) {
                        super.onNext(orderBean);
                        mView.showToOrder(orderBean);
                    }
                })
        );
    }
}
