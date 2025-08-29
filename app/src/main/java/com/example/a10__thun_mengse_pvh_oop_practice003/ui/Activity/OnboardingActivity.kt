package com.example.a10__thun_mengse_pvh_oop_practice003.ui.Activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.a10__thun_mengse_pvh_oop_practice003.R


//@SuppressLint("CustomSplashScreen")
class OnboardingActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Onboarding()
        }
    }
}

@Composable
fun Onboarding(){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red)
    ){
        Image(
            painter = painterResource(id = R.drawable.g_ngoy),
            contentDescription = "background onboarding",
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.Crop
        )

    }

//    Column (
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Color.Red)
//    ) {
//        Image(
//            painter = painterResource(id = R.drawable.sentry),
//            contentDescription = "background onboarding",
//            modifier = Modifier
//                .fillMaxSize(),
//            contentScale = ContentScale.Crop
//        )
//    }
}
