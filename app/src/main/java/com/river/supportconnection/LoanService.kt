package com.river.supportconnection

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Headers
import retrofit2.http.POST

interface LoanService {
    @FormUrlEncoded
    @Headers(
        "Accept: application/json",
        "Content-Type: application/json;charset=UTF-8"
    )
    @POST("/me/loan")
    fun requiresAsset(
        @Field("userId") userId: Int,
        @Field("loan") loan: Int,
        @Field("interestRate") interestRate: Int
    ): Call<Jasan>
}