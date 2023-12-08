package com.example.sltravelguide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class sigiriyaActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sigiriya);

        final Button button1 = (Button) findViewById(R.id.buttonlocation);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),MapsActivity.class);
                startActivity(i);
            }
        });
//add video
        VideoView videoView = findViewById(R.id.videoView);
        videoView.setVideoPath("android.resource://" + getPackageName()
        +"/"+ R.raw.sigi);

        videoView.start();
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
    }
}