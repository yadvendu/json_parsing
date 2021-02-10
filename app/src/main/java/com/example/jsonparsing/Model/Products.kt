package com.example.jsonparsing.Model

import com.google.gson.annotations.SerializedName

data class Products(
    @SerializedName("productId")
    val mProductId: String,
    @SerializedName("productName")
    val mProductName: String
)