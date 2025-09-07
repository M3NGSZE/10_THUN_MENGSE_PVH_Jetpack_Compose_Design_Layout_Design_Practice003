package com.example.a10__thun_mengse_pvh_oop_practice003.screen.orderAccept

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.a10__thun_mengse_pvh_oop_practice003.R
import com.example.a10__thun_mengse_pvh_oop_practice003.component.NectarButton
import com.example.a10__thun_mengse_pvh_oop_practice003.navigation.Screen

@Composable
fun OrderAcceptScreen(navController: NavController){
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        Box(
            modifier = Modifier
                .size(300.dp),
            contentAlignment = Alignment.Center
        ){
            Image(
                painter = painterResource(R.drawable.tick),
                contentDescription = "order success"
            )
        }

        Spacer(modifier = Modifier.height(30.dp))

        Column {
            Text(
                text = "Your Order has been \n accepted",
                textAlign = TextAlign.Center,
                fontSize = 30.sp,
                fontWeight = FontWeight.Medium
            )

            Spacer(modifier = Modifier.height(15.dp))

            Text(
                text = "Your item has been placed and is on \n ot's way to being processed",
                textAlign = TextAlign.Center,
                fontSize = 18.sp,
                color = Color.Gray
            )
        }

        Spacer(modifier = Modifier.height(135.dp))

        NectarButton("Track Order", navController, Screen.Cart.route)

        Spacer(modifier = Modifier.height(25.dp))

        Text(
            text = "Back to Home",
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .clickable{
                    navController.navigate(Screen.Home.route)
                }
        )

    }
}