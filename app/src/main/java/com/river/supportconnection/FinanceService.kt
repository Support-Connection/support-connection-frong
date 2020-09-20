package com.river.supportconnection

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface FinanceService {
    @GET("/finance/asset/{id}")
    @Headers(
        "Accept: application/json",
        "Content-Type: application/json;charset=UTF-8"
    )
    fun getMain(@Path("id") id: Int): Call<Finance>
}