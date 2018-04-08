package com.carpartsshow.model.http.bean;

import java.util.List;

/**
 * Created by lizhe on 2018/4/8.
 */

public class SeckillGoodsDetail {


    /**
     * ListServicePhone : [{"ItemDetailId":"2ea2b9c5-a8d8-4669-a372-070eac359b40","ItemId":"2dae762a-72c7-496a-b9b9-63d3cce74bc6","ParentId":"0","ItemCode":null,"ItemName":"客服1","ItemValue":"1588888888","QuickQuery":null,"SimpleSpelling":"kf1","IsDefault":null,"SortCode":0,"DeleteMark":0,"EnabledMark":1,"Description":null,"CreateDate":"2017-12-21T19:42:54.967","CreateUserId":"System","CreateUserName":"超级管理员","ModifyDate":null,"ModifyUserId":null,"ModifyUserName":null},{"ItemDetailId":"bb460a0f-2569-4d81-a6b9-b13b06f7ead8","ItemId":"2dae762a-72c7-496a-b9b9-63d3cce74bc6","ParentId":"0","ItemCode":null,"ItemName":"客服2","ItemValue":"1577777777","QuickQuery":null,"SimpleSpelling":"kf2","IsDefault":null,"SortCode":1,"DeleteMark":0,"EnabledMark":1,"Description":null,"CreateDate":"2017-12-21T19:43:03.653","CreateUserId":"System","CreateUserName":"超级管理员","ModifyDate":null,"ModifyUserId":null,"ModifyUserName":null}]
     * SeckillGoods : {"Seckill_ID":"067bf736-98d8-4cf6-89c6-c4b856a28a74","Seckill_Name":"减震器后右防尘套 DB019","Seckill_ImgPath":"http://zpk.jscxqp.com//Resource/PhotoFile/8c76f9bd-8154-4977-865c-9034a5ae19e9.png","Seckill_Stock":200,"Seckill_LookCount":82,"Seckill_SourcePrice":50,"Seckill_SuggestPrice":110,"Seckill_Price":80,"Seckill_Content":null,"Seckill_CarNoContent":null,"Seckill_ParameterContent":null,"Seckill_SaleContent":null,"Seckill_SaleCount":0,"Seckill_Integer":10,"Seckill_Sort":99,"Seckill_IsOn":true,"Company_ID":"0465ad54-ef0a-401f-a4a8-1072fa544da2","Card_ID":"ad5024a6-f9a5-4868-892c-a8b4cbaba19a"}
     * CurrentRepairUser : {"RepairUser_ID":"ddeqwdq","RepairUser_Name":"小李修理厂","RepairUser_State":0,"RepairUser_Sex":0,"RepairUser_RealName":"小李","RepairUser_Mobile":"15971486093","RepairUser_Pwd":"E10ADC3949BA59ABBE56E057F20F883E","RepairUser_CreateTime":"2017-05-03T00:00:00","RepairUser_IsMaster":false,"RepairUser_ParentID":null,"RepairUser_SCode":"123123","RepairUser_Provice":"140000","RepairUser_City":"140100","RepairUser_Region":"140105","RepairUser_DetailAddress":"来咯咿呀咿呀哟","RepairUser_CostMoney":50000,"RepairUser_ImgOne":"1","RepairUser_ImgTwo":"2","RepairUser_ImgLicense":"3","RepairUser_ImgHandheldIdentityCard":"4","RepairUser_Integer":99,"RepairUser_CreditMoney":50000,"Company_ID":"0465ad54-ef0a-401f-a4a8-1072fa544da2","RepairUser_CreditBeOverMoney":48383,"RepairUser_CreditType":0,"RepairUser_CreditMonth":0,"RepairUser_CreditDay":0,"DefaultAddress":null,"OrganizationId":"2","OrganizationCode":"10001","OrganizationName":null,"CompanyId":null}
     * IsCollection : false
     * CarCount : 6
     * CompanyHandle : {"Company_ID":"0465ad54-ef0a-401f-a4a8-1072fa544da2","RepairUser_SCode":"123123","IsLogin":true,"NotLoggedInWord":"会员登录看价","NotLoggedInSign":"--"}
     */

