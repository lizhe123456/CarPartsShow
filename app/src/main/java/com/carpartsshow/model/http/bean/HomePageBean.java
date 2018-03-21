package com.carpartsshow.model.http.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lizhe on 2018/3/20.
 */

public class HomePageBean implements Serializable {


    /**
     * Banner : [{"Banner_ID":"900cd0ff-c71e-4590-9f22-80b735042335","Banner_WxAppImgPath":"http://zpk.jscxqp.com//Resource/PhotoFile/d8909ef0-d4df-4e80-9441-fa509de395bb.jpg","Banner_PcImgPath":"/Resource/PhotoFile/ec57b706-4c86-4a14-8c41-46a4c8acc80c.jpg","Banner_WxLinkUrl":"#","Banner_PcLikUrl":"#","Category":"首页","Banner_Sort":99,"Company_ID":"0465ad54-ef0a-401f-a4a8-1072fa544da2"},{"Banner_ID":"b137b556-84f0-4bf1-ae42-974f5319c1cd","Banner_WxAppImgPath":"http://zpk.jscxqp.com//Resource/PhotoFile/189869b8-c779-4e77-865c-26064dfb647c.jpg","Banner_PcImgPath":"/Resource/PhotoFile/29d1d83b-f04e-4efb-81d8-2d286c62b952.jpg","Banner_WxLinkUrl":"#","Banner_PcLikUrl":"#","Category":"首页","Banner_Sort":99,"Company_ID":"0465ad54-ef0a-401f-a4a8-1072fa544da2"},{"Banner_ID":"bddc72a3-da20-4596-80e8-fd3855d1cd42","Banner_WxAppImgPath":"http://zpk.jscxqp.com//Resource/PhotoFile/cb49887c-0f1f-40e1-b6f7-b56fee3e8665.jpg","Banner_PcImgPath":"/Resource/PhotoFile/262e7693-8b1c-4c12-bafc-9c905db889ef.jpg","Banner_WxLinkUrl":"#","Banner_PcLikUrl":"#","Category":"首页","Banner_Sort":99,"Company_ID":"0465ad54-ef0a-401f-a4a8-1072fa544da2"}]
     * OfferNar : [{"Banner_ID":"0027ef02-4e47-4bb7-ad83-08a8fedc1763","Banner_WxAppImgPath":"http://zpk.jscxqp.com//Resource/PhotoFile/fc4a9bf5-ca3a-4db3-bf63-0e22145a98b4.jpg","Banner_PcImgPath":null,"Banner_WxLinkUrl":"http://zpk.jscxqp.com/HomeWxZPK/SeckillGoodsDetail?Seckill_ID=c7c3ca4b-b2e7-49a7-a8cd-1e769b409da2","Banner_PcLikUrl":"1","Category":"天天特价","Banner_Sort":99,"Company_ID":"0465ad54-ef0a-401f-a4a8-1072fa544da2"}]
     * PoopNar : [{"Banner_ID":"8716da48-421a-4368-812c-ea81272af162","Banner_WxAppImgPath":"http://zpk.jscxqp.com//Resource/PhotoFile/052d8538-5e5c-4a6f-870a-bad5c2289d8b.jpg","Banner_PcImgPath":null,"Banner_WxLinkUrl":"http://zpk.jscxqp.com/HomeWxZPK/SeckillGoodsDetail?Seckill_ID=c7c3ca4b-b2e7-49a7-a8cd-1e769b409da2","Banner_PcLikUrl":"#","Category":"尾货清仓","Banner_Sort":99,"Company_ID":"0465ad54-ef0a-401f-a4a8-1072fa544da2"}]
     * ListNotice : [{"Notice_ID":"yhtyt665","Notice_Title":"为这件事 中纪委7位领导密集出京","Notice_Describe":null,"Notice_Seed":7,"Notice_ImgPaths":"http://zpk.jscxqp.com//Resource/PhotoFile/760a8343-3adb-46c6-a51e-90d67ec09589.jpg","Notice_CreateTime":"2017-07-25T10:55:08.137","Notice_ReleaseTime":"2017-12-18T00:00:00","Notice_Source":"长安街知事","Notice_Content":"<p class=\"otitle\" style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">（原标题：中纪委7领导密集出京，大动作！）<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">今天的《中国纪检监察报》头版头条刊发了\u201c中央纪委有关领导同志分赴地方调研\u201d的新闻。长安街知事注意到，分赴地方调研的领导阵容十分强大\u2014\u2014<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">中央政治局委员、中央纪委副书记杨晓渡到宁夏、四川调研；<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">中央纪委副书记刘金国到河北、山东调研；<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">中央纪委副书记徐令义到陕西、新疆维吾尔自治区、新疆生产建设兵团调研；<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">中央纪委副书记肖培到安徽、福建、江西调研；<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">中央纪委常委邹加怡到陕西、甘肃、青海、湖南、广东、海南，张春生到宁夏、四川，崔鹏到黑龙江调研。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">文章提到，七位中纪委领导深入到省市县乡纪委，与纪检监察干部交流，召开座谈会听取意见建议，了解改国家监察体制改革试点工作进展情况。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">监察体制改革试点，其实从去年11月已经开始，北京、山西、浙江3省市设立各级监察委员会，从体制机制、制度建设上先行先试、探索实践，为在全国推开积累经验。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">今年11月4日，全国人大常委会通过在全国各地推开国家监察体制改革试点工作的决定。一周后，全国推开国家监察体制改革试点工作动员部署电视电话会议在太原召开，中共中央政治局常委、中央纪委书记赵乐际出席并讲话。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">直至近日，中纪委领导们密集出京，去基层了解改革试点工作进展。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">国家监察体制改革是事关全局的重大政治改革，是国家监察制度的顶层设计。兹事体大，事关反腐胜局。派出如此强大阵容去基层了解情况，因此也就不难理解了。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">中纪委的领导们具体去了哪里，其实各地媒体也已有披露。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">中央政治局委员、中纪委副书记杨晓渡在宁夏和四川调研时，先后去了宁夏回族自治区灵武市及梧桐树乡、石嘴山市及星海镇和自治区纪委机关，四川省广汉市及西外乡、成都市金牛区和省纪委机关实地考察并召开座谈会。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">杨晓渡调研时提出五项要求，包括：要进一步吃透中央精神，把准政治方向；要进一步夯实主体责任，层层传导压力；试点地区要充分借鉴北京、山西、浙江改革试点成功经验，并结合自身实际积极探索创新；要做好过渡期工作衔接，妥善处理新老业务；要抓好思想建设和人心稳定，通过做深做实思想政治工作。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">长安街知事发现，中纪委副书记调研目的地的选择，颇有讲究。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">中纪委副书记刘金国调研目的地河北，是他曾经工作过的地方。在2005年入京担任公安部副部长前，刘金国在河北政法系统工作了十余年。此次刘金国除了调研河北、山东外，还在中央纪委机关主持召开联系省区市纪委书记座谈会。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">中纪委副书记徐令义也不是第一次到陕西了。今年6月，时任中央第十一巡视组组长的他，就曾代表中央巡视组分别向陕西省委书记娄勤俭和陕西省委领导班子反馈了巡视\u201c回头看\u201d情况，并且指出陕西用人问题反映集中，\u201d四风\u201c问题依然多发的情况。此外，中纪委副书记肖培也曾给福建省委作过\u201c学习贯彻廉洁自律准则和纪律处分条例\u201d专题报告。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">除了了解试点的监察体制改革情况外，中纪委领导对各地区的其他重点领域也进行了调研。中央纪委常委、监察部副部长邹加怡在甘肃还调研了学习贯彻党的十九大精神、扶贫领域监督执纪问责等工作。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">在中纪委领导分赴地方调研后，各地省委纪委也进行了反馈。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">山东省近日审议市县两级监察体制改革实施方案，并且成立了17个督导组，陆续到全省17市就推进市县深化监察体制改革试点工作情况，开展集中督导。《中国纪检监察报》披露，山东省委常委、纪委书记陈辐宽为了掌握第一手情况，就曾在不与市一级政府打招呼的情况下，直接去找县一级\u201c施工队长\u201d了解情况。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">党委书记当好\u201c施工队长\u201d，纪委当好\u201c泥瓦工匠\u201d。黑龙江省纪委近日召开了监察体制改革试点工作座谈会，传达崔鹏同志在黑龙江调研讲话和省深化监察体制改革试点工作小组第二次会议精神等，要求严明政治纪律，对有令不行、有禁不止，对党中央、省委要求置若罔闻的，对拖延改革进程、工作进展缓慢的，对口无遮拦、说三道四、妄议改革、动摇军心的要予以问责等要求。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">除了严明纪律，还要提升转隶干部的归属感和认同感。四川省在监察体制改革的过程中认识到，干部队伍思想稳定，是试点工作顺利开展的重要前提。省、市、县三级都广泛开展了面对面、一对一全覆盖谈心谈话，增强了涉改人员的认同感、归属感。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\"><br/><\/p><p><iframe width=\"300\" height=\"250\" frameborder=\"0\"><\/iframe><\/p><p><a target=\"_self\" class=\"ad_hover_href\" style=\"color: rgb(15, 107, 153); text-decoration-line: underline; width: 30px; height: 17px; position: absolute; left: 0px; bottom: 0px; z-index: 10; background: url(&quot;http://img1.126.net/channel18/ad.png&quot;) no-repeat;\"><\/a><\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">日前，中央纪委监察部网站推出了系列访谈。浙江、北京两地纪委书记先后接受采访，分享了试点国家监察体制改革的相关经验。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">浙江省委常委、纪委书记刘建超提到，最重要的还是把中央的决策部署、中央对监察体制改革的精神吃透弄懂，在实施时，要有完整的改革方案；转隶工作一定抓好，要做到机构融合、能力融合、情感融合，切实把好转隶人员的政治关、廉洁关。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">北京市委常委、纪委书记张硕辅也在中纪委访谈节目中提到，在\u201c转隶\u201d时做到四个注重：注重摸清转隶家底；注重各方协调联动；注重解除后顾之忧；注重把握动态平衡。保证了转隶过程的平稳、顺利进行。<\/p><p><br/><\/p>","Notice_Sort":1,"Category":"集团新闻"},{"Notice_ID":"dwqeqdqweq","Notice_Title":"为这件事 中纪委7位领导密集出京","Notice_Describe":null,"Notice_Seed":4,"Notice_ImgPaths":"http://zpk.jscxqp.com//Resource/PhotoFile/760a8343-3adb-46c6-a51e-90d67ec09589.jpg","Notice_CreateTime":"2017-07-25T10:55:08.137","Notice_ReleaseTime":"2017-12-18T00:00:00","Notice_Source":"长安街知事","Notice_Content":"<p class=\"otitle\" style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">（原标题：中纪委7领导密集出京，大动作！）<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">今天的《中国纪检监察报》头版头条刊发了\u201c中央纪委有关领导同志分赴地方调研\u201d的新闻。长安街知事注意到，分赴地方调研的领导阵容十分强大\u2014\u2014<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">中央政治局委员、中央纪委副书记杨晓渡到宁夏、四川调研；<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">中央纪委副书记刘金国到河北、山东调研；<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">中央纪委副书记徐令义到陕西、新疆维吾尔自治区、新疆生产建设兵团调研；<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">中央纪委副书记肖培到安徽、福建、江西调研；<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">中央纪委常委邹加怡到陕西、甘肃、青海、湖南、广东、海南，张春生到宁夏、四川，崔鹏到黑龙江调研。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">文章提到，七位中纪委领导深入到省市县乡纪委，与纪检监察干部交流，召开座谈会听取意见建议，了解改国家监察体制改革试点工作进展情况。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">监察体制改革试点，其实从去年11月已经开始，北京、山西、浙江3省市设立各级监察委员会，从体制机制、制度建设上先行先试、探索实践，为在全国推开积累经验。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">今年11月4日，全国人大常委会通过在全国各地推开国家监察体制改革试点工作的决定。一周后，全国推开国家监察体制改革试点工作动员部署电视电话会议在太原召开，中共中央政治局常委、中央纪委书记赵乐际出席并讲话。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">直至近日，中纪委领导们密集出京，去基层了解改革试点工作进展。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">国家监察体制改革是事关全局的重大政治改革，是国家监察制度的顶层设计。兹事体大，事关反腐胜局。派出如此强大阵容去基层了解情况，因此也就不难理解了。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">中纪委的领导们具体去了哪里，其实各地媒体也已有披露。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">中央政治局委员、中纪委副书记杨晓渡在宁夏和四川调研时，先后去了宁夏回族自治区灵武市及梧桐树乡、石嘴山市及星海镇和自治区纪委机关，四川省广汉市及西外乡、成都市金牛区和省纪委机关实地考察并召开座谈会。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">杨晓渡调研时提出五项要求，包括：要进一步吃透中央精神，把准政治方向；要进一步夯实主体责任，层层传导压力；试点地区要充分借鉴北京、山西、浙江改革试点成功经验，并结合自身实际积极探索创新；要做好过渡期工作衔接，妥善处理新老业务；要抓好思想建设和人心稳定，通过做深做实思想政治工作。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">长安街知事发现，中纪委副书记调研目的地的选择，颇有讲究。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">中纪委副书记刘金国调研目的地河北，是他曾经工作过的地方。在2005年入京担任公安部副部长前，刘金国在河北政法系统工作了十余年。此次刘金国除了调研河北、山东外，还在中央纪委机关主持召开联系省区市纪委书记座谈会。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">中纪委副书记徐令义也不是第一次到陕西了。今年6月，时任中央第十一巡视组组长的他，就曾代表中央巡视组分别向陕西省委书记娄勤俭和陕西省委领导班子反馈了巡视\u201c回头看\u201d情况，并且指出陕西用人问题反映集中，\u201d四风\u201c问题依然多发的情况。此外，中纪委副书记肖培也曾给福建省委作过\u201c学习贯彻廉洁自律准则和纪律处分条例\u201d专题报告。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">除了了解试点的监察体制改革情况外，中纪委领导对各地区的其他重点领域也进行了调研。中央纪委常委、监察部副部长邹加怡在甘肃还调研了学习贯彻党的十九大精神、扶贫领域监督执纪问责等工作。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">在中纪委领导分赴地方调研后，各地省委纪委也进行了反馈。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">山东省近日审议市县两级监察体制改革实施方案，并且成立了17个督导组，陆续到全省17市就推进市县深化监察体制改革试点工作情况，开展集中督导。《中国纪检监察报》披露，山东省委常委、纪委书记陈辐宽为了掌握第一手情况，就曾在不与市一级政府打招呼的情况下，直接去找县一级\u201c施工队长\u201d了解情况。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">党委书记当好\u201c施工队长\u201d，纪委当好\u201c泥瓦工匠\u201d。黑龙江省纪委近日召开了监察体制改革试点工作座谈会，传达崔鹏同志在黑龙江调研讲话和省深化监察体制改革试点工作小组第二次会议精神等，要求严明政治纪律，对有令不行、有禁不止，对党中央、省委要求置若罔闻的，对拖延改革进程、工作进展缓慢的，对口无遮拦、说三道四、妄议改革、动摇军心的要予以问责等要求。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">除了严明纪律，还要提升转隶干部的归属感和认同感。四川省在监察体制改革的过程中认识到，干部队伍思想稳定，是试点工作顺利开展的重要前提。省、市、县三级都广泛开展了面对面、一对一全覆盖谈心谈话，增强了涉改人员的认同感、归属感。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\"><br/><\/p><p><iframe width=\"300\" height=\"250\" frameborder=\"0\"><\/iframe><\/p><p><a target=\"_self\" class=\"ad_hover_href\" style=\"color: rgb(15, 107, 153); text-decoration-line: underline; width: 30px; height: 17px; position: absolute; left: 0px; bottom: 0px; z-index: 10; background: url(&quot;http://img1.126.net/channel18/ad.png&quot;) no-repeat;\"><\/a><\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">日前，中央纪委监察部网站推出了系列访谈。浙江、北京两地纪委书记先后接受采访，分享了试点国家监察体制改革的相关经验。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">浙江省委常委、纪委书记刘建超提到，最重要的还是把中央的决策部署、中央对监察体制改革的精神吃透弄懂，在实施时，要有完整的改革方案；转隶工作一定抓好，要做到机构融合、能力融合、情感融合，切实把好转隶人员的政治关、廉洁关。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">北京市委常委、纪委书记张硕辅也在中纪委访谈节目中提到，在\u201c转隶\u201d时做到四个注重：注重摸清转隶家底；注重各方协调联动；注重解除后顾之忧；注重把握动态平衡。保证了转隶过程的平稳、顺利进行。<\/p><p><br/><\/p>","Notice_Sort":1,"Category":"集团新闻"},{"Notice_ID":"dqwEWQEWQdqw","Notice_Title":"习近平引领中国经济向高质量发展阶段迈进","Notice_Describe":null,"Notice_Seed":6,"Notice_ImgPaths":"http://zpk.jscxqp.com//Resource/PhotoFile/430c3c44-90ac-403f-9887-b8812747afa7.jpg,/Resource/PhotoFile/2261213a-4614-48dc-a59a-af3796cc7289.jpg,/Resource/PhotoFile/1afcfaed-b7b7-4ffe-8bd4-fdc36fb1448b.jpg","Notice_CreateTime":"2017-07-25T11:03:59.93","Notice_ReleaseTime":"2017-12-18T00:00:00","Notice_Source":"央视网","Notice_Content":"<p class=\"f_center\" style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: center; white-space: normal; background-color: rgb(255, 255, 255);\"><img alt=\"12月6日，中共中央召开党外人士座谈会，征求对经济工作的意见和建议。习近平主持并发表重要讲话。\" src=\"/Content/scripts/plugins/ueditor/net/../../../../../upload/image/20171218/6364921870050192903243746.jpgimageView&thumbnail=550x0\" width=\"500\" height=\"360\"/><\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">12月6日，中共中央召开党外人士座谈会，征求对经济工作的意见和建议。习近平主持座谈会并发表重要讲话。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">央视网消息：党的十九大报告描绘了中国经济未来发展蓝图。党的十八大以来，以习近平同志为核心的党中央准确把握复杂局势，科学判断，正确决策，真抓实干，引领我国经济取得历史性成就、发生历史性变革。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">中国经济向高质量发展阶段迈进<\/p><p class=\"f_center\" style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: center; white-space: normal; background-color: rgb(255, 255, 255);\"><img alt=\" \" src=\"/Content/scripts/plugins/ueditor/net/../../../../../upload/image/20171218/6364921870053093065000409.jpgimageView&thumbnail=550x0\" width=\"500\" height=\"363\"/><\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">习近平总书记强调，现阶段，我国经济发展的基本特征就是由高速增长阶段转向高质量发展阶段。实现高质量发展，是保持经济社会持续健康发展的必然要求，是适应我国社会主要矛盾变化和全面建设社会主义现代化国家的必然要求。随着从高速增长向高质量发展迈进，中国经济正在开启新的时代。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">第三产业增加值在GDP中的占比从2011年的44.4%快速上升至2017年前三季度的52.9%;超过三分之二的经济增长来自消费，而不是投资和出口;与此同时，制造业技术升级、产业结构高端化的发展特征愈加明显。<\/p><p class=\"f_center\" style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: center; white-space: normal; background-color: rgb(255, 255, 255);\"><img alt=\" \" src=\"/Content/scripts/plugins/ueditor/net/../../../../../upload/image/20171218/6364921870079194568984783.jpgimageView&thumbnail=550x0\" width=\"500\" height=\"370\"/><\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">中国经济在变，对于这个重大变化，党的十九大报告给出了一个全新的判断：\u201c我国经济已由高速增长阶段转向高质量发展阶段\u201d，同时提出了\u201c建设现代化经济体系\u201d的新任务，\u201c推动经济发展质量变革、效率变革、动力变革\u201d。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">围绕着质量变革，中国正在展开一场从理念、目标、制度到具体领域工作细节的全方位变革。围绕着效率变革，改革将着力破除制约效率提升的各种体制机制障碍，打破行政性垄断、推动要素价格的市场化，加快实体经济、金融、对外开放等领域的效率提升。围绕着动力变革，拉动中国经济增长的动力，正在从传统要素驱动向创新驱动转变，就在不久前，国家批准建立6大国家研究中心，聚焦世界科技前沿，加强创新能力。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">中国经济正在发生的重大变化，也让国际机构的观察研究视角有了新的调整。对于即将到来的2018年，渣打银行表示，预计未来中国经济增长效率和质量将得到更好地提升;高盛最新发布的报告认为，新兴工业、互联网、新消费和健康产业是中国带给世界的新机会;而世界银行最新发布的《中国经济展望》中，则把中国经济关键词重新定义为\u201c高质量\u201d。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">优化供给 中国制造迈向中高端<\/p><p class=\"f_center\" style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: center; white-space: normal; background-color: rgb(255, 255, 255);\"><img alt=\" \" src=\"/Content/scripts/plugins/ueditor/net/../../../../../upload/image/20171218/6364921870090595218484016.jpgimageView&thumbnail=550x0\" width=\"500\" height=\"354\"/><\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">习近平总书记指出，建设现代化经济体系，要以供给侧结构性改革为主线，必须把发展经济的着力点放在实体经济上，把提高供给体系质量作为主攻方向。如今，围绕着加快建设制造强国，中国正在通过推动实体经济和数字经济融合发展等举措，全力向全球价值链中高端迈进。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">十九大报告指出，加快建设制造强国，加快发展先进制造业，成为深化供给侧结构性改革重要发力点。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">补上短板，中国制造正在不断创造着新纪录。中国已成为世界信息领域发展的重要贡献者。国产C919大型飞机首飞成功，12月17日，第二架飞机也完成首次飞行，中国高端制造的行业名单里，又加入了大飞机这张\u201c新名片\u201d。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">为进一步加快发展先进制造业，国家明确要推动实体经济和数字经济融合发展，继续做好信息化和工业化深度融合这篇大文章，推动制造业加速向数字化、网络化、智能化发展。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">创新开启中国经济新未来<\/p><p class=\"f_center\" style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: center; white-space: normal; background-color: rgb(255, 255, 255);\"><img alt=\" \" src=\"/Content/scripts/plugins/ueditor/net/../../../../../upload/image/20171218/6364921870094095414469924.jpgimageView&thumbnail=550x0\" width=\"500\" height=\"354\"/><\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">党的十九大报告指出，创新是引领发展的第一动力，是建设现代化经济体系的战略支撑。面向未来，我国正以全球视野谋划和推进创新，加强前沿科技布局，完善国家创新体系。创新，正在开启中国经济永续发展的新未来。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">大科学装置推动前沿基础研究不断突破，为创新驱动带来了源头活水。目前我国已经在核物理、未来网络、空间和天文等多个领域建成了50个重大科学装置，在大科学装置聚集的北京怀柔、上海张江和安徽合肥，国家建立三个综合性科学中心，瞄准世界科技前沿的基础研究，孵化战略新兴产业。<\/p><p class=\"f_center\" style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: center; white-space: normal; background-color: rgb(255, 255, 255);\"><img alt=\" \" src=\"/Content/scripts/plugins/ueditor/net/../../../../../upload/image/20171218/6364921870097995636226587.jpgimageView&thumbnail=550x0\" width=\"500\" height=\"370\"/><\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">基础科学研究的短板正在补上来，如何进一步强化创新第一动力的作用?十九大报告把加快建设创新型国家作为构建现代经济体系中重要内容，并用\u201c战略支撑\u201d四个字，强化了创新的重要地位。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">创新的引擎，正在被改革点燃。169项全面创新改革举措在全国八个试验区域全部启动。2016年，我国企业科研经费投入占全社会投入的近五分之四。其中，大中型工业企业中有研发机构的企业达到2万多家。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">目前，在数字科技的人工智能、智联网、金融科技等方面，中国已经走在了世界前列，北京中关村成为继美国硅谷之后，全球第二大吸引全球风险投资的区域，人工智能产业与硅谷齐头并进。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">在刚刚落幕的第四届世界互联网大会上，发布了18项世界最顶尖互联网科技成果，中国团队研发的占六成以上。创新对国家现代化经济体系的支撑作用正在逐步显现，也在为中国经济开启崭新的未来。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">中国乡村走向振兴<\/p><p class=\"f_center\" style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: center; white-space: normal; background-color: rgb(255, 255, 255);\"><img alt=\" \" src=\"/Content/scripts/plugins/ueditor/net/../../../../../upload/image/20171218/6364921870102195872212495.jpgimageView&thumbnail=550x0\" width=\"500\" height=\"366\"/><\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">党的十九大报告中首次提出实施乡村振兴战略，坚持农业农村优先发展，加快推进农业农村现代化，提升亿万农民幸福感。破解\u201c三农\u201d问题，进入了乡村振兴战略引领的新时代。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">不久前，农业部正式对外宣布：我国有七个省份已基本完成农村承包地确权颁证，九个省份正在收尾。拿到土地承包经营权证，不少农民放心把土地流转给新型经营主体，发展新产业。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">中国要强、农村必须强。中国要美、农村必须要美。中国要富、农民必须要富。十八大以来，国家做出了一系列强农惠农的土地制度安排，从土地确权整省试点推进，到\u201c三权分置\u201d将承包权和经营权拆分开，让农村土地迸发出新活力。农业部最新统计显示，目前，全国已有80%的承包地完成确权，35%的承包地进行了流转。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">在激发土地新活力的同时，针对农村基础设施薄弱落后的问题，2013年以来，国家仅在农林水方面的支出就达到8万多亿元，农村社区通路、通电、通电话接近全覆盖，\u201c一站式\u201d\u201c一体化\u201d互联网服务迅速向基层延伸，农村生产生活条件得到了很大改善。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">农业农村发展的内生动力在增强，农业发展方式也在转变。最新数据表明，全国农药化肥用量已经连续三年负增长;今年1200万亩土地轮作休耕。随着农业供给侧结构性改革的进一步推进，农业生产结构出现了新的变化。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">补短板，强弱项，党的十九大报告，又将实施乡村振兴战略作为建立现代化经济体系的重要一环，坚持农业、农村优先发展。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">围绕着乡村振兴，一系列的改革措施快马加鞭，十九大后首次中央深改小组会议上，有关三农的议题占了将近三分之一。开启农村人居环境整治三年行动，宅基地制度改革试点范围也将拓展。《农村土地承包法修正案(草案)》也已完成向社会公开草案征求意见。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">如今的中国农村正在主动发力、迎头赶上，成为\u201c看得见山、望得见水、记得住乡愁\u201d的美好家园。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">党的十九大对未来经济社会发展作出全面决策部署，让我们牢记习近平总书记嘱托，\u201c紧扣新时代要求推动改革发展\u201d，把握好\u201c开局之年\u201d、\u201c关键一年\u201d的2018，实干苦干，走进决胜全面建成小康社会的新时代，走进奋力实现中华民族伟大复兴中国梦的新时代!<\/p><p><br/><\/p>","Notice_Sort":1,"Category":"集团新闻"},{"Notice_ID":"99a89c35-f55b-47e0-ad7a-dac6c5857fd3","Notice_Title":"为这件事 中纪委7位领导密集出京","Notice_Describe":null,"Notice_Seed":3,"Notice_ImgPaths":"http://zpk.jscxqp.com//Resource/PhotoFile/760a8343-3adb-46c6-a51e-90d67ec09589.jpg","Notice_CreateTime":"2017-07-25T10:55:08.137","Notice_ReleaseTime":"2017-12-18T00:00:00","Notice_Source":"长安街知事","Notice_Content":"<p class=\"otitle\" style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">（原标题：中纪委7领导密集出京，大动作！）<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">今天的《中国纪检监察报》头版头条刊发了\u201c中央纪委有关领导同志分赴地方调研\u201d的新闻。长安街知事注意到，分赴地方调研的领导阵容十分强大\u2014\u2014<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">中央政治局委员、中央纪委副书记杨晓渡到宁夏、四川调研；<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">中央纪委副书记刘金国到河北、山东调研；<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">中央纪委副书记徐令义到陕西、新疆维吾尔自治区、新疆生产建设兵团调研；<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">中央纪委副书记肖培到安徽、福建、江西调研；<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">中央纪委常委邹加怡到陕西、甘肃、青海、湖南、广东、海南，张春生到宁夏、四川，崔鹏到黑龙江调研。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">文章提到，七位中纪委领导深入到省市县乡纪委，与纪检监察干部交流，召开座谈会听取意见建议，了解改国家监察体制改革试点工作进展情况。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">监察体制改革试点，其实从去年11月已经开始，北京、山西、浙江3省市设立各级监察委员会，从体制机制、制度建设上先行先试、探索实践，为在全国推开积累经验。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">今年11月4日，全国人大常委会通过在全国各地推开国家监察体制改革试点工作的决定。一周后，全国推开国家监察体制改革试点工作动员部署电视电话会议在太原召开，中共中央政治局常委、中央纪委书记赵乐际出席并讲话。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">直至近日，中纪委领导们密集出京，去基层了解改革试点工作进展。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">国家监察体制改革是事关全局的重大政治改革，是国家监察制度的顶层设计。兹事体大，事关反腐胜局。派出如此强大阵容去基层了解情况，因此也就不难理解了。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">中纪委的领导们具体去了哪里，其实各地媒体也已有披露。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">中央政治局委员、中纪委副书记杨晓渡在宁夏和四川调研时，先后去了宁夏回族自治区灵武市及梧桐树乡、石嘴山市及星海镇和自治区纪委机关，四川省广汉市及西外乡、成都市金牛区和省纪委机关实地考察并召开座谈会。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">杨晓渡调研时提出五项要求，包括：要进一步吃透中央精神，把准政治方向；要进一步夯实主体责任，层层传导压力；试点地区要充分借鉴北京、山西、浙江改革试点成功经验，并结合自身实际积极探索创新；要做好过渡期工作衔接，妥善处理新老业务；要抓好思想建设和人心稳定，通过做深做实思想政治工作。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">长安街知事发现，中纪委副书记调研目的地的选择，颇有讲究。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">中纪委副书记刘金国调研目的地河北，是他曾经工作过的地方。在2005年入京担任公安部副部长前，刘金国在河北政法系统工作了十余年。此次刘金国除了调研河北、山东外，还在中央纪委机关主持召开联系省区市纪委书记座谈会。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">中纪委副书记徐令义也不是第一次到陕西了。今年6月，时任中央第十一巡视组组长的他，就曾代表中央巡视组分别向陕西省委书记娄勤俭和陕西省委领导班子反馈了巡视\u201c回头看\u201d情况，并且指出陕西用人问题反映集中，\u201d四风\u201c问题依然多发的情况。此外，中纪委副书记肖培也曾给福建省委作过\u201c学习贯彻廉洁自律准则和纪律处分条例\u201d专题报告。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">除了了解试点的监察体制改革情况外，中纪委领导对各地区的其他重点领域也进行了调研。中央纪委常委、监察部副部长邹加怡在甘肃还调研了学习贯彻党的十九大精神、扶贫领域监督执纪问责等工作。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">在中纪委领导分赴地方调研后，各地省委纪委也进行了反馈。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">山东省近日审议市县两级监察体制改革实施方案，并且成立了17个督导组，陆续到全省17市就推进市县深化监察体制改革试点工作情况，开展集中督导。《中国纪检监察报》披露，山东省委常委、纪委书记陈辐宽为了掌握第一手情况，就曾在不与市一级政府打招呼的情况下，直接去找县一级\u201c施工队长\u201d了解情况。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">党委书记当好\u201c施工队长\u201d，纪委当好\u201c泥瓦工匠\u201d。黑龙江省纪委近日召开了监察体制改革试点工作座谈会，传达崔鹏同志在黑龙江调研讲话和省深化监察体制改革试点工作小组第二次会议精神等，要求严明政治纪律，对有令不行、有禁不止，对党中央、省委要求置若罔闻的，对拖延改革进程、工作进展缓慢的，对口无遮拦、说三道四、妄议改革、动摇军心的要予以问责等要求。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">除了严明纪律，还要提升转隶干部的归属感和认同感。四川省在监察体制改革的过程中认识到，干部队伍思想稳定，是试点工作顺利开展的重要前提。省、市、县三级都广泛开展了面对面、一对一全覆盖谈心谈话，增强了涉改人员的认同感、归属感。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\"><br/><\/p><p><iframe width=\"300\" height=\"250\" frameborder=\"0\"><\/iframe><\/p><p><a target=\"_self\" class=\"ad_hover_href\" style=\"color: rgb(15, 107, 153); text-decoration-line: underline; width: 30px; height: 17px; position: absolute; left: 0px; bottom: 0px; z-index: 10; background: url(&quot;http://img1.126.net/channel18/ad.png&quot;) no-repeat;\"><\/a><\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">日前，中央纪委监察部网站推出了系列访谈。浙江、北京两地纪委书记先后接受采访，分享了试点国家监察体制改革的相关经验。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">浙江省委常委、纪委书记刘建超提到，最重要的还是把中央的决策部署、中央对监察体制改革的精神吃透弄懂，在实施时，要有完整的改革方案；转隶工作一定抓好，要做到机构融合、能力融合、情感融合，切实把好转隶人员的政治关、廉洁关。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">北京市委常委、纪委书记张硕辅也在中纪委访谈节目中提到，在\u201c转隶\u201d时做到四个注重：注重摸清转隶家底；注重各方协调联动；注重解除后顾之忧；注重把握动态平衡。保证了转隶过程的平稳、顺利进行。<\/p><p><br/><\/p>","Notice_Sort":1,"Category":"集团新闻"},{"Notice_ID":"93863a9b-1f07-4ba2-8a08-05d25ebc1bf3","Notice_Title":"习近平引领中国经济向高质量发展阶段迈进","Notice_Describe":null,"Notice_Seed":2,"Notice_ImgPaths":"http://zpk.jscxqp.com//Resource/PhotoFile/430c3c44-90ac-403f-9887-b8812747afa7.jpg,/Resource/PhotoFile/2261213a-4614-48dc-a59a-af3796cc7289.jpg,/Resource/PhotoFile/1afcfaed-b7b7-4ffe-8bd4-fdc36fb1448b.jpg","Notice_CreateTime":"2017-07-25T11:03:59.93","Notice_ReleaseTime":"2017-12-18T00:00:00","Notice_Source":"央视网","Notice_Content":"<p class=\"f_center\" style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: center; white-space: normal; background-color: rgb(255, 255, 255);\"><img alt=\"12月6日，中共中央召开党外人士座谈会，征求对经济工作的意见和建议。习近平主持并发表重要讲话。\" src=\"/Content/scripts/plugins/ueditor/net/../../../../../upload/image/20171218/6364921870050192903243746.jpgimageView&thumbnail=550x0\" width=\"500\" height=\"360\"/><\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">12月6日，中共中央召开党外人士座谈会，征求对经济工作的意见和建议。习近平主持座谈会并发表重要讲话。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">央视网消息：党的十九大报告描绘了中国经济未来发展蓝图。党的十八大以来，以习近平同志为核心的党中央准确把握复杂局势，科学判断，正确决策，真抓实干，引领我国经济取得历史性成就、发生历史性变革。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">中国经济向高质量发展阶段迈进<\/p><p class=\"f_center\" style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: center; white-space: normal; background-color: rgb(255, 255, 255);\"><img alt=\" \" src=\"/Content/scripts/plugins/ueditor/net/../../../../../upload/image/20171218/6364921870053093065000409.jpgimageView&thumbnail=550x0\" width=\"500\" height=\"363\"/><\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">习近平总书记强调，现阶段，我国经济发展的基本特征就是由高速增长阶段转向高质量发展阶段。实现高质量发展，是保持经济社会持续健康发展的必然要求，是适应我国社会主要矛盾变化和全面建设社会主义现代化国家的必然要求。随着从高速增长向高质量发展迈进，中国经济正在开启新的时代。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">第三产业增加值在GDP中的占比从2011年的44.4%快速上升至2017年前三季度的52.9%;超过三分之二的经济增长来自消费，而不是投资和出口;与此同时，制造业技术升级、产业结构高端化的发展特征愈加明显。<\/p><p class=\"f_center\" style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: center; white-space: normal; background-color: rgb(255, 255, 255);\"><img alt=\" \" src=\"/Content/scripts/plugins/ueditor/net/../../../../../upload/image/20171218/6364921870079194568984783.jpgimageView&thumbnail=550x0\" width=\"500\" height=\"370\"/><\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">中国经济在变，对于这个重大变化，党的十九大报告给出了一个全新的判断：\u201c我国经济已由高速增长阶段转向高质量发展阶段\u201d，同时提出了\u201c建设现代化经济体系\u201d的新任务，\u201c推动经济发展质量变革、效率变革、动力变革\u201d。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">围绕着质量变革，中国正在展开一场从理念、目标、制度到具体领域工作细节的全方位变革。围绕着效率变革，改革将着力破除制约效率提升的各种体制机制障碍，打破行政性垄断、推动要素价格的市场化，加快实体经济、金融、对外开放等领域的效率提升。围绕着动力变革，拉动中国经济增长的动力，正在从传统要素驱动向创新驱动转变，就在不久前，国家批准建立6大国家研究中心，聚焦世界科技前沿，加强创新能力。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">中国经济正在发生的重大变化，也让国际机构的观察研究视角有了新的调整。对于即将到来的2018年，渣打银行表示，预计未来中国经济增长效率和质量将得到更好地提升;高盛最新发布的报告认为，新兴工业、互联网、新消费和健康产业是中国带给世界的新机会;而世界银行最新发布的《中国经济展望》中，则把中国经济关键词重新定义为\u201c高质量\u201d。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">优化供给 中国制造迈向中高端<\/p><p class=\"f_center\" style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: center; white-space: normal; background-color: rgb(255, 255, 255);\"><img alt=\" \" src=\"/Content/scripts/plugins/ueditor/net/../../../../../upload/image/20171218/6364921870090595218484016.jpgimageView&thumbnail=550x0\" width=\"500\" height=\"354\"/><\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">习近平总书记指出，建设现代化经济体系，要以供给侧结构性改革为主线，必须把发展经济的着力点放在实体经济上，把提高供给体系质量作为主攻方向。如今，围绕着加快建设制造强国，中国正在通过推动实体经济和数字经济融合发展等举措，全力向全球价值链中高端迈进。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">十九大报告指出，加快建设制造强国，加快发展先进制造业，成为深化供给侧结构性改革重要发力点。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">补上短板，中国制造正在不断创造着新纪录。中国已成为世界信息领域发展的重要贡献者。国产C919大型飞机首飞成功，12月17日，第二架飞机也完成首次飞行，中国高端制造的行业名单里，又加入了大飞机这张\u201c新名片\u201d。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">为进一步加快发展先进制造业，国家明确要推动实体经济和数字经济融合发展，继续做好信息化和工业化深度融合这篇大文章，推动制造业加速向数字化、网络化、智能化发展。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">创新开启中国经济新未来<\/p><p class=\"f_center\" style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: center; white-space: normal; background-color: rgb(255, 255, 255);\"><img alt=\" \" src=\"/Content/scripts/plugins/ueditor/net/../../../../../upload/image/20171218/6364921870094095414469924.jpgimageView&thumbnail=550x0\" width=\"500\" height=\"354\"/><\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">党的十九大报告指出，创新是引领发展的第一动力，是建设现代化经济体系的战略支撑。面向未来，我国正以全球视野谋划和推进创新，加强前沿科技布局，完善国家创新体系。创新，正在开启中国经济永续发展的新未来。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">大科学装置推动前沿基础研究不断突破，为创新驱动带来了源头活水。目前我国已经在核物理、未来网络、空间和天文等多个领域建成了50个重大科学装置，在大科学装置聚集的北京怀柔、上海张江和安徽合肥，国家建立三个综合性科学中心，瞄准世界科技前沿的基础研究，孵化战略新兴产业。<\/p><p class=\"f_center\" style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: center; white-space: normal; background-color: rgb(255, 255, 255);\"><img alt=\" \" src=\"/Content/scripts/plugins/ueditor/net/../../../../../upload/image/20171218/6364921870097995636226587.jpgimageView&thumbnail=550x0\" width=\"500\" height=\"370\"/><\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">基础科学研究的短板正在补上来，如何进一步强化创新第一动力的作用?十九大报告把加快建设创新型国家作为构建现代经济体系中重要内容，并用\u201c战略支撑\u201d四个字，强化了创新的重要地位。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">创新的引擎，正在被改革点燃。169项全面创新改革举措在全国八个试验区域全部启动。2016年，我国企业科研经费投入占全社会投入的近五分之四。其中，大中型工业企业中有研发机构的企业达到2万多家。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">目前，在数字科技的人工智能、智联网、金融科技等方面，中国已经走在了世界前列，北京中关村成为继美国硅谷之后，全球第二大吸引全球风险投资的区域，人工智能产业与硅谷齐头并进。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">在刚刚落幕的第四届世界互联网大会上，发布了18项世界最顶尖互联网科技成果，中国团队研发的占六成以上。创新对国家现代化经济体系的支撑作用正在逐步显现，也在为中国经济开启崭新的未来。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">中国乡村走向振兴<\/p><p class=\"f_center\" style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: center; white-space: normal; background-color: rgb(255, 255, 255);\"><img alt=\" \" src=\"/Content/scripts/plugins/ueditor/net/../../../../../upload/image/20171218/6364921870102195872212495.jpgimageView&thumbnail=550x0\" width=\"500\" height=\"366\"/><\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">党的十九大报告中首次提出实施乡村振兴战略，坚持农业农村优先发展，加快推进农业农村现代化，提升亿万农民幸福感。破解\u201c三农\u201d问题，进入了乡村振兴战略引领的新时代。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">不久前，农业部正式对外宣布：我国有七个省份已基本完成农村承包地确权颁证，九个省份正在收尾。拿到土地承包经营权证，不少农民放心把土地流转给新型经营主体，发展新产业。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">中国要强、农村必须强。中国要美、农村必须要美。中国要富、农民必须要富。十八大以来，国家做出了一系列强农惠农的土地制度安排，从土地确权整省试点推进，到\u201c三权分置\u201d将承包权和经营权拆分开，让农村土地迸发出新活力。农业部最新统计显示，目前，全国已有80%的承包地完成确权，35%的承包地进行了流转。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">在激发土地新活力的同时，针对农村基础设施薄弱落后的问题，2013年以来，国家仅在农林水方面的支出就达到8万多亿元，农村社区通路、通电、通电话接近全覆盖，\u201c一站式\u201d\u201c一体化\u201d互联网服务迅速向基层延伸，农村生产生活条件得到了很大改善。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">农业农村发展的内生动力在增强，农业发展方式也在转变。最新数据表明，全国农药化肥用量已经连续三年负增长;今年1200万亩土地轮作休耕。随着农业供给侧结构性改革的进一步推进，农业生产结构出现了新的变化。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">补短板，强弱项，党的十九大报告，又将实施乡村振兴战略作为建立现代化经济体系的重要一环，坚持农业、农村优先发展。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">围绕着乡村振兴，一系列的改革措施快马加鞭，十九大后首次中央深改小组会议上，有关三农的议题占了将近三分之一。开启农村人居环境整治三年行动，宅基地制度改革试点范围也将拓展。《农村土地承包法修正案(草案)》也已完成向社会公开草案征求意见。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">如今的中国农村正在主动发力、迎头赶上，成为\u201c看得见山、望得见水、记得住乡愁\u201d的美好家园。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">党的十九大对未来经济社会发展作出全面决策部署，让我们牢记习近平总书记嘱托，\u201c紧扣新时代要求推动改革发展\u201d，把握好\u201c开局之年\u201d、\u201c关键一年\u201d的2018，实干苦干，走进决胜全面建成小康社会的新时代，走进奋力实现中华民族伟大复兴中国梦的新时代!<\/p><p><br/><\/p>","Notice_Sort":1,"Category":"集团新闻"},{"Notice_ID":"54645646234","Notice_Title":"为这件事 中纪委7位领导密集出京","Notice_Describe":null,"Notice_Seed":8,"Notice_ImgPaths":"http://zpk.jscxqp.com//Resource/PhotoFile/760a8343-3adb-46c6-a51e-90d67ec09589.jpg","Notice_CreateTime":"2017-07-25T10:55:08.137","Notice_ReleaseTime":"2017-12-18T00:00:00","Notice_Source":"长安街知事","Notice_Content":"<p class=\"otitle\" style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">（原标题：中纪委7领导密集出京，大动作！）<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">今天的《中国纪检监察报》头版头条刊发了\u201c中央纪委有关领导同志分赴地方调研\u201d的新闻。长安街知事注意到，分赴地方调研的领导阵容十分强大\u2014\u2014<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">中央政治局委员、中央纪委副书记杨晓渡到宁夏、四川调研；<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">中央纪委副书记刘金国到河北、山东调研；<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">中央纪委副书记徐令义到陕西、新疆维吾尔自治区、新疆生产建设兵团调研；<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">中央纪委副书记肖培到安徽、福建、江西调研；<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">中央纪委常委邹加怡到陕西、甘肃、青海、湖南、广东、海南，张春生到宁夏、四川，崔鹏到黑龙江调研。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">文章提到，七位中纪委领导深入到省市县乡纪委，与纪检监察干部交流，召开座谈会听取意见建议，了解改国家监察体制改革试点工作进展情况。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">监察体制改革试点，其实从去年11月已经开始，北京、山西、浙江3省市设立各级监察委员会，从体制机制、制度建设上先行先试、探索实践，为在全国推开积累经验。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">今年11月4日，全国人大常委会通过在全国各地推开国家监察体制改革试点工作的决定。一周后，全国推开国家监察体制改革试点工作动员部署电视电话会议在太原召开，中共中央政治局常委、中央纪委书记赵乐际出席并讲话。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">直至近日，中纪委领导们密集出京，去基层了解改革试点工作进展。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">国家监察体制改革是事关全局的重大政治改革，是国家监察制度的顶层设计。兹事体大，事关反腐胜局。派出如此强大阵容去基层了解情况，因此也就不难理解了。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">中纪委的领导们具体去了哪里，其实各地媒体也已有披露。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">中央政治局委员、中纪委副书记杨晓渡在宁夏和四川调研时，先后去了宁夏回族自治区灵武市及梧桐树乡、石嘴山市及星海镇和自治区纪委机关，四川省广汉市及西外乡、成都市金牛区和省纪委机关实地考察并召开座谈会。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">杨晓渡调研时提出五项要求，包括：要进一步吃透中央精神，把准政治方向；要进一步夯实主体责任，层层传导压力；试点地区要充分借鉴北京、山西、浙江改革试点成功经验，并结合自身实际积极探索创新；要做好过渡期工作衔接，妥善处理新老业务；要抓好思想建设和人心稳定，通过做深做实思想政治工作。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">长安街知事发现，中纪委副书记调研目的地的选择，颇有讲究。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">中纪委副书记刘金国调研目的地河北，是他曾经工作过的地方。在2005年入京担任公安部副部长前，刘金国在河北政法系统工作了十余年。此次刘金国除了调研河北、山东外，还在中央纪委机关主持召开联系省区市纪委书记座谈会。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">中纪委副书记徐令义也不是第一次到陕西了。今年6月，时任中央第十一巡视组组长的他，就曾代表中央巡视组分别向陕西省委书记娄勤俭和陕西省委领导班子反馈了巡视\u201c回头看\u201d情况，并且指出陕西用人问题反映集中，\u201d四风\u201c问题依然多发的情况。此外，中纪委副书记肖培也曾给福建省委作过\u201c学习贯彻廉洁自律准则和纪律处分条例\u201d专题报告。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">除了了解试点的监察体制改革情况外，中纪委领导对各地区的其他重点领域也进行了调研。中央纪委常委、监察部副部长邹加怡在甘肃还调研了学习贯彻党的十九大精神、扶贫领域监督执纪问责等工作。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">在中纪委领导分赴地方调研后，各地省委纪委也进行了反馈。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">山东省近日审议市县两级监察体制改革实施方案，并且成立了17个督导组，陆续到全省17市就推进市县深化监察体制改革试点工作情况，开展集中督导。《中国纪检监察报》披露，山东省委常委、纪委书记陈辐宽为了掌握第一手情况，就曾在不与市一级政府打招呼的情况下，直接去找县一级\u201c施工队长\u201d了解情况。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">党委书记当好\u201c施工队长\u201d，纪委当好\u201c泥瓦工匠\u201d。黑龙江省纪委近日召开了监察体制改革试点工作座谈会，传达崔鹏同志在黑龙江调研讲话和省深化监察体制改革试点工作小组第二次会议精神等，要求严明政治纪律，对有令不行、有禁不止，对党中央、省委要求置若罔闻的，对拖延改革进程、工作进展缓慢的，对口无遮拦、说三道四、妄议改革、动摇军心的要予以问责等要求。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">除了严明纪律，还要提升转隶干部的归属感和认同感。四川省在监察体制改革的过程中认识到，干部队伍思想稳定，是试点工作顺利开展的重要前提。省、市、县三级都广泛开展了面对面、一对一全覆盖谈心谈话，增强了涉改人员的认同感、归属感。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\"><br/><\/p><p><iframe width=\"300\" height=\"250\" frameborder=\"0\"><\/iframe><\/p><p><a target=\"_self\" class=\"ad_hover_href\" style=\"color: rgb(15, 107, 153); text-decoration-line: underline; width: 30px; height: 17px; position: absolute; left: 0px; bottom: 0px; z-index: 10; background: url(&quot;http://img1.126.net/channel18/ad.png&quot;) no-repeat;\"><\/a><\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">日前，中央纪委监察部网站推出了系列访谈。浙江、北京两地纪委书记先后接受采访，分享了试点国家监察体制改革的相关经验。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">浙江省委常委、纪委书记刘建超提到，最重要的还是把中央的决策部署、中央对监察体制改革的精神吃透弄懂，在实施时，要有完整的改革方案；转隶工作一定抓好，要做到机构融合、能力融合、情感融合，切实把好转隶人员的政治关、廉洁关。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">北京市委常委、纪委书记张硕辅也在中纪委访谈节目中提到，在\u201c转隶\u201d时做到四个注重：注重摸清转隶家底；注重各方协调联动；注重解除后顾之忧；注重把握动态平衡。保证了转隶过程的平稳、顺利进行。<\/p><p><br/><\/p>","Notice_Sort":1,"Category":"集团新闻"},{"Notice_ID":"321421412的dwqe","Notice_Title":"天津河北高层人事近日变动频繁","Notice_Describe":null,"Notice_Seed":5,"Notice_ImgPaths":"http://zpk.jscxqp.com//Resource/PhotoFile/27919e89-030e-4bfd-bc6e-01b1434a5fc8.jpg","Notice_CreateTime":"2017-07-26T21:46:51.927","Notice_ReleaseTime":"2017-12-18T00:00:00","Notice_Source":"北京知道","Notice_Content":"<p class=\"otitle\" style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">（原标题：天津河北高层人事变动频繁）<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">近期，天津和河北的高层变动频繁。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">此前任河北省委常委、宣传部部长的田向利调任四川省委常委；此前任山东省委常委的王浩任河北省委常委。此前任天津市副市长的何树山已任安徽省政府党组成员。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\"><strong>再有山东常委跨省任职<\/strong><\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">日前，中共中央批准：王浩同志任河北省委委员、常委；不再担任山东省委常委、委员职务。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">知道君注意到，此番调任河北，是现年54岁的王浩，首次离开山东工作。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">据公开资料，王浩出生于1963年10月，是山东单县人，其仕途始于单县本地，19岁进入单县李半庄乡团委成为一名干事，此后35年时间里一直在省内任职，曾主政山东菏泽、滨州、淄博、烟台4市。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">今年4月，他由淄博市委书记之职调任烟台市委书记，两个月后，在中共山东省第十一届委员会第一次全体会议上当选为省委常委，跻身省部级之列。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">另外，知道君注意到，这已是近期第二名山东省委常委，离开本地跨省任职。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">今年11月底，此前担任山东省委常委、宣传部部长的孙守刚离开山东赴河南工作，近日已明确担任河南省委常委、统战部部长。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\"><strong>王浩简历<\/strong><\/p><p class=\"f_center\" style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: center; white-space: normal; background-color: rgb(255, 255, 255);\"><img alt=\"天津河北高层人事变动频繁\" src=\"/Content/scripts/plugins/ueditor/net/../../../../../upload/image/20171218/6364921878613682708586222.png\" id=\"netease1513587791255241\"/><\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">王浩，男，汉族，1963年10月生，山东单县人，省委党校业余本科班经济管理专业毕业，省委党校大学。1984年1月加入中国共产党，1982年7月参加工作。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">先后在单县李半庄乡、团县委、单城镇工作。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">1993.01历任曹县县委常委、宣传部部长，菏泽地区体委主任、党组书记，菏泽市(县级)委副书记、市长，菏泽市牡丹区委书记<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">2003.04菏泽市委常委、牡丹区委书记<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">2004.05菏泽市委常委、秘书长<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">2008.01菏泽市委常委、副市长<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">2008.11菏泽市委副书记<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">2010.12滨州市委副书记<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">2012.09山东省委副秘书长、省信访局局长<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">2014.01山东省民政厅党组书记<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">2014.03山东省民政厅厅长、党组书记<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">2015.02淄博市委书记，市人大常委会主任<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">2017.04烟台市委书记<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">2017.06山东省委常委、烟台市委书记<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">2017.12河北省委常委<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">十九大后，省级女常委首次跨省调动<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">近日，中共中央批准：田向利同志任中共四川省委委员、常委；李静同志不再担任中共四川省委常委、委员职务。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\"><strong>田向利简历<\/strong><\/p><p class=\"f_center\" style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: center; white-space: normal; background-color: rgb(255, 255, 255);\"><img alt=\"天津河北高层人事变动频繁\" src=\"/Content/scripts/plugins/ueditor/net/../../../../../upload/image/20171218/6364921878620483097801375.png\" id=\"netease1513587791255686\"/><\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">田向利，女，汉族，1963年3月生，邢台人，1984年1月入党，1984年7月参加工作，天津大学管理学院管理科学与工程专业毕业，在职研究生学历，管理学博士学位。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">1981.09--1984.07张家口师范专科学校中文系中文专业学习<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">1984.07--1985.11石家庄市桥西区南长街街道办事处干事<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">1985.11--1992.05共青团石家庄市桥西区委书记<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">1992.05--1995.02　共青团石家庄市委副书记（其间:1992.08--1994.12中央党校函授学院经济专业学习）<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">1995.02--1995.05　石家庄市桥西区政府负责人<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">1995.05--1996.09　共青团石家庄市委书记<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">1996.09--2001.06　共青团河北省委副书记（1996.03--1999.06吉林大学经济管理学院国民经济学专业在职学习，获经济学硕士学位）<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">2001.06--2003.03　共青团河北省委书记<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">2003.03--2005.04　唐山市委副书记（正厅级）（2001.09--2004.07天津大学管理学院管理科学与工程专业在职研究生学习，获管理学博士学位）<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">2005.04--2006.11　河北省委统战部常务副部长<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">2006.11--2007.01　河北省委组织部副部长，省机构编制委员会办公室主任，省人事厅党组书记<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">2007.01--2008.01　河北省委组织部副部长，省机构编制委员会办公室主任，省人事厅厅长、党组书记<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">2008.01--2011.11　河北省政协副主席、党组成员<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">2011.11--2012.01　河北省委常委、统战部部长，省政协副主席<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">2012.01--2013.02　河北省委常委、统战部部长<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">2013.02--2013.06　河北省委常委、统战部部长，秦皇岛市委书记<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">2013.06--2015.09　河北省委常委、秦皇岛市委书记<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">2015.09--2017.12 ?河北省委常委、宣传部部长<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">2017.12 四川省委常委。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">十届、十二届全国政协委员，十九大代表。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\"><strong>十九大后，天津市政府高层再外调<\/strong><\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">12月16日，安徽省政府党组书记、省长李国英主持召开省政府第88次党组会议，学习贯彻习近平总书记关于弘扬\u201c红船精神\u201d重要指示、关于进一步纠正\u201c四风\u201d加强作风建设重要批示精神，学习统计违纪违法责任人处分处理建议办法等文件，贯彻省委常委会会议部署，研究贯彻落实工作。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">安徽省政府党组成员参加会议，副省长谢广祥列席会议。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">知道君注意到，何树山和杨光荣也参加了此次会议，位列安徽省政府党组成员之列，两人分别作了发言。<\/p><p class=\"f_center\" style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: center; white-space: normal; background-color: rgb(255, 255, 255);\"><img alt=\"天津河北高层人事变动频繁\" src=\"/Content/scripts/plugins/ueditor/net/../../../../../upload/image/20171218/6364921878626683442314700.png\" id=\"netease1513587791255920\"/><\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">此前，何树山为天津市副市长；杨光荣为湖南省副省长。<\/p><p class=\"f_center\" style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: center; white-space: normal; background-color: rgb(255, 255, 255);\"><img alt=\"天津河北高层人事变动频繁\" src=\"/Content/scripts/plugins/ueditor/net/../../../../../upload/image/20171218/6364921878640884268272424.png\" id=\"netease1513587791255281\"/><\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">据天津市政府官网显示，何树山在天津6位副市长中位列第二，分管工业和信息化（国防工业、节能降耗）、服务业、科技、知识产权、电力、通信、安全生产、抗震救灾工作。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">出生于1964年的何树山为山东新泰人，1984年大庆石油学院毕业后，进入大庆油田，从一名钻井公司技术员开始，十余年间逐渐升至大庆石油管理局修井分公司经理。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">2000年，他调任吉林石油集团，先后任总工程师、董事长、总经理，中石油大港油田分公司总经理等职。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">2008年，何树山踏入仕途，出任天津经济技术开发区管委会主任。2009年12月起，任天津市滨海新区区委常委、天津经济技术开发区管委会主任。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">2013年1月，他在天津市第十六届人民代表大会第一次会议上当选天津市副市长。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">知道君注意到，这是十九大后，天津外调的第二位高层。今年10月28日，原任天津市长王东峰调任河北省委书记。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">公开简历显示，杨光荣是湖南湘潭人，1962年出生，其工作经历集中在湖南省内，曾任长沙市委常委、长沙县委书记，湖南省旅游局局长，张家界市委书记。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">2016年12月，杨光荣任湖南省副省长、秘书长，2017年3月卸任湖南省政府秘书长职务。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">本月6日，杨光荣还以湖南省副省长的身份出席了全省煤矿整顿关闭暨安全生产工作会议。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\"><strong>何树山简历<\/strong><\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">何树山，男，汉族，1964年3月生，山东新泰人，1986年12月加入中国共产党，1984年7月参加工作，中国石油大学油气井工程专业毕业，在职研究生学历，工学博士，正高级工程师。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">1984年7月起，先后任大庆石油管理局钻井一公司探井一大队钻井队技术员、钻井一公司工程技术站固井组组长、现场管理室副主任、工程技术站副主任；<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">钻井三分公司党委书记兼副经理、副总工程师；<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">钻井一公司副总工程师兼一分公司经理；<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">1996年任钻井一公司副经理、常务副经理、党委委员，钻井三公司经理、党委副书记；<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">1999年任大庆油田有限责任公司修井分公司经理、党委副书记；<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">2000年调任吉林石油集团有限责任公司总工程师、党委常委；<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">2002年任吉林石油集团有限责任公司董事长、总经理、党委副书记；<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\"><br/><\/p><p><iframe width=\"300\" height=\"250\" frameborder=\"0\"><\/iframe><\/p><p><a target=\"_self\" class=\"ad_hover_href\" style=\"color: rgb(15, 107, 153); text-decoration-line: underline; width: 30px; height: 17px; position: absolute; left: 0px; bottom: 0px; z-index: 10; background: url(&quot;http://img1.126.net/channel18/ad.png&quot;) no-repeat;\"><\/a><\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">2006任中国石油大港油田公司总经理、党委副书记；<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">2008年3月，大港油田公司与大港油田集团公司重组整合，任大港油田公司总经理兼大港油田集团公司总经理；<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">2008年4月，任天津市委滨海新区工委委员、天津经济技术开发区管理委员会党组副书记、管委会主任；<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">2009年11月，任天津市委滨海新区工委委员、天津经济技术开发区管理委员会党组书记、管委会主任；<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">2009年12月，任天津市滨海新区区委常委、天津经济技术开发区管委会主任；<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">2013年1月，任天津市副市长。<\/p><p><br/><\/p>","Notice_Sort":1,"Category":"业内新闻"},{"Notice_ID":"0460a642-86fb-4d0c-8254-2066f9ebb54a","Notice_Title":"天津河北高层人事近日变动频繁","Notice_Describe":null,"Notice_Seed":1,"Notice_ImgPaths":"http://zpk.jscxqp.com//Resource/PhotoFile/27919e89-030e-4bfd-bc6e-01b1434a5fc8.jpg","Notice_CreateTime":"2017-07-26T21:46:51.927","Notice_ReleaseTime":"2017-12-18T00:00:00","Notice_Source":"北京知道","Notice_Content":"<p class=\"otitle\" style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">（原标题：天津河北高层人事变动频繁）<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">近期，天津和河北的高层变动频繁。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">此前任河北省委常委、宣传部部长的田向利调任四川省委常委；此前任山东省委常委的王浩任河北省委常委。此前任天津市副市长的何树山已任安徽省政府党组成员。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\"><strong>再有山东常委跨省任职<\/strong><\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">日前，中共中央批准：王浩同志任河北省委委员、常委；不再担任山东省委常委、委员职务。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">知道君注意到，此番调任河北，是现年54岁的王浩，首次离开山东工作。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">据公开资料，王浩出生于1963年10月，是山东单县人，其仕途始于单县本地，19岁进入单县李半庄乡团委成为一名干事，此后35年时间里一直在省内任职，曾主政山东菏泽、滨州、淄博、烟台4市。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">今年4月，他由淄博市委书记之职调任烟台市委书记，两个月后，在中共山东省第十一届委员会第一次全体会议上当选为省委常委，跻身省部级之列。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">另外，知道君注意到，这已是近期第二名山东省委常委，离开本地跨省任职。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">今年11月底，此前担任山东省委常委、宣传部部长的孙守刚离开山东赴河南工作，近日已明确担任河南省委常委、统战部部长。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\"><strong>王浩简历<\/strong><\/p><p class=\"f_center\" style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: center; white-space: normal; background-color: rgb(255, 255, 255);\"><img alt=\"天津河北高层人事变动频繁\" src=\"/Content/scripts/plugins/ueditor/net/../../../../../upload/image/20171218/6364921878613682708586222.png\" id=\"netease1513587791255241\"/><\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">王浩，男，汉族，1963年10月生，山东单县人，省委党校业余本科班经济管理专业毕业，省委党校大学。1984年1月加入中国共产党，1982年7月参加工作。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">先后在单县李半庄乡、团县委、单城镇工作。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">1993.01历任曹县县委常委、宣传部部长，菏泽地区体委主任、党组书记，菏泽市(县级)委副书记、市长，菏泽市牡丹区委书记<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">2003.04菏泽市委常委、牡丹区委书记<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">2004.05菏泽市委常委、秘书长<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">2008.01菏泽市委常委、副市长<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">2008.11菏泽市委副书记<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">2010.12滨州市委副书记<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">2012.09山东省委副秘书长、省信访局局长<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">2014.01山东省民政厅党组书记<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">2014.03山东省民政厅厅长、党组书记<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">2015.02淄博市委书记，市人大常委会主任<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">2017.04烟台市委书记<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">2017.06山东省委常委、烟台市委书记<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">2017.12河北省委常委<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">十九大后，省级女常委首次跨省调动<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">近日，中共中央批准：田向利同志任中共四川省委委员、常委；李静同志不再担任中共四川省委常委、委员职务。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\"><strong>田向利简历<\/strong><\/p><p class=\"f_center\" style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: center; white-space: normal; background-color: rgb(255, 255, 255);\"><img alt=\"天津河北高层人事变动频繁\" src=\"/Content/scripts/plugins/ueditor/net/../../../../../upload/image/20171218/6364921878620483097801375.png\" id=\"netease1513587791255686\"/><\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">田向利，女，汉族，1963年3月生，邢台人，1984年1月入党，1984年7月参加工作，天津大学管理学院管理科学与工程专业毕业，在职研究生学历，管理学博士学位。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">1981.09--1984.07张家口师范专科学校中文系中文专业学习<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">1984.07--1985.11石家庄市桥西区南长街街道办事处干事<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">1985.11--1992.05共青团石家庄市桥西区委书记<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">1992.05--1995.02　共青团石家庄市委副书记（其间:1992.08--1994.12中央党校函授学院经济专业学习）<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">1995.02--1995.05　石家庄市桥西区政府负责人<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">1995.05--1996.09　共青团石家庄市委书记<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">1996.09--2001.06　共青团河北省委副书记（1996.03--1999.06吉林大学经济管理学院国民经济学专业在职学习，获经济学硕士学位）<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">2001.06--2003.03　共青团河北省委书记<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">2003.03--2005.04　唐山市委副书记（正厅级）（2001.09--2004.07天津大学管理学院管理科学与工程专业在职研究生学习，获管理学博士学位）<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">2005.04--2006.11　河北省委统战部常务副部长<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">2006.11--2007.01　河北省委组织部副部长，省机构编制委员会办公室主任，省人事厅党组书记<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">2007.01--2008.01　河北省委组织部副部长，省机构编制委员会办公室主任，省人事厅厅长、党组书记<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">2008.01--2011.11　河北省政协副主席、党组成员<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">2011.11--2012.01　河北省委常委、统战部部长，省政协副主席<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">2012.01--2013.02　河北省委常委、统战部部长<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">2013.02--2013.06　河北省委常委、统战部部长，秦皇岛市委书记<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">2013.06--2015.09　河北省委常委、秦皇岛市委书记<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">2015.09--2017.12 ?河北省委常委、宣传部部长<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">2017.12 四川省委常委。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">十届、十二届全国政协委员，十九大代表。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\"><strong>十九大后，天津市政府高层再外调<\/strong><\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">12月16日，安徽省政府党组书记、省长李国英主持召开省政府第88次党组会议，学习贯彻习近平总书记关于弘扬\u201c红船精神\u201d重要指示、关于进一步纠正\u201c四风\u201d加强作风建设重要批示精神，学习统计违纪违法责任人处分处理建议办法等文件，贯彻省委常委会会议部署，研究贯彻落实工作。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">安徽省政府党组成员参加会议，副省长谢广祥列席会议。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">知道君注意到，何树山和杨光荣也参加了此次会议，位列安徽省政府党组成员之列，两人分别作了发言。<\/p><p class=\"f_center\" style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: center; white-space: normal; background-color: rgb(255, 255, 255);\"><img alt=\"天津河北高层人事变动频繁\" src=\"/Content/scripts/plugins/ueditor/net/../../../../../upload/image/20171218/6364921878626683442314700.png\" id=\"netease1513587791255920\"/><\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">此前，何树山为天津市副市长；杨光荣为湖南省副省长。<\/p><p class=\"f_center\" style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: center; white-space: normal; background-color: rgb(255, 255, 255);\"><img alt=\"天津河北高层人事变动频繁\" src=\"/Content/scripts/plugins/ueditor/net/../../../../../upload/image/20171218/6364921878640884268272424.png\" id=\"netease1513587791255281\"/><\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">据天津市政府官网显示，何树山在天津6位副市长中位列第二，分管工业和信息化（国防工业、节能降耗）、服务业、科技、知识产权、电力、通信、安全生产、抗震救灾工作。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">出生于1964年的何树山为山东新泰人，1984年大庆石油学院毕业后，进入大庆油田，从一名钻井公司技术员开始，十余年间逐渐升至大庆石油管理局修井分公司经理。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">2000年，他调任吉林石油集团，先后任总工程师、董事长、总经理，中石油大港油田分公司总经理等职。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">2008年，何树山踏入仕途，出任天津经济技术开发区管委会主任。2009年12月起，任天津市滨海新区区委常委、天津经济技术开发区管委会主任。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">2013年1月，他在天津市第十六届人民代表大会第一次会议上当选天津市副市长。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">知道君注意到，这是十九大后，天津外调的第二位高层。今年10月28日，原任天津市长王东峰调任河北省委书记。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">公开简历显示，杨光荣是湖南湘潭人，1962年出生，其工作经历集中在湖南省内，曾任长沙市委常委、长沙县委书记，湖南省旅游局局长，张家界市委书记。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">2016年12月，杨光荣任湖南省副省长、秘书长，2017年3月卸任湖南省政府秘书长职务。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">本月6日，杨光荣还以湖南省副省长的身份出席了全省煤矿整顿关闭暨安全生产工作会议。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\"><strong>何树山简历<\/strong><\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">何树山，男，汉族，1964年3月生，山东新泰人，1986年12月加入中国共产党，1984年7月参加工作，中国石油大学油气井工程专业毕业，在职研究生学历，工学博士，正高级工程师。<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">1984年7月起，先后任大庆石油管理局钻井一公司探井一大队钻井队技术员、钻井一公司工程技术站固井组组长、现场管理室副主任、工程技术站副主任；<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">钻井三分公司党委书记兼副经理、副总工程师；<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">钻井一公司副总工程师兼一分公司经理；<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">1996年任钻井一公司副经理、常务副经理、党委委员，钻井三公司经理、党委副书记；<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">1999年任大庆油田有限责任公司修井分公司经理、党委副书记；<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">2000年调任吉林石油集团有限责任公司总工程师、党委常委；<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">2002年任吉林石油集团有限责任公司董事长、总经理、党委副书记；<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\"><br/><\/p><p><iframe width=\"300\" height=\"250\" frameborder=\"0\"><\/iframe><\/p><p><a target=\"_self\" class=\"ad_hover_href\" style=\"color: rgb(15, 107, 153); text-decoration-line: underline; width: 30px; height: 17px; position: absolute; left: 0px; bottom: 0px; z-index: 10; background: url(&quot;http://img1.126.net/channel18/ad.png&quot;) no-repeat;\"><\/a><\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">2006任中国石油大港油田公司总经理、党委副书记；<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">2008年3月，大港油田公司与大港油田集团公司重组整合，任大港油田公司总经理兼大港油田集团公司总经理；<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">2008年4月，任天津市委滨海新区工委委员、天津经济技术开发区管理委员会党组副书记、管委会主任；<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">2009年11月，任天津市委滨海新区工委委员、天津经济技术开发区管理委员会党组书记、管委会主任；<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">2009年12月，任天津市滨海新区区委常委、天津经济技术开发区管委会主任；<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-size: 18px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">2013年1月，任天津市副市长。<\/p><p><br/><\/p>","Notice_Sort":1,"Category":"业内新闻"}]
     * ListFirstCategory : [{"ID":1,"Code":"L","Step":1,"ParentID":null,"Name":"滤清器","Enabled":true,"Consumable":false,"IsGoodsCategory":false,"OrderID":1,"GCode":"L","Company_ID":"0465ad54-ef0a-401f-a4a8-1072fa544da2","Category_ID":"9287e989-f0fa-41fd-96aa-45e0d60b9886","Category_Code":"L","Category_ImgPath":"http://zpk.jscxqp.com//Resource/PhotoFile/756a7543-5961-4ef8-b921-bb8d0082b1da.jpg","Category_FirstCode":"L","Category_ChooseOn":"/Resource/PhotoFile/5006e20a-c0b4-433e-a76e-3915a9b67abc.jpg","Category_ChooseOff":"/Resource/PhotoFile/e130cf6e-90fe-42d4-8044-1833d371cee2.jpg","Category_FirstImgPath":"http://zpk.jscxqp.com//Resource/PhotoFile/b1d9300d-6b0b-41ae-a788-b55881b1915e.jpg"},{"ID":2,"Code":"C","Step":1,"ParentID":null,"Name":"传动系统","Enabled":true,"Consumable":false,"IsGoodsCategory":false,"OrderID":2,"GCode":"C","Company_ID":"0465ad54-ef0a-401f-a4a8-1072fa544da2","Category_ID":"7433ce0d-50b5-49af-aac4-f417433123df","Category_Code":"C","Category_ImgPath":"http://zpk.jscxqp.com//Resource/PhotoFile/47590287-b5e8-4dd6-93be-6d6e5ae14369.jpg","Category_FirstCode":"C","Category_ChooseOn":"/Resource/PhotoFile/64c06ef7-7fa8-4eef-88ab-73464af960ec.jpg","Category_ChooseOff":"/Resource/PhotoFile/3fcb09d6-8809-4786-a83f-322b1f058c95.jpg","Category_FirstImgPath":"http://zpk.jscxqp.com//Resource/PhotoFile/311134ba-df70-46f1-aec9-7e1995bf51de.jpg"},{"ID":3,"Code":"Z","Step":1,"ParentID":null,"Name":"制动系统","Enabled":true,"Consumable":false,"IsGoodsCategory":false,"OrderID":3,"GCode":"Z","Company_ID":"0465ad54-ef0a-401f-a4a8-1072fa544da2","Category_ID":"f0b5809e-23e4-4b4b-ac62-24206317eed6","Category_Code":"Z","Category_ImgPath":"http://zpk.jscxqp.com//Resource/PhotoFile/323926ac-6115-4027-a28d-79167c238f12.jpg","Category_FirstCode":"Z","Category_ChooseOn":"/Resource/PhotoFile/d2df40fd-9533-48d4-b366-22f7759c8111.jpg","Category_ChooseOff":"/Resource/PhotoFile/4528459f-67d5-4b21-8547-22e7754dc72f.jpg","Category_FirstImgPath":"http://zpk.jscxqp.com//Resource/PhotoFile/8baf4ef9-5826-497f-9a9b-ea764c3efb2a.jpg"},{"ID":4,"Code":"F","Step":1,"ParentID":null,"Name":"点火系统","Enabled":true,"Consumable":false,"IsGoodsCategory":false,"OrderID":4,"GCode":"F","Company_ID":"0465ad54-ef0a-401f-a4a8-1072fa544da2","Category_ID":"9b751c10-29b5-478c-a162-973d7cc86a47","Category_Code":"F","Category_ImgPath":"http://zpk.jscxqp.com//Resource/PhotoFile/0cbfadcc-aad6-417f-9c07-6980adfb1fe3.jpg","Category_FirstCode":"D","Category_ChooseOn":"/Resource/PhotoFile/3b4cff7a-aa66-4ca3-b1b6-f9ebeea0a470.jpg","Category_ChooseOff":"/Resource/PhotoFile/276fc1e7-11a6-4516-a27f-d8578f494490.jpg","Category_FirstImgPath":"http://zpk.jscxqp.com//Resource/PhotoFile/8e2d7a2c-32ea-48a7-b937-b705cf21b912.jpg"},{"ID":5,"Code":"S","Step":1,"ParentID":null,"Name":"照明系统","Enabled":true,"Consumable":false,"IsGoodsCategory":false,"OrderID":5,"GCode":"S","Company_ID":"0465ad54-ef0a-401f-a4a8-1072fa544da2","Category_ID":"105bcc86-26a9-4e92-8e9c-aa8967032d35","Category_Code":"S","Category_ImgPath":"http://zpk.jscxqp.com//Resource/PhotoFile/5a4b941d-bf5e-45a1-8443-9ff81a32d355.jpg","Category_FirstCode":"Z","Category_ChooseOn":"/Resource/PhotoFile/ea512084-5271-4478-887f-a658aea1c11c.jpg","Category_ChooseOff":"/Resource/PhotoFile/06d94766-a12c-4ed5-a125-957e0933b134.jpg","Category_FirstImgPath":"http://zpk.jscxqp.com//Resource/PhotoFile/0d8c2984-92ad-4fcf-8780-c0d7cd4af029.jpg"},{"ID":6,"Code":"G","Step":1,"ParentID":null,"Name":"雨刮喇叭","Enabled":true,"Consumable":false,"IsGoodsCategory":false,"OrderID":6,"GCode":"G","Company_ID":"0465ad54-ef0a-401f-a4a8-1072fa544da2","Category_ID":"8a4d6ac6-e155-4eae-9344-07e639acc97b","Category_Code":"G","Category_ImgPath":"http://zpk.jscxqp.com//Resource/PhotoFile/83363910-8ba6-4ff5-89ef-db77a1532f2b.jpg","Category_FirstCode":"Y","Category_ChooseOn":"/Resource/PhotoFile/327712a2-7f0b-4f37-bd81-6f8dc8d4f065.jpg","Category_ChooseOff":"/Resource/PhotoFile/ec6fd69d-0462-493f-82a3-57e63c8762fb.jpg","Category_FirstImgPath":"http://zpk.jscxqp.com//Resource/PhotoFile/308503c3-3eae-4806-b135-4fb24c6213c9.jpg"},{"ID":7,"Code":"D","Step":1,"ParentID":null,"Name":"底盘系统","Enabled":true,"Consumable":false,"IsGoodsCategory":false,"OrderID":7,"GCode":"D","Company_ID":"0465ad54-ef0a-401f-a4a8-1072fa544da2","Category_ID":"c615e1f9-38be-480c-9208-4dd622ffde83","Category_Code":"D","Category_ImgPath":"http://zpk.jscxqp.com//Resource/PhotoFile/ed1d7396-8bb1-450e-8bd6-7f7d8af1a327.jpg","Category_FirstCode":"D","Category_ChooseOn":"/Resource/PhotoFile/faf4914c-96ae-4a1c-8c39-b59a7fc42f81.jpg","Category_ChooseOff":"/Resource/PhotoFile/6d783e6c-51d8-48c7-a2e4-8ef47afff5c8.jpg","Category_FirstImgPath":"http://zpk.jscxqp.com//Resource/PhotoFile/9e881a25-9cf8-4e31-9279-e765f5473177.jpg"},{"ID":8,"Code":"0","Step":1,"ParentID":null,"Name":"油品化工","Enabled":true,"Consumable":false,"IsGoodsCategory":false,"OrderID":8,"GCode":"0","Company_ID":"0465ad54-ef0a-401f-a4a8-1072fa544da2","Category_ID":"8fd7263b-471d-41cb-ab44-54cc0c6483be","Category_Code":"0","Category_ImgPath":"http://zpk.jscxqp.com//Resource/PhotoFile/24b939dc-7f45-4ccb-849a-bef89d9dc1fb.jpg","Category_FirstCode":"Y","Category_ChooseOn":"/Resource/PhotoFile/46223604-6438-45f4-9e46-2aef63b7947f.jpg","Category_ChooseOff":"/Resource/PhotoFile/59592574-8672-48dc-bba1-96beb97c73cd.jpg","Category_FirstImgPath":"http://zpk.jscxqp.com//Resource/PhotoFile/e0e131db-e298-408f-9965-68fb10722334.jpg"},{"ID":9,"Code":"B","Step":1,"ParentID":null,"Name":"电瓶轮胎","Enabled":true,"Consumable":false,"IsGoodsCategory":false,"OrderID":9,"GCode":"B","Company_ID":"0465ad54-ef0a-401f-a4a8-1072fa544da2","Category_ID":"0c34ced1-1d48-4227-903f-c883bb804848","Category_Code":"B","Category_ImgPath":"http://zpk.jscxqp.com//Resource/PhotoFile/1f59c83f-edd2-4e82-9609-dca1be98437e.jpg","Category_FirstCode":"D","Category_ChooseOn":"/Resource/PhotoFile/f731163f-19a7-4849-b79d-fb6562b3e506.jpg","Category_ChooseOff":"/Resource/PhotoFile/d7c8b711-98df-429a-b22d-ce5e4928b9ed.jpg","Category_FirstImgPath":"http://zpk.jscxqp.com//Resource/PhotoFile/a486098d-2249-4b3f-8b1a-01d5e3d0735d.jpg"},{"ID":10,"Code":"T","Step":1,"ParentID":null,"Name":"汽保工具","Enabled":true,"Consumable":false,"IsGoodsCategory":false,"OrderID":10,"GCode":"T","Company_ID":"0465ad54-ef0a-401f-a4a8-1072fa544da2","Category_ID":"594ab578-0a3a-4abd-bc44-f992f60e9af8","Category_Code":"T","Category_ImgPath":"http://zpk.jscxqp.com//Resource/PhotoFile/90ff8acd-1ae7-47ab-a72d-90ed9de8a67a.jpg","Category_FirstCode":"Q","Category_ChooseOn":"/Resource/PhotoFile/5853bcaa-8b0d-43a1-a115-2fcfe1107b89.jpg","Category_ChooseOff":"/Resource/PhotoFile/e30017a4-0988-4c1c-8922-7b1eed725534.jpg","Category_FirstImgPath":"http://zpk.jscxqp.com//Resource/PhotoFile/a943195b-0390-4886-94e2-793913fe9f1f.jpg"},{"ID":11,"Code":"W","Step":1,"ParentID":null,"Name":"全车件","Enabled":true,"Consumable":false,"IsGoodsCategory":false,"OrderID":11,"GCode":"W","Company_ID":"0465ad54-ef0a-401f-a4a8-1072fa544da2","Category_ID":"06bb1c55-720e-4b9f-affa-578b1194c758","Category_Code":"W","Category_ImgPath":"http://zpk.jscxqp.com//Resource/PhotoFile/ff61bc20-6437-474b-b957-6962af71b912.jpg","Category_FirstCode":"Q","Category_ChooseOn":"/Resource/PhotoFile/9844c7be-f758-454a-8846-bd34f63c9f18.jpg","Category_ChooseOff":"/Resource/PhotoFile/2c574daf-0e88-4788-8ffc-7ad6b650a9a1.jpg","Category_FirstImgPath":"http://zpk.jscxqp.com//Resource/PhotoFile/2a4ded08-acc8-4fc1-8249-7b5d33801845.jpg"},{"ID":12,"Code":"A","Step":1,"ParentID":null,"Name":"辅料用品","Enabled":true,"Consumable":false,"IsGoodsCategory":false,"OrderID":12,"GCode":"A","Company_ID":"0465ad54-ef0a-401f-a4a8-1072fa544da2","Category_ID":"dbcbd57e-2348-4d97-a689-2afe62200822","Category_Code":"A","Category_ImgPath":"http://zpk.jscxqp.com//Resource/PhotoFile/a92fc5c3-3874-466b-b746-8ee1b8948325.jpg","Category_FirstCode":"F","Category_ChooseOn":"/Resource/PhotoFile/980984a7-1a05-44e5-962c-a46ef671d7ad.jpg","Category_ChooseOff":"/Resource/PhotoFile/cb76360b-176e-4c99-8bfc-01ec38e6ab5c.jpg","Category_FirstImgPath":"http://zpk.jscxqp.com//Resource/PhotoFile/624e6413-cd08-44b5-a133-349756d0fff8.jpg"}]
     * ListSeckillGoods : [{"Seckill_ID":"067bf736-98d8-4cf6-89c6-c4b856a28a74","Seckill_Name":"减震器后右防尘套 DB019","Seckill_ImgPath":"http://zpk.jscxqp.com//Resource/PhotoFile/8c76f9bd-8154-4977-865c-9034a5ae19e9.png","Seckill_Stock":200,"Seckill_LookCount":22,"Seckill_SourcePrice":50,"Seckill_SuggestPrice":110,"Seckill_Price":80,"Seckill_Content":null,"Seckill_CarNoContent":null,"Seckill_ParameterContent":null,"Seckill_SaleContent":null,"Seckill_SaleCount":0,"Seckill_Integer":10,"Seckill_Sort":99,"Seckill_IsOn":true,"Company_ID":"0465ad54-ef0a-401f-a4a8-1072fa544da2","Card_ID":"ad5024a6-f9a5-4868-892c-a8b4cbaba19a"},{"Seckill_ID":"067bf736-98d8-4cf6-89c6-c4b856a38a74","Seckill_Name":"优静 宝马3系 X1全系 无骨雨刷片571003","Seckill_ImgPath":"http://zpk.jscxqp.com//Resource/PhotoFile/8c76f9bd-8154-4977-865c-9034a5ae19e9.png","Seckill_Stock":200,"Seckill_LookCount":22,"Seckill_SourcePrice":50,"Seckill_SuggestPrice":110,"Seckill_Price":80,"Seckill_Content":null,"Seckill_CarNoContent":null,"Seckill_ParameterContent":null,"Seckill_SaleContent":null,"Seckill_SaleCount":0,"Seckill_Integer":10,"Seckill_Sort":99,"Seckill_IsOn":true,"Company_ID":"0465ad54-ef0a-401f-a4a8-1072fa544da2","Card_ID":"ad5024a6-f9a5-4868-892c-a8b4cbaba19a"},{"Seckill_ID":"075a3dfe-512b-48a5-9a33-e35166e6f863","Seckill_Name":"雨刮器 桑塔纳POLO宝来 逸有无骨雨刷汽车原装","Seckill_ImgPath":"http://zpk.jscxqp.com//Resource/PhotoFile/11cf4981-0d60-4d0e-b25d-df4253e1fa5b.jpg","Seckill_Stock":55,"Seckill_LookCount":14,"Seckill_SourcePrice":11,"Seckill_SuggestPrice":11,"Seckill_Price":11,"Seckill_Content":"<p>dqwdq<\/p>","Seckill_CarNoContent":"<p>带我去多无群<\/p>","Seckill_ParameterContent":"<p>带我去多无群<\/p>","Seckill_SaleContent":"<p>带我去多无群<\/p>","Seckill_SaleCount":4,"Seckill_Integer":2,"Seckill_Sort":99,"Seckill_IsOn":true,"Company_ID":"0465ad54-ef0a-401f-a4a8-1072fa544da2","Card_ID":null},{"Seckill_ID":"0d6a7e98-e795-480b-9372-58e4bdc94f71","Seckill_Name":"117208 SWF(优视) 帕萨特/新领驭（04/2009","Seckill_ImgPath":"http://zpk.jscxqp.com//Resource/PhotoFile/99062a86-fabf-4eff-8510-1aebef6a5c77.png","Seckill_Stock":100,"Seckill_LookCount":104,"Seckill_SourcePrice":100,"Seckill_SuggestPrice":150,"Seckill_Price":70,"Seckill_Content":null,"Seckill_CarNoContent":null,"Seckill_ParameterContent":null,"Seckill_SaleContent":null,"Seckill_SaleCount":50,"Seckill_Integer":70,"Seckill_Sort":99,"Seckill_IsOn":true,"Company_ID":"0465ad54-ef0a-401f-a4a8-1072fa544da2","Card_ID":"ad5024a6-f9a5-4868-892c-a8b4cbaba19a"},{"Seckill_ID":"13f03a99-7438-4cc8-816c-2f9725b9a98c","Seckill_Name":"大众老新捷达雨刮器 桑塔纳POLO宝来 逸有无骨雨刷汽车原装","Seckill_ImgPath":"http://zpk.jscxqp.com//Resource/PhotoFile/92532c31-6bd8-4052-85aa-1e7f6deff293.jpg","Seckill_Stock":2,"Seckill_LookCount":23,"Seckill_SourcePrice":21,"Seckill_SuggestPrice":33,"Seckill_Price":15,"Seckill_Content":null,"Seckill_CarNoContent":null,"Seckill_ParameterContent":null,"Seckill_SaleContent":null,"Seckill_SaleCount":0,"Seckill_Integer":1,"Seckill_Sort":99,"Seckill_IsOn":true,"Company_ID":"0465ad54-ef0a-401f-a4a8-1072fa544da2","Card_ID":null},{"Seckill_ID":"3fa185ef-80d7-4fc2-b5d5-82fd9214cc3f","Seckill_Name":"减震器后防尘套 DB006","Seckill_ImgPath":"http://zpk.jscxqp.com//Resource/PhotoFile/b28e300b-c07f-4cd5-8bb6-dbf1f2516596.png","Seckill_Stock":200,"Seckill_LookCount":3,"Seckill_SourcePrice":20,"Seckill_SuggestPrice":30,"Seckill_Price":15,"Seckill_Content":null,"Seckill_CarNoContent":null,"Seckill_ParameterContent":null,"Seckill_SaleContent":null,"Seckill_SaleCount":0,"Seckill_Integer":10,"Seckill_Sort":99,"Seckill_IsOn":true,"Company_ID":"0465ad54-ef0a-401f-a4a8-1072fa544da2","Card_ID":"e66facbd-44cc-4f07-bfbd-13f16a8f4c15"}]
     * ListCrad : [{"Card_ID":"e66facbd-44cc-4f07-bfbd-13f16a8f4c15","Card_Title":"尾货清仓","Card_ImgPath":"http://zpk.jscxqp.com//Resource/PhotoFile/9310ed8e-965c-4ced-8a59-706ffbc630aa.jpg","Card_Link":"http://zpk.jscxqp.com/HomePCZPK/ListSeckillGoods?Card_ID=e66facbd-44cc-4f07-bfbd-13f16a8f4c15","Card_Sort":99,"Card_Remark":"清仓大甩卖看谁手更快","Company_ID":"0465ad54-ef0a-401f-a4a8-1072fa544da2","Card_Type":1},{"Card_ID":"ad5024a6-f9a5-4868-892c-a8b4cbaba19a","Card_Title":"天天特价","Card_ImgPath":"http://zpk.jscxqp.com//Resource/PhotoFile/a2e7a6cc-e10c-463e-b392-225a2b0a4ae0.jpg","Card_Link":"http://zpk.jscxqp.com/HomePCZPK/ListSeckillGoods?Card_ID=e66facbd-44cc-4f07-bfbd-13f16a8f4c15","Card_Sort":99,"Card_Remark":"特价大优惠","Company_ID":"0465ad54-ef0a-401f-a4a8-1072fa544da2","Card_Type":1}]
     * ListCardImg : []
     * ListDateItem : [{"ItemDetailId":"1dbd005e-008d-4073-a73e-6568a9b08ac7","ItemId":"1f37cf55-d64a-48e7-984d-fa8d0a28b599","ParentId":"0","ItemCode":null,"ItemName":"是否开启","ItemValue":"1","QuickQuery":null,"SimpleSpelling":"sfkq","IsDefault":null,"SortCode":0,"DeleteMark":0,"EnabledMark":1,"Description":null,"CreateDate":"2017-12-21T15:25:57.137","CreateUserId":"System","CreateUserName":"超级管理员","ModifyDate":"2017-12-21T15:26:09.56","ModifyUserId":"System","ModifyUserName":"超级管理员"},{"ItemDetailId":"93a20be7-a9dc-4ced-b43f-3c98f4e38537","ItemId":"1f37cf55-d64a-48e7-984d-fa8d0a28b599","ParentId":"0","ItemCode":null,"ItemName":"结束时间","ItemValue":"2020-12-12","QuickQuery":null,"SimpleSpelling":"jssj","IsDefault":null,"SortCode":1,"DeleteMark":0,"EnabledMark":1,"Description":null,"CreateDate":"2017-12-21T15:26:24.897","CreateUserId":"System","CreateUserName":"超级管理员","ModifyDate":null,"ModifyUserId":null,"ModifyUserName":null},{"ItemDetailId":"e82e0b56-5d81-4db3-ad0e-70f8bf4e8ddd","ItemId":"1f37cf55-d64a-48e7-984d-fa8d0a28b599","ParentId":"0","ItemCode":null,"ItemName":"抢购上限","ItemValue":"1","QuickQuery":null,"SimpleSpelling":"qgsx","IsDefault":null,"SortCode":2,"DeleteMark":0,"EnabledMark":1,"Description":null,"CreateDate":"2017-12-21T15:28:43.633","CreateUserId":"System","CreateUserName":"超级管理员","ModifyDate":null,"ModifyUserId":null,"ModifyUserName":null}]
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
    private List<?> ListCardImg;
    private List<ListDateItemBean> ListDateItem;

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

    public List<?> getListCardImg() {
        return ListCardImg;
    }

    public void setListCardImg(List<?> ListCardImg) {
        this.ListCardImg = ListCardImg;
    }

    public List<ListDateItemBean> getListDateItem() {
        return ListDateItem;
    }

    public void setListDateItem(List<ListDateItemBean> ListDateItem) {
        this.ListDateItem = ListDateItem;
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
}
