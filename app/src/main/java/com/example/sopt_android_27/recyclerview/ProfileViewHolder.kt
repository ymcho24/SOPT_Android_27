package com.example.sopt_android_27.recyclerview

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sopt_android_27.R

class ProfileViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
    private val title : TextView = itemView.findViewById(R.id.item_title)
    private val subTitle : TextView = itemView.findViewById(R.id.item_subtitle)

    fun onBind(data : ProfileData) {
        title.text = data.title
        subTitle.text = data.subTitle
    }
}