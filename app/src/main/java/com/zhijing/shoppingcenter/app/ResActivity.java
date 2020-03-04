package com.zhijing.shoppingcenter.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.zhijing.shoppingcenter.MyViewModel;
import com.zhijing.shoppingcenter.R;
import com.zhijing.shoppingcenter.database.User;
import com.zhijing.shoppingcenter.database.UserDao;
import com.zhijing.shoppingcenter.database.UserDatabase;
import com.zhijing.shoppingcenter.databinding.ActivityResBinding;

public class ResActivity extends AppCompatActivity {
    private MyViewModel myViewModel;
    private ActivityResBinding binding;
    private UserDatabase userDatabase;
    private UserDao userDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_res);

        myViewModel = ViewModelProviders.of(this,new SavedStateViewModelFactory(getApplication(),this)).get(MyViewModel.class);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_res);
        binding.setData(myViewModel);
        binding.setLifecycleOwner(this);

        userDatabase = UserDatabase.getInstance(this);
        userDao=userDatabase.getUserDao();

    }

    public void RES(View view) {
        //获取输入的账号
        String user = binding.user.getText().toString().trim();
        //获取输入的密码
        String pwd = binding.password.getText().toString().trim();
        //设定用户名和密码的长度
        if (user.length() <= 3){
            binding.user.setError("用户名长度不能小于3");
            return;
        }

        if (pwd.length() <= 5){
            binding.password.setError("密码长度不能小于5");
            return;
        }

        //将账号密码添加至数据表中
        User test = userDao.getUser(user);
        if (test == null){
            User user1 = new User(user,pwd);
            userDao.insertUser(user1);
            Toast.makeText(ResActivity.this,"注册成功" +
                    "\r\nUserName:" + user1.getUserName() +
                    "\n Password:" + user1.getUserPassword() ,Toast.LENGTH_SHORT).show();
            finish();
        }else{
            //添加失败则返回指定提示
            binding.user.setError("用户已存在");
            return;
        }
    }
}
