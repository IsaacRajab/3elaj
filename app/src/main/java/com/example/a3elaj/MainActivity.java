package com.example.a3elaj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button logIN;
    Button regis;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
        boolean rememberMe = sharedPreferences.getBoolean("rememberMe",false);
        if (rememberMe) {

            Intent i = new Intent(MainActivity.this, home.class);
            startActivity(i);
            finish();
        }

        regis = findViewById(R.id.reg);
        regis.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, reg.class);
            startActivity(intent);
            finish();

        });


        logIN = findViewById(R.id.login);
        logIN.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, login.class);
            startActivity(intent);
            finish();

        });

    }
}
