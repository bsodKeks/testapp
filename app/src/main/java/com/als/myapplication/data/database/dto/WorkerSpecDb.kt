package com.als.myapplication.data.database.dto

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class WorkerSpecDb(
    @PrimaryKey(autoGenerate = true) val workerSpecId: Long = 0,
    val workerId: Long,
    val specId: Int
)