package com.zhijing.shoppingcenter.IdCode.Product.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.zhijing.shoppingcenter.IdCode.Product.RestuleBean.ProductData;
import com.zhijing.shoppingcenter.R;
import com.zhijing.shoppingcenter.ShoppongCart.Adapter.ShoppingCartAdapter;
import com.zhijing.shoppingcenter.utils.Constants;

public class SecondOriginalFragmentAdapter extends RecyclerView.Adapter<SecondOriginalFragmentAdapter.Viewholder> {

    private final ProductData.ResultBean.ProductInfoBean.ListBean datas;
    private final Context context;
    private RecyclerView mRecyclerView;

    private View VIEW_HEADER;
    private View VIEW_FOOTER;

    private int TYPE_NORMAL = 0;
    private int TYPE_HEADER = 1;
    private int TYPE_FOOTER = 2;

    public SecondOriginalFragmentAdapter(Context context, ProductData.ResultBean.ProductInfoBean.ListBean datas) {
        this.context = context;
        this.datas = datas;
    }

    @Override
    public Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_FOOTER){
            return new Viewholder(VIEW_FOOTER);
        }else if (viewType == TYPE_HEADER){
            return new Viewholder(VIEW_HEADER);
        }else{
            return new Viewholder(getLayout(R.layout.thrid_original_fragment_item));
        }
    }

    @Override
    public void onBindViewHolder(Viewholder holder, int position) {
        if (!isHeaderView(position) && !isFooterView(position)) {
            if (haveHeaderView()) position--;
            TextView production_name = holder.itemView.findViewById(R.id.production_name);
            ImageView production_photo =  holder.itemView.findViewById(R.id.production_photo);
            production_name.setText(datas.getWorkmanship_name().getWorkmanship_nameList().get(position).getWorkmanship_name());
            Glide.with(context).load(Constants.BASE_IMAGES_URL + datas.getWorkmanship_photo().getWorkmanshipList().get(position).getWorkmanship_photo()).into(production_photo);
//            if (datas.getType() == "饮品") {
//                production_photo.setImageResource(R.drawable.ycl);
//            }
//            if (datas.getType() == "盾构机"){
//                production_photo.setImageResource(R.drawable.faqd);
//            }

        }
    }

    @Override
    public int getItemCount() {
        int count = (datas.getWorkmanship_name().getWorkmanship_nameList() == null) ? 0 : datas.getWorkmanship_name().getWorkmanship_nameList().size();
        if (VIEW_FOOTER != null){
            count++;
        }
        if (VIEW_HEADER != null){
            count++;
        }
        return count;
    }

    @Override
    public int getItemViewType(int position) {
        if (isHeaderView(position)){
            return TYPE_HEADER;
        }else if (isFooterView(position)){
            return TYPE_FOOTER;
        }else{
            return TYPE_NORMAL;
        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        try {
            if (mRecyclerView == null && mRecyclerView != recyclerView){
                mRecyclerView = recyclerView;
            }
            ifGridLayoutManager();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private View getLayout(int layoutId){
        return LayoutInflater.from(context).inflate(layoutId,null);
    }

    public void addHeaderView(View headerView){
        if (haveHeaderView()){
            throw new IllegalStateException("hearview has already exists!");
        }else {
//            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
//            headerView.setLayoutParams(layoutParams);
            VIEW_HEADER = headerView;
            ifGridLayoutManager();
            notifyItemInserted(0);
        }
    }

    public void addFooterView(View footerView) {
        if (haveFooterView()) {
            throw new IllegalStateException("footerView has already exists!");
        } else {
//            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//            footerView.setLayoutParams(params);
            VIEW_FOOTER = footerView;
            ifGridLayoutManager();
            notifyItemInserted(getItemCount() - 1);
        }
    }

    private void ifGridLayoutManager() {
        if (mRecyclerView == null) return;
        final RecyclerView.LayoutManager layoutManager = mRecyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            final GridLayoutManager.SpanSizeLookup originalSpanSizeLookup =
                    ((GridLayoutManager) layoutManager).getSpanSizeLookup();
            ((GridLayoutManager) layoutManager).setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    return (isHeaderView(position) || isFooterView(position)) ?
                            ((GridLayoutManager) layoutManager).getSpanCount() : 1;
                }
            });
        }
    }

    private boolean haveHeaderView() {
        return VIEW_HEADER != null;
    }

    public boolean haveFooterView() {
        return VIEW_FOOTER != null;
    }

    private boolean isHeaderView(int position) {
        return haveHeaderView() && position == 0;
    }

    private boolean isFooterView(int position) {
        return haveFooterView() && position == getItemCount() - 1;
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        public Viewholder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Toast.makeText(context,"item:"+getItemCount(),Toast.LENGTH_SHORT).show();
                    if (onSecondOriginalFragmentRecylerView != null){
                        onSecondOriginalFragmentRecylerView.OnItemClick(getLayoutPosition());
                    }
                }
            });
        }
    }

    public interface OnSecondOriginalFragmentRecylerView{
        public void OnItemClick(int postion);
    }
    private OnSecondOriginalFragmentRecylerView onSecondOriginalFragmentRecylerView;
    public void setOnSecondOriginalFragmentRecylerView(OnSecondOriginalFragmentRecylerView onSecondOriginalFragmentRecylerView){
        this.onSecondOriginalFragmentRecylerView = onSecondOriginalFragmentRecylerView;
    }

}
