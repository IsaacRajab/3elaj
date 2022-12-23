package com.example.a3elaj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button logIN;
    Button regis;
//    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        regis = findViewById(R.id.reg);
        regis.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, reg.class);
            startActivity(intent);
            finish();

        });
//        // Get data from file: userSRF --> (username,password)
//        sharedPreferences = getSharedPreferences("userSRF", MODE_PRIVATE);
//        String username = sharedPreferences.getString("username", null);
//        String password = sharedPreferences.getString("password", null);
//        if (username !=null && password !=null) {
//            String name = sharedPreferences.getString("username", "no user");
//            String pass = sharedPreferences.getString("password", "no pass");
//            if(name.equals("project@project.com")&& pass.equals("12345")) {
//                Intent i = new Intent(MainActivity.this, home.class);
//                startActivity(i);
//                finish();
//            }
        logIN = findViewById(R.id.login);
        logIN.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, login.class);
            startActivity(intent);

        });

    }
}
