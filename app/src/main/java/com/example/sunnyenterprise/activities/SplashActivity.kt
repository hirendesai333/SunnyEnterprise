package com.example.sunnyenterprise.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.preference.PreferenceManager
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.example.sunnyenterprise.R

class SplashActivity : AppCompatActivity() {
    var SPLASH_TIME = 3000
    override fun onCreate(savedInstanceState: Bundle?) {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val prefs = PreferenceManager.getDefaultSharedPreferences(this)
        val Islogin = prefs.getBoolean("Islogin", false)
        if (Islogin) {
            val i = Intent(this@SplashActivity, HomeActivity::class.java)
            startActivityForResult(i, 1)
        } else {
            Handler().postDelayed({
                val loginIntent = Intent(this@SplashActivity, LoginActivity::class.java)
                startActivity(loginIntent)
                finish()
            }, SPLASH_TIME.toLong())
        }
    }
}