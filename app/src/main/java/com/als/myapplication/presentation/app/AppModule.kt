package com.als.myapplication.presentation.app

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val baseApp: App) {
    @Provides
    @Singleton
    fun provideContext(): Context = baseApp
}