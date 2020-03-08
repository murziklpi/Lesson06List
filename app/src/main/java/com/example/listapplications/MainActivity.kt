package com.example.listapplications

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
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
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = NewsAdapter(LayoutInflater.from(this), items)
            //DividerItemDecoration
        val itemDecor=CustomItemDecoration(this, DividerItemDecoration.VERTICAL)
        recyclerView.addItemDecoration(itemDecor)

        findViewById<View>(R.id.addBtn).setOnClickListener() {
            items.add(2, NewsItem("new item", "---", Color.MAGENTA))
            recyclerView.adapter?.notifyItemInserted(2)
            //  recyclerView.adapter?.notifyItemInserted(1) //many binds
        }

        findViewById<View>(R.id.removeBtn).setOnClickListener() {
            items.removeAt(2)
            //recyclerView.adapter?.notifyItemRemoved(2) //many binds
            recyclerView.adapter?.notifyItemRemoved(2)
        }

        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                //findLastVisibleItemPosition
                Log.d("onScrolled", "text beforeInsert  size=${items.size}")
                if ((recyclerView.layoutManager as LinearLayoutManager).findLastCompletelyVisibleItemPosition() == items.size - 1) {
                    Runnable {
                    items.add(NewsItem("Pagination new item1", "****", Color.GREEN))
                    items.add(NewsItem("Pagination new item2", "****", Color.GRAY))
                    items.add(NewsItem("Pagination new item3", "****", Color.MAGENTA))
                    Log.d("onScrolled", "text beforeError  size=${items.size}")
                    recyclerView.adapter?.notifyItemRangeInserted(items.size - 1, items.size - 4)
                    }
                }
            }
        })
    }
    class CustomItemDecoration(context: Context, orientation: Int): DividerItemDecoration(context, orientation) {
        override fun onDrawOver(c: Canvas, parent: RecyclerView, state: State) {
            super.onDrawOver(c, parent, state)
        }

        override fun onDraw(c: Canvas, parent: RecyclerView, state: State) {
            super.onDraw(c, parent, state)
        }

        override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: State) {
            super.getItemOffsets(outRect, view, parent, state)
        }

    }
}
