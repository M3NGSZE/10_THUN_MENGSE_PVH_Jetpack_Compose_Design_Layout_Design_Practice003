package com.example.a10__thun_mengse_pvh_oop_practice003.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.example.a10__thun_mengse_pvh_oop_practice003.screen.account.AccountScreen
import com.example.a10__thun_mengse_pvh_oop_practice003.screen.cart.CartScreen
import com.example.a10__thun_mengse_pvh_oop_practice003.screen.detailProduct.DetailProductScreen
import com.example.a10__thun_mengse_pvh_oop_practice003.screen.explore.ExploreScreen
import com.example.a10__thun_mengse_pvh_oop_practice003.screen.exploreProduct.BeverageScreen
import com.example.a10__thun_mengse_pvh_oop_practice003.screen.favorite.FavoriteScreen
import com.example.a10__thun_mengse_pvh_oop_practice003.screen.home.HomeScreen
import com.example.a10__thun_mengse_pvh_oop_practice003.screen.orderAccept.OrderAcceptScreen
import com.example.a10__thun_mengse_pvh_oop_practice003.screen.search.SearchScreen
import com.example.a10__thun_mengse_pvh_oop_practice003.screen.splash.SplashScreen




fun NavGraphBuilder.rootNavGraph(
  navController: NavHostController
) {
    navigation(
        startDestination = Screen.Detail.route,
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

        composable (route = Screen.Beverage.route){
            BeverageScreen(navController = navController)
        }

        composable (route = Screen.Search.route){
            SearchScreen(navController = navController)
        }

        composable (
            route = Screen.Detail.route,
            arguments = listOf(navArgument(name = "productId"){
                type = NavType.StringType
//                defaultValue = ""
            })
        ){backStackEntry ->
            val productId = backStackEntry.arguments?.getString("productId")
            DetailProductScreen(navController = navController, productId = productId)
        }

        composable (route = Screen.Accept.route){
            OrderAcceptScreen(navController = navController)
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