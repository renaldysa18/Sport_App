package com.redveloper.sportapp.about

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.redveloper.sportapp.about.di.aboutModule
import com.redveloper.sportapp.core.domain.model.Team
import com.redveloper.sportapp.ui.detail.team.DetailTeamActivity
import kotlinx.android.synthetic.main.activity_about.*
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules

class AboutActivity : AppCompatActivity(), AboutAdapter.AboutAdapterImpl{

    val aboutViewModel : AboutViewModel by viewModel()
    private lateinit var aboutAdapter: AboutAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        aboutAdapter = AboutAdapter()
        aboutAdapter.setListener(this)

        loadKoinModules(aboutModule)

        with(rv_about_favorit_team) {
            layoutManager = LinearLayoutManager(this@AboutActivity, RecyclerView.HORIZONTAL, false)
            adapter = aboutAdapter
        }

        aboutViewModel.favorit.observe(this, Observer { data ->
            aboutAdapter.setItems(data)
            tv_count_favorit.text =
                if (data != null) "Kamu memfavoritkan ${data.size} team" else "Kamu belum memfavoritkan team"
        })
    }

    override fun onTeamClick(data: Team) {
        val intent = Intent(this, DetailTeamActivity::class.java)
        intent.putExtra(DetailTeamActivity.EXTRAS, data)
        startActivity(intent)
    }

    override fun onRestart() {
        super.onRestart()
    }
}
