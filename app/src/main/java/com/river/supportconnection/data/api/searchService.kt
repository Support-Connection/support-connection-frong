package com.river.supportconnection.data.api

import com.river.supportconnection.data.Search
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface searchService {
    @GET("/supports/:{userId}")
    @Headers(
        "Accept: application/json",
        "Content-Type: application/json;charset=UTF-8"
    )
    fun getSearch(@Path("userId") userId: Int): Call<List<Search>>
}