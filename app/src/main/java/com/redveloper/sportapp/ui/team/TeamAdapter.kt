package com.redveloper.sportapp.ui.team

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.redveloper.sportapp.R
import com.redveloper.sportapp.domain.model.Team
import kotlinx.android.synthetic.main.layout_item_team.view.*

class TeamAdapter : RecyclerView.Adapter<TeamAdapter.ViewHolder>(){

    private val items : ArrayList<Team> = ArrayList()

    fun setItemTeam(data : List<Team>?){
        if (data.isNullOrEmpty()) return
        items.clear()
        items.addAll(data)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_item_team, parent, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(items.get(position))
    }

    class ViewHolder(itemView: View)  : RecyclerView.ViewHolder(itemView){
        fun bindData(data : Team){
            with(itemView){
                Glide.with(context)
                    .load(data.stadiumThumb)
                    .into(img_stadium_item_team)
                Glide.with(context)
                    .load(data.teamBadge)
                    .into(img_logo_item_team)
                tv_title_item_team.setText(data.name)
                tv_location_item_team.setText(data.stadiumLocation)
                tv_stadium_item_team.setText(data.stadiumLocation)
            }
        }
    }
}