package com.dyk.cameratest;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.dyk.cameratest.view.CameraSurfaceView;
import com.dyk.cameratest.view.RectOnCamera;

public class MainActivity extends Activity implements RectOnCamera.IAutoFocus{

    private CameraSurfaceView mCameraSurfaceView;
    private RectOnCamera mRectOnCamera;
    private Button takePicBtn;

    private boolean isClicked;

    public static String return_filepath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // 全屏显示
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        mCameraSurfaceView = (CameraSurfaceView) findViewById(R.id.cameraSurfaceView);
//        mRectOnCamera = (RectOnCamera) findViewById(R.id.rectOnCamera);
        takePicBtn= (Button) findViewById(R.id.takePic);
//        mRectOnCamera.setIAutoFocus(this);
        takePicBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                mCameraSurfaceView.takePicture();

                String result = mCameraSurfaceView.takePicture();
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



    @Override
    public void autoFocus() {
        mCameraSurfaceView.setAutoFocus();
    }
}
