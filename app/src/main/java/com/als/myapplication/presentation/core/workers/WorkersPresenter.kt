package com.als.myapplication.presentation.core.workers

import com.als.myapplication.data.database.dto.WorkerDb
import com.als.myapplication.domain.dto.WorkerShort
import com.als.myapplication.domain.workers.WorkersInteractor
import com.als.myapplication.presentation.app.App
import com.als.myapplication.presentation.core.detail.DetailScreen
import moxy.InjectViewState
import moxy.MvpPresenter
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class WorkersPresenter: MvpPresenter<WorkersView>(), WorkersCallback {
    @Inject
    lateinit var interactor: WorkersInteractor

    @Inject
    lateinit var cicerone: Cicerone<Router>

    init {
        App.appComponent.inject(this)
        interactor.setWorkersCallback(this)
    }

    fun getWorkers(specId: Int?) {
        interactor.getWorkers(specId)
    }

    override fun setWorkers(workers: List<WorkerShort>) {
        viewState.showWorkers(workers)
    }

    fun onWorkerClick(workerId: Long) {
        cicerone.router.navigateTo(DetailScreen(workerId = workerId))
    }
}