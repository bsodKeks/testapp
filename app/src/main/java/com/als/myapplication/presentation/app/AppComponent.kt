package com.als.myapplication.presentation.app

import com.als.myapplication.data.database.DatabaseModule
import com.als.myapplication.data.network.NetworkModule
import com.als.myapplication.data.repositories.MainRepositoryImpl
import com.als.myapplication.data.repositories.RepositoriesModule
import com.als.myapplication.domain.DomainModule
import com.als.myapplication.domain.detail.DetailInteractorImpl
import com.als.myapplication.domain.spec.SpecsInteractorImpl
import com.als.myapplication.domain.workers.WorkersInteractorImpl
import com.als.myapplication.presentation.PresentationModule
import com.als.myapplication.presentation.activities.MainActivity
import com.als.myapplication.presentation.core.detail.DetailPresenter
import com.als.myapplication.presentation.core.specs.SpecsPresenter
import com.als.myapplication.presentation.core.workers.WorkersPresenter
import dagger.Component
import javax.inject.Singleton

@Component(modules = [DatabaseModule::class,
    NetworkModule::class,
    DomainModule::class,
    RepositoriesModule::class,
    AppModule::class,
    PresentationModule::class])
@Singleton
interface AppComponent {
    @Component.Builder
    interface Builder {
        fun build(): AppComponent
        fun addModule(databaseModule: DatabaseModule): Builder
        fun addModule(networkModule: NetworkModule): Builder
        fun addModule(domainModule: DomainModule): Builder
        fun addModule(repositoriesModule: RepositoriesModule): Builder
        fun addModule(appModule: AppModule): Builder
        fun addModule(presentationModule: PresentationModule): Builder
    }

    fun inject(mainRepositoryImpl: MainRepositoryImpl)
    fun inject(specsPresenter: SpecsPresenter)
    fun inject(mainInteractorImpl: DetailInteractorImpl)
    fun inject(workersPresenter: WorkersPresenter)
    fun inject(detailPresenter: DetailPresenter)
    fun inject(specsInteractorImpl: SpecsInteractorImpl)
    fun inject(workersInteractorImpl: WorkersInteractorImpl)
    fun inject(mainActivity: MainActivity)


}