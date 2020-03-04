package com.zhijing.shoppingcenter.Type.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zhijing.shoppingcenter.R;
import com.zhijing.shoppingcenter.Type.bean.type_info;
import com.zhijing.shoppingcenter.utils.Constants;

import java.util.List;

public class GridViewAdapter extends BaseAdapter {
    private Context context;
    private List<type_info.ResultBean.DrinksInfoBean.ListBean> list;
    public GridViewAdapter(Context context,List<type_info.ResultBean.DrinksInfoBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    static class ViewHolder{
        ImageView grid_image;
        TextView grid_text;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder ;
        if (convertView == null){
            convertView = View.inflate(context,R.layout.grid_view_item,null);
            holder = new ViewHolder();
            holder.grid_image = convertView.findViewById(R.id.grid_view_item_photo);
            holder.grid_text = convertView.findViewById(R.id.grid_view_item_name);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder)convertView.getTag();
        }


        type_info.ResultBean.DrinksInfoBean.ListBean data = list.get(position);
        holder.grid_text.setText(data.getName());
        Glide.with(context).load(Constants.BASE_IMAGES_URL + data.getFigure()).into(holder.grid_image);
        return convertView;
    }


}
