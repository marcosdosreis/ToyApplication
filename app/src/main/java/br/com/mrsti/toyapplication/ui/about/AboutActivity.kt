package br.com.mrsti.toyapplication.ui.about

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import br.com.mrsti.toyapplication.R

class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
    }

    fun fechar (view: View) {
        this.finish()
    }
}
