package com.example.a.t10_mediaplayer;

import android.Manifest;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.SeekBar;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    SeekBar seekBar = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar = (SeekBar) findViewById(R.id.seekBar);

        //Runtime permission에 대해서 권한 부여 물어보는 코드 삽입. deny한 경우 설정>앱가서 변경해야 함.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) { //M이 마시멜로 나타냄.
            String[] permissions = {Manifest.permission.READ_EXTERNAL_STORAGE};
            requestPermissions(permissions,0);
        }


    }

    MediaPlayer mp = null;
    public  void onPlayClick(View v){
        String path = Environment.getExternalStorageDirectory() + "/Download/Kalimba.mp3";
        mp = new MediaPlayer();
        //mp.getCurrentPosition();
        try {
            mp.setDataSource(path);
            mp.prepare();
            mp.start();
            seekBar.setMax(mp.getDuration());
            Thread th = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (mp!=null){
                        try {
                            seekBar.setProgress(mp.getCurrentPosition());
                        }catch (Exception e){
                            seekBar.setProgress(0);
                        }
                    }
                }
            });
            th.start();

        } catch (IOException e) {
            e.printStackTrace();
        }

        //File f = new File(path);
        //Toast.makeText(this, "file exists:"+f.exists(), Toast.LENGTH_SHORT).show();

    }

    public  void onStopClick(View v){
        if(mp!=null){
            mp.stop();
            mp.release();
            mp = null;
        }
    }
}
