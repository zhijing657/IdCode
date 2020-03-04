package com.zhijing.shoppingcenter.HomePage.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zhijing.shoppingcenter.HomePage.bean.ResultBeanData;
import com.zhijing.shoppingcenter.R;
import com.zhijing.shoppingcenter.utils.Constants;

import java.util.List;

public class RecomnendAdatper extends BaseAdapter {
    private Context context;
    private List<ResultBeanData.ResultBean.RecommendInfoBean> datas;
    public RecomnendAdatper(Context context, List<ResultBeanData.ResultBean.RecommendInfoBean> recommend_info) {
        this.context = context;
        this.datas = recommend_info;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null){
            convertView = View.inflate(context, R.layout.item_recommend_grid_view,null);
            viewHolder = new ViewHolder();
            viewHolder.iv_recommend =convertView.findViewById(R.id.iv_recommend);
            viewHolder.tv_name = convertView.findViewById(R.id.tv_name);
            viewHolder.tv_price = convertView.findViewById(R.id.tv_price);

            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder)convertView.getTag();
        }

        Log.e("datas", "getView: "+datas.get(0).getInfo().getCover_price());
        ResultBeanData.ResultBean.RecommendInfoBean recommendInfoBean = datas.get(position);
        Glide.with(context).load(Constants.BASE_IMAGES_URL + recommendInfoBean.getInfo().getFigure()).into(viewHolder.iv_recommend);
        viewHolder.tv_name.setText(recommendInfoBean.getInfo().getName());
        viewHolder.tv_price.setText("￥"+recommendInfoBean.getInfo().getCover_price());
        return convertView;
    }

   static class ViewHolder {
        ImageView iv_recommend;
        TextView tv_name;
        TextView tv_price;
    }
}
