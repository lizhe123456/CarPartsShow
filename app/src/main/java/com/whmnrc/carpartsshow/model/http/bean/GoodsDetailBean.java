package com.whmnrc.carpartsshow.model.http.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lizhe on 2018/3/30.
 */

public class GoodsDetailBean implements Serializable{


    /**
     * ListServicePhone : [{"ItemDetailId":"2ea2b9c5-a8d8-4669-a372-070eac359b40","ItemId":"2dae762a-72c7-496a-b9b9-63d3cce74bc6","ParentId":"0","ItemCode":null,"ItemName":"客服1","ItemValue":"1588888888","QuickQuery":null,"SimpleSpelling":"kf1","IsDefault":null,"SortCode":0,"DeleteMark":0,"EnabledMark":1,"Description":null,"CreateDate":"2017-12-21T19:42:54.967","CreateUserId":"System","CreateUserName":"超级管理员","ModifyDate":null,"ModifyUserId":null,"ModifyUserName":null},{"ItemDetailId":"bb460a0f-2569-4d81-a6b9-b13b06f7ead8","ItemId":"2dae762a-72c7-496a-b9b9-63d3cce74bc6","ParentId":"0","ItemCode":null,"ItemName":"客服2","ItemValue":"1577777777","QuickQuery":null,"SimpleSpelling":"kf2","IsDefault":null,"SortCode":1,"DeleteMark":0,"EnabledMark":1,"Description":null,"CreateDate":"2017-12-21T19:43:03.653","CreateUserId":"System","CreateUserName":"超级管理员","ModifyDate":null,"ModifyUserId":null,"ModifyUserName":null}]
     * VGoods : {"ID":3568,"Code":"G0000003568","BrandCategoryID":null,"Category":"D0T","Name":"天合 JBJ176","Model":"JBJ176","ModelLetter":"JBJ176","SizeInfo":"","StyleInfo":"前轴,下,右","Tag":null,"Keywords":"TRW 悬挂球头（球铰链） 天合 JBJ176","Description":"TRW 悬挂球头（球铰链） 天合 JBJ176","Introduce":"<p style=\"TEXT-ALIGN: center\"><img style=\"FLOAT: none\" title=\"1.jpg\" src=\"/UploadFiles/Goods/G0000003568/Images/49525c403d8345449f05160fce3e1ca7.jpg\"/><\/p><p style=\"TEXT-ALIGN: center\"><img title=\"2.jpg\" src=\"/UploadFiles/Goods/G0000003568/Images/0f65360800c943e4b14bc373b797f531.jpg\"/><\/p><p style=\"TEXT-ALIGN: center\"><img title=\"3.jpg\" src=\"/UploadFiles/Goods/G0000003568/Images/d5304422209344858c534481cabd1534.jpg\"/><\/p><p>&nbsp;<\/p>","Parameters":"<p>品牌：TRW/天合<\/p><p>类型：悬挂球头（球铰链）<\/p><p>适用位置：前轴,下,右<\/p><p>型号：JBJ176<\/p><p>&nbsp;<\/p>","EditType":1,"EditTime":"2017-11-21T14:19:22.3","EditTimeStamp":1511245162300,"EditUser":2,"Deleted":false,"Brand":"TRW","TCode":"TRW_JBJ176","Goods_ID":"0004f845-b3af-4a0c-a66a-058cb34aef7e","Goods_CarNoContent":"","Goods_SaleContent":"","Goods_Code":"G0000003568","Goods_LookCount":0,"Goods_Sort":99,"Goods_Integer":0,"Goods_SuggestPrice":22,"Goods_Price":15,"Goods_IsOn":true,"Goods_IsHot":false,"Company_ID":"0465ad54-ef0a-401f-a4a8-1072fa544da2","MonthCount":0,"BrandName":"TRW","CategoryName":"球头","ImagePath":"http://zpk.jscxqp.com//UploadFiles/Goods/G0000003568/f934dd97f48846a3b72413050c209f02.jpg","UniversalParts":false}
     * CurrentRepairUser : {"RepairUser_ID":null,"RepairUser_Name":null,"RepairUser_State":0,"RepairUser_Sex":0,"RepairUser_RealName":null,"RepairUser_Mobile":null,"RepairUser_Pwd":null,"RepairUser_CreateTime":"0001-01-01T00:00:00","RepairUser_IsMaster":null,"RepairUser_ParentID":null,"RepairUser_SCode":null,"RepairUser_Provice":null,"RepairUser_City":null,"RepairUser_Region":null,"RepairUser_DetailAddress":null,"RepairUser_CostMoney":0,"RepairUser_ImgOne":null,"RepairUser_ImgTwo":null,"RepairUser_ImgLicense":null,"RepairUser_ImgHandheldIdentityCard":null,"RepairUser_Integer":0,"RepairUser_CreditMoney":0,"Company_ID":null,"RepairUser_CreditBeOverMoney":0,"RepairUser_CreditType":0,"RepairUser_CreditMonth":0,"RepairUser_CreditDay":0,"DefaultAddress":null,"OrganizationId":null,"OrganizationCode":null,"OrganizationName":null,"CompanyId":null}
     * IsCollection : true
     * CarCount : 9
     * Url : http://zpk.jscxqp.com/HomeWxZPK/GoodsDetailApp?Goods_ID=0004f845-b3af-4a0c-a66a-058cb34aef7e
     * CompanyHandle : {"Company_ID":"0465ad54-ef0a-401f-a4a8-1072fa544da2","RepairUser_SCode":"123123","IsLogin":true,"NotLoggedInWord":"会员登录看价","NotLoggedInSign":"--"}
     */

