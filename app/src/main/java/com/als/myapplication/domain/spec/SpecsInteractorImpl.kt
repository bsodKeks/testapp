package com.als.myapplication.domain.spec

import com.als.myapplication.data.database.dto.SpecialityDb
import com.als.myapplication.data.repositories.MainRepository
import com.als.myapplication.domain.MapperList
import com.als.myapplication.domain.dto.SpecialityV
import com.als.myapplication.presentation.app.App
import com.als.myapplication.presentation.core.specs.SpecsCallback
import javax.inject.Inject

class SpecsInteractorImpl: SpecsInteractor {
    @Inject
    lateinit var mainRepository: MainRepository

    @Inject
    lateinit var mapperList: MapperList<SpecialityDb, SpecialityV>

    lateinit var specCallback: SpecsCallback

    init {
        App.appComponent.inject(this)
        mainRepository.setInteractor(this)
    }

    override fun getData() {
        mainRepository.getData()
    }

    override fun setSpecsCallback(specsCallback: SpecsCallback) {
        specCallback = specsCallback
    }

    override fun setSpecialitys(specialtys: List<SpecialityDb>) {
        specCallback.setSpecialitys(mapperList.map(specialtys))
    }
}