package com.berkerdgn.isparkapp

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.berkerdgn.isparkapp.presentation.ui.theme.customBlue

@Composable
fun AppName() {
    Text(text = "İSPARK",
        fontSize = 30.sp,
        color = customBlue,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Bold
        )



}