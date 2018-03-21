package com.carpartsshow.presenter.me.contract;

import com.carpartsshow.base.BasePresenter;
import com.carpartsshow.base.BaseView;
import com.carpartsshow.model.http.bean.IntergralBean;

/**
 * Created by lizhe on 2018/3/15.
 */

public interface IntergralContract {

    interface View extends BaseView{
        void showContent(IntergralBean intergralBean);

        void loadMore(IntergralBean intergralBean);
    }

    interface Presenter extends BasePresenter<View>{
        void getIntergralList(String userId,int type);

    }
}
