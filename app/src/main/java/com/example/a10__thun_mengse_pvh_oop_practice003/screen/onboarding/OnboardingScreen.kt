package com.example.a10__thun_mengse_pvh_oop_practice003.screen.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.a10__thun_mengse_pvh_oop_practice003.R

@Composable
fun OnboardingScreen(navController: NavController){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red),
        contentAlignment = Alignment.BottomEnd
    ){
        Image(
            painter = painterResource(id = R.drawable.g_ngoy),
            contentDescription = "background onboarding",
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.Crop
        )


        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.5f)
                .background(Color(0x3B2E2E2E)),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Image(
                painter = painterResource(id = R.drawable.carrot_logo),
                contentDescription = "App Logo",
                modifier = Modifier.size(60.dp)
            )

            Spacer(
                modifier = Modifier.height(20.dp)
            )

            Text(
                text = "  Welcome\nto our store",
                fontSize = 50.sp,
                color = Color.White,
                fontWeight = FontWeight.SemiBold
            )

            Spacer(
                modifier = Modifier.height(10.dp)
            )

            Text(
                text = "Get your groceries in as fast as one hour",
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                color = Color(0xFEB5B1B1),
            )

            Spacer(
                modifier = Modifier.height(30.dp)
            )

            val context = LocalContext.current
            val text = "Get Started"

            Row (
                modifier = Modifier
                    .padding(16.dp)
            ){
//                NectarButton(context, LoginActivity(), text)
            }

        }

    }

}