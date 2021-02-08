package com.als.myapplication.data.repositories

import com.als.myapplication.data.database.dto.SpecialityDb
import com.als.myapplication.domain.detail.DetailInteractor
import com.als.myapplication.domain.spec.SpecsInteractor
import com.als.myapplication.domain.workers.WorkersInteractor

interface MainRepository{
    fun getData()
    fun getWorkers(specialityId: Int)
    fun getWorker(workerId: Long)
    fun getSpecialitys(): List<SpecialityDb>

    fun setInteractor(specsInteractor: SpecsInteractor)
    fun setInteractor(workersInteractor: WorkersInteractor)
    fun setInteractor(detailInteractor: DetailInteractor)
}