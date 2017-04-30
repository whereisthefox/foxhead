package com.spaceappchallange.foxapp.foxx;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class PhotoVerificationActivity extends AppCompatActivity {
    String name;
    Button verifyButton;
    Button verify;
    String species;
    ImageView imageView;
    Bitmap myBitmap;
    PhotoVerificationActivity self;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        self = this;
        setContentView(R.layout.activity_photo_verification);


        verifyButton = (Button) this.findViewById(R.id.verifyButton);
        imageView = (ImageView) self.findViewById(R.id.imageView);
        verifyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mockedValidation();
            }
        });

        Map config = new HashMap();
        config.put("cloud_name", "foxtail");
        config.put("api_key", "228946752362694");
        config.put("api_secret", "GXzd8f09RSnZFcmzPS0ul4w_siY");
        final Cloudinary cloudinary = new Cloudinary(config);

        Intent oldIntent = getIntent();
        name = oldIntent.getStringExtra("URI");
        File imgFile = new File(name);
        myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
        imageView.setImageBitmap(myBitmap);

        final String fileName = String.valueOf(new Date().getTime()) + ".jpg";
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    ByteArrayOutputStream bos = new ByteArrayOutputStream();
                    myBitmap.compress(Bitmap.CompressFormat.PNG, 0 /*ignored for PNG*/, bos);
                    byte[] bitmapdata = bos.toByteArray();
                    final ByteArrayInputStream bs = new ByteArrayInputStream(bitmapdata);
                    cloudinary.uploader().upload(bs, ObjectUtils.asMap("public_id", fileName));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

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
