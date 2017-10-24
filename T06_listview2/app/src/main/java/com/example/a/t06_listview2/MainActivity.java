package com.example.a.t06_listview2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    class MyData{
        int itemIcon;
        String title;
        String desc;
    }

    ArrayList<MyData> myList = new ArrayList<>();

    private void initData(){
        for(int i=0; i<50;i++){
            MyData myData = new MyData();
            myData.title = "title"+i;
            myData.desc ="desc"+i;
            myData.itemIcon = R.mipmap.ic_launcher;
            myList.add(myData);
        }
    }

    class  MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return myList.size();
        }

        @Override
        public Object getItem(int i) {
            return myList.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup viewGroup) {
            //return null;
            if(convertView==null){
                LayoutInflater inf = getLayoutInflater();
                convertView = inf.inflate(R.layout.item_view,null);
            }
            MyData myData = myList.get(position);

            TextView tvTitle = (TextView) convertView.findViewById(R.id.item_title);
            TextView tvDesc = (TextView) convertView.findViewById(R.id.item_desc);
            tvTitle.setText(myData.title);
            tvDesc.setText(myData.desc);

            return convertView;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        ListView listView = (ListView) findViewById(R.id.listView);
        MyAdapter adapter = new MyAdapter();
        listView.setAdapter(adapter);
    }
}
