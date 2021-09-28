package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView


class CatAdapter (private var listCat : MutableList<Cat>, var context : Context) : RecyclerView.Adapter<CatViewHolder>() , Filterable{
    var filterList = mutableListOf<Cat>()
    init {
        filterList = listCat
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.layout_cat, parent, false)
        var viewHolder = CatViewHolder(view)
        return viewHolder
    }

    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        var cat : Cat = filterList[position]
        holder.name.text = cat.name
        holder.age.text = cat.age.toString()
        holder.constraint.setOnClickListener({
            val fragmentManager: FragmentManager =
                (context as AppCompatActivity).supportFragmentManager
            if (this.context != null)
            CustomBottomSheetDialogFragment(cat).apply {
                show(fragmentManager, CustomBottomSheetDialogFragment.TAG)
            }
        })
    }

    override fun getItemCount(): Int {
        return filterList.size
    }

    override fun getFilter(): Filter {
        return object : Filter(){
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                var search : String = constraint.toString()
                if (search.isEmpty()){
                    filterList = listCat
                }
                else{
                    var results : MutableList<Cat> = mutableListOf()
                    for(cat : Cat in listCat){
                        if (cat.name.toUpperCase().contains(search.toUpperCase())){
                            results.add(cat)
                        }
                    }
                    filterList = results
                }
                val filterResults = FilterResults()
                filterResults.values = filterList
                return filterResults
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                if (results != null) {
                    filterList = results.values as MutableList<Cat>
                }
                notifyDataSetChanged()
            }
        }
    }
}

class CatViewHolder (view: View) : RecyclerView.ViewHolder(view){
    lateinit var name : TextView
    lateinit var age : TextView
    lateinit var constraint : ConstraintLayout
    init {
        name = view.findViewById(R.id.name)
        age = view.findViewById(R.id.age)
        constraint = view.findViewById(R.id.constraintlayout)
    }
}