    private SeckillGoodsBean SeckillGoods;
    private CurrentRepairUserBean CurrentRepairUser;
    private boolean IsCollection;
    private int CarCount;
    private CompanyHandleBean CompanyHandle;
    private List<ListServicePhoneBean> ListServicePhone;

    public SeckillGoodsBean getSeckillGoods() {
        return SeckillGoods;
    }

    public void setSeckillGoods(SeckillGoodsBean SeckillGoods) {
        this.SeckillGoods = SeckillGoods;
    }

    public CurrentRepairUserBean getCurrentRepairUser() {
        return CurrentRepairUser;
    }

    public void setCurrentRepairUser(CurrentRepairUserBean CurrentRepairUser) {
        this.CurrentRepairUser = CurrentRepairUser;
    }

    public boolean isIsCollection() {
        return IsCollection;
    }

    public void setIsCollection(boolean IsCollection) {
        this.IsCollection = IsCollection;
    }

    public int getCarCount() {
        return CarCount;
    }

    public void setCarCount(int CarCount) {
        this.CarCount = CarCount;
    }

    public CompanyHandleBean getCompanyHandle() {
        return CompanyHandle;
    }

    public void setCompanyHandle(CompanyHandleBean CompanyHandle) {
        this.CompanyHandle = CompanyHandle;
    }

    public List<ListServicePhoneBean> getListServicePhone() {
        return ListServicePhone;
    }

    public void setListServicePhone(List<ListServicePhoneBean> ListServicePhone) {
        this.ListServicePhone = ListServicePhone;
    }

    public static class SeckillGoodsBean {
        /**
         * Seckill_ID : 067bf736-98d8-4cf6-89c6-c4b856a28a74
         * Seckill_Name : 减震器后右防尘套 DB019
         * Seckill_ImgPath : http://zpk.jscxqp.com//Resource/PhotoFile/8c76f9bd-8154-4977-865c-9034a5ae19e9.png
         * Seckill_Stock : 200
         * Seckill_LookCount : 82
         * Seckill_SourcePrice : 50
         * Seckill_SuggestPrice : 110
         * Seckill_Price : 80
         * Seckill_Content : null
         * Seckill_CarNoContent : null
         * Seckill_ParameterContent : null
         * Seckill_SaleContent : null
         * Seckill_SaleCount : 0
         * Seckill_Integer : 10
         * Seckill_Sort : 99
         * Seckill_IsOn : true
         * Company_ID : 0465ad54-ef0a-401f-a4a8-1072fa544da2
         * Card_ID : ad5024a6-f9a5-4868-892c-a8b4cbaba19a
         */

        private String Seckill_ID;
        private String Seckill_Name;
        private String Seckill_ImgPath;
        private int Seckill_Stock;
        private int Seckill_LookCount;
        private int Seckill_SourcePrice;
        private int Seckill_SuggestPrice;
        private int Seckill_Price;
        private Object Seckill_Content;
        private Object Seckill_CarNoContent;
        private Object Seckill_ParameterContent;
        private Object Seckill_SaleContent;
        private int Seckill_SaleCount;
        private int Seckill_Integer;
        private int Seckill_Sort;
        private boolean Seckill_IsOn;
        private String Company_ID;
        private String Card_ID;

        public String getSeckill_ID() {
            return Seckill_ID;
        }

        public void setSeckill_ID(String Seckill_ID) {
            this.Seckill_ID = Seckill_ID;
        }

        public String getSeckill_Name() {
            return Seckill_Name;
        }

        public void setSeckill_Name(String Seckill_Name) {
            this.Seckill_Name = Seckill_Name;
        }

        public String getSeckill_ImgPath() {
            return Seckill_ImgPath;
        }

        public void setSeckill_ImgPath(String Seckill_ImgPath) {
            this.Seckill_ImgPath = Seckill_ImgPath;
        }

