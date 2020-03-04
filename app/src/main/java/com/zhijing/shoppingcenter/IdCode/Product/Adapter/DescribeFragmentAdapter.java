package com.zhijing.shoppingcenter.IdCode.Product.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

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


public class DescribeFragmentAdapter extends RecyclerView.Adapter<DescribeFragmentAdapter.ViewHolder> {
    private final List<ProductData.ResultBean.ProductInfoBean.ListBean.ActivityBean.ActivityListBean> datas;
    private Context context;

    public DescribeFragmentAdapter(Context context, List<ProductData.ResultBean.ProductInfoBean.ListBean.ActivityBean.ActivityListBean> list){
        this.context = context;
        this.datas = list;
    }

    //创建页面
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.describe_fragment_adapter,null);
        return new ViewHolder(view);
    }

    //绑定数据
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (datas != null && datas.size()>0){
            ProductData.ResultBean.ProductInfoBean.ListBean.ActivityBean.ActivityListBean list = datas.get(position);
            holder.describe_activity_name.setText(list.getActivity());
            holder.describe_activity_name.setTextColor(Color.RED);
        }
    }

    //RecyclerView的长度
    @Override
    public int getItemCount() {
        return 2;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView describe_activity_name;
        public ViewHolder(View itemView) {
            super(itemView);
            describe_activity_name = itemView.findViewById(R.id.describe_activity_name);
        }
    }
}
