package com.carpartsshow.base;

/**
 * Created by lizhe on 2018/3/12.
 */

public interface BasePresenter<T extends BaseView> {

    void attachView(T view);

    void datachView();

}
