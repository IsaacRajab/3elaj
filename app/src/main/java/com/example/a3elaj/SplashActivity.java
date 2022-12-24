package com.example.a3elaj;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

@SuppressLint("CustomSplashScreen")
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Load the splash screen animation
        Animation splashAnimation = AnimationUtils.loadAnimation(this, R.anim.loginanim);

        // Start the animation
        ImageView splashImage = findViewById(R.id.splash_image);
        splashImage.startAnimation(splashAnimation);

        // Delay for 5 seconds before starting the next activity
        new Handler().postDelayed(() -> {
            // Start the next activity
            Intent intent = new Intent(SplashActivity.this, home.class);
            startActivity(intent);
            finish();
        }, 5000); // Delay for 5 seconds (5000 milliseconds)
    }
}