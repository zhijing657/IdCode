package com.zhijing.shoppingcenter.IdCode.Product.getExcel.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zhijing.shoppingcenter.IdCode.Product.getExcel.bean.Programme;
import com.zhijing.shoppingcenter.R;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShowProgrammeAdapter extends RecyclerView.Adapter<ShowProgrammeAdapter.ViewHolder> {

    private Context context;
    private List<Programme.ResultBean.ProgrammeInfoBean.ListBean> datas;
    private OnItemClick onitemClick;
    private static boolean  checked = false;
    public static Map<String,String> getMaterial = new HashMap<>();
    public ShowProgrammeAdapter(Context context,List<Programme.ResultBean.ProgrammeInfoBean.ListBean> datas) {
        this.context = context;
        this.datas=datas;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.show_programme_adapter,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.material.setText(datas.get(position).getName());
        if (onitemClick != null){
            holder.price.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.e("checked", "onClick: "+checked );
                    checked =!checked;
                    holder.material.setChecked(checked);

                    if (holder.material.isChecked()){
                        getMaterial.put("name"+position,holder.material.getText().toString());
                    }else{
                        getMaterial.remove("name"+position);
                    }
                    System.out.println(getMaterial);

                    onitemClick.onItemClick(position);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return datas.size();
    }
    public void setOnClickItemListener(OnItemClick onitemClick){
        this.onitemClick = onitemClick;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView price;
        private CheckBox material;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            material = itemView.findViewById(R.id.material);
            price = itemView.findViewById(R.id.price);
        }
    }

    public interface OnItemClick{
        void onItemClick(int position);
    }
}
