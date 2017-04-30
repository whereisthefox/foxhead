package com.spaceappchallange.foxapp.foxx;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.io.File;
import java.util.Random;

public class PhotoVerificationActivity extends AppCompatActivity {
    String name;
    Button verifyButton;
    Button verify;
    String species;
    PhotoVerificationActivity self;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        self = this;
        setContentView(R.layout.activity_photo_verification);

        ImageView imageView = (ImageView) this.findViewById(R.id.imageView);
        verifyButton = (Button) this.findViewById(R.id.verifyButton);

        verifyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mockedValidation();
            }
        });

        Intent oldIntent = getIntent();
        name = oldIntent.getStringExtra("URI");
        File imgFile = new File(name);
        Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
        imageView.setImageBitmap(myBitmap);
        EditText editText = (EditText) findViewById(R.id.editText);
        species = editText.getText().toString();
        verify = (Button) findViewById(R.id.verifyButton);
        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent newIntention = new Intent(self, DevOnlyActivity.class);
//                newIntention.putExtra("URI", species);
//                startActivity(newIntention);
                mockedValidation();
            }
        });
    }

    public void mockedValidation() {
        Random random = new Random();
        boolean isValid = random.nextBoolean();
        Intent answerIntent = new Intent(this, AnswerActivity.class);
        startActivity(answerIntent);
    }
}
