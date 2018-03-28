package com.carpartsshow.presenter.home;

import com.carpartsshow.base.BasePresenterImpl;
import com.carpartsshow.base.CommonSubscriber;
import com.carpartsshow.model.DataManager;
import com.carpartsshow.model.http.bean.NewsListBean;
import com.carpartsshow.model.http.response.CPSResponse;
import com.carpartsshow.presenter.home.contract.NewsListContract;
import com.carpartsshow.util.RxUtil;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by lizhe on 2018/3/28.
 */

public class NewsListPresenter extends BasePresenterImpl<NewsListContract.View> implements NewsListContract.Presenter {

    int page = 1;
    int size = 10;
    DataManager dataManager;
    @Inject
    public NewsListPresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public void getNewsList(String newsType, final int type) {
        if (type == 1){
            page = 1;
        }
        addSubscribe(dataManager.fetchSplitListNotice(newsType,page,size)
                .compose(RxUtil.<CPSResponse<List<NewsListBean>>>rxSchedulerHelper())
                .compose(RxUtil.<List<NewsListBean>>handle())
                .subscribeWith(new CommonSubscriber<List<NewsListBean>>(mView){
                    @Override
                    public void onNext(List<NewsListBean> newsListBeans) {
                        super.onNext(newsListBeans);
                        if (type == 1){
                            mView.loadFirst(newsListBeans);
                        }else {
                            mView.loadMore(newsListBeans);
                        }
                    }
                })
        );
    }
}
