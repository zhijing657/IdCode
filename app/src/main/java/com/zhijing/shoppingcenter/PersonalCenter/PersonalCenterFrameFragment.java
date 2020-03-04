package com.zhijing.shoppingcenter.PersonalCenter;


import android.graphics.Color;
import android.os.Build;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;


import androidx.appcompat.widget.Toolbar;

import com.zhijing.shoppingcenter.R;
import com.zhijing.shoppingcenter.base.BaseFragment;


public class PersonalCenterFrameFragment extends BaseFragment {

    private static final String TAG = PersonalCenterFrameFragment.class.getName();
    private Toolbar toolbar_pc;

    @Override
    protected View initView() {
        Log.d(TAG, "个人中心页面被创建 ");
        View view = View.inflate(context, R.layout.mine_frame_fragment,null);
        toolbar_pc = view.findViewById(R.id.toolbar_pc);
        return view;
    }

    @Override
    protected void initData() {
        Log.d(TAG, "个人中心数据被创建 ");
        super.initData();
        setToolBar();
        initStatusBar();
    }

    private void setToolBar() {
        toolbar_pc.inflateMenu(R.menu.taskbar);
        toolbar_pc.setTitle("个人中心");
        toolbar_pc.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
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
//        View decorView = getActivity().getWindow().getDecorView();
//        int option = View.SYSTEM_UI_FLAG_FULLSCREEN;
//        decorView.setSystemUiVisibility(option);

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
