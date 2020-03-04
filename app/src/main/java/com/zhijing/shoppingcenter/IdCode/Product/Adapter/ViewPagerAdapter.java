package com.zhijing.shoppingcenter.IdCode.Product.Adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> fragments;
    private List<String> list;
    public ViewPagerAdapter(FragmentManager fm, ArrayList<Fragment> list) {
        super(fm);
        this.fragments = list;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position){
        list = new ArrayList<>();
        list.add("产品描述");
        list.add("企业信息");
        list.add("规格参数");
        list.add("朔源");
        list.add("防串");
        list.add("官网");
       //return fragments.get(position).getTag()
        return list.get(position);
    }

}
