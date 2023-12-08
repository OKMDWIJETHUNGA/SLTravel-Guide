package com.example.sltravelguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class unawatunaActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unawatuna);

        final Button button1 = (Button) findViewById(R.id.buttonlocation);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),unawatunaMapsActivity.class);
                startActivity(i);
            }
        });
        VideoView videoView = findViewById(R.id.videoView);
        videoView.setVideoPath("android.resource://" + getPackageName()
                +"/"+ R.raw.unawatu);

        videoView.start();
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
    }
}