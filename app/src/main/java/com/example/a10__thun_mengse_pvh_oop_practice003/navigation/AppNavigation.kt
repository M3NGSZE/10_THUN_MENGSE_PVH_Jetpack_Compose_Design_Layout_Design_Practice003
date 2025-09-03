package com.example.a10__thun_mengse_pvh_oop_practice003.navigation

import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.a10__thun_mengse_pvh_oop_practice003.component.BottomNavBar
import com.example.a10__thun_mengse_pvh_oop_practice003.component.NectarButton
import com.example.a10__thun_mengse_pvh_oop_practice003.screen.cart.CartScreen


@Composable
fun AppNavigation(navController: NavHostController){

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val bottomRoute = listOf(
        Screen.Home.route,
        Screen.Explore.route,
        Screen.Cart.route,
        Screen.Favorite.route,
        Screen.Account.route,
        Screen.Search.route,
    )

    Scaffold (
        bottomBar = {
            if (currentRoute in bottomRoute){
                BottomNavBar(navController = navController)
            }
        },
//        floatingActionButton = {
//            NectarButton("Go to Checkout", navController, "")
//        },
//        floatingActionButtonPosition = FabPosition.Center
    ) { innerPadding ->
        NavHost(
            modifier = Modifier.padding(paddingValues = innerPadding),
//            startDestination = ROOT_GRAPH_ROUTE,
            startDestination = AUTH_GRAPH_ROUTE,
            navController = navController,
        ) {
            authNavGraph(navController = navController)
            rootNavGraph(navController = navController)

//            composable(route = Screen.Cart.route) {
//                CartScreen(navController = navController)
//            }
        }
    }
}