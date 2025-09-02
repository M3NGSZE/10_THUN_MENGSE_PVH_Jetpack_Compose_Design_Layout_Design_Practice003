package com.example.a10__thun_mengse_pvh_oop_practice003.screen.favorite

import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun FavoriteScreen(navController: NavController){
    LazyColumn (
        modifier = Modifier.systemBarsPadding()
    ) {
        item{
            Text("Explore screen")
        }
    }
}