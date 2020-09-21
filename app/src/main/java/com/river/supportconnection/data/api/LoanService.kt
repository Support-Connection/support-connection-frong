package com.river.supportconnection.data.api

import com.river.supportconnection.data.Loan
import com.river.supportconnection.data.LoanRequest
import retrofit2.Call
import retrofit2.http.*

interface LoanService {

    @Headers(
        "Accept: application/json",
        "Content-Type: application/json;charset=UTF-8"
    )
    @POST("/me/loan")
    fun requestLoan(
        @Body loanRequest : LoanRequest
    ): Call<Loan>
}