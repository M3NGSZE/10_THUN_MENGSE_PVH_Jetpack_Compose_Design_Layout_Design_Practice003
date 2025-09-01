package com.example.a10__thun_mengse_pvh_oop_practice003.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.a10__thun_mengse_pvh_oop_practice003.screen.login.LoginScreen
import com.example.a10__thun_mengse_pvh_oop_practice003.screen.signup.SignupScreen

fun NavGraphBuilder.authNavGraph(
    navController: NavHostController
) {
    navigation(
        startDestination = Screen.Splash.route,
        route = AUTH_GRAPH_ROUTE
    ) {
        composable(route = Screen.SignUp.route) {
            SignupScreen(navController = navController)

        }
        composable(route = Screen.Login.route) {
            LoginScreen(navController = navController)
        }
        composable(route = Screen.SignUp.route) {
            SignupScreen(navController = navController)

        }
    }

}