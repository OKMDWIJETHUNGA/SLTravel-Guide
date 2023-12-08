package com.example.sltravelguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class dashboardActivity extends AppCompatActivity implements SensorEventListener {
//declare variable
    private TextView textView1;
    private SensorManager sensorManager;
    private Sensor tempSensor;
    private Boolean isTempartureSensorAvailable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
//implementing temperature sensor
        textView1 = findViewById(R.id.textView);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        if (sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE) != null){
            tempSensor = sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
            isTempartureSensorAvailable = true;
        }else {
            isTempartureSensorAvailable = false;
        }
//declare variables to link pages
        final TextView textView1 = (TextView) findViewById(R.id.VisitPlaces);
        final TextView textView2 = (TextView) findViewById(R.id.Transport);
        final TextView textView3 = (TextView) findViewById(R.id.Hotels);
        final TextView textView4 = (TextView) findViewById(R.id.AboutUs);
// link to another activities
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),visitActivity.class);
                startActivity(i);
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),transportActivity.class);
                startActivity(i);
            }
        });
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), hotels.class);
                startActivity(i);
            }
        });
        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), aboutus.class);
                startActivity(i);
            }
        });
    }
//method for sensor
    @Override
    public void onSensorChanged(SensorEvent event) {
        textView1.setText(event.values[0]+" °C");
    }
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }
    @Override
    protected void onResume() {
        super.onResume();
        if (isTempartureSensorAvailable){
            sensorManager.registerListener(this,tempSensor,SensorManager.SENSOR_DELAY_NORMAL);
        }
    }
    @Override
    protected void onPause() {
        super.onPause();
        if (isTempartureSensorAvailable){
            sensorManager.unregisterListener(this);
        }
    }
}