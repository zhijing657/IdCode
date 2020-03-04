package com.zhijing.shoppingcenter.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

/**
 * 用于建立子项的Fragment
 */

public abstract class BaseFragment extends Fragment {

    protected Context context;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        return initView();
    }
    /**
     * 强制重写该方法，实现子类特有的UI
     * @return
     */
    protected abstract View initView();



    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    /**
     * 当子项需要处理数据、请求网络绑定数据、展示数据  等等
     * 重写该方法
     */
    protected  void initData(){

    }
}
