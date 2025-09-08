package com.example.a10__thun_mengse_pvh_oop_practice003.screen.detailProduct

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material.icons.rounded.KeyboardArrowUp
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.a10__thun_mengse_pvh_oop_practice003.component.NectarButton
import com.example.a10__thun_mengse_pvh_oop_practice003.data.ProductMoreFields

@Composable
fun DetailProductSection(item: ProductMoreFields?, navController: NavController){

    var isFavorite by remember { mutableStateOf(false) }
    var amountItems by remember { mutableIntStateOf(1) }

//    var isShowIcon = Icons.Rounded.KeyboardArrowDown
//    var isShow = false

    var isShowIcon by remember { mutableStateOf(Icons.Rounded.KeyboardArrowUp) }
    var isShow by remember { mutableStateOf(true) }

    // contain title product, favorite, amount and price
    Column (
        modifier = Modifier
            .padding(16.dp)
    ){

        // product name and favorite section

        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = item?.name!!,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )

            IconButton(
                onClick = {
                    isFavorite = !isFavorite
                }
            ) {
                if (isFavorite){
                    Icon(
                        imageVector = Icons.Default.Favorite,
                        contentDescription = "Favorite",
                        tint = Color.Red
                    )
                } else{
                    Icon(
                        imageVector = Icons.Default.FavoriteBorder,
                        contentDescription = "Favorite",
                        tint = Color.Gray
                    )
                }
            }
        }

        Text(
            text = item?.des!!,
            color = Color.Gray,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium
        )

        // increase amount and price section

        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 36.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Row (
                modifier = Modifier.width(150.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                IconButton(
                    onClick = {
                        amountItems = if(amountItems == 1) 1 else  amountItems - 1
                    },
                ) {
                    Icon(
                        imageVector = Icons.Default.Remove,
                        contentDescription = "Close",
                        tint = Color(0xFFB2B2B2),
                        modifier = Modifier.size(30.dp)
                    )
                }

                Box (
                    modifier = Modifier
                        .size(45.dp)
                        .border(
                            width = 1.dp,
                            color = Color.Gray,
                            shape = RoundedCornerShape(16.dp)
                        ),
                    contentAlignment = Alignment.Center
                ){
                    Text(
                        text = "$amountItems",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                }


                IconButton(
                    onClick = {
                        amountItems += 1
                    },
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Close",
                        tint = Color(0xFF53B074),
                        modifier = Modifier.size(30.dp),
                    )
                }
            }

            Text(
                text = "$ ${((item.price * amountItems) * 100).toInt() / 100.00}",
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp
            )
        }
    }

    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ){
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .drawBehind {
                    val strokeWidth = 0.3.dp.toPx()
                    drawLine(
                        color = Color.Gray,
                        start = Offset(0f, 0f),
                        end = Offset(size.width, 0f),
                        strokeWidth = strokeWidth
                    )
                }
                .padding(top = 6.dp)
            ,
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = "Product detail",
                fontSize = 21.sp,
                fontWeight = FontWeight.Medium
            )

            IconButton(
                onClick = {
                    isShow = !isShow
                    isShowIcon = if (isShow) Icons.Rounded.KeyboardArrowDown else Icons.Rounded.KeyboardArrowUp
                }
            ) {
                Icon(
                    imageVector = isShowIcon,
                    contentDescription = "Arrow Icon",
                    modifier = Modifier.size(30.dp)
                )
            }
        }

        if (isShow){
            Text(
                text = "Apples are nutritious. Apples may be good for weight loss. " +
                        "Apple may be good for your heart. As part of a healful and varied diet",
                color = Color.Gray,
                fontSize = 17.sp,
                lineHeight = 25.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
        }

        Spacer(modifier = Modifier.height(19.dp))

        Row (
            modifier = Modifier
                .fillMaxWidth()
                .drawBehind {
                    val strokeWidth = 0.3.dp.toPx()
                    drawLine(
                        color = Color.Gray,
                        start = Offset(0f, 0f),
                        end = Offset(size.width, 0f),
                        strokeWidth = strokeWidth
                    )
                }
                .padding(top = 16.dp)
            ,
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = "Nutrition",
                fontSize = 23.sp,
                fontWeight = FontWeight.Medium,
            )

            Text(
                text = "100gr",
                color = Color.Gray,
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color(0xFFEAEAEA))
                    .padding(8.dp)

            )
        }

        Spacer(modifier = Modifier.height(23.dp))

        Row (
            modifier = Modifier
                .fillMaxWidth()
                .drawBehind {
                    val strokeWidth = 0.3.dp.toPx()
                    drawLine(
                        color = Color.Gray,
                        start = Offset(0f, 0f),
                        end = Offset(size.width, 0f),
                        strokeWidth = strokeWidth
                    )
                }
                .padding(top = 19.dp)
            ,
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = "Review",
                fontSize = 23.sp,
                fontWeight = FontWeight.Medium,
            )

            Row {
                for (i in 1..5){
                    Icon(
                        Icons.Rounded.Star,
                        contentDescription = "Stars",
                        tint = Color(0xFFF1603F)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(23.dp))


    }
}