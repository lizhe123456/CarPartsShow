package com.carpartsshow.presenter.home;

import com.carpartsshow.base.BasePresenterImpl;
import com.carpartsshow.base.CommonSubscriber;
import com.carpartsshow.model.DataManager;
import com.carpartsshow.model.http.bean.HomePageBean;
import com.carpartsshow.model.http.response.CPSResponse;
import com.carpartsshow.presenter.home.contract.HomePageContract;
import com.carpartsshow.util.RxUtil;

import javax.inject.Inject;

/**
 * Created by lizhe on 2018/3/20.
 */

public class HomePagePresenter extends BasePresenterImpl<HomePageContract.View> implements HomePageContract.Presenter {

    DataManager dataManager;
    int page = 1;
    int size = 20;

    @Inject
    public HomePagePresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public void getHomePage(String userId, final int type) {
        if (type == 1){
            page = 1;
        }
        addSubscribe(dataManager.getHomePageData(userId,size,page)
                .compose(RxUtil.<CPSResponse<HomePageBean>>rxSchedulerHelper())
                .compose(RxUtil.<HomePageBean>handle())
                .subscribeWith(new CommonSubscriber<HomePageBean>(mView){
                    @Override
                    public void onNext(HomePageBean homePageBean) {
                        super.onNext(homePageBean);
                        if (type == 1){
                            mView.showContent(homePageBean);
                        }else {
                            mView.loadMore(homePageBean);
                        }
                        page++;
                    }
                })
        );
    }
}
