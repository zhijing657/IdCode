package com.zhijing.shoppingcenter.IdCode.Product;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.zhijing.shoppingcenter.IdCode.Product.RestuleBean.OriginalInfo;
import com.zhijing.shoppingcenter.R;
import com.zhijing.shoppingcenter.utils.Constants;

public class ProductDetails extends AppCompatActivity {


    private TextView product_details_name, product_details;
    private TextView inspect_name, textView5, textView9,equipment_type;
    private TextView manufacturer_name, manufacturer_location, manufacturer_phone, manufacturer_info;
    private ImageView inspect_photo;
    private ImageView product_details_logo;
    private OriginalInfo originalInfo;
    private Toolbar toolbar;
    private View equipment_layout;
    private View manufacturer_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prodict_details);

        product_details_name = findViewById(R.id.product_details_name);
        product_details = findViewById(R.id.product_details);
        product_details_logo = findViewById(R.id.product_details_logo);
        toolbar = findViewById(R.id.toolbar3);
        inspect_name = findViewById(R.id.equipment_name);
        equipment_type = findViewById(R.id.equipment_type);
        inspect_photo = findViewById(R.id.equipment_logo);
        equipment_layout = findViewById(R.id.equipment_layout);
        manufacturer_view = findViewById(R.id.manufacturer_view);
        textView5 = findViewById(R.id.textView5);
        textView9 = findViewById(R.id.textView9);

        manufacturer_name = findViewById(R.id.manufacturer_name);
        manufacturer_location = findViewById(R.id.manufacturer_location);
        manufacturer_phone = findViewById(R.id.manufacturer_phone);
        manufacturer_info = findViewById(R.id.manufacturer_info);


        originalInfo = (OriginalInfo) getIntent().getSerializableExtra("productDetails");
        setDataForView(originalInfo);
        initStatusBar();
    }

    public void setDataForView(OriginalInfo originalInfo) {
        product_details.setText("\u3000\u3000" + originalInfo.getFunction());
        product_details_name.setText(originalInfo.getName());
        manufacturer_name.setText(originalInfo.getManufacturer_name());
        manufacturer_location.setText(originalInfo.getManufacturer_location());
        manufacturer_phone.setText(originalInfo.getManufacturer_phone());
        manufacturer_info.setText(originalInfo.getManufacturer_info());
        Glide.with(this).load(Constants.BASE_IMAGES_URL + originalInfo.getPicture())
                .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                .into(product_details_logo);
        toolbar.setTitle(originalInfo.getTitle());

        inspect_name.setText("\u3000"+originalInfo.getInspect_name());
        equipment_type.setText("\u3000"+originalInfo.getInspect_type());
        Glide.with(this).load(Constants.BASE_IMAGES_URL + originalInfo.getPhoto()).into(inspect_photo);

        //工艺
        if (originalInfo.getShow() == 1) {
            //显示地信息
            textView5.setVisibility(View.VISIBLE);
            equipment_layout.setVisibility(View.VISIBLE);

            //隐藏的信息
            manufacturer_view.setVisibility(View.GONE);
            textView9.setVisibility(View.GONE);
            originalInfo.setShow(0);
        }
        //设备
        if (originalInfo.getShow() == 2) {
            //隐藏地信息
            textView5.setVisibility(View.GONE);
            equipment_layout.setVisibility(View.GONE);

            //显示的信息
            textView9.setVisibility(View.VISIBLE);
            textView9.setTextColor(Color.DKGRAY);
            manufacturer_view.setVisibility(View.VISIBLE);


            //初始化
            originalInfo.setShow(0);
        }
    }

    private void initStatusBar() {
//        View decorView = getActivity().getWindow().getDecorfView();
//        int option = View.SYSTEM_UI_FLAG_FULLSCREEN;
//        decorView.setSystemUiVisibility(option);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = this.getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION
                    | WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            this.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }

}
