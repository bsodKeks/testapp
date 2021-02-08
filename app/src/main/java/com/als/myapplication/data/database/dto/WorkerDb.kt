package com.als.myapplication.data.database.dto

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters


@Entity
data class WorkerDb(
    @PrimaryKey(autoGenerate = true) val workerId: Long = 0,
    val name: String,
    val fname: String,
    val dr: String?,
    val url: String?
)