        public int getSeckill_Stock() {
            return Seckill_Stock;
        }

        public void setSeckill_Stock(int Seckill_Stock) {
            this.Seckill_Stock = Seckill_Stock;
        }

        public int getSeckill_LookCount() {
            return Seckill_LookCount;
        }

        public void setSeckill_LookCount(int Seckill_LookCount) {
            this.Seckill_LookCount = Seckill_LookCount;
        }

        public int getSeckill_SourcePrice() {
            return Seckill_SourcePrice;
        }

        public void setSeckill_SourcePrice(int Seckill_SourcePrice) {
            this.Seckill_SourcePrice = Seckill_SourcePrice;
        }

        public int getSeckill_SuggestPrice() {
            return Seckill_SuggestPrice;
        }

        public void setSeckill_SuggestPrice(int Seckill_SuggestPrice) {
            this.Seckill_SuggestPrice = Seckill_SuggestPrice;
        }

        public int getSeckill_Price() {
            return Seckill_Price;
        }

        public void setSeckill_Price(int Seckill_Price) {
            this.Seckill_Price = Seckill_Price;
        }

        public Object getSeckill_Content() {
            return Seckill_Content;
        }

        public void setSeckill_Content(Object Seckill_Content) {
            this.Seckill_Content = Seckill_Content;
        }

        public Object getSeckill_CarNoContent() {
            return Seckill_CarNoContent;
        }

        public void setSeckill_CarNoContent(Object Seckill_CarNoContent) {
            this.Seckill_CarNoContent = Seckill_CarNoContent;
        }

        public Object getSeckill_ParameterContent() {
            return Seckill_ParameterContent;
        }

        public void setSeckill_ParameterContent(Object Seckill_ParameterContent) {
            this.Seckill_ParameterContent = Seckill_ParameterContent;
        }

        public Object getSeckill_SaleContent() {
            return Seckill_SaleContent;
        }

        public void setSeckill_SaleContent(Object Seckill_SaleContent) {
            this.Seckill_SaleContent = Seckill_SaleContent;
        }

        public int getSeckill_SaleCount() {
            return Seckill_SaleCount;
        }

        public void setSeckill_SaleCount(int Seckill_SaleCount) {
            this.Seckill_SaleCount = Seckill_SaleCount;
        }

        public int getSeckill_Integer() {
            return Seckill_Integer;
        }

        public void setSeckill_Integer(int Seckill_Integer) {
            this.Seckill_Integer = Seckill_Integer;
        }

        public int getSeckill_Sort() {
            return Seckill_Sort;
        }

        public void setSeckill_Sort(int Seckill_Sort) {
            this.Seckill_Sort = Seckill_Sort;
        }

        public boolean isSeckill_IsOn() {
            return Seckill_IsOn;
        }

        public void setSeckill_IsOn(boolean Seckill_IsOn) {
            this.Seckill_IsOn = Seckill_IsOn;
        }

        public String getCompany_ID() {
            return Company_ID;
        }

        public void setCompany_ID(String Company_ID) {
            this.Company_ID = Company_ID;
        }

        public String getCard_ID() {
            return Card_ID;
        }

        public void setCard_ID(String Card_ID) {
            this.Card_ID = Card_ID;
        }
    }

