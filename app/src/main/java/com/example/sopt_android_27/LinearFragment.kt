package com.example.sopt_android_27

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sopt_android_27.recyclerview.ProfileAdapter
import com.example.sopt_android_27.recyclerview.ProfileData
import kotlinx.android.synthetic.main.fragment_linear.*

class LinearFragment : Fragment() {
    private lateinit var profileAdapter : ProfileAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_linear, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        profileAdapter = ProfileAdapter(context!!)

        main_recycler.adapter = profileAdapter
        main_recycler.layoutManager = LinearLayoutManager(context!!)

        profileAdapter.data = mutableListOf(
            ProfileData("이름", "강희원"),
            ProfileData("나이", "22"),
            ProfileData("파트", "안드로이드"),
            ProfileData(
                "학교",
                "숙명여자대학교"
            ),
            ProfileData("전공", "컴퓨터과학")
        )
        profileAdapter.notifyDataSetChanged()

    }
}