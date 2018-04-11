package com.whmnrc.carpartsshow.presenter.classify;

import com.whmnrc.carpartsshow.base.BasePresenterImpl;
import com.whmnrc.carpartsshow.base.CommonSubscriber;
import com.whmnrc.carpartsshow.model.DataManager;
import com.whmnrc.carpartsshow.model.http.bean.CarFilterBean;
import com.whmnrc.carpartsshow.model.http.response.CPSResponse;
import com.whmnrc.carpartsshow.presenter.classify.contract.CarFilterContract;
import com.whmnrc.carpartsshow.util.RxUtil;

import javax.inject.Inject;

/**
 * Created by lizhe on 2018/3/30.
 */

public class CarFilterPresenter extends BasePresenterImpl<CarFilterContract.View> implements CarFilterContract.Presenter{

    DataManager dataManager;
    @Inject
    public CarFilterPresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public void carFilter(String val) {
        mView.loading("加载中..");
        addSubscribe(dataManager.carFilter(val)
                .compose(RxUtil.<CPSResponse<CarFilterBean>>rxSchedulerHelper())
                .compose(RxUtil.<CarFilterBean>handle())
                .subscribeWith(new CommonSubscriber<CarFilterBean>(mView){
                    @Override
                    public void onNext(CarFilterBean carFilterBean) {
                        super.onNext(carFilterBean);
                        mView.loadData(carFilterBean);
                    }
                })
        );
    }
}
