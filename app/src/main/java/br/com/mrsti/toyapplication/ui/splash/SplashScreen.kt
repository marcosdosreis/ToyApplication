package br.com.mrsti.toyapplication.ui.splash

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import br.com.mrsti.toyapplication.R
import br.com.mrsti.toyapplication.ui.login.LoginActivity
import kotlinx.android.synthetic.main.activity_splash_screen.*

class SplashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        carregar()
    }

    fun carregar() {

        val animacao = AnimationUtils.loadAnimation(this,
                R.anim.animacao_splash)
        ivLogoSplash.startAnimation(animacao)

        Handler().postDelayed({
            startActivity(Intent(this, LoginActivity::class.java))
            this.finish()
        }, 3000)

    }
}
