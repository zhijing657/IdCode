package com.zhijing.shoppingcenter.IdCode.Product;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.google.android.material.tabs.TabLayout;
import com.zhijing.shoppingcenter.IdCode.Product.Adapter.ViewPagerAdapter;
import com.zhijing.shoppingcenter.IdCode.Product.Fragment.DescribeFragment;
import com.zhijing.shoppingcenter.IdCode.Product.Fragment.EnterpriseInformationFragment;
import com.zhijing.shoppingcenter.IdCode.Product.Fragment.OriginalFragment;
import com.zhijing.shoppingcenter.IdCode.Product.Fragment.ParameterFragment;
import com.zhijing.shoppingcenter.IdCode.Product.Fragment.PreventStaggeredFragment;
import com.zhijing.shoppingcenter.IdCode.Product.Fragment.WebViewFragment;
import com.zhijing.shoppingcenter.R;

import java.util.ArrayList;


public class Product_info extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ArrayList<Fragment> list;
    ViewPagerAdapter viewPagerAdapter;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_info);
        context = getApplicationContext();
        initStatusBar();//设置状态栏透明
        tabLayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.viewPager);

        //设置所有的Fragment
        list = new ArrayList<>();
        DescribeFragment describeFragment = new DescribeFragment();
        EnterpriseInformationFragment enterpriseInformationFragment = new EnterpriseInformationFragment();
        ParameterFragment parameterFragment = new ParameterFragment();
        OriginalFragment originalFragment = new OriginalFragment();
        PreventStaggeredFragment preventStaggeredFragment = new PreventStaggeredFragment();
        WebViewFragment webViewFragment = new WebViewFragment();

        list.add(describeFragment);
        list.add(enterpriseInformationFragment);
        list.add(parameterFragment);
        list.add(originalFragment);
        list.add(preventStaggeredFragment);
        list.add(webViewFragment);

        //设置ViewPager的适配器
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), list);
        viewPager.setAdapter(viewPagerAdapter);

        //将tablayout和ViewPager绑定
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

    }

    public void initStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = this.getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION
                    | WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            this.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }
}
