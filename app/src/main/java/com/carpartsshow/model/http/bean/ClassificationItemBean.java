package com.carpartsshow.model.http.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lizhe on 2018/3/26.
 */

public class ClassificationItemBean implements Parcelable {



    /**
     * ID : 83
     * Code : A3M
     * Step : 2
     * ParentID : 12
     * Name : 3M胶
     * Enabled : true
     * Consumable : false
     * IsGoodsCategory : true
     * OrderID : 0
     * GCode : 003MJ
     * Company_ID : 0465ad54-ef0a-401f-a4a8-1072fa544da2
     * Category_ID : 518bb883-ab9c-48f4-9360-54b4a92ffa10
     * Category_Code : A3M
     * Category_ImgPath : http://zpk.jscxqp.com/
     * Category_FirstCode : null
     * Category_ChooseOn : null
     * Category_ChooseOff : null
     * Category_FirstImgPath : http://zpk.jscxqp.com/
     * UniversalParts : true
     */

    private int ID;
    private String Code;
    private String Name;
    private int ParentID;
    private boolean Enabled;
    private boolean Consumable;
    private boolean IsGoodsCategory;
    private String GCode;
    private String Company_ID;
    private String Category_ID;
    private String Category_Code;
    private String Category_ImgPath;
    private Object Category_FirstCode;
    private Object Category_ChooseOn;
    private Object Category_ChooseOff;
    private String Category_FirstImgPath;
    private boolean UniversalParts;
    List<ClassificationItem2Bean> list;

    protected ClassificationItemBean(Parcel in) {
        ID = in.readInt();
        Code = in.readString();
        Name = in.readString();
        ParentID = in.readInt();
        Enabled = in.readByte() != 0;
        Consumable = in.readByte() != 0;
        IsGoodsCategory = in.readByte() != 0;
        GCode = in.readString();
        Company_ID = in.readString();
        Category_ID = in.readString();
        Category_Code = in.readString();
        Category_ImgPath = in.readString();
        Category_FirstImgPath = in.readString();
        UniversalParts = in.readByte() != 0;
    }

    public static final Creator<ClassificationItemBean> CREATOR = new Creator<ClassificationItemBean>() {
        @Override
        public ClassificationItemBean createFromParcel(Parcel in) {
            return new ClassificationItemBean(in);
        }

        @Override
        public ClassificationItemBean[] newArray(int size) {
            return new ClassificationItemBean[size];
        }
    };

    public List<ClassificationItem2Bean> getList() {
        return list;
    }

    public void setList(List<ClassificationItem2Bean> list) {
        this.list = list;
    }

    public int getParentID() {
        return ParentID;
    }

    public void setParentID(int parentID) {
        ParentID = parentID;
    }

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

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public boolean isEnabled() {
        return Enabled;
    }

    public void setEnabled(boolean Enabled) {
        this.Enabled = Enabled;
    }

    public boolean isConsumable() {
        return Consumable;
    }

    public void setConsumable(boolean Consumable) {
        this.Consumable = Consumable;
    }

    public boolean isIsGoodsCategory() {
        return IsGoodsCategory;
    }

    public void setIsGoodsCategory(boolean IsGoodsCategory) {
        this.IsGoodsCategory = IsGoodsCategory;
    }

    public String getGCode() {
        return GCode;
    }

    public void setGCode(String GCode) {
        this.GCode = GCode;
    }

    public String getCompany_ID() {
        return Company_ID;
    }

    public void setCompany_ID(String Company_ID) {
        this.Company_ID = Company_ID;
    }

    public String getCategory_ID() {
        return Category_ID;
    }

    public void setCategory_ID(String Category_ID) {
        this.Category_ID = Category_ID;
    }

    public String getCategory_Code() {
        return Category_Code;
    }

    public void setCategory_Code(String Category_Code) {
        this.Category_Code = Category_Code;
    }

    public String getCategory_ImgPath() {
        return Category_ImgPath;
    }

    public void setCategory_ImgPath(String Category_ImgPath) {
        this.Category_ImgPath = Category_ImgPath;
    }

    public Object getCategory_FirstCode() {
        return Category_FirstCode;
    }

    public void setCategory_FirstCode(Object Category_FirstCode) {
        this.Category_FirstCode = Category_FirstCode;
    }

    public Object getCategory_ChooseOn() {
        return Category_ChooseOn;
    }

    public void setCategory_ChooseOn(Object Category_ChooseOn) {
        this.Category_ChooseOn = Category_ChooseOn;
    }

    public Object getCategory_ChooseOff() {
        return Category_ChooseOff;
    }

    public void setCategory_ChooseOff(Object Category_ChooseOff) {
        this.Category_ChooseOff = Category_ChooseOff;
    }

    public String getCategory_FirstImgPath() {
        return Category_FirstImgPath;
    }

    public void setCategory_FirstImgPath(String Category_FirstImgPath) {
        this.Category_FirstImgPath = Category_FirstImgPath;
    }

    public boolean isUniversalParts() {
        return UniversalParts;
    }

