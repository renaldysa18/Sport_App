package com.redveloper.sportapp.about

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.redveloper.sportapp.about.di.aboutModule
import com.redveloper.sportapp.core.vo.Resource
import kotlinx.android.synthetic.main.activity_about.*
import org.koin.android.ext.android.inject
import org.koin.core.context.loadKoinModules

class AboutActivity : AppCompatActivity() {

    val viewModel : AboutViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        loadKoinModules(aboutModule)

        viewModel.favorit.observe(this, Observer { data ->
            if (data != null){
                val count = data.size
                tv_count_favorit.text = "Kamu memfavoritkan $count team"
            }
        })
    }
}