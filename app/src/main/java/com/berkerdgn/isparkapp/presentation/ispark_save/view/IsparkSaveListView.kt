package com.berkerdgn.isparkapp.presentation.ispark_save.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.berkerdgn.isparkapp.AppName
import com.berkerdgn.isparkapp.presentation.ispark_save.IsparkSaveViewModel
import okhttp3.internal.wait
import java.util.Collections


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun IsparkSaveListView(
    navController: NavController,
    saveViewModel : IsparkSaveViewModel = hiltViewModel()
) {
    val state = saveViewModel.state.value



    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp)
    ){
        Column {
            AppName()
            if (state.isparks.isNotEmpty()){
                LazyColumn(modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                ){
                    itemsIndexed(items = state.isparks, key = {_,ispark->
                        ispark.hashCode()
                    }){index, item->
                        val dismissState = rememberDismissState(
                            confirmStateChange = {
                                if (it == DismissValue.DismissedToStart){
                                    saveViewModel.deleteIspark(item)
                                }
                                true
                            }
                        )
                        SwipeToDismiss(state = dismissState , background = {
                            val color = when(dismissState.dismissDirection){
                                DismissDirection.StartToEnd -> Color.Transparent
                                DismissDirection.EndToStart -> Color.Black
                                null -> Color.White
                            }
                            Box(modifier = Modifier
                                .fillMaxSize()
                                .background(color = color)
                                .padding(10.dp)){
                                Icon(imageVector = Icons.Default.Delete,
                                    contentDescription = "Delete",
                                    tint = Color.Gray,
                                    modifier = Modifier.align(Alignment.CenterEnd)
                                    )
                            }
                        },
                            dismissContent = {
                                IsparkSaveRow(navController = navController, ispark = item)
                            },
                            directions = setOf(DismissDirection.EndToStart))
                            Divider()
                    }
                }
            }else{
                Text(text = "You didn't save any Ispark. Add a ispark near your home ❤️",
                    fontSize = 13.sp,
                    textAlign = TextAlign.Center)
            }
        }
        if(state.isLoading){
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }

    }
    

}