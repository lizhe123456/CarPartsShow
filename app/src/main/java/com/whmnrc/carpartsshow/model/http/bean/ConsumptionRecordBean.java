package com.whmnrc.carpartsshow.model.http.bean;

import java.io.Serializable;

/**
 * Created by lizhe on 2018/3/29.
 */

public class ConsumptionRecordBean implements Serializable {

    /**
     * CreditRecord_ID : c2cee1fe-00ce-4776-980c-744d8f7db6dc
     * CreditRecord_CreateTime : 2018-02-23 18:37
     * CreditRecord_OverTime : 2018-03-01
     * CreditRecord_Money : 30
     * CreditRecord_State : 0
     * UserInfo_ID : ddeqwdq
     * CreditRecord_Type : -1
     * CreditRecord_FrozenInteger : 0
     * CreditRecord_Integer : 0
     * CreditRecord_EffectiveInteger : 0
     * CreditRecord_FinancialVoucherImgPath : null
     * Company_ID : 0465ad54-ef0a-401f-a4a8-1072fa544da2
     * Order_ID : d57e3e8e-9b45-441c-a47c-a7da07e5626c
     * Order_No : E3783712946677
     * CreditRecord_Remark : [天合 JBJ176]等2种商品
     */

    private String CreditRecord_ID;
    private String CreditRecord_CreateTime;
    private String CreditRecord_OverTime;
    private int CreditRecord_Money;
    private int CreditRecord_State;
    private String UserInfo_ID;
    private int CreditRecord_Type;
    private int CreditRecord_FrozenInteger;
    private int CreditRecord_Integer;
    private int CreditRecord_EffectiveInteger;
    private Object CreditRecord_FinancialVoucherImgPath;
    private String Company_ID;
    private String Order_ID;
    private String Order_No;
    private String CreditRecord_Remark;

    public String getCreditRecord_ID() {
        return CreditRecord_ID;
    }

    public void setCreditRecord_ID(String CreditRecord_ID) {
        this.CreditRecord_ID = CreditRecord_ID;
    }

    public String getCreditRecord_CreateTime() {
        return CreditRecord_CreateTime;
    }

    public void setCreditRecord_CreateTime(String CreditRecord_CreateTime) {
        this.CreditRecord_CreateTime = CreditRecord_CreateTime;
    }

    public String getCreditRecord_OverTime() {
        return CreditRecord_OverTime;
    }

    public void setCreditRecord_OverTime(String CreditRecord_OverTime) {
        this.CreditRecord_OverTime = CreditRecord_OverTime;
    }

    public int getCreditRecord_Money() {
        return CreditRecord_Money;
    }

    public void setCreditRecord_Money(int CreditRecord_Money) {
        this.CreditRecord_Money = CreditRecord_Money;
    }

    public int getCreditRecord_State() {
        return CreditRecord_State;
    }

    public void setCreditRecord_State(int CreditRecord_State) {
        this.CreditRecord_State = CreditRecord_State;
    }

    public String getUserInfo_ID() {
        return UserInfo_ID;
    }

    public void setUserInfo_ID(String UserInfo_ID) {
        this.UserInfo_ID = UserInfo_ID;
    }

    public int getCreditRecord_Type() {
        return CreditRecord_Type;
    }

    public void setCreditRecord_Type(int CreditRecord_Type) {
        this.CreditRecord_Type = CreditRecord_Type;
    }

    public int getCreditRecord_FrozenInteger() {
        return CreditRecord_FrozenInteger;
    }

    public void setCreditRecord_FrozenInteger(int CreditRecord_FrozenInteger) {
        this.CreditRecord_FrozenInteger = CreditRecord_FrozenInteger;
    }

    public int getCreditRecord_Integer() {
        return CreditRecord_Integer;
    }

    public void setCreditRecord_Integer(int CreditRecord_Integer) {
        this.CreditRecord_Integer = CreditRecord_Integer;
    }

    public int getCreditRecord_EffectiveInteger() {
        return CreditRecord_EffectiveInteger;
    }

    public void setCreditRecord_EffectiveInteger(int CreditRecord_EffectiveInteger) {
        this.CreditRecord_EffectiveInteger = CreditRecord_EffectiveInteger;
    }

    public Object getCreditRecord_FinancialVoucherImgPath() {
        return CreditRecord_FinancialVoucherImgPath;
    }

    public void setCreditRecord_FinancialVoucherImgPath(Object CreditRecord_FinancialVoucherImgPath) {
        this.CreditRecord_FinancialVoucherImgPath = CreditRecord_FinancialVoucherImgPath;
    }

    public String getCompany_ID() {
        return Company_ID;
    }

    public void setCompany_ID(String Company_ID) {
        this.Company_ID = Company_ID;
    }

    public String getOrder_ID() {
        return Order_ID;
    }

    public void setOrder_ID(String Order_ID) {
        this.Order_ID = Order_ID;
    }

    public String getOrder_No() {
        return Order_No;
    }

    public void setOrder_No(String Order_No) {
        this.Order_No = Order_No;
    }

    public String getCreditRecord_Remark() {
        return CreditRecord_Remark;
    }

    public void setCreditRecord_Remark(String CreditRecord_Remark) {
        this.CreditRecord_Remark = CreditRecord_Remark;
    }
}
