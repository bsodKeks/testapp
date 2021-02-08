package com.als.myapplication.data.network.dto

import com.google.gson.annotations.SerializedName


data class GetData (

    @SerializedName("response") val response : List<Response>
)