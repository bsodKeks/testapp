package com.als.myapplication.presentation.core.specs

import androidx.fragment.app.Fragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class SpecsScreen: SupportAppScreen() {
    override fun getFragment() = SpecsFragment()
}