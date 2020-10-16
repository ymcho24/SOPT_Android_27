package com.example.sopt_android_27

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        button_sign_up.setOnClickListener {
            if (edittext_name.text.toString().isNotEmpty() && edittext_id.text.toString().isNotEmpty()
                && edittext_pwd.text.toString().isNotEmpty()) {
                Toast.makeText(this, "회원가입이 완료되었습니다", Toast.LENGTH_SHORT).show()

                val id = edittext_id.text.toString()
                val pwd = edittext_pwd.text.toString()

                val intent = Intent(this, LoginActivity::class.java)
                intent.putExtra("id", id)
                intent.putExtra("pwd", pwd)
                setResult(Activity.RESULT_OK, intent)

                finish()
            }
            else {
                Toast.makeText(this, "빈 칸을 채워주세요", Toast.LENGTH_SHORT).show()
            }
        }
    }
}