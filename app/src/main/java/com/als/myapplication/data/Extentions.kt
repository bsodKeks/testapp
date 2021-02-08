package com.als.myapplication.data

import com.als.myapplication.data.network.dto.GetData

fun GetData.specialtyMap(): MutableMap<Int, String>{
    val map = mutableMapOf<Int, String>()
    for (item in this.response)
        for (spec in item.speciality)
            map[spec.specialty_id] = spec.name
    return map
}