package com.example.a10__thun_mengse_pvh_oop_practice003.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.a10__thun_mengse_pvh_oop_practice003.screen.home.HomeScreen
import com.example.a10__thun_mengse_pvh_oop_practice003.screen.splash.SplashScreen


fun NavGraphBuilder.rootNavGraph(
  navController: NavHostController
) {
    navigation(
        startDestination = Screen.Home.route,
        route = ROOT_GRAPH_ROUTE
    ) {

        composable (route = Screen.Home.route){
            HomeScreen(navController = navController)
        }
//        composable (route = Screen.RootScaffold.route){
//            RootScaffold(navController = navController)
//        }
    }


}

//composable (route = Screen.Splash.route){
//    SplashScreen(navController = navController)
//}