package com.redveloper.sportapp.ui.detail.team

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.redveloper.sportapp.R
import com.redveloper.sportapp.domain.model.Team
import com.redveloper.sportapp.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.activity_detail_team.*
import kotlinx.android.synthetic.main.content_detail_team.*

class DetailTeamActivity : AppCompatActivity() {

    companion object {
        const val EXTRAS = "EXTRAS"
    }

    private lateinit var viewModel: DetailTeamViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_team)
        setSupportActionBar(findViewById(R.id.toolbar_detail_team))

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory)[DetailTeamViewModel::class.java]

        val bundle = intent.getParcelableExtra<Team>(EXTRAS)
        if (bundle != null) {
            showDataDetailTeam(bundle)
        }
    }

    private fun showDataDetailTeam(data: Team) {
        Glide.with(this)
            .load(data.imageFanArt)
            .into(img_fanart_detail_team)

        Glide.with(this)
            .load(data.teamBadge)
            .into(img_logo_detail_team)

        toolbar_layout_detail_team.title = data.name
        tv_name_detail_team.text = data.name
        tv_altName_detail_team.text = data.nameAlt
        tv_stadium_deatil_team.text = data.stadiumLocation
        tv_league_detail_team.text = data.league
        tv_desc_detail_team.text = data.description

        var statusFavorite = data.isFavorite
        setStatusFavorite(statusFavorite)
        fab_detail_team.setOnClickListener{
            statusFavorite = !statusFavorite
            viewModel.setFavoriteTeam(data, statusFavorite)
            setStatusFavorite(statusFavorite)
        }
    }

    private fun setStatusFavorite(state : Boolean){
        if (state){
            fab_detail_team.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_favorite))
        } else {
            fab_detail_team.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_not_favorite))
        }
    }
}