package com.als.myapplication.domain

import com.als.myapplication.data.database.dto.SpecialityDb
import com.als.myapplication.data.database.dto.WorkerDb
import com.als.myapplication.domain.detail.DetailInteractor
import com.als.myapplication.domain.detail.DetailInteractorImpl
import com.als.myapplication.domain.detail.WorkerDetailMapper
import com.als.myapplication.domain.dto.SpecialityV
import com.als.myapplication.domain.dto.WorkerDetail
import com.als.myapplication.domain.dto.WorkerShort
import com.als.myapplication.domain.spec.SpecMapper
import com.als.myapplication.domain.spec.SpecsInteractor
import com.als.myapplication.domain.spec.SpecsInteractorImpl
import com.als.myapplication.domain.workers.WorkerShortMapper
import com.als.myapplication.domain.workers.WorkersInteractor
import com.als.myapplication.domain.workers.WorkersInteractorImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DomainModule {
    @Provides
    @Singleton
    fun provideSpecInteractor(): SpecsInteractor = SpecsInteractorImpl()

    @Provides
    @Singleton
    fun provideWorkersInteractor(): WorkersInteractor = WorkersInteractorImpl()

    @Provides
    @Singleton
    fun provideDetailInteractor(): DetailInteractor = DetailInteractorImpl()

    @Provides
    @Singleton
    fun provideSpecMapper(): MapperList<SpecialityDb, SpecialityV> = SpecMapper()

    @Provides
    @Singleton
    fun provideWorkerShortMapper(): MapperList<WorkerDb, WorkerShort> = WorkerShortMapper()

    @Provides
    @Singleton
    fun provideWorkerAllMapper(): MapperSingle<WorkerDb, WorkerDetail> = WorkerDetailMapper()
}