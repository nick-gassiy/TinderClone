package com.example.tindercloneapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.tindercloneapp.Registration.EmailAndPasswordActivity;

public class MainActivity extends AppCompatActivity {

    private TextView registration;
    private TextView signIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registration = findViewById(R.id.reg);
        signIn = findViewById(R.id.log);

        registration.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, EmailAndPasswordActivity.class)));
    }
}
