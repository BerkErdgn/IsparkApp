package com.berkerdgn.isparkapp.graphs


import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation


fun NavGraphBuilder.splashScreenGraph(navController: NavHostController) {
    navigation(
        route = Graph.SPLASH,
        startDestination = SplashScreen.FirstSplash.route
    ){
        composable(route = SplashScreen.FirstSplash.route){
            Text(text = "splash Screen")
            Button(onClick ={ navController.navigate(Graph.HOME)}) {
                Text(text = "Home")
            }
        }
    }
}


sealed class SplashScreen(val route: String){
    object FirstSplash : SplashScreen(route = "FIRSTSPLASH")
}

