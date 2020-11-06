package com.example.sopt_android_27.activity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sopt_android_27.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        button_login.setOnClickListener {
            if (editText_id.text.isNotEmpty() && editText_pwd.text.isNotEmpty()) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }

        textview_sign_up.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivityForResult(intent, 1);
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == 1) {
                editText_id.setText(data!!.getStringExtra("id"))
                editText_pwd.setText(data!!.getStringExtra("pwd"))
            }
        }
    }
}