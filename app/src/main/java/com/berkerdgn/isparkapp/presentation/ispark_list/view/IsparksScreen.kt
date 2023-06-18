package com.berkerdgn.isparkapp.presentation.ispark_list.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.berkerdgn.isparkapp.AppName
import com.berkerdgn.isparkapp.presentation.ispark_list.IsparksViewModel


@Composable
fun IsparksScreen(
    navController: NavController,
    viewModel:IsparksViewModel = hiltViewModel()
) {

    val state = viewModel.state.value



    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(5.dp)
    ){
        Column {
            AppName()
            LazyColumn(modifier = Modifier.fillMaxWidth()){
                items(state.isparks){
                    IsparkViewListRow( ispark = it, navController = navController)
                }
            }
        }

        if(state.isLoading){
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }


}