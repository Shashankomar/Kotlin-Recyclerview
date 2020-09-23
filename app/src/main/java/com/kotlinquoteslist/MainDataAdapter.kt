package com.example.kotlinquoteslist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainDataAdapter(private val context: Context, private val data: List<MainDataModel>) :
    RecyclerView.Adapter<MainDataAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.list_item_home, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return data.size

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.mTvItem.text = data.get(index = position).title
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var mTvItem: TextView = itemView.findViewById(R.id.tv_item)
    }
}
