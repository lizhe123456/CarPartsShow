package com.whmnrc.carpartsshow.presenter.me.contract;

import com.whmnrc.carpartsshow.base.BasePresenter;
import com.whmnrc.carpartsshow.base.BaseView;
import com.whmnrc.carpartsshow.model.http.bean.IntergralShopBean;

import java.util.List;

/**
 * Created by lizhe on 2018/3/16.
 */

public interface IntegralGoodsContract {

    interface View extends BaseView{
        void showContent(List<IntergralShopBean.IstIntegerGoods> list);

        void loadMore(List<IntergralShopBean.IstIntegerGoods> list);
    }

    interface Presenter extends BasePresenter<View>{

        void getGoodsInfo(int type,String sValue,String userId,String goodsType);

    }
}
