package com.zhijing.shoppingcenter.ShoppongCart;


import android.graphics.Color;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.zhijing.shoppingcenter.HomePage.bean.GoodsBean;
import com.zhijing.shoppingcenter.R;
import com.zhijing.shoppingcenter.ShoppongCart.Adapter.ShoppingCartAdapter;
import com.zhijing.shoppingcenter.ShoppongCart.utils.CartStorage;
import com.zhijing.shoppingcenter.base.BaseFragment;

import java.util.List;
import java.util.Objects;


public class ShoppingCartFrameFragment extends BaseFragment implements View.OnClickListener {

    private static final String TAG = ShoppingCartFrameFragment.class.getName();
    /**
     * 有数据的布局
     */
    private TextView tvShopcartEdit;
    private RecyclerView recyclerview;
    private LinearLayout llCheckAll;
    private CheckBox checkboxAll;
    private TextView tvShopcartTotal;
    private Button btnCheckOut;
    private LinearLayout llDelete;
    private CheckBox cbAll;
    private Button btnDelete;
    private Button btnCollection;
    private ShoppingCartAdapter shoppingCartAdapter;
    /**
     * 空布局
     */
    private LinearLayout llEmptyShopcart;
    private ImageView ivEmpty;
    private TextView tvEmptyCartTobuy;

    private static final int ACTION_EDIT = 1;
    private static final int ACTION_COMPLETE = 2;


    @Override
    protected View initView() {
        Log.d(TAG, "购物车页面被创建 ");
        View view = View.inflate(context, R.layout.gwc_frame_fragment, null);
        tvShopcartEdit = view.findViewById(R.id.tv_shopcart_edit);
        recyclerview = view.findViewById(R.id.recyclerview);
        llCheckAll = view.findViewById(R.id.ll_check_all);
        checkboxAll = view.findViewById(R.id.checkbox_all);
        tvShopcartTotal = view.findViewById(R.id.tv_shopcart_total);
        btnCheckOut = view.findViewById(R.id.btn_check_out);
        llDelete = view.findViewById(R.id.ll_delete);
        cbAll = view.findViewById(R.id.cb_all);
        btnDelete = view.findViewById(R.id.btn_delete);
        btnCollection = view.findViewById(R.id.btn_collection);

        llEmptyShopcart = view.findViewById(R.id.ll_empty_shopcart);
        ivEmpty = view.findViewById(R.id.iv_empty);
        tvEmptyCartTobuy = view.findViewById(R.id.tv_empty_cart_tobuy);

        btnCheckOut.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        btnCollection.setOnClickListener(this);

        initListener();
        initStatusBar();
        return view;
    }

    private void initListener() {
        tvShopcartEdit.setTag(ACTION_EDIT);
        tvShopcartEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int action = (int) v.getTag();
                if (action == ACTION_EDIT) {
                    showDelete();
                } else {
                    hideDelete();
                }
            }
        });
    }

    private void hideDelete() {
        tvShopcartEdit.setTag(ACTION_EDIT);
        tvShopcartEdit.setText("编辑");
        if (shoppingCartAdapter != null) {
            shoppingCartAdapter.checkAll_none(true);
            shoppingCartAdapter.checkAll();
            shoppingCartAdapter.showTotalPrice();
        }
        llDelete.setVisibility(View.GONE);
        llCheckAll.setVisibility(View.VISIBLE);
    }

    private void showDelete() {
        tvShopcartEdit.setTag(ACTION_COMPLETE);
        tvShopcartEdit.setText("完成");
        if (shoppingCartAdapter != null) {
            shoppingCartAdapter.checkAll_none(false);
            shoppingCartAdapter.checkAll();
        }
        llDelete.setVisibility(View.VISIBLE);
        llCheckAll.setVisibility(View.GONE);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btn_check_out:
                break;
            case R.id.btn_delete:
                Log.e(TAG, "onClick: delete");
                shoppingCartAdapter.deleteData();
                shoppingCartAdapter.checkAll();
                if (shoppingCartAdapter.getItemCount() == 0){
                    emptyShopcart();
                }
                break;
            case R.id.btn_collection:
                break;
        }
    }

    @Override
    protected void initData() {
        Log.d(TAG, "购物车数据被创建 ");
        super.initData();
        showData();
        getView().findViewById(R.id.tv_empty_cart_tobuy).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"去逛逛",Toast.LENGTH_SHORT).show();
                //Navigation.findNavController(v).navigate(R.id.action_shoppingCartFrameFragment_to_homePageFrameFragment);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        showData();
    }

    /**
     * 显示数据
     */
    private void showData() {
        List<GoodsBean> goodsBeanList = CartStorage.getInstance().getAllData();
        if (goodsBeanList != null && goodsBeanList.size() > 0) {
            //有数据
            // 显示有数据的布局
            tvShopcartEdit.setVisibility(View.VISIBLE);
            llEmptyShopcart.setVisibility(View.GONE);
            llCheckAll.setVisibility(View.VISIBLE);
            //设置适配器
            shoppingCartAdapter = new ShoppingCartAdapter(context, goodsBeanList, tvShopcartTotal, checkboxAll, cbAll);
            recyclerview.setAdapter(shoppingCartAdapter);
            //设置布局管理器
            recyclerview.setLayoutManager(new LinearLayoutManager(context, RecyclerView.VERTICAL, false));

        } else {
            //显示数据为空的布局
            emptyShopcart();
        }
    }
    private void emptyShopcart(){
        llEmptyShopcart.setVisibility(View.VISIBLE);
        tvShopcartEdit.setVisibility(View.GONE);
        llDelete.setVisibility(View.GONE);
    }

    private void initStatusBar() {
//        View decorView = getActivity().getWindow().getDecorView();
//        int option = View.SYSTEM_UI_FLAG_FULLSCREEN;
//        decorView.setSystemUiVisibility(option);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            Window window = getActivity().getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION
                    | WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        }

    }
}
