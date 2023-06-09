package com.berkerdgn.isparkapp.graphs

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.berkerdgn.isparkapp.BottomBarScreen

@Composable
fun HomeNavGraph(navController: NavHostController) {
    NavHost(navController = navController,
            route = Graph.HOME,
            startDestination = BottomBarScreen.Home.route
        ){
        composable( route = BottomBarScreen.Home.route){
            Text(text = "Home")
            Button(onClick = { navController.navigate(Graph.DETAIL) }) {
                Text(text = "ileri")
            }
        }
        composable(route = BottomBarScreen.Save.route){
            Text(text = "save")
        }

        detailsNavGraph(navController=navController)
    }
}