package com.zhijing.shoppingcenter.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.zhijing.shoppingcenter.HomePage.bean.GoodsBean;
import com.zhijing.shoppingcenter.HomePage.home.HomePageFrameFragment;
import com.zhijing.shoppingcenter.R;
import com.zhijing.shoppingcenter.ShoppongCart.utils.CartStorage;
import com.zhijing.shoppingcenter.utils.Constants;

public class GoodsInfo extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout rootView;
    private ImageButton ibGoodInfoBack;
    private ImageButton ibGoodInfoMore;
    private ImageView ivGoodInfoImage;
    private TextView tvGoodInfoName;
    private TextView tvGoodInfoDesc;
    private TextView tvGoodInfoPrice;
    private TextView tvGoodInfoStore;
    private TextView tvGoodInfoStyle;
    private TextView tv_good_info_tease;
    private TextView tv_good_company_name;
    private TextView tv_good_company_location;
    private TextView tv_good_company_phone;
    private TextView tv_good_company_people;
    private TextView tv_good_info_style;
    private TextView tv_good_info_bad_time;
    private TextView goods_info_taste_1;
    private ImageView goods_info_style_logo;
    private ImageView tv_good_company_logo;
    private WebView wbGoodInfoMore;
    private LinearLayout llGoodsRoot;
    private TextView tvGoodInfoCallcenter;
    private TextView tvGoodInfoCollection;
    private TextView tvGoodInfoCart;
    private TextView company_info_3;
    private Button btnGoodInfoAddcart;

    private TextView tv_more_share;
    private TextView tv_more_search;
    private TextView tv_more_home;

    private Context context;
    private GoodsBean goodsBean;


    /**
     * Find the Views in the layout<br />
     * <br />
     * Auto-created on 2019-10-17 03:06:58 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    private void findViews() {
        rootView = (LinearLayout)findViewById( 0 );
        ibGoodInfoBack = (ImageButton)findViewById( R.id.ib_good_info_back );
        ibGoodInfoMore = (ImageButton)findViewById( R.id.ib_good_info_more );
        ivGoodInfoImage = (ImageView)findViewById( R.id.iv_good_info_image );
        tvGoodInfoName = (TextView)findViewById( R.id.tv_good_info_name );
        tvGoodInfoDesc = (TextView)findViewById( R.id.tv_good_info_desc );
        tvGoodInfoPrice = (TextView)findViewById( R.id.tv_good_info_price );
        tvGoodInfoStore = (TextView)findViewById( R.id.tv_good_info_store );
        tvGoodInfoStyle = (TextView)findViewById( R.id.tv_good_info_style );
        wbGoodInfoMore = (WebView)findViewById( R.id.wb_good_info_more );
        llGoodsRoot = (LinearLayout)findViewById( R.id.ll_goods_root );
        tvGoodInfoCallcenter = (TextView)findViewById( R.id.tv_good_info_callcenter );
        tvGoodInfoCollection = (TextView)findViewById( R.id.tv_good_info_collection );
        tvGoodInfoCart = (TextView)findViewById( R.id.tv_good_info_cart );
        btnGoodInfoAddcart = (Button)findViewById( R.id.btn_good_info_addcart );
        tv_good_info_tease = findViewById( R.id.tv_good_info_tease );
        tv_good_info_style = findViewById( R.id.tv_good_info_style );
        tv_good_info_bad_time = findViewById( R.id.tv_good_info_bad_time );
        goods_info_style_logo = findViewById( R.id.goods_info_style_logo );
        goods_info_taste_1 = findViewById( R.id.goods_info_taste_1 );
        tv_good_company_logo = findViewById( R.id.tv_good_company_logo );
        company_info_3 = findViewById( R.id.company_info_3 );
        tv_good_company_name = findViewById( R.id.tv_good_company_name );
        tv_good_company_location = findViewById( R.id.tv_good_company_location );
        tv_good_company_phone = findViewById( R.id.tv_good_company_phone );
        tv_good_company_people = findViewById( R.id.tv_good_company_people );


        tv_more_share = (TextView)findViewById( R.id.tv_more_share );
        tv_more_search = (TextView)findViewById( R.id.tv_more_search );
        tv_more_home = (TextView)findViewById( R.id.tv_more_home );

        ibGoodInfoBack.setOnClickListener( this );
        ibGoodInfoMore.setOnClickListener( this );
        btnGoodInfoAddcart.setOnClickListener( this );

        tvGoodInfoCallcenter.setOnClickListener(this);
        tvGoodInfoCollection.setOnClickListener(this);
        tvGoodInfoCart.setOnClickListener(this);

        tv_more_share.setOnClickListener(this);
        tv_more_search.setOnClickListener(this);
        tv_more_home.setOnClickListener(this);


    }

    /**
     * Handle button click events<br />
     * <br />
     * Auto-created on 2019-10-17 03:06:58 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    @Override
    public void onClick(View v) {
        if ( v == ibGoodInfoBack ) {
            finish();
            // Handle clicks for ibGoodInfoBack
        } else if ( v == ibGoodInfoMore ) {
            Toast.makeText(context,"更多",Toast.LENGTH_SHORT).show();
            // Handle clicks for ibGoodInfoMore
        } else if ( v == btnGoodInfoAddcart ) {
            // Handle clicks for btnGoodInfoAddcart
            CartStorage.getInstance().addData(goodsBean);
            Toast.makeText(context,"加入购物车",Toast.LENGTH_SHORT).show();

        }else if (v == tvGoodInfoCallcenter){
            Toast.makeText(context,"客服",Toast.LENGTH_SHORT).show();
        }else if (v == tvGoodInfoCollection){
            Toast.makeText(context,"收藏",Toast.LENGTH_SHORT).show();
        }else if (v == tvGoodInfoCart){
            Toast.makeText(context,"购物车",Toast.LENGTH_SHORT).show();
        }else if (v == tv_more_share){
            Toast.makeText(context,"分享",Toast.LENGTH_SHORT).show();
        }else if (v == tv_more_search){
            Toast.makeText(context,"搜索",Toast.LENGTH_SHORT).show();
        }else if (v == tv_more_home){
            Toast.makeText(context,"首页",Toast.LENGTH_SHORT).show();
        }
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.goods_info);
        findViews();
        context = getApplicationContext();

       goodsBean = (GoodsBean) getIntent().getSerializableExtra("goodsbean");
//       if (goodsBean !=null){
//           Toast.makeText(context,"goodBean = "+ goodsBean.toString(),Toast.LENGTH_SHORT).show();
//       }
        setDataForView(goodsBean);
    }
        String url;
    private void setDataForView(GoodsBean goodsBean) {
        Log.e("ZHIJING_data", goodsBean.toString() );
        Glide.with(context).load(Constants.BASE_IMAGES_URL + goodsBean.getFigure()).into(ivGoodInfoImage);
        tvGoodInfoName.setText(goodsBean.getName());
        tvGoodInfoPrice.setText("￥"+goodsBean.getCover_price());
        tvGoodInfoStore.setText(goodsBean.getCompany_name());
        tv_good_info_tease.setText(goodsBean.getTaste());
        goods_info_taste_1.setText(goodsBean.getTaste());
        tv_good_info_style.setText(goodsBean.getSpecs());
        tvGoodInfoDesc.setText(goodsBean.getProduct());
        tv_good_info_bad_time.setText(goodsBean.getDate_of_bad());
        company_info_3.setText(goodsBean.getCompany_info());
        tv_good_company_name.setText(goodsBean.getCompany_name());
        tv_good_company_location.setText(goodsBean.getCompany_location());
        tv_good_company_people.setText(goodsBean.getCompany_people());
        tv_good_company_phone.setText(goodsBean.getCompany_phone());
        Glide.with(context).load(Constants.BASE_IMAGES_URL + goodsBean.getLogo()).into(goods_info_style_logo);
        Glide.with(context).load(Constants.BASE_IMAGES_URL + goodsBean.getCompany_logo()).into(tv_good_company_logo);
        url = goodsBean.getUrl();
        setWebViewData(goodsBean.getGoods_id());
    }

    private void setWebViewData(String goods_id) {
        if (goods_id!=null){
            wbGoodInfoMore.loadUrl(url);
            WebSettings webSettings = wbGoodInfoMore.getSettings();
            webSettings.setUseWideViewPort(true);
            webSettings.setJavaScriptEnabled(true);
            webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
            wbGoodInfoMore.setWebViewClient(new WebViewClient(){
//                @Override
//                public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
//                    view.loadUrl(request.getUrl().toString());
//                    return true;
//                }
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    view.loadUrl(url);
                    return true;
                }
            });
        }
    }


}
