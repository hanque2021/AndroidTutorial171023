package com.example.a.t02_widget2;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText myEditText = (EditText) findViewById(R.id.myEditText);
        myEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String str = (String) charSequence.toString();

                if(str.length()>10){
                    Log.d("123", "size over error") ;
                }
                //Log.d("123", "count"+i2) ;
                //if(i2>10){
                 //   Log.d("123", "size over error") ;
                //}

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        Button btn = (Button) findViewById(R.id.helloBtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = myEditText.getText().toString();
                Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();
               // Toast.makeText(MainActivity.this, "Helllo world", Toast.LENGTH_SHORT).show();
            }
        });

        CheckBox myCheckBox = (CheckBox) findViewById(R.id.myCheckBox1);
        myCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Toast.makeText(MainActivity.this, "Hello CheckBox", Toast.LENGTH_SHORT).show();
            }
        });

        RadioGroup myRadioGroup = (RadioGroup) findViewById(R.id.myRadioGroup);
        myRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                switch (i){
                    case R.id.myRadio1:
                        Toast.makeText(MainActivity.this, "radio1", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.myRadio2:
                        Toast.makeText(MainActivity.this, "radio2", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.myRadio3:
                        Toast.makeText(MainActivity.this, "radio3", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });



    }
}
