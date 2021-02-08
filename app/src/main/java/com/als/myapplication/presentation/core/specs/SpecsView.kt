package com.als.myapplication.presentation.core.specs

import com.als.myapplication.domain.dto.SpecialityV
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

interface SpecsView : MvpView{
    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showSpecs(specialtys: List<SpecialityV>)
}