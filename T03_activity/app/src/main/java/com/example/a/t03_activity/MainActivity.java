package com.example.a.t03_activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int MY_REQ = 100; //어디에서 가져오는 정의하기 위해
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onBtnClick(View v){
        Intent intent = new Intent(this,MyActivity.class);
        //intent에 값 전달
        intent.putExtra("id", "abcd");
        intent.putExtra("pw", "1234");
        intent.putExtra("level",1);

        //startActivity(intent);   //결과값 안 받는 경우
        startActivityForResult(intent,MY_REQ);   //결과값 받는 경우, 이 액티비티의 값을 전달
    }

    //다른 activity에서 값 넘겨 받는 경우
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
       // super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==MY_REQ){
            if(resultCode == RESULT_OK){
                String str = data.getStringExtra("myResult");
                Toast.makeText(this, "str:"+str, Toast.LENGTH_SHORT).show();
            }
        }
    }


}
