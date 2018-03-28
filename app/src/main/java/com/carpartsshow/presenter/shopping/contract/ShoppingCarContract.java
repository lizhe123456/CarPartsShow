package com.carpartsshow.presenter.shopping.contract;

import com.carpartsshow.base.BasePresenter;
import com.carpartsshow.base.BaseView;
import com.carpartsshow.model.http.bean.ShopCarBean;

/**
 * Created by lizhe on 2018/3/20.
 */

public interface ShoppingCarContract {

    interface View extends BaseView{
        void loadMore(ShopCarBean shopCarBean);

        void showContent(ShopCarBean shopCarBean);

        void updateNum(int type,int position);

        void state(String msg);
    }

    interface Presenter extends BasePresenter<View>{

        //购物车数据
        void getShoppingCarData(String userId,int type);
        //加一
        void plus(String userId,String productId,int productType,int position);
        //减一
        void reduce(String userId,String buyCarId,int position);

        //收藏
        void collections(String userId,String pids);
        //删除
        void delCards(String userId,String cids);
    }
}
