package com.ywlee.kbapplication.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ywlee.kbapplication.R
import com.ywlee.kbapplication.data.ImageModel

class SearchAdapter(private val context: Context) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var data = listOf<ImageModel.Image>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return SearchViewHolder(
            context,
            LayoutInflater.from(context).inflate(R.layout.item_image, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as SearchViewHolder).bind(data[position] as ImageModel.Image)
    }

    override fun getItemCount(): Int {
        return data.size
    }

}