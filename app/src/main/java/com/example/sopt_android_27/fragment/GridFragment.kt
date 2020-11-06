package com.example.sopt_android_27.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.sopt_android_27.R
import com.example.sopt_android_27.recyclerview.GridAdapter
import com.example.sopt_android_27.recyclerview.ProfileData
import kotlinx.android.synthetic.main.fragment_grid.*

class GridFragment : Fragment() {
    private lateinit var gridAdapter : GridAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_grid, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        gridAdapter = GridAdapter(context!!)

        main_recycler_grid.adapter = gridAdapter
        main_recycler_grid.layoutManager = GridLayoutManager(context!!, 3)

        gridAdapter.data = mutableListOf(
            ProfileData("이름", "강희원"),
            ProfileData("나이", "22"),
            ProfileData("파트", "안드로이드"),
            ProfileData(
                "학교",
                "숙명여자대학교"
            ),
            ProfileData("전공", "컴퓨터과학")
        )
        gridAdapter.notifyDataSetChanged()

    }
}