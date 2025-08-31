package com.example.a10__thun_mengse_pvh_oop_practice003.ui.Activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material.icons.rounded.PersonOutline
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material.icons.rounded.StoreMallDirectory
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.a10__thun_mengse_pvh_oop_practice003.data.BottomNavigation

class HomeActivity : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Home()
        }
    }
}

@Composable
fun Home(){
    Scaffold (
        bottomBar = {
            NectarBottomBar()
        }
    ) { paddingValues ->
        Column (
            modifier = Modifier
                .padding(paddingValues)
        ) {
            Text("Home Screen")
        }
    }
}

val bottomBarItems = listOf(
    BottomNavigation(
        label = "Shop",
        icon = Icons.Rounded.StoreMallDirectory
    ),
    BottomNavigation(
        label = "Explore",
        icon = Icons.Rounded.Search
    ),
    BottomNavigation(
        label = "Cart",
        icon = Icons.Rounded.ShoppingCart
    ),
    BottomNavigation(
        label = "Favorite",
        icon = Icons.Rounded.FavoriteBorder
    ),
    BottomNavigation(
        label = "Account",
        icon = Icons.Rounded.PersonOutline
    )
)

@Composable
fun NectarBottomBar(){
    Surface (
        modifier = Modifier
            .clip(RoundedCornerShape(15.dp))
            .background(Color.Red),
//        color = MaterialTheme.colorScheme.background
    ) {
        NavigationBar {
            Row (
                modifier = Modifier.background(MaterialTheme.colorScheme.inverseOnSurface)
            ){
                bottomBarItems.forEachIndexed {
                        index, item ->
                    NavigationBarItem(
                        selected = index == 0,
                        onClick = {},
                        icon = {
                            Icon(
                                imageVector = item.icon,
                                contentDescription = item.label,
                                tint = MaterialTheme.colorScheme.onBackground
                            )
                        },
                        label = {
                            Text(
                                text = item.label,
                                color = MaterialTheme.colorScheme.onBackground
                            )
                        }
                    )
                }
            }
        }
    }
//    NavigationBar {
//        Row (
//            modifier = Modifier.background(MaterialTheme.colorScheme.inverseOnSurface)
//        ){
//            bottomBarItems.forEachIndexed {
//                index, item ->
//                NavigationBarItem(
//                    selected = index == 0,
//                    onClick = {},
//                    icon = {
//                        Icon(
//                            imageVector = item.icon,
//                            contentDescription = item.label,
//                            tint = MaterialTheme.colorScheme.onBackground
//                        )
//                    },
//                    label = {
//                        Text(
//                            text = item.label,
//                            color = MaterialTheme.colorScheme.onBackground
//                        )
//                    }
//                )
//            }
//        }
//    }
}