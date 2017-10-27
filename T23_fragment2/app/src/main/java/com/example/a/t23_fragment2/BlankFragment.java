package com.example.a.t23_fragment2;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {


    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_blank, container, false);
        final TextView textViewCounter = v.findViewById(R.id.textViewCounter);
        Button btnIncrease = v.findViewById(R.id.btnIncrease);

        btnIncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int number = Integer.parseInt((textViewCounter.getText().toString()));
                number++;
                textViewCounter.setText(""+number);
            }
        });
        return  v;
    }

}
