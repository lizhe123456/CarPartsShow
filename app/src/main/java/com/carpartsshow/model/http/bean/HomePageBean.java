package com.carpartsshow.model.http.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by lizhe on 2018/3/20.
 * 首页实体
 */

public class HomePageBean implements Serializable {


    /**
     * IsLogin : true
     * NotLoggedInWord : 会员登录看价
     */

    private boolean IsLogin;
    private String NotLoggedInWord;
    private List<BannerBean> Banner;
    private List<OfferNarBean> OfferNar;
    private List<PoopNarBean> PoopNar;
    private List<ListNoticeBean> ListNotice;
    private List<ListFirstCategoryBean> ListFirstCategory;
    private List<ListSeckillGoodsBean> ListSeckillGoods;
    private List<ListCradBean> ListCrad;
    private List<ListCardImg> ListCardImg;
    private List<ListDateItemBean> ListDateItem;
    private List<SpecialOfferBean> specialOfferBeans;
    private TimeLimit timeLimit;


    public List<SpecialOfferBean> getSpecialOfferBeans() {
        return specialOfferBeans;
    }

    public void setSpecialOfferBeans(List<SpecialOfferBean> specialOfferBeans) {
        this.specialOfferBeans = specialOfferBeans;
    }

    public TimeLimit getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(TimeLimit timeLimit) {
        this.timeLimit = timeLimit;
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

    public List<BannerBean> getBanner() {
        return Banner;
    }

    public void setBanner(List<BannerBean> Banner) {
        this.Banner = Banner;
    }

    public List<OfferNarBean> getOfferNar() {
        return OfferNar;
    }

    public void setOfferNar(List<OfferNarBean> OfferNar) {
        this.OfferNar = OfferNar;
    }

    public List<PoopNarBean> getPoopNar() {
        return PoopNar;
    }

    public void setPoopNar(List<PoopNarBean> PoopNar) {
        this.PoopNar = PoopNar;
    }

    public List<ListNoticeBean> getListNotice() {
        return ListNotice;
    }

    public void setListNotice(List<ListNoticeBean> ListNotice) {
        this.ListNotice = ListNotice;
    }

    public List<ListFirstCategoryBean> getListFirstCategory() {
        return ListFirstCategory;
    }

    public void setListFirstCategory(List<ListFirstCategoryBean> ListFirstCategory) {
        this.ListFirstCategory = ListFirstCategory;
    }

    public List<ListSeckillGoodsBean> getListSeckillGoods() {
        return ListSeckillGoods;
    }

    public void setListSeckillGoods(List<ListSeckillGoodsBean> ListSeckillGoods) {
        this.ListSeckillGoods = ListSeckillGoods;
    }

    public List<ListCradBean> getListCrad() {
        return ListCrad;
    }

    public void setListCrad(List<ListCradBean> ListCrad) {
        this.ListCrad = ListCrad;
    }

    public List<ListCardImg> getListCardImg() {
        return ListCardImg;
    }

    public void setListCardImg(List<ListCardImg> ListCardImg) {
        this.ListCardImg = ListCardImg;
    }

    public List<ListDateItemBean> getListDateItem() {
        return ListDateItem;
    }

    public void setListDateItem(List<ListDateItemBean> ListDateItem) {
        this.ListDateItem = ListDateItem;
    }

    public class TimeLimit{
        private Date date;

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }
    }

