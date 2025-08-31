package com.example.a10__thun_mengse_pvh_oop_practice003.ui.Activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material.icons.rounded.LocationOn
import androidx.compose.material.icons.rounded.PersonOutline
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material.icons.rounded.StoreMallDirectory
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.a10__thun_mengse_pvh_oop_practice003.R
import com.example.a10__thun_mengse_pvh_oop_practice003.data.BottomNavigation
import com.example.a10__thun_mengse_pvh_oop_practice003.ui.component.SearchField

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
        LazyColumn (
            modifier = Modifier
                .padding(paddingValues)
                .padding(25.dp)
        ) {
            item {
                NectarTopBar()
            }
        }
    }
}

//@Preview
@Composable
fun NectarTopBar(){
    Column (
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(
            painter = painterResource(id = R.drawable.orange_carrot),
            contentDescription = "Carrot Icon",
            modifier = Modifier.size(40.dp)
        )

        Spacer(modifier = Modifier.height(15.dp))

        Row (

            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            Icon(
                imageVector = Icons.Rounded.LocationOn,
                contentDescription = "Location Icon"
            )

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = "Dhaka, Banassre",
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium,
//                color = Color(0xFF919090),
            )
        }

        Spacer(modifier = Modifier.height(15.dp))

        SearchField()
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

//@Preview
@Composable
fun NectarBottomBar(){
    Surface (
        modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
    ) {
        NavigationBar {
            Row (
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.inverseOnSurface)
                    .padding(10.dp)
                    .clip(RoundedCornerShape(20.dp))
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
                            )
                        },
                        label = {
                            Text(
                                text = item.label,
                            )
                        },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Color(0xFF53B175),
                            selectedTextColor = Color(0xFF53B175),
                            indicatorColor = Color.Transparent
                        )
                    )
                }
            }
        }
    }
}