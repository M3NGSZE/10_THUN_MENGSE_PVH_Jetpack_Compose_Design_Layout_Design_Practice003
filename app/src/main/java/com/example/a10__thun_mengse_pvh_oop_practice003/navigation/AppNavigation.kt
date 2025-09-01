package com.example.a10__thun_mengse_pvh_oop_practice003.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.a10__thun_mengse_pvh_oop_practice003.component.NectarBottomBar
import com.example.a10__thun_mengse_pvh_oop_practice003.screen.splash.SplashScreen

@Composable
fun AppNavigation(navController: NavHostController = rememberNavController()){
//    Scaffold (
//        bottomBar = {
//            NectarBottomBar()
//        }
//    ) { innerPadding ->
//        NavHost(
//            modifier = Modifier.padding(paddingValues = innerPadding),
//            startDestination = ROOT_GRAPH_ROUTE,
//            navController = navController,
//        ){
//            rootNavGraph(navController = navController)
////            authNavGraph(navController = navController)
//        }
//
//    }

    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route,
    ){
        composable (route = Screen.Splash.route){
            SplashScreen(navController = navController)
        }
        composable (route = Screen.RootScaffold.route){
            RootScaffold(navController = navController)
        }
    }
}