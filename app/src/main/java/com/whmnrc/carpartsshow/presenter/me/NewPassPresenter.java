package com.whmnrc.carpartsshow.presenter.me;

import com.whmnrc.carpartsshow.base.BasePresenterImpl;
import com.whmnrc.carpartsshow.base.CommonSubscriber;
import com.whmnrc.carpartsshow.model.DataManager;
import com.whmnrc.carpartsshow.model.http.response.CPSResponse;
import com.whmnrc.carpartsshow.presenter.me.contract.NewPassContract;
import com.whmnrc.carpartsshow.util.RxUtil;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

/**
 * Created by lizhe on 2018/3/14.
 */

public class NewPassPresenter extends BasePresenterImpl<NewPassContract.View> implements NewPassContract.Presenter {

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
