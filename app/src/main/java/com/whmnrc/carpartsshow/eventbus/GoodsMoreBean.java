package com.whmnrc.carpartsshow.eventbus;

import java.io.Serializable;

/**
 * Created by lizhe on 2018/3/29.
 */

public class GoodsMoreBean implements Serializable{

    Integer integer;

    public GoodsMoreBean(int integer) {
        this.integer = integer;
    }

    public Integer getInteger() {
        return integer;
    }

    public void setInteger(Integer integer) {
        this.integer = integer;
    }
}
