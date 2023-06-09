package com.berkerdgn.isparkapp.graphs

import androidx.compose.material.Text
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation

fun NavGraphBuilder.detailsNavGraph(navController: NavHostController){
    navigation(
        route = Graph.DETAIL,
        startDestination = DetailsScreen.Information.route
    ){
        composable(DetailsScreen.Information.route){
            Text(text = "info")
        }
    }
}


sealed class DetailsScreen(val route: String){
    object Information : DetailsScreen(route = "INFORMATON")
}