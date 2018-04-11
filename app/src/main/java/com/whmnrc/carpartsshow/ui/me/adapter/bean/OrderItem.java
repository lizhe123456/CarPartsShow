package com.whmnrc.carpartsshow.ui.me.adapter.bean;


import com.whmnrc.carpartsshow.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lizhe on 2018/3/14.
 */

public class OrderItem implements Serializable {

    String text;
    int img;
    int num;

    public OrderItem(String text, int img) {
        this.text = text;
        this.img = img;
    }

    public OrderItem(String text, int img, int num) {
        this.text = text;
        this.img = img;
        this.num = num;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }



    public static List<OrderItem> initItemData(){
        List<OrderItem> list = new ArrayList<>();
        list.add(new OrderItem("积分商城", R.drawable.integral_mall));
        list.add(new OrderItem("新闻资讯", R.drawable.news_and_information));
        list.add(new OrderItem("联系客服", R.drawable.contact_customer_service));
        list.add(new OrderItem("意见反馈", R.drawable.feedback));
        list.add(new OrderItem("修改密码", R.drawable.modify_the_password));
        list.add(new OrderItem("关于我们", R.drawable.about_us));
        return list;
    }
}
