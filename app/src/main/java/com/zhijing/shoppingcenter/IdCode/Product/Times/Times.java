package com.zhijing.shoppingcenter.IdCode.Product.Times;

public class Times {
    private String name;
    private int Times;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTimes() {
        return Times;
    }

    public void setTimes(int times) {
        Times = times;
    }

    @Override
    public String toString() {
        return "Times{" +
                "name='" + name + '\'' +
                ", Times=" + Times +
                '}';
    }
}
