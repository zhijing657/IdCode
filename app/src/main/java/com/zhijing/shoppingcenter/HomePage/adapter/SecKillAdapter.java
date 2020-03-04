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

public class SecKillAdapter extends RecyclerView.Adapter<SecKillAdapter.ViewHolder> {

    private Context context;
    private List<ResultBeanData.ResultBean.DrinksInfoBean.ListBean> datas;

    public SecKillAdapter(Context context, List<ResultBeanData.ResultBean.DrinksInfoBean.ListBean> list) {
        this.context = context;
        this.datas = list;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = View.inflate(context,R.layout.sec_kill_item,null);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ResultBeanData.ResultBean.DrinksInfoBean.ListBean listBean = datas.get(position);

        Glide.with(context).load(Constants.BASE_IMAGES_URL + listBean.getFigure()).into(holder.imageView);
        //holder.imageView.setImageResource(R.mipmap.lcy);
        //holder.price1.setText("￥"+listBean.getCover_price());
        holder.price2.setText(listBean.getName());

    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView price1;
        private TextView price2;

        private ViewHolder(View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.iv_figure);
            //price1 = itemView.findViewById(R.id.tv_cover_price);
            price2 = itemView.findViewById(R.id.tv_origin_price);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Toast.makeText(context,"item:"+getItemCount(),Toast.LENGTH_SHORT).show();
                    if (onSecKillRecylerView != null){
                        onSecKillRecylerView.OnItemClick(getLayoutPosition());
                    }
                }
            });
        }
    }

    public interface OnSecKillRecylerView{
        public void OnItemClick(int postion);
    }

    private OnSecKillRecylerView onSecKillRecylerView;

    public void setOnSecKillRecylerView(OnSecKillRecylerView onSecKillRecylerView){
        this.onSecKillRecylerView = onSecKillRecylerView;

    }
}
