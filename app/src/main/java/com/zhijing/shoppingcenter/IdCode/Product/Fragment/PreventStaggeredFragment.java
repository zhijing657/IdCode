package com.zhijing.shoppingcenter.IdCode.Product.Fragment;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.alibaba.fastjson.JSON;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.MapView;
import com.zhijing.shoppingcenter.HomePage.home.HomePageFrameFragment;
import com.zhijing.shoppingcenter.IdCode.Product.RestuleBean.ProductData;
import com.zhijing.shoppingcenter.R;
import com.zhijing.shoppingcenter.utils.Constants;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import okhttp3.Call;

public class PreventStaggeredFragment extends Fragment implements View.OnClickListener{

    private Context context;
    private final String TAG = PreventStaggeredFragment.class.getName();
    private ProductData.ResultBean productBean;
    private ProductData.ResultBean.ProductInfoBean.ListBean datas;
    private TextView company_name_5,company_contacts_5,phone_to_call_5,company_location_5,
            agent_name,agent_location,complaint_phone,finish_view;
    private MapView mapView;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = View.inflate(context, R.layout.prevent_staggered_fragment,null);
        company_name_5 = view.findViewById(R.id.company_name_5);
        company_contacts_5 = view.findViewById(R.id.company_contacts_5);
        phone_to_call_5 = view.findViewById(R.id.phone_to_call_5);
        company_location_5 = view.findViewById(R.id.company_location_5);
        agent_name = view.findViewById(R.id.agent_name);
        agent_location = view.findViewById(R.id.agent_location);
        complaint_phone = view.findViewById(R.id.complaint_phone);
        finish_view = view.findViewById(R.id.finish_view);
        //mapView = view.findViewById(R.id.bmapView);

        finish_view.setOnClickListener(this);
        getData();

        //initBDView();
        return view;
    }

    private void initBDView() {
        SDKInitializer.initialize(context);
        SDKInitializer.setCoordType(CoordType.BD09LL);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    private void getData() {
        String url = Constants.PRODUCT_INFO;
        OkHttpUtils
                .get()
                .url(url)
                .build()
                .execute(new StringCallback()
                {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.e(TAG, "产品描述页面数据请求失败  "  + e.getMessage());
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        //Log.e(TAG, "产品描述页面数据请求成功  "  + response);
                        processData(response);
                    }
                });
    }

    private String a = null;
    private String Result = null;
    //    SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
//    Date curdate = new Date(System.currentTimeMillis());
    private void processData(String json) {
        ProductData productData = JSON.parseObject(json, ProductData.class);
        productBean = productData.getResult();
        List<ProductData.ResultBean.ProductInfoBean.ListBean> list = productBean.getProduct_info().getList();
        String qrcode = HomePageFrameFragment.open_url.replaceAll("\\s*","");
        for(int i = 0;i<productBean.getProduct_info().getList().size();i++){

            datas = list.get(i);
            a = datas.getCode();

            if (a.equalsIgnoreCase(qrcode.substring(qrcode.length()-10))){
                //Log.e(TAG, "processData: YES" );
                company_name_5.setText(datas.getCompany_name());
                company_contacts_5.setText(datas.getCompany_contacts());
                phone_to_call_5.setText(datas.getPhone_to_call());
                company_location_5.setText(datas.getCompany_location());
                agent_name.setText(datas.getAgent_name());
                agent_location.setText(datas.getAgent_location());
                complaint_phone.setText(datas.getComplaint_phone());
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.finish_view:
                getActivity().onBackPressed();
        }
    }
}
