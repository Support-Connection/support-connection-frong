package com.river.supportconnection

import retrofit2.Call
import retrofit2.http.*

interface LoginService {

    @FormUrlEncoded
    @Headers(
        "Accept: application/json",
        "Content-Type: application/json;charset=UTF-8"
    )
    @PUT("/user/login")
    fun requestLogin(
        @Field("name") name: String,
        @Field("agency") agency: String,
        @Field("phoneNumber") phoneNumber: String,
        @Field("age") age: Int
    ): Call<Login>
}