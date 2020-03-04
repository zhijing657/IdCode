package com.zhijing.shoppingcenter.HomePage.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.zhijing.shoppingcenter.HomePage.bean.ResultBeanData;
import com.zhijing.shoppingcenter.R;
import com.zhijing.shoppingcenter.utils.Constants;

import java.util.List;


public class ActAdapter extends RecyclerView.Adapter<ActAdapter.ViewHolder> {
    private final Context context;
    private final List<ResultBeanData.ResultBean.DeriveInfoBean.ListBeanX> datas;

    public ActAdapter(Context context, List<ResultBeanData.ResultBean.DeriveInfoBean.ListBeanX> list) {
        this.context = context;
        this.datas = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.sec_kill_item,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Glide.with(context).load(Constants.BASE_IMAGES_URL + datas.get(position).getFigure()).into(holder.logo);
        //holder.tv_cover_price.setText("￥" +datas.get(position).getCover_price());
        holder.tv_origin_price.setText(datas.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView logo;
        private TextView tv_cover_price;
        private TextView tv_origin_price;
        public ViewHolder(View itemView) {
            super(itemView);
            logo = itemView.findViewById(R.id.iv_figure);
            //tv_cover_price = itemView.findViewById(R.id.tv_cover_price);
            tv_origin_price = itemView.findViewById(R.id.tv_origin_price);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Toast.makeText(context,"item:"+getItemCount(),Toast.LENGTH_SHORT).show();
                    if (onActRecylerView != null){
                        onActRecylerView.OnItemClick(getLayoutPosition());
                    }
                }
            });
        }
    }

    public interface OnActRecylerView{
        public void OnItemClick(int postion);
    }

    private OnActRecylerView onActRecylerView;

    public void setOnSecKillRecylerView(OnActRecylerView onSecKillRecylerView){
        this.onActRecylerView = onSecKillRecylerView;

    }

}
