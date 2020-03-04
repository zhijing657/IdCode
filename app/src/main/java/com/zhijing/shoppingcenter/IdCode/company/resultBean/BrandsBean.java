package com.zhijing.shoppingcenter.IdCode.company.resultBean;

import java.io.Serializable;

public class BrandsBean implements Serializable {
    private String image;
    private String title;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "BrandsBean{" +
                "image='" + image + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
