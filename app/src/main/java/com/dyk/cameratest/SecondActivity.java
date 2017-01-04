package com.dyk.cameratest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by GOD on 2017/1/4.
 */
public class SecondActivity extends Activity
{
    private Button button;
    private TextView textView;
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        button = (Button)findViewById(R.id.button1);
        textView = (TextView)findViewById(R.id.textView1);
        editText = (EditText)findViewById(R.id.editText1);

        Intent intent = getIntent();
        String message = intent.getStringExtra("message").toString().trim();
        textView.setText(message);

        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String result = editText.getText().toString().trim();
                Intent intent = new Intent();
                intent.putExtra("result", result);
                /*
                 * 调用setResult方法表示我将Intent对象返回给之前的那个Activity，这样就可以在onActivityResult方法中得到Intent对象，
                 */
                setResult(1001, intent);
                //    结束当前这个Activity对象的生命
                finish();
            }
        });
    }
}
