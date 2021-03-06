package com.example.sopt_android_27.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sopt_android_27.R
import com.example.sopt_android_27.fragment.FirstFragment
import com.example.sopt_android_27.fragment.SecondFragment
import kotlinx.android.synthetic.main.activity_transaction.*

class TransactionActivity : AppCompatActivity() {
    var code = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transaction)

        val fragment1 = FirstFragment()
        val fragment2 = SecondFragment()

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, fragment1).commit()

        button_change.setOnClickListener {
            val transAction = supportFragmentManager.beginTransaction()
            when(code) {
                1 -> {
                    transAction.replace(R.id.fragment_container, fragment2)
                    code = 2
                }
                2 -> {
                    transAction.replace(R.id.fragment_container, fragment1)
                    code = 1
                }
            }
            transAction.commit()
        }
    }
}