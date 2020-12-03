package com.example.sopt_android_27.activity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.sopt_android_27.R
import com.example.sopt_android_27.network.RequestSignupData
import com.example.sopt_android_27.network.ResponseSignupData
import com.example.sopt_android_27.network.SoptServiceImpl
import kotlinx.android.synthetic.main.activity_sign_up.*
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        button_sign_up.setOnClickListener {
            val name = edittext_name.text.toString()
            val id = edittext_id.text.toString()
            val pwd = edittext_pwd.text.toString()

            //서버 통신
            val call : Call<ResponseSignupData> = SoptServiceImpl.service.postSignup(
                RequestSignupData(email = id, password = pwd, userName = name)
            )
            call.enqueue(object : Callback<ResponseSignupData> {
                override fun onFailure(call: Call<ResponseSignupData>, t: Throwable) {
                    Log.d("signup fail", "통신실패")
                }

                override fun onResponse(
                    call: Call<ResponseSignupData>,
                    response: Response<ResponseSignupData>
                ) {
                    response.takeIf { it.isSuccessful }
                        ?.body()
                        ?.let {
                            if (name.isNotEmpty() && id.isNotEmpty() && pwd.isNotEmpty()) {
                                Toast.makeText(this@SignUpActivity, "회원가입이 완료되었습니다", Toast.LENGTH_SHORT).show()

                                val intent = Intent(this@SignUpActivity, LoginActivity::class.java)
                                intent.putExtra("id", id)
                                intent.putExtra("pwd", pwd)
                                setResult(Activity.RESULT_OK, intent)

                                finish()
                            }
                            else {
                                Toast.makeText(this@SignUpActivity, "빈 칸을 채워주세요", Toast.LENGTH_SHORT).show()
                            }
                        } ?: showError(response.errorBody())
                }

            })

        }
    }

    private fun showError(error : ResponseBody?) {
        val e = error ?: return
        val ob = JSONObject(e.string())
        Toast.makeText(this, ob.getString("message"), Toast.LENGTH_SHORT).show()
    }
}