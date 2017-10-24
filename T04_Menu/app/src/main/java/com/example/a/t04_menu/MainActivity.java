package com.example.a.t04_menu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //context 메뉴 위한 코드
        TextView textView  = (TextView) findViewById(R.id.textView);
        registerForContextMenu(textView);
    }

    //context 메뉴 처리
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0,100,0,"menu1");
        menu.add(0,101,0,"menu2");

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        //return super.onContextItemSelected(item);

        if(item.getItemId()==100){
            Toast.makeText(this, "context1 menu1", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "context2 menu2", Toast.LENGTH_SHORT).show();
        }
        return true;
    }

    //옵션메뉴 처리
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_main,menu);  //xml을 메모리로 로딩
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //return super.onOptionsItemSelected(item);
        if(item.getItemId()==R.id.myItem1){
            Toast.makeText(this, "myItem1 select", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "myItem2 select", Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}
