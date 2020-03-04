package com.zhijing.shoppingcenter.IdCode.Product.Times;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private int Times;
    private String name;
    private List<Times> timesList = new ArrayList<>();

    public int getTimes() {
        return Times;
    }

    public void setTimes(int times) {
        Times = times;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<com.zhijing.shoppingcenter.IdCode.Product.Times.Times> getTimesList() {
        return timesList;
    }

    public void setTimesList(List<com.zhijing.shoppingcenter.IdCode.Product.Times.Times> timesList) {
        this.timesList = timesList;
    }


    public void addUser(Times times){
        timesList.add(times);
    }

    @Override
    public String toString() {
        return "Group{" +
                "Times=" + Times +
                ", name='" + name + '\'' +
                ", timesList=" + timesList +
                '}';
    }
}
