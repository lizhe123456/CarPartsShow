package com.whmnrc.carpartsshow.presenter.home.contract;

import com.whmnrc.carpartsshow.base.BasePresenter;
import com.whmnrc.carpartsshow.base.BaseView;
import com.whmnrc.carpartsshow.model.http.bean.CarModelByVINBean;
import com.whmnrc.carpartsshow.model.http.bean.ClassificationBean;
import com.whmnrc.carpartsshow.model.http.bean.ClassificationItemBean;
import com.whmnrc.carpartsshow.model.http.bean.GoodsListBean;

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

        void showGoodsList(GoodsListBean goodsListBean,int type);

        void showVinData(List<CarModelByVINBean> carModelByVINBean);

        void updateBrand(List<ClassificationBean.ListBrandBean> listBrandBeans);
    }

    interface Presenter extends BasePresenter<View> {
        void getClassification(String userId);

        void getClassification(String userId,int type);

        void getGoodsSearch(Map<String ,Object> map,int type);

        void searchVin(String vin);

        void getListBrand(String userId,int step,String categoryName);
    }

}
