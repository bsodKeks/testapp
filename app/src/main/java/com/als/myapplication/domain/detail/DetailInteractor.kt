package com.als.myapplication.domain.detail

import com.als.myapplication.data.database.dto.SpecialityDb
import com.als.myapplication.data.database.dto.WorkerDb
import com.als.myapplication.presentation.core.detail.DetailCallback

interface DetailInteractor {
    fun setDetailsCallback(detailCallback: DetailCallback)
    fun getWorker(workerId: Long)
    fun setWorker(workerDb: WorkerDb, specs: List<SpecialityDb>)
}