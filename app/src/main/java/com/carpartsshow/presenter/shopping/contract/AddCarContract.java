package com.carpartsshow.presenter.shopping.contract;

import com.carpartsshow.base.BasePresenter;
import com.carpartsshow.base.BaseView;

/**
 * Created by lizhe on 2018/3/29.
 */

public interface AddCarContract  {

    interface View extends BaseView{
        void state(String msg);
    }

    interface Presenter extends BasePresenter<View>{
        //加一
        void plus(String userId,String productId,int productType);
    }

}
