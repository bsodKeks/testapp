package com.als.myapplication.presentation.core.workers

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.als.myapplication.presentation.Constants
import ru.terrakok.cicerone.android.support.SupportAppScreen

class WorkersScreen(private val specId: Int, private val title: String): SupportAppScreen() {
    override fun getFragment(): Fragment? {
        val fragment = WorkersFragment()
        val args = Bundle()
        args.putInt(Constants.SPEC_ID, specId)
        args.putString(Constants.TITLE, title)
        fragment.arguments = args
        return fragment
    }
}