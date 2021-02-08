package com.als.myapplication.domain.workers

import com.als.myapplication.data.database.dto.WorkerDb
import com.als.myapplication.data.repositories.MainRepository
import com.als.myapplication.domain.MapperList
import com.als.myapplication.domain.dto.WorkerShort
import com.als.myapplication.presentation.app.App
import com.als.myapplication.presentation.core.workers.WorkersCallback
import javax.inject.Inject

class WorkersInteractorImpl: WorkersInteractor {
    lateinit var workerCallback: WorkersCallback

    @Inject
    lateinit var mainRepository: MainRepository

    @Inject
    lateinit var mapper: MapperList<WorkerDb, WorkerShort>

    init {
        App.appComponent.inject(this)
        mainRepository.setInteractor(this)
    }

    override fun setWorkersCallback(workersCallback: WorkersCallback) {
        workerCallback = workersCallback
    }
    override fun getWorkers(specId: Int?) {
        mainRepository.getWorkers(specId!!)
    }

    override fun setWorkers(workerDbs: List<WorkerDb>) {
        workerCallback.setWorkers(mapper.map(workerDbs))
    }
}