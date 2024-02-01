package com.maxbay.productsTestEffectiveMobile.presentation.di

import com.maxbay.productsTestEffectiveMobile.NavBottomMenuDestinationsCollection
import dagger.Component

@Component(
    modules = [MenuModule::class]
)
interface MenuComponent {
    val bottomMenuDestinations: NavBottomMenuDestinationsCollection

    @Component.Builder
    interface Builder {
        fun build(): MenuComponent
    }
}