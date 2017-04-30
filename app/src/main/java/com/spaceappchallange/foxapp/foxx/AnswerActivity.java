package com.spaceappchallange.foxapp.foxx;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class AnswerActivity extends AppCompatActivity {

    boolean isValid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent fromVerification = getIntent();
        boolean isValid = fromVerification.getBooleanExtra("validFlag", false);
        setContentView(R.layout.activity_answer);
        ImageView responseImage = (ImageView) findViewById(R.id.responseImage);
        if (isValid) {
            responseImage.setImageResource(R.drawable.good_answer);
        } else {
            responseImage.setImageResource(R.drawable.bad_answer);
        }
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                showInfo();
            }
        }, 5000);
    }

    public void showInfo() {
        Intent infoIntent = new Intent(this, InfoActivity.class);
        startActivity(infoIntent);
    }
}
