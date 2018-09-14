package com.whmnrc.carpartsshow.presenter.home.contract;

import com.whmnrc.carpartsshow.base.BasePresenter;
import com.whmnrc.carpartsshow.base.BaseView;
import com.whmnrc.carpartsshow.model.http.bean.GoodsDetailBean;
import com.whmnrc.carpartsshow.model.http.bean.OrderBean;
import com.whmnrc.carpartsshow.model.http.bean.OrderBeanV2;
import com.whmnrc.carpartsshow.model.http.bean.SeckillGoodsDetail;

/**
 * Created by lizhe on 2018/3/30.
 */

public interface GoodsDetailsContract {

    interface View extends BaseView{
        void shoeGoodsDetails(GoodsDetailBean goodsDetailBean);

        void state(String msg);

        void showToOrder(OrderBeanV2 orderBean);

        void showSeckillGoods(SeckillGoodsDetail seckillGoodsDetail);

    }

    interface Presenter extends BasePresenter<View> {
        void getGoods(String userId, String goodsId);

        //收藏
        void collections(String userId,String pids);

        //取消收藏
        void delCollections(String cids);

        //支付
        void generateOrder(String userId,String pids);

        //加入购物车
        void plus(String userId,String productId,int productType);

        //
        void seckillGoodsDetail(String userId,String seckillId);

    }
}
