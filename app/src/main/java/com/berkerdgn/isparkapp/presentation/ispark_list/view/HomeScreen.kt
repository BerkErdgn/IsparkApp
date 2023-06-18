package com.berkerdgn.isparkapp

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.berkerdgn.isparkapp.graphs.HomeNavGraph
import com.berkerdgn.isparkapp.presentation.bottom_bar_screen.BottomBarScreen
import com.berkerdgn.isparkapp.presentation.ui.theme.customBlue

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavHostController = rememberNavController()) {
    Scaffold (
        bottomBar = { BottomBar(navController = navController) }
            ) {
        HomeNavGraph(navController = navController)
    }
}

@Composable
fun BottomBar(navController: NavHostController) {
    val screens = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Save
    )

    val navBackStageEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStageEntry?.destination


    val bottomBarDestination = screens.any { it.route == currentDestination?.route }
    if (bottomBarDestination){
        BottomNavigation {
            screens.forEach { screen->
                AddItem(
                    screen = screen,
                    currentDestination = currentDestination,
                    navController = navController
                )

            }
        }
    }

}

@Composable
fun RowScope.AddItem(
    screen: BottomBarScreen,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    BottomNavigationItem(
        modifier = Modifier.background(customBlue),
        label = {
          Text(text = screen.title)
        },
        icon = {
            Icon(imageVector = screen.icon,
                contentDescription = "Navigation Icon"
                )
        },
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,
        unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
        onClick = {
            navController.navigate(screen.route){
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        }
    )
}