    private VGoodsBean VGoods;
    private CurrentRepairUserBean CurrentRepairUser;
    private boolean IsCollection;
    private int CarCount;
    private String Url;
    private CompanyHandleBean CompanyHandle;
    private List<ListServicePhoneBean> ListServicePhone;

    public VGoodsBean getVGoods() {
        return VGoods;
    }

    public void setVGoods(VGoodsBean VGoods) {
        this.VGoods = VGoods;
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

    public String getUrl() {
        return Url;
    }

    public void setUrl(String Url) {
        this.Url = Url;
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

    public static class VGoodsBean {
        /**
         * ID : 3568
         * Code : G0000003568
         * BrandCategoryID : null
         * Category : D0T
         * Name : 天合 JBJ176
         * Model : JBJ176
         * ModelLetter : JBJ176
         * SizeInfo :
         * StyleInfo : 前轴,下,右
         * Tag : null
         * Keywords : TRW 悬挂球头（球铰链） 天合 JBJ176
         * Description : TRW 悬挂球头（球铰链） 天合 JBJ176
         * Introduce : <p style="TEXT-ALIGN: center"><img style="FLOAT: none" title="1.jpg" src="/UploadFiles/Goods/G0000003568/Images/49525c403d8345449f05160fce3e1ca7.jpg"/></p><p style="TEXT-ALIGN: center"><img title="2.jpg" src="/UploadFiles/Goods/G0000003568/Images/0f65360800c943e4b14bc373b797f531.jpg"/></p><p style="TEXT-ALIGN: center"><img title="3.jpg" src="/UploadFiles/Goods/G0000003568/Images/d5304422209344858c534481cabd1534.jpg"/></p><p>&nbsp;</p>
         * Parameters : <p>品牌：TRW/天合</p><p>类型：悬挂球头（球铰链）</p><p>适用位置：前轴,下,右</p><p>型号：JBJ176</p><p>&nbsp;</p>
         * EditType : 1
         * EditTime : 2017-11-21T14:19:22.3
         * EditTimeStamp : 1511245162300
         * EditUser : 2
         * Deleted : false
         * Brand : TRW
         * TCode : TRW_JBJ176
         * Goods_ID : 0004f845-b3af-4a0c-a66a-058cb34aef7e
         * Goods_CarNoContent :
         * Goods_SaleContent :
         * Goods_Code : G0000003568
         * Goods_LookCount : 0
         * Goods_Sort : 99
         * Goods_Integer : 0
         * Goods_SuggestPrice : 22
         * Goods_Price : 15
         * Goods_IsOn : true
         * Goods_IsHot : false
         * Company_ID : 0465ad54-ef0a-401f-a4a8-1072fa544da2
         * MonthCount : 0
         * BrandName : TRW
         * CategoryName : 球头
         * ImagePath : http://zpk.jscxqp.com//UploadFiles/Goods/G0000003568/f934dd97f48846a3b72413050c209f02.jpg
         * UniversalParts : false
         */

        private int ID;
        private String Code;
        private Object BrandCategoryID;
        private String Category;
        private String Name;
        private String Model;
        private String ModelLetter;
        private String SizeInfo;
        private String StyleInfo;
        private Object Tag;
        private String Keywords;
        private String Description;
        private String Introduce;
        private String Parameters;
        private int EditType;
        private String EditTime;
        private long EditTimeStamp;
        private int EditUser;
        private boolean Deleted;
        private String Brand;
        private String TCode;
        private String Goods_ID;
        private String Goods_CarNoContent;
        private String Goods_SaleContent;
        private String Goods_Code;
        private int Goods_LookCount;
        private int Goods_Sort;
        private int Goods_Integer;
        private int Goods_SuggestPrice;
        private int Goods_Price;
        private boolean Goods_IsOn;
        private boolean Goods_IsHot;
        private String Company_ID;
        private int MonthCount;
        private String BrandName;
        private String CategoryName;
        private String ImagePath;
        private boolean UniversalParts;

        public int getID() {
            return ID;
        }

        public void setID(int ID) {
            this.ID = ID;
        }

        public String getCode() {
            return Code;
        }

        public void setCode(String Code) {
            this.Code = Code;
        }

        public Object getBrandCategoryID() {
            return BrandCategoryID;
        }

        public void setBrandCategoryID(Object BrandCategoryID) {
            this.BrandCategoryID = BrandCategoryID;
        }

        public String getCategory() {
            return Category;
        }

        public void setCategory(String Category) {
            this.Category = Category;
        }

        public String getName() {
            return Name;
        }

        public void setName(String Name) {
            this.Name = Name;
        }

        public String getModel() {
            return Model;
        }

        public void setModel(String Model) {
            this.Model = Model;
        }

        public String getModelLetter() {
            return ModelLetter;
        }

        public void setModelLetter(String ModelLetter) {
            this.ModelLetter = ModelLetter;
        }

        public String getSizeInfo() {
            return SizeInfo;
        }

        public void setSizeInfo(String SizeInfo) {
            this.SizeInfo = SizeInfo;
        }

        public String getStyleInfo() {
            return StyleInfo;
        }

        public void setStyleInfo(String StyleInfo) {
            this.StyleInfo = StyleInfo;
        }

        public Object getTag() {
            return Tag;
        }

        public void setTag(Object Tag) {
            this.Tag = Tag;
        }

        public String getKeywords() {
            return Keywords;
        }

        public void setKeywords(String Keywords) {
            this.Keywords = Keywords;
        }

        public String getDescription() {
            return Description;
        }

        public void setDescription(String Description) {
            this.Description = Description;
        }

        public String getIntroduce() {
            return Introduce;
        }

        public void setIntroduce(String Introduce) {
            this.Introduce = Introduce;
        }

        public String getParameters() {
            return Parameters;
        }

        public void setParameters(String Parameters) {
            this.Parameters = Parameters;
        }

        public int getEditType() {
            return EditType;
        }

        public void setEditType(int EditType) {
            this.EditType = EditType;
        }

        public String getEditTime() {
            return EditTime;
        }

        public void setEditTime(String EditTime) {
            this.EditTime = EditTime;
        }

        public long getEditTimeStamp() {
            return EditTimeStamp;
        }

        public void setEditTimeStamp(long EditTimeStamp) {
            this.EditTimeStamp = EditTimeStamp;
        }

        public int getEditUser() {
            return EditUser;
        }

        public void setEditUser(int EditUser) {
            this.EditUser = EditUser;
        }

        public boolean isDeleted() {
            return Deleted;
        }

        public void setDeleted(boolean Deleted) {
            this.Deleted = Deleted;
        }

        public String getBrand() {
            return Brand;
        }

        public void setBrand(String Brand) {
            this.Brand = Brand;
        }

        public String getTCode() {
            return TCode;
        }

        public void setTCode(String TCode) {
            this.TCode = TCode;
        }

        public String getGoods_ID() {
            return Goods_ID;
        }

        public void setGoods_ID(String Goods_ID) {
            this.Goods_ID = Goods_ID;
        }

        public String getGoods_CarNoContent() {
            return Goods_CarNoContent;
        }

        public void setGoods_CarNoContent(String Goods_CarNoContent) {
            this.Goods_CarNoContent = Goods_CarNoContent;
        }

        public String getGoods_SaleContent() {
            return Goods_SaleContent;
        }

        public void setGoods_SaleContent(String Goods_SaleContent) {
            this.Goods_SaleContent = Goods_SaleContent;
        }

        public String getGoods_Code() {
            return Goods_Code;
        }

        public void setGoods_Code(String Goods_Code) {
            this.Goods_Code = Goods_Code;
        }

        public int getGoods_LookCount() {
            return Goods_LookCount;
        }

        public void setGoods_LookCount(int Goods_LookCount) {
            this.Goods_LookCount = Goods_LookCount;
        }

        public int getGoods_Sort() {
            return Goods_Sort;
        }

        public void setGoods_Sort(int Goods_Sort) {
            this.Goods_Sort = Goods_Sort;
        }

        public int getGoods_Integer() {
            return Goods_Integer;
        }

        public void setGoods_Integer(int Goods_Integer) {
            this.Goods_Integer = Goods_Integer;
        }

        public int getGoods_SuggestPrice() {
            return Goods_SuggestPrice;
        }

        public void setGoods_SuggestPrice(int Goods_SuggestPrice) {
            this.Goods_SuggestPrice = Goods_SuggestPrice;
        }

        public int getGoods_Price() {
            return Goods_Price;
        }

        public void setGoods_Price(int Goods_Price) {
            this.Goods_Price = Goods_Price;
        }

        public boolean isGoods_IsOn() {
            return Goods_IsOn;
        }

        public void setGoods_IsOn(boolean Goods_IsOn) {
            this.Goods_IsOn = Goods_IsOn;
        }

        public boolean isGoods_IsHot() {
            return Goods_IsHot;
        }

        public void setGoods_IsHot(boolean Goods_IsHot) {
            this.Goods_IsHot = Goods_IsHot;
        }

        public String getCompany_ID() {
            return Company_ID;
        }

        public void setCompany_ID(String Company_ID) {
            this.Company_ID = Company_ID;
        }

        public int getMonthCount() {
            return MonthCount;
        }

        public void setMonthCount(int MonthCount) {
            this.MonthCount = MonthCount;
        }

        public String getBrandName() {
            return BrandName;
        }

        public void setBrandName(String BrandName) {
            this.BrandName = BrandName;
        }

        public String getCategoryName() {
            return CategoryName;
        }

        public void setCategoryName(String CategoryName) {
            this.CategoryName = CategoryName;
        }

        public String getImagePath() {
            return ImagePath;
        }

        public void setImagePath(String ImagePath) {
            this.ImagePath = ImagePath;
        }

        public boolean isUniversalParts() {
            return UniversalParts;
        }

        public void setUniversalParts(boolean UniversalParts) {
            this.UniversalParts = UniversalParts;
        }
    }

    public static class CurrentRepairUserBean {
        /**
         * RepairUser_ID : null
         * RepairUser_Name : null
         * RepairUser_State : 0
         * RepairUser_Sex : 0
         * RepairUser_RealName : null
         * RepairUser_Mobile : null
         * RepairUser_Pwd : null
         * RepairUser_CreateTime : 0001-01-01T00:00:00
         * RepairUser_IsMaster : null
         * RepairUser_ParentID : null
         * RepairUser_SCode : null
         * RepairUser_Provice : null
         * RepairUser_City : null
         * RepairUser_Region : null
         * RepairUser_DetailAddress : null
         * RepairUser_CostMoney : 0
         * RepairUser_ImgOne : null
         * RepairUser_ImgTwo : null
         * RepairUser_ImgLicense : null
         * RepairUser_ImgHandheldIdentityCard : null
         * RepairUser_Integer : 0
         * RepairUser_CreditMoney : 0
         * Company_ID : null
         * RepairUser_CreditBeOverMoney : 0
         * RepairUser_CreditType : 0
         * RepairUser_CreditMonth : 0
         * RepairUser_CreditDay : 0
         * DefaultAddress : null
         * OrganizationId : null
         * OrganizationCode : null
         * OrganizationName : null
         * CompanyId : null
         */

        private Object RepairUser_ID;
        private Object RepairUser_Name;
        private int RepairUser_State;
        private int RepairUser_Sex;
        private Object RepairUser_RealName;
        private Object RepairUser_Mobile;
        private Object RepairUser_Pwd;
        private String RepairUser_CreateTime;
        private Object RepairUser_IsMaster;
        private Object RepairUser_ParentID;
        private Object RepairUser_SCode;
        private Object RepairUser_Provice;
        private Object RepairUser_City;
        private Object RepairUser_Region;
        private Object RepairUser_DetailAddress;
        private int RepairUser_CostMoney;
        private Object RepairUser_ImgOne;
        private Object RepairUser_ImgTwo;
        private Object RepairUser_ImgLicense;
        private Object RepairUser_ImgHandheldIdentityCard;
        private int RepairUser_Integer;
        private int RepairUser_CreditMoney;
        private Object Company_ID;
        private int RepairUser_CreditBeOverMoney;
        private int RepairUser_CreditType;
        private int RepairUser_CreditMonth;
        private int RepairUser_CreditDay;
        private Object DefaultAddress;
        private Object OrganizationId;
        private Object OrganizationCode;
        private Object OrganizationName;
        private Object CompanyId;

        public Object getRepairUser_ID() {
            return RepairUser_ID;
        }

        public void setRepairUser_ID(Object RepairUser_ID) {
            this.RepairUser_ID = RepairUser_ID;
        }

        public Object getRepairUser_Name() {
            return RepairUser_Name;
        }

        public void setRepairUser_Name(Object RepairUser_Name) {
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

        public Object getRepairUser_RealName() {
            return RepairUser_RealName;
        }

        public void setRepairUser_RealName(Object RepairUser_RealName) {
            this.RepairUser_RealName = RepairUser_RealName;
        }

        public Object getRepairUser_Mobile() {
            return RepairUser_Mobile;
        }

        public void setRepairUser_Mobile(Object RepairUser_Mobile) {
            this.RepairUser_Mobile = RepairUser_Mobile;
        }

        public Object getRepairUser_Pwd() {
            return RepairUser_Pwd;
        }

        public void setRepairUser_Pwd(Object RepairUser_Pwd) {
            this.RepairUser_Pwd = RepairUser_Pwd;
        }

        public String getRepairUser_CreateTime() {
            return RepairUser_CreateTime;
        }

        public void setRepairUser_CreateTime(String RepairUser_CreateTime) {
            this.RepairUser_CreateTime = RepairUser_CreateTime;
        }

        public Object getRepairUser_IsMaster() {
            return RepairUser_IsMaster;
        }

        public void setRepairUser_IsMaster(Object RepairUser_IsMaster) {
            this.RepairUser_IsMaster = RepairUser_IsMaster;
        }

        public Object getRepairUser_ParentID() {
            return RepairUser_ParentID;
        }

        public void setRepairUser_ParentID(Object RepairUser_ParentID) {
            this.RepairUser_ParentID = RepairUser_ParentID;
        }

        public Object getRepairUser_SCode() {
            return RepairUser_SCode;
        }

        public void setRepairUser_SCode(Object RepairUser_SCode) {
            this.RepairUser_SCode = RepairUser_SCode;
        }

        public Object getRepairUser_Provice() {
            return RepairUser_Provice;
        }

        public void setRepairUser_Provice(Object RepairUser_Provice) {
            this.RepairUser_Provice = RepairUser_Provice;
        }

        public Object getRepairUser_City() {
            return RepairUser_City;
        }

        public void setRepairUser_City(Object RepairUser_City) {
            this.RepairUser_City = RepairUser_City;
        }

        public Object getRepairUser_Region() {
            return RepairUser_Region;
        }

        public void setRepairUser_Region(Object RepairUser_Region) {
            this.RepairUser_Region = RepairUser_Region;
        }

        public Object getRepairUser_DetailAddress() {
            return RepairUser_DetailAddress;
        }

        public void setRepairUser_DetailAddress(Object RepairUser_DetailAddress) {
            this.RepairUser_DetailAddress = RepairUser_DetailAddress;
        }

        public int getRepairUser_CostMoney() {
            return RepairUser_CostMoney;
        }

        public void setRepairUser_CostMoney(int RepairUser_CostMoney) {
            this.RepairUser_CostMoney = RepairUser_CostMoney;
        }

        public Object getRepairUser_ImgOne() {
            return RepairUser_ImgOne;
        }

        public void setRepairUser_ImgOne(Object RepairUser_ImgOne) {
            this.RepairUser_ImgOne = RepairUser_ImgOne;
        }

        public Object getRepairUser_ImgTwo() {
            return RepairUser_ImgTwo;
        }

        public void setRepairUser_ImgTwo(Object RepairUser_ImgTwo) {
            this.RepairUser_ImgTwo = RepairUser_ImgTwo;
        }

        public Object getRepairUser_ImgLicense() {
            return RepairUser_ImgLicense;
        }

        public void setRepairUser_ImgLicense(Object RepairUser_ImgLicense) {
            this.RepairUser_ImgLicense = RepairUser_ImgLicense;
        }

        public Object getRepairUser_ImgHandheldIdentityCard() {
            return RepairUser_ImgHandheldIdentityCard;
        }

        public void setRepairUser_ImgHandheldIdentityCard(Object RepairUser_ImgHandheldIdentityCard) {
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

        public Object getCompany_ID() {
            return Company_ID;
        }

        public void setCompany_ID(Object Company_ID) {
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

        public Object getOrganizationId() {
            return OrganizationId;
        }

        public void setOrganizationId(Object OrganizationId) {
            this.OrganizationId = OrganizationId;
        }

        public Object getOrganizationCode() {
            return OrganizationCode;
        }

        public void setOrganizationCode(Object OrganizationCode) {
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
