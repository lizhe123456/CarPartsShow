package com.carpartsshow.eventbus;

/**
 * Created by lizhe on 2018/4/8.
 */

public class HomePageBean {

    private int page ;

    public HomePageBean(int page) {
        this.page = page;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
