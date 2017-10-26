package com.example.a.t21_style;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView selectedTextView, workingTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

            }
        };

        selectedTextView = (TextView) findViewById(R.id.selected_textView);
        workingTextView = (TextView) findViewById(R.id.working_textView);

        TableLayout tableLayout = (TableLayout) findViewById(R.id.remote_control_tablelayout);

        int number = 1;
        for(int i=2; i<tableLayout.getChildCount()-1; i++){
            TableRow row = (TableRow) tableLayout.getChildAt(i);
            for(int k=0; k<row.getChildCount(); k++){
                Button btn = (Button) row.getChildAt(k);
                btn.setText(""+number);
                btn.setOnClickListener(numberListener);
                number++;
            }
        }
        TableRow row = (TableRow) tableLayout.getChildAt( tableLayout.getChildCount()-1 );
        Button deleteButton = (Button) row.getChildAt(0);
        Button zeroButton = (Button) row.getChildAt(1);
        Button enterButton = (Button) row.getChildAt(2);

        zeroButton.setOnClickListener(numberListener);
        zeroButton.setText("0");
        deleteButton.setText("delete");
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                workingTextView.setText("0");
            }
        });

        enterButton.setText("enter");
        enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedTextView.setText( workingTextView.getText() );
                workingTextView.setText("0");
            }
        });
    }
}