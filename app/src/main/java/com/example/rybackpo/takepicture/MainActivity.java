package com.example.rybackpo.takepicture;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickbutton(View view){
        Intent toTakePic = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(toTakePic, REQUEST_IMAGE_CAPTURE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent){
        if(requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK){
            setContentView(R.layout.display_pic);
            Bitmap bmp = (Bitmap) intent.getExtras().get("data");
            ImageView image = (ImageView) findViewById(R.id.viewpic);
            image.setImageBitmap(bmp);
        }
    }
}
