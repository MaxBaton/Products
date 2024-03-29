package com.maxbay.productsTestEffectiveMobile.presentation.di

import com.maxbay.presentation.navigation.CartBottomMenuDestination
import com.maxbay.presentation.navigation.CatalogBottomMenuDestination
import com.maxbay.presentation.navigation.DiscountsBottomMenuDestination
import com.maxbay.presentation.navigation.ProfileBottomMenuDestination
import com.maxbay.productsTestEffectiveMobile.NavBottomMenuDestinationsCollection
import com.maxbay.productsTestEffectiveMobile.presentation.navigation.MainBottomMenuDestination
import dagger.Module
import dagger.Provides

@Module
class MenuModule {
    @Provides
    fun provideNavBottomMenuDestinationsCollection(): NavBottomMenuDestinationsCollection {
        return NavBottomMenuDestinationsCollection(
            destinations = listOf(
                MainBottomMenuDestination,
                CatalogBottomMenuDestination,
                CartBottomMenuDestination,
                DiscountsBottomMenuDestination,
                ProfileBottomMenuDestination
            )
        )
    }
}