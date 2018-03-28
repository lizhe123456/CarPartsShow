package com.carpartsshow.presenter.home.contract;

import com.carpartsshow.base.BasePresenter;
import com.carpartsshow.base.BaseView;
import com.carpartsshow.model.http.bean.NewTypeBean;

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
