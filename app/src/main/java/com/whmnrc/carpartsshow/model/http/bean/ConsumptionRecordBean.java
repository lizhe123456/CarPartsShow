package com.whmnrc.carpartsshow.model.http.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lizhe on 2018/3/29.
 */

public class ConsumptionRecordBean implements Serializable {


    /**
     * Credit_ID : 65c988bd-88f1-4e99-bd2e-52314dbae119
     * Credit_Seed : 106
     * Credit_PayNo : L1929939185470
     * Credit_PayType : 2
     * RepairUser_ID : 1f9965d1-7746-4a36-a76e-96024512292a
     * Credit_Month : 2018-03
     * Credit_MoneyUse : 0
     * Credit_FrozenInteger : 0
     * Credit_LossInteger : 3
     * Credit_StartTime : 2018-03-01T00:00:00
     * Credit_EndTime : 2018-04-01T00:00:00
     * Credit_PayTime : null
     * Credit_AllMoney : 108
     * Credit_Integer : 3
     * Credit_BackMoney : 0
     * Credit_BackInteger : 0
     * Credit_ValidInteger : 0
     * RepairUser_Name : 天仁汽车维修服务有限公司
     * RepairUser_RealName : 张三
     * RepairUser_Mobile : 13888888888
     * Credit_FinancialVoucherImgPath : /Resource/PhotoFile/27fa3efb-8728-4fa3-ba41-85fc4fb9fd64.jpg
     * ListDetail : [{"CreditRecord_ID":"5cf22dcd-f969-45ca-8848-1d0f542a2878","CreditRecord_CreateTime":"18-03-07 09:38","CreditRecord_OverTime":"2018-04-01T00:00:00","CreditRecord_Money":108,"CreditRecord_State":0,"UserInfo_ID":"1f9965d1-7746-4a36-a76e-96024512292a","CreditRecord_Type":-1,"CreditRecord_FrozenInteger":0,"CreditRecord_Integer":3,"CreditRecord_EffectiveInteger":0,"CreditRecord_FinancialVoucherImgPath":null,"Company_ID":"0465ad54-ef0a-401f-a4a8-1072fa544da2","Order_ID":"17c74311-1faf-4888-8d85-03249f9be0a9","Order_No":"E4448984127764","CreditRecord_Remark":"[HO-7841 桑塔]等1种商品","Credit_ID":"65c988bd-88f1-4e99-bd2e-52314dbae119"}]
     */

    private String Credit_ID;
    private int Credit_Seed;
    private String Credit_PayNo;
    private int Credit_PayType;
    private String RepairUser_ID;
    private String Credit_Month;
    private int Credit_MoneyUse;
    private int Credit_FrozenInteger;
    private int Credit_LossInteger;
    private String Credit_StartTime;
    private String Credit_EndTime;
    private Object Credit_PayTime;
    private int Credit_AllMoney;
    private int Credit_Integer;
    private int Credit_BackMoney;
    private int Credit_BackInteger;
    private int Credit_ValidInteger;
    private String RepairUser_Name;
    private String RepairUser_RealName;
    private String RepairUser_Mobile;
    private String Credit_FinancialVoucherImgPath;
    private List<ListDetailBean> ListDetail;
    private boolean isShow;

    public boolean isShow() {
        return isShow;
    }

    public void setShow(boolean show) {
        isShow = show;
    }

    public String getCredit_ID() {
        return Credit_ID;
    }

    public void setCredit_ID(String Credit_ID) {
        this.Credit_ID = Credit_ID;
    }

    public int getCredit_Seed() {
        return Credit_Seed;
    }

    public void setCredit_Seed(int Credit_Seed) {
        this.Credit_Seed = Credit_Seed;
    }

    public String getCredit_PayNo() {
        return Credit_PayNo;
    }

    public void setCredit_PayNo(String Credit_PayNo) {
        this.Credit_PayNo = Credit_PayNo;
    }

    public int getCredit_PayType() {
        return Credit_PayType;
    }

    public void setCredit_PayType(int Credit_PayType) {
        this.Credit_PayType = Credit_PayType;
    }

    public String getRepairUser_ID() {
        return RepairUser_ID;
    }

    public void setRepairUser_ID(String RepairUser_ID) {
        this.RepairUser_ID = RepairUser_ID;
    }

    public String getCredit_Month() {
        return Credit_Month;
    }

    public void setCredit_Month(String Credit_Month) {
        this.Credit_Month = Credit_Month;
    }

