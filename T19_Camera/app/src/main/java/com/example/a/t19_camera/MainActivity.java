package com.example.a.t19_camera;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    int TAKE_PHOTO = 100;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public  void  onBtnClick(View v){
        //String path = Environment.getExternalStorageDirectory()+"/1.jpg";
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE); //사진찍는 앱들에 대한 암시적 intent.ACTION_IMAGE_CAPTURE 를mainfest에 넣으면 사진 앱이됨
        //intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(new File(path)));
        //startActivity(intent);
        startActivityForResult(intent,TAKE_PHOTO);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==TAKE_PHOTO){
            if(requestCode==RESULT_OK){
                Bitmap image = (Bitmap) data.getExtras().get("data");
                imageView.setImageBitmap(image);
            }
        }
    }
}
