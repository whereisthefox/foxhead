package com.spaceappchallange.foxapp.foxx;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.Inet4Address;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class DevOnlyActivity extends AppCompatActivity {

    private EditText mTextMessage;
    private TextView label;
    private Button button;
    private String species;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dev_only);
        Intent oldIntention = getIntent();
        species = "sarenka";
        mTextMessage = (EditText) findViewById(R.id.addressEdit);
        label = (TextView) findViewById(R.id.label);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = mTextMessage.getText().toString();
                URL url = null;
                try {
                    url = new URL(text);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                HttpURLConnection conn = null;
                try {
                    conn = (HttpURLConnection)url.openConnection();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                conn.setReadTimeout(20000);
                conn.setConnectTimeout(15000);
                try {
                    conn.setRequestMethod("GET");
                } catch (ProtocolException e) {
                    e.printStackTrace();
                }
                label.setText("Success");
            }
        });
    }

}