    public static class CurrentRepairUserBean {
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
         * RepairUser_Provice : 140000
         * RepairUser_City : 140100
         * RepairUser_Region : 140105
         * RepairUser_DetailAddress : 来咯咿呀咿呀哟
         * RepairUser_CostMoney : 50000
         * RepairUser_ImgOne : 1
         * RepairUser_ImgTwo : 2
         * RepairUser_ImgLicense : 3
         * RepairUser_ImgHandheldIdentityCard : 4
         * RepairUser_Integer : 99
         * RepairUser_CreditMoney : 50000
         * Company_ID : 0465ad54-ef0a-401f-a4a8-1072fa544da2
         * RepairUser_CreditBeOverMoney : 48383
         * RepairUser_CreditType : 0
         * RepairUser_CreditMonth : 0
         * RepairUser_CreditDay : 0
         * DefaultAddress : null
         * OrganizationId : 2
         * OrganizationCode : 10001
         * OrganizationName : null
         * CompanyId : null
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
        private String RepairUser_SCode;
        private String RepairUser_Provice;
        private String RepairUser_City;
        private String RepairUser_Region;
        private String RepairUser_DetailAddress;
        private int RepairUser_CostMoney;
        private String RepairUser_ImgOne;
        private String RepairUser_ImgTwo;
        private String RepairUser_ImgLicense;
        private String RepairUser_ImgHandheldIdentityCard;
        private int RepairUser_Integer;
        private int RepairUser_CreditMoney;
        private String Company_ID;
        private int RepairUser_CreditBeOverMoney;
        private int RepairUser_CreditType;
        private int RepairUser_CreditMonth;
        private int RepairUser_CreditDay;
        private Object DefaultAddress;
        private String OrganizationId;
        private String OrganizationCode;
        private Object OrganizationName;
        private Object CompanyId;

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

        public String getRepairUser_SCode() {
            return RepairUser_SCode;
        }

        public void setRepairUser_SCode(String RepairUser_SCode) {
            this.RepairUser_SCode = RepairUser_SCode;
        }

        public String getRepairUser_Provice() {
            return RepairUser_Provice;
        }

        public void setRepairUser_Provice(String RepairUser_Provice) {
            this.RepairUser_Provice = RepairUser_Provice;
        }

        public String getRepairUser_City() {
            return RepairUser_City;
        }

        public void setRepairUser_City(String RepairUser_City) {
            this.RepairUser_City = RepairUser_City;
        }

        public String getRepairUser_Region() {
            return RepairUser_Region;
        }

        public void setRepairUser_Region(String RepairUser_Region) {
            this.RepairUser_Region = RepairUser_Region;
        }

        public String getRepairUser_DetailAddress() {
            return RepairUser_DetailAddress;
        }

        public void setRepairUser_DetailAddress(String RepairUser_DetailAddress) {
            this.RepairUser_DetailAddress = RepairUser_DetailAddress;
        }

        public int getRepairUser_CostMoney() {
            return RepairUser_CostMoney;
        }

        public void setRepairUser_CostMoney(int RepairUser_CostMoney) {
            this.RepairUser_CostMoney = RepairUser_CostMoney;
        }

        public String getRepairUser_ImgOne() {
            return RepairUser_ImgOne;
        }

        public void setRepairUser_ImgOne(String RepairUser_ImgOne) {
            this.RepairUser_ImgOne = RepairUser_ImgOne;
        }

        public String getRepairUser_ImgTwo() {
            return RepairUser_ImgTwo;
        }

        public void setRepairUser_ImgTwo(String RepairUser_ImgTwo) {
            this.RepairUser_ImgTwo = RepairUser_ImgTwo;
        }

        public String getRepairUser_ImgLicense() {
            return RepairUser_ImgLicense;
        }

        public void setRepairUser_ImgLicense(String RepairUser_ImgLicense) {
            this.RepairUser_ImgLicense = RepairUser_ImgLicense;
        }

        public String getRepairUser_ImgHandheldIdentityCard() {
            return RepairUser_ImgHandheldIdentityCard;
        }

        public void setRepairUser_ImgHandheldIdentityCard(String RepairUser_ImgHandheldIdentityCard) {
            this.RepairUser_ImgHandheldIdentityCard = RepairUser_ImgHandheldIdentityCard;
        }

        public int getRepairUser_Integer() {
            return RepairUser_Integer;
        }

        public void setRepairUser_Integer(int RepairUser_Integer) {
            this.RepairUser_Integer = RepairUser_Integer;
        }

        public int getRepairUser_CreditMoney() {
            return RepairUser_CreditMoney;
        }

        public void setRepairUser_CreditMoney(int RepairUser_CreditMoney) {
            this.RepairUser_CreditMoney = RepairUser_CreditMoney;
        }

