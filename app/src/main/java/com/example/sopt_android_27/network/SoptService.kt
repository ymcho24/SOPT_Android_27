package com.example.sopt_android_27.network

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface SoptService {
    @Headers("Content-Type:application/json")
    @POST("/users/signin")

    //서버에 로그인 요청하는 함수
    fun postLogin(
        @Body body : RequestLoginData
    ) : Call<ResponseLoginData>
}