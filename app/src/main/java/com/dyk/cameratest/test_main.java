package com.dyk.cameratest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Created by GOD on 2017/1/4.
 */
public class test_main extends Activity {

    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private ImageView imageView;
    private TextView text;

    private Button button;
    private EditText editText1;
    private EditText editText2;
    private EditText editText3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);

        imageView = (ImageView) findViewById(R.id.imageView);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button)	findViewById(R.id.button2);
        button3 = (Button)	findViewById(R.id.button3);
        button4 = (Button)	findViewById(R.id.button4);
        button5 = (Button)	findViewById(R.id.button5);
        button6 = (Button)	findViewById(R.id.button6);
        button7 = (Button)	findViewById(R.id.button7);
        button8 = (Button)	findViewById(R.id.button8);
        text = (TextView) findViewById(R.id.text);

        button = (Button)findViewById(R.id.button);
        editText1 = (EditText)findViewById(R.id.editText1);
        editText2 = (EditText)findViewById(R.id.editText2);
        editText3 = (EditText)findViewById(R.id.editText3);


        Glide.with(test_main.this).load("/sdcard/dyk1483535351089.jpg").fitCenter().skipMemoryCache(true).into(imageView);

        button8.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent();
                intent.putExtra("message", editText1.getText().toString().trim() + " + " + editText2.getText().toString().trim() + " = ?");
                intent.setClass(test_main.this, MainActivity.class);
                /*
                 * 如果希望启动另一个Activity，并且希望有返回值，则需要使用startActivityForResult这个方法，
                 * 第一个参数是Intent对象，第二个参数是一个requestCode值，如果有多个按钮都要启动Activity，则requestCode标志着每个按钮所启动的Activity
                 */
                startActivityForResult(intent, 1000);
            }
        });

        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent();
                intent.putExtra("message", editText1.getText().toString().trim() + " + " + editText2.getText().toString().trim() + " = ?");
                intent.setClass(test_main.this, SecondActivity.class);
                /*
                 * 如果希望启动另一个Activity，并且希望有返回值，则需要使用startActivityForResult这个方法，
                 * 第一个参数是Intent对象，第二个参数是一个requestCode值，如果有多个按钮都要启动Activity，则requestCode标志着每个按钮所启动的Activity
                 */
                startActivityForResult(intent, 1000);
            }
        });
    }

    /**
     * 所有的Activity对象的返回值都是由这个方法来接收
     * requestCode:    表示的是启动一个Activity时传过去的requestCode值
     * resultCode：表示的是启动后的Activity回传值时的resultCode值
     * data：表示的是启动后的Activity回传过来的Intent对象
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1000 && resultCode == 1001)
        {
            String result_value = data.getStringExtra("result");
            editText3.setText(result_value);
        }
    }
}
