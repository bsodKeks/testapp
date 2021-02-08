package com.als.myapplication.data.network

import com.als.myapplication.data.network.dto.GetData

interface ApiCallback {
    fun setData(data: GetData)
}