        public String getCompany_ID() {
            return Company_ID;
        }

        public void setCompany_ID(String Company_ID) {
            this.Company_ID = Company_ID;
        }

        public int getRepairUser_CreditBeOverMoney() {
            return RepairUser_CreditBeOverMoney;
        }

        public void setRepairUser_CreditBeOverMoney(int RepairUser_CreditBeOverMoney) {
            this.RepairUser_CreditBeOverMoney = RepairUser_CreditBeOverMoney;
        }

        public int getRepairUser_CreditType() {
            return RepairUser_CreditType;
        }

        public void setRepairUser_CreditType(int RepairUser_CreditType) {
            this.RepairUser_CreditType = RepairUser_CreditType;
        }

        public int getRepairUser_CreditMonth() {
            return RepairUser_CreditMonth;
        }

        public void setRepairUser_CreditMonth(int RepairUser_CreditMonth) {
            this.RepairUser_CreditMonth = RepairUser_CreditMonth;
        }

        public int getRepairUser_CreditDay() {
            return RepairUser_CreditDay;
        }

        public void setRepairUser_CreditDay(int RepairUser_CreditDay) {
            this.RepairUser_CreditDay = RepairUser_CreditDay;
        }

        public Object getDefaultAddress() {
            return DefaultAddress;
        }

        public void setDefaultAddress(Object DefaultAddress) {
            this.DefaultAddress = DefaultAddress;
        }

        public String getOrganizationId() {
            return OrganizationId;
        }

        public void setOrganizationId(String OrganizationId) {
            this.OrganizationId = OrganizationId;
        }

        public String getOrganizationCode() {
            return OrganizationCode;
        }

        public void setOrganizationCode(String OrganizationCode) {
            this.OrganizationCode = OrganizationCode;
        }

        public Object getOrganizationName() {
            return OrganizationName;
        }

        public void setOrganizationName(Object OrganizationName) {
            this.OrganizationName = OrganizationName;
        }

        public Object getCompanyId() {
            return CompanyId;
        }

        public void setCompanyId(Object CompanyId) {
            this.CompanyId = CompanyId;
        }
    }

    public static class CompanyHandleBean {
        /**
         * Company_ID : 0465ad54-ef0a-401f-a4a8-1072fa544da2
         * RepairUser_SCode : 123123
         * IsLogin : true
         * NotLoggedInWord : 会员登录看价
         * NotLoggedInSign : --
         */

        private String Company_ID;
        private String RepairUser_SCode;
        private boolean IsLogin;
        private String NotLoggedInWord;
        private String NotLoggedInSign;

        public String getCompany_ID() {
            return Company_ID;
        }

        public void setCompany_ID(String Company_ID) {
            this.Company_ID = Company_ID;
        }

        public String getRepairUser_SCode() {
            return RepairUser_SCode;
        }

        public void setRepairUser_SCode(String RepairUser_SCode) {
            this.RepairUser_SCode = RepairUser_SCode;
        }

        public boolean isIsLogin() {
            return IsLogin;
        }

        public void setIsLogin(boolean IsLogin) {
            this.IsLogin = IsLogin;
        }

        public String getNotLoggedInWord() {
            return NotLoggedInWord;
        }

        public void setNotLoggedInWord(String NotLoggedInWord) {
            this.NotLoggedInWord = NotLoggedInWord;
        }

        public String getNotLoggedInSign() {
            return NotLoggedInSign;
        }

        public void setNotLoggedInSign(String NotLoggedInSign) {
            this.NotLoggedInSign = NotLoggedInSign;
        }
    }

    public static class ListServicePhoneBean {
        /**
         * ItemDetailId : 2ea2b9c5-a8d8-4669-a372-070eac359b40
         * ItemId : 2dae762a-72c7-496a-b9b9-63d3cce74bc6
         * ParentId : 0
         * ItemCode : null
         * ItemName : 客服1
         * ItemValue : 1588888888
         * QuickQuery : null
         * SimpleSpelling : kf1
         * IsDefault : null
         * SortCode : 0
         * DeleteMark : 0
         * EnabledMark : 1
         * Description : null
         * CreateDate : 2017-12-21T19:42:54.967
         * CreateUserId : System
         * CreateUserName : 超级管理员
         * ModifyDate : null
         * ModifyUserId : null
         * ModifyUserName : null
         */

