package com.als.myapplication.presentation.core.specs

import com.als.myapplication.domain.dto.SpecialityV

interface SpecsCallback {
    fun setSpecialitys(specialtys: List<SpecialityV>)
}