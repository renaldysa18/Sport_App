package com.redveloper.sportapp.about

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.redveloper.sportapp.about.di.aboutModule
import kotlinx.android.synthetic.main.activity_about.*
import org.koin.android.ext.android.inject
import org.koin.core.context.loadKoinModules

class AboutActivity : AppCompatActivity() {

    val viewModel : AboutViewModel by inject()
    private lateinit var aboutAdapter: AboutAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        aboutAdapter = AboutAdapter()

        loadKoinModules(aboutModule)

        with(rv_about_favorit_team){
            layoutManager = LinearLayoutManager(this@AboutActivity, RecyclerView.HORIZONTAL, false)
            adapter = aboutAdapter
        }

        viewModel.favorit.observe(this, Observer { data ->
            if (data != null){
                val count = data.size
                tv_count_favorit.text = "Kamu memfavoritkan $count team"

                aboutAdapter.setItems(data)
                aboutAdapter.notifyDataSetChanged()

            }
        })
    }
}