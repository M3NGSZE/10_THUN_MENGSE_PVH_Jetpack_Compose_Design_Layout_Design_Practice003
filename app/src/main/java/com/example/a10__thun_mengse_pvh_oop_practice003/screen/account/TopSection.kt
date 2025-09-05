package com.example.a10__thun_mengse_pvh_oop_practice003.screen.account

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.a10__thun_mengse_pvh_oop_practice003.R

@Composable
fun TopBarAcc(navController: NavController){
    Row (
        modifier = Modifier.fillMaxWidth()
            .padding(16.dp)
    ){
        Image(
            painter = painterResource(id = R.drawable.kout_thom),
            contentDescription = "kout thom",
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
                .border(1.dp, Color.Gray, CircleShape),
            contentScale = ContentScale.Crop

        )

        Spacer(modifier = Modifier.width(20.dp))

        Column {
            Row {
                Text(
                    text = "Lohan Golden Door",
                    fontSize = 21.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.width(10.dp))

                Icon(
                    imageVector = Icons.Rounded.Edit,
                    contentDescription = "edit profile",
                    modifier = Modifier
                        .size(20.dp),
                    tint = Color(0xFF53B074)
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "lohan.goldendoor369@gmail.com",
                color = Color.Gray
            )
        }
    }
}