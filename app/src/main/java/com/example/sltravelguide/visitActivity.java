package com.example.sltravelguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class visitActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visit);

        final TextView textView1 = (TextView) findViewById(R.id.Sigiriya);
        final TextView textView2 = (TextView) findViewById(R.id.Ella);
        final TextView textView3 = (TextView) findViewById(R.id.Hikkaduwa);
        final TextView textView4 = (TextView) findViewById(R.id.nuwara);
        final TextView textView5 = (TextView) findViewById(R.id.Lipton);
        final TextView textView6 = (TextView) findViewById(R.id.Galle);
        final Button button = (Button) findViewById(R.id.buttonnext);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),vistActivity2.class);
                startActivity(i);
            }
        });
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),sigiriyaActivity.class);
                startActivity(i);
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),ellaActivity.class);
                startActivity(i);
            }
        });
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), hikkaduwaActivity.class);
                startActivity(i);
            }
        });
        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), kandyActivity.class);
                startActivity(i);
            }
        });
        textView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), liptonActivity.class);
                startActivity(i);
            }
        });
        textView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), galleActivity.class);
                startActivity(i);
            }
        });
    }
}