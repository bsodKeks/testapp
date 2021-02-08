package com.als.myapplication.data.repositories

import com.als.myapplication.domain.spec.SpecsInteractor
import com.als.myapplication.domain.spec.SpecsInteractorImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoriesModule {
    @Provides
    @Singleton
    fun provideMainRepository(): MainRepository = MainRepositoryImpl()
}