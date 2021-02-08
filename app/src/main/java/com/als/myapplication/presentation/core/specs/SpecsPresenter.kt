package com.als.myapplication.presentation.core.specs

import com.als.myapplication.data.network.dto.Speciality
import com.als.myapplication.domain.dto.SpecialityV
import com.als.myapplication.domain.spec.SpecsInteractor
import com.als.myapplication.presentation.app.App
import com.als.myapplication.presentation.core.workers.WorkersScreen
import moxy.InjectViewState
import moxy.MvpPresenter
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class SpecsPresenter: MvpPresenter<SpecsView>(), SpecsCallback {
    @Inject
    lateinit var interactor: SpecsInteractor

    @Inject
    lateinit var cicerone: Cicerone<Router>

    init {
        App.appComponent.inject(this)
        interactor.setSpecsCallback(this)
    }

    fun getData(){
        interactor.getData()
    }

    override fun setSpecialitys(specialtys: List<SpecialityV>) {
        viewState.showSpecs(specialtys)
    }

    fun onSpecClick(specId: Int, specName: String) {
        cicerone.router.navigateTo(WorkersScreen(specId,specName))
    }
}