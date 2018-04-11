package com.whmnrc.carpartsshow.model.http.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lizhe on 2018/3/16.
 */

public class IntergralShopBean implements Serializable{

    private List<BannerListBean> BannerList;
    private List<IntegerGoodsListBean> IntegerGoodsList;
    private List<IstIntegerGoods> IstIntegerGoods;

    public List<BannerListBean> getBannerList() {
        return BannerList;
    }

    public void setBannerList(List<BannerListBean> BannerList) {
        this.BannerList = BannerList;
    }

    public List<IntegerGoodsListBean> getIntegerGoodsList() {
        return IntegerGoodsList;
    }

    public void setIntegerGoodsList(List<IntegerGoodsListBean> IntegerGoodsList) {
        this.IntegerGoodsList = IntegerGoodsList;
    }

    public List<IstIntegerGoods> getIstIntegerGoods() {
        return IstIntegerGoods;
    }

    public void setIstIntegerGoods(List<IstIntegerGoods> IstIntegerGoods) {
        this.IstIntegerGoods = IstIntegerGoods;
    }

    public static class BannerListBean {
        /**
         * Banner_ID : 0338bc91-c80d-4657-aab9-97e706bac70e
         * Banner_WxAppImgPath : http://zpk.jscxqp.com//Resource/PhotoFile/a8a484c3-d97c-4c02-a038-fe43c648cb63.jpg
         * Banner_PcImgPath : /Resource/PhotoFile/e6d14529-35fc-44b0-958e-a0e93a735ada.jpg
         * Banner_WxLinkUrl : #
         * Banner_PcLikUrl : #
         * Category : 积分首页
         * Banner_Sort : 99
         * Company_ID : 0465ad54-ef0a-401f-a4a8-1072fa544da2
         */

        private String Banner_ID;
        private String Banner_WxAppImgPath;
        private String Banner_PcImgPath;
        private String Banner_WxLinkUrl;
        private String Banner_PcLikUrl;
        private String Category;
        private int Banner_Sort;
        private String Company_ID;

        public String getBanner_ID() {
            return Banner_ID;
        }

        public void setBanner_ID(String Banner_ID) {
            this.Banner_ID = Banner_ID;
        }

        public String getBanner_WxAppImgPath() {
            return Banner_WxAppImgPath;
        }

        public void setBanner_WxAppImgPath(String Banner_WxAppImgPath) {
            this.Banner_WxAppImgPath = Banner_WxAppImgPath;
        }

        public String getBanner_PcImgPath() {
            return Banner_PcImgPath;
        }

        public void setBanner_PcImgPath(String Banner_PcImgPath) {
            this.Banner_PcImgPath = Banner_PcImgPath;
        }

        public String getBanner_WxLinkUrl() {
            return Banner_WxLinkUrl;
        }

        public void setBanner_WxLinkUrl(String Banner_WxLinkUrl) {
            this.Banner_WxLinkUrl = Banner_WxLinkUrl;
        }

        public String getBanner_PcLikUrl() {
            return Banner_PcLikUrl;
        }

        public void setBanner_PcLikUrl(String Banner_PcLikUrl) {
            this.Banner_PcLikUrl = Banner_PcLikUrl;
        }

        public String getCategory() {
            return Category;
        }

        public void setCategory(String Category) {
            this.Category = Category;
        }

        public int getBanner_Sort() {
            return Banner_Sort;
        }

        public void setBanner_Sort(int Banner_Sort) {
            this.Banner_Sort = Banner_Sort;
        }

        public String getCompany_ID() {
            return Company_ID;
        }

        public void setCompany_ID(String Company_ID) {
            this.Company_ID = Company_ID;
        }
    }

    public static class IntegerGoodsListBean {
        /**
         * IntegerGoodsType_ID : 0174879a-ca32-417f-a863-ac253fb90e81
         * IntegerGoodsType_Name : 生活用品
         * IntegerGoodsType_ImgPath : http://zpk.jscxqp.com//Resource/PhotoFile/f36ec05f-7ab6-4c81-aebb-f184565ab6c6.jpg
         * IntegerGoodsType_Sort : 0
         * Company_ID : 0465ad54-ef0a-401f-a4a8-1072fa544da2
         */

        private String IntegerGoodsType_ID;
        private String IntegerGoodsType_Name;
        private String IntegerGoodsType_ImgPath;
        private int IntegerGoodsType_Sort;
        private String Company_ID;
        private int img;

        public int getImg() {
            return img;
        }

        public void setImg(int img) {
            this.img = img;
        }

        public String getIntegerGoodsType_ID() {
            return IntegerGoodsType_ID;
        }

        public void setIntegerGoodsType_ID(String IntegerGoodsType_ID) {
            this.IntegerGoodsType_ID = IntegerGoodsType_ID;
        }

        public String getIntegerGoodsType_Name() {
            return IntegerGoodsType_Name;
        }

