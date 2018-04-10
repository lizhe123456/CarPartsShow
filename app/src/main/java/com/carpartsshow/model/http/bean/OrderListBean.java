package com.carpartsshow.model.http.bean;

import java.util.List;

/**
 * Created by lizhe on 2018/3/31.
 */

public class OrderListBean {


    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * Order_ID : 130d1d8f-7906-4b53-9da7-8d4fa900a195
         * Order_No : E4994679888235
         * UserInfo_ID : ddeqwdq
         * UserInfo_ParentID : null
         * Order_PayNo : P4994679888235
         * Order_CreateTime : 2018-03-30 16:43
         * Order_PayTime : 2018-03-30T16:43:57.22
         * Address_Name : 小李
         * Address_Mobile : 15971486093
         * Address_FullAddress : 大山滴子孙哟~爱太阳咯~太阳下的影子哟。山里滴城哟
         * Order_PayType : 2
         * Order_State : 1
         * Order_Integer : 0
         * Order_PayInteger : 0
         * Order_CouponMoney : 0
         * Order_Money : 45
         * ORder_Freight : 0
         * Order_Seed : 32
         * Order_Remark : null
         * Company_ID : 0465ad54-ef0a-401f-a4a8-1072fa544da2
         * Order_IsUrgent : true
         * Order_IsUseCompanyName : false
         * detail : [{"OrderItem_ID":"cb7e77a5-3fa2-4fb5-b472-f447ec5140c0","Product_ID":"000dc86c-c674-4591-84ff-e3ec9327f2b3","Product_Name":"P50102\t\t前刹车片","Product_Type":0,"Product_ImgPath":"http://zpk.jscxqp.com//UploadFiles/Goods/G0000014709/9e66820848874bf988d814d92db8c24c.jpg","Product_Price":15,"OrderItem_Integer":0,"OrderItem_Number":3,"OrderItem_Money":45,"Order_ID":"130d1d8f-7906-4b53-9da7-8d4fa900a195"}]
         */

        private String Order_ID;
        private String Order_No;
        private String UserInfo_ID;
        private Object UserInfo_ParentID;
        private String Order_PayNo;
        private String Order_CreateTime;
        private String Order_PayTime;
        private String Address_Name;
        private String Address_Mobile;
        private String Address_FullAddress;
        private int Order_PayType;
        private int Order_State;
        private int Order_Integer;
        private int Order_PayInteger;
        private int Order_CouponMoney;
        private int Order_Money;
        private int ORder_Freight;
        private int Order_Seed;
        private Object Order_Remark;
        private String Company_ID;
        private boolean Order_IsUrgent;
        private boolean Order_IsUseCompanyName;
        private List<DetailBean> detail;

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

        public String getUserInfo_ID() {
            return UserInfo_ID;
        }

        public void setUserInfo_ID(String UserInfo_ID) {
            this.UserInfo_ID = UserInfo_ID;
        }

        public Object getUserInfo_ParentID() {
            return UserInfo_ParentID;
        }

        public void setUserInfo_ParentID(Object UserInfo_ParentID) {
            this.UserInfo_ParentID = UserInfo_ParentID;
        }

        public String getOrder_PayNo() {
            return Order_PayNo;
        }

        public void setOrder_PayNo(String Order_PayNo) {
            this.Order_PayNo = Order_PayNo;
        }

        public String getOrder_CreateTime() {
            return Order_CreateTime;
        }

        public void setOrder_CreateTime(String Order_CreateTime) {
            this.Order_CreateTime = Order_CreateTime;
        }

        public String getOrder_PayTime() {
            return Order_PayTime;
        }

        public void setOrder_PayTime(String Order_PayTime) {
            this.Order_PayTime = Order_PayTime;
        }

        public String getAddress_Name() {
            return Address_Name;
        }

        public void setAddress_Name(String Address_Name) {
            this.Address_Name = Address_Name;
        }

        public String getAddress_Mobile() {
            return Address_Mobile;
        }

        public void setAddress_Mobile(String Address_Mobile) {
            this.Address_Mobile = Address_Mobile;
        }

        public String getAddress_FullAddress() {
            return Address_FullAddress;
        }

        public void setAddress_FullAddress(String Address_FullAddress) {
            this.Address_FullAddress = Address_FullAddress;
        }

        public int getOrder_PayType() {
            return Order_PayType;
        }

        public void setOrder_PayType(int Order_PayType) {
            this.Order_PayType = Order_PayType;
        }

        public int getOrder_State() {
            return Order_State;
        }

        public void setOrder_State(int Order_State) {
            this.Order_State = Order_State;
        }

        public int getOrder_Integer() {
            return Order_Integer;
        }

        public void setOrder_Integer(int Order_Integer) {
            this.Order_Integer = Order_Integer;
        }

        public int getOrder_PayInteger() {
            return Order_PayInteger;
        }

