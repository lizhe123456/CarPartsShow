package com.whmnrc.carpartsshow.presenter.scancode;

import com.whmnrc.carpartsshow.base.BasePresenterImpl;
import com.whmnrc.carpartsshow.base.CommonSubscriber;
import com.whmnrc.carpartsshow.model.DataManager;
import com.whmnrc.carpartsshow.model.http.bean.CarModelByVINBean;
import com.whmnrc.carpartsshow.model.http.response.CPSResponse;
import com.whmnrc.carpartsshow.presenter.scancode.contract.ScanCodeContract;
import com.whmnrc.carpartsshow.util.RxUtil;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by lizhe on 2018/4/8.
 */

public class ScanCodePresenter extends BasePresenterImpl<ScanCodeContract.View> implements ScanCodeContract.Presenter {

    DataManager dataManager;
    @Inject
    public ScanCodePresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public void getVinCode(String vid) {
        addSubscribe(dataManager.fetchGetCarModelByVIN(vid)
                .compose(RxUtil.<CPSResponse<List<CarModelByVINBean>>>rxSchedulerHelper())
                .compose(RxUtil.<List<CarModelByVINBean>>handle())
                .subscribeWith(new CommonSubscriber<List<CarModelByVINBean>>(mView){
                    @Override
                    public void onNext(List<CarModelByVINBean> carModelByVINBean) {
                        super.onNext(carModelByVINBean);
                        mView.showData(carModelByVINBean);
                    }
                })
        );
    }
}
