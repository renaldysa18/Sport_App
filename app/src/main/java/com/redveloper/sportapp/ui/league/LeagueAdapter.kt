package com.redveloper.sportapp.ui.league

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.redveloper.sportapp.R
import com.redveloper.sportapp.domain.model.League
import kotlinx.android.synthetic.main.layout_item_league.view.*

class LeagueAdapter : RecyclerView.Adapter<LeagueAdapter.ViewHolder>(){

    private var items : ArrayList<League> = ArrayList()

    fun setDataLeague(datas : List<League>?){
        if (datas.isNullOrEmpty()) return
        items.clear()
        items.addAll(datas)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_item_league, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(items.get(position))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bindData(data : League){
            with(itemView){
                Glide.with(context)
                    .load(data.logo)
                    .into(img_item_league)
                tv_name_item_league.text = data.name
                tv_gender_item_league.text = data.gender
            }
        }
    }
}