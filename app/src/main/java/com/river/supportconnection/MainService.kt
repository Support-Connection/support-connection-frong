package com.river.supportconnection

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Path

interface MainService {
    @GET("/user/{userId}")
    @Headers(
        "Accept: application/json",
        "Content-Type: application/json;charset=UTF-8"
    )
    fun getMain(@Path("userId") userId: Int): Call<Main>
}