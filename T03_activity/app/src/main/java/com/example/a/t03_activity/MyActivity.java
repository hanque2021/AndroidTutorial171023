package com.example.a.t03_activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class MyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this,"my activity destory", Toast.LENGTH_SHORT);

    }

}
