package com.example.sopt_android_27.activity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.sopt_android_27.R
import com.example.sopt_android_27.network.RequestLoginData
import com.example.sopt_android_27.network.ResponseLoginData
import com.example.sopt_android_27.network.SoptServiceImpl
import kotlinx.android.synthetic.main.activity_login.*
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        button_login.setOnClickListener {
            val email = editText_id.text.toString()
            val password = editText_pwd.text.toString()

            //서버 통신
            val call : Call<ResponseLoginData> = SoptServiceImpl.service.postLogin(
                RequestLoginData(email = email, password = password)
            )
            call.enqueue(object : Callback<ResponseLoginData> {
                override fun onFailure(call: Call<ResponseLoginData>, t: Throwable) {
                    //통신 실패 로직
                    Log.d("login fail", "통신실패")
                }

                override fun onResponse(
                    call: Call<ResponseLoginData>,
                    response: Response<ResponseLoginData>
                ) {
                    response.takeIf { it.isSuccessful }
                        ?.body()
                        ?.let { it ->
                            it.data.let{ data ->
                                if (editText_id.text.isNotEmpty() && editText_pwd.text.isNotEmpty()) {
                                    Toast.makeText(this@LoginActivity, "${data.userName}님, 안녕하세요",
                                        Toast.LENGTH_SHORT).show()

                                    val intent = Intent(this@LoginActivity, MainActivity::class.java)
                                    startActivity(intent)
                                }
                            }
                        } ?: showError(response.errorBody())
                }

            })
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

    private fun showError(error : ResponseBody?) {
        val e = error ?: return
        val ob = JSONObject(e.string())
        Toast.makeText(this, ob.getString("message"), Toast.LENGTH_SHORT).show()
    }
}