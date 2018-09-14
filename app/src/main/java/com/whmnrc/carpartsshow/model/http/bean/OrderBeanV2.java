package com.whmnrc.carpartsshow.model.http.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lizhe on 2018/3/29.
 */

public class OrderBeanV2 implements Serializable {


    /**
     * Coupon : null
     * CouponCount : 2
     * IsUseCompanyName : 0
     * ListReceiptAddress : [{"Provice":"辽宁省","City":"鞍山市","Region":"千山区","DetailAddress":"西湖区骆家庄西苑一区","PersonName":"小李","Mobile":"15971486093","CompanyName":"小李修理厂"}]
     * ListGoods : [{"Company_ID":"0465ad54-ef0a-401f-a4a8-1072fa544da2","Goods_ID":"0190bbc6-ed6b-41a5-96bb-4a3b0b6c27eb","Name":"火炬 火花塞 5307","ImagePath":"http://www.zpkmall.com//UploadFiles/GoodsBrands/e610c1da97ac48ea8f30b9c4a7f52dda.jpg","Goods_Price":0,"Goods_Integer":0,"Goods_Type":0,"Number":1}]
     * ProductAttrIds : 0190bbc6-ed6b-41a5-96bb-4a3b0b6c27eb,1|
     * CurrentRepairUser : {"RepairUser_ID":"ddeqwdq","RepairUser_Name":"小李修理厂","RepairUser_State":0,"RepairUser_Sex":0,"RepairUser_RealName":"小李","RepairUser_Mobile":"15971486093","RepairUser_Pwd":"E10ADC3949BA59ABBE56E057F20F883E","RepairUser_CreateTime":"2017-05-03T00:00:00","RepairUser_IsMaster":false,"RepairUser_ParentID":null,"RepairUser_SCode":"102767","RepairUser_Provice":"210000","RepairUser_City":"210300","RepairUser_Region":"210311","RepairUser_DetailAddress":"西湖区骆家庄西苑一区","RepairUser_CostMoney":0,"RepairUser_ImgOne":"1","RepairUser_ImgTwo":"2","RepairUser_ImgLicense":"3","RepairUser_ImgHandheldIdentityCard":"4","RepairUser_Integer":998000,"RepairUser_CreditMoney":50000,"Company_ID":"0465ad54-ef0a-401f-a4a8-1072fa544da2","RepairUser_CreditBeOverMoney":35547.99,"RepairUser_CreditType":0,"RepairUser_CreditMonth":1,"RepairUser_CreditDay":20,"DefaultAddress":null,"OrganizationId":null,"OrganizationCode":"10001","OrganizationName":"车行健","CompanyId":"2","OrganizeId":"53298b7a-404c-4337-aa7f-80b2a4ca6681","ShopID":null}
     * listProductAttrId : ["0190bbc6-ed6b-41a5-96bb-4a3b0b6c27eb,1",""]
     * WarehouseList : [{"Id":43,"Code":"10002","Name":"中天凤凰仓库"},{"Id":44,"Code":"10003","Name":"礼嘉仓库"},{"Id":45,"Code":"10004","Name":"中凉亭仓库"},{"Id":55,"Code":"10014","Name":"谭墅仓库"}]
     */

    private Object Coupon;
    private int CouponCount;
    private String IsUseCompanyName;
    private String ProductAttrIds;
    private CurrentRepairUserBean CurrentRepairUser;
    private List<ListReceiptAddressBean> ListReceiptAddress;
    private List<ListGoodsBean> ListGoods;
    private List<String> listProductAttrId;
    private List<WarehouseListBean> WarehouseList;

    public Object getCoupon() {
        return Coupon;
    }

    public void setCoupon(Object Coupon) {
        this.Coupon = Coupon;
    }

    public int getCouponCount() {
        return CouponCount;
    }

    public void setCouponCount(int CouponCount) {
        this.CouponCount = CouponCount;
    }

    public String getIsUseCompanyName() {
        return IsUseCompanyName;
    }

    public void setIsUseCompanyName(String IsUseCompanyName) {
        this.IsUseCompanyName = IsUseCompanyName;
    }

