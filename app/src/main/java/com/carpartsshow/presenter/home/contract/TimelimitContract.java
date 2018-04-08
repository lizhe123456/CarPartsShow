package com.carpartsshow.presenter.home.contract;

import com.carpartsshow.base.BasePresenter;
import com.carpartsshow.base.BaseView;
import com.carpartsshow.model.http.bean.SeckillGoodsBean;

import java.util.List;

/**
 * Created by lizhe on 2018/4/8.
 */

public interface TimelimitContract {

    interface View extends BaseView{
        void loadData(List<SeckillGoodsBean> list);

        void loadMore(List<SeckillGoodsBean> list);
    }

    interface Presenter extends BasePresenter<View>{
        void getTimeData(String userId,int type);

    }

}
