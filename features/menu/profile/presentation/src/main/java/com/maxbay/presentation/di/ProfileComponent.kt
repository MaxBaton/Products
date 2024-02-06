package com.maxbay.presentation.di

import com.maxbay.api.AuthApi
import com.maxbay.presentation.viewModel.ProfileViewModelFactory
import dagger.Component

@ProfileScope
@Component(
    modules = [ProfileModule::class],
    dependencies = [ProfileFeatureDeps::class]
)
interface ProfileComponent {
    val profileViewModelFactory: ProfileViewModelFactory

    @Component.Builder
    interface Builder {
        fun addDeps(deps: ProfileFeatureDeps): Builder
        fun build(): ProfileComponent
    }
}