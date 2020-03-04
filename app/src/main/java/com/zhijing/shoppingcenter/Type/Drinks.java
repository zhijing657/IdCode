package com.zhijing.shoppingcenter.Type;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.zhijing.shoppingcenter.R;
import com.zhijing.shoppingcenter.Type.Adapter.GridViewAdapter;
import com.zhijing.shoppingcenter.Type.bean.type_info;
import com.zhijing.shoppingcenter.utils.Constants;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.OkHttpClient;


public class Drinks extends Fragment {

    private TextView textView;
    private GridView gridView;
    private List<type_info.ResultBean.DrinksInfoBean.ListBean> list = new ArrayList<>();
    public Drinks() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        initnet();
        View view =  inflater.inflate(R.layout.fragment_home, container, false);
        textView = view.findViewById(R.id.type_name);
        gridView = view.findViewById(R.id.gridview_type);


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //设置一个弹窗Toast,显示被短点击的条目
                Toast.makeText(getActivity(),"点击位置:"+position,Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    private void initnet() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                .readTimeout(10000L, TimeUnit.MILLISECONDS)
                //其他配置
                .build();

        OkHttpUtils.initClient(okHttpClient);

        String url = Constants.HOME_URL;
        OkHttpUtils
                .get()
                .url(url)
                .build()
                .execute(new StringCallback()
                {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        processData(response);
                    }
                });

    }

    private void processData(String response) {
        type_info data = JSON.parseObject(response,type_info.class);
        type_info.ResultBean result = data.getResult();
        list = result.getDrinks_info().getList();
        gridView.setAdapter(new GridViewAdapter(getActivity(),list));
    }
}
