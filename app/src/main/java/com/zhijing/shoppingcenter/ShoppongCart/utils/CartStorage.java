package com.zhijing.shoppingcenter.ShoppongCart.utils;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zhijing.shoppingcenter.HomePage.bean.GoodsBean;
import com.zhijing.shoppingcenter.IdCode.company.resultBean.BrandsBean;
import com.zhijing.shoppingcenter.app.MyApplication;
import com.zhijing.shoppingcenter.utils.CacheUtils;

import java.util.ArrayList;
import java.util.List;

public class CartStorage {
    public static final String JSON_CART = "json_cart";
    private static CartStorage getInstance;
    private Context context   ;
    private SparseArray<GoodsBean> sparseArray;
    private CartStorage(Context context){
        this.context = context;
        sparseArray = new SparseArray<>(100);
        listToSparseArray();
    }

    private void listToSparseArray() {
        List<GoodsBean> goodsBeansList = getAllData();
        //把列表数据转换成SparseArray
            if (sparseArray != null && sparseArray.size()>0){
                for (int i = 0;i<goodsBeansList.size();i++){
                    GoodsBean goodsBean = goodsBeansList.get(i);
                    sparseArray.put(Integer.parseInt(goodsBean.getGoods_id()),goodsBean );
                    //Log.e("ZHIJING : ", "sparseArray : "+sparseArray.toString() );
                }
            }

    }

    public List<GoodsBean> getAllData() {
        List<GoodsBean> goodsBeanList = new ArrayList<>();
        //从本地获取缓存数据
        String savaJson = CacheUtils.getString(context, JSON_CART);
        if (!TextUtils.isEmpty(savaJson)) {
        //把数据转换成列表
            goodsBeanList = new Gson().fromJson(savaJson, new
                    TypeToken<List<GoodsBean>>() {
                    }.getType());
        }
        Log.e("getAllData", "getAllData: "+goodsBeanList.toString() );
        return goodsBeanList;
    }

    public List<BrandsBean> getBrandsAllData() {
        List<BrandsBean> goodsBrandsBeanList = new ArrayList<>();
        //从本地获取缓存数据
        String savaJson = CacheUtils.getString(context, JSON_CART);
        if (!TextUtils.isEmpty(savaJson)) {
            //把数据转换成列表
            goodsBrandsBeanList = new Gson().fromJson(savaJson, new
                    TypeToken<List<BrandsBean>>() {
                    }.getType());
        }
        Log.e("getAllData", "getAllData: "+goodsBrandsBeanList.toString() );
        return goodsBrandsBeanList;
    }


    public static CartStorage getInstance(){
        if (getInstance == null){
             getInstance = new CartStorage(MyApplication.getContext());
        }
        return getInstance;
    }

    public void addData(GoodsBean cart){
        //添加到内存中
        GoodsBean tempData = sparseArray.get(Integer.parseInt(cart.getGoods_id()));
        if (tempData != null) {
            tempData.setNum(tempData.getNum()+1);
        }else{
            tempData = cart;
            tempData.setNum(1);
        }
        sparseArray.put(Integer.parseInt(tempData.getGoods_id()),tempData);
        //同步到本地
        saveLocal();
    }

    /**
     * 删除数据
     * @param goodsBean
     */
    public void deleteData(GoodsBean goodsBean) {
        sparseArray.delete(Integer.parseInt(goodsBean.getGoods_id()));
        saveLocal();
    }
    
    public void upDateData(GoodsBean goodsBean) {
        sparseArray.put(Integer.parseInt(goodsBean.getGoods_id()),goodsBean);
        saveLocal();
    }

    private void saveLocal() {
        //列表转换成String 类型
       List<GoodsBean> goodsBeanList =  SparsetArrayToList();

        String json = new Gson().toJson(goodsBeanList);
        CacheUtils.saveString(context,JSON_CART, json);
        
    }

    private List<GoodsBean> SparsetArrayToList() {
        List<GoodsBean> goodsBeanList = new ArrayList<>();
        for (int i = 0;i<sparseArray.size();i++){
            GoodsBean goodsBean = sparseArray.valueAt(i);
            goodsBeanList.add(goodsBean);
        }
        return goodsBeanList;
    }
}
