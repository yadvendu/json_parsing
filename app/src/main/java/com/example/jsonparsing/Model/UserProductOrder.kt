package com.example.jsonparsing.Model

import com.google.gson.annotations.SerializedName

data class UserProductOrder(
    @SerializedName("name")
    val mName: String,
    @SerializedName("address")
    val mAddress: Address,
    @SerializedName("products")
    val mProducts: List<Products>
)