package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var view = setContentView(R.layout.activity_main)
        var list = mutableListOf<Cat>(Cat("barsik", 10), Cat("murzik", 10), Cat("bar", 10), Cat("bars", 10))
        var recyclerview = findViewById<RecyclerView>(R.id.recyclerview)
        var catAdapter = CatAdapter(list)
        if (recyclerview != null) {
            recyclerview.adapter = catAdapter
        }
        if (recyclerview != null) {
            recyclerview.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        }
        return view
    }
}