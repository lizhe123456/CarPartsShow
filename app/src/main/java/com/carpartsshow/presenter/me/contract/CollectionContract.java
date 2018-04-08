package com.carpartsshow.presenter.me.contract;

import com.carpartsshow.base.BasePresenter;
import com.carpartsshow.base.BasePresenterImpl;
import com.carpartsshow.base.BaseView;
import com.carpartsshow.model.http.bean.CollectionBean;
import com.carpartsshow.model.http.bean.CouponBean;

import java.util.List;

/**
 * Created by lizhe on 2018/3/15.
 */

public interface CollectionContract {

    interface View extends BaseView{
        void showData(CollectionBean collectionBean);

        void loadMore(CollectionBean couponBean);

        void state(String msg);
    }

    interface Presenter extends BasePresenter<View> {
        void getCollectionList(String userId, int type);

        //取消收藏
        void delCollections(String cids);

        //加入购物车
        void plus(String userId,String productId,int productType);
    }
}
