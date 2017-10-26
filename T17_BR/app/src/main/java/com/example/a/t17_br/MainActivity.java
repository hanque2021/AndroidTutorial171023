package com.example.a.t17_br;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //동적사용예제
    BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action =intent.getAction();  //Action을 여러개 받은 경우  if~ else 처리

            if(action.equals(Intent.ACTION_BATTERY_CHANGED)){
                int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL,0);  //int level = batteryStatus.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
                Toast.makeText(context, "batt:"+level, Toast.LENGTH_SHORT).show();
            }else if(action.equals(Intent.ACTION_BATTERY_LOW)){
                Toast.makeText(context, "Battery Low", Toast.LENGTH_SHORT).show();
            }else if(action.equals("abcdefg")){
                Toast.makeText(context, "custom br", Toast.LENGTH_SHORT).show();
            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void onStart() {
        super.onStart();
        //Mainfet에 설정하는 경우에는 앱이 활성화 안되더라도 무조건 적용(문자가 계속오는 경우).. 동적인 이경우에는 앱이 활성화된 경우만 처리됨
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_BATTERY_CHANGED);
        filter.addAction(Intent.ACTION_BATTERY_LOW);
        filter.addAction("abcdefg");   //임의의 액션을 등록해줄수 있다.
        registerReceiver(receiver,filter);
    }

    @Override
    protected void onStop() {
        super.onStop();

        unregisterReceiver(receiver);
    }

    public void onBtnClick(View v){
        Intent intent = new Intent("abcdefg");
        sendBroadcast(intent);
    }
}
