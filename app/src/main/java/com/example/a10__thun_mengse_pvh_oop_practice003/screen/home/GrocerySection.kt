package com.example.a10__thun_mengse_pvh_oop_practice003.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.a10__thun_mengse_pvh_oop_practice003.R
import com.example.a10__thun_mengse_pvh_oop_practice003.data.Groceries
import com.example.a10__thun_mengse_pvh_oop_practice003.ui.HomeActivity.exclusiveOfferItem

val groceryItems = listOf(
    Groceries(
        name = "Pulses",
        img = R.drawable.pulses
    ),
    Groceries(
        name = "Rice",
        img = R.drawable.rice
    )
)
@Composable
fun GroceriesSection(){
    LazyRow {
        items(groceryItems.size) {it ->
            GroceryRender(it)
        }
    }
}

@Composable
fun GroceryRender(index: Int){
    val groceries = groceryItems[index]
    var firstPaddingStart = 16.dp
    var lastPaddingEnd = 0.dp

    if (index == exclusiveOfferItem.size - 1){
        lastPaddingEnd = 16.dp
    }

    if (index == 0){
        firstPaddingStart = 0.dp
    }

    val bgColor = if (index == 0) 0xFFFCF0E3 else 0xFFE4F2E9

    Box(
        modifier = Modifier
            .padding(
                start = firstPaddingStart,
                end = lastPaddingEnd
            )
    ){
        Row (
            modifier = Modifier
                .clip(RoundedCornerShape(20.dp))
                .background(Color(bgColor))
                .width(300.dp)
                .height(140.dp)
                .padding(10.dp)
                .clickable{},
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
//                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ){
                Image(
                    painter = painterResource(groceries.img),
                    contentDescription = groceries.name,
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .size(110.dp)
                )
            }

            Spacer(modifier = Modifier.width(15.dp))

            Text(
                text = groceries.name,
                fontSize = 25.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}