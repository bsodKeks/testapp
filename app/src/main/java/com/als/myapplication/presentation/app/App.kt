package com.als.myapplication.presentation.app

import android.app.Application
import com.als.myapplication.data.database.DatabaseModule
import com.als.myapplication.data.network.NetworkModule
import com.als.myapplication.data.repositories.RepositoriesModule
import com.als.myapplication.domain.DomainModule
import com.als.myapplication.presentation.PresentationModule

class App : Application() {
    companion object {
        lateinit var instance: App
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        initializeDagger()
        instance = this
    }

    private fun initializeDagger() {
        appComponent = DaggerAppComponent.builder()
            .addModule(NetworkModule())
            .addModule(DatabaseModule())
            .addModule(DomainModule())
            .addModule(RepositoriesModule())
            .addModule(AppModule(this))
            .addModule(PresentationModule())
            .build()
    }
}