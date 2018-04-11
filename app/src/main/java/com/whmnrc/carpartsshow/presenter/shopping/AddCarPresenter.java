package com.whmnrc.carpartsshow.presenter.shopping;

import com.whmnrc.carpartsshow.base.BasePresenterImpl;
import com.whmnrc.carpartsshow.base.CommonSubscriber;
import com.whmnrc.carpartsshow.model.DataManager;
import com.whmnrc.carpartsshow.model.http.response.CPSResponse;
import com.whmnrc.carpartsshow.presenter.shopping.contract.AddCarContract;
import com.whmnrc.carpartsshow.util.RxUtil;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

/**
 * Created by lizhe on 2018/3/29.
 */

public class AddCarPresenter extends BasePresenterImpl<AddCarContract.View> implements AddCarContract.Presenter {

    DataManager dataManager;
    @Inject
    public AddCarPresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public void plus(String userId, String productId, int productType) {
        Map<String,Object> map = new HashMap<>();
        map.put("Product_ID",productId);
        map.put("Product_Type",productType);
        map.put("RepairUser_ID",userId);
        addSubscribe(dataManager.fetchAddCar(map)
                .compose(RxUtil.<CPSResponse>rxSchedulerHelper())
                .compose(RxUtil.handleState())
                .subscribeWith(new CommonSubscriber<CPSResponse>(mView){
                    @Override
                    public void onNext(CPSResponse cpsResponse) {
                        super.onNext(cpsResponse);
                        mView.state(cpsResponse.getMessage());
                    }
                })
        );
    }
}
