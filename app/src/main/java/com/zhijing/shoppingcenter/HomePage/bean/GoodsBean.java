package com.zhijing.shoppingcenter.HomePage.bean;

import java.io.Serializable;

public class GoodsBean implements Serializable {

    private String cover_price;
    private String figure;
    private String name;
    private String goods_id;
    private String url;
    private boolean isSelected = true;
    private int num = 1;
    private String call_to_buy;
    private String specs;
    private String taste;
    private String date_of_bad;
    private String logo;
    private String product;
    private String company_name;
    private String company_logo;
    private String company_people;
    private String company_phone;
    private String company_location;

    @Override
    public String toString() {
        return "GoodsBean{" +
                "cover_price='" + cover_price + '\'' +
                ", figure='" + figure + '\'' +
                ", name='" + name + '\'' +
                ", goods_id='" + goods_id + '\'' +
                ", url='" + url + '\'' +
                ", isSelected=" + isSelected +
                ", num=" + num +
                ", call_to_buy='" + call_to_buy + '\'' +
                ", specs='" + specs + '\'' +
                ", taste='" + taste + '\'' +
                ", date_of_bad='" + date_of_bad + '\'' +
                ", logo='" + logo + '\'' +
                ", product='" + product + '\'' +
                ", company_name='" + company_name + '\'' +
                ", company_logo='" + company_logo + '\'' +
                ", company_people='" + company_people + '\'' +
                ", company_phone='" + company_phone + '\'' +
                ", company_location='" + company_location + '\'' +
                ", company_info='" + company_info + '\'' +
                '}';
    }

    public String getCompany_info() {
        return company_info;
    }

    public void setCompany_info(String company_info) {
        this.company_info = company_info;
    }

    private String company_info;

    public String getCall_to_buy() {
        return call_to_buy;
    }

    public void setCall_to_buy(String call_to_buy) {
        this.call_to_buy = call_to_buy;
    }

    public String getSpecs() {
        return specs;
    }

    public void setSpecs(String specs) {
        this.specs = specs;
    }

    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }

    public String getDate_of_bad() {
        return date_of_bad;
    }

    public void setDate_of_bad(String date_of_bad) {
        this.date_of_bad = date_of_bad;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getCompany_logo() {
        return company_logo;
    }

    public void setCompany_logo(String company_logo) {
        this.company_logo = company_logo;
    }

    public String getCompany_people() {
        return company_people;
    }

    public void setCompany_people(String company_people) {
        this.company_people = company_people;
    }

    public String getCompany_phone() {
        return company_phone;
    }

    public void setCompany_phone(String company_phone) {
        this.company_phone = company_phone;
    }

    public String getCompany_location() {
        return company_location;
    }

    public void setCompany_location(String company_location) {
        this.company_location = company_location;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCover_price() {
        return cover_price;
    }

    public void setCover_price(String cover_price) {
        this.cover_price = cover_price;
    }

    public String getFigure() {
        return figure;
    }

    public void setFigure(String figure) {
        this.figure = figure;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(String goods_id) {
        this.goods_id = goods_id;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

}
