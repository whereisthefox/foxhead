package com.spaceappchallange.foxapp.foxx;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton fab;
    MainActivity self;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        fab = (FloatingActionButton) findViewById(R.id.fab);
        self = this;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newIntent = new Intent(self, CameraActivity.class);
                startActivity(newIntent);
            }
        });
    }
}
