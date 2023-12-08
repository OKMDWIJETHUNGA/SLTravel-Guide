package com.example.sltravelguide;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class signupActivity extends AppCompatActivity {
    EditText edUserName, edPassword;
    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        final Button button1 = (Button) findViewById(R.id.Login);
        final TextView textView = (TextView) findViewById(R.id.ForgotPassword);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),ComformActivity.class);
                startActivity(i);
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edUserName.getText().toString();
                String password = edPassword.getText().toString();
//connect database
                DatabaseHelper db = new DatabaseHelper(getApplicationContext(),"SL Travel Guide",null,1);
//check user fill all details
                if (username.length()==0 || password.length()==0){
                    Toast.makeText(getApplicationContext(),"Please fill All details",Toast.LENGTH_SHORT).show();
                }else {
//check username and password
                    if (db.login(username,password)==1){
                        Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_SHORT).show();

                        SharedPreferences sharedPreferences = getSharedPreferences("shared_pref", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("username",username);
                        // to save data with key and value
                        editor.apply();
//link to another activity
                        Intent i = new Intent(getApplicationContext(),dashboardActivity.class);
                        startActivity(i);
                    }else {
                        Toast.makeText(getApplicationContext(), "Invalid Username and Password", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        edUserName = findViewById(R.id.editTextLoginUserName);
        edPassword = findViewById(R.id.editTextLoginPassword);
    }
}