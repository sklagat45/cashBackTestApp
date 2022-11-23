package com.sklagat46.cashbacktestapp.ui

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.widget.Toast
import com.sklagat46.cashbacktestapp.R
import com.sklagat46.cashbacktestapp.utils.Constants
import timber.log.Timber

@SuppressLint("CustomSplashScreen")
@Suppress("DEPRECATION")
class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        Handler().postDelayed(
            {
                    startActivity(Intent(this@SplashScreen, MainActivity::class.java))
                    finish()
            },
            Constants.SPLASH_SLEEP_TIME
        )
    }


}