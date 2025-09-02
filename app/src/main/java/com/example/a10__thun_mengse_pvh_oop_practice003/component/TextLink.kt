package com.example.a10__thun_mengse_pvh_oop_practice003.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun Signup(description1: String, description2: String, navController: NavController, screenName: String){
    Row (
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ){
        Text(
            text = description1,
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium
        )
        Text(
            text = " $description2",
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            color = Color(0xFF53B175),
            modifier = Modifier
                .clickable{
                    navController.navigate(screenName)
                }
        )
    }
}