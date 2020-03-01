package com.example.listapplications

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.*

class MainActivity : AppCompatActivity() {

    val items = arrayListOf<NewsItem>(
        NewsItem("Заголовок1", "подзаголовок 1", Color.RED),
        NewsItem("Заголовок2", "подзаголовок 2", Color.BLUE),
        NewsItem("Заголовок3", "подзаголовок 3", Color.GREEN)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecycler()
    }

    fun initRecycler() {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.layoutManager=layoutManager
        recyclerView.adapter = NewsAdapter(LayoutInflater.from(this), items)
    }
}
