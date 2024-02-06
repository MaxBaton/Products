package com.maxbay.presentation.di

import com.maxbay.api.AuthApi
import com.maxbay.api.CatalogApi

interface ProfileFeatureDeps {
    val authApi: AuthApi
    val catalogApi: CatalogApi
}