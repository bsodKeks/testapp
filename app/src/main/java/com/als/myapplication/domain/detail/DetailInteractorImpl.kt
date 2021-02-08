package com.als.myapplication.domain.detail

import com.als.myapplication.data.database.dto.SpecialityDb
import com.als.myapplication.data.database.dto.WorkerDb
import com.als.myapplication.data.repositories.MainRepository
import com.als.myapplication.domain.MapperSingle
import com.als.myapplication.domain.dto.WorkerDetail
import com.als.myapplication.presentation.app.App
import com.als.myapplication.presentation.core.detail.DetailCallback
import javax.inject.Inject

class DetailInteractorImpl: DetailInteractor {
    @Inject
    lateinit var mainRepository: MainRepository

    @Inject
    lateinit var mapper: MapperSingle<WorkerDb, WorkerDetail>

    lateinit var detailCallback: DetailCallback

    init {
        App.appComponent.inject(this)
        mainRepository.setInteractor(this)
    }

    override fun setDetailsCallback(detailCallback: DetailCallback) {
        this.detailCallback = detailCallback
    }

    override fun getWorker(workerId: Long) {
        mainRepository.getWorker(workerId)
    }

    override fun setWorker(workerDb: WorkerDb, specs: List<SpecialityDb>) {
        val stringSpecs = ArrayList<String>()
        for (item in specs){
            stringSpecs.add(item.name)
        }
        val workerDetail = mapper.map(workerDb)
        workerDetail.specs = stringSpecs.toString().replace("[","").replace("]","")
        detailCallback.setWorker(workerDetail)
    }
}