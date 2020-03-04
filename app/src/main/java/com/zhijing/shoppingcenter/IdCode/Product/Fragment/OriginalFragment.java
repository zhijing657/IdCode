package com.zhijing.shoppingcenter.IdCode.Product.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.fastjson.JSON;
import com.zhijing.shoppingcenter.HomePage.bean.GoodsBean;
import com.zhijing.shoppingcenter.HomePage.home.HomePageFrameFragment;
import com.zhijing.shoppingcenter.IdCode.Product.Adapter.FirstOriginalFragmentAdapter;
import com.zhijing.shoppingcenter.IdCode.Product.Adapter.SecondOriginalFragmentAdapter;
import com.zhijing.shoppingcenter.IdCode.Product.Adapter.ThirdOriginalFragmentAdapter;
import com.zhijing.shoppingcenter.IdCode.Product.ProductDetails;
import com.zhijing.shoppingcenter.IdCode.Product.RestuleBean.OriginalInfo;
import com.zhijing.shoppingcenter.IdCode.Product.RestuleBean.ProductData;
import com.zhijing.shoppingcenter.IdCode.Product.getExcel.GetExcelActivity;
import com.zhijing.shoppingcenter.IdCode.Product.getExcel.GetExcelFragment;
import com.zhijing.shoppingcenter.R;
import com.zhijing.shoppingcenter.app.GoodsInfo;
import com.zhijing.shoppingcenter.utils.Constants;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import okhttp3.Call;

public class OriginalFragment extends Fragment {

