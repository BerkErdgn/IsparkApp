package com.berkerdgn.isparkapp.presentation.ispark_save.view

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.berkerdgn.isparkapp.presentation.ispark_save.IsparkSaveViewModel


@Composable
fun IsparkSaveListView(
    navController: NavController,
    saveViewModel : IsparkSaveViewModel = hiltViewModel()
) {
    val state = saveViewModel.state.value
    
    Column {
        for (i in state.isparks){
            println("liste")
            println(i.parkName)
            Text(text = i.parkName)
        }
        
    }
    

}