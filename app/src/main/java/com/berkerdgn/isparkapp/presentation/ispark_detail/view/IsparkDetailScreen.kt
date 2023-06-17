package com.berkerdgn.isparkapp.presentation.ispark_detail.view


import android.graphics.drawable.Icon
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle

import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.berkerdgn.isparkapp.presentation.ispark_detail.IsparkDetailViewModel
import com.berkerdgn.isparkapp.presentation.ispark_save.IsparkSaveViewModel
import com.berkerdgn.isparkapp.presentation.ui.theme.customWhite
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState


@Composable
fun IsparkDetailScreen(
    emptyParkingSpace : Painter,
    fullParkingSpace : Painter,
    viewModel: IsparkDetailViewModel = hiltViewModel(),
    savedViewModel: IsparkSaveViewModel = hiltViewModel()
) {

    val state = viewModel.state.value

    state.isparkDetail?.let {
        if (it.isEmpty()){
            println("boş")
        }else{

            val parkArea = LatLng(it[0].lat.toDouble(),it[0].lng.toDouble())
            val parkAreaState = MarkerState(position = parkArea)
            val cameraPositionState = rememberCameraPositionState{
                position = CameraPosition.fromLatLngZoom(parkArea, 16f)
            }

            Box(modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
                ){
                Column(modifier = Modifier.fillMaxSize()) {
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp)
                        .clip(shape = RoundedCornerShape(20.dp))


                    ) {
                        GoogleMap(
                            modifier = Modifier
                                .fillMaxSize(),
                            cameraPositionState = cameraPositionState
                        ){
                            Marker(
                                state = parkAreaState,
                                title = it[0].parkName
                            )

                        }

                    }

                    Column(modifier = Modifier
                        .fillMaxWidth()
                        .clip(shape = RoundedCornerShape(20.dp))
                        .padding(top = 15.dp, bottom = 15.dp)
                        .background(customWhite)

                    ) {

                        Row(modifier = Modifier
                            .fillMaxWidth()
                            .padding(5.dp)
                        ) {
                            Text(text = it[0].parkName,
                                style = MaterialTheme.typography.h5,
                                textAlign = TextAlign.Center,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .drawBehind {
                                        val borderSize = 4.dp.toPx()
                                        drawLine(
                                            color = Color.DarkGray,
                                            start = Offset(0f, size.height),
                                            end = Offset(size.width, size.height),
                                            strokeWidth = borderSize
                                        )
                                    },
                                fontWeight = FontWeight.Bold)
                        }

                        Row(modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center) {
                            val calculation = (it[0].emptyCapacity * 5 / it[0].capacity)

                            for (i in 1..calculation){
                                Image(painter = fullParkingSpace, contentDescription = "Empty Park Area")
                            }
                            for(i in 0..(4-calculation)){
                                Image(painter = emptyParkingSpace, contentDescription = "Empty Park Area")
                            }
                        }

                        Row(modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Text(text = "Çalışma saati: ${it[0].workHours} ",
                                style = MaterialTheme.typography.h6,
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center
                            )

                        }

                        Row(modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Column(modifier = Modifier
                                .fillMaxSize()
                                .padding(top = 5.dp)
                            ) {
                                Text(text = "Ücretler : ",
                                    style = MaterialTheme.typography.h6,
                                )

                                val replaced = it[0].tariff.replace(';','\n')
                                Text(text = replaced,
                                    style = MaterialTheme.typography.h6,
                                    modifier = Modifier
                                        .padding(start = 60.dp),
                                    fontStyle = FontStyle.Italic
                                )
                            }
                        }
                    }



                    }

                    Row(modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(5.dp)
                    ) {
                        val context = LocalContext.current
                        CustomFloatingButton {
                            Toast.makeText(context,"Successfully saved!",Toast.LENGTH_LONG).show()
                            val savedIspark = it[0]
                            savedViewModel.saveIspark(parkID = savedIspark.parkID, parkName = savedIspark.parkName)
                        }

                    }



                }




        }


    }

    if (state.error.isNotBlank()){
        Text(text = "sorun")
    }

    if (state.isLoading){
        CircularProgressIndicator()
    }

}


@Composable
fun CustomFloatingButton(onSave : () -> Unit) {
    FloatingActionButton(onClick = onSave,
        backgroundColor = Color.Cyan,
        contentColor = Color.Black){
        androidx.compose.material.Icon(imageVector = Icons.Filled.Add, contentDescription = "Add Button")
    }
}
