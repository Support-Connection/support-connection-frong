package com.river.supportconnection.data

import android.graphics.drawable.Drawable
import android.os.Parcelable
import android.renderscript.Allocation
import kotlinx.android.parcel.Parcelize

@Parcelize
data class recyclerData (
    var supportId : Int,
   // var image: Drawable,
    var institution:String,
    var specific:String,
    var rate: Double,
    var saving: Int
) : Parcelable