package com.example.sltravelguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class hikkaduwaActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hikkaduwa);

        final Button button1 = (Button) findViewById(R.id.buttonlocation3);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),hikkaMapsActivity.class);
                startActivity(i);
            }
        });
//add video
        VideoView videoView = findViewById(R.id.videoView);
        videoView.setVideoPath("android.resource://" + getPackageName()
                +"/"+ R.raw.hikkabeach);

        videoView.start();
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
    }
}