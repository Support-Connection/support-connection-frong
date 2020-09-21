package com.river.supportconnection.data

data class Search(
    var supportId:Int,
    var name:String,
    var category: String,
    var site:String,
    var isLocal:Int,
    var type:String,
    var amount: Int
)
