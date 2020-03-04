package com.zhijing.shoppingcenter.Type.TypesBean;

/**
 * @author ZhiJing
 * @create 2019-12-11 : 0:04
 */
public class Types {
    private String name;

    @Override
    public String toString() {
        return "Types{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Types(String name) {
        this.name = name;
    }

    public Types() {
    }
}
