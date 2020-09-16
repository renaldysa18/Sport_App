package com.redveloper.sportapp.ui.classement

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.redveloper.sportapp.R
import com.redveloper.sportapp.domain.model.Classement
import kotlinx.android.synthetic.main.layout_item_classement.view.*

class ClassementAdapter : RecyclerView.Adapter<ClassementAdapter.ViewHolder>(){

    private val items : ArrayList<Classement> = ArrayList()

    fun setDataItem(data : List<Classement>?){
        if (data.isNullOrEmpty()) return
        items.clear()
        items.addAll(data)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_item_classement, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(items.get(position), position)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindData(data : Classement, position: Int){
            with(itemView){
                tv_number_item_classement.text = position.toString()
                tv_name_item_classement.text = data.name
                tv_played_item_classement.text = data.played.toString()
                tv_win_item_classement.text = data.win.toString()
                tv_draw_item_classement.text = data.draw.toString()
                tv_loss_item_classement.text = data.loss.toString()
                tv_total_item_classement.text = data.total.toString()
            }
        }
    }
}