package com.example.a10__thun_mengse_pvh_oop_practice003.screen.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Hevc
import androidx.compose.material.icons.filled.Tune
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.a10__thun_mengse_pvh_oop_practice003.component.SearchField

@Composable
fun SearchScreen(navController: NavController){
    Column {
        TopSearchApp(navController)
        EggSection(navController)
    }
}

@Composable
fun TopSearchApp(navController: NavController){
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Box(
            modifier = Modifier
                .fillMaxWidth(0.9f)
        ){
            SearchField(isTrailing = true, navController = navController)
        }
        Icon(
            imageVector = Icons.Default.Tune,
            contentDescription = "Back Arrow",
            modifier = Modifier.size(30.dp)
        )

    }
}