package com.river.supportconnection

data class Condition(
    val userId: Int,
    val province : String,
    val district : String,
    val minAge : Int,
    val maxAge : Int,
    val incomeGroup : Int,
    val annualIncome : Int,
    val isMarried : Int,
    val haveChild : Int,
    val minChildAge : Int,
    val maxChildAge : Int,
    val isPregnant :Int,
    val occupation : Int,
    val isTemporary : Int,
    var isUnemployed : Int,
    var businessType : String,
    var businessScale : Int,
    val annualSale : Int
)

