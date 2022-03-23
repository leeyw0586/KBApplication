package com.ywlee.kbapplication.ui.adapter

import android.content.Context
import android.util.Log
import android.view.View
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ywlee.kbapplication.R
import com.ywlee.kbapplication.data.ImageModel


class SearchViewHolder(private val context: Context, itemView: View) :
    RecyclerView.ViewHolder(itemView) {

    private val title: TextView = itemView.findViewById(R.id.date)
    private val image: ImageView = itemView.findViewById(R.id.thumbnailImage)
    private val isSaved: CheckBox = itemView.findViewById(R.id.isSaved)

    fun bind(item: ImageModel.Image) {

        // databinding으로 하는게 좋을듯?
        Log.e("asdf", item.thumbnailUrl)

        Glide.with(itemView).load(item.thumbnailUrl).into(image)
        title.text = item.dateTime

        isSaved.setOnClickListener {
            when (it.isSelected) {
                true -> Toast.makeText(context, "삭제됨", Toast.LENGTH_SHORT).show()
                else -> Toast.makeText(context, "저장 완료", Toast.LENGTH_SHORT).show()
            }

            it.isSelected = !it.isSelected

        }
    }
}