    public static class BannerBean {
        /**
         * Banner_ID : 900cd0ff-c71e-4590-9f22-80b735042335
         * Banner_WxAppImgPath : http://zpk.jscxqp.com//Resource/PhotoFile/d8909ef0-d4df-4e80-9441-fa509de395bb.jpg
         * Banner_PcImgPath : /Resource/PhotoFile/ec57b706-4c86-4a14-8c41-46a4c8acc80c.jpg
         * Banner_WxLinkUrl : #
         * Banner_PcLikUrl : #
         * Category : 首页
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

    public static class OfferNarBean {
        /**
         * Banner_ID : 0027ef02-4e47-4bb7-ad83-08a8fedc1763
         * Banner_WxAppImgPath : http://zpk.jscxqp.com//Resource/PhotoFile/fc4a9bf5-ca3a-4db3-bf63-0e22145a98b4.jpg
         * Banner_PcImgPath : null
         * Banner_WxLinkUrl : http://zpk.jscxqp.com/HomeWxZPK/SeckillGoodsDetail?Seckill_ID=c7c3ca4b-b2e7-49a7-a8cd-1e769b409da2
         * Banner_PcLikUrl : 1
         * Category : 天天特价
         * Banner_Sort : 99
         * Company_ID : 0465ad54-ef0a-401f-a4a8-1072fa544da2
         */

        private String Banner_ID;
        private String Banner_WxAppImgPath;
        private Object Banner_PcImgPath;
        private String Banner_WxLinkUrl;
        private String Banner_PcLikUrl;
        private String Category;
        private int Banner_Sort;
        private String Company_ID;
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

        public Object getBanner_PcImgPath() {
            return Banner_PcImgPath;
        }