    public String getProductAttrIds() {
        return ProductAttrIds;
    }

    public void setProductAttrIds(String ProductAttrIds) {
        this.ProductAttrIds = ProductAttrIds;
    }

    public CurrentRepairUserBean getCurrentRepairUser() {
        return CurrentRepairUser;
    }

    public void setCurrentRepairUser(CurrentRepairUserBean CurrentRepairUser) {
        this.CurrentRepairUser = CurrentRepairUser;
    }

    public List<ListReceiptAddressBean> getListReceiptAddress() {
        return ListReceiptAddress;
    }

    public void setListReceiptAddress(List<ListReceiptAddressBean> ListReceiptAddress) {
        this.ListReceiptAddress = ListReceiptAddress;
    }

    public List<ListGoodsBean> getListGoods() {
        return ListGoods;
    }

    public void setListGoods(List<ListGoodsBean> ListGoods) {
        this.ListGoods = ListGoods;
    }

    public List<String> getListProductAttrId() {
        return listProductAttrId;
    }

    public void setListProductAttrId(List<String> listProductAttrId) {
        this.listProductAttrId = listProductAttrId;
    }

    public List<WarehouseListBean> getWarehouseList() {
        return WarehouseList;
    }

    public void setWarehouseList(List<WarehouseListBean> WarehouseList) {
        this.WarehouseList = WarehouseList;
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
         * RepairUser_SCode : 102767
         * RepairUser_Provice : 210000
         * RepairUser_City : 210300
         * RepairUser_Region : 210311
         * RepairUser_DetailAddress : 西湖区骆家庄西苑一区
         * RepairUser_CostMoney : 0
         * RepairUser_ImgOne : 1
         * RepairUser_ImgTwo : 2
         * RepairUser_ImgLicense : 3
         * RepairUser_ImgHandheldIdentityCard : 4
         * RepairUser_Integer : 998000
         * RepairUser_CreditMoney : 50000
         * Company_ID : 0465ad54-ef0a-401f-a4a8-1072fa544da2
         * RepairUser_CreditBeOverMoney : 35547.99
         * RepairUser_CreditType : 0
         * RepairUser_CreditMonth : 1
         * RepairUser_CreditDay : 20
         * DefaultAddress : null
         * OrganizationId : null
         * OrganizationCode : 10001
         * OrganizationName : 车行健
         * CompanyId : 2
         * OrganizeId : 53298b7a-404c-4337-aa7f-80b2a4ca6681
         * ShopID : null
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
        private double RepairUser_CreditBeOverMoney;
        private int RepairUser_CreditType;
        private int RepairUser_CreditMonth;
        private int RepairUser_CreditDay;
        private Object DefaultAddress;
        private Object OrganizationId;
        private String OrganizationCode;
        private String OrganizationName;
        private String CompanyId;
        private String OrganizeId;
        private Object ShopID;

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

        public double getRepairUser_CreditBeOverMoney() {
            return RepairUser_CreditBeOverMoney;
        }

        public void setRepairUser_CreditBeOverMoney(double RepairUser_CreditBeOverMoney) {
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

        public Object getOrganizationId() {
            return OrganizationId;
        }

        public void setOrganizationId(Object OrganizationId) {
            this.OrganizationId = OrganizationId;
        }

        public String getOrganizationCode() {
            return OrganizationCode;
        }

        public void setOrganizationCode(String OrganizationCode) {
            this.OrganizationCode = OrganizationCode;
        }

        public String getOrganizationName() {
            return OrganizationName;
        }

        public void setOrganizationName(String OrganizationName) {
            this.OrganizationName = OrganizationName;
        }

        public String getCompanyId() {
            return CompanyId;
        }

        public void setCompanyId(String CompanyId) {
            this.CompanyId = CompanyId;
        }

        public String getOrganizeId() {
            return OrganizeId;
        }

        public void setOrganizeId(String OrganizeId) {
            this.OrganizeId = OrganizeId;
        }

        public Object getShopID() {
            return ShopID;
        }

        public void setShopID(Object ShopID) {
            this.ShopID = ShopID;
        }
    }

    public static class ListReceiptAddressBean {
        /**
         * Provice : 辽宁省
         * City : 鞍山市
         * Region : 千山区
         * DetailAddress : 西湖区骆家庄西苑一区
         * PersonName : 小李
         * Mobile : 15971486093
         * CompanyName : 小李修理厂
         */

        private String Provice;
        private String City;
        private String Region;
        private String DetailAddress;
        private String PersonName;
        private String Mobile;
        private String CompanyName;

        public String getProvice() {
            return Provice;
        }

        public void setProvice(String Provice) {
            this.Provice = Provice;
        }

        public String getCity() {
            return City;
        }

        public void setCity(String City) {
            this.City = City;
        }

        public String getRegion() {
            return Region;
        }

        public void setRegion(String Region) {
            this.Region = Region;
        }

        public String getDetailAddress() {
            return DetailAddress;
        }

        public void setDetailAddress(String DetailAddress) {
            this.DetailAddress = DetailAddress;
        }

        public String getPersonName() {
            return PersonName;
        }

        public void setPersonName(String PersonName) {
            this.PersonName = PersonName;
        }

        public String getMobile() {
            return Mobile;
        }

        public void setMobile(String Mobile) {
            this.Mobile = Mobile;
        }

        public String getCompanyName() {
            return CompanyName;
        }

        public void setCompanyName(String CompanyName) {
            this.CompanyName = CompanyName;
        }
    }

    public static class ListGoodsBean {
        /**
         * Company_ID : 0465ad54-ef0a-401f-a4a8-1072fa544da2
         * Goods_ID : 0190bbc6-ed6b-41a5-96bb-4a3b0b6c27eb
         * Name : 火炬 火花塞 5307
         * ImagePath : http://www.zpkmall.com//UploadFiles/GoodsBrands/e610c1da97ac48ea8f30b9c4a7f52dda.jpg
         * Goods_Price : 0
         * Goods_Integer : 0
         * Goods_Type : 0
         * Number : 1
         */

        private String Company_ID;
        private String Goods_ID;
        private String Name;
        private String ImagePath;
        private int Goods_Price;
        private int Goods_Integer;
        private int Goods_Type;
        private int Number;

        public String getCompany_ID() {
            return Company_ID;
        }

        public void setCompany_ID(String Company_ID) {
            this.Company_ID = Company_ID;
        }

        public String getGoods_ID() {
            return Goods_ID;
        }

        public void setGoods_ID(String Goods_ID) {
            this.Goods_ID = Goods_ID;
        }

        public String getName() {
            return Name;
        }

        public void setName(String Name) {
            this.Name = Name;
        }

        public String getImagePath() {
            return ImagePath;
        }

        public void setImagePath(String ImagePath) {
            this.ImagePath = ImagePath;
        }

        public int getGoods_Price() {
            return Goods_Price;
        }

        public void setGoods_Price(int Goods_Price) {
            this.Goods_Price = Goods_Price;
        }

        public int getGoods_Integer() {
            return Goods_Integer;
        }

        public void setGoods_Integer(int Goods_Integer) {
            this.Goods_Integer = Goods_Integer;
        }

        public int getGoods_Type() {
            return Goods_Type;
        }

        public void setGoods_Type(int Goods_Type) {
            this.Goods_Type = Goods_Type;
        }

        public int getNumber() {
            return Number;
        }

        public void setNumber(int Number) {
            this.Number = Number;
        }
    }

    public static class WarehouseListBean {
        /**
         * Id : 43
         * Code : 10002
         * Name : 中天凤凰仓库
         */

        private int Id;
        private String Code;
        private String Name;

        public int getId() {
            return Id;
        }

        public void setId(int Id) {
            this.Id = Id;
        }

        public String getCode() {
            return Code;
        }

        public void setCode(String Code) {
            this.Code = Code;
        }

        public String getName() {
            return Name;
        }

        public void setName(String Name) {
            this.Name = Name;
        }
    }
}
