package com.zhijing.shoppingcenter.IdCode.company.Adapter;

import android.content.Context;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.zhijing.shoppingcenter.IdCode.company.resultBean.BrandsBean;
import com.zhijing.shoppingcenter.IdCode.company.resultBean.CompanyData;
import com.zhijing.shoppingcenter.R;
import com.zhijing.shoppingcenter.utils.Constants;


import java.util.List;

public class BrandAdapter extends RecyclerView.Adapter<BrandAdapter.ViewHolder>
{

    private List<CompanyData.ResultBean.BrandInfoBean.ListBean> datas;
    private Context context;

    public BrandAdapter(Context context, List<CompanyData.ResultBean.BrandInfoBean.ListBean> list) {
        this.context = context;
        this.datas = list;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context,R.layout.brand_item,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
       CompanyData.ResultBean.BrandInfoBean.ListBean listBean = datas.get(position);
       Glide.with(context).load(Constants.BASE_IMAGES_URL + listBean.getFigure()).into(holder.brand_logo);
       holder.brand_name.setText( listBean.getName());
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView brand_logo;
        private TextView brand_name;
        public ViewHolder(View itemView) {
            super(itemView);
            brand_logo = itemView.findViewById(R.id.brand_logo);
            brand_name = itemView.findViewById(R.id.brand_name);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onBrandRecylerView != null){
                        onBrandRecylerView.OnItemClick(getLayoutPosition());
                        //Toast.makeText(context,"item:"+getItemCount(),Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
    public interface OnBrandRecylerView{
        public void OnItemClick(int postion);
    }

    private OnBrandRecylerView onBrandRecylerView;

    public void setOnBrandRecylerView(OnBrandRecylerView onBrandRecylerView){
        this.onBrandRecylerView = onBrandRecylerView;

    }

}
