package com.river.supportconnection

data class LoginRequest(
    val name : String,
    val agency : String,
    val phoneNumber : String,
    var age : Int
)