package com.carpartsshow.presenter.me;

import com.carpartsshow.base.BasePresenterImpl;
import com.carpartsshow.model.DataManager;
import com.carpartsshow.presenter.me.contract.XFRContract;

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
