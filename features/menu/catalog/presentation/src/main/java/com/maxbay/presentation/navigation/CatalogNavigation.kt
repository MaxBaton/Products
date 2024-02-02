package com.maxbay.presentation.navigation

import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.maxbay.presentation.R
import com.maxbay.presentation.di.CatalogFeatureDepsProvider
import com.maxbay.presentation.di.DaggerCatalogComponent
import com.maxbay.presentation.ui.CatalogScreen
import com.maxbay.presentation.viewModel.CatalogViewModel
import com.maxbay.productsTestEffectiveMobile.NavBottomMenuDestination

object CatalogBottomMenuDestination: NavBottomMenuDestination {
    override val iconId: Int = R.drawable.ic_catalog
    override val titleId: Int = R.string.catalog_screen_title
    override val route: String = "CatalogBottomMenuDestination"
}

fun NavGraphBuilder.catalog() {
    composable(route = CatalogBottomMenuDestination.route) {
        val catalogComponent = DaggerCatalogComponent
            .builder()
            .addDeps(deps = CatalogFeatureDepsProvider.deps)
            .build()
        val catalogViewModel: CatalogViewModel = viewModel(factory = catalogComponent.catalogViewModelFactory)

        CatalogScreen()
    }
}