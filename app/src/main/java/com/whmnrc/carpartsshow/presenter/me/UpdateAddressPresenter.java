package com.whmnrc.carpartsshow.presenter.me;

import com.whmnrc.carpartsshow.base.BasePresenterImpl;
import com.whmnrc.carpartsshow.base.CommonSubscriber;
import com.whmnrc.carpartsshow.model.DataManager;
import com.whmnrc.carpartsshow.model.http.bean.AddressBean;
import com.whmnrc.carpartsshow.model.http.response.CPSResponse;
import com.whmnrc.carpartsshow.presenter.me.contract.UpdateAddressContract;
import com.whmnrc.carpartsshow.util.RxUtil;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;

/**
 * Created by lizhe on 2018/3/15.
 */

public class UpdateAddressPresenter extends BasePresenterImpl<UpdateAddressContract.View> implements UpdateAddressContract.Presenter {

    DataManager dataManager;
    @Inject
    public UpdateAddressPresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public void updateAddress(String userId, String provice, String city, String region, String detailAddress) {
        mView.loading("保存中..");
        Map<String,Object> map = new HashMap<>();
        map.put("RepairUser_ID",userId);
        map.put("RepairUser_Provice",provice);
        map.put("RepairUser_City",city);
        map.put("RepairUser_Region",region);
        map.put("RepairUser_DetailAddress",detailAddress);
        addSubscribe(dataManager.fetchUpdateShippingAddress(map)
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

    @Override
    public void getAreaList(@Nullable final String parentId, final int type) {
        addSubscribe(dataManager.fetchAddressInfo(parentId)
                .compose(RxUtil.<CPSResponse<AddressBean>>rxSchedulerHelper())
                .compose(RxUtil.<AddressBean>handle())
                .subscribeWith(new CommonSubscriber<AddressBean>(mView){
                    @Override
                    public void onNext(AddressBean addressBean) {
                        super.onNext(addressBean);
//                        mView.showAddress(addressBean);
                        if (type == 0){
                            mView.setP(addressBean.getResultdata());
                        }else if (type == 1){
                            for (int i = 0; i < addressBean.getResultdata().size(); i++) {
                                if (parentId.equals(addressBean.getResultdata().get(i).getAreaCode())){
                                    addressBean.getResultdata().get(i).setSelect(true);
                                    break;
                                }
                            }
                            mView.setC(addressBean.getResultdata());
                        }else if (type == 2){
                            for (int i = 0; i < addressBean.getResultdata().size(); i++) {
                                if (parentId.equals(addressBean.getResultdata().get(i).getAreaCode())){
                                    addressBean.getResultdata().get(i).setSelect(true);
                                    break;
                                }
                            }
                            mView.setA(addressBean.getResultdata());
                        }
                    }
                })
        );
    }

    @Override
    public void getAreaList() {
        mView.loading("加载中..");
        addSubscribe(dataManager.fetchAddressInfo()
                        .compose(RxUtil.<CPSResponse<AddressBean>>rxSchedulerHelper())
                        .compose(RxUtil.<AddressBean>handle())
                        .subscribeWith(new CommonSubscriber<AddressBean>(mView) {
                            @Override
                            public void onNext(AddressBean addressBean) {
                                super.onNext(addressBean);
                                mView.setP(addressBean.getResultdata());
                            }
                        })
        );
    }
}
