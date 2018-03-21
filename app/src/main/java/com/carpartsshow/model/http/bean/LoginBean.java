package com.carpartsshow.model.http.bean;

import java.io.Serializable;

/**
 * Created by lizhe on 2018/3/14.
 */

public class LoginBean implements Serializable {
    /**
     * RepairUser_ID : ddeqwdq
     * RepairUser_Name : 小李修理厂
     * RepairUser_State : 0
     * RepairUser_Sex : 0
     * RepairUser_RealName : 小李
     * RepairUser_Mobile : 15971486093
     * RepairUser_Pwd : E10ADC3949BA59ABBE56E057F20F883E
     * RepairUser_CreateTime : 2017-05-03T00:00:00
     * RepairUser_IsMaster : false
     * RepairUser_ParentID : null
     * RepairUser_SCode : 123123
     * RepairUser_Provice : 420000
     * RepairUser_City : 420100
     * RepairUser_Region : 420106
     * RepairUser_DetailAddress : 丁字桥向阳佳苑B区509
     * RepairUser_CostMoney : 0
     * RepairUser_ImgOne : 1
     * RepairUser_ImgTwo : 2
     * RepairUser_ImgLicense : 3
     * RepairUser_ImgHandheldIdentityCard : 4
     * RepairUser_Integer : 241911
     * RepairUser_CreditMoney : 50000
     * Company_ID : 0465ad54-ef0a-401f-a4a8-1072fa544da2
     * RepairUser_CreditBeOverMoney : 0
     * RepairUser_CreditType : 0
     * RepairUser_CreditMonth : 1
     * RepairUser_CreditDay : 20
     */

    private String RepairUser_ID;
    private String RepairUser_Name;
    private int RepairUser_State;
    private int RepairUser_Sex;
    private String RepairUser_RealName;
    private String RepairUser_Mobile;
    private String RepairUser_Pwd;
    private String RepairUser_CreateTime;
    private boolean RepairUser_IsMaster;
    private Object RepairUser_ParentID;
    private String RepairUser_Provice;
    private String RepairUser_City;
    private String RepairUser_Region;
    private String RepairUser_DetailAddress;
    private String RepairUser_CreditMoney;

    public String getRepairUser_CreditMoney() {
        return RepairUser_CreditMoney;
    }

    public void setRepairUser_CreditMoney(String repairUser_CreditMoney) {
        RepairUser_CreditMoney = repairUser_CreditMoney;
    }

    public String getRepairUser_Provice() {
        return RepairUser_Provice;
    }

    public void setRepairUser_Provice(String repairUser_Provice) {
        RepairUser_Provice = repairUser_Provice;
    }

    public String getRepairUser_City() {
        return RepairUser_City;
    }

    public void setRepairUser_City(String repairUser_City) {
        RepairUser_City = repairUser_City;
    }

    public String getRepairUser_Region() {
        return RepairUser_Region;
    }

    public void setRepairUser_Region(String repairUser_Region) {
        RepairUser_Region = repairUser_Region;
    }

    public String getRepairUser_DetailAddress() {
        return RepairUser_DetailAddress;
    }

    public void setRepairUser_DetailAddress(String repairUser_DetailAddress) {
        RepairUser_DetailAddress = repairUser_DetailAddress;
    }

    public String getRepairUser_ID() {
        return RepairUser_ID;
    }

    public void setRepairUser_ID(String RepairUser_ID) {
        this.RepairUser_ID = RepairUser_ID;
    }

    public String getRepairUser_Name() {
        return RepairUser_Name;
    }

    public void setRepairUser_Name(String RepairUser_Name) {
        this.RepairUser_Name = RepairUser_Name;
    }

    public int getRepairUser_State() {
        return RepairUser_State;
    }

    public void setRepairUser_State(int RepairUser_State) {
        this.RepairUser_State = RepairUser_State;
    }

    public int getRepairUser_Sex() {
        return RepairUser_Sex;
    }

    public void setRepairUser_Sex(int RepairUser_Sex) {
        this.RepairUser_Sex = RepairUser_Sex;
    }

    public String getRepairUser_RealName() {
        return RepairUser_RealName;
    }

    public void setRepairUser_RealName(String RepairUser_RealName) {
        this.RepairUser_RealName = RepairUser_RealName;
    }

    public String getRepairUser_Mobile() {
        return RepairUser_Mobile;
    }

    public void setRepairUser_Mobile(String RepairUser_Mobile) {
        this.RepairUser_Mobile = RepairUser_Mobile;
    }

    public String getRepairUser_Pwd() {
        return RepairUser_Pwd;
    }

    public void setRepairUser_Pwd(String RepairUser_Pwd) {
        this.RepairUser_Pwd = RepairUser_Pwd;
    }

    public String getRepairUser_CreateTime() {
        return RepairUser_CreateTime;
    }

    public void setRepairUser_CreateTime(String RepairUser_CreateTime) {
        this.RepairUser_CreateTime = RepairUser_CreateTime;
    }

    public boolean isRepairUser_IsMaster() {
        return RepairUser_IsMaster;
    }

    public void setRepairUser_IsMaster(boolean RepairUser_IsMaster) {
        this.RepairUser_IsMaster = RepairUser_IsMaster;
    }

    public Object getRepairUser_ParentID() {
        return RepairUser_ParentID;
    }

    public void setRepairUser_ParentID(Object RepairUser_ParentID) {
        this.RepairUser_ParentID = RepairUser_ParentID;
    }
}
