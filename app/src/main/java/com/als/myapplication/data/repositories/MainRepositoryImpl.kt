package com.als.myapplication.data.repositories

import com.als.myapplication.data.database.AppDao
import com.als.myapplication.data.database.AppDatabase
import com.als.myapplication.data.database.dto.SpecialityDb
import com.als.myapplication.data.database.dto.WorkerDb
import com.als.myapplication.data.database.dto.WorkerSpecDb
import com.als.myapplication.data.network.ApiService
import com.als.myapplication.data.network.dto.GetData
import com.als.myapplication.data.network.dto.Speciality
import com.als.myapplication.data.specialtyMap
import com.als.myapplication.domain.detail.DetailInteractor
import com.als.myapplication.domain.spec.SpecsInteractor
import com.als.myapplication.domain.workers.WorkersInteractor
import com.als.myapplication.presentation.app.App
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainRepositoryImpl : MainRepository {
    @Inject
    lateinit var api: ApiService

    @Inject
    lateinit var dao: AppDao

    @Inject
    lateinit var db: AppDatabase

    lateinit var specsInteractor: SpecsInteractor

    lateinit var workersInteractor: WorkersInteractor

    lateinit var detailInteractor: DetailInteractor

    init {
        App.appComponent.inject(this)
    }

    override fun getData() {
        api.getData()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : DisposableSingleObserver<GetData>() {
                override fun onSuccess(t: GetData) {
                    saveData(t)
                }

                override fun onError(e: Throwable) {
                    e.localizedMessage
                }

            })
    }

    override fun getWorkers(specialityId: Int) {
        workersInteractor.setWorkers(dao.getWorkers(specId = specialityId))
    }

    override fun getWorker(workerId: Long) {
        detailInteractor.setWorker(
            dao.getWorker(workerId = workerId),
            dao.getSpecsByWorker(workerId)
        )
    }

    override fun getSpecialitys() = dao.getSpecs()
    override fun setInteractor(specsInteractor: SpecsInteractor) {
        this.specsInteractor = specsInteractor
    }

    override fun setInteractor(workersInteractor: WorkersInteractor) {
        this.workersInteractor = workersInteractor
    }

    override fun setInteractor(detailInteractor: DetailInteractor) {
        this.detailInteractor = detailInteractor
    }

    private fun saveData(t: GetData) {
        db.clearAllTables()
        val specs = ArrayList<SpecialityDb>()
        for (item in t.specialtyMap()) {
            specs.add(SpecialityDb(specialityId = item.key, name = item.value))
        }
        dao.insertSpecs(specs = specs)

        for (item in t.response) {

            val workerId = dao.insertWorker(
                WorkerDb(
                    name = item.f_name,
                    fname = item.l_name,
                    dr = item.birthday,
                    url = item.avatr_url
                )
            )

            for (spec in item.speciality) {
                dao.insertWorkerSpec(WorkerSpecDb(workerId = workerId, specId = spec.specialty_id))
            }
        }
        specsInteractor.setSpecialitys(dao.getSpecs())
    }
}