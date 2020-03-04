package com.zhijing.shoppingcenter.IdCode.Product.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.fastjson.JSON;
import com.zhijing.shoppingcenter.HomePage.home.HomePageFrameFragment;
import com.zhijing.shoppingcenter.IdCode.Product.Adapter.FirstOriginalFragmentAdapter;
import com.zhijing.shoppingcenter.IdCode.Product.Adapter.ParameterFragmentAdapter;
import com.zhijing.shoppingcenter.IdCode.Product.RestuleBean.ProductData;
import com.zhijing.shoppingcenter.R;
import com.zhijing.shoppingcenter.utils.Constants;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import okhttp3.Call;

public class ParameterFragment extends Fragment {
    private Context context;
    private final String TAG = ParameterFragment.class.getName();
    private ProductData.ResultBean productBean;
    private ProductData.ResultBean.ProductInfoBean.ListBean datas;
    private TextView wd_3, code_type, specs_3, code;
    private RecyclerView parameter_fragment_view;
    private ParameterFragmentAdapter adapter;
    private List<ProductData.ResultBean.ProductInfoBean.ListBean.AllCODEBean.AllCodeListBean> dataslist;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getActivity();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = View.inflate(context, R.layout.parameter_fragment, null);
        wd_3 = view.findViewById(R.id.wd_3);
        code_type = view.findViewById(R.id.code_type);
        specs_3 = view.findViewById(R.id.specs_3);
        code = view.findViewById(R.id.code);
        parameter_fragment_view = view.findViewById(R.id.parameter_fragment_view);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getData();
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
                        //Log.e(TAG, "产品描述页面数据请求成功  "  + response);
                        processData(response);
                    }
                });
    }

    private String a = null;

    //    SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
    //    Date curdate = new Date(System.currentTimeMillis());
    private void processData(String json) {
        ProductData productData = JSON.parseObject(json, ProductData.class);
        productBean = productData.getResult();
        List<ProductData.ResultBean.ProductInfoBean.ListBean> list = productBean.getProduct_info().getList();
        String qrcode = HomePageFrameFragment.open_url.replaceAll("\\s*", "");
        for (int i = 0; i < productBean.getProduct_info().getList().size(); i++) {

            datas = list.get(i);
            a = datas.getCode();
            //Log.e(TAG, "code_result1:"+code_result);
            //Log.e(TAG, "code_result2:"+ qrcode.substring(qrcode.length()-10,qrcode.length()));
            /**
             * 根据扫码得出的名字与json中产品名进行比较
             */
            if (a.equalsIgnoreCase(qrcode.substring(qrcode.length() - 10, qrcode.length()))) {
                wd_3.setText(datas.getTaste());
                code_type.setText(datas.getCode_type());
                specs_3.setText(datas.getSpecs());
                code.setText(datas.getOne_code());

                dataslist = datas.getAll_CODE().getAll_code_list();
                adapter = new ParameterFragmentAdapter(context, dataslist);
                parameter_fragment_view.setAdapter(adapter);
                parameter_fragment_view.setLayoutManager(new LinearLayoutManager(context, RecyclerView.VERTICAL, false));
            }
        }

    }
}
