package com.carpartsshow.presenter.me;

import com.carpartsshow.base.BasePresenterImpl;
import com.carpartsshow.base.CommonSubscriber;
import com.carpartsshow.model.DataManager;
import com.carpartsshow.model.http.response.CPSResponse;
import com.carpartsshow.presenter.me.contract.NewPassContract;
import com.carpartsshow.util.RxUtil;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

/**
 * Created by lizhe on 2018/3/14.
 */

public class NewPassPresenter extends BasePresenterImpl<NewPassContract.View> implements NewPassContract.Presenter{

    DataManager dataManager;
    @Inject
    public NewPassPresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public void submitFindPwd(String mobile, String code, String newPass) {
        Map<String, Object> map = new HashMap<>();
        map.put("",mobile);
        map.put("",code);
        map.put("",newPass);
        addSubscribe(dataManager.fetchSubmitFindPwd(map)
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
