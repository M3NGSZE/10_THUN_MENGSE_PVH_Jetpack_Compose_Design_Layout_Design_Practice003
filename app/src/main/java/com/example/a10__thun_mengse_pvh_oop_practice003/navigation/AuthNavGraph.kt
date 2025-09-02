package com.example.a10__thun_mengse_pvh_oop_practice003.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.a10__thun_mengse_pvh_oop_practice003.screen.login.LoginScreen
import com.example.a10__thun_mengse_pvh_oop_practice003.screen.onboarding.OnboardingScreen
import com.example.a10__thun_mengse_pvh_oop_practice003.screen.signup.SignupScreen
import com.example.a10__thun_mengse_pvh_oop_practice003.screen.splash.SplashScreen

fun NavGraphBuilder.authNavGraph(
    navController: NavHostController
) {
    navigation(
        startDestination = Screen.Splash.route,
        route = AUTH_GRAPH_ROUTE
    ) {
        composable(route = Screen.Splash.route) {
            SplashScreen(navController = navController)
        }
        composable(route = Screen.Onboarding.route) {
            OnboardingScreen(navController = navController)
        }
        composable(route = Screen.Login.route) {
            LoginScreen(navController = navController)
        }
        composable(route = Screen.SignUp.route) {
            SignupScreen(navController = navController)
        }
    }

}