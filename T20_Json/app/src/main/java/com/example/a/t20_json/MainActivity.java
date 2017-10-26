package com.example.a.t20_json;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    String str = "[{'name':'kim', 'tel':'010-1111-2222','age':20},"+
                "{'name':'park', 'tel':'010-1111-3333','age':21},"+
                "{'name':'lee', 'tel':'010-1111-4444,'age':22}]";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            JSONArray array = new JSONArray(str);
            for(int i=0;i<array.length();i++){
                JSONObject obj = array.getJSONObject(i);
                String name = obj.getString("name");
                String tel = obj.getString("tel");
                int age  = obj.getInt("age");

                Log.d("json",name+" "+tel+ " "+age);
                //Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public  void  onBtnClick(View v){

    }

}
