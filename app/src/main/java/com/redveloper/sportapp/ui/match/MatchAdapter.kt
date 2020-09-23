package com.redveloper.sportapp.ui.match

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.redveloper.sportapp.R
import com.redveloper.sportapp.core.domain.model.Match
import kotlinx.android.synthetic.main.layout_item_match.view.*

class MatchAdapter : RecyclerView.Adapter<MatchAdapter.ViewHolder>(){

    private val items : ArrayList<Match> = ArrayList()

    fun setDataItem(data : List<Match>?){
        if (data.isNullOrEmpty()) return
        items.clear()
        items.addAll(data)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_item_match, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(items.get(position))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bindData(data : Match){
            with(itemView){
                Glide.with(context)
                    .load(data.image)
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(img_item_match)
                tv_title_item_match.text = data.name
            }
        }
    }
}