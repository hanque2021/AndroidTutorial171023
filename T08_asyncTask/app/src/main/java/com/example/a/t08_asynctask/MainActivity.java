package com.example.a.t08_asynctask;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    class  MyTask extends AsyncTask<Integer, Float,String>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
        }

        @Override
        protected void onProgressUpdate(Float... values) {
            super.onProgressUpdate(values);
            textView.setText("count:"+values[0]);
        }

        @Override
        protected String doInBackground(Integer... integers) {
            int value = integers[0];
            for(int i=value;i<100000;i++){
                Log.d("asynctask", "count:"+i);
                //textView.setText("count:"+i);
                publishProgress((float)i);
            }
            //int b = integers[1]
            return "doInBackGroud Done!"; //null;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);
        MyTask task = new MyTask();
        task.execute(1000);
        //task.execute(1000,2000,3000,4000);

    }
}
