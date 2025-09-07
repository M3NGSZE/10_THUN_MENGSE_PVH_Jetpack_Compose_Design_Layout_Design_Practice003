@file:OptIn(ExperimentalFoundationApi::class)

package com.example.a10__thun_mengse_pvh_oop_practice003.screen.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.a10__thun_mengse_pvh_oop_practice003.R
import com.example.a10__thun_mengse_pvh_oop_practice003.component.RowSection
import com.example.a10__thun_mengse_pvh_oop_practice003.component.SearchField

@Composable
fun HomeScreen(navController: NavController) {
    LazyColumn{
        stickyHeader {
            TopHomeSection(navController = navController)
        }
        item {
            HomeBanner()

            RowSection(sectionName = "Exclusive Offers", seeAll = "See All")

            ProductSection(navController)

            RowSection(sectionName = "Best Selling", seeAll = "See All")

            ProductSection(navController)

            RowSection(sectionName = "Groceries", seeAll = "See All")

            GroceriesSection()

            Spacer(modifier = Modifier.height(20.dp))

            ProductSection(navController)
        }
    }
}

@Composable
fun TopHomeSection(navController: NavController){
    Column (
        modifier = Modifier
            .background(Color(0xFFFCF5FD))
            .fillMaxSize()

    ){
        Column (
            modifier = Modifier
            .padding(start = 16.dp, end = 16.dp)
        ){
            NectarTopBar()

            Spacer(modifier = Modifier.height(15.dp))

            SearchField(navController = navController, screenName = "")

            Spacer(modifier = Modifier.height(20.dp))
        }

    }
}

@Composable
fun HomeBanner(){
    Box(
        modifier = Modifier
            .fillMaxWidth()      // make Box fill the screen width
            .height(130.dp)
            .clip(RoundedCornerShape(15.dp))
            .padding(start = 16.dp, end = 16.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.banner),
            contentDescription = "Banner img",
            modifier = Modifier
                .fillMaxWidth()   // make Image fill the Box width
                .fillMaxHeight(), // optional: match Box height
            contentScale = ContentScale.Crop // scales image to fill width nicely
        )
    }
}