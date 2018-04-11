package com.whmnrc.carpartsshow.presenter.home;

import com.whmnrc.carpartsshow.base.BasePresenterImpl;
import com.whmnrc.carpartsshow.base.CommonSubscriber;
import com.whmnrc.carpartsshow.model.DataManager;
import com.whmnrc.carpartsshow.model.http.bean.NewTypeBean;
import com.whmnrc.carpartsshow.model.http.response.CPSResponse;
import com.whmnrc.carpartsshow.presenter.home.contract.NewsTypeContract;
import com.whmnrc.carpartsshow.util.RxUtil;

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
