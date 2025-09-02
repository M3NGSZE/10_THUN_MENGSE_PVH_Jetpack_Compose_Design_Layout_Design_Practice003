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
import com.example.a10__thun_mengse_pvh_oop_practice003.component.NectarBottomBar
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

        composable(Screen.Home.route) {
            Scaffold(
                bottomBar = { NectarBottomBar() },
                modifier = Modifier.systemBarsPadding(),
                containerColor = Color.Blue
            ) {
                HomeScreen(
                    navController = navController,
                )
            }
        }
    }
}