package com.als.myapplication.data.network.dto

import com.google.gson.annotations.SerializedName

data class Response (

    @SerializedName("f_name") val f_name : String,
    @SerializedName("l_name") val l_name : String,
    @SerializedName("birthday") val birthday : String,
    @SerializedName("avatr_url") val avatr_url : String,
    @SerializedName("specialty") val speciality : List<Speciality>
)