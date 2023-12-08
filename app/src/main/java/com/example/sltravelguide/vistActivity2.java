package com.example.sltravelguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class vistActivity2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vist2);
//assign activity to variables
        final TextView textView1 = (TextView) findViewById(R.id.yapanaya);
        final TextView textView2 = (TextView) findViewById(R.id.nuwaraeliya);
        final TextView textView3 = (TextView) findViewById(R.id.sripadaya);
        final TextView textView4 = (TextView) findViewById(R.id.mee);
        final TextView textView5 = (TextView) findViewById(R.id.unawatuna);
        final TextView textView6 = (TextView) findViewById(R.id.mirissa);

        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),jaffnaActivity.class);
                startActivity(i);
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),nuwaraeliyaActivity.class);
                startActivity(i);
            }
        });
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), sripadayaActivity.class);
                startActivity(i);
            }
        });
        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), meemureActivity.class);
                startActivity(i);
            }
        });
        textView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), unawatunaActivity.class);
                startActivity(i);
            }
        });
        textView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), mirissaActivity.class);
                startActivity(i);
            }
        });
    }
}