package com.example.a.t14_location;

import android.Manifest;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] p = {Manifest.permission.ACCESS_FINE_LOCATION};
                //requestPermissions(new String[] {Manifest.permission.ACCESS_FINE_LOCATION});
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
            String[] permission = {Manifest.permission.ACCESS_FINE_LOCATION};
            requestPermissions(permission,0);
        }
        String res = "";
        TextView textView = (TextView) findViewById(R.id.textView);
        LocationManager manager = (LocationManager) getSystemService(LOCATION_SERVICE);
        List<String> providers = manager.getAllProviders();
        for(int i=0;i<providers.size();i++){
            //textView.append(providers.get(i));
            res +="provider:"+providers.get(i)+" status:"+manager.isProviderEnabled(providers.get(i))+"\n";

        }
        textView.setText(res);
    }
}
