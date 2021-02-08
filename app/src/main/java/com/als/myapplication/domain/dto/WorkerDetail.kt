package com.als.myapplication.domain.dto

data class WorkerDetail(
    val workerId: Long,
    val fio: String,
    val dr: String?,
    var specs: String = "",
    val url: String?
)