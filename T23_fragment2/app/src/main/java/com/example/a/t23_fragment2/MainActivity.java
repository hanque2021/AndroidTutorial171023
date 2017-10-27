package com.example.a.t23_fragment2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public  void onBtnClick(View v){
        FragmentManager manager = getSupportFragmentManager();
        Fragment fr = manager.findFragmentById(R.id.frame);

        switch (v.getId()) {
            case R.id.btnAdd:
                if(fr==null){
                    fr = new BlankFragment();
                    FragmentTransaction tr = manager.beginTransaction();
                    tr.add(R.id.frame,fr,"counter");
                    tr.addToBackStack(null);
                    tr.commit();
                }
                break;
            case R.id.btnRemove:
                if(fr!=null){
                    FragmentTransaction tr = manager.beginTransaction();
                    tr.remove(fr);
                    tr.commit();
                }
                break;
            case R.id.btnReplace:
                if(fr!=null){
                    FragmentTransaction tr = manager.beginTransaction();
                    if(fr.getTag().equals("counter")){
                        TextFragment tf = new TextFragment();
                        tr.replace(R.id.frame,tf,"text");
                        tr.addToBackStack(null);
                        tr.commit();
                    }else{
                        BlankFragment bf = new BlankFragment();
                        tr.replace(R.id.frame, bf,"counter");
                        tr.addToBackStack(null);
                        tr.commit();
                    }
                }
                break;
            case R.id.btnHide:
                if(fr!=null){
                    FragmentTransaction tr = manager.beginTransaction();
                    if(fr.isHidden()){
                        tr.show(fr);
                    }else{
                        tr.hide(fr);
                    }
                    tr.commit();
                }
                break;
        }
    }
}
