package com.whmnrc.carpartsshow.model.http.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lizhe on 2018/3/15.
 */

public class CollectionBean implements Serializable {


    private List<CollectionListProductBean> CollectionListProduct;

    public List<CollectionListProductBean> getCollectionListProduct() {
        return CollectionListProduct;
    }

    public void setCollectionListProduct(List<CollectionListProductBean> CollectionListProduct) {
        this.CollectionListProduct = CollectionListProduct;
    }

    public static class CollectionListProductBean {
        /**
         * Collection_ID : 65e10215-38ba-4534-9b30-f5d4b8f8af0b
         * Collection_Type : 0
         * UserInfo_ID : ddeqwdq
         * Collection_ProductID : 001d9af4-5a4b-4d24-8fff-925ade334d49
         * Collection_CreateTime : 2018-02-06T14:38:09.167
         * Price : 15
         * Name : PL5149	广汽传祺GA5 F 前刹车片
         * ImagePath : http://zpk.jscxqp.com//UploadFiles/Goods/G0000018243/b414d5fd6f2d4021874c077c23843b27.JPG
         */

        private String Collection_ID;
        private int Collection_Type;
        private String UserInfo_ID;
        private String Collection_ProductID;
        private String Collection_CreateTime;
        private int Price;
        private String Name;
        private String ImagePath;
        private boolean select;
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

        public boolean isSelect() {
            return select;
        }

        public void setSelect(boolean select) {
            this.select = select;
        }

        public String getCollection_ID() {
            return Collection_ID;
        }

        public void setCollection_ID(String Collection_ID) {
            this.Collection_ID = Collection_ID;
        }

        public int getCollection_Type() {
            return Collection_Type;
        }

        public void setCollection_Type(int Collection_Type) {
            this.Collection_Type = Collection_Type;
        }

        public String getUserInfo_ID() {
            return UserInfo_ID;
        }

        public void setUserInfo_ID(String UserInfo_ID) {
            this.UserInfo_ID = UserInfo_ID;
        }

        public String getCollection_ProductID() {
            return Collection_ProductID;
        }

        public void setCollection_ProductID(String Collection_ProductID) {
            this.Collection_ProductID = Collection_ProductID;
        }

        public String getCollection_CreateTime() {
            return Collection_CreateTime;
        }

        public void setCollection_CreateTime(String Collection_CreateTime) {
            this.Collection_CreateTime = Collection_CreateTime;
        }

        public int getPrice() {
            return Price;
        }

        public void setPrice(int Price) {
            this.Price = Price;
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
    }
}
