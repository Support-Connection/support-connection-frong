package com.river.supportconnection.data.api

import com.river.supportconnection.data.ConditionRequest
import com.river.supportconnection.data.Conditions
import retrofit2.Call
import retrofit2.http.*

interface ConditionService {

    @Headers(
        "Accept: application/json",
        "Content-Type: application/json;charset=UTF-8"
    )
    @PUT("/condition/")
    fun requiresCondition(
        @Body conditionRequest : ConditionRequest
    ): Call<Conditions>
}

/*

        @Field("userId") userId: Int,
        @Field("province") province: String,
        @Field("district") district: String,
        @Field("minAge") minAge: Int,
        @Field("maxAge") maxAge: Int,
        @Field("incomeGroup") incomeGroup: Int,
        @Field("annualIncome") annualIncome: Int,
        @Field("isMarried") isMarried: Int,
        @Field("haveChild") haveChild: Int,
        @Field("minChildAge") minChildAge: Int,
        @Field("maxChildAge") maxChildAge: Int,
        @Field("isPregnant") isPregnant: Int,
        @Field("occupation") occupation: Int,
        @Field("isTemporary") isTemporary: Int,
        @Field("isUnemployed") isUnemployed: Int,
        @Field("businessType") businessType: String,
        @Field("businessScale") businessScale: Int,
        @Field("annualSale") annualSale: Int,
 */
