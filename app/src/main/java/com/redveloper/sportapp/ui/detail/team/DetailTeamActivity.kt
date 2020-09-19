package com.redveloper.sportapp.ui.detail.team

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.redveloper.sportapp.R
import com.redveloper.sportapp.domain.model.Team
import kotlinx.android.synthetic.main.activity_detail_team.*
import kotlinx.android.synthetic.main.content_detail_team.*

class DetailTeamActivity : AppCompatActivity() {

    companion object {
        const val EXTRAS = "EXTRAS"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_team)
        setSupportActionBar(findViewById(R.id.toolbar_detail_team))

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
    }
}