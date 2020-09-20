package com.redveloper.sportapp.ui.favorit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.redveloper.sportapp.R
import com.redveloper.sportapp.core.domain.model.Team
import kotlinx.android.synthetic.main.layout_item_team.view.*

class FavoritAdapter : RecyclerView.Adapter<FavoritAdapter.ViewHolder>(){
    private val items : ArrayList<Team> = ArrayList()

    fun setData(datas : List<Team>?){
        if (datas.isNullOrEmpty()) return
        this.items.clear()
        this.items.addAll(datas)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_item_team, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(items.get(position))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bindData(data : Team){
            with(itemView) {
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