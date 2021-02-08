package com.als.myapplication.domain.spec

import com.als.myapplication.data.database.dto.SpecialityDb
import com.als.myapplication.domain.MapperList
import com.als.myapplication.domain.dto.SpecialityV

class SpecMapper: MapperList<SpecialityDb, SpecialityV> {
    override fun map(from: List<SpecialityDb>): List<SpecialityV> {
        val specs = ArrayList<SpecialityV>()
        for (item in from){
            specs.add(SpecialityV(specialityId = item.specialityId, name = item.name))
        }
        return specs
    }
}