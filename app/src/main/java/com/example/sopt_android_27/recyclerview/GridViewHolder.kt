package com.example.sopt_android_27.recyclerview

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sopt_android_27.R

class GridViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView) {
    private val title : TextView = itemView.findViewById(R.id.textView_title_grid)
    private val subTitle : TextView = itemView.findViewById(R.id.textView_subTitle_grid)

    fun onBind(data : ProfileData) {
        title.text = data.title
        subTitle.text = data.subTitle
    }
}