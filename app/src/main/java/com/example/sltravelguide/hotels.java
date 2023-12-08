package com.example.sltravelguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class hotels extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotels);

        final TextView textView1 = (TextView) findViewById(R.id.Colombo);
        final TextView textView2 = (TextView) findViewById(R.id.Kandy);
        final TextView textView3 = (TextView) findViewById(R.id.Galle);
        final TextView textView4 = (TextView) findViewById(R.id.Jaffna);
        final TextView textView5 = (TextView) findViewById(R.id.Ella);
        final TextView textView6 = (TextView) findViewById(R.id.Meemure);

        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),colomboActivity.class);
                startActivity(i);
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),kandyhotelActivity.class);
                startActivity(i);
            }
        });
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),gallehotelActivity.class);
                startActivity(i);
            }
        });
        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),jaffnahotelActivity.class);
                startActivity(i);
            }
        });
        textView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),ellahotelActivity.class);
                startActivity(i);
            }
        });
        textView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),meemurehotelActivity.class);
                startActivity(i);
            }
        });
    }
}