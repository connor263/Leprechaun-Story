package com.miniclip.car

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.animation.doOnEnd

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val ivBg = findViewById<ImageView>(R.id.iv_bg)
        val tvName = findViewById<TextView>(R.id.tv_name)

        val bgAnimator = ObjectAnimator.ofFloat(ivBg, View.ALPHA, 1F, 0.3F).apply {
            duration = 1500
        }

        val tvAnimator = ObjectAnimator.ofFloat(tvName, View.ALPHA, 0F, 1F).apply {
            duration = 1500
        }

        AnimatorSet().apply {
            play(bgAnimator)
                .with(
                    tvAnimator
                )
            doOnEnd {
                navigateToMainActivity()
            }
            start()
        }
    }

    private fun navigateToMainActivity() {
        Intent(this, MainActivity::class.java).run {
            startActivity(this)
            finish()
        }
    }
}