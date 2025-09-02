package com.example.a10__thun_mengse_pvh_oop_practice003.navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.a10__thun_mengse_pvh_oop_practice003.screen.account.AccountScreen
import com.example.a10__thun_mengse_pvh_oop_practice003.screen.cart.CartScreen
import com.example.a10__thun_mengse_pvh_oop_practice003.screen.explore.ExploreScreen
import com.example.a10__thun_mengse_pvh_oop_practice003.screen.favorite.FavoriteScreen
import com.example.a10__thun_mengse_pvh_oop_practice003.screen.home.HomeScreen
import com.example.a10__thun_mengse_pvh_oop_practice003.screen.splash.SplashScreen



@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
fun NavGraphBuilder.rootNavGraph(
  navController: NavHostController
) {
    navigation(
        startDestination = Screen.Splash.route,
        route = ROOT_GRAPH_ROUTE
    ) {
        composable(route = Screen.Splash.route) {
            SplashScreen(navController = navController)
        }

        composable(route = Screen.Home.route) {
            HomeScreen(navController = navController)
        }

        composable(route = Screen.Explore.route) {
            ExploreScreen(navController = navController)
        }

        composable(route = Screen.Cart.route) {
            CartScreen(navController = navController)
        }

        composable(route = Screen.Favorite.route) {
            FavoriteScreen(navController = navController)
        }

        composable(route = Screen.Account.route) {
            AccountScreen(navController = navController)
        }

    }
}

//        composable(Screen.Home.route) {
//            Scaffold(
//                bottomBar = { NectarBottomBar(navController = navController) },
//                modifier = Modifier.systemBarsPadding(),
//            ) {
//                HomeScreen(
//                    navController = navController,
//                )
//                ExploreScreen(navController = navController)
//            }
//        }