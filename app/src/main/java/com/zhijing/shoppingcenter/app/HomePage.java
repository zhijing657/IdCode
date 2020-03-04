package com.zhijing.shoppingcenter.app;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.RadioGroup;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.zhijing.shoppingcenter.R;
import com.zhijing.shoppingcenter.ShoppongCart.Adapter.ShoppingCartAdapter;
import com.zhijing.shoppingcenter.Type.TypeFrameFragment;
import com.zhijing.shoppingcenter.base.BaseFragment;
import com.zhijing.shoppingcenter.HomePage.home.HomePageFrameFragment;
import com.zhijing.shoppingcenter.News.NewsFrameFragment;
import com.zhijing.shoppingcenter.PersonalCenter.PersonalCenterFrameFragment;
import com.zhijing.shoppingcenter.ShoppongCart.ShoppingCartFrameFragment;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends FragmentActivity {

    public RadioGroup radioGroup;
    private List<BaseFragment> mBaseFragment;
    public int position;
    public   Fragment mContext;
    private Toolbar toolbar;
    private ShoppingCartAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

                
        initFragment();
    }

    private void initFragment() {
        mBaseFragment = new ArrayList<>();
        mBaseFragment.add(new HomePageFrameFragment());
        mBaseFragment.add(new TypeFrameFragment());
        mBaseFragment.add(new NewsFrameFragment());
        mBaseFragment.add(new ShoppingCartFrameFragment());
        mBaseFragment.add(new PersonalCenterFrameFragment());
    }


}
