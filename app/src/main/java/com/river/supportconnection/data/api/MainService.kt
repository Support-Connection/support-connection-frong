package com.river.supportconnection.data.api

import com.river.supportconnection.data.Main
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface MainService {
    @GET("/user/{id}")
    @Headers(
        "Accept: application/json",
        "Content-Type: application/json;charset=UTF-8"
    )
    fun getMain(@Path("id") id: Int): Call<Main>
}