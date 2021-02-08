package com.als.myapplication.domain.spec

import com.als.myapplication.data.database.dto.SpecialityDb
import com.als.myapplication.data.network.dto.Speciality
import com.als.myapplication.presentation.core.specs.SpecsCallback

interface SpecsInteractor {
    fun getData()
    fun setSpecsCallback(specsCallback: SpecsCallback)
    fun setSpecialitys(specialtys: List<SpecialityDb>)
}