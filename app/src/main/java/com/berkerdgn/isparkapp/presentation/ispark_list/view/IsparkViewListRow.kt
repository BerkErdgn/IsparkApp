package com.berkerdgn.isparkapp.presentation.ispark_list.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.berkerdgn.isparkapp.data.remote.dto.IsparkDtoItem
import com.berkerdgn.isparkapp.graphs.DetailsScreen
import com.berkerdgn.isparkapp.presentation.ispark_list.IsparkViewState
import com.berkerdgn.isparkapp.presentation.ui.theme.customWhite


@Composable
fun IsparkViewListRow(
    navController: NavController,
    ispark : IsparkDtoItem,

    ) {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(7.dp)
            .background(customWhite)
            .clickable {
                navController.navigate(DetailsScreen.Information.route+"/${ispark.parkID}")
            },

        horizontalArrangement = Arrangement.SpaceBetween

            ){
        Column {
            Text(text = ispark.parkName,
                style = MaterialTheme.typography.h5,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                fontWeight = FontWeight.Bold
            )
            Row (modifier = Modifier.fillMaxWidth()
                .padding(5.dp)
            ) {
                Text(text = "Capacity: ${ispark.capacity}",
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.width(180.dp),
                    fontStyle = FontStyle.Italic

                )
                Text(text = "EmptyCapacity: ${ispark.emptyCapacity}",
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.width(200.dp),
                    fontStyle = FontStyle.Italic
                )
            }

        }

    }

}

/*
@Preview
@Composable
fun Preview(){
    IsparkViewListRow()
}

 */