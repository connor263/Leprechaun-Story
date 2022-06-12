package com.miniclip.car

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.animation.doOnEnd

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val comminiclipcarg = findViewById<ImageView>(R.id.iv_bg)
        val tvcomminiclipcar = findViewById<TextView>(R.id.tv_name)

        val bcomminiclipcarimator = ObjectAnimator.ofFloat(comminiclipcarg, View.ALPHA, 1F, 0.3F).apply {
            duration = 1500
        }

        val tvAcomminiclipcartor = ObjectAnimator.ofFloat(tvcomminiclipcar, View.ALPHA, 0F, 1F).apply {
            duration = 1500
        }

        AnimatorSet().apply {
            play(bcomminiclipcarimator)
                .with(
                    tvAcomminiclipcartor
                )
            doOnEnd {
                navigatcomminiclipcarctivity()
            }
            start()
        }
    }

    private fun navigatcomminiclipcarctivity() {
        Intent(this, MainActivity::class.java).run {
            startActivity(this)
            finish()
        }
    }
}