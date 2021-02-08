package com.als.myapplication.presentation.core.detail

import com.als.myapplication.domain.dto.WorkerDetail

interface DetailCallback {
    fun setWorker(worker: WorkerDetail)
}