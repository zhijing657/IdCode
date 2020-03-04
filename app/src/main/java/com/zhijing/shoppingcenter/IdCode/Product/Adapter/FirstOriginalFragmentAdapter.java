package com.zhijing.shoppingcenter.IdCode.Product.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.zhijing.shoppingcenter.IdCode.Product.RestuleBean.ProductData;
import com.zhijing.shoppingcenter.R;
import com.zhijing.shoppingcenter.utils.Constants;

public class FirstOriginalFragmentAdapter extends RecyclerView.Adapter<FirstOriginalFragmentAdapter.ViewHolde> {

    private final ProductData.ResultBean.ProductInfoBean.ListBean list;
    private Context context;

    public FirstOriginalFragmentAdapter(Context context, ProductData.ResultBean.ProductInfoBean.ListBean datas) {
        this.context = context;
        this.list = datas;
    }


    //创建页面
    @Override
    public ViewHolde onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.original_fragment_item,null);
        return new ViewHolde(view);
    }

    //绑定数据
    @Override
    public void onBindViewHolder(ViewHolde holder, int position) {
        Glide.with(context).load(Constants.BASE_IMAGES_URL +
                list.getTest_photo().getTestPhotoList().get(position).getTest_photo()).into(holder.test_photo);
        holder.test_name.setText(list.getTest_name().getTestNameList().get(position).getTest_name());

    }

    //RecyclerView的个数
    @Override
    public int getItemCount() {
        return list.getTest_name().getTestNameList().size();
    }

    public class ViewHolde extends RecyclerView.ViewHolder {
        private ImageView test_photo;
        private TextView test_name;
        public ViewHolde(View itemView) {
            super(itemView);
            test_name = itemView.findViewById(R.id.test_name);
            test_photo = itemView.findViewById(R.id.test_photo);
        }
    }
}
