package com.carpartsshow.model.http.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lizhe on 2018/3/27.
 */

public class GoodsListBean implements Serializable{

    private TheCompanyHandleBean TheCompanyHandle;
    private List<ListGoodsBean> ListGoods;
    private int isMore;

    public int getIsMore() {
        return isMore;
    }

    public void setIsMore(int isMore) {
        this.isMore = isMore;
    }

    public TheCompanyHandleBean getTheCompanyHandle() {
        return TheCompanyHandle;
    }

    public void setTheCompanyHandle(TheCompanyHandleBean TheCompanyHandle) {
        this.TheCompanyHandle = TheCompanyHandle;
    }

    public List<ListGoodsBean> getListGoods() {
        return ListGoods;
    }

    public void setListGoods(List<ListGoodsBean> ListGoods) {
        this.ListGoods = ListGoods;
    }

    public static class TheCompanyHandleBean implements Serializable{
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

    public static class ListGoodsBean implements Serializable{
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
}
