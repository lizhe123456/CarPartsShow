package com.whmnrc.carpartsshow.presenter.me.contract;

import com.whmnrc.carpartsshow.base.BasePresenter;
import com.whmnrc.carpartsshow.base.BaseView;

/**
 * Created by lizhe on 2018/3/15.
 */

public interface XFRContract {

    interface View extends BaseView{
        void showContent();
    }

    interface Presenter extends BasePresenter<View>{
        void getXfData(int userId);
    }

}
