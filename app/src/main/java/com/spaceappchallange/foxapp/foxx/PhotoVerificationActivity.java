package com.spaceappchallange.foxapp.foxx;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class PhotoVerificationActivity extends AppCompatActivity {
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_verification);
        Intent oldIntent = getIntent();
        name = oldIntent.getStringExtra("URI");
    }
}
