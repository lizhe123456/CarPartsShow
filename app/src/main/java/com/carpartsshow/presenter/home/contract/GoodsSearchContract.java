package com.carpartsshow.presenter.home.contract;

import com.carpartsshow.base.BasePresenter;
import com.carpartsshow.base.BaseView;
import com.carpartsshow.model.http.bean.ClassificationBean;
import com.carpartsshow.model.http.bean.ClassificationItemBean;
import com.carpartsshow.model.http.bean.GoodsListBean;

import java.util.List;
import java.util.Map;

/**
 * Created by lizhe on 2018/3/26.
 */

public interface GoodsSearchContract {

    interface View extends BaseView{
        void showClassification(List<ClassificationItemBean> listCategoryBeans);

        void showBrand(List<ClassificationBean.ListBrandBean> listBrandBeans);

        void showCarBrand(List<ClassificationBean.ListCarBrandBean> listCarBrandBeans);

        void showGoodsList(GoodsListBean goodsListBean);
    }

    interface Presenter extends BasePresenter<View>{
        void getClassification(String userId);

        void getGoodsSearch(Map<String ,Object> map);
    }

}