        public void setBanner_PcImgPath(Object Banner_PcImgPath) {
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

    public static class SpecialOfferBean implements Serializable{
        private String Banner_ID;
        private String Category;
        private String Company_ID;
        private String Banner_WxAppImgPath;
        private String Banner_PcLikUrl;
        private int Banner_Sort;
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

        public String getBanner_ID() {
            return Banner_ID;
        }

        public void setBanner_ID(String banner_ID) {
            Banner_ID = banner_ID;
        }

        public String getCategory() {
            return Category;
        }

        public void setCategory(String category) {
            Category = category;
        }

        public String getCompany_ID() {
            return Company_ID;
        }

        public void setCompany_ID(String company_ID) {
            Company_ID = company_ID;
        }

        public String getBanner_WxAppImgPath() {
            return Banner_WxAppImgPath;
        }

        public void setBanner_WxAppImgPath(String banner_WxAppImgPath) {
            Banner_WxAppImgPath = banner_WxAppImgPath;
        }

        public String getBanner_PcLikUrl() {
            return Banner_PcLikUrl;
        }

        public void setBanner_PcLikUrl(String banner_PcLikUrl) {
            Banner_PcLikUrl = banner_PcLikUrl;
        }

        public int getBanner_Sort() {
            return Banner_Sort;
        }

        public void setBanner_Sort(int banner_Sort) {
            Banner_Sort = banner_Sort;
        }
    }

    public static class PoopNarBean {
        /**
         * Banner_ID : 8716da48-421a-4368-812c-ea81272af162
         * Banner_WxAppImgPath : http://zpk.jscxqp.com//Resource/PhotoFile/052d8538-5e5c-4a6f-870a-bad5c2289d8b.jpg
         * Banner_PcImgPath : null
         * Banner_WxLinkUrl : http://zpk.jscxqp.com/HomeWxZPK/SeckillGoodsDetail?Seckill_ID=c7c3ca4b-b2e7-49a7-a8cd-1e769b409da2
         * Banner_PcLikUrl : #
         * Category : 尾货清仓
         * Banner_Sort : 99
         * Company_ID : 0465ad54-ef0a-401f-a4a8-1072fa544da2
         */

        private String Banner_ID;
        private String Banner_WxAppImgPath;
        private Object Banner_PcImgPath;
        private String Banner_WxLinkUrl;
        private String Banner_PcLikUrl;
        private String Category;
        private int Banner_Sort;
        private String Company_ID;
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

        public Object getBanner_PcImgPath() {
            return Banner_PcImgPath;
        }

        public void setBanner_PcImgPath(Object Banner_PcImgPath) {
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

    public static class ListNoticeBean {
        /**
         * Notice_ID : yhtyt665
         * Notice_Title : 为这件事 中纪委7位领导密集出京
         * Notice_Describe : null
         * Notice_Seed : 7
         * Notice_ImgPaths : http://zpk.jscxqp.com//Resource/PhotoFile/760a8343-3adb-46c6-a51e-90d67ec09589.jpg
         * Notice_CreateTime : 2017-07-25T10:55:08.137
         * Notice_ReleaseTime : 2017-12-18T00:00:00
         * Notice_Source : 长安街知事
         * Notice_Content : <p class="otitle" style="margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);">（原标题：中纪委7领导密集出京，大动作！）</p><p style="margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);">今天的《中国纪检监察报》头版头条刊发了“中央纪委有关领导同志分赴地方调研”的新闻。长安街知事注意到，分赴地方调研的领导阵容十分强大——</p><p style="margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);">中央政治局委员、中央纪委副书记杨晓渡到宁夏、四川调研；</p><p style="margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);">中央纪委副书记刘金国到河北、山东调研；</p><p style="margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);">中央纪委副书记徐令义到陕西、新疆维吾尔自治区、新疆生产建设兵团调研；</p><p style="margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);">中央纪委副书记肖培到安徽、福建、江西调研；</p><p style="margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);">中央纪委常委邹加怡到陕西、甘肃、青海、湖南、广东、海南，张春生到宁夏、四川，崔鹏到黑龙江调研。</p><p style="margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);">文章提到，七位中纪委领导深入到省市县乡纪委，与纪检监察干部交流，召开座谈会听取意见建议，了解改国家监察体制改革试点工作进展情况。</p><p style="margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);">监察体制改革试点，其实从去年11月已经开始，北京、山西、浙江3省市设立各级监察委员会，从体制机制、制度建设上先行先试、探索实践，为在全国推开积累经验。</p><p style="margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);">今年11月4日，全国人大常委会通过在全国各地推开国家监察体制改革试点工作的决定。一周后，全国推开国家监察体制改革试点工作动员部署电视电话会议在太原召开，中共中央政治局常委、中央纪委书记赵乐际出席并讲话。</p><p style="margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);">直至近日，中纪委领导们密集出京，去基层了解改革试点工作进展。</p><p style="margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);">国家监察体制改革是事关全局的重大政治改革，是国家监察制度的顶层设计。兹事体大，事关反腐胜局。派出如此强大阵容去基层了解情况，因此也就不难理解了。</p><p style="margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);">中纪委的领导们具体去了哪里，其实各地媒体也已有披露。</p><p style="margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);">中央政治局委员、中纪委副书记杨晓渡在宁夏和四川调研时，先后去了宁夏回族自治区灵武市及梧桐树乡、石嘴山市及星海镇和自治区纪委机关，四川省广汉市及西外乡、成都市金牛区和省纪委机关实地考察并召开座谈会。</p><p style="margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);">杨晓渡调研时提出五项要求，包括：要进一步吃透中央精神，把准政治方向；要进一步夯实主体责任，层层传导压力；试点地区要充分借鉴北京、山西、浙江改革试点成功经验，并结合自身实际积极探索创新；要做好过渡期工作衔接，妥善处理新老业务；要抓好思想建设和人心稳定，通过做深做实思想政治工作。</p><p style="margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);">长安街知事发现，中纪委副书记调研目的地的选择，颇有讲究。</p><p style="margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);">中纪委副书记刘金国调研目的地河北，是他曾经工作过的地方。在2005年入京担任公安部副部长前，刘金国在河北政法系统工作了十余年。此次刘金国除了调研河北、山东外，还在中央纪委机关主持召开联系省区市纪委书记座谈会。</p><p style="margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);">中纪委副书记徐令义也不是第一次到陕西了。今年6月，时任中央第十一巡视组组长的他，就曾代表中央巡视组分别向陕西省委书记娄勤俭和陕西省委领导班子反馈了巡视“回头看”情况，并且指出陕西用人问题反映集中，”四风“问题依然多发的情况。此外，中纪委副书记肖培也曾给福建省委作过“学习贯彻廉洁自律准则和纪律处分条例”专题报告。</p><p style="margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);">除了了解试点的监察体制改革情况外，中纪委领导对各地区的其他重点领域也进行了调研。中央纪委常委、监察部副部长邹加怡在甘肃还调研了学习贯彻党的十九大精神、扶贫领域监督执纪问责等工作。</p><p style="margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);">在中纪委领导分赴地方调研后，各地省委纪委也进行了反馈。</p><p style="margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);">山东省近日审议市县两级监察体制改革实施方案，并且成立了17个督导组，陆续到全省17市就推进市县深化监察体制改革试点工作情况，开展集中督导。《中国纪检监察报》披露，山东省委常委、纪委书记陈辐宽为了掌握第一手情况，就曾在不与市一级政府打招呼的情况下，直接去找县一级“施工队长”了解情况。</p><p style="margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);">党委书记当好“施工队长”，纪委当好“泥瓦工匠”。黑龙江省纪委近日召开了监察体制改革试点工作座谈会，传达崔鹏同志在黑龙江调研讲话和省深化监察体制改革试点工作小组第二次会议精神等，要求严明政治纪律，对有令不行、有禁不止，对党中央、省委要求置若罔闻的，对拖延改革进程、工作进展缓慢的，对口无遮拦、说三道四、妄议改革、动摇军心的要予以问责等要求。</p><p style="margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);">除了严明纪律，还要提升转隶干部的归属感和认同感。四川省在监察体制改革的过程中认识到，干部队伍思想稳定，是试点工作顺利开展的重要前提。省、市、县三级都广泛开展了面对面、一对一全覆盖谈心谈话，增强了涉改人员的认同感、归属感。</p><p style="margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);"><br/></p><p><iframe width="300" height="250" frameborder="0"></iframe></p><p><a target="_self" class="ad_hover_href" style="color: rgb(15, 107, 153); text-decoration-line: underline; width: 30px; height: 17px; position: absolute; left: 0px; bottom: 0px; z-index: 10; background: url(&quot;http://img1.126.net/channel18/ad.png&quot;) no-repeat;"></a></p><p style="margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);">日前，中央纪委监察部网站推出了系列访谈。浙江、北京两地纪委书记先后接受采访，分享了试点国家监察体制改革的相关经验。</p><p style="margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);">浙江省委常委、纪委书记刘建超提到，最重要的还是把中央的决策部署、中央对监察体制改革的精神吃透弄懂，在实施时，要有完整的改革方案；转隶工作一定抓好，要做到机构融合、能力融合、情感融合，切实把好转隶人员的政治关、廉洁关。</p><p style="margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);">北京市委常委、纪委书记张硕辅也在中纪委访谈节目中提到，在“转隶”时做到四个注重：注重摸清转隶家底；注重各方协调联动；注重解除后顾之忧；注重把握动态平衡。保证了转隶过程的平稳、顺利进行。</p><p><br/></p>
         * Notice_Sort : 1
         * Category : 集团新闻
         */

        private String Notice_ID;
        private String Notice_Title;
        private Object Notice_Describe;
        private int Notice_Seed;
        private String Notice_ImgPaths;
        private String Notice_CreateTime;
        private String Notice_ReleaseTime;
        private String Notice_Source;
        private String Notice_Content;
        private int Notice_Sort;
        private String Category;
        private String Url;

        public String getUrl() {
            return Url;
        }

        public void setUrl(String url) {
            Url = url;
        }

        public String getNotice_ID() {
            return Notice_ID;
        }

        public void setNotice_ID(String Notice_ID) {
            this.Notice_ID = Notice_ID;
        }

        public String getNotice_Title() {
            return Notice_Title;
        }

        public void setNotice_Title(String Notice_Title) {
            this.Notice_Title = Notice_Title;
        }

        public Object getNotice_Describe() {
            return Notice_Describe;
        }

        public void setNotice_Describe(Object Notice_Describe) {
            this.Notice_Describe = Notice_Describe;
        }

        public int getNotice_Seed() {
            return Notice_Seed;
        }

        public void setNotice_Seed(int Notice_Seed) {
            this.Notice_Seed = Notice_Seed;
        }

        public String getNotice_ImgPaths() {
            return Notice_ImgPaths;
        }

        public void setNotice_ImgPaths(String Notice_ImgPaths) {
            this.Notice_ImgPaths = Notice_ImgPaths;
        }

        public String getNotice_CreateTime() {
            return Notice_CreateTime;
        }

        public void setNotice_CreateTime(String Notice_CreateTime) {
            this.Notice_CreateTime = Notice_CreateTime;
        }

        public String getNotice_ReleaseTime() {
            return Notice_ReleaseTime;
        }

        public void setNotice_ReleaseTime(String Notice_ReleaseTime) {
            this.Notice_ReleaseTime = Notice_ReleaseTime;
        }

        public String getNotice_Source() {
            return Notice_Source;
        }

        public void setNotice_Source(String Notice_Source) {
            this.Notice_Source = Notice_Source;
        }

        public String getNotice_Content() {
            return Notice_Content;
        }

        public void setNotice_Content(String Notice_Content) {
            this.Notice_Content = Notice_Content;
        }

        public int getNotice_Sort() {
            return Notice_Sort;
        }

        public void setNotice_Sort(int Notice_Sort) {
            this.Notice_Sort = Notice_Sort;
        }

        public String getCategory() {
            return Category;
        }

        public void setCategory(String Category) {
            this.Category = Category;
        }
    }

    public static class ListFirstCategoryBean {
        /**
         * ID : 1
         * Code : L
         * Step : 1
         * ParentID : null
         * Name : 滤清器
         * Enabled : true
         * Consumable : false
         * IsGoodsCategory : false
         * OrderID : 1
         * GCode : L
         * Company_ID : 0465ad54-ef0a-401f-a4a8-1072fa544da2
         * Category_ID : 9287e989-f0fa-41fd-96aa-45e0d60b9886
         * Category_Code : L
         * Category_ImgPath : http://zpk.jscxqp.com//Resource/PhotoFile/756a7543-5961-4ef8-b921-bb8d0082b1da.jpg
         * Category_FirstCode : L
         * Category_ChooseOn : /Resource/PhotoFile/5006e20a-c0b4-433e-a76e-3915a9b67abc.jpg
         * Category_ChooseOff : /Resource/PhotoFile/e130cf6e-90fe-42d4-8044-1833d371cee2.jpg
         * Category_FirstImgPath : http://zpk.jscxqp.com//Resource/PhotoFile/b1d9300d-6b0b-41ae-a788-b55881b1915e.jpg
         */

        private int ID;
        private String Code;
        private int Step;
        private Object ParentID;
        private String Name;
        private boolean Enabled;
        private boolean Consumable;
        private boolean IsGoodsCategory;
        private int OrderID;
        private String GCode;
        private String Company_ID;
        private String Category_ID;
        private String Category_Code;
        private String Category_ImgPath;
        private String Category_FirstCode;
        private String Category_ChooseOn;
        private String Category_ChooseOff;
        private String Category_FirstImgPath;
        private int resId;

        public ListFirstCategoryBean(int resId, String resName) {
            this.resId = resId;
            this.Name = resName;
        }

        public boolean isGoodsCategory() {
            return IsGoodsCategory;
        }

        public void setGoodsCategory(boolean goodsCategory) {
            IsGoodsCategory = goodsCategory;
        }

        public int getResId() {
            return resId;
        }

        public void setResId(int resId) {
            this.resId = resId;
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

        public int getStep() {
            return Step;
        }

        public void setStep(int Step) {
            this.Step = Step;
        }

        public Object getParentID() {
            return ParentID;
        }

        public void setParentID(Object ParentID) {
            this.ParentID = ParentID;
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

        public int getOrderID() {
            return OrderID;
        }

        public void setOrderID(int OrderID) {
            this.OrderID = OrderID;
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

        public String getCategory_FirstCode() {
            return Category_FirstCode;
        }

        public void setCategory_FirstCode(String Category_FirstCode) {
            this.Category_FirstCode = Category_FirstCode;
        }

        public String getCategory_ChooseOn() {
            return Category_ChooseOn;
        }

        public void setCategory_ChooseOn(String Category_ChooseOn) {
            this.Category_ChooseOn = Category_ChooseOn;
        }

        public String getCategory_ChooseOff() {
            return Category_ChooseOff;
        }

        public void setCategory_ChooseOff(String Category_ChooseOff) {
            this.Category_ChooseOff = Category_ChooseOff;
        }

        public String getCategory_FirstImgPath() {
            return Category_FirstImgPath;
        }

        public void setCategory_FirstImgPath(String Category_FirstImgPath) {
            this.Category_FirstImgPath = Category_FirstImgPath;
        }
    }

    public static class ListSeckillGoodsBean {
        /**
         * Seckill_ID : 067bf736-98d8-4cf6-89c6-c4b856a28a74
         * Seckill_Name : 减震器后右防尘套 DB019
         * Seckill_ImgPath : http://zpk.jscxqp.com//Resource/PhotoFile/8c76f9bd-8154-4977-865c-9034a5ae19e9.png
         * Seckill_Stock : 200
         * Seckill_LookCount : 22
         * Seckill_SourcePrice : 50
         * Seckill_SuggestPrice : 110
         * Seckill_Price : 80
         * Seckill_Content : null
         * Seckill_CarNoContent : null
         * Seckill_ParameterContent : null
         * Seckill_SaleContent : null
         * Seckill_SaleCount : 0
         * Seckill_Integer : 10
         * Seckill_Sort : 99
         * Seckill_IsOn : true
         * Company_ID : 0465ad54-ef0a-401f-a4a8-1072fa544da2
         * Card_ID : ad5024a6-f9a5-4868-892c-a8b4cbaba19a
         */

        private String Seckill_ID;
        private String Seckill_Name;
        private String Seckill_ImgPath;
        private int Seckill_Stock;
        private int Seckill_LookCount;
        private int Seckill_SourcePrice;
        private int Seckill_SuggestPrice;
        private int Seckill_Price;
        private Object Seckill_Content;
        private Object Seckill_CarNoContent;
        private Object Seckill_ParameterContent;
        private Object Seckill_SaleContent;
        private int Seckill_SaleCount;
        private int Seckill_Integer;
        private int Seckill_Sort;
        private boolean Seckill_IsOn;
        private String Company_ID;
        private String Card_ID;
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

        public String getSeckill_ID() {
            return Seckill_ID;
        }

        public void setSeckill_ID(String Seckill_ID) {
            this.Seckill_ID = Seckill_ID;
        }

        public String getSeckill_Name() {
            return Seckill_Name;
        }

        public void setSeckill_Name(String Seckill_Name) {
            this.Seckill_Name = Seckill_Name;
        }

        public String getSeckill_ImgPath() {
            return Seckill_ImgPath;
        }

        public void setSeckill_ImgPath(String Seckill_ImgPath) {
            this.Seckill_ImgPath = Seckill_ImgPath;
        }

        public int getSeckill_Stock() {
            return Seckill_Stock;
        }

        public void setSeckill_Stock(int Seckill_Stock) {
            this.Seckill_Stock = Seckill_Stock;
        }

        public int getSeckill_LookCount() {
            return Seckill_LookCount;
        }

        public void setSeckill_LookCount(int Seckill_LookCount) {
            this.Seckill_LookCount = Seckill_LookCount;
        }

        public int getSeckill_SourcePrice() {
            return Seckill_SourcePrice;
        }

        public void setSeckill_SourcePrice(int Seckill_SourcePrice) {
            this.Seckill_SourcePrice = Seckill_SourcePrice;
        }

        public int getSeckill_SuggestPrice() {
            return Seckill_SuggestPrice;
        }

        public void setSeckill_SuggestPrice(int Seckill_SuggestPrice) {
            this.Seckill_SuggestPrice = Seckill_SuggestPrice;
        }

        public int getSeckill_Price() {
            return Seckill_Price;
        }

        public void setSeckill_Price(int Seckill_Price) {
            this.Seckill_Price = Seckill_Price;
        }

        public Object getSeckill_Content() {
            return Seckill_Content;
        }

        public void setSeckill_Content(Object Seckill_Content) {
            this.Seckill_Content = Seckill_Content;
        }

        public Object getSeckill_CarNoContent() {
            return Seckill_CarNoContent;
        }

        public void setSeckill_CarNoContent(Object Seckill_CarNoContent) {
            this.Seckill_CarNoContent = Seckill_CarNoContent;
        }

        public Object getSeckill_ParameterContent() {
            return Seckill_ParameterContent;
        }

        public void setSeckill_ParameterContent(Object Seckill_ParameterContent) {
            this.Seckill_ParameterContent = Seckill_ParameterContent;
        }

        public Object getSeckill_SaleContent() {
            return Seckill_SaleContent;
        }

        public void setSeckill_SaleContent(Object Seckill_SaleContent) {
            this.Seckill_SaleContent = Seckill_SaleContent;
        }

        public int getSeckill_SaleCount() {
            return Seckill_SaleCount;
        }

        public void setSeckill_SaleCount(int Seckill_SaleCount) {
            this.Seckill_SaleCount = Seckill_SaleCount;
        }

        public int getSeckill_Integer() {
            return Seckill_Integer;
        }

        public void setSeckill_Integer(int Seckill_Integer) {
            this.Seckill_Integer = Seckill_Integer;
        }

        public int getSeckill_Sort() {
            return Seckill_Sort;
        }

        public void setSeckill_Sort(int Seckill_Sort) {
            this.Seckill_Sort = Seckill_Sort;
        }

        public boolean isSeckill_IsOn() {
            return Seckill_IsOn;
        }

        public void setSeckill_IsOn(boolean Seckill_IsOn) {
            this.Seckill_IsOn = Seckill_IsOn;
        }

        public String getCompany_ID() {
            return Company_ID;
        }

        public void setCompany_ID(String Company_ID) {
            this.Company_ID = Company_ID;
        }

        public String getCard_ID() {
            return Card_ID;
        }

        public void setCard_ID(String Card_ID) {
            this.Card_ID = Card_ID;
        }
    }

    public static class ListCradBean {
        /**
         * Card_ID : e66facbd-44cc-4f07-bfbd-13f16a8f4c15
         * Card_Title : 尾货清仓
         * Card_ImgPath : http://zpk.jscxqp.com//Resource/PhotoFile/9310ed8e-965c-4ced-8a59-706ffbc630aa.jpg
         * Card_Link : http://zpk.jscxqp.com/HomePCZPK/ListSeckillGoods?Card_ID=e66facbd-44cc-4f07-bfbd-13f16a8f4c15
         * Card_Sort : 99
         * Card_Remark : 清仓大甩卖看谁手更快
         * Company_ID : 0465ad54-ef0a-401f-a4a8-1072fa544da2
         * Card_Type : 1
         */

        private String Card_ID;
        private String Card_Title;
        private String Card_ImgPath;
        private String Card_Link;
        private int Card_Sort;
        private String Card_Remark;
        private String Company_ID;
        private int Card_Type;

        public String getCard_ID() {
            return Card_ID;
        }

        public void setCard_ID(String Card_ID) {
            this.Card_ID = Card_ID;
        }

        public String getCard_Title() {
            return Card_Title;
        }

        public void setCard_Title(String Card_Title) {
            this.Card_Title = Card_Title;
        }

        public String getCard_ImgPath() {
            return Card_ImgPath;
        }

        public void setCard_ImgPath(String Card_ImgPath) {
            this.Card_ImgPath = Card_ImgPath;
        }

        public String getCard_Link() {
            return Card_Link;
        }

        public void setCard_Link(String Card_Link) {
            this.Card_Link = Card_Link;
        }

        public int getCard_Sort() {
            return Card_Sort;
        }

        public void setCard_Sort(int Card_Sort) {
            this.Card_Sort = Card_Sort;
        }

        public String getCard_Remark() {
            return Card_Remark;
        }

        public void setCard_Remark(String Card_Remark) {
            this.Card_Remark = Card_Remark;
        }

        public String getCompany_ID() {
            return Company_ID;
        }

        public void setCompany_ID(String Company_ID) {
            this.Company_ID = Company_ID;
        }

        public int getCard_Type() {
            return Card_Type;
        }

        public void setCard_Type(int Card_Type) {
            this.Card_Type = Card_Type;
        }
    }

    public static class ListDateItemBean {
        /**
         * ItemDetailId : 1dbd005e-008d-4073-a73e-6568a9b08ac7
         * ItemId : 1f37cf55-d64a-48e7-984d-fa8d0a28b599
         * ParentId : 0
         * ItemCode : null
         * ItemName : 是否开启
         * ItemValue : 1
         * QuickQuery : null
         * SimpleSpelling : sfkq
         * IsDefault : null
         * SortCode : 0
         * DeleteMark : 0
         * EnabledMark : 1
         * Description : null
         * CreateDate : 2017-12-21T15:25:57.137
         * CreateUserId : System
         * CreateUserName : 超级管理员
         * ModifyDate : 2017-12-21T15:26:09.56
         * ModifyUserId : System
         * ModifyUserName : 超级管理员
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
        private String ModifyDate;
        private String ModifyUserId;
        private String ModifyUserName;

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

        public String getModifyDate() {
            return ModifyDate;
        }

        public void setModifyDate(String ModifyDate) {
            this.ModifyDate = ModifyDate;
        }

        public String getModifyUserId() {
            return ModifyUserId;
        }

        public void setModifyUserId(String ModifyUserId) {
            this.ModifyUserId = ModifyUserId;
        }

        public String getModifyUserName() {
            return ModifyUserName;
        }

        public void setModifyUserName(String ModifyUserName) {
            this.ModifyUserName = ModifyUserName;
        }
    }

    public static class ListCardImg{

        /**
         * Id : beda5b42-b44c-402c-a683-ac71d567ca23
         * Title : 火花塞
         * ImgUrl : http://zpk.jscxqp.com//Resource/PhotoFile/fc271b35-5de8-4537-8363-13a78391d69f.jpg
         * Search : 火花塞
         * Sort : 2
         */

        private String Id;
        private String Title;
        private String ImgUrl;
        private String Search;
        private int Sort;

        public String getId() {
            return Id;
        }

        public void setId(String Id) {
            this.Id = Id;
        }

        public String getTitle() {
            return Title;
        }

        public void setTitle(String Title) {
            this.Title = Title;
        }

        public String getImgUrl() {
            return ImgUrl;
        }

        public void setImgUrl(String ImgUrl) {
            this.ImgUrl = ImgUrl;
        }

        public String getSearch() {
            return Search;
        }

        public void setSearch(String Search) {
            this.Search = Search;
        }

        public int getSort() {
            return Sort;
        }

        public void setSort(int Sort) {
            this.Sort = Sort;
        }
    }
}
