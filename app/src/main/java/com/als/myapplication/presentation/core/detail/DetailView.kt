package com.als.myapplication.presentation.core.detail

import com.als.myapplication.domain.dto.WorkerDetail
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

interface DetailView: MvpView {
    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showWorker(worker: WorkerDetail)
}