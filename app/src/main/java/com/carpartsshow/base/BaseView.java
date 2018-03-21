package com.carpartsshow.base;

/**
 * Created by lizhe on 2018/3/12.
 */

public interface BaseView {

    void showErrorMsg(String msg);


    void stateError();

    void loading(String msg);

    void unLoading();

}
