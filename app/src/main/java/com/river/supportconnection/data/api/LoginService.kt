package com.river.supportconnection.data.api

import com.river.supportconnection.data.LoginRequest
import retrofit2.Call
import retrofit2.http.*

interface LoginService {

    @Headers(
        "Accept: application/json",
        "Content-Type: application/json;charset=UTF-8"
    )
    @POST("/user/login/")
    fun requestLogin(
        @Body loginRequest : LoginRequest
    ): Call<Int>
}