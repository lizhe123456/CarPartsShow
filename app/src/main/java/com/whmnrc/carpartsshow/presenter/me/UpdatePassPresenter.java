package com.whmnrc.carpartsshow.presenter.me;

import com.whmnrc.carpartsshow.base.BasePresenterImpl;
import com.whmnrc.carpartsshow.base.CommonSubscriber;
import com.whmnrc.carpartsshow.model.DataManager;
import com.whmnrc.carpartsshow.model.http.response.CPSResponse;
import com.whmnrc.carpartsshow.presenter.me.contract.UpdatePassContract;
import com.whmnrc.carpartsshow.util.RxUtil;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

/**
 * Created by lizhe on 2018/3/15.
 */

public class UpdatePassPresenter extends BasePresenterImpl<UpdatePassContract.View> implements UpdatePassContract.Presenter {

    DataManager dataManager;
    @Inject
    public UpdatePassPresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public void updatePass(String RepairUser_ID, String OldPwd, String NewFPwd, String NewTPwd) {
        Map<String, Object> map = new HashMap<>();
        map.put("RepairUser_ID",RepairUser_ID);
        map.put("OldPwd",OldPwd);
        map.put("NewFPwd",NewFPwd);
        map.put("NewTPwd",NewTPwd);
        addSubscribe(dataManager.fetchUpdatePwd(map)
                .compose(RxUtil.<CPSResponse>rxSchedulerHelper())
                .compose(RxUtil.handleState())
                .subscribeWith(new CommonSubscriber<CPSResponse>(mView){
                    @Override
                    public void onNext(CPSResponse cpsResponse) {
                        super.onNext(cpsResponse);
                        mView.state();
                    }
                })
        );
    }
}
