package com.spaceappchallange.foxapp.foxx;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity {

    String creatureName = "THE EUROPEAN ROE DEER";
    String latinName = "(Capreolus capreolus)";
    String description = "The roe deer is relatively small, redish and grey-brown. The species is well-adapted to cold environment and is widespread in Europe, from the Mediterranean to Scandinavia and from Britain to the Caucasus. It is disting from somewhat larger Siberian roe deer";
    String distance = "4km";
    String seenInWeek = "10";
    Button cameraButton;

    TextView titleTextBox;
    TextView latinNameTextView;
    TextView descriptionTextView;
    InfoActivity self;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_info);

        this.self = this;
        this.cameraButton = (Button) findViewById(R.id.cameraButton);
        this.titleTextBox = (TextView) findViewById(R.id.titleTextBox);
        this.latinNameTextView = (TextView) findViewById(R.id.latinNameTextView);
        this.descriptionTextView = (TextView) findViewById(R.id.descriptionTextView);

        this.titleTextBox.setText(creatureName);
        this.latinNameTextView.setText(latinName);
        this.descriptionTextView.setText(description);

        this.cameraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newIntent = new Intent(self, CameraActivity.class);
                startActivity(newIntent);
            }
        });
    }
}