        private String ItemDetailId;
        private String ItemId;
        private String ParentId;
        private Object ItemCode;
        private String ItemName;
        private String ItemValue;
        private Object QuickQuery;
        private String SimpleSpelling;
        private Object IsDefault;
        private int SortCode;
        private int DeleteMark;
        private int EnabledMark;
        private Object Description;
        private String CreateDate;
        private String CreateUserId;
        private String CreateUserName;
        private Object ModifyDate;
        private Object ModifyUserId;
        private Object ModifyUserName;

        public String getItemDetailId() {
            return ItemDetailId;
        }

        public void setItemDetailId(String ItemDetailId) {
            this.ItemDetailId = ItemDetailId;
        }

        public String getItemId() {
            return ItemId;
        }

        public void setItemId(String ItemId) {
            this.ItemId = ItemId;
        }

        public String getParentId() {
            return ParentId;
        }

        public void setParentId(String ParentId) {
            this.ParentId = ParentId;
        }

        public Object getItemCode() {
            return ItemCode;
        }

        public void setItemCode(Object ItemCode) {
            this.ItemCode = ItemCode;
        }

        public String getItemName() {
            return ItemName;
        }

        public void setItemName(String ItemName) {
            this.ItemName = ItemName;
        }

        public String getItemValue() {
            return ItemValue;
        }

        public void setItemValue(String ItemValue) {
            this.ItemValue = ItemValue;
        }

        public Object getQuickQuery() {
            return QuickQuery;
        }

        public void setQuickQuery(Object QuickQuery) {
            this.QuickQuery = QuickQuery;
        }

        public String getSimpleSpelling() {
            return SimpleSpelling;
        }

        public void setSimpleSpelling(String SimpleSpelling) {
            this.SimpleSpelling = SimpleSpelling;
        }

        public Object getIsDefault() {
            return IsDefault;
        }

        public void setIsDefault(Object IsDefault) {
            this.IsDefault = IsDefault;
        }

        public int getSortCode() {
            return SortCode;
        }

        public void setSortCode(int SortCode) {
            this.SortCode = SortCode;
        }

        public int getDeleteMark() {
            return DeleteMark;
        }

        public void setDeleteMark(int DeleteMark) {
            this.DeleteMark = DeleteMark;
        }

        public int getEnabledMark() {
            return EnabledMark;
        }

        public void setEnabledMark(int EnabledMark) {
            this.EnabledMark = EnabledMark;
        }

        public Object getDescription() {
            return Description;
        }

        public void setDescription(Object Description) {
            this.Description = Description;
        }

        public String getCreateDate() {
            return CreateDate;
        }

        public void setCreateDate(String CreateDate) {
            this.CreateDate = CreateDate;
        }

        public String getCreateUserId() {
            return CreateUserId;
        }

        public void setCreateUserId(String CreateUserId) {
            this.CreateUserId = CreateUserId;
        }

        public String getCreateUserName() {
            return CreateUserName;
        }

        public void setCreateUserName(String CreateUserName) {
            this.CreateUserName = CreateUserName;
        }

        public Object getModifyDate() {
            return ModifyDate;
        }

        public void setModifyDate(Object ModifyDate) {
            this.ModifyDate = ModifyDate;
        }

        public Object getModifyUserId() {
            return ModifyUserId;
        }

        public void setModifyUserId(Object ModifyUserId) {
            this.ModifyUserId = ModifyUserId;
        }

        public Object getModifyUserName() {
            return ModifyUserName;
        }

        public void setModifyUserName(Object ModifyUserName) {
            this.ModifyUserName = ModifyUserName;
        }
    }
}