    public int getCredit_MoneyUse() {
        return Credit_MoneyUse;
    }

    public void setCredit_MoneyUse(int Credit_MoneyUse) {
        this.Credit_MoneyUse = Credit_MoneyUse;
    }

    public int getCredit_FrozenInteger() {
        return Credit_FrozenInteger;
    }

    public void setCredit_FrozenInteger(int Credit_FrozenInteger) {
        this.Credit_FrozenInteger = Credit_FrozenInteger;
    }

    public int getCredit_LossInteger() {
        return Credit_LossInteger;
    }

    public void setCredit_LossInteger(int Credit_LossInteger) {
        this.Credit_LossInteger = Credit_LossInteger;
    }

    public String getCredit_StartTime() {
        return Credit_StartTime;
    }

    public void setCredit_StartTime(String Credit_StartTime) {
        this.Credit_StartTime = Credit_StartTime;
    }

    public String getCredit_EndTime() {
        return Credit_EndTime;
    }

    public void setCredit_EndTime(String Credit_EndTime) {
        this.Credit_EndTime = Credit_EndTime;
    }

    public Object getCredit_PayTime() {
        return Credit_PayTime;
    }

    public void setCredit_PayTime(Object Credit_PayTime) {
        this.Credit_PayTime = Credit_PayTime;
    }

    public int getCredit_AllMoney() {
        return Credit_AllMoney;
    }

    public void setCredit_AllMoney(int Credit_AllMoney) {
        this.Credit_AllMoney = Credit_AllMoney;
    }

    public int getCredit_Integer() {
        return Credit_Integer;
    }

    public void setCredit_Integer(int Credit_Integer) {
        this.Credit_Integer = Credit_Integer;
    }

    public int getCredit_BackMoney() {
        return Credit_BackMoney;
    }

    public void setCredit_BackMoney(int Credit_BackMoney) {
        this.Credit_BackMoney = Credit_BackMoney;
    }

    public int getCredit_BackInteger() {
        return Credit_BackInteger;
    }

    public void setCredit_BackInteger(int Credit_BackInteger) {
        this.Credit_BackInteger = Credit_BackInteger;
    }

    public int getCredit_ValidInteger() {
        return Credit_ValidInteger;
    }

    public void setCredit_ValidInteger(int Credit_ValidInteger) {
        this.Credit_ValidInteger = Credit_ValidInteger;
    }

    public String getRepairUser_Name() {
        return RepairUser_Name;
    }

    public void setRepairUser_Name(String RepairUser_Name) {
        this.RepairUser_Name = RepairUser_Name;
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

    public String getCredit_FinancialVoucherImgPath() {
        return Credit_FinancialVoucherImgPath;
    }

    public void setCredit_FinancialVoucherImgPath(String Credit_FinancialVoucherImgPath) {
        this.Credit_FinancialVoucherImgPath = Credit_FinancialVoucherImgPath;
    }

    public List<ListDetailBean> getListDetail() {
        return ListDetail;
    }

    public void setListDetail(List<ListDetailBean> ListDetail) {
        this.ListDetail = ListDetail;
    }

    public static class ListDetailBean {
        /**
         * CreditRecord_ID : 5cf22dcd-f969-45ca-8848-1d0f542a2878
         * CreditRecord_CreateTime : 18-03-07 09:38
         * CreditRecord_OverTime : 2018-04-01T00:00:00
         * CreditRecord_Money : 108
         * CreditRecord_State : 0
         * UserInfo_ID : 1f9965d1-7746-4a36-a76e-96024512292a
         * CreditRecord_Type : -1
         * CreditRecord_FrozenInteger : 0
         * CreditRecord_Integer : 3
         * CreditRecord_EffectiveInteger : 0
         * CreditRecord_FinancialVoucherImgPath : null
         * Company_ID : 0465ad54-ef0a-401f-a4a8-1072fa544da2
         * Order_ID : 17c74311-1faf-4888-8d85-03249f9be0a9
         * Order_No : E4448984127764
         * CreditRecord_Remark : [HO-7841 桑塔]等1种商品
         * Credit_ID : 65c988bd-88f1-4e99-bd2e-52314dbae119
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
        private String Credit_ID;

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

        public String getCredit_ID() {
            return Credit_ID;
        }

        public void setCredit_ID(String Credit_ID) {
            this.Credit_ID = Credit_ID;
        }
    }
}
