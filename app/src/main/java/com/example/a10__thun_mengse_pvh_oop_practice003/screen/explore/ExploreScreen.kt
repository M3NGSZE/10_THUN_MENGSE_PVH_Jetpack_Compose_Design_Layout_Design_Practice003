@file:OptIn(ExperimentalFoundationApi::class)

package com.example.a10__thun_mengse_pvh_oop_practice003.screen.explore

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.a10__thun_mengse_pvh_oop_practice003.component.SearchField

@Composable
fun ExploreScreen(navController: NavController){
    Column {
        HeaderSticky()
        GridProduct()
    }
}

@Composable
fun HeaderSticky(){
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

        SearchField()
    }
}


//items(findProductsItems.size){it ->
//    FindProductsItems(it)
//}