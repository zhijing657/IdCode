package com.zhijing.shoppingcenter.app;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import com.zhijing.shoppingcenter.HomePage.HomepageWithBN;
import com.zhijing.shoppingcenter.MyViewModel;
import com.zhijing.shoppingcenter.R;
import com.zhijing.shoppingcenter.database.User;
import com.zhijing.shoppingcenter.database.UserDao;
import com.zhijing.shoppingcenter.database.UserDatabase;
import com.zhijing.shoppingcenter.databinding.ActivityLoginBinding;
import com.zhijing.shoppingcenter.utils.StatusBarUtil;
import com.zhy.http.okhttp.OkHttpUtils;

import okhttp3.OkHttpClient;

import java.util.concurrent.TimeUnit;

public class LoginActivity extends AppCompatActivity {
    private MyViewModel myViewModel;
    private UserDatabase userDatabase;
    private UserDao userDao;
    private static final String TAG = "LoginActivity";
    private ActivityLoginBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_login);
        myViewModel = ViewModelProviders.of(this,new SavedStateViewModelFactory(getApplication(),this)).get(MyViewModel.class);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_login);
        binding.setData(myViewModel);
        binding.setLifecycleOwner(this);

        userDatabase = UserDatabase.getInstance(this);
        userDao=userDatabase.getUserDao();
        initStatuBar();
        //Glide.with(this).load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1576150705009&di=0aef75970db6ec202f1f51f3cd272844&imgtype=0&src=http%3A%2F%2Fdmimg.5054399.com%2Fallimg%2Fpkm%2Fpk%2F22.jpg").into(imageView4);

        /**
         * 配置OkhttpClient
         */
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                .addInterceptor(new LoggerInterceptor("TAG"))
                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                .readTimeout(10000L, TimeUnit.MILLISECONDS)
                //其他配置
                .build();
        OkHttpUtils.initClient(okHttpClient);
    }


    private void initStatuBar() {
        StatusBarUtil.setRootViewFitsSystemWindows(this,false);
        StatusBarUtil.setTranslucentStatus(this);
        if (!StatusBarUtil.setStatusBarDarkTheme(this, true)) {
            //如果不支持设置深色风格 为了兼容总不能让状态栏白白的看不清, 于是设置一个状态栏颜色为半透明,
            //这样半透明+白=灰, 状态栏的文字能看得清
            StatusBarUtil.setStatusBarColor(this, 0x55000000);
        }
    }

    public void Login(View view) {
        //获取输入的账号
        String userName = binding.user.getText().toString().trim();
        //获取输入的密码
        String pwd = binding.password.getText().toString().trim();
        //根据账号在数据库中查询是否有对应的用户
        User user1 = userDao.getUser(userName);
        if (user1 == null){
            //查询结果为空的情况
            binding.user.setError("用户不存在");
            return;
        }
        if (user1.getUserName().equals(userName) && user1.getUserPassword().equals(pwd)){
            //查询结果不为空并且密码一致的情况
            Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LoginActivity.this, HomepageWithBN.class);
            startActivity(intent);
            myViewModel.setUserName(binding.user.getText().toString().trim());
            myViewModel.setPassword(binding.password.getText().toString().trim());
            myViewModel.save();
            finish();
        }
        if (user1.getUserName().equals(userName)) {
            if (!user1.getUserPassword().equals(pwd)) {
                //查询结果不为空但密码不一致的情况
                binding.password.setError("密码错误");
                return;
            }
        }
    }

    public void RES(View view) {
       Intent intent = new Intent(LoginActivity.this,ResActivity.class);
       startActivity(intent);
    }
}



