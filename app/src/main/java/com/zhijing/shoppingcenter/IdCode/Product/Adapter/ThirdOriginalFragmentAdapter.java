package com.zhijing.shoppingcenter.IdCode.Product.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.zhijing.shoppingcenter.IdCode.Product.RestuleBean.ProductData;
import com.zhijing.shoppingcenter.R;
import com.zhijing.shoppingcenter.utils.Constants;

public class ThirdOriginalFragmentAdapter extends RecyclerView.Adapter<ThirdOriginalFragmentAdapter.Viewholder> {

    private final Context context;
    private final ProductData.ResultBean.ProductInfoBean.ListBean datas;

    public ThirdOriginalFragmentAdapter(Context context, ProductData.ResultBean.ProductInfoBean.ListBean datas) {
        this.context = context;
        this.datas = datas;
    }

    @Override
    public Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.second_original_fragment_item, null);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(Viewholder holder, int position) {
        Log.e("POSITION", "onBindViewHolder: " + position);
        Glide.with(context).load(Constants.BASE_IMAGES_URL + datas.getInspect_photo().getInspectPhotoList().get(position).getInspect_photo()).into(holder.Third_Production_photo);
        holder.Third_Production_name.setText(datas.getInspect_name().getInspectNameList().get(position).getInspect_name());
        //holder.Third_Production_price.setText("￥***~￥***");
    }

    @Override
    public int getItemCount() {
        return datas.getInspect_name().getInspectNameList().size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        private ImageView Third_Production_photo;
        private TextView Third_Production_name;
        //private TextView Third_Production_price;

        public Viewholder(View itemView) {
            super(itemView);
            Third_Production_photo = itemView.findViewById(R.id.production_photo);
            Third_Production_name = itemView.findViewById(R.id.production_name);
            //Third_Production_price = itemView.findViewById(R.id.production_price);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onThridViewItemClick != null) {
                        onThridViewItemClick.OnItemClick(getLayoutPosition());
                    }
                }
            });

        }
    }

    public interface OnThridViewItemClick {
        void OnItemClick(int postion);
    }

    private OnThridViewItemClick onThridViewItemClick;

    public void setOnThridViewItemClick(OnThridViewItemClick onThridViewItemClick) {
        this.onThridViewItemClick = onThridViewItemClick;
    }
}
