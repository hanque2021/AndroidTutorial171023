package com.example.a.t11_pref;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences pref = getSharedPreferences("settings",0);
        String name = pref.getString("name", "");

        Toast.makeText(this, "name is"+name, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();

        SharedPreferences pref=getSharedPreferences("settings", 0);
        SharedPreferences.Editor editor = pref.edit();

        editor.putString("name","hello");
        editor.apply();

    }
}
