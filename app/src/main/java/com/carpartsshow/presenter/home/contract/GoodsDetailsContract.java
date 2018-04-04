package com.carpartsshow.presenter.home.contract;

import com.carpartsshow.base.BasePresenter;
import com.carpartsshow.base.BaseView;
import com.carpartsshow.model.http.bean.GoodsDetailBean;
import com.carpartsshow.model.http.bean.OrderBean;

/**
 * Created by lizhe on 2018/3/30.
 */

public interface GoodsDetailsContract {

    interface View extends BaseView{
        void shoeGoodsDetails(GoodsDetailBean goodsDetailBean);

        void state(String msg);

        void showToOrder(OrderBean orderBean);

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

    }
}
