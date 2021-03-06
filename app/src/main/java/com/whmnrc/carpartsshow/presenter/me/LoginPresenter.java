package com.whmnrc.carpartsshow.presenter.me;


import com.whmnrc.carpartsshow.base.BasePresenterImpl;
import com.whmnrc.carpartsshow.base.CommonSubscriber;
import com.whmnrc.carpartsshow.model.DataManager;
import com.whmnrc.carpartsshow.model.http.bean.LoginBean;
import com.whmnrc.carpartsshow.model.http.response.CPSResponse;
import com.whmnrc.carpartsshow.presenter.me.contract.LoginContract;
import com.whmnrc.carpartsshow.util.RxUtil;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

/**
 * Created by lizhe on 2018/3/14.
 */

public class LoginPresenter extends BasePresenterImpl<LoginContract.View> implements LoginContract.Presenter {

    private DataManager dataManager;
    @Inject
    public LoginPresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public void passLogin(String mobile, String pass) {
        mView.loading("登录中...");
        Map<String, Object> map = new HashMap<>();
        map.put("RepairUser_Mobile",mobile);
        map.put("RepairUser_Pwd",pass);
        addSubscribe(dataManager.fetchSubmitLogin(map)
                .compose(RxUtil.<CPSResponse<LoginBean>>rxSchedulerHelper())
                .compose(RxUtil.<LoginBean>handle())
                .subscribeWith(new CommonSubscriber<LoginBean>(mView){
                    @Override
                    public void onNext(LoginBean loginBean) {
                        super.onNext(loginBean);
                        mView.loginState(loginBean);
                    }
                })
        );
    }
}
