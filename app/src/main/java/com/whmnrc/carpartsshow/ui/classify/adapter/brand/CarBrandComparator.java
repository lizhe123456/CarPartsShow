package com.whmnrc.carpartsshow.ui.classify.adapter.brand;

import com.whmnrc.carpartsshow.model.http.bean.ClassificationBean;

import java.util.Comparator;

/**
 * Created by lizhe on 2018/3/27.
 */

public class CarBrandComparator implements Comparator<ClassificationBean.ListCarBrandBean> {

    public int compare(ClassificationBean.ListCarBrandBean o1, ClassificationBean.ListCarBrandBean o2) {
        //这里主要是用来对ListView里面的数据根据ABCDEFG...来排序
        if (o1.getCarBrand_FirstCode().equals("@")
                || o2.getCarBrand_FirstCode().equals("#")) {
            return -1;
        } else if (o1.getCarBrand_FirstCode().equals("#")
                || o2.getCarBrand_FirstCode().equals("@")) {
            return 1;
        } else {
            return o1.getCarBrand_FirstCode().compareTo(o2.getCarBrand_FirstCode());
        }
    }
}
