package com.zhijing.shoppingcenter.IdCode.Product.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.fastjson.JSON;
import com.bumptech.glide.Glide;
import com.zhijing.shoppingcenter.HomePage.home.HomePageFrameFragment;
import com.zhijing.shoppingcenter.IdCode.Product.Adapter.DescribeFragmentAdapter;
import com.zhijing.shoppingcenter.IdCode.Product.RestuleBean.ProductData;
import com.zhijing.shoppingcenter.IdCode.Product.Times.Group;
import com.zhijing.shoppingcenter.IdCode.Product.Times.Times;
import com.zhijing.shoppingcenter.R;
import com.zhijing.shoppingcenter.utils.Constants;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class DescribeFragment extends Fragment {

    private static final String TAG = DescribeFragment.class.getName();
    private Context context;
    private TextView product_name, phone_to_buy, price, date_of_make, date_of_now, date_of_bad;
    private TextView name, time, bad, wd, product, company,Activity_name,specs;
    private ImageView figure, figure_2, company_logo;
    private EditText Verification_Code;
    private RecyclerView activity;
    private DescribeFragmentAdapter adapter;
    private ProductData.ResultBean productBean;
    ProductData.ResultBean.ProductInfoBean.ListBean datas;
    public List<ProductData.ResultBean.ProductInfoBean.ListBean.ActivityBean.ActivityListBean> datasList;
    private String qrcode;
    private List<ProductData.ResultBean.ProductInfoBean.ListBean> list;
    private static int times;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getActivity();
    }

    //创建页面
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = View.inflate(context, R.layout.describe_fragment, null);
        activity = view.findViewById(R.id.activity_view);
        Verification_Code = view.findViewById(R.id.Verification_Code);
        product_name = view.findViewById(R.id.product_name);
        figure = view.findViewById(R.id.figure);
        phone_to_buy = view.findViewById(R.id.phone_to_buy);
        price = view.findViewById(R.id.price);
        date_of_make = view.findViewById(R.id.date_of_make);
        date_of_now = view.findViewById(R.id.date_of_now);
        date_of_bad = view.findViewById(R.id.date_of_bad);
        name = view.findViewById(R.id.name);
        time = view.findViewById(R.id.time);
        bad = view.findViewById(R.id.bad);
        wd = view.findViewById(R.id.wd);
        figure_2 = view.findViewById(R.id.figure_2);
        product = view.findViewById(R.id.product);
        company_logo = view.findViewById(R.id.company_logo);
        company = view.findViewById(R.id.company);
        Activity_name = view.findViewById(R.id.Activity_name);
        specs = view.findViewById(R.id.specs);
        //ShowTimes = view.findViewById(R.id.Times_show);

        return view;
    }

    //绑定数据
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getData();
        //setJson();
    }

    private void getData() {
        String url = Constants.PRODUCT_INFO;
        OkHttpUtils
                .post()
                .url(url)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.e(TAG, "产品描述页面数据请求失败  " + e.getMessage());
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.e(TAG, "产品描述页面数据请求成功  " + response);
                        processData(response);
                    }
                });
    }


    private String a = null;
    SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
    Date curdate = new Date(System.currentTimeMillis());

    private void processData(String json) {
        //parseObject 将json字符串反序列化为java.class
        ProductData productData = JSON.parseObject(json, ProductData.class);

        productBean = productData.getResult();
        qrcode = HomePageFrameFragment.open_url.replaceAll("\\s*", "");
        list = productBean.getProduct_info().getList();

        for (int i = 0; i < productBean.getProduct_info().getList().size(); i++) {
            datas = list.get(i);
            a = datas.getCode();

            if (a.equalsIgnoreCase(qrcode.substring(qrcode.length() - 10))) {
                //Log.e(TAG, "processData: YES" );
                specs.setText(datas.getSpecs());
                Activity_name.setText(a);
                product_name.setText(datas.getProduct_name());
                Glide.with(context).load(Constants.BASE_IMAGES_URL + datas.getFigure()).into(figure);
                phone_to_buy.setText(datas.getPhone_to_buy());
                price.setText(datas.getPrice());
                date_of_bad.setText(datas.getDate_of_bad());
                date_of_make.setText(datas.getDate_of_make());
                date_of_now.setText(date.format(curdate));
                name.setText(datas.getProduct_name());
                time.setText(datas.getDate_of_make());
                bad.setText(datas.getDate_of_bad());
                wd.setText(datas.getTaste().toString().trim());
                Glide.with(context).load(Constants.BASE_IMAGES_URL + datas.getFigure()).into(figure_2);
                product.setText(datas.getProduct());
                Glide.with(context).load(Constants.BASE_IMAGES_URL + datas.getCompany_logo()).into(company_logo);
                company.setText(datas.getCompany());

                //设置活动的适配器
                adapter = new DescribeFragmentAdapter(context, datasList);
                activity.setAdapter(adapter);
                //设置布局管理器
                activity.setLayoutManager(new LinearLayoutManager(context, RecyclerView.VERTICAL, false));
            }
        }
    }

}
