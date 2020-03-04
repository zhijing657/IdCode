package com.zhijing.shoppingcenter.IdCode.Product.getExcel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentProvider;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.zhijing.shoppingcenter.IdCode.Product.getExcel.adapter.ShowProgrammeAdapter;
import com.zhijing.shoppingcenter.IdCode.Product.getExcel.bean.Programme;
import com.zhijing.shoppingcenter.R;
import com.zhijing.shoppingcenter.utils.Constants;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import okhttp3.Call;

public class GetExcelActivity extends AppCompatActivity {

    private Context context;
    private ShowProgrammeAdapter adapter;
    private RecyclerView showProgramme;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_excel);
        initStatusBar();
        getData();
        context=this;
        showProgramme = findViewById(R.id.showProgramme);
    }
    private void getData() {
        String url = Constants.PROGRAMME_INFO;
        OkHttpUtils
                .get()
                .url(url)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.e("response", "数据请求失败  "  + e.getMessage());
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.e("response", "数据请求成功  "  + response);
                        processData(response);
                    }
                });
    }

    private void processData(String response) {
        Programme programme = JSON.parseObject(response, Programme.class);
        List<Programme.ResultBean.ProgrammeInfoBean.ListBean> datas = programme.getResult().getProgramme_info().getList();
        adapter=new ShowProgrammeAdapter(context,datas);
        adapter.setOnClickItemListener(new ShowProgrammeAdapter.OnItemClick() {
            @Override
            public void onItemClick(int position) {
//                Toast.makeText(GetExcelActivity.this,"点击了一下"+position,Toast.LENGTH_SHORT).show();

            }
        });
        showProgramme.setAdapter(adapter);
        showProgramme.setLayoutManager(new GridLayoutManager(this,1));
    }

    private void initStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            Window window = this.getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION
                    | WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            this.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }

}
