package com.example.a.t01_widget;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.linear_layout);

        TextView myTextView = (TextView) findViewById(R.id.textView1);
        myTextView.setText("orcle java");
    }


}
