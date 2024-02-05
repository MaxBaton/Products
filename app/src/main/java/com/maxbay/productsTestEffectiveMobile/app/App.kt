package com.maxbay.productsTestEffectiveMobile.app

import android.app.Application
import com.maxbay.presentation.di.CatalogFeatureDepsProvider
import com.maxbay.productsTestEffectiveMobile.di.AppComponentProvider
import com.maxbay.productsTestEffectiveMobile.di.AuthFeatureDepsProvider
import com.maxbay.productsTestEffectiveMobile.di.DaggerAppComponent

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        setupDagger()
    }

    private fun setupDagger() {
        val appComponent = DaggerAppComponent
            .builder()
            .addContext(context = this)
            .build()
        AppComponentProvider.appComponent = appComponent
        AuthFeatureDepsProvider.deps = appComponent
        CatalogFeatureDepsProvider.deps = appComponent
    }
}