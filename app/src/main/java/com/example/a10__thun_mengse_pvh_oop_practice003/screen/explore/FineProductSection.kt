package com.example.a10__thun_mengse_pvh_oop_practice003.screen.explore

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import com.example.a10__thun_mengse_pvh_oop_practice003.data.FindProduct
import com.example.a10__thun_mengse_pvh_oop_practice003.navigation.Screen

val findProductsItems = listOf(
    FindProduct(
        id = 1,
        name = "Fresh Fruit & Vegetable",
        img = R.drawable.fresh_fruit_vegetable
    ),
    FindProduct(
        id = 2,
        name = "Cooking Oil & Ghee",
        img = R.drawable.cooking_oil_ghee
    ),
    FindProduct(
        id = 3,
        name = "Meat & Fish",
        img = R.drawable.meat_fish
    ),
    FindProduct(
        id = 4,
        name = "Bakery & Snacks",
        img = R.drawable.bakery_snacks
    ),
    FindProduct(
        id = 5,
        name = "Dairy & Egg",
        img = R.drawable.dairy_eggs
    ),
    FindProduct(
        id = 6,
        name = "Beverages",
        img = R.drawable.beverages
    ),
    FindProduct(
        id = 7,
        name = "Dairy & Egg",
        img = R.drawable.dairy_eggs
    ),
    FindProduct(
        id = 8,
        name = "Beverages",
        img = R.drawable.beverages
    )
)

@Composable
fun GridProduct(navController: NavController){
    LazyVerticalGrid (
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 10.dp, end = 10.dp,)
    ) {
        items(findProductsItems, key = {item -> item.id}){
                it -> FindProductsItems(it, navController)
        }
    }
}

@Composable
fun FindProductsItems(item: FindProduct, navController: NavController){
//    var item = findProductsItems[index]
//    val navController: NavController
    Card (
        modifier = Modifier
            .padding(start = 10.dp, top = 16.dp, end = 10.dp,)
            .fillMaxWidth()
            .height(220.dp)
            .clickable {
                Log.d("screenName","${Screen.Beverage.route}")
                navController.navigate(route = Screen.Beverage.route)
            },
        elevation = CardDefaults.cardElevation(8.dp),
//        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ){
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
//            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ){
                Image(
                    painter = painterResource(item.img),
                    contentDescription = item.name,
                    modifier = Modifier.size(125.dp)
                )
            }

            Text(
                modifier = Modifier.padding(top = 5.dp),
                text = item.name,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                textAlign = TextAlign.Center
            )
        }
    }


}