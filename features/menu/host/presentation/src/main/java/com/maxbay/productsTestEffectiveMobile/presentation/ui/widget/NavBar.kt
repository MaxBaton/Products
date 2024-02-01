package com.maxbay.productsTestEffectiveMobile.presentation.ui.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.maxbay.productsTestEffectiveMobile.NavBottomMenuDestination

@Composable
fun NavBar(
    currentDestination: String?,
    destinations: List<NavBottomMenuDestination>,
    onNavigateToTopLevel: (topRoute: String) -> Unit,
    modifier: Modifier = Modifier,
    backgroundColor: Color = MaterialTheme.colorScheme.background
) {
    NavigationBar(
        modifier = modifier,
        containerColor = backgroundColor
    ) {
        destinations.forEachIndexed { index, destination ->
            val isSelected = currentDestination == destination.route
            val iconTintColor = if (isSelected) {
                MaterialTheme.colorScheme.primary
            }else {
                MaterialTheme.colorScheme.onSurface
            }

            BottomMenuItem(
                modifier = Modifier.weight(1f).fillMaxHeight(),
                iconId = destination.iconId,
                titleId = destination.titleId,
                onClick = { onNavigateToTopLevel(destination.route) }
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun NavBarPreview() {

}