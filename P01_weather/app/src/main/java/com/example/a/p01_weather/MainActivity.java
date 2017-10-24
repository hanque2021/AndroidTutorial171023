package com.example.a.p01_weather;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    class WeatherData{
        int day;
        int hour;
        float temp;
        String wfKor;
    }

    ArrayList<WeatherData> weatherList = new ArrayList<>();

    class  MyPullParser extends AsyncTask<String, Void, String>{

        String res ="";

        @Override
        protected String doInBackground(String... strings) {

            XmlPullParserFactory factory = null;
            try {
                factory = XmlPullParserFactory.newInstance();
                XmlPullParser xpp =factory.newPullParser();
                InputStream input = new URL(strings[0]).openStream();
                xpp.setInput(input, "utf-8");

                int eventType = xpp.getEventType();
                boolean bRead = false;
                int readType = 0; // 0:not read, 1:hour, 2:day, 3:temp, 4:wfKor
                WeatherData data =null;
                while (eventType != XmlPullParser.END_DOCUMENT){
                    if(eventType== XmlPullParser.START_TAG){
                        String tag = xpp.getName();
                        if(tag.equals("hour")  ){
                            data = new WeatherData();
                            weatherList.add(data);
                        }
                        if(tag.equals("hour")){
                            readType=1;
                        }else if(tag.equals("day")){
                            readType=2;
                        }else if(tag.equals("temp")){
                            readType=3;
                        }else if(tag.equals("wfKor")){
                            readType=4;
                        }else {
                            readType=0;
                        }

                        if(tag.equals("hour") || tag.equals("day")||tag.equals("temp")|| tag.equals("wfKor") ){
                            switch (readType){
                                case 1:
                                    data.hour = Integer.parseInt(xpp.getText());
                                    break;
                                case 2:
                                    data.day = Integer.parseInt(xpp.getText());
                                    break;
                                case 3:
                                    data.temp = Integer.parseInt(xpp.getText());
                                    break;
                                case 4:
                                    data.wfKor = xpp.getText();
                                    break;
                            }
                        }
                    }else  if(eventType==XmlPullParser.TEXT){
                        if(bRead){
                            Log.d("weather", xpp.getText());
                            bRead = false;
                        }
                    }
                    eventType= xpp.next();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // textView
    }

    public void  onBtnClick(View v){
        MyPullParser task = new MyPullParser();
        task.execute("http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1153052000");
    }





    class MyPullParser extends AsyncTask<String, Void, String>{

        @Override
        protected String doInBackground(String... strings) {
            XmlPullParserFactory factory = null;
            try {
                factory = XmlPullParserFactory.newInstance();
                XmlPullParser xpp =factory.newPullParser();
                InputStream input = new URL(strings[0]).openStream();
                xpp.setInput(input, "utf-8");

                int eventType = xpp.getEventType();
                boolean bRead = false;

                while (eventType != XmlPullParser.END_DOCUMENT){
                    MyData myData = new MyData();

                    if(eventType== XmlPullParser.START_TAG){
                        String tag = xpp.getName();
                        if(tag.equals("hour")  ){
                            bRead = true;
                            myData.hour =  xpp.getText();

                        }
                        if(tag.equals("day")){
                            bRead = true;
                            myData.day = xpp.getText();
                        }
                        if(tag.equals("temp")){
                            bRead = true;
                            myData.temp = xpp.getText();
                        }
                        if(tag.equals("wfKor")){
                            bRead = true;
                            myData.wfKor = xpp.getText();
                        }

                    }else  if(eventType==XmlPullParser.TEXT){
                        if(bRead){
                            Log.d("weather", xpp.getText());
                            bRead = false;
                        }
                    }

                    if(bRead==true) {
                        myList.add(myData);
                    }
                    eventType= xpp.next();
                }

                class  MyAdapter extends BaseAdapter {

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
                            convertView = inf.inflate(R.layout.activity_main,null);
                        }
                        MyData myData = myList.get(position);

                        TextView tvDay = (TextView) convertView.findViewById(R.id.day);
                        TextView tvHour = (TextView) convertView.findViewById(R.id.hour);
                        TextView tvTemp = (TextView) convertView.findViewById(R.id.temp);
                        TextView tvWfKor = (TextView) convertView.findViewById(R.id.wfkor);
                        ImageView weatherIcon = convertView.findViewById(R.id.weather_icon);

                        tvDay.setText(myData.day);
                        tvHour.setText(myData.hour);
                        tvTemp.setText(myData.temp);
                        tvWfKor.setText(myData.wfKor);
                        //weatherIcon.setImageResource(myData.w);

                        return convertView;
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
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
            ImageView itemIcon = convertView.findViewById(R.id.itemIcon);

            tvTitle.setText(myData.title);
            tvDesc.setText(myData.desc);
            itemIcon.setImageResource(myData.itemIcon);

            return convertView;
        }
    }


}
