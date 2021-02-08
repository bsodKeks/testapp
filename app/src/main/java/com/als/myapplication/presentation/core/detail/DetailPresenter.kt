package com.als.myapplication.presentation.core.detail

import com.als.myapplication.domain.detail.DetailInteractor
import com.als.myapplication.domain.dto.WorkerDetail
import com.als.myapplication.presentation.app.App
import moxy.InjectViewState
import moxy.MvpPresenter
import javax.inject.Inject

@InjectViewState
class DetailPresenter: MvpPresenter<DetailView>(), DetailCallback {
    @Inject
    lateinit var interactor: DetailInteractor

    init {
        App.appComponent.inject(this)
        interactor.setDetailsCallback(this)
    }

    fun getWorker(workerId: Long) {
        interactor.getWorker(workerId)
    }

    override fun setWorker(worker: WorkerDetail) {
        viewState.showWorker(worker)
    }
}