package com.redveloper.sportapp.ui.splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.redveloper.sportapp.R
import com.redveloper.sportapp.ui.league.LeagueActivity
import com.redveloper.sportapp.ui.main.MainActivity
import com.redveloper.sportapp.viewmodel.ViewModelFactory

class SplashActivity : AppCompatActivity() {

    private lateinit var viewModel: SplashViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory)[SplashViewModel::class.java]

        viewModel.league.observe(this, Observer { state ->
            if (state) {
                toMain()
            } else {
                toLeague()
            }
        })
    }

    private fun toMain() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    private fun toLeague() {
        startActivity(Intent(this, LeagueActivity::class.java))
        finish()
    }
}