package com.carpartsshow.ui.classify.adapter.brand;

import com.carpartsshow.model.http.bean.ClassificationBean;

import java.util.Comparator;

/**
 * Created by lizhe on 2018/3/27.
 */

public class BrandComparator implements Comparator<ClassificationBean.ListBrandBean> {

    public int compare(ClassificationBean.ListBrandBean o1, ClassificationBean.ListBrandBean o2) {
        //这里主要是用来对ListView里面的数据根据ABCDEFG...来排序
        if (o1.getCompany_FirstWord().equals("@")
                || o2.getCompany_FirstWord().equals("#")) {
            return -1;
        } else if (o1.getCompany_FirstWord().equals("#")
                || o2.getCompany_FirstWord().equals("@")) {
            return 1;
        } else {
            return o1.getCompany_FirstWord().compareTo(o2.getCompany_FirstWord());
        }
    }
}
