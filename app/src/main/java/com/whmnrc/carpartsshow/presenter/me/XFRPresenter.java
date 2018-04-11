package com.whmnrc.carpartsshow.presenter.me;

import com.whmnrc.carpartsshow.base.BasePresenterImpl;
import com.whmnrc.carpartsshow.model.DataManager;
import com.whmnrc.carpartsshow.presenter.me.contract.XFRContract;

import javax.inject.Inject;

/**
 * Created by lizhe on 2018/3/15.
 */

public class XFRPresenter extends BasePresenterImpl<XFRContract.View> implements XFRContract.Presenter{

    DataManager dataManager;
    @Inject
    public XFRPresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public void getXfData(int userId) {

    }
}
