package com.berkerdgn.isparkapp

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector


sealed class BottomBarScreen(
    val route : String,
    val title: String,
    val icon : ImageVector
) {
    object Home : BottomBarScreen(
        route = "Home",
        title = "Home",
        icon = Icons.Default.Home
    )

    object Save : BottomBarScreen(
        route = "Save",
        title = "Save",
        icon = Icons.Default.Person
    )

}