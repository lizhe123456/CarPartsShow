package com.whmnrc.carpartsshow.model.http.bean;

import java.io.Serializable;

/**
 * Created by lizhe on 2018/3/15.
 */

public class CouponBean implements Serializable {


    /**
     * Coupon_ID : fqweqw1
     * Coupon_Money : 10
     * Coupon_OverTime : 2018-10-15 00:00
     * Coupon_CreateTime : 2018-10-15 00:00
     * UserInfo_ID : ddeqwdq
     * Coupon_FullMoneyUse : 200
     * Coupon_IsUse : 0
     * Coupon_Type : 1
     */

    private String Coupon_ID;
    private int Coupon_Money;
    private String Coupon_OverTime;
    private String Coupon_CreateTime;
    private String UserInfo_ID;
    private int Coupon_FullMoneyUse;
    private int Coupon_IsUse;
    private int Coupon_Type;

    public String getCoupon_ID() {
        return Coupon_ID;
    }

    public void setCoupon_ID(String Coupon_ID) {
        this.Coupon_ID = Coupon_ID;
    }

    public int getCoupon_Money() {
        return Coupon_Money;
    }

    public void setCoupon_Money(int Coupon_Money) {
        this.Coupon_Money = Coupon_Money;
    }

    public String getCoupon_OverTime() {
        return Coupon_OverTime;
    }

    public void setCoupon_OverTime(String Coupon_OverTime) {
        this.Coupon_OverTime = Coupon_OverTime;
    }

    public String getCoupon_CreateTime() {
        return Coupon_CreateTime;
    }

    public void setCoupon_CreateTime(String Coupon_CreateTime) {
        this.Coupon_CreateTime = Coupon_CreateTime;
    }

    public String getUserInfo_ID() {
        return UserInfo_ID;
    }

    public void setUserInfo_ID(String UserInfo_ID) {
        this.UserInfo_ID = UserInfo_ID;
    }

    public int getCoupon_FullMoneyUse() {
        return Coupon_FullMoneyUse;
    }

    public void setCoupon_FullMoneyUse(int Coupon_FullMoneyUse) {
        this.Coupon_FullMoneyUse = Coupon_FullMoneyUse;
    }

    public int getCoupon_IsUse() {
        return Coupon_IsUse;
    }

    public void setCoupon_IsUse(int Coupon_IsUse) {
        this.Coupon_IsUse = Coupon_IsUse;
    }

    public int getCoupon_Type() {
        return Coupon_Type;
    }

    public void setCoupon_Type(int Coupon_Type) {
        this.Coupon_Type = Coupon_Type;
    }
}
