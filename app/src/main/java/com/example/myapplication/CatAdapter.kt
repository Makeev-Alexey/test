package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CatAdapter (private var listCat : List<Cat>) : RecyclerView.Adapter<CatViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.layout_cat, parent, false)
        var viewHolder = CatViewHolder(view)
        return viewHolder
    }

    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        var cat : Cat = listCat[position]
        holder.name.text = cat.name
        holder.age.text = cat.age.toString()
    }

    override fun getItemCount(): Int {
        return listCat.size
    }
}

class CatViewHolder (view: View) : RecyclerView.ViewHolder(view){
    lateinit var name : TextView
    lateinit var age : TextView
    init {
        name = view.findViewById(R.id.name)
        age = view.findViewById(R.id.age)
    }
}