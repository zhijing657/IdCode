package com.zhijing.shoppingcenter.HomePage.home;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Color;
import android.os.Build;
import android.util.JsonReader;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.view.ViewCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.fastjson.JSON;
import com.bumptech.glide.Glide;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.zhijing.shoppingcenter.HomePage.adapter.HomePageAdapter;
import com.zhijing.shoppingcenter.HomePage.bean.ResultBeanData;
import com.zhijing.shoppingcenter.IdCode.Product.Adapter.DescribeFragmentAdapter;
import com.zhijing.shoppingcenter.IdCode.Product.ProductDetails;
import com.zhijing.shoppingcenter.IdCode.Product.Product_info;
import com.zhijing.shoppingcenter.IdCode.Product.RestuleBean.ProductData;
import com.zhijing.shoppingcenter.IdCode.company.CompanyDetails;
import com.zhijing.shoppingcenter.R;
import com.zhijing.shoppingcenter.ShoppongCart.Adapter.ShoppingCartAdapter;
import com.zhijing.shoppingcenter.app.WebViewActivity;
import com.zhijing.shoppingcenter.base.BaseFragment;
import com.zhijing.shoppingcenter.utils.Constants;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import okhttp3.Call;

public class HomePageFrameFragment extends BaseFragment {

    private static final String TAG = HomePageFrameFragment.class.getName();
    private TextView search;
    private TextView idCode;
    private RecyclerView rvHome;
    private ImageButton ib_top;
    private HomePageAdapter homePageAdapter;

    public static String open_url = null;
    private String showcode = null;
    private String getCodeResult;
    private static boolean isCode = false;
    private static boolean isFlag = false;
    /**
     * 返回的数据
     */
    private ResultBeanData.ResultBean resultBean;
    private ProductData.ResultBean productBean;
    private AlertDialog.Builder builder;
    private String showResult;

    @Override
    protected View initView() {
        Log.d(TAG, "首页被创建 ");
        View view = View.inflate(context, R.layout.hg_frame_fragment, null);
        search = view.findViewById(R.id.search);
        idCode = view.findViewById(R.id.idCode);
        rvHome = view.findViewById(R.id.rv_home);
        ib_top = view.findViewById(R.id.ib_top);

        initListener();
        initStatusBar();//初始化 状态栏
        return view;
    }

    private void initStatusBar() {
//        View decorView = getActivity().getWindow().getDecorView();
//        int option = View.SYSTEM_UI_FLAG_FULLSCREEN;
//        decorView.setSystemUiVisibility(option);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getActivity().getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION
                    | WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }

    private void initListener() {
        ib_top.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //rvHome.scrollToPosition(0); //置顶
//                NavController controller = Navigation.findNavController(v);
//                controller.navigate(R.id.action_homePageFrameFragment_to_typeFrameFragment);
            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ProductDetails.class);
                startActivity(intent);
            }
        });

        idCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getIdCode();
                isCode = true;
                //Toast.makeText(context,"IdCode",Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void getIdCode() {
        IntentIntegrator integrator = IntentIntegrator.forSupportFragment(this);
        // 设置要扫描的条码类型，ONE_D_CODE_TYPES：一维码，QR_CODE_TYPES-二维码
//        integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
//        integrator.setCaptureActivity(ScanActivity.class);
        integrator.setPrompt("将二维码放到框内即可"); //底部的提示文字，设为""可以置空
//        integrator.setCameraId(0); //前置或者后置摄像头
        integrator.setBeepEnabled(true); //扫描成功的「哔哔」声，默认开启
//        integrator.setBarcodeImageEnabled(true);
        integrator.initiateScan();
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() == null) {
                Toast.makeText(context, "取消扫描", Toast.LENGTH_SHORT).show();
                isCode = false;
            } else {
                Toast.makeText(context, result.getContents(), Toast.LENGTH_SHORT).show();
                open_url = result.getContents();
                showcode = result.getContents();
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }


    @Override
    protected void initData() {
        Log.d(TAG, "首页数据被创建 ");
        super.initData();
        //showcode = null;
        getDate();
        getProductData();
    }

    private void getDate() {
        String url = Constants.HOME_URL;
        OkHttpUtils
                .get()
                .url(url)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        //Log.d(TAG, "主页数据请求失败  " + e.getMessage());
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.d(TAG, "主页数据请求成功  " + response);
                        processData(response);

                    }
                });
    }

    private void processData(String json) {
        ResultBeanData resultBeanData = JSON.parseObject(json, ResultBeanData.class);
        resultBean = resultBeanData.getResult();

        if (resultBean != null) {
            Log.e(TAG, "processData: resultBean != null");
            homePageAdapter = new HomePageAdapter(context, resultBean);
            rvHome.setAdapter(homePageAdapter);
            rvHome.setLayoutManager(new GridLayoutManager(context, 1));
            GridLayoutManager manager = new GridLayoutManager(context, 1);
            manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    if (position == 5) {
                        ib_top.setVisibility(View.VISIBLE);
                        //Log.e(TAG1, "View.VISIBLE");
                    } else {
                        ib_top.setVisibility(View.GONE);
                        //Log.e(TAG1, "View.GONE");
                    }
                    return 1;
                }
            });
        } else {

        }
    }

    @Override
    public void onResume() {
        super.onResume();
        initData();
    }

    private void getProductData() {
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
                    private String code = null;
                    @Override
                    public void onResponse(String response, int id) {


                        Log.e(TAG, "产品描述页面数据请求成功  " + response);
                        ProductData productData  = JSON.parseObject(response,ProductData.class);

                        if (showcode != null && showcode.length()>=10){
                            showResult = showcode.substring(showcode.length()-10).replaceAll("\\s*","");
                            for (int i = 0;i<productData.getResult().getProduct_info().getList().size();i++){
                                code = productData.getResult().getProduct_info().getList().get(i).getCode();
                                if (showResult.equalsIgnoreCase(code)){
                                    isFlag = true;
                                    Intent intent = new Intent(getActivity(),Product_info.class);
                                    startActivity(intent);
                                    showcode = null;
                                    break;
                                }

                            }
                        }
                        if (isFlag == false && isCode == true){
                            show_choose();
                        }
                    }
                });
    }




    private void show_choose() {
        final AlertDialog.Builder alerDialog = new AlertDialog.Builder(getActivity());
        alerDialog.setIcon(R.mipmap.lcy);
        alerDialog.setTitle("错误");
        alerDialog.setMessage("请检查是否正确");
        alerDialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getContext(),"取消",Toast.LENGTH_SHORT).show();
                dialog.cancel();
                Log.e(TAG, "cancel:");
            }
        });

        alerDialog.setPositiveButton("再扫一次", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
//                Toast.makeText(getContext(),"点击了再扫一次",Toast.LENGTH_SHORT).show();
                getIdCode();
            }
        });
        alerDialog.show();
    }
}



