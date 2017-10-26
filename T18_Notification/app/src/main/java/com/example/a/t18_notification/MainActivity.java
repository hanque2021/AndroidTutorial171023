package com.example.a.t18_notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onBtnClick(View v){
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);  //Compat 들어가 있으면 하위버전 호환 할 수 있음
        builder.setContentTitle("TITLE");
        builder.setContentText("TEXT");
        builder.setSubText("SUB TEXT");
        builder.setSmallIcon(R.mipmap.ic_launcher_round);
        Bitmap bm = BitmapFactory.decodeResource(getResources(),R.drawable.desert);  //bitmap으로 만들어야
        builder.setLargeIcon(bm);

        Intent intent = new Intent(this, NotiActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        PendingIntent pIntent = PendingIntent.getActivity(this,0, intent,0);  //클릭한 경우 해당 페이지로 이동
        builder.setContentIntent(pIntent);
        builder.setAutoCancel(true); //클릭한 경우 없애기

        Notification noti =builder.build();
        manager.notify(1234,noti);
    }

}
