package com.example.demoapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

     EditText Email,Password;
    protected Button Login;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Email = findViewById(R.id.editTextEmail);
        Password = findViewById(R.id.editTextPassword);
        Login = (Button)findViewById(R.id.cirLoginButton);
        fAuth = FirebaseAuth.getInstance();

        /*Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                *//*String email = Email.getText().toString().trim();
                String password = Password.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    Email.setError("Email is Required.");
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    Password.setError("Password is Required.");
                    return;
                }

                if(password.length() < 6){
                    Password.setError("Password must be >= 6 Characters");
                    return;
                }

                fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener< AuthResult >() {
                    @Override
                    public void onComplete(@NonNull Task< AuthResult > task) {
                       if (task.isSuccessful()){
                           Toast.makeText(LoginActivity.this, "Logged in successfully", Toast.LENGTH_SHORT).show();
                           startActivity(new Intent(getApplicationContext(),MainActivity.class));
                       }
                       else {
                           Toast.makeText(LoginActivity.this, "Error !" +task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                       }
                    }
                });*//*
            }
        });*/
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        setContentView(R.layout.activity_login);
    }

    public void Login(View view){
        String email = Email.getText().toString().trim();
        String password = Password.getText().toString().trim();

        if(TextUtils.isEmpty(email)){
            Email.setError("Email is Required.");
            return;
        }
        if(TextUtils.isEmpty(password)){
            Password.setError("Password is Required.");
            return;
        }

        if(password.length() < 6){
            Password.setError("Password must be >= 6 Characters");
            return;
        }

        fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener< AuthResult >() {
            @Override
            public void onComplete(@NonNull Task< AuthResult > task) {
                if (task.isSuccessful()){
                    Toast.makeText(LoginActivity.this, "Logged in successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                }
                else {
                    Toast.makeText(LoginActivity.this, "Error !" +task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void onLoginClick(View view){
        startActivity(new Intent(this,RegisterActivity.class));
        overridePendingTransition(R.anim.slide_in_right, R.anim.stay);
    }
}