package com.example.sopt_android_27.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sopt_android_27.R
import com.example.sopt_android_27.adapter.SampleViewPagerAdapter
import com.example.sopt_android_27.fragment.FirstFragment
import com.example.sopt_android_27.fragment.SecondFragment
import com.example.sopt_android_27.fragment.ThirdFragment
import kotlinx.android.synthetic.main.activity_viewpager.*

class ViewpagerActivity : AppCompatActivity() {
    private lateinit var viewPagerAdapter : SampleViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewpager)

        viewPagerAdapter =
            SampleViewPagerAdapter(
                supportFragmentManager
            )
        viewPagerAdapter.fragments = listOf(
            FirstFragment(),
            SecondFragment(),
            ThirdFragment()
        )

        viewpager_sample.adapter = viewPagerAdapter
    }
}