package com.example.listapplications

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NewsViewHolder(itemItem: View): RecyclerView.ViewHolder(itemItem){
    val titleTv: TextView = itemItem.findViewById(R.id.titleTv)
    val subTitleTv: TextView = itemItem.findViewById(R.id.subTitleTv)
    val imageIv: ImageView =itemItem.findViewById(R.id.imgIv)

    fun bind(item: NewsItem) {
        titleTv.text=item.title
        subTitleTv.text=item.subTitle
        imageIv.setBackgroundColor(item.color)
    }

}