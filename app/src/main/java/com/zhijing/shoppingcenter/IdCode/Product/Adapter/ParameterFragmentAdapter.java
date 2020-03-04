package com.zhijing.shoppingcenter.IdCode.Product.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.zhijing.shoppingcenter.IdCode.Product.RestuleBean.ProductData;
import com.zhijing.shoppingcenter.R;

import java.util.List;


public class ParameterFragmentAdapter extends RecyclerView.Adapter<ParameterFragmentAdapter.ViewHolder> {

    private final Context context;
    private final List<ProductData.ResultBean.ProductInfoBean.ListBean.AllCODEBean.AllCodeListBean> datas;

    public ParameterFragmentAdapter(Context context, List<ProductData.ResultBean.ProductInfoBean.ListBean.AllCODEBean.AllCodeListBean> dataslist) {
        this.context = context;
        this.datas = dataslist;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.parameter_fragment_item,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.all_code.setText(datas.get(position).getCode());
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView all_code;
        public ViewHolder(View itemView) {
            super(itemView);
            all_code = itemView.findViewById(R.id.all_code);
        }
    }
}
