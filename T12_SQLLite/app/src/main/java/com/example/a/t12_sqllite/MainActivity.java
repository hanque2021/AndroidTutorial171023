package com.example.a.t12_sqllite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = (TextView) findViewById(R.id.textView);

        TestSQLiteHandler dbhandler = new TestSQLiteHandler(this);
        dbhandler.insert("kim", 10,"서울");
        dbhandler.insert("홍", 11,"부산");
        dbhandler.update("kim", 15);

        String res = dbhandler.selectAll();
        textView.setText(res);
    }
}