        public void setIntegerGoodsType_Name(String IntegerGoodsType_Name) {
            this.IntegerGoodsType_Name = IntegerGoodsType_Name;
        }

        public String getIntegerGoodsType_ImgPath() {
            return IntegerGoodsType_ImgPath;
        }

        public void setIntegerGoodsType_ImgPath(String IntegerGoodsType_ImgPath) {
            this.IntegerGoodsType_ImgPath = IntegerGoodsType_ImgPath;
        }

        public int getIntegerGoodsType_Sort() {
            return IntegerGoodsType_Sort;
        }

        public void setIntegerGoodsType_Sort(int IntegerGoodsType_Sort) {
            this.IntegerGoodsType_Sort = IntegerGoodsType_Sort;
        }

        public String getCompany_ID() {
            return Company_ID;
        }

        public void setCompany_ID(String Company_ID) {
            this.Company_ID = Company_ID;
        }
    }

    public class IstIntegerGoods implements Serializable{

        /**
         * IntegerGoods_ID : 432564ht5utyuty
         * IntegerGoods_Name : 生命之源特级初榨橄榄油1L
         * IntegerGoods_ImgPath : http://zpk.jscxqp.com//Resource/PhotoFile/6ea7d1b6-10a9-4d4e-a554-443b1a06a62f.jpg
         * IntegerGoodsType_ID : 0174879a-ca32-417f-a863-ac253fb90e81
         * IntegerGoods_SaleContent : null
         * IntegerGoods_Sort : 0
         * IntegerGoods_Integer : 1200
         * IntegerGoods_IsOn : true
         * Company_ID : 0465ad54-ef0a-401f-a4a8-1072fa544da2
         * Floor_ID : 6ad90c8d-cd7d-48af-983b-b8a7db89d0e2
         */

        private String IntegerGoods_ID;
        private String IntegerGoods_Name;
        private String IntegerGoods_ImgPath;
        private String IntegerGoodsType_ID;
        private Object IntegerGoods_SaleContent;
        private int IntegerGoods_Sort;
        private int IntegerGoods_Integer;
        private boolean IntegerGoods_IsOn;
        private String Company_ID;
        private String Floor_ID;
        private String Url;
        private boolean IsCollection;
        private int CarCount;

        public boolean isCollection() {
            return IsCollection;
        }

        public void setCollection(boolean collection) {
            IsCollection = collection;
        }

        public int getCarCount() {
            return CarCount;
        }

        public void setCarCount(int carCount) {
            CarCount = carCount;
        }

        public String getUrl() {
            return Url;
        }

        public void setUrl(String url) {
            Url = url;
        }

        public String getIntegerGoods_ID() {
            return IntegerGoods_ID;
        }

        public void setIntegerGoods_ID(String IntegerGoods_ID) {
            this.IntegerGoods_ID = IntegerGoods_ID;
        }

        public String getIntegerGoods_Name() {
            return IntegerGoods_Name;
        }

        public void setIntegerGoods_Name(String IntegerGoods_Name) {
            this.IntegerGoods_Name = IntegerGoods_Name;
        }

        public String getIntegerGoods_ImgPath() {
            return IntegerGoods_ImgPath;
        }

        public void setIntegerGoods_ImgPath(String IntegerGoods_ImgPath) {
            this.IntegerGoods_ImgPath = IntegerGoods_ImgPath;
        }

        public String getIntegerGoodsType_ID() {
            return IntegerGoodsType_ID;
        }

        public void setIntegerGoodsType_ID(String IntegerGoodsType_ID) {
            this.IntegerGoodsType_ID = IntegerGoodsType_ID;
        }

        public Object getIntegerGoods_SaleContent() {
            return IntegerGoods_SaleContent;
        }

        public void setIntegerGoods_SaleContent(Object IntegerGoods_SaleContent) {
            this.IntegerGoods_SaleContent = IntegerGoods_SaleContent;
        }

        public int getIntegerGoods_Sort() {
            return IntegerGoods_Sort;
        }

        public void setIntegerGoods_Sort(int IntegerGoods_Sort) {
            this.IntegerGoods_Sort = IntegerGoods_Sort;
        }

        public int getIntegerGoods_Integer() {
            return IntegerGoods_Integer;
        }

        public void setIntegerGoods_Integer(int IntegerGoods_Integer) {
            this.IntegerGoods_Integer = IntegerGoods_Integer;
        }

        public boolean isIntegerGoods_IsOn() {
            return IntegerGoods_IsOn;
        }

        public void setIntegerGoods_IsOn(boolean IntegerGoods_IsOn) {
            this.IntegerGoods_IsOn = IntegerGoods_IsOn;
        }

        public String getCompany_ID() {
            return Company_ID;
        }

        public void setCompany_ID(String Company_ID) {
            this.Company_ID = Company_ID;
        }

        public String getFloor_ID() {
            return Floor_ID;
        }

        public void setFloor_ID(String Floor_ID) {
            this.Floor_ID = Floor_ID;
        }
    }
}