    private RecyclerView FIRST, SECOND, THIRD;
    private Context context;
    private FirstOriginalFragmentAdapter firstOriginalFragmentAdapter;
    private SecondOriginalFragmentAdapter secondOriginalFragmentAdapter;
    private ThirdOriginalFragmentAdapter thirdOriginalFragmentAdapter;
    private final String TAG = OriginalFragment.class.getName();
    private ProductData.ResultBean productBean;
    private ProductData.ResultBean.ProductInfoBean.ListBean datas;
    private static final String PRODUCTDETAILS = "productDetails";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = View.inflate(context, R.layout.original_fragment, null);
        FIRST = view.findViewById(R.id.FIRST);
        SECOND = view.findViewById(R.id.SECOND);
        THIRD = view.findViewById(R.id.THIRD);
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
                        //Log.e(TAG, "产品描述页面数据请求失败  "  + e.getMessage());
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        // Log.e(TAG, "产品描述页面数据请求成功  "  + response);
                        processData(response);
                    }
                });
    }

    private String a = null;
    int bbb = 0;

    private void processData(String json) {

        ProductData productData = JSON.parseObject(json, ProductData.class);
        productBean = productData.getResult();
        String qrCode = HomePageFrameFragment.open_url.replaceAll("\\s*", "");
        List<ProductData.ResultBean.ProductInfoBean.ListBean> list = productBean.getProduct_info().getList();
        for (int i = 0; i < productBean.getProduct_info().getList().size(); i++) {
            a = list.get(i).getCode();
            if (a.equalsIgnoreCase(qrCode.substring(qrCode.length() - 10))) {
                datas = list.get(i);
                Log.e(TAG, "processData: YES" );
                //检测信息的适配器
                firstOriginalFragmentAdapter = new FirstOriginalFragmentAdapter(context, datas);
                FIRST.setAdapter(firstOriginalFragmentAdapter);
                FIRST.setLayoutManager(new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false));

                //生产工艺的适配器
                secondOriginalFragmentAdapter = new SecondOriginalFragmentAdapter(context, datas);
                SECOND.setAdapter(secondOriginalFragmentAdapter);
                SECOND.setLayoutManager(new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false));
                secondOriginalFragmentAdapter.addFooterView(LayoutInflater.from(getActivity()).inflate(R.layout.thrid_original_fragment_item_footer, null));
                secondOriginalFragmentAdapter.addHeaderView(LayoutInflater.from(getActivity()).inflate(R.layout.thrid_original_fragment_item_header, null));
                secondOriginalFragmentAdapter.setOnSecondOriginalFragmentRecylerView(new SecondOriginalFragmentAdapter.OnSecondOriginalFragmentRecylerView() {
                    @Override
                    public void OnItemClick(int postion) {


                        if (postion == 0) {
                            Toast.makeText(getActivity(), "源材料", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getActivity(), GetExcelActivity.class);
                            startActivity(intent);
                        } else if (postion == datas.getWorkmanship_name().getWorkmanship_nameList().size() + 1) {
                            Toast.makeText(getActivity(), "成品", Toast.LENGTH_SHORT).show();
                        } else {
                            OriginalInfo originalInfo = new OriginalInfo();
                            //Log.e(TAG, "postion3 " + postion);
                            //originalInfo.setFunction(datas.getProduction_fountion().getProduction_fountionList().get(postion-1).getProduction_fountion());
                            originalInfo.setFunction(datas.getWorkmanship_fountion().getWorkmanship_fountionList().get(postion - 1).getWorkmanship_fountion());
                            originalInfo.setName(datas.getWorkmanship_name().getWorkmanship_nameList().get(postion - 1).getWorkmanship_name());
                            originalInfo.setPicture(datas.getWorkmanship_photo().getWorkmanshipList().get(postion - 1).getWorkmanship_photo());
                            originalInfo.setTitle("工艺详情");
                            //originalInfo.setPhoto(datas.getInspect_photo().getInspectPhotoList().get(postion-1).getInspect_photo());
                            originalInfo.setPhoto(datas.getInspect_photo().getInspectPhotoList().get(postion - 1).getInspect_photo());
                            originalInfo.setInspect_name(datas.getInspect_name().getInspectNameList().get(postion - 1).getInspect_name());
                            originalInfo.setInspect_type(datas.getInspec_type().getInspec_typeList().get(postion - 1).getInspec_type());
                            originalInfo.setShow(1);
                            Intent intent = new Intent(getContext(), ProductDetails.class);
                            intent.putExtra(PRODUCTDETAILS, originalInfo);
                            startActivity(intent);
                        }
                    }
                });

                //生产设备的适配器
                thirdOriginalFragmentAdapter = new ThirdOriginalFragmentAdapter(context, datas);
                THIRD.setAdapter(thirdOriginalFragmentAdapter);
                THIRD.setLayoutManager(new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false));

                thirdOriginalFragmentAdapter.setOnThridViewItemClick(new ThirdOriginalFragmentAdapter.OnThridViewItemClick() {
                    @Override
                    public void OnItemClick(int postion) {
                        OriginalInfo originalInfo = new OriginalInfo();
                        Log.e(TAG, "processData: yes");
                        //originalInfo.setName(datas.getInspect_name().getInspectNameList().get(postion).getInspect_name());
                        originalInfo.setName(datas.getInspect_name().getInspectNameList().get(postion).getInspect_name());
                        originalInfo.setFunction(datas.getInspec_fountion().getInspec_fountionList().get(postion).getInspec_fountion());
                        originalInfo.setTitle("设备详情");
                        //originalInfo.setPicture(datas.getInspect_photo().getInspectPhotoList().get(postion).getInspect_photo());
                        originalInfo.setPicture(datas.getInspect_photo().getInspectPhotoList().get(postion).getInspect_photo());
                        originalInfo.setShow(2);
                        originalInfo.setManufacturer_info(datas.getManufacturer().getManufacturer_infoList().get(postion).getManufacturer_info());
                        originalInfo.setManufacturer_location(datas.getManufacturer().getManufacturer_infoList().get(postion).getManufacturer_location());
                        originalInfo.setManufacturer_name(datas.getManufacturer().getManufacturer_infoList().get(postion).getManufacturer_name());
                        originalInfo.setManufacturer_phone(datas.getManufacturer().getManufacturer_infoList().get(postion).getManufacturer_phone());
                        Intent intent = new Intent(getActivity(), ProductDetails.class);
                        intent.putExtra(PRODUCTDETAILS, originalInfo);
                        startActivity(intent);
                    }
                });
            }
        }
    }
}
