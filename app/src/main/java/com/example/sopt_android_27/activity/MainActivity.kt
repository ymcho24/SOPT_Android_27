package com.example.sopt_android_27.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.example.sopt_android_27.R
import com.example.sopt_android_27.adapter.SampleViewPagerAdapter
import com.example.sopt_android_27.fragment.GridFragment
import com.example.sopt_android_27.fragment.LinearFragment
import com.example.sopt_android_27.fragment.ProfileFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {
    private lateinit var viewPagerAdapter : SampleViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        viewPager_main.adapter = MainPagerAdapter(supportFragmentManager)
//        viewPager_main.offscreenPageLimit = 2

        viewPagerAdapter =
            SampleViewPagerAdapter(supportFragmentManager)
        viewPagerAdapter.fragments = listOf(
            ProfileFragment(),
            LinearFragment(),
            GridFragment()
        )

        viewPager_main.adapter = viewPagerAdapter

        //뷰페이저를 슬라이드 했을 때 그에 대응하는 하단 탭 변경
        viewPager_main.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {}

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {}

            override fun onPageSelected(position: Int) {
                bottomNavi_sample.menu.getItem(position).isChecked = true
            }

        })

        //하단 탭을 눌렀을 때 뷰페이저 화면 변경
        bottomNavi_sample.setOnNavigationItemSelectedListener {
            var index by Delegates.notNull<Int>()
            when(it.itemId) {
                R.id.menu_profile -> index = 0
                R.id.menu_obeject -> index = 1
                R.id.menu_pets -> index = 2
            }
            viewPager_main.currentItem = index
            true
        }
    }
}