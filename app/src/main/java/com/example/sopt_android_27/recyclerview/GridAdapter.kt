package com.example.sopt_android_27.recyclerview

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.sopt_android_27.DetailActivity
import com.example.sopt_android_27.R

class GridAdapter(private val context : Context) : RecyclerView.Adapter<GridViewHolder>() {
    var data = listOf<ProfileData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridViewHolder {
        val view = LayoutInflater.from(context).inflate(
            R.layout.sample_item_list_grid,
            parent, false
        )

        return GridViewHolder(view)
    }

    //데이터의 총 사이즈 반환
    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        holder.onBind(data[position])

        //아이템 클릭 이벤트
        holder.itemView.setOnClickListener {

            val title = data[position].title
            val subTitle = data[position].subTitle

            val intent = Intent(holder.itemView.context, DetailActivity::class.java)
            intent.putExtra("title", title)
            intent.putExtra("subTitle", subTitle)

            ContextCompat.startActivity(holder.itemView.context, intent, null)
        }
    }
}