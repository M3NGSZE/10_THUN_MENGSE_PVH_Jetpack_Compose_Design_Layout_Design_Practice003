package com.example.a10__thun_mengse_pvh_oop_practice003.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController


@Composable
fun AppNavigation(navController: NavHostController){

    NavHost(
        navController = navController,
        startDestination = ROOT_GRAPH_ROUTE,
    ){
        rootNavGraph(navController = navController)

    }
}



//        composable (route = Screen.Splash.route){
//            SplashScreen(navController = navController)
//        }
//        composable (route = Screen.RootScaffold.route){
//            RootScaffold(navController = navController)
//        }

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