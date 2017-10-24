package com.example.a.t03_activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        //입력한 값 얻어오기. 형식에 맞는 extra얻어오기
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        String pw = intent.getStringExtra("pw");
        int level = intent.getIntExtra("level", 0);   //int는 default값 넣어줘야
    }

    public void onFinishClick(View v){
        Intent intent = new Intent();
        intent.putExtra("myResult", "abdcd");
        intent.putExtra("myValue", 1233);

        setResult(RESULT_OK, intent);

        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this,"my activity destory", Toast.LENGTH_SHORT);

    }

}
