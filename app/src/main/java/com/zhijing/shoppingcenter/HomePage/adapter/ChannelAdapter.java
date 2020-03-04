package com.zhijing.shoppingcenter.HomePage.adapter;

import android.content.Context;
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

import org.w3c.dom.Text;

import java.util.List;

/**
 * 频道适配器
 */
public class ChannelAdapter extends BaseAdapter {
    private Context context;
    private  List<ResultBeanData.ResultBean.ChannelInfoBean> datas;
    public ChannelAdapter(Context context, List<ResultBeanData.ResultBean.ChannelInfoBean> channel_info) {
        this.context = context;
        this.datas = channel_info;
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
        ViewHodle viewHodle;
        if (convertView == null){
            convertView = View.inflate(context,R.layout.channel_item,null);
            viewHodle = new ViewHodle();
            viewHodle.logo = convertView.findViewById(R.id.iv_channel);
            viewHodle.title = convertView.findViewById(R.id.tv_channel);

            convertView.setTag(viewHodle);
        }else {
            viewHodle = (ViewHodle) convertView.getTag();
        }
        //根据位置得到数据
        ResultBeanData.ResultBean.ChannelInfoBean channelInfoBean = datas.get(position);
        Glide.with(context).load(Constants.BASE_IMAGES_URL +channelInfoBean.getImage()).into(viewHodle.logo);
//      Glide.with(context).load(Constants.BASE_IMAGES_URL+channelInfoBean.getChannel_name()).into(viewHodle.title);
        viewHodle.title.setText(channelInfoBean.getChannel_name());
        return convertView;
    }

    static class ViewHodle{
        ImageView logo;
        TextView title;
    }
}
