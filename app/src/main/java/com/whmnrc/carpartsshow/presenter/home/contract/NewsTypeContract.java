package com.whmnrc.carpartsshow.presenter.home.contract;

import com.whmnrc.carpartsshow.base.BasePresenter;
import com.whmnrc.carpartsshow.base.BaseView;
import com.whmnrc.carpartsshow.model.http.bean.NewTypeBean;

import java.util.List;

/**
 * Created by lizhe on 2018/3/19.
 */

public interface NewsTypeContract {

    interface View extends BaseView{
        void showNewsType(List<NewTypeBean> newTypeBeans);

    }

    interface Presenter extends BasePresenter<View>{
        void getNewsType();
    }

}
