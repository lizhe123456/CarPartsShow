package com.carpartsshow.model.http.bean;

import java.io.Serializable;

/**
 * Created by lizhe on 2018/4/9.
 */

public class GoodsDetailToBean implements Serializable {

    private String url;
    private boolean isCollection;
    private int count;
    private int type;

    public GoodsDetailToBean(String url, boolean isCollection, int count) {
        this.url = url;
        this.isCollection = isCollection;
        this.count = count;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isCollection() {
        return isCollection;
    }

    public void setCollection(boolean collection) {
        isCollection = collection;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
