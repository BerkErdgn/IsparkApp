package com.berkerdgn.isparkapp.presentation.ispark_save.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.berkerdgn.isparkapp.data.remote.dto.room_dto.SavedIsparkDto
import com.berkerdgn.isparkapp.graphs.DetailsScreen
import com.berkerdgn.isparkapp.presentation.ui.theme.customWhite


@Composable
fun IsparkSaveRow(
    navController: NavController,
    ispark: SavedIsparkDto
) {

    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .background(customWhite)
            .clickable {
                navController.navigate(DetailsScreen.Information.route + "/${ispark.parkID}")
            },
        horizontalArrangement = Arrangement.SpaceBetween

            ){
        Column(modifier = Modifier
            .fillMaxSize()
        ) {
            Text(text = ispark.parkName,
            modifier = Modifier
                .fillMaxWidth(),
                style = MaterialTheme.typography.h6,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold)
        }

    }

}