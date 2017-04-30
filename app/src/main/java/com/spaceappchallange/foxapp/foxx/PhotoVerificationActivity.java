package com.spaceappchallange.foxapp.foxx;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.io.File;

public class PhotoVerificationActivity extends AppCompatActivity {
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_verification);
        ImageView imageView = (ImageView) this.findViewById(R.id.imageView);
        Intent oldIntent = getIntent();
        name = oldIntent.getStringExtra("URI");
        File imgFile = new File(name);
        Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
        imageView.setImageBitmap(myBitmap);
        //imageView.setRotation(90);
    }
}
