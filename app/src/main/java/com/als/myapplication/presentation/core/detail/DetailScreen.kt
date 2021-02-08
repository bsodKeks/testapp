package com.als.myapplication.presentation.core.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.als.myapplication.presentation.Constants
import com.als.myapplication.presentation.core.workers.WorkersFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class DetailScreen(val workerId: Long): SupportAppScreen() {
    override fun getFragment(): Fragment? {
        val fragment = DetailFragment()
        val args = Bundle()
        args.putLong(Constants.WORKER_ID, workerId)
        fragment.arguments = args
        return fragment
    }
}