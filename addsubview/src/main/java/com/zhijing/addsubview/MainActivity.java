package com.zhijing.addsubview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private AddSubView add_sub;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        add_sub = findViewById(R.id.add_sub);
        add_sub.setOnNumberChangeListener(new AddSubView.OnNumberChangeListener() {
            @Override
            public void OnNumberChangeListener(int value) {
                Toast.makeText(MainActivity.this,"num == " + value,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
