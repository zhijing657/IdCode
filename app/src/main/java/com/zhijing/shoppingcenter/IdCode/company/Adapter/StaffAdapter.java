package com.zhijing.shoppingcenter.IdCode.company.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.zhijing.shoppingcenter.IdCode.company.resultBean.CompanyData;
import com.zhijing.shoppingcenter.R;
import com.zhijing.shoppingcenter.utils.Constants;

import java.util.List;

public class StaffAdapter extends RecyclerView.Adapter<StaffAdapter.ViewHolder> {

    private final Context context;
    private final List<CompanyData.ResultBean.StaffInfoBean.ListBeanXX> datas;

    public StaffAdapter(Context context, List<CompanyData.ResultBean.StaffInfoBean.ListBeanXX> list) {
        this.context = context;
        this.datas = list;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView staffLogo;
        private TextView staffName;
        public ViewHolder(View itemView) {
            super(itemView);
            staffLogo = itemView.findViewById(R.id.staff_logo);
            staffName = itemView.findViewById(R.id.staff_name);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onStaffRecylerView != null){
                        onStaffRecylerView.OnItemClick(getLayoutPosition());
                        //Toast.makeText(context,"item:"+getItemCount(),Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.staff_item,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CompanyData.ResultBean.StaffInfoBean.ListBeanXX listBean = datas.get(position);
        Log.e("zhijing", "onBindViewHolder: 这里" );
            Glide.with(context).load(Constants.BASE_IMAGES_URL + listBean.getFigure()).into(holder.staffLogo);
            holder.staffName.setText(listBean.getName());
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public interface OnStaffRecylerView{
        public void OnItemClick(int postion);
    }

    private OnStaffRecylerView onStaffRecylerView;

    public void onStaffRecylerView(OnStaffRecylerView onBrandRecylerView){
        this.onStaffRecylerView = onBrandRecylerView;

    }
}
