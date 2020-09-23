package com.redveloper.sportapp.about

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.redveloper.sportapp.core.domain.model.Team
import kotlinx.android.synthetic.main.layout_item_favorit.view.*

class AboutAdapter : RecyclerView.Adapter<AboutAdapter.ViewHolder>(){
    private var items : ArrayList<Team> = ArrayList()
    private lateinit var listener : AboutAdapterImpl

    fun setItems(datas : List<Team>?){
        if (datas == null) return
        items.clear()
        items.addAll(datas)
        notifyDataSetChanged()
    }

    fun setListener(listener : AboutAdapterImpl?){
        if (listener == null) return
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_item_favorit, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(items.get(position), listener)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bindData(data : Team, listener : AboutAdapterImpl){
            with(itemView){
                Glide.with(context)
                    .load(data.teamBadge)
                    .into(imgv_item_favorit_team_about)
                setOnClickListener {
                    listener.onTeamClick(data)
                }
            }
        }
    }

    interface AboutAdapterImpl {
        fun onTeamClick(data : Team)
    }
}