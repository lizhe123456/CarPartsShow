package com.carpartsshow.presenter.home.contract;

import com.carpartsshow.base.BasePresenter;
import com.carpartsshow.base.BaseView;

/**
 * Created by lizhe on 2018/3/30.
 */

public interface GoodsDetailsContract {

    interface View extends BaseView{
        void shoeGoodsDetails(String url);
    }

    interface Presenter extends BasePresenter<View> {
        void getGoods(String userId, String goodsId);
    }
}
