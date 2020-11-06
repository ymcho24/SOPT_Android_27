package com.example.sopt_android_27.fragment

import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.OvalShape
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import com.example.sopt_android_27.R
import com.example.sopt_android_27.adapter.SampleViewPagerAdapter
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment() {
    private lateinit var viewPagerAdapter : SampleViewPagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //프로필 이미지 동그랗게 라운딩
        imageView_profile.background = ShapeDrawable(OvalShape())
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            imageView_profile.clipToOutline = true
        }

        //어댑터
        //중첩 프래그먼트 -> childFragmentManager 사용
        viewPagerAdapter = SampleViewPagerAdapter(childFragmentManager)
        viewPagerAdapter.fragments = listOf(
            FirstFragment(),
            SecondFragment()
        )

        viewpager_profile.adapter = viewPagerAdapter

        //TapLayout과 연동
        tab_sample.setupWithViewPager(viewpager_profile)

        tab_sample.apply {
            getTabAt(0)?.text = "INFO"
            getTabAt(1)?.text = "OTHER"
        }

    }

}