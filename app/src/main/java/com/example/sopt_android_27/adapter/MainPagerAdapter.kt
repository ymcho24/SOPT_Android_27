package com.example.sopt_android_27.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.sopt_android_27.fragment.GridFragment
import com.example.sopt_android_27.fragment.LinearFragment

class MainPagerAdapter (fm : FragmentManager) : FragmentPagerAdapter(fm,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getItem(position: Int): Fragment {
        return when(position) {
            0 -> LinearFragment()
            else -> GridFragment()
        }
    }

    override fun getCount() = 2
}