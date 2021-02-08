package com.als.myapplication.domain.dto


data class WorkerShort(
    val workerId: Long,
    val fio: String,
    val vozrast: String,
    val url: String?
)