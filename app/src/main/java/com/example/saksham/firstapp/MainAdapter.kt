package com.example.saksham.firstapp

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.row.view.*


/*
 * Created by saksham on 23/June/2018
*/

class MainAdapter(var context : Context, var list : List<Row>) : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        var layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        return MainViewHolder(layoutInflater.inflate(R.layout.row, parent, false))
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.itemView.tvId.text = list[position].id
        holder.itemView.tvText.text = list[position].text
    }

    class MainViewHolder(view : View) : RecyclerView.ViewHolder(view)
}

