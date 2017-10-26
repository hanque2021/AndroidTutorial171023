package com.example.a.t21_style;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView selectedTextView, workingTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        selectedTextView = (TextView) findViewById(R.id.selected_textView);
        workingTextView = (TextView) findViewById(R.id.working_textView);

        Button btnZero = (Button) findViewById(R.id.btnZero);
        Button btnOne = (Button) findViewById(R.id.btnOne);
        Button btnEnter = (Button) findViewById(R.id.btnEnter);

        View.OnClickListener numberListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button btn = (Button) view;
                String working = workingTextView.getText().toString();
                if(working.equals("0")){
                    workingTextView.setText(btn.getText());
                }else{
                    workingTextView.setText(working+btn.getText());
                }
                //int number = Integer.parseInt(btn.getText().toString());
            }
        };

        btnZero.setOnClickListener(numberListener);
        btnOne.setOnClickListener(numberListener);

        btnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedTextView.setText(workingTextView.getText());
                workingTextView.setText("0");
            }
        });
    }



}
