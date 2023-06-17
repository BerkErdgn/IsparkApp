package com.berkerdgn.isparkapp.graphs

import androidx.compose.material.Text
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.berkerdgn.isparkapp.R
import com.berkerdgn.isparkapp.presentation.ispark_detail.view.IsparkDetailScreen
import com.berkerdgn.isparkapp.presentation.ispark_list.view.IsparksScreen
import com.berkerdgn.isparkapp.util.Constant.PARK_ID

fun NavGraphBuilder.detailsNavGraph(navController: NavHostController){
    navigation(
        route = Graph.DETAIL,
        startDestination = DetailsScreen.Information.route
    ){
        composable(DetailsScreen.Information.route+"/{${PARK_ID}}"){
            
            IsparkDetailScreen(
                emptyParkingSpace = painterResource(id = R.drawable.empty_parking_space),
                fullParkingSpace = painterResource(id = R.drawable.full_parking_space)
            )

        }
    }
}


sealed class DetailsScreen(val route: String){
    object Information : DetailsScreen(route = "detail")
}