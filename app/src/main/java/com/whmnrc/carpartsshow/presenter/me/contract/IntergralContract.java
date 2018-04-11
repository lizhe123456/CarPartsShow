package com.whmnrc.carpartsshow.presenter.me.contract;

import com.whmnrc.carpartsshow.base.BasePresenter;
import com.whmnrc.carpartsshow.base.BaseView;
import com.whmnrc.carpartsshow.model.http.bean.IntergralBean;

import java.util.List;

/**
 * Created by lizhe on 2018/3/15.
 */

public interface IntergralContract {

    interface View extends BaseView{
        void showContent(List<IntergralBean> intergralBean);

        void loadMore(List<IntergralBean> intergralBean);
    }

    interface Presenter extends BasePresenter<View> {
        void getIntergralList(String userId,int type);

    }
}
