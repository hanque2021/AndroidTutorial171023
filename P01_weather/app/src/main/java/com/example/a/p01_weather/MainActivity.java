package com.example.a.p01_weather;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    MyAdapter adapter;

    class WeatherData{
        int day;
        int hour;
        float temp;
        String wfKor;
    }
    ArrayList<WeatherData> weatherList = new ArrayList<>();

    class MyPullParser extends AsyncTask<String, Void, String> {

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            adapter.notifyDataSetChanged();

            //for(int i=0; i<weatherList.size(); i++){
            //    Log.d("test", ""+weatherList.get(i).temp);
            //}
        }

        @Override
        protected String doInBackground(String... strings) {
            String res = "";
            XmlPullParserFactory factory = null;
            try {
                factory = XmlPullParserFactory.newInstance();
                XmlPullParser xpp = factory.newPullParser();
                InputStream input = new URL(strings[0]).openStream();
                xpp.setInput(input, "utf-8");

                int eventType = xpp.getEventType();
                int readType = 0; // 0: not read, 1: hour, 2:day, 3:temp, 4:wfKor
                WeatherData data = null;
                while(eventType != XmlPullParser.END_DOCUMENT){
                    if(eventType == XmlPullParser.START_TAG){
                        String tag = xpp.getName();
                        if(tag.equals("hour")){
                            data = new WeatherData();
                            weatherList.add(data);
                        }
                        if(tag.equals("hour")){
                            readType = 1;
                        }else if (tag.equals("day")){
                            readType = 2;
                        }else if (tag.equals("temp")){
                            readType = 3;
                        }else if (tag.equals("wfKor")){
                            readType = 4;
                        }else{
                            readType = 0;
                        }
                    }else if(eventType == XmlPullParser.TEXT){
                        switch (readType){
                            case 1:
                                data.hour = Integer.parseInt(xpp.getText());
                                break;
                            case 2:
                                data.day = Integer.parseInt(xpp.getText());
                                break;
                            case 3:
                                data.temp = Float.parseFloat(xpp.getText());
                                break;
                            case 4:
                                data.wfKor = xpp.getText();
                                break;
                        }
                        readType = 0;
                    }
                    eventType = xpp.next();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return res;
        }
    }


    class  MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return weatherList.size();
        }

        @Override
        public Object getItem(int i) {
            return weatherList.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup viewGroup) {
            if(convertView==null){
                LayoutInflater inf = getLayoutInflater();
                convertView = inf.inflate(R.layout.item_view,null);
            }
            WeatherData data = weatherList.get(position);

            TextView tvTitle = (TextView) convertView.findViewById(R.id.item_title);
            TextView tvDesc = (TextView) convertView.findViewById(R.id.item_desc);
            ImageView itemIcon = convertView.findViewById(R.id.itemIcon);

            tvTitle.setText(data.temp+"도 "+data.wfKor  );
            tvDesc.setText(data.day+"일 "+data.hour+"시" );
            //itemIcon.setImageResource(data.itemIcon);

            //TextView tvDay = (TextView) convertView.findViewById(R.id.item_day);
            //TextView tvHour = (TextView) convertView.findViewById(R.id.item_hour);
            //TextView tvTemp = (TextView) convertView.findViewById(R.id.item_temp);
            //TextView tvWfKor = (TextView) convertView.findViewById(R.id.item_wfkor);
            //ImageView itemIcon = convertView.findViewById(R.id.itemIcon);

            //tvDay.setText(myData.day);
            //tvHour.setText(myData.hour);
            //tvTemp.setText(myData.temp);
            //tvWfKor.setText(myData.wfKor);
            //itemIcon.setImageResource(myData.temp);

            return convertView;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);
        adapter = new MyAdapter();
        listView.setAdapter(adapter);
        Toast.makeText(this, "test", Toast.LENGTH_SHORT).show();

    }

    public void onBtnClick(View v){
        MyPullParser task = new MyPullParser();
        task.execute("http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1153052000");

    }


}
