package com.example.a10__thun_mengse_pvh_oop_practice003.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.a10__thun_mengse_pvh_oop_practice003.component.NectarBottomBar
import com.example.a10__thun_mengse_pvh_oop_practice003.navigation.rootNavGraph
import com.example.a10__thun_mengse_pvh_oop_practice003.screen.home.HomeScreen
import com.example.a10__thun_mengse_pvh_oop_practice003.screen.splash.SplashScreen

//@Composable
//fun RootScaffold(navController: NavHostController) {
//    Scaffold(
//        bottomBar = {
//            NectarBottomBar()
//        }
//    ) { innerPadding ->
//        NavHost(
//            modifier = Modifier.padding(paddingValues = innerPadding),
//            startDestination = Screen.Splash.route,
//            navController = navController,
//        ) {
//            composable(Screen.Splash.route) { SplashScreen(navController) }
//            composable(route = Screen.Home.route) {
//                HomeScreen(navController = navController)
//            }
//        }
//
//    }
//
//}

//            rootNavGraph(navController = navController)
//            authNavGraph(navController = navController)