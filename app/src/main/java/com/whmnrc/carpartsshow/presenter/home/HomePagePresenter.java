package com.whmnrc.carpartsshow.presenter.home;

import com.whmnrc.carpartsshow.base.BasePresenterImpl;
import com.whmnrc.carpartsshow.base.CommonSubscriber;
import com.whmnrc.carpartsshow.model.DataManager;
import com.whmnrc.carpartsshow.model.http.bean.CarModelByVINBean;
import com.whmnrc.carpartsshow.model.http.bean.HomePageBean;
import com.whmnrc.carpartsshow.model.http.response.CPSResponse;
import com.whmnrc.carpartsshow.presenter.home.contract.HomePageContract;
import com.whmnrc.carpartsshow.util.RxUtil;

import java.util.List;

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

    @Override
    public void searchVin(String vin) {
        addSubscribe(dataManager.fetchGetCarModelByVIN(vin)
                .compose(RxUtil.<CPSResponse<List<CarModelByVINBean>>>rxSchedulerHelper())
                .compose(RxUtil.<List<CarModelByVINBean>>handle())
                .subscribeWith(new CommonSubscriber<List<CarModelByVINBean>>(mView){
                    @Override
                    public void onNext(List<CarModelByVINBean> carModelByVINBean) {
                        super.onNext(carModelByVINBean);
                        mView.showVinData(carModelByVINBean);
                    }
                })
        );
    }

}
