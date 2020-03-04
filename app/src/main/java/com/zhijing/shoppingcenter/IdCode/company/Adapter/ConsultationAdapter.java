package com.zhijing.shoppingcenter.IdCode.company.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import com.zhijing.shoppingcenter.IdCode.company.resultBean.CompanyData;
import com.zhijing.shoppingcenter.R;

import java.util.List;

public class ConsultationAdapter extends RecyclerView.Adapter<ConsultationAdapter.ViewHolder>  {

    private final Context context;
    private final List<CompanyData.ResultBean.ConsultationInfoBean.ListBeanXXX> dates;

    public ConsultationAdapter(Context context, List<CompanyData.ResultBean.ConsultationInfoBean.ListBeanXXX> list) {
        this.context = context;
        this.dates = list;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView ConsultationTitle;

        public ViewHolder(View itemView) {
            super(itemView);
            ConsultationTitle = itemView.findViewById(R.id.CTitle);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onConsultationView != null){
                        onConsultationView.OnItemClick(getLayoutPosition());
                        //Toast.makeText(context,"item:"+getItemCount(),Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.consultation_item,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CompanyData.ResultBean.ConsultationInfoBean.ListBeanXXX listBeanXXX = dates.get(position);
        if (dates != null && dates.size()>0){
            holder.ConsultationTitle.setText(dates.get(position).getTitle());
        }
    }

    @Override
    public int getItemCount() {
        return dates.size();
    }


    public interface OnConsultationView{
        public void OnItemClick(int postion);
    }

    private OnConsultationView onConsultationView;

    public void setonConsultationView(OnConsultationView onConsultationView){
        this.onConsultationView = onConsultationView;

    }
}
