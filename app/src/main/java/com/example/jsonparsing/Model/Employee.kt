package com.example.jsonparsing.Model

import com.google.gson.annotations.SerializedName

data class Employee(
    @SerializedName("employee_name")
    val mName: String,
    @SerializedName("employee_age")
    val mAge: String,
    @SerializedName("employee_email")
    val mEmail: String
)