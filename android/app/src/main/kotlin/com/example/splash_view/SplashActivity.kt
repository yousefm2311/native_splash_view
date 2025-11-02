package com.example.splash_view

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView

class SplashActivity : AppCompatActivity() {

    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val lottieView = findViewById<LottieAnimationView>(R.id.lottieLogo)
        val loadingText = findViewById<TextView>(R.id.loading_text)
        val progressBar = findViewById<ProgressBar>(R.id.progress_bar)

        // ✅ تشغيل الصوت
        mediaPlayer = MediaPlayer.create(this, R.raw.start_sound)
        mediaPlayer.start()

        // ✅ بدء أنيميشن Lottie
        lottieView.playAnimation()

        // ✅ بعد 3 ثواني يفتح التطبيق
        Handler(Looper.getMainLooper()).postDelayed({
            mediaPlayer.release()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }
}
