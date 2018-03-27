package com.carpartsshow.presenter.home;

import android.text.TextUtils;

import com.carpartsshow.base.BasePresenterImpl;
import com.carpartsshow.base.CommonSubscriber;
import com.carpartsshow.model.DataManager;
import com.carpartsshow.model.http.bean.ClassificationBean;
import com.carpartsshow.model.http.bean.ClassificationItemBean;
import com.carpartsshow.model.http.response.CPSResponse;
import com.carpartsshow.presenter.home.contract.GoodsSearchContract;
import com.carpartsshow.util.RxUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;

/**
 * Created by lizhe on 2018/3/26.
 * 商品搜索
 */

public class GoodsSearchPresenter extends BasePresenterImpl<GoodsSearchContract.View> implements GoodsSearchContract.Presenter{

    DataManager dataManager;

    @Inject
    public GoodsSearchPresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    //分类
    @Override
    public void getClassification(String userId) {
        addSubscribe(dataManager.classification(userId)
                .compose(RxUtil.<CPSResponse<ClassificationBean>>rxSchedulerHelper())
                .compose(RxUtil.<ClassificationBean>handle())
                .subscribeWith(new CommonSubscriber<ClassificationBean>(mView){
                    @Override
                    public void onNext(ClassificationBean classificationBean) {
                        super.onNext(classificationBean);
                        mView.showBrand(classificationBean.getListBrand());
                        mView.showClassification(handleClassificationBean(classificationBean.getListCategory()));
                        List<ClassificationBean.ListCarBrandBean> listCarBrandBeans = classificationBean.getListCarBrand();
                        getCarBrandBean(listCarBrandBeans,classificationBean.getVCJList());
                        mView.showCarBrand(listCarBrandBeans);
                    }
                })

        );
    }

    //商品搜索
    @Override
    public void getGoodsSearch(Map<String, String> map) {
        addSubscribe(dataManager.fetchListSplitGoods(map)
                .compose(RxUtil.<CPSResponse>rxSchedulerHelper())
                .compose(RxUtil.handleState())
                .subscribeWith(new CommonSubscriber<CPSResponse>(mView){
                    @Override
                    public void onNext(CPSResponse cpsResponse) {
                        super.onNext(cpsResponse);
                    }
                })

        );
    }

    /**
     * 处理品牌数据
     * @param listCategoryBeans
     * @return
     */
    private List<ClassificationItemBean> handleClassificationBean(@Nullable List<ClassificationBean.ListCategoryBean> listCategoryBeans){
        List<ClassificationItemBean> list = new ArrayList<>();
        for (ClassificationBean.ListCategoryBean listCategoryBean : listCategoryBeans) {
            if (listCategoryBean.getStep() == 1){
                ClassificationItemBean classificationBean = new ClassificationItemBean();
                classificationBean.setCategory_ChooseOff(listCategoryBean.getCategory_ChooseOff());
                classificationBean.setCategory_ChooseOn(listCategoryBean.getCategory_ChooseOn());
                classificationBean.setCategory_Code(listCategoryBean.getCategory_Code());
                classificationBean.setCategory_FirstCode(listCategoryBean.getCategory_FirstCode());
                classificationBean.setCategory_FirstImgPath(listCategoryBean.getCategory_FirstImgPath());
                classificationBean.setCategory_ID(listCategoryBean.getCategory_ID());
                classificationBean.setCategory_ImgPath(listCategoryBean.getCategory_ImgPath());
                classificationBean.setCode(listCategoryBean.getCode());
                classificationBean.setCompany_ID(listCategoryBean.getCompany_ID());
                classificationBean.setGCode(listCategoryBean.getGCode());
                classificationBean.setID(listCategoryBean.getID());
                List<ClassificationItemBean.ClassificationItem2Bean> list1 = new ArrayList<>();
                for (ClassificationBean.ListCategoryBean listCategoryBean1 : listCategoryBeans) {
                    if (classificationBean.getID() == listCategoryBean1.getParentID()){
                        ClassificationItemBean.ClassificationItem2Bean classificationBean1 = new ClassificationItemBean.ClassificationItem2Bean();
                        classificationBean1.setCategory_ChooseOff(listCategoryBean.getCategory_ChooseOff());
                        classificationBean1.setCategory_ChooseOn(listCategoryBean.getCategory_ChooseOn());
                        classificationBean1.setCategory_Code(listCategoryBean.getCategory_Code());
                        classificationBean1.setCategory_FirstCode(listCategoryBean.getCategory_FirstCode());
                        classificationBean1.setCategory_FirstImgPath(listCategoryBean.getCategory_FirstImgPath());
                        classificationBean1.setCategory_ID(listCategoryBean.getCategory_ID());
                        classificationBean1.setCategory_ImgPath(listCategoryBean.getCategory_ImgPath());
                        classificationBean1.setCode(listCategoryBean.getCode());
                        classificationBean1.setCompany_ID(listCategoryBean.getCompany_ID());
                        classificationBean1.setGCode(listCategoryBean.getGCode());
                        classificationBean1.setID(listCategoryBean.getID());
                        list1.add(classificationBean1);
                    }
                }
                list.add(classificationBean);
            }
        }
        return list;
    }

    /**
     * 处理车型数据
     * @param carBrandBeans
     * @param carBean
     */
    public void getCarBrandBean(List<ClassificationBean.ListCarBrandBean> carBrandBeans, List<ClassificationBean.VCJListBean> carBean){
        for (ClassificationBean.ListCarBrandBean listCarBrandBean : carBrandBeans) {
            List<ClassificationBean.VCJListBean> listBeans = new ArrayList<>();
            for (ClassificationBean.VCJListBean vcj: carBean) {
                if (TextUtils.isEmpty(listCarBrandBean.getCarBrand_Name())){
                    continue;
                }
                if (TextUtils.isEmpty(vcj.getPP())){
                    continue;
                }
                if (listCarBrandBean.getCarBrand_Name().equals(vcj.getPP())){
                    listBeans.add(vcj);
                }
            }
            listCarBrandBean.setListBeans(listBeans);
        }
    }
}