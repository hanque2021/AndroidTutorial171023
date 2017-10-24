package com.example.a.t07_thread;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    class MyThread extends  Thread{
        @Override
        public void run() {
            for(int i=0; i<100000;i++){
                Log.d("thread", "count:"+i);
                //myButton.setText("count "+i);  //Thread 에서 기본적으로 UI접근 못한다. 실행 시 에러.
             }
        }
    }
    Button myButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myButton = (Button) findViewById(R.id.myButton);

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyThread th = new MyThread();
                th.start();

                //for(int i=0; i<1000000;i++){
                //    Log.d("thread", "count:"+i);
               // }
            }
        });



    }


}
