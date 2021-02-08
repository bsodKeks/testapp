package com.als.myapplication.presentation.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.als.myapplication.R
import com.als.myapplication.presentation.app.App
import com.als.myapplication.presentation.core.specs.SpecsScreen
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import javax.inject.Inject

class MainActivity : AppCompatActivity(){
    @Inject
    lateinit var cicerone: Cicerone<Router>

    private var navigator: Navigator = object : SupportAppNavigator(this, R.id.container){}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeDagger()
        if (savedInstanceState == null) showfragment()

    }

    private fun initializeDagger() {
        App.appComponent.inject(this)
    }

    override fun onResume() {
        super.onResume()
        cicerone.navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        cicerone.navigatorHolder.removeNavigator()
    }

    private fun showfragment() {
        cicerone.router.newRootScreen(SpecsScreen())
    }
}