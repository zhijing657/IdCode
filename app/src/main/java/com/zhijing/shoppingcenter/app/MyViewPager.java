package com.zhijing.shoppingcenter.app;

import android.content.Context;
import android.view.View;
import android.widget.GridView;

import androidx.viewpager.widget.ViewPager;

import me.kaelaela.verticalviewpager.VerticalViewPager;

public class MyViewPager extends VerticalViewPager {

    public MyViewPager(Context context) {
        super(context);
    }

    @Override
    protected boolean canScroll(View v, boolean checkV, int dx, int x, int y) {
        if (v != this && (v instanceof ViewPager)) {
            return true;
        } else if (v != this && v instanceof GridView) {
            return false;
        }
        return super.canScroll(v, checkV, dx, x, y);
    }
}
