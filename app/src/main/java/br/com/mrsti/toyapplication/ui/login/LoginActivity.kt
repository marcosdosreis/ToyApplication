package br.com.mrsti.toyapplication.ui.login

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import br.com.mrsti.toyapplication.ui.main.MainActivity
import br.com.mrsti.toyapplication.R

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    fun logar(view: View) {
        startActivity(Intent(this, MainActivity::class.java))
        this.finish()
    }
}
