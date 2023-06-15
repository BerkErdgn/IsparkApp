package com.berkerdgn.isparkapp.graphs

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.berkerdgn.isparkapp.presentation.bottom_bar_screen.BottomBarScreen
import com.berkerdgn.isparkapp.presentation.ispark_list.view.IsparksScreen

@Composable
fun HomeNavGraph(navController: NavHostController) {
    NavHost(navController = navController,
            route = Graph.HOME,
            startDestination = BottomBarScreen.Home.route
        ){
        composable( route = BottomBarScreen.Home.route){
            IsparksScreen(navController = navController)
        }
        composable(route = BottomBarScreen.Save.route){
            Text(text = "save")
        }

        detailsNavGraph(navController=navController)
    }
}