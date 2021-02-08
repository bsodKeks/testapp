package com.als.myapplication.data.network.dto

import com.google.gson.annotations.SerializedName

data class Speciality (

    @SerializedName("specialty_id") val specialty_id : Int,
    @SerializedName("name") val name : String
)