package com.example.jsonparsing.Model

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("name")
    val mName: String,
    @SerializedName("age")
    val mAge: String,
    @SerializedName("address")
    val mAddress: Address
)
