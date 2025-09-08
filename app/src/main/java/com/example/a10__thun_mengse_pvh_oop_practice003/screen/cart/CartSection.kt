package com.example.a10__thun_mengse_pvh_oop_practice003.screen.cart

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.a10__thun_mengse_pvh_oop_practice003.R
import com.example.a10__thun_mengse_pvh_oop_practice003.component.CartItem
import com.example.a10__thun_mengse_pvh_oop_practice003.component.SwipeToDeleteContainer
import com.example.a10__thun_mengse_pvh_oop_practice003.data.ProductMoreFields

@Composable
fun MyCartSection(navController: NavController){

    val cartItems= remember {
        mutableListOf(
            ProductMoreFields(
                id = 1,
                name = "Bell Pepper Red",
                des = "1kg, Priceg",
                price = 4.99,
                img = R.drawable.bell_pepper
            ),
            ProductMoreFields(
                id = 2,
                name = "Egg Chicken Red",
                des = "4pcs, Price",
                price = 1.99,
                img = R.drawable.egg_chicken
            ),
            ProductMoreFields(
                id = 3,
                name = "Organic Bananas",
                des = "7pcs, Priceg",
                price = 4.99,
                img = R.drawable.banana
            ),
            ProductMoreFields(
                id = 4,
                name = "Ginger",
                des = "250gm, Priceg",
                price = 4.99,
                img = R.drawable.ginger
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
    }

    LazyColumn (
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp)
    ){
        items(cartItems, key = {item -> item.id}){
//                it -> CartItem(it, navController, true)
            SwipeToDeleteContainer(it, onDelete = { cartItems -= it}) {
                    it -> CartItem(it, navController, true)
            }
        }
    }
}