package com.example.jsonparsing.Model

import com.google.gson.annotations.SerializedName

data class Address(
    @SerializedName("city")
    val mCity: String,
    @SerializedName("country")
    val mCountry: String
)