package com.whmnrc.carpartsshow.model.http.bean;

/**
 * Created by lizhe on 2018/3/28.
 */

public class MsgBean {

    /**
     * UserMsg_ID : fff0122e-3302-4c2f-845b-c07e4fea9cb0
     * UserMsg_Content : 【系统】 使用信用额度30.00积分0支付了编号为E3783712946677的订单
     * UserMsg_CreateTime : 2018-02-23 18:37
     * UserInfo_ID : ddeqwdq
     */

    private String UserMsg_ID;
    private String UserMsg_Content;
    private String UserMsg_CreateTime;
    private String UserInfo_ID;

    public String getUserMsg_ID() {
        return UserMsg_ID;
    }

    public void setUserMsg_ID(String UserMsg_ID) {
        this.UserMsg_ID = UserMsg_ID;
    }

    public String getUserMsg_Content() {
        return UserMsg_Content;
    }

    public void setUserMsg_Content(String UserMsg_Content) {
        this.UserMsg_Content = UserMsg_Content;
    }

    public String getUserMsg_CreateTime() {
        return UserMsg_CreateTime;
    }

    public void setUserMsg_CreateTime(String UserMsg_CreateTime) {
        this.UserMsg_CreateTime = UserMsg_CreateTime;
    }

    public String getUserInfo_ID() {
        return UserInfo_ID;
    }

    public void setUserInfo_ID(String UserInfo_ID) {
        this.UserInfo_ID = UserInfo_ID;
    }
}
