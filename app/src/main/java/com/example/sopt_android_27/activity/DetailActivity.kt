package com.example.sopt_android_27.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sopt_android_27.R
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val title = intent.getStringExtra("title")
        val subTitle = intent.getStringExtra("subTitle")

        textView_title.text = title
        textView_subTitle.text = subTitle
    }
}