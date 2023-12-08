package com.example.sltravelguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class loginActivity extends AppCompatActivity {
    EditText edUserName, edPassword, edEmail, edreenterpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final Button button1 = (Button) findViewById(R.id.Signup);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = edUserName.getText().toString();
                String password = edPassword.getText().toString();
                String email = edEmail.getText().toString();
                String reenterpassword = edreenterpassword.getText().toString();

                DatabaseHelper db = new DatabaseHelper(getApplicationContext(),"SL Travel Guide",null,1);

                if (username.length() == 0 || password.length() == 0 || email.length() == 0 || reenterpassword.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Please fill All details", Toast.LENGTH_SHORT).show();
                } else {
                    if (password.compareTo(reenterpassword) == 0) {
                        if (isValid(password)) {
                            db.signup(username,password,email);
                            Toast.makeText(getApplicationContext(), "SignUp Successful", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(getApplicationContext(), signupActivity.class);
                            startActivity(i);
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "Password must contain at least 8 characters, having letter,digit and letters", Toast.LENGTH_SHORT).show();
                        }
                        if (validateEmailAddress(edEmail)){

                        }else {
                            Toast.makeText(getApplicationContext(), "Invalid Email Address", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "Password and Re-enter password didn't match", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        edUserName = findViewById(R.id.editTextSignupUserName);
        edPassword = findViewById(R.id.editTextSignUpPassword);
        edEmail = findViewById(R.id.editTextSignUpEmailAddress);
        edreenterpassword = findViewById(R.id.editTextSignUpreenterpassword);
    }
//validate password
    public static boolean isValid(String passwordhere){
        int f1 =0, f2 = 0, f3 = 0;
        if (passwordhere.length() < 8){
            return false;
        }else {
            for (int p = 0; p < passwordhere.length(); p++){
                if (Character.isLetter(passwordhere.charAt(p))){
                    f1=1;
                }
            }
            for (int r=0; r < passwordhere.length(); r++){
                if (Character.isDigit(passwordhere.charAt(r))){
                    f2 = 1;
                }
            }
            for (int s =0; s < passwordhere.length(); s++){
                char c = passwordhere.charAt(s);
                if (c>=33 && c<=46 || c==64){
                    f3 = 1;
                }
            }
            if (f1==1 && f2==1 && f3==1) {
                return true;
            }
            return false;
        }
    }
//check email address
    private boolean validateEmailAddress(EditText edEmail){
        String emailInput = edEmail.getText().toString();
        if (!emailInput.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()){
            return true;
        }else {
            return false;
        }
    }
}
