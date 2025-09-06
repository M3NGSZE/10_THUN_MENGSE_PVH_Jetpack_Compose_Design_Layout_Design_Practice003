package com.example.a10__thun_mengse_pvh_oop_practice003.screen.favorite

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavController
import com.example.a10__thun_mengse_pvh_oop_practice003.component.CartItem
import com.example.a10__thun_mengse_pvh_oop_practice003.component.NectarButton
import com.example.a10__thun_mengse_pvh_oop_practice003.component.TopbarGeneral
import com.example.a10__thun_mengse_pvh_oop_practice003.screen.exploreProduct.beverageItems

@Composable
fun FavoriteScreen(navController: NavController){
    Column {
        TopbarGeneral("Favorite")
        ConstraintButton(navController)
    }
}

@Composable
fun ConstraintButton(navController: NavController){
    ConstraintLayout (
        modifier = Modifier
            .fillMaxSize()
    ){
        val (cart, button) = createRefs()

        Column (
            modifier = Modifier.constrainAs(cart) {
                top.linkTo(parent.top)
            }
        ){
            FavoriteSection(navController)
        }

        Column (
            modifier = Modifier.constrainAs(button) {
                bottom.linkTo(parent.bottom, margin = 24.dp) // <--- key change
                start.linkTo(parent.start, margin = 18.dp)
                end.linkTo(parent.end, margin = 18.dp)
                width = Dimension.fillToConstraints
            }
        ){
            NectarButton("Add All To Cart", navController, "",)
        }
    }
}

@Composable
fun FavoriteSection(navController: NavController){
    LazyColumn (
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp)
    ){
        items(beverageItems, key = { item -> item.id}){
                it -> CartItem(it, navController, false)
        }
    }
}