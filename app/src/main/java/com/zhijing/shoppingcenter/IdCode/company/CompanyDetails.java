package com.zhijing.shoppingcenter.IdCode.company;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.bumptech.glide.Glide;
import com.zhijing.shoppingcenter.IdCode.company.Adapter.BrandAdapter;
import com.zhijing.shoppingcenter.IdCode.company.Adapter.ConsultationAdapter;
import com.zhijing.shoppingcenter.IdCode.company.Adapter.StaffAdapter;
import com.zhijing.shoppingcenter.IdCode.company.resultBean.CompanyData;
import com.zhijing.shoppingcenter.R;
import com.zhijing.shoppingcenter.utils.Constants;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import okhttp3.Call;

public class CompanyDetails extends AppCompatActivity {

    private String TAG = CompanyDetails.class.getName();
    private ImageView CompanyLogo;
    private TextView CompanyName,companyIntroduction;
    private RecyclerView employee,brand,consultation;
    private CompanyData.ResultBean companyBean;
    private BrandAdapter brandAdapter;
    private StaffAdapter staffAdapter;
    private ConsultationAdapter consultationAdapter;

    protected Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.company_details);
        context = this;


        CompanyLogo=findViewById(R.id.CompanyLogo);
        CompanyName=findViewById(R.id.CompanyName);
        companyIntroduction=findViewById(R.id.companyIntroduction);

        employee=findViewById(R.id.employee);//公司员工
        brand=findViewById(R.id.brand);//公司品牌
        consultation=findViewById(R.id.Consultation);//公司品牌
        getData();

    }
    private void getData() {
        String url = Constants.BRAND_URL;
        OkHttpUtils
                .get()
                .url(url)
                .build()
                .execute(new StringCallback()
                {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.d(TAG, "页面数据请求失败  "  + e.getMessage());
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.d(TAG, "页面数据请求成功  "  + response);
                        processData(response);
                    }
                });
    }

    private void processData(String json) {
        CompanyData companyData = JSON.parseObject(json, CompanyData.class);
        companyBean = companyData.getResult();

        showData(companyBean.getBrand_info());
        showWorkerData(companyBean.getStaff_info());
        showConsultationData(companyBean.getConsultation_info());

        Log.e(TAG, ": " + companyBean.getBrand_info() );
        String a = companyBean.getCompany_info().getList().get(0).getName();
        Glide.with(context).load(Constants.BASE_IMAGES_URL + companyBean.getCompany_info().getList().get(0).getFigure()).into(CompanyLogo);
        CompanyName.setText(a);
        companyIntroduction.setText(companyBean.getCompany_info().getList().get(0).getArticle());
        Log.e(TAG, "processData: "+a );
    }

    private void showData(final CompanyData.ResultBean.BrandInfoBean brand_info) {
            brandAdapter = new BrandAdapter(context,brand_info.getList());
            brand.setAdapter(brandAdapter);
            brand.setLayoutManager(new LinearLayoutManager(context,RecyclerView.HORIZONTAL,false));

        brandAdapter.setOnBrandRecylerView(new BrandAdapter.OnBrandRecylerView() {
            @Override
            public void OnItemClick(int postion) {
                String name = companyBean.getBrand_info().getList().get(postion).getName();
                Toast.makeText(context,"item : " + name,Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void showWorkerData(final CompanyData.ResultBean.StaffInfoBean staffInfoBean) {
        staffAdapter = new StaffAdapter(context,staffInfoBean.getList());
        employee.setAdapter(staffAdapter);
        employee.setLayoutManager(new LinearLayoutManager(context,RecyclerView.HORIZONTAL,false));

        staffAdapter.onStaffRecylerView(new StaffAdapter.OnStaffRecylerView() {
            @Override
            public void OnItemClick(int postion) {
                String name = companyBean.getStaff_info().getList().get(postion).getName();
                Toast.makeText(context,"item : " + name,Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void showConsultationData(final CompanyData.ResultBean.ConsultationInfoBean consultationInfoBean) {
        consultationAdapter = new ConsultationAdapter(context,consultationInfoBean.getList());
        consultation.setAdapter(consultationAdapter);
        consultation.setLayoutManager(new LinearLayoutManager(context,RecyclerView.VERTICAL,false));

        consultationAdapter.setonConsultationView(new ConsultationAdapter.OnConsultationView() {
            @Override
            public void OnItemClick(int postion) {
                String name = companyBean.getConsultation_info().getList().get(postion).getTitle();
                Toast.makeText(context,"item : " + name,Toast.LENGTH_SHORT).show();
            }
        });


    }

}

