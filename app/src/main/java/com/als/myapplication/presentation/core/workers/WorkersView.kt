package com.als.myapplication.presentation.core.workers

import com.als.myapplication.data.database.dto.WorkerDb
import com.als.myapplication.domain.dto.WorkerShort
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

interface WorkersView : MvpView {
    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showWorkers(workers: List<WorkerShort>)
}