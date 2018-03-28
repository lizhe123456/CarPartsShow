package com.carpartsshow.presenter.home;

import com.carpartsshow.base.BasePresenterImpl;
import com.carpartsshow.base.CommonSubscriber;
import com.carpartsshow.model.DataManager;
import com.carpartsshow.model.http.bean.NewTypeBean;
import com.carpartsshow.model.http.response.CPSResponse;
import com.carpartsshow.presenter.home.contract.NewsTypeContract;
import com.carpartsshow.util.RxUtil;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by lizhe on 2018/3/19.
 * 新闻类型
 */

public class NewsTypePresenter extends BasePresenterImpl<NewsTypeContract.View> implements NewsTypeContract.Presenter{

    DataManager dataManager;

    @Inject
    public NewsTypePresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public void getNewsType() {
        mView.loading("加载中...");
        addSubscribe(dataManager.fetchListNoticeType()
                .compose(RxUtil.<CPSResponse<List<NewTypeBean>>>rxSchedulerHelper())
                .compose(RxUtil.<List<NewTypeBean>>handle())
                .subscribeWith(new CommonSubscriber<List<NewTypeBean>>(mView){
                    @Override
                    public void onNext(List<NewTypeBean> newTypeBeans) {
                        super.onNext(newTypeBeans);
                        mView.showNewsType(newTypeBeans);
                    }
                })
        );
    }
}
