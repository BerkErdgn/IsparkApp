package com.berkerdgn.isparkapp.presentation.splash_secreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.berkerdgn.isparkapp.graphs.Graph
import kotlinx.coroutines.delay



@Composable
fun SplashScreen(navController: NavHostController) {

    LaunchedEffect(key1 = true){
        // for delay
        delay(4000)
        navController.popBackStack()
        navController.navigate(Graph.HOME)
    }

    Column(modifier = Modifier
        .fillMaxWidth(),
        horizontalAlignment = Alignment.End
    ) {
        //For LottieAnimation
        val composition by rememberLottieComposition(spec = LottieCompositionSpec.Url("https://assets9.lottiefiles.com/packages/lf20_KLSxFl.json"))
        LottieAnimation(composition = composition, iterations = LottieConstants.IterateForever,)


    }

}