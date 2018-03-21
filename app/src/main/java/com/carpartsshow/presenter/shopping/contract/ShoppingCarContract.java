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

    }

    interface Presenter extends BasePresenter<View>{
        void getShoppingCarData(String userId,int type);
    }
}
