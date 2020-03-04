package com.zhijing.shoppingcenter.Type.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
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

public class EquipmentAdapter extends BaseAdapter {
    Context context;
    List<type_info.ResultBean.DeriveInfoBean.ListBeanX> list;

    public EquipmentAdapter(Context context, List<type_info.ResultBean.DeriveInfoBean.ListBeanX> list) {
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

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Viewholder viewholder;
        if (convertView == null){
            convertView = View.inflate(context, R.layout.grid_view_item,null);
            viewholder = new Viewholder();
            viewholder.textView = convertView.findViewById(R.id.grid_view_item_name);
            viewholder.imageView = convertView.findViewById(R.id.grid_view_item_photo);
            convertView.setTag(viewholder);
        }else{
            viewholder = (Viewholder)convertView.getTag();
        }

        type_info.ResultBean.DeriveInfoBean.ListBeanX data = list.get(position);
        String name = data.getName();
        String figure = data.getFigure();
        viewholder.textView.setText(name);
        Glide.with(context).load(Constants.BASE_IMAGES_URL + figure).into(viewholder.imageView);

        return convertView;
    }

    static class Viewholder{
        TextView textView;
        ImageView imageView;
    }
}
