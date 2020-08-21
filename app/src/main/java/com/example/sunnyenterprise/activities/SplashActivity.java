package com.example.sunnyenterprise.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.example.sunnyenterprise.R;

public class SplashActivity extends AppCompatActivity {

    int SPLASH_TIME = 2500; //This is 3 seconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        TextView welcomeText = findViewById(R.id.welcomeTextView);
        TextView companyText = findViewById(R.id.textView);
        Animation fadingIn = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fading_in);
        Animation fadingOut = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_out);

        welcomeText.startAnimation(fadingIn);
        companyText.startAnimation(fadingOut);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mySuperIntent = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(mySuperIntent);
                finish();
            }
        }, SPLASH_TIME);
    }
}