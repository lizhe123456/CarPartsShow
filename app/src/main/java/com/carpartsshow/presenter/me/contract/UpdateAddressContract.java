package com.carpartsshow.presenter.me.contract;

import com.carpartsshow.base.BasePresenter;
import com.carpartsshow.base.BaseView;
import com.carpartsshow.model.http.bean.AddressBean;

import java.util.List;

/**
 * Created by lizhe on 2018/3/15.
 */

public interface UpdateAddressContract {

    interface View extends BaseView{
        void state(String msg);

        void showAddress(List<AddressBean.ResultdataBean> addressBean);

        void setP(List<AddressBean.ResultdataBean> addressBean);

        void setC(List<AddressBean.ResultdataBean> addressBean);

        void setA(List<AddressBean.ResultdataBean> addressBean);
    }

    interface Presenter extends BasePresenter<View>{
        void updateAddress(String userId, String provice, String city, String region, String detailAddress);

        void getAreaList(String parentId,int type);

        void getAreaList();
    }
}
