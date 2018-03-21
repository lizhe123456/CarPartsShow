package com.carpartsshow.model.http.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lizhe on 2018/3/15.
 */

public class AddressBean implements Serializable {


    /**
     * resultdata : [{"AreaId":"120100","ParentId":"120000","AreaCode":"120100","AreaName":"天津市","QuickQuery":"TianJinShi","SimpleSpelling":"tjs","Layer":2,"SortCode":120100,"DeleteMark":0,"EnabledMark":1,"Description":null,"CreateDate":"2015-11-16T14:34:41.633","CreateUserId":"System","CreateUserName":"超级管理员","ModifyDate":null,"ModifyUserId":null,"ModifyUserName":null}]
     * type : 1
     * errorcode : 0
     * message : 操作成功。
     */

    private int type;
    private int errorcode;
    private String message;
    private List<ResultdataBean> resultdata;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getErrorcode() {
        return errorcode;
    }

    public void setErrorcode(int errorcode) {
        this.errorcode = errorcode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<ResultdataBean> getResultdata() {
        return resultdata;
    }

    public void setResultdata(List<ResultdataBean> resultdata) {
        this.resultdata = resultdata;
    }

    public static class ResultdataBean {
        /**
         * AreaId : 120100
         * ParentId : 120000
         * AreaCode : 120100
         * AreaName : 天津市
         * QuickQuery : TianJinShi
         * SimpleSpelling : tjs
         * Layer : 2
         * SortCode : 120100
         * DeleteMark : 0
         * EnabledMark : 1
         * Description : null
         * CreateDate : 2015-11-16T14:34:41.633
         * CreateUserId : System
         * CreateUserName : 超级管理员
         * ModifyDate : null
         * ModifyUserId : null
         * ModifyUserName : null
         */

        private String AreaId;
        private String ParentId;
        private String AreaCode;
        private String AreaName;
        private String QuickQuery;
        private String SimpleSpelling;
        private int Layer;
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
        private boolean select;

        public boolean isSelect() {
            return select;
        }

        public void setSelect(boolean select) {
            this.select = select;
        }

        public String getAreaId() {
            return AreaId;
        }

        public void setAreaId(String AreaId) {
            this.AreaId = AreaId;
        }

        public String getParentId() {
            return ParentId;
        }

        public void setParentId(String ParentId) {
            this.ParentId = ParentId;
        }

        public String getAreaCode() {
            return AreaCode;
        }

        public void setAreaCode(String AreaCode) {
            this.AreaCode = AreaCode;
        }

        public String getAreaName() {
            return AreaName;
        }

        public void setAreaName(String AreaName) {
            this.AreaName = AreaName;
        }

        public String getQuickQuery() {
            return QuickQuery;
        }

        public void setQuickQuery(String QuickQuery) {
            this.QuickQuery = QuickQuery;
        }

        public String getSimpleSpelling() {
            return SimpleSpelling;
        }

        public void setSimpleSpelling(String SimpleSpelling) {
            this.SimpleSpelling = SimpleSpelling;
        }

        public int getLayer() {
            return Layer;
        }

        public void setLayer(int Layer) {
            this.Layer = Layer;
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
