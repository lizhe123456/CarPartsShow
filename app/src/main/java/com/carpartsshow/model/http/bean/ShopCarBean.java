package com.carpartsshow.model.http.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lizhe on 2018/3/20.
 */

public class ShopCarBean implements Serializable {


    /**
     * ListCarProduct : [{"BuyCar_ID":"b2639c9c-a26d-434f-997a-65d07be9d12b","Product_ID":"0014031c-2877-422c-9428-a307f8d86923","UserInfo_ID":"ddeqwdq","BuyCar_Num":1,"BuyCar_CreateDate":"2018-03-20T18:44:20.153","Product_Type":0,"Price":15,"Name":"XYA-2615U\t福特全顺汽油车/XYA-2615U/K3320-3000\t空气滤芯","ImagePath":"http://zpk.jscxqp.com//UploadFiles/Goods/G0000015767/e7461a3c06904ffe8b01525c5d4093ff.jpg"},{"BuyCar_ID":"7e0ced2e-51bb-4b93-bec4-694cf60ebf63","Product_ID":"067bf736-98d8-4cf6-89c6-c4b856a38a74","UserInfo_ID":"ddeqwdq","BuyCar_Num":1,"BuyCar_CreateDate":"2018-03-19T10:43:32.993","Product_Type":1,"Price":80,"Name":"优静 宝马3系 X1全系 无骨雨刷片571003","ImagePath":"http://zpk.jscxqp.com//Resource/PhotoFile/8c76f9bd-8154-4977-865c-9034a5ae19e9.png"},{"BuyCar_ID":"69b869d4-dfc0-4535-9d47-1c626538c1df","Product_ID":"003f467c-3422-41ef-9345-f76fd4a7cf06","UserInfo_ID":"ddeqwdq","BuyCar_Num":1,"BuyCar_CreateDate":"2018-03-12T11:22:43.073","Product_Type":0,"Price":15,"Name":"亮霸科雷傲后雨刮","ImagePath":"http://zpk.jscxqp.com//UploadFiles/GoodsBrands/4cd320be0a6a4656a5f66fc2e4ebd37f.jpg"},{"BuyCar_ID":"d331ecec-937a-4906-81cf-c7a9c332fb11","Product_ID":"008e26d0-2dae-4c1b-b395-557ca668834f","UserInfo_ID":"ddeqwdq","BuyCar_Num":5,"BuyCar_CreateDate":"2018-03-12T11:14:21.053","Product_Type":0,"Price":15,"Name":"蓝标 80D26R( 6-QW-70 D26-70-R-T2-M)","ImagePath":"http://zpk.jscxqp.com//UploadFiles/Goods/G0000001607/174201b5c2584589925bfc2ccd39e87e.jpg"},{"BuyCar_ID":"dde26fb6-32f4-4ff7-970f-95e7e73f228f","Product_ID":"450628a9-aa5f-48a8-99f2-32ba3faf6952","UserInfo_ID":"ddeqwdq","BuyCar_Num":1,"BuyCar_CreateDate":"2018-03-12T11:11:16.627","Product_Type":2,"Price":1200,"Name":"生命之源特级初榨橄榄油1L","ImagePath":"http://zpk.jscxqp.com//Resource/PhotoFile/6ea7d1b6-10a9-4d4e-a554-443b1a06a62f.jpg"},{"BuyCar_ID":"aa1aa68e-01ed-4ea0-aca1-56bd5a7048e3","Product_ID":"069b8c99-4777-42b7-9942-1d77f0e5107e","UserInfo_ID":"ddeqwdq","BuyCar_Num":4,"BuyCar_CreateDate":"2018-03-12T11:01:31.26","Product_Type":0,"Price":15,"Name":"空调滤芯 FP26010","ImagePath":"http://zpk.jscxqp.com//UploadFiles/Goods/G0000011287/e20ff74e9e1949e8b2ec5c88788cfffe.jpg"}]
     * CompanyHandle : {"Company_ID":"0465ad54-ef0a-401f-a4a8-1072fa544da2","RepairUser_SCode":"123123","IsLogin":true,"NotLoggedInWord":"会员登录看价","NotLoggedInSign":"--"}
     */

    private CompanyHandleBean CompanyHandle;
    private List<ListCarProductBean> ListCarProduct;

    public CompanyHandleBean getCompanyHandle() {
        return CompanyHandle;
    }

    public void setCompanyHandle(CompanyHandleBean CompanyHandle) {
        this.CompanyHandle = CompanyHandle;
    }

    public List<ListCarProductBean> getListCarProduct() {
        return ListCarProduct;
    }

    public void setListCarProduct(List<ListCarProductBean> ListCarProduct) {
        this.ListCarProduct = ListCarProduct;
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

    public static class ListCarProductBean {
        /**
         * BuyCar_ID : b2639c9c-a26d-434f-997a-65d07be9d12b
         * Product_ID : 0014031c-2877-422c-9428-a307f8d86923
         * UserInfo_ID : ddeqwdq
         * BuyCar_Num : 1
         * BuyCar_CreateDate : 2018-03-20T18:44:20.153
         * Product_Type : 0
         * Price : 15
         * Name : XYA-2615U	福特全顺汽油车/XYA-2615U/K3320-3000	空气滤芯
         * ImagePath : http://zpk.jscxqp.com//UploadFiles/Goods/G0000015767/e7461a3c06904ffe8b01525c5d4093ff.jpg
         */

        private String BuyCar_ID;
        private String Product_ID;
        private String UserInfo_ID;
        private int BuyCar_Num;
        private String BuyCar_CreateDate;
        private int Product_Type;
        private int Price;
        private String Name;
        private String ImagePath;

        public String getBuyCar_ID() {
            return BuyCar_ID;
        }

        public void setBuyCar_ID(String BuyCar_ID) {
            this.BuyCar_ID = BuyCar_ID;
        }

        public String getProduct_ID() {
            return Product_ID;
        }

        public void setProduct_ID(String Product_ID) {
            this.Product_ID = Product_ID;
        }

        public String getUserInfo_ID() {
            return UserInfo_ID;
        }

        public void setUserInfo_ID(String UserInfo_ID) {
            this.UserInfo_ID = UserInfo_ID;
        }

        public int getBuyCar_Num() {
            return BuyCar_Num;
        }

        public void setBuyCar_Num(int BuyCar_Num) {
            this.BuyCar_Num = BuyCar_Num;
        }

        public String getBuyCar_CreateDate() {
            return BuyCar_CreateDate;
        }

        public void setBuyCar_CreateDate(String BuyCar_CreateDate) {
            this.BuyCar_CreateDate = BuyCar_CreateDate;
        }

        public int getProduct_Type() {
            return Product_Type;
        }

        public void setProduct_Type(int Product_Type) {
            this.Product_Type = Product_Type;
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