    public void setUniversalParts(boolean UniversalParts) {
        this.UniversalParts = UniversalParts;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(ID);
        dest.writeString(Code);
        dest.writeString(Name);
        dest.writeInt(ParentID);
        dest.writeByte((byte) (Enabled ? 1 : 0));
        dest.writeByte((byte) (Consumable ? 1 : 0));
        dest.writeByte((byte) (IsGoodsCategory ? 1 : 0));
        dest.writeString(GCode);
        dest.writeString(Company_ID);
        dest.writeString(Category_ID);
        dest.writeString(Category_Code);
        dest.writeString(Category_ImgPath);
        dest.writeString(Category_FirstImgPath);
        dest.writeByte((byte) (UniversalParts ? 1 : 0));
    }


    public static class ClassificationItem2Bean implements Parcelable{
        private int ID;
        private String Code;
        private String Name;
        private boolean Enabled;
        private boolean Consumable;
        private boolean IsGoodsCategory;
        private String GCode;
        private String Company_ID;
        private String Category_ID;
        private String Category_Code;
        private String Category_ImgPath;
        private Object Category_FirstCode;
        private Object Category_ChooseOn;
        private Object Category_ChooseOff;
        private String Category_FirstImgPath;
        private boolean UniversalParts;

        protected ClassificationItem2Bean(Parcel in) {
            ID = in.readInt();
            Code = in.readString();
            Name = in.readString();
            Enabled = in.readByte() != 0;
            Consumable = in.readByte() != 0;
            IsGoodsCategory = in.readByte() != 0;
            GCode = in.readString();
            Company_ID = in.readString();
            Category_ID = in.readString();
            Category_Code = in.readString();
            Category_ImgPath = in.readString();
            Category_FirstImgPath = in.readString();
            UniversalParts = in.readByte() != 0;
        }

        public static final Creator<ClassificationItem2Bean> CREATOR = new Creator<ClassificationItem2Bean>() {
            @Override
            public ClassificationItem2Bean createFromParcel(Parcel in) {
                return new ClassificationItem2Bean(in);
            }

            @Override
            public ClassificationItem2Bean[] newArray(int size) {
                return new ClassificationItem2Bean[size];
            }
        };

        public int getID() {
            return ID;
        }

        public void setID(int ID) {
            this.ID = ID;
        }

        public String getCode() {
            return Code;
        }

        public void setCode(String code) {
            Code = code;
        }

        public String getName() {
            return Name;
        }

        public void setName(String name) {
            Name = name;
        }

        public boolean isEnabled() {
            return Enabled;
        }

        public void setEnabled(boolean enabled) {
            Enabled = enabled;
        }

        public boolean isConsumable() {
            return Consumable;
        }

        public void setConsumable(boolean consumable) {
            Consumable = consumable;
        }

        public boolean isGoodsCategory() {
            return IsGoodsCategory;
        }

        public void setGoodsCategory(boolean goodsCategory) {
            IsGoodsCategory = goodsCategory;
        }

        public void setGCode(String GCode) {
            this.GCode = GCode;
        }

        public String getCompany_ID() {
            return Company_ID;
        }

        public void setCompany_ID(String company_ID) {
            Company_ID = company_ID;
        }

        public String getCategory_ID() {
            return Category_ID;
        }

        public void setCategory_ID(String category_ID) {
            Category_ID = category_ID;
        }

        public String getCategory_Code() {
            return Category_Code;
        }

        public void setCategory_Code(String category_Code) {
            Category_Code = category_Code;
        }

        public String getCategory_ImgPath() {
            return Category_ImgPath;
        }

        public void setCategory_ImgPath(String category_ImgPath) {
            Category_ImgPath = category_ImgPath;
        }

        public Object getCategory_FirstCode() {
            return Category_FirstCode;
        }

        public void setCategory_FirstCode(Object category_FirstCode) {
            Category_FirstCode = category_FirstCode;
        }

        public Object getCategory_ChooseOn() {
            return Category_ChooseOn;
        }

        public void setCategory_ChooseOn(Object category_ChooseOn) {
            Category_ChooseOn = category_ChooseOn;
        }

        public Object getCategory_ChooseOff() {
            return Category_ChooseOff;
        }

        public void setCategory_ChooseOff(Object category_ChooseOff) {
            Category_ChooseOff = category_ChooseOff;
        }

        public String getCategory_FirstImgPath() {
            return Category_FirstImgPath;
        }

        public void setCategory_FirstImgPath(String category_FirstImgPath) {
            Category_FirstImgPath = category_FirstImgPath;
        }

        public boolean isUniversalParts() {
            return UniversalParts;
        }

        public void setUniversalParts(boolean universalParts) {
            UniversalParts = universalParts;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(ID);
            dest.writeString(Code);
            dest.writeString(Name);
            dest.writeByte((byte) (Enabled ? 1 : 0));
            dest.writeByte((byte) (Consumable ? 1 : 0));
            dest.writeByte((byte) (IsGoodsCategory ? 1 : 0));
            dest.writeString(GCode);
            dest.writeString(Company_ID);
            dest.writeString(Category_ID);
            dest.writeString(Category_Code);
            dest.writeString(Category_ImgPath);
            dest.writeString(Category_FirstImgPath);
            dest.writeByte((byte) (UniversalParts ? 1 : 0));
        }
    }
}
