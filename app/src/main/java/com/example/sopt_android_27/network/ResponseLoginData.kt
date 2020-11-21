package com.example.sopt_android_27.network

data class ResponseLoginData (
    val status: Int,
    val success: Boolean,
    val message: String,
    val data: Data
) {
    data class Data(
        val email: String,
        val password: String,
        val userName: String
    )
}