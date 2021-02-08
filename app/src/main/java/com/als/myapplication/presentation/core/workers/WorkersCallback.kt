package com.als.myapplication.presentation.core.workers

import com.als.myapplication.domain.dto.WorkerShort

interface WorkersCallback {
    fun setWorkers(workers: List<WorkerShort>)
}