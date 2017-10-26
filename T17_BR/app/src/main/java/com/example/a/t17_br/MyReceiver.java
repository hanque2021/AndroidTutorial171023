package com.example.a.t17_br;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Object[] pdus = (Object[]) intent.getExtras().get("pdus");
        SmsMessage[] msgs = new SmsMessage[pdus.length];
        String str= "";
        for(int i =0;i<pdus.length;i++){
            msgs[i] = SmsMessage.createFromPdu((byte[])pdus[i]);
            str +="SMS from:"+msgs[i].getOriginatingAddress();
            str +=" : " +msgs[i].getMessageBody();
        }
        Toast.makeText(context, str, Toast.LENGTH_SHORT).show();
        //intent.getStringExtra("name");
        //intent.getIntExtra("value", 0);

    }
}
