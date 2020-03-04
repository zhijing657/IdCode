package com.zhijing.shoppingcenter.IdCode.Product.Fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import androidx.fragment.app.Fragment;

import com.alibaba.fastjson.JSON;
import com.zhijing.shoppingcenter.HomePage.home.HomePageFrameFragment;
import com.zhijing.shoppingcenter.IdCode.Product.RestuleBean.ProductData;
import com.zhijing.shoppingcenter.R;
import com.zhijing.shoppingcenter.utils.Constants;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import okhttp3.Call;


public class WebViewFragment extends Fragment {

    private static final String TAG = WebViewFragment.class.getName();
    private Context context;
    private WebView webView;
    private ProductData.ResultBean productBean;
    private ProductData.ResultBean.ProductInfoBean.ListBean datas;
    private String a;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = View.inflate(context, R.layout.webview_fragment,null);
        webView = view.findViewById(R.id.webview);
        return view;
    }

    private String url;
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getData();
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void setWebViewData(final String url) {
        if (url!=null){
            //textView.setText(url);
            //Log.e("URL", "setWebViewData: url = " + url);
            WebSettings mWebSettings = webView.getSettings();
            mWebSettings.setJavaScriptCanOpenWindowsAutomatically(true);//设置js可以直接打开窗口，如window.open()，默认为false
            mWebSettings.setJavaScriptEnabled(true);//是否允许JavaScript脚本运行，默认为false。设置true时，会提醒可能造成XSS漏洞
            mWebSettings.setSupportZoom(true);//是否可以缩放，默认true
            mWebSettings.setBuiltInZoomControls(true);//是否显示缩放按钮，默认false
            mWebSettings.setUseWideViewPort(true);//设置此属性，可任意比例缩放。大视图模式
            mWebSettings.setLoadWithOverviewMode(true);//和setUseWideViewPort(true)一起解决网页自适应问题
            mWebSettings.setAppCacheEnabled(true);//是否使用缓存
            mWebSettings.setDomStorageEnabled(true);//开启本地DOM存储
            mWebSettings.setLoadsImagesAutomatically(true); // 加载图片
            mWebSettings.setMediaPlaybackRequiresUserGesture(false);//播放音频，多媒体需要用户手动？设置为false为可自动播放
            webView.loadUrl(url);

            webView.setWebViewClient(new WebViewClient(){
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    view.loadUrl(url);
                    //Log.e("URl;", "shouldOverrideUrlLoading: url ="+ url);
                    return true;
                }

                @Override
                public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                    view.loadUrl(request.getUrl().toString());
                    //Log.e("URL", "shouldOverrideUrlLoading: request ="+request.getUrl().toString().trim());
                    return true;
                }

                @Override
                public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                    handler.proceed();
                    super.onReceivedSslError(view, handler, error);
                }
            });
        }
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

    private void processData(String json) {
        ProductData productData = JSON.parseObject(json, ProductData.class);
        productBean = productData.getResult();
        List<ProductData.ResultBean.ProductInfoBean.ListBean> list = productBean.getProduct_info().getList();
        String qrcode = HomePageFrameFragment.open_url.replaceAll("\\s*","");
        for(int i = 0;i<productBean.getProduct_info().getList().size();i++){


            datas = list.get(i);
            a = datas.getCode();

            //Log.e(TAG, "code_result1:"+code_result);
            //Log.e(TAG, "code_result2:"+ qrcode.substring(qrcode.length()-10,qrcode.length()));
            /**
             * 根据扫码得出的名字与json中产品名进行比较
             */
            if (a.equals(qrcode.substring(qrcode.length()-10,qrcode.length()))){
                //Log.e(TAG, "processData: YES" );

                url = datas.getUrl();
                setWebViewData(url);
            }
        }

//        Glide.with(context).load(Constants.BASE_IMAGES_URL + companyBean.getCompany_info().getList().get(0).getFigure()).into(CompanyLogo);
//        CompanyName.setText(a);
//        companyIntroduction.setText(companyBean.getCompany_info().getList().get(0).getArticle());

        //Log.e(TAG, "Product_name: "+a );
    }
}
