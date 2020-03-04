package com.zhijing.shoppingcenter.IdCode.Product.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.fragment.app.Fragment;

import com.alibaba.fastjson.JSON;
import com.bumptech.glide.Glide;
import com.zhijing.shoppingcenter.HomePage.home.HomePageFrameFragment;
import com.zhijing.shoppingcenter.IdCode.Product.RestuleBean.ProductData;
import com.zhijing.shoppingcenter.R;
import com.zhijing.shoppingcenter.utils.Constants;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import okhttp3.Call;

public class EnterpriseInformationFragment extends Fragment {

    private Context context;
    private final String TAG = EnterpriseInformationFragment.class.getName();
    private ProductData.ResultBean productBean;
    ProductData.ResultBean.ProductInfoBean.ListBean datas;
    private ImageView company_logo_2;
    private TextView company_info_2, company_name_2, company_contacts, phone_to_call, company_location;
    private String qrcode;
    private List<ProductData.ResultBean.ProductInfoBean.ListBean> list;

    public EnterpriseInformationFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getActivity();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = View.inflate(context, R.layout.enterprise_information_fragment, null);
        company_logo_2 = view.findViewById(R.id.company_logo_2);
        company_info_2 = view.findViewById(R.id.company_info_2);
        company_name_2 = view.findViewById(R.id.company_name_2);
        company_contacts = view.findViewById(R.id.company_contacts);
        phone_to_call = view.findViewById(R.id.phone_to_call);
        company_location = view.findViewById(R.id.company_location);
        getData();
        return view;
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
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.e(TAG, "产品描述页面数据请求失败  " + e.getMessage());
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        // Log.e(TAG, "产品描述页面数据请求成功  "  + response);
                        processData(response);
                    }
                });
    }

    private String a = null;

    private void processData(String json) {
        ProductData productData = JSON.parseObject(json, ProductData.class);
        productBean = productData.getResult();
        qrcode = HomePageFrameFragment.open_url.replaceAll("\\s*", "");
        list = productBean.getProduct_info().getList();
        for (int i = 0; i < productBean.getProduct_info().getList().size(); i++) {
            datas = list.get(i);
            a = datas.getCode();
            if (qrcode.substring(qrcode.length() - 10).equalsIgnoreCase(a)) {
                //Log.e(TAG, "processData: YES" );
                company_contacts.setText(datas.getCompany_contacts());
                company_info_2.setText(datas.getCompany_info());
                company_location.setText(datas.getCompany_location());
                phone_to_call.setText(datas.getPhone_to_call());
                company_name_2.setText(datas.getCompany_name());
                Glide.with(context).load(Constants.BASE_IMAGES_URL + datas.getCompany_logo()).into(company_logo_2);
            }
        }

    }
}

