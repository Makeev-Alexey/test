package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var view = setContentView(R.layout.activity_main)
        var list : MutableList<Cat> = mutableListOf<Cat>(Cat("barsik", 10), Cat("murzik", 10), Cat("bar", 10), Cat("bars", 10))
        var recyclerview = findViewById<RecyclerView>(R.id.recyclerview)
        var catAdapter = CatAdapter(list, this)
        if (recyclerview != null) {
            recyclerview.adapter = catAdapter
        }
        if (recyclerview != null) {
            recyclerview.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        }
        var searchView = findViewById<SearchView>(R.id.searchView)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
               return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                catAdapter?.filter?.filter(newText)
                return true
            }

        })
        return view
    }
}