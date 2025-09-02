package com.example.a10__thun_mengse_pvh_oop_practice003.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.LocationOn
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.a10__thun_mengse_pvh_oop_practice003.R

@Composable
fun NectarTopBar() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.orange_carrot),
            contentDescription = "Carrot Icon",
            modifier = Modifier.size(40.dp)
        )

        Spacer(modifier = Modifier.height(15.dp))

        Row(

            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Rounded.LocationOn,
                contentDescription = "Location Icon"
            )

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = "Dhaka, Banassre",
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium,
//                color = Color(0xFF919090),
            )
        }


    }
}