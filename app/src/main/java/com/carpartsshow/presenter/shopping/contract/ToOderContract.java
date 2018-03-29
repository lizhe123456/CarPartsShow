package com.carpartsshow.presenter.shopping.contract;

import com.carpartsshow.base.BasePresenter;
import com.carpartsshow.base.BaseView;

/**
 * Created by lizhe on 2018/3/29.
 */

public interface ToOderContract {

    interface View extends BaseView{

    }

    interface Presenter extends BasePresenter<View>{
        void toOder(String userId, String productAttrIds);
    }

}