        public void setOrder_PayInteger(int Order_PayInteger) {
            this.Order_PayInteger = Order_PayInteger;
        }

        public int getOrder_CouponMoney() {
            return Order_CouponMoney;
        }

        public void setOrder_CouponMoney(int Order_CouponMoney) {
            this.Order_CouponMoney = Order_CouponMoney;
        }

        public int getOrder_Money() {
            return Order_Money;
        }

        public void setOrder_Money(int Order_Money) {
            this.Order_Money = Order_Money;
        }

        public int getORder_Freight() {
            return ORder_Freight;
        }

        public void setORder_Freight(int ORder_Freight) {
            this.ORder_Freight = ORder_Freight;
        }

        public int getOrder_Seed() {
            return Order_Seed;
        }

        public void setOrder_Seed(int Order_Seed) {
            this.Order_Seed = Order_Seed;
        }

        public Object getOrder_Remark() {
            return Order_Remark;
        }

        public void setOrder_Remark(Object Order_Remark) {
            this.Order_Remark = Order_Remark;
        }

        public String getCompany_ID() {
            return Company_ID;
        }

        public void setCompany_ID(String Company_ID) {
            this.Company_ID = Company_ID;
        }

        public boolean isOrder_IsUrgent() {
            return Order_IsUrgent;
        }

        public void setOrder_IsUrgent(boolean Order_IsUrgent) {
            this.Order_IsUrgent = Order_IsUrgent;
        }

        public boolean isOrder_IsUseCompanyName() {
            return Order_IsUseCompanyName;
        }

        public void setOrder_IsUseCompanyName(boolean Order_IsUseCompanyName) {
            this.Order_IsUseCompanyName = Order_IsUseCompanyName;
        }

        public List<DetailBean> getDetail() {
            return detail;
        }

        public void setDetail(List<DetailBean> detail) {
            this.detail = detail;
        }

        public static class DetailBean {
            /**
             * OrderItem_ID : cb7e77a5-3fa2-4fb5-b472-f447ec5140c0
             * Product_ID : 000dc86c-c674-4591-84ff-e3ec9327f2b3
             * Product_Name : P50102		前刹车片
             * Product_Type : 0
             * Product_ImgPath : http://zpk.jscxqp.com//UploadFiles/Goods/G0000014709/9e66820848874bf988d814d92db8c24c.jpg
             * Product_Price : 15
             * OrderItem_Integer : 0
             * OrderItem_Number : 3
             * OrderItem_Money : 45
             * Order_ID : 130d1d8f-7906-4b53-9da7-8d4fa900a195
             */

            private String OrderItem_ID;
            private String Product_ID;
            private String Product_Name;
            private int Product_Type;
            private String Product_ImgPath;
            private int Product_Price;
            private int OrderItem_Integer;
            private int OrderItem_Number;
            private int OrderItem_Money;
            private String Order_ID;
            private String Url;

            public String getUrl() {
                return Url;
            }

            public void setUrl(String url) {
                Url = url;
            }

            public String getOrderItem_ID() {
                return OrderItem_ID;
            }

            public void setOrderItem_ID(String OrderItem_ID) {
                this.OrderItem_ID = OrderItem_ID;
            }

            public String getProduct_ID() {
                return Product_ID;
            }

            public void setProduct_ID(String Product_ID) {
                this.Product_ID = Product_ID;
            }

            public String getProduct_Name() {
                return Product_Name;
            }

            public void setProduct_Name(String Product_Name) {
                this.Product_Name = Product_Name;
            }

            public int getProduct_Type() {
                return Product_Type;
            }

            public void setProduct_Type(int Product_Type) {
                this.Product_Type = Product_Type;
            }

            public String getProduct_ImgPath() {
                return Product_ImgPath;
            }

            public void setProduct_ImgPath(String Product_ImgPath) {
                this.Product_ImgPath = Product_ImgPath;
            }

            public int getProduct_Price() {
                return Product_Price;
            }

            public void setProduct_Price(int Product_Price) {
                this.Product_Price = Product_Price;
            }

            public int getOrderItem_Integer() {
                return OrderItem_Integer;
            }

            public void setOrderItem_Integer(int OrderItem_Integer) {
                this.OrderItem_Integer = OrderItem_Integer;
            }

            public int getOrderItem_Number() {
                return OrderItem_Number;
            }

            public void setOrderItem_Number(int OrderItem_Number) {
                this.OrderItem_Number = OrderItem_Number;
            }

            public int getOrderItem_Money() {
                return OrderItem_Money;
            }

            public void setOrderItem_Money(int OrderItem_Money) {
                this.OrderItem_Money = OrderItem_Money;
            }

            public String getOrder_ID() {
                return Order_ID;
            }

            public void setOrder_ID(String Order_ID) {
                this.Order_ID = Order_ID;
            }
        }
    }
}
