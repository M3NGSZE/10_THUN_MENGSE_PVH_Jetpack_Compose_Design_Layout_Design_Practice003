package com.example.a10__thun_mengse_pvh_oop_practice003.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun NectarButton(
    text: String,
    navController: NavController,
    screenName: String,
){
    Button(
        onClick = {
            if (screenName != ""){
                navController.navigate(screenName)
            }
        },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF53B175),
        ),
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
    ) {
        Text(
            text = text,
            fontSize = 23.sp,
            fontWeight = FontWeight.W900
        )
    }
}