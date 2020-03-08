package com.example.listapplications

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class NewsAdapter(val inflater: LayoutInflater, val items: List<NewsItem>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        Log.d("NewsAdapter","onCreateViewHolder $viewType")
        if (viewType == VIEW_TYPE_ITEM) {
            return NewsViewHolder(inflater.inflate(R.layout.item_news,parent,false))
        }
        else
            return HeaderViewHolder(inflater.inflate(R.layout.item_header,parent, false))

    }

    override fun getItemCount()=items.size


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is NewsViewHolder)
         holder.bind(items[position-1])
    }

    override fun getItemViewType(position: Int): Int {
        return if (position==0)  VIEW_TYPE_HEADER else VIEW_TYPE_ITEM
    }

    companion object {
        const val VIEW_TYPE_ITEM = 0
        const val VIEW_TYPE_HEADER = 1
    }
}