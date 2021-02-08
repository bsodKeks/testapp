package com.als.myapplication.data.database.dto

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SpecialityDb(
    @PrimaryKey(autoGenerate = true) val specialityDbId: Long = 0,
    val specialityId: Int,
    val name: String
)