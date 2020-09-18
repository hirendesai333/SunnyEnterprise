package com.example.sunnyenterprise.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.sunnyenterprise.R;

public class SplashActivity extends AppCompatActivity {

    int SPLASH_TIME = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        boolean Islogin = prefs.getBoolean("Islogin", false);

        if(Islogin){
            Intent i = new Intent(SplashActivity.this, HomeActivity.class);
            startActivityForResult(i, 1);
        }

        else{
            new Handler().postDelayed(() -> {
                Intent loginIntent = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(loginIntent);
                finish();

            }, SPLASH_TIME);
        }



    }
}