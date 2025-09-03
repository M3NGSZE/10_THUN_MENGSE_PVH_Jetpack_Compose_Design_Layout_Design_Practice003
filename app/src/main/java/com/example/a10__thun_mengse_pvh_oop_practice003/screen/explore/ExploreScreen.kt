@file:OptIn(ExperimentalFoundationApi::class)

package com.example.a10__thun_mengse_pvh_oop_practice003.screen.explore

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.a10__thun_mengse_pvh_oop_practice003.component.SearchField
import com.example.a10__thun_mengse_pvh_oop_practice003.navigation.Screen

@Composable
fun ExploreScreen(navController: NavController){
    Column {
        HeaderSticky(navController = navController)
        GridProduct(navController)
    }
}

@Composable
fun HeaderSticky(navController: NavController){
    Column (
        modifier = Modifier.fillMaxWidth().padding(start = 16.dp, end = 16.dp)
    ){
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ){
            Text(
                text = "Find Products",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
            )
        }

        Spacer(modifier = Modifier.height(15.dp))

        SearchField(navController = navController, screenName = Screen.Search.route)
    }
}


//items(findProductsItems.size){it ->
//    FindProductsItems(it)
//}