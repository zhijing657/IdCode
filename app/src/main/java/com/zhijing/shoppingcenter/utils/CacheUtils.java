package com.zhijing.shoppingcenter.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class CacheUtils {
    /**
     * 得到保存的数据（本地）
     * @param context
     * @param key
     * @return
     */
    public static String getString(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences("zhijing's car",Context.MODE_PRIVATE);
        return sp.getString(key,"");
    }

    public static void saveString(Context context, String key,String value) {
        SharedPreferences sp = context.getSharedPreferences("zhijing's car",Context.MODE_PRIVATE);
        sp.edit().putString(key,value).commit();
    }

}
