package com.berkerdgn.isparkapp.graphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.berkerdgn.isparkapp.HomeScreen

@Composable
fun RootNavigationGraph(navController: NavHostController) {
    NavHost(navController = navController,
            route = Graph.ROOT,
            startDestination = Graph.SPLASH
    ){
        splashScreenGraph(navController = navController)
        composable(route = Graph.HOME){
            HomeScreen()
        }
    }

}


object Graph{
    const val ROOT = "root_graph"
    const val SPLASH = "splash_graph"
    const val HOME = "home_graph"
    const val DETAIL = "detail_graph"
}