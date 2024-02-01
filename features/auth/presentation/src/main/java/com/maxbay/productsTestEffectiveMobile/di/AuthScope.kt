package com.maxbay.productsTestEffectiveMobile.di

import androidx.core.location.LocationRequestCompat.Quality
import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class AuthScope
