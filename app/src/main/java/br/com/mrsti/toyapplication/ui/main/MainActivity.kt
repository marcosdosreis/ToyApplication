package br.com.mrsti.toyapplication.ui.main

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.widget.Toast
import br.com.mrsti.toyapplication.R
import br.com.mrsti.toyapplication.ui.about.AboutActivity
import br.com.mrsti.toyapplication.ui.newtoy.NewToyFragment
import br.com.mrsti.toyapplication.ui.toylist.ToyListFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_lista -> {
                changeFragment(ToyListFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_novo -> {
                changeFragment(NewToyFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_sobre -> {
                startActivity(Intent(this, AboutActivity::class.java))
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_sair -> {
                this.finish()
            }
        }
        false
    }

    fun changeFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.containerFragment, fragment)
        transaction.commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
}
