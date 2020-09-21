package com.river.supportconnection.data.api

import com.river.supportconnection.data.Jasan
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Headers
import retrofit2.http.POST

interface JasanService {
    @FormUrlEncoded
    @Headers(
        "Accept: application/json",
        "Content-Type: application/json;charset=UTF-8"
    )
    @POST("/me/asset")
    fun requiresAsset(
        @Field("userId") userId: Int,
        @Field("myAsset") myAsset: Int,
        @Field("annualIncome") annualIncome: Int
    ): Call<Jasan>
}