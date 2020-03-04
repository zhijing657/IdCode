package com.zhijing.shoppingcenter.IdCode.Product.RestuleBean;

import java.io.Serializable;

public class OriginalInfo implements Serializable {
    private int show;
    private String picture;
    private String photo;
    private String name;
    private String Inspect_name;
    private String function;
    private String title;
    private String Manufacturer_name;
    private String Manufacturer_location;
    private String Manufacturer_phone;
    private String Manufacturer_info;
    private String Inspect_type;

    public int getShow() {
        return show;
    }

    public void setShow(int show) {
        this.show = show;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInspect_name() {
        return Inspect_name;
    }

    public void setInspect_name(String inspect_name) {
        Inspect_name = inspect_name;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getManufacturer_name() {
        return Manufacturer_name;
    }

    public void setManufacturer_name(String manufacturer_name) {
        Manufacturer_name = manufacturer_name;
    }

    public String getManufacturer_location() {
        return Manufacturer_location;
    }

    public void setManufacturer_location(String manufacturer_location) {
        Manufacturer_location = manufacturer_location;
    }

    public String getManufacturer_phone() {
        return Manufacturer_phone;
    }

    public void setManufacturer_phone(String manufacturer_phone) {
        Manufacturer_phone = manufacturer_phone;
    }

    public String getManufacturer_info() {
        return Manufacturer_info;
    }

    public void setManufacturer_info(String manufacturer_info) {
        Manufacturer_info = manufacturer_info;
    }

    public String getInspect_type() {
        return Inspect_type;
    }

    public void setInspect_type(String inspect_type) {
        Inspect_type = inspect_type;
    }

    @Override
    public String toString() {
        return "OriginalInfo{" +
                "show=" + show +
                ", picture='" + picture + '\'' +
                ", photo='" + photo + '\'' +
                ", name='" + name + '\'' +
                ", Inspect_name='" + Inspect_name + '\'' +
                ", function='" + function + '\'' +
                ", title='" + title + '\'' +
                ", Manufacturer_name='" + Manufacturer_name + '\'' +
                ", Manufacturer_location='" + Manufacturer_location + '\'' +
                ", Manufacturer_phone='" + Manufacturer_phone + '\'' +
                ", Manufacturer_info='" + Manufacturer_info + '\'' +
                ", Inspect_type='" + Inspect_type + '\'' +
                '}';
    }
}
