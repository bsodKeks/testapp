package com.als.myapplication.data.network

import com.als.myapplication.data.network.dto.GetData
import io.reactivex.Single
import retrofit2.http.GET

interface ApiService {

    @GET("65gb/static/raw/master/testTask.json")
    fun getData(): Single<GetData>
}