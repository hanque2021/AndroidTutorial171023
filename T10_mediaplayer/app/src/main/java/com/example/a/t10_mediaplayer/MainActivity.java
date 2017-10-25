package com.example.a.t10_mediaplayer;

import android.Manifest;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Runtime permission에 대해서 권한 부여 물어보는 코드 삽입. deny한 경우 설정>앱가서 변경해야 함.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) { //M이 마시멜로 나타냄.
            String[] permissions = {Manifest.permission.READ_EXTERNAL_STORAGE};
            requestPermissions(permissions,0);
        }


    }
    public  void onPlayClick(View v){

    }

    public  void onStopClick(View v){

    }
}
