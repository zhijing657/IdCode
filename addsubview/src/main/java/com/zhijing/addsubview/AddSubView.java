package com.zhijing.addsubview;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class AddSubView extends LinearLayout implements View.OnClickListener {

    private final Context context;
    private ImageView iv_sub;
    private ImageView iv_add;
    private TextView iv_number;

    private int num = 1;
    private int max_num = 20;
    private int min_num = 1;
    private OnNumberChangeListener onNumberChangeListener;

    public AddSubView(Context context, AttributeSet attrs) {
        super(context, attrs);

        this.context = context;
       View view = View.inflate(context,R.layout.add_sub_view,this);
        iv_sub = view.findViewById(R.id.iv_sub);
        iv_add = view.findViewById(R.id.iv_add);
        iv_number = view.findViewById(R.id.number);

        iv_sub.setOnClickListener(this);
        iv_add.setOnClickListener(this);
        iv_number.setOnClickListener(this);

        int value = getNum();
        setNum(value);
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_sub:
                subNumber();
                break;
            case R.id.iv_add:
                addNumber();
                break;
        }
        //Toast.makeText(context,"number : "+num,Toast.LENGTH_SHORT).show();
    }

    private void subNumber() {
        if (num > min_num){
            Log.e("TAG", "onClick: -- " );
            num --;
            setNum(num);
        }
        if ( onNumberChangeListener != null){
            onNumberChangeListener.OnNumberChangeListener(num);
        }
    }

    private void addNumber() {
        if (num < max_num){
            Log.e("TAG", "onClick: ++ " );
            num++;
            setNum(num);
        }
        if ( onNumberChangeListener != null){
            onNumberChangeListener.OnNumberChangeListener(num);
        }
    }

    public int getNum() {
        String values= iv_number.getText().toString().trim();
        if (!TextUtils.isEmpty(values)){
            num = Integer.parseInt(values);
        }
        return num;
    }

    public void setNum(int num) {
        this.num = num;
        iv_number.setText(num + "");
    }

    public int getMax_num() {
        return max_num;
    }

    public void setMax_num(int max_num) {
        this.max_num = max_num;
    }

    public int getMin_num() {
        return min_num;
    }

    public void setMin_num(int min_num) {
        this.min_num = min_num;
    }

    public interface OnNumberChangeListener{
        public void OnNumberChangeListener(int value);
    }

    public OnNumberChangeListener getOnNumberChangeListener() {
        return onNumberChangeListener;
    }

    public void setOnNumberChangeListener(OnNumberChangeListener onNumberChangeListener) {
        this.onNumberChangeListener = onNumberChangeListener;
    }
}
