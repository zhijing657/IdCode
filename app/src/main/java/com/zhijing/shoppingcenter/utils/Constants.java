package com.zhijing.shoppingcenter.utils;

import android.util.Log;
import com.zhijing.shoppingcenter.app.WelcomeActivity;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Constants {
    public static final String TAG = Constants.class.getCanonicalName();

    /**
     * 服务器所在路径
     */
    //public static String IP = "http://120.25.155.54:8080";
    //public static String BASE_URL = "http://100.13.14.243:8080/zhijing";
    public final static String BASE_URL = "http://120.25.155.54:8080/idcode";
    //public static String LOGIN_URL = "http://"+ "192.168.1.108" + ":8080/LoginDemo/hello";
    /**
     * 主页面路径
     */
    public static final String HOME_URL = BASE_URL+"/json/HOME_URL.json";
    public static final String BRAND_URL = BASE_URL+"/json/BRAND_URL.json";
    public static final String PRODUCT_INFO = BASE_URL+"/json/PRODUCT_INFO.json";
    public static final String PROGRAMME_INFO = BASE_URL+"/json/programme_info.json";
    /**
     * 所有图片的基本路径
     */
    public static String BASE_IMAGES_URL = BASE_URL+"/img";
}
