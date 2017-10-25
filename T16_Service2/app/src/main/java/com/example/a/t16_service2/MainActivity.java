package com.example.a.t16_service2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    MyService mySerive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(this, MyService.class);
       // bindService(intent,);
    }

    @Override
    protected void onStop() {
        super.onStop();
      //  unbindService();
    }

    public void onBtnClick(View v){
        int num = mySerive.getRandomNumber();
        Toast.makeText(mySerive, "random:"+num, Toast.LENGTH_SHORT).show();
    }
}
