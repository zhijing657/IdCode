package com.zhijing.shoppingcenter.ShoppongCart.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.zhijing.shoppingcenter.HomePage.bean.GoodsBean;
import com.zhijing.shoppingcenter.R;
import com.zhijing.shoppingcenter.ShoppongCart.utils.CartStorage;
import com.zhijing.shoppingcenter.app.AddSubView;
import com.zhijing.shoppingcenter.utils.Constants;

import java.util.List;

/**
 * 适配器的构造方法
 */
public class ShoppingCartAdapter extends RecyclerView.Adapter<ShoppingCartAdapter.ViewHolder> {

    private final Context context;
    private final List<GoodsBean> datas;
    private final CheckBox cbAll;
    private TextView tvShopcartTotal;
    private CheckBox checkboxAll;


    public ShoppingCartAdapter(Context context, List<GoodsBean> goodsBeanList, TextView tvShopcartTotal, CheckBox checkboxAll,CheckBox cbAll) {
        this.context = context;
        this.datas = goodsBeanList;
        this.tvShopcartTotal = tvShopcartTotal;
        this.checkboxAll = checkboxAll;
        this.cbAll = cbAll;
        
        showTotalPrice();
        setListener();
        checkAll();

    }

    private void setListener() {
        setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                GoodsBean goodsBean = datas.get(position);
                goodsBean.setSelected(!goodsBean.isSelected());
                notifyItemRemoved(position);
                checkAll();
                showTotalPrice();
            }
        });

        checkboxAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isChecked = checkboxAll.isChecked();
                checkAll_none(isChecked);
                showTotalPrice();
            }
        });
        cbAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isChecked = cbAll.isChecked();
                checkAll_none(isChecked);
            }
        });
    }

    public void checkAll_none(boolean isChecked) {
        if (datas != null & datas.size()>0){
            for (int i =0;i<datas.size();i++){
                GoodsBean goodsBean = datas.get(i);
                goodsBean.setSelected(isChecked);
                notifyItemRemoved(i);
                showTotalPrice();
            }
        }
    }

    public void checkAll() {
        if (datas != null & datas.size()>0){
            int number = 0;
            for (int i =0;i<datas.size();i++){
                GoodsBean goodsBean = datas.get(i);
                if (!goodsBean.isSelected()){
                    checkboxAll.setChecked(false);
                    cbAll.setChecked(false);
                }else{
                    number ++;
                }
            }
            if (number == datas.size()){
                checkboxAll.setChecked(true);
                cbAll.setChecked(true);
            }
        }else{
            checkboxAll.setChecked(false);
            cbAll.setChecked(false);
        }
    }

    public void showTotalPrice() {
        tvShopcartTotal.setText("合计：" + getTotalPrice()+"");
    }

    private double getTotalPrice() {
        double totalprice = 0;
        if (datas!=null && datas.size()>0){
            for (int i = 0;i<datas.size();i++){
                GoodsBean goodsBean = datas.get(i);
                if (goodsBean.isSelected()){
                    totalprice = totalprice + Double.valueOf(goodsBean.getNum()) * Double.valueOf(goodsBean.getCover_price());
                }
            }
        }
        return totalprice;
    }

    public void deleteData() {
        if (datas != null && datas.size()> 0){
            Log.e("deleteData", "datas != null && datas.size()> 0" );
            for (int i=0;i<datas.size();i++){
                GoodsBean goodsBean = datas.get(i);
                if (goodsBean.isSelected()){
                    datas.remove(goodsBean);
                    notifyItemRemoved(i);
                    CartStorage.getInstance().deleteData(goodsBean);
                    i--;
                }
            }
        }
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        private CheckBox cb_gov;
        private ImageView iv_gov;
        private TextView tv_desc_gov;
        private TextView tv_price_gov;
        private AddSubView add_sub;

        public ViewHolder(View itemView) {
            super(itemView);
            cb_gov = itemView.findViewById(R.id.cb_gov);
            iv_gov = itemView.findViewById(R.id.iv_gov);
            tv_desc_gov = itemView.findViewById(R.id.tv_desc_gov);
            tv_price_gov = itemView.findViewById(R.id.tv_price_gov);
            add_sub = itemView.findViewById(R.id.add_sub);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onItemClickListener != null){
                        onItemClickListener.onItemClick(getLayoutPosition());
                    }
                }
            });
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View  view = View.inflate(context, R.layout.item_shop_cart,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        //根据位置得到对应的bean对象
        final GoodsBean goodsBean = datas.get(position);

        //Double price = Double.valueOf(goodsBean.getCover_price()) * Double.valueOf(goodsBean.getNum());

        holder.cb_gov.setChecked(goodsBean.isSelected());
        Glide.with(context).load(Constants.BASE_IMAGES_URL + goodsBean.getFigure()).into(holder.iv_gov);
        holder.tv_desc_gov.setText(goodsBean.getName());
        holder.tv_price_gov.setText("￥"+ goodsBean.getCover_price());
        holder.add_sub.setMin_num(1);
        holder.add_sub.setMax_num(20);
        holder.add_sub.setNum(goodsBean.getNum());

        holder.add_sub.setOnNumberChangeListener(new AddSubView.OnNumberChangeListener() {
            @Override
            public void OnNumberChangeListener(int value) {
                goodsBean.setNum(value);
                CartStorage.getInstance().upDateData(goodsBean);
                //notifyItemChanged(position);
                showTotalPrice();
            }
        });
    }
    @Override
    public int getItemCount() {
        //Log.e("SIZE : ", ""+datas.size() );
        return datas.size();
    }

    public interface OnItemClickListener{
       public void onItemClick(int position);
    }
    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
