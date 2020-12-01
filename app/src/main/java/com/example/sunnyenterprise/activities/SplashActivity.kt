package com.example.sunnyenterprise.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.preference.PreferenceManager
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.example.sunnyenterprise.R
import com.example.sunnyenterprise.utils.Preferences

@Suppress("DEPRECATION")
class SplashActivity : AppCompatActivity() {
    var preferences: Preferences? = null

    var SPLASH_TIME = 3000
    override fun onCreate(savedInstanceState: Bundle?) {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
//        val prefs = PreferenceManager.getDefaultSharedPreferences(this)

        preferences = Preferences(this)

//        val Islogin = prefs.getBoolean("Islogin", false)
        if (preferences!!.getMobile().isEmpty()) {
            Handler().postDelayed({
                val loginIntent = Intent(this@SplashActivity, LoginActivity::class.java)
                startActivity(loginIntent)
                finish()
            }, SPLASH_TIME.toLong())
        } else {
            val i = Intent(this@SplashActivity, HomeActivity::class.java)
            startActivityForResult(i, 1)
        }
    }
}