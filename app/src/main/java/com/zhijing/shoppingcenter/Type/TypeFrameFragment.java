package com.zhijing.shoppingcenter.Type;


import android.graphics.Color;
import android.os.Build;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import com.zhijing.shoppingcenter.R;
import com.zhijing.shoppingcenter.Type.Adapter.YvewPaperAdapter;
import com.zhijing.shoppingcenter.base.BaseFragment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import me.kaelaela.verticalviewpager.VerticalViewPager;
import me.kaelaela.verticalviewpager.transforms.DefaultTransformer;
import q.rorbin.verticaltablayout.VerticalTabLayout;
import q.rorbin.verticaltablayout.adapter.TabAdapter;
import q.rorbin.verticaltablayout.widget.ITabView;
import q.rorbin.verticaltablayout.widget.QTabView;
import q.rorbin.verticaltablayout.widget.TabView;


public class TypeFrameFragment extends BaseFragment {

    private static final String TAG = TypeFrameFragment.class.getName();
    private Toolbar toolbar_type;
    private VerticalTabLayout tab;
    private VerticalViewPager yviewPager;
    @Override
    protected View initView() {
        Log.d(TAG, "分类页面页面被创建 ");
        View view = View.inflate(context, R.layout.type_frame_fragment,null);
        toolbar_type= view.findViewById(R.id.toolbar_type);
        tab = view.findViewById(R.id.type_tab);
        yviewPager = view.findViewById(R.id.yviewpager);
        return view;
    }

    @Override
    protected void initData() {
        Log.d(TAG, "分类页面数据被创建 ");
        initTab();
        setToolBar();
        initStatusBar();

    }

    private void initTab() {
        tab.addTab(new QTabView(getActivity()));
        tab.setTabMode(VerticalTabLayout.TAB_MODE_SCROLLABLE);

        tab.addOnTabSelectedListener(new VerticalTabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabView tab, int position) {
                yviewPager.setCurrentItem(position);
            }

            @Override
            public void onTabReselected(TabView tab, int position) {
            }
    });

        tab.setTabAdapter(new TabAdapter() {
            List<String> titles;
            {
                titles = new ArrayList<>();
                titles.add("1");
                titles.add("2");
                Collections.addAll(titles);
            }
            @Override
            public int getCount() {
                return titles.size();
            }

            @Override
            public ITabView.TabBadge getBadge(int position) {
                return null;
            }

            @Override
            public ITabView.TabIcon getIcon(int position) {
                return null;
            }

            @Override
            public ITabView.TabTitle getTitle(int position) {
                return new QTabView.TabTitle.Builder()
                        .setContent(titles.get(position))
                        .setTextColor(Color.BLACK, Color.GRAY)
                        .build();
            }

            @Override
            public int getBackground(int position) {
                return 0;
            }
        });

        yviewPager.setAdapter(new YvewPaperAdapter(getChildFragmentManager()));
        yviewPager.setPageTransformer(false, new DefaultTransformer());

        tab.setupWithViewPager(yviewPager);

    }


    private void setToolBar() {
        toolbar_type.inflateMenu(R.menu.taskbar);
        toolbar_type.setTitle("分类");
        toolbar_type.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.zxing:
                        break;
                }
                return true;
            }
        });
    }

    private void initStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            Window window = getActivity().getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION
                    | WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }
}
