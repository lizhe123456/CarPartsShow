package com.whmnrc.carpartsshow.presenter.shopping.contract;

import com.whmnrc.carpartsshow.base.BasePresenter;
import com.whmnrc.carpartsshow.base.BaseView;

/**
 * Created by lizhe on 2018/3/29.
 */

public interface ToOderContract {

    interface View extends BaseView{

    }

    interface Presenter extends BasePresenter<View> {
        void toOder(String userId, String productAttrIds);
    }

}
