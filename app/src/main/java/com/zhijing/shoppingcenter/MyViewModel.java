package com.zhijing.shoppingcenter;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;

public class MyViewModel extends AndroidViewModel {
    private static final String TAG = "AndroidViewModel";
    private SavedStateHandle handle;
    private static String KEY_USER_NAME = "KEY_USERNAME";
    private static String KEY_PASSWORD = "KEY_PASSWORD";
    private static String SHP_NAME = "SHP_NAME";

    private String userName = "";
    private String password = "";


    public MyViewModel(Application application, SavedStateHandle handle) {
        super(application);
        if (!handle.contains(KEY_USER_NAME)) {
            SharedPreferences shp = getApplication().getSharedPreferences(SHP_NAME, Context.MODE_PRIVATE);
            handle.set(KEY_USER_NAME, shp.getString(KEY_USER_NAME, ""));
            handle.set(KEY_PASSWORD, shp.getString(KEY_PASSWORD, ""));
        }
        this.handle = handle;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public MutableLiveData<String> getUsername() {
        return handle.getLiveData(KEY_USER_NAME);
    }

    public MutableLiveData<String> getPassword() {
        return handle.getLiveData(KEY_PASSWORD);
    }


    public void save() {
        SharedPreferences shp = getApplication().getSharedPreferences(SHP_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = shp.edit();
        editor.putString(KEY_USER_NAME, userName);
        editor.putString(KEY_PASSWORD, password);
        editor.apply();
    }

}
