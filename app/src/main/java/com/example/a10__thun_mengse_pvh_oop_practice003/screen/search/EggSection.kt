package com.example.a10__thun_mengse_pvh_oop_practice003.screen.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
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
import androidx.navigation.NavController
import com.example.a10__thun_mengse_pvh_oop_practice003.R
import com.example.a10__thun_mengse_pvh_oop_practice003.data.ProductMoreFields
import com.example.a10__thun_mengse_pvh_oop_practice003.screen.explore.exploreProduct.beverageItems

val eggItems = listOf(
    ProductMoreFields(
        id = 1,
        name = "Egg Chicken Red",
        des = "4pcs, Price",
        price = 1.99,
        img = R.drawable.egg_chicken
    ),
    ProductMoreFields(
        id = 2,
        name = "Egg Chicken White",
        des = "180g, Price",
        price = 1.50,
        img = R.drawable.egg_white
    ),
    ProductMoreFields(
        id = 3,
        name = "Egg Pasta",
        des = "30g, Price",
        price = 15.99,
        img = R.drawable.egg_pasta
    ),
    ProductMoreFields(
        id = 4,
        name = "Egg Noodles",
        des = "2L, Price",
        price = 15.99,
        img = R.drawable.egg_noodle
    ),
    ProductMoreFields(
        id = 5,
        name = "Mayonnaise Eggless",
        des = "325ml, Price",
        price = 4.99,
        img = R.drawable.maynonnias_egg
    ),
    ProductMoreFields(
        id = 6,
        name = "Egg Noodles",
        des = "350ml, Price",
        price = 4.99,
        img = R.drawable.egg_noodle_purple
    ),
    ProductMoreFields(
        id = 7,
        name = "Diet Coke",
        des = "355ml, Price",
        price = 1.99,
        img = R.drawable.diet_coke
    ),
    ProductMoreFields(
        id = 8,
        name = "Sprite Can",
        des = "325ml, Price",
        price = 1.50,
        img = R.drawable.sprike_can
    ),
)

@Composable
fun EggSection(navController: NavController){
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 10.dp, end = 10.dp,)
    ) {
        items(eggItems, key = {item -> item.id}){
                it -> EggItem(it, navController)
        }
    }
}

@Composable
fun EggItem(item: ProductMoreFields, navController: NavController){
    Card (
        modifier = Modifier
            .padding(start = 10.dp, end = 10.dp, top = 16.dp)
            .height(320.dp)
            .fillMaxWidth()
            .clickable {

            },
        elevation = CardDefaults.cardElevation(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ){
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ){
                Image(
                    painter = painterResource(item.img),
                    contentDescription = item.name,
                    modifier = Modifier.size(120.dp)
                )
            }

            Spacer(modifier = Modifier.height(15.dp))

            Text(
                text = item.name,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
//                maxLines = 1
            )

            Spacer(modifier = Modifier.height(5.dp))

            Text(
                text = item.des,
                fontSize = 15.sp,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(15.dp))

            Row (
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    text = "$ ${item.price}",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                )

                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(20.dp))
                        .background(Color(0xFF53B175))
                        .size(50.dp)
                        .clickable {},
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Rounded.Add,
                        contentDescription = "Add icon",
                        tint = Color.White
                    )
                }
            }
        }
    }
}