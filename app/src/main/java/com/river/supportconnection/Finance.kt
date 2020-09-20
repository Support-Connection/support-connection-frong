package com.river.supportconnection

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

data class Finance (
    val interestRate: Double,
    val creditRate: Int,
    val currentInterest: Int,
    val reduceInterest: Int,
    val annualIncome: Int,
    val myAsset: Int,
    var supports : MutableList<Support>
)
@Parcelize
data class Support (
    val supportId : Int,
    val name : String,
    var category : String,
    var rate : Double,
    var site : String,
    var isLocal : Int,
    val type : String,
    val amount : Int,
    var reduceInterest: Int
) : Parcelable