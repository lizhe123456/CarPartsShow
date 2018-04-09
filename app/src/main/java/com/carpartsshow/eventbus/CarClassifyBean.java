package com.carpartsshow.eventbus;

import java.io.Serializable;

/**
 * Created by lizhe on 2018/3/30.
 */

public class CarClassifyBean  implements Serializable{

    String type;
    String name;
    int cid;
    String cType;

    public CarClassifyBean(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public CarClassifyBean(String type, String name, int cid) {
        this.type = type;
        this.name = name;
        this.cid = cid;
    }

    public CarClassifyBean(String type, String name, String cType) {
        this.type = type;
        this.name = name;
        this.cType = cType;
    }

    public String getcType() {
        return cType;
    }

    public void setcType(String cType) {
        this.cType = cType;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
