package com.whmnrc.carpartsshow.model.http.bean;

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

    public static class ListGoodsBean {

        /**
         * ID : 42
         * Code : G0000000042
         * BrandCategoryID : null
         * Category : GYZ
         * Name : SWF(优视) 奥迪A6L(C6) 专用无骨雨刮 117217
         * Model : 117217
         * ModelLetter : 117217
         * SizeInfo : 22"/22"
         * StyleInfo : 无骨雨刮
         * Tag : null
         * Keywords : 法雷奥 雨刮器 SWF(优视)  奥迪A6L(C6)   专用无骨雨刮 117217
         * Description : 法雷奥 雨刮器 SWF(优视)  奥迪A6L(C6)   专用无骨雨刮 117217
         * Introduce : <p style="TEXT-ALIGN: center"><img style="FLOAT: none" title="0.jpg" src="/UploadFiles/Goods/G0000000042/Images/459e8c06c6364baaa3778b6d043e2182.jpg"/></p><p style="TEXT-ALIGN: center"><img style="FLOAT: none" title="1.jpg" src="/UploadFiles/Goods/G0000000042/Images/699e344302374db589b9fbac39c69536.jpg"/></p><p style="TEXT-ALIGN: center"><img style="FLOAT: none" title="2.jpg" src="/UploadFiles/Goods/G0000000042/Images/f81647f25b62480abd52e4dfd2d18e9c.jpg"/></p><p style="TEXT-ALIGN: center"><img style="FLOAT: none" title="3.jpg" src="/UploadFiles/Goods/G0000000042/Images/77d1f81ce4c744c4a70fe4117c5e91a8.jpg"/></p><p style="TEXT-ALIGN: center"><img style="FLOAT: none" title="4.jpg" src="/UploadFiles/Goods/G0000000042/Images/8c8ea552d9964f14acb1dcf21b80f372.jpg"/></p><p style="TEXT-ALIGN: center"><img style="FLOAT: none" title="5.jpg" src="/UploadFiles/Goods/G0000000042/Images/a824cf77732f443cb6a605f14279bbd4.jpg"/></p><p style="TEXT-ALIGN: center"><img style="FLOAT: none" title="6.jpg" src="/UploadFiles/Goods/G0000000042/Images/7755c90b377b4521a7109336d7558af7.jpg"/></p><p style="TEXT-ALIGN: center"><img style="FLOAT: none" title="7.jpg" src="/UploadFiles/Goods/G0000000042/Images/511acc213e054a13bda58f82d86d19ec.jpg"/></p><p style="TEXT-ALIGN: center"><img style="FLOAT: none" title="8.jpg" src="/UploadFiles/Goods/G0000000042/Images/d2a0188b6e094529ac35eb32a1966141.jpg"/></p><p style="TEXT-ALIGN: center"><img style="FLOAT: none" title="9.jpg" src="/UploadFiles/Goods/G0000000042/Images/4bc648e5f01d476bb65c55d3178462c5.jpg"/></p><p style="TEXT-ALIGN: center">&nbsp;</p>
         * Parameters : <ul style="list-style-type: none;" class="attributes-list list-paddingleft-2"><li><p>品牌: Valeo/法雷奥</p></li><li><p>型号: 117217</p></li><li><p>尺寸: 22&quot;/22&quot;</p></li><li><p>雨刷类型: 无骨雨刷</p></li><li><p>件数: 2件</p></li></ul><p>&nbsp;</p>
         * EditType : 1
         * EditTime : 2017-11-21T10:00:29.623
         * EditTimeStamp : 1511229629622
         * EditUser : 1
         * Deleted : false
         * Brand : FL0
         * TCode : FL0_117217
         * Goods_ID : 5aa92597-3c27-4ef5-8e1d-d4411242a3c6
         * Goods_CarNoContent : <p>dqwd</p>
         * Goods_SaleContent : <p>带我去多</p>
         * Goods_Code : G0000000042
         * Goods_LookCount : 2
         * Goods_Sort : 99
         * Goods_Integer : 111
         * Goods_SuggestPrice : 111
         * Goods_Price : 222.5
         * Goods_IsOn : true
         * Goods_IsHot : true
         * Company_ID : 0465ad54-ef0a-401f-a4a8-1072fa544da2
         * MonthCount : 0
         * BrandName : 法雷奥
         * CategoryName : 专用雨刷
         * ImagePath : http://zpk.jscxqp.com//UploadFiles/Goods/G0000000042/cad5c9629f8548ccaed58c15d206b5ef.jpg
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
        private double Goods_Price;
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

        public double getGoods_Price() {
            return Goods_Price;
        }

        public void setGoods_Price(double Goods_Price) {
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
