package com.als.myapplication.data.network

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule() {
    @Provides
    @Singleton
    internal fun provideHttpClient() = OkHttpClient.Builder().build()

    @Provides
    @Singleton
    internal fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl("https://gitlab.65apps.com/") //TODO gradle
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    internal fun provideApi(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)

}