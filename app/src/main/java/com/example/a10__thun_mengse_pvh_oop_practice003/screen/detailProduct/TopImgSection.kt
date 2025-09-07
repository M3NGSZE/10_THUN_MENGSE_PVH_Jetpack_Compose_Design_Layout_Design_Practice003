package com.example.a10__thun_mengse_pvh_oop_practice003.screen.detailProduct

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.IosShare
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.a10__thun_mengse_pvh_oop_practice003.data.ProductMoreFields
import com.example.a10__thun_mengse_pvh_oop_practice003.navigation.Screen

@Composable
fun TopImgSection(img: ProductMoreFields, navController: NavController){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(330.dp)
            .background(
                color = Color(0xFFF0F1F0),
                shape = RoundedCornerShape(
                    bottomStart = 24.dp,
                    bottomEnd = 24.dp
                )
            )
            .padding(start = 16.dp, end = 16.dp)
    ){
        Image(
            painter = painterResource(img.img),
            contentDescription = "",
            modifier = Modifier
                .width(350.dp)
                .height(350.dp)
                .align(alignment = Alignment.Center)
        )

        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            IconButton(
                onClick = {
                    navController.navigate(Screen.Home.route)
                }
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBackIosNew,
                    contentDescription = "Back"
                )
            }

            IconButton(
                onClick = {
                    navController.navigate(Screen.Home.route)
                }
            ) {
                Icon(
                    imageVector = Icons.Default.IosShare,
                    contentDescription = "Share"
                )
            }
        }
    }
}