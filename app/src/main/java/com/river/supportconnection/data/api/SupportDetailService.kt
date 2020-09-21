package com.river.supportconnection.data.api

import com.river.supportconnection.data.SupportDetail
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface SupportDetailService {
    @GET("/apply/supports/{id}")
    @Headers(
        "Accept: application/json",
        "Content-Type: application/json;charset=UTF-8"
    )
    fun getSupport(@Path("id") id: Int): Call<SupportDetail>
}