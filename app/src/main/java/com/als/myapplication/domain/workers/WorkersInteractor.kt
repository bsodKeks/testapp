package com.als.myapplication.domain.workers

import com.als.myapplication.data.database.dto.WorkerDb
import com.als.myapplication.presentation.core.workers.WorkersCallback

interface WorkersInteractor {
    fun setWorkersCallback(workersCallback: WorkersCallback)
    fun getWorkers(specId: Int?)
    fun setWorkers(workerDbs: List<WorkerDb>)
}