package com.whmnrc.carpartsshow.presenter.home.contract;

import com.whmnrc.carpartsshow.base.BasePresenter;
import com.whmnrc.carpartsshow.base.BaseView;
import com.whmnrc.carpartsshow.model.http.bean.NewsListBean;

import java.util.List;

/**
 * Created by lizhe on 2018/3/28.
 * 新闻列表
 */

public interface NewsListContract {

    interface View extends BaseView{
        void loadFirst(List<NewsListBean> msgBeans);

        void loadMore(List<NewsListBean> msgBeans);
    }

    interface Presenter extends BasePresenter<View>{
        void getNewsList(String newsType,int type);
    }


}
