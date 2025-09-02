package com.example.a10__thun_mengse_pvh_oop_practice003.component

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material.icons.rounded.PersonOutline
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material.icons.rounded.StoreMallDirectory
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.a10__thun_mengse_pvh_oop_practice003.data.BottomNavigation
import com.example.a10__thun_mengse_pvh_oop_practice003.navigation.Screen

//@Preview
@Composable
fun BottomNavBar(navController: NavController) {

    // access current route
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route


//    var selectedItem by remember { mutableStateOf(Screen.Home.route) }

    val selectedTabs = listOf(
        remember { mutableStateOf(Screen.Home.route) },
        remember { mutableStateOf(Screen.Explore.route) },
        remember { mutableStateOf(Screen.Cart.route) },
        remember { mutableStateOf(Screen.Favorite.route) },
        remember { mutableStateOf(Screen.Account.route) }
    )

    Log.d("currentRoute","${currentRoute}")

    fun onNavigate(route: String) {
//        selectedItem = route
        navController.navigate(route)
    }

    Surface(
        modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
    ) {
        NavigationBar {
            Row(
                modifier = Modifier
                    .background(Color(0xFFFDFDFD))
                    .padding(10.dp)
//                    .clip(RoundedCornerShape(20.dp))
            ) {
                bottomBarItems.forEachIndexed { index, item ->
                    NavigationBarItem(

                        // access route
//                         selected = selectedItem.startsWith(Screen.Home.route.substringBefore("/")),

                        selected = currentRoute == selectedTabs[index].value,

                        onClick = {
//                            Log.d("currentRoute","${selectedTabs[index].value}")
                            onNavigate(selectedTabs[index].value)
                        },

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