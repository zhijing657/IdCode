package com.zhijing.shoppingcenter.HomePage;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.zhijing.shoppingcenter.HomePage.home.HomePageFrameFragment;
import com.zhijing.shoppingcenter.News.NewsFrameFragment;
import com.zhijing.shoppingcenter.PersonalCenter.PersonalCenterFrameFragment;
import com.zhijing.shoppingcenter.R;
import com.zhijing.shoppingcenter.ShoppongCart.ShoppingCartFrameFragment;
import com.zhijing.shoppingcenter.Type.TypeFrameFragment;

import java.util.ArrayList;

public class HomepageWithBN extends AppCompatActivity {
    private static final String TAG = "HomepageWithBN";
    private ViewPager viewPager;
    private BottomNavigationView bottomNavigationView;
    private MenuItem menuItem;
    private ArrayList<Fragment> list;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        viewPager = findViewById(R.id.viewPager);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);

        bottomNavigationView.setItemIconTintList(getColorStateList(R.color.btv_select));//设置选中时图标状态
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView
                .OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.homePageFrameFragment:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.typeFrameFragment:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.newsFrameFragment:
                        viewPager.setCurrentItem(2);
                        break;
                    case R.id.shoppingCartFrameFragment:
                        viewPager.setCurrentItem(3);
                        break;
                    case R.id.personalCenterFrameFragment:
                        viewPager.setCurrentItem(4);
                        break;
                }
                return false;
            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position,
                                       float positionOffset,
                                       int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (menuItem != null) {
                    menuItem.setChecked(false);
                } else {
                    bottomNavigationView.getMenu().getItem(0).setChecked(false);
                }
                menuItem = bottomNavigationView.getMenu().getItem(position);
                menuItem.setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
//        NavController controller = Navigation.findNavController(this,R.id.navFragment);
//        AppBarConfiguration configuration = new AppBarConfiguration.Builder(controller.getGraph()).build();
//        NavigationUI.setupActionBarWithNavController(this,controller,configuration);
//        NavigationUI.setupWithNavController(bottomNavigationView,controller);
        list = new ArrayList<>();
        list.add(new HomePageFrameFragment());
        list.add(new TypeFrameFragment());
        list.add(new NewsFrameFragment());
        list.add(new ShoppingCartFrameFragment());
        list.add(new PersonalCenterFrameFragment());
        HomepageViewPagerAdapter adapter = new HomepageViewPagerAdapter(getSupportFragmentManager(), list);
        viewPager.setAdapter(adapter);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy: " );
    }
}
