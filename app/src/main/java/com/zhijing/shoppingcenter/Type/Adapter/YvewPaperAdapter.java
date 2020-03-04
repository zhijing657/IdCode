package com.zhijing.shoppingcenter.Type.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.zhijing.shoppingcenter.Type.Drinks;
import com.zhijing.shoppingcenter.Type.Equipment;

import java.util.ArrayList;

public class YvewPaperAdapter extends FragmentPagerAdapter {
    ArrayList<Fragment> list;



    public YvewPaperAdapter(FragmentManager fm, ArrayList<Fragment> list) {
        super(fm);
        this.list = list;
    }

    public YvewPaperAdapter(@NonNull FragmentManager fm) {
        super(fm);
        list = new ArrayList<>();
        list.add(new Drinks());
        list.add(new Equipment());

    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        ArrayList<String> title = new ArrayList<>();
        title.add("饮品");
        title.add("设备");
        return title.get(position);
    }
}
