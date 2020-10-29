package com.example.sopt_android_27

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var profileAdapter : ProfileAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        profileAdapter = ProfileAdapter(this)

        main_recycler.adapter = profileAdapter
        main_recycler.layoutManager = LinearLayoutManager(this)

        profileAdapter.data = mutableListOf(
            ProfileData("이름", "강희원"),
            ProfileData("나이", "22"),
            ProfileData("파트", "안드로이드"),
            ProfileData("학교", "숙명여자대학교"),
            ProfileData("전공", "컴퓨터과학")
        )
        profileAdapter.notifyDataSetChanged()